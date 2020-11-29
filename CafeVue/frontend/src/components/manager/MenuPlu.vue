<template>
  <div class="basmargin">
    <div>
        <div>
          <v-row>
            <p id="menuName">메뉴 이름</p><input type="text" v-model="name" class="block" id="menuNanp"/>
            <p id="menuPrice">가격</p><input type="number" v-model="pr" class="block" id="menuPrnp"/>
          </v-row>
        </div>
        <file-pond
          name="bin"
          ref="pond"
          allow-multiple="false"
          max-files="1"
          accepted-file-types="image/*"
          :server="server"
        />
        <div id="MenuSiz">
          <h2>싸이즈</h2>
          <v-row>
            <p class="pteg1">Tall</p><v-checkbox v-model="ta" value="Tall"/>
            <p class="pteg1">Grande</p><v-checkbox v-model="gr" value="Grande"/>
            <p class="pteg1">Venti</p><v-checkbox v-model="va" value="Venti"/>
            <v-btn @click="filepath(name, pr, ta, gr, va)" id="btn1">확인</v-btn>
          </v-row>
        </div>
    </div>
    <div class="MenuPM">
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
      name: '',
      pr:'',
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
    if (this.idSt != "null" && this.adSt != "null") {
      console.log("echo")
      // const place = this.adSt
      const place = "커피빈 종각역점"
      await axios.post('http://localhost:1234/menu/show', {place})
          .then(res => {
            console.log(res.data)
            this.menulist = res.data
          })
    }
    else {
      router.push("/")
    }
  }
}
</script>

<style>
.text-center{
  text-align: center;
}
.MenuPM {
  height: 50%;
}
#MenuSiz {
  margin-left: 10px;
  width: 400px;
}
#fileget {
  margin-top: 20px;
}
#btn1 {
  margin-left: 15px;
  margin-top: 15px;
}
.pteg1 {
  margin-top: 25px;
  margin-right: 10px;
  margin-left: 30px;
}
#menuName {
  margin-left: 30px;
  margin-right: 10px;
  font-size: 30px;
}
#menuPrice {
  margin-left: 30px;
  margin-right: 10px;
  font-size: 30px;
}
#menuNanp {
  width: 300px;
  height: 30px;
  margin-top: 10px;
}
#menuPrnp {
  width: 300px;
  height: 30px;
  margin-top: 10px;
}
</style>
