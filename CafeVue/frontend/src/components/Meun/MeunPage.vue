<template>
  <div id="card" class="basmargin">
    <ul class="HO">
      <ol
           v-for="i in item"
           :key="i.key">
        {{ i.name }}<br>
        {{ i.size }}
        <v-btn v-on:click="removeitem(i.key)">취소</v-btn>
      </ol>
    </ul>
    <v-btn v-on:click="Order()" class="HO" id="orderokbtn">주문하기</v-btn>
    <div id="MU">
      <v-row>
          <v-card
              id="menucard"
            class="mx-auto"
            max-width="344"
            v-for="(item, idx) in menu"
            :key="item.menuNo"
          >
          <div id="menuimge">
            <v-img :src="require(`@/assets/CafeMenu/`+item.imgN)" id="menuimg"></v-img>
          </div>
<!--          <v-img src="@/assets/CafeMenu/아메리카노.jpg" height="200px"></v-img>-->
          <v-card-title>{{ item.name }}</v-card-title>
          <v-card-subtitle>{{ item.pr }}</v-card-subtitle>
          <v-card-actions>
            <v-btn
                color="orange lighten-2"
                text
            >
              선택하기
            </v-btn>

          </v-card-actions>
            <v-divider></v-divider>

            <v-card-actions>
              Size :
              <v-checkbox v-model="size[idx]" value="Venti" v-if="item.va === 'Venti'"/>
              <p v-if="item.va==='Venti'">Venti</p>
              <v-checkbox v-model="size[idx]" value="Grande" v-if="item.gr === 'Grande'"/>
              <p v-if="item.gr=== 'Grande'">Grande</p>
              <v-checkbox v-model="size[idx]" value="Tall" v-if="item.ta === 'Tall'"/>
              <p v-if="item.ta==='Tall'">Tall</p>
              <v-btn v-on:click="PushCof(item.name, size[idx], idx, idSt, placeSW)">확인</v-btn>
            </v-card-actions>
        </v-card>
      </v-row>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import {mapState} from 'vuex'

export default {
  name: "MeunPage",
  data: () => ({
    menu: [],
    size: [],
    item: [],
    k: 0,
    TF: true,
    dialog3: false,
    imgN: []
  }),
  computed: {
    ...mapState(["idSt"])
  },
  methods: {
    PushCof(na, si, idx, id, place) {
      if(this.k === null || na === null || si === '') {
        console.log("ID : " + id)
      }
      else {
        this.item.push({key: this.k, name: na, size: si, id: id, place: place})
        this.k++
        this.size[idx] = ''
      }
    },
    removeitem (key) {
      const targetIndex = this.item.findIndex(v => v.key === key)
      this.item.splice(targetIndex, 1)
    },
    Order() {
      console.log("Order")
      const order = this.item
      console.log(this.item)
      if(this.item.length != 0) {
        axios.post('http://localhost:1234/orderby/create', {order})
            .then(res => {
              console.log(res)
            })
            .catch(err => {
              console.log(err)
            })
        this.item.splice(0)
      }
    }
  },
  props: {
    placeSW: String
  },
  async mounted() {
    let place = this.placeSW
    console.log(place)
    await axios.post('http://localhost:1234/menu/show', {place})
      .then(res => {
        console.log("성공")
        console.log(res.data.length)
        console.log(res.data)
        for(let i = 0; i<res.data.length; i++)
        {
          this.size[i] = ''
          this.imgN[i] = res.data[i].imgN
          console.log(this.imgN[i])
        }
        this.menu = res.data
      })
      .catch(err => {
        console.log(err)
      })
  }
}
</script>

<style>
#card {
  margin-top: 85px;
  margin-left: 65px;
}
.HO {
  position: sticky;
  float: right;
  width: 15vw;
  height: 100vh;
  margin-right:30px;
}
#MU {
  width: 75vw;
}
#menuimge {
  width: 270px;
  height: 300px;
}
#menucard {
  width: 280px;
  margin-left: 15px;
  border: 0.5px solid black;
  margin-top: 20px;
}
#orderokbtn {
  margin-top: 20px;
  background: gainsboro;
}
</style>
