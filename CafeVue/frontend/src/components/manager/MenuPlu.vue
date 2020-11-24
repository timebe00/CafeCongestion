<template>
  <div class="basmargin">
    <v-col>
      <v-row>
        <p></p>
        <p>메뉴 이름</p><input type="text" v-model="name" class="block"/>
        <p>가격</p><input type="text" v-model="pr" class="block"/>
      </v-row>
        <file-pond
            name="bin"
            ref="pond"
            allow-multiple="false"
            max-files="1"
            accepted-file-types="image/*"
            :server="server"
        />
      <v-row>
        Tall<v-checkbox v-model="ta" value="Tall" class="mr">Tall</v-checkbox>
        Grande<v-checkbox v-model="gr" value="Grande"/>
        Venti<v-checkbox v-model="va" value="Venti"/>
      </v-row>
      <v-btn @click="filepath(name, pr, ta, gr, va)">확인</v-btn>
    </v-col>
    <v-data-table
      :headers="headers"
      :items="menulist"
      align="center"
    >
      <template v-slot:item.size="{ item }">
        <span v-if="item.ta != 'null'">{{ item.ta }}   </span>
        <span v-if="item.gr != 'null'">{{ item.gr }}   </span>
        <span v-if="item.va != 'null'">{{ item.va }}</span>
      </template>
      <template v-slot:item.tru="{ item }">
        <v-icon @click="dle(item.menuNo)">mdi-delete</v-icon>
      </template>
    </v-data-table>
  </div>
</template>

<script>
import router from "@/router";
import axios from "axios";
import vueFilePond from 'vue-filepond'
import 'filepond/dist/filepond.min.css'
import FilePondPluginFileValidateType from 'filepond-plugin-file-validate-type'
import {mapState} from 'vuex'

const FilePond = vueFilePond(FilePondPluginFileValidateType)
export default {
  name: "MenuPlu",
  components: {
    FilePond
  },
  computed: {
    ...mapState(['idSt']),
    ...mapState(['adSt']),
    headers () {
      return [
        {
          text: '메뉴 이름',
          align: 'center',
          sortable: false,
          width: '35%',
          value: 'name'
        },
        {
          text: '가격',
          align: 'center',
          sortable: false,
          width: '25%',
          value: 'pr'
        },
        {
          text: 'SIZE',
          align: 'center',
          sortable: false,
          width: '25%',
          value: 'size'
        },
        {
          text: '삭제',
          align: 'center',
          sortable: false,
          width: '15%',
          value: 'tru'
        }
      ]
    }
  },
  data () {
    return {
      menulist: [],
      ta: '',
      va: '',
      gr: '',
      server: {
        url: 'http://localhost:1234/menu',
        process: {
          url: '/file',
          method: 'POST'
        },
        revert: {
          url: '/fileremove',
          method: 'POST'
        }
      }
    }
  },
  methods: {
    dle (menuNo) {



      console.log("menuNo : " + menuNo)
      axios.post('http://localhost:1234/menu/remove', {menuNo})
        .then(router.push("/menu/voidpage"))
    },
    filepath (name, pr, ta, gr, va) {
      const file = this.$refs.pond.getFile()
      let imgN = file.filename
      console.log("imgn : " + imgN)
      let place = this.adSt
      this.$emit('menuset', {gr, imgN, name, place, pr, ta, va})
    }
  },
  async mounted() {
    if (this.idSt == "null" && this.adSt == "null") {
      router.push("/")
    } else {
      console.log("echo")
      // const place = this.adSt
      const place = "커피빈 종각역점"
      await axios.post('http://localhost:1234/menu/show', {place})
          .then(res => {
            console.log(res.data)
            this.menulist = res.data
          })
    }
  }
}
</script>

<style>
.text-center{
  text-align: center;
}
</style>
