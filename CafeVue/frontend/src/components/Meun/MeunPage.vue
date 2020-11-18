<template>
  <div id="card">
    <ul id="HO">
      <ol
           v-for="i in item"
           :key="i.key">
        {{ i.name }}<br>
        <p v-if="i.size === '1'" id="shsi">Tall</p>
        <p v-else-if="i.size === '2'" id="shsi">Grande</p>
        <p v-else id="shsi">Venti</p>
<!--        {{ i.size === '1' }}-->
        <v-btn v-on:click="removeitem(i.key)">취소</v-btn>
      </ol>
    </ul>
    <div id="MU">
      <v-row>
          <v-card
            class="mx-auto"
            max-width="344"
            v-for="(item, idx) in menu"
            :key="item.menuNo"
          >
          <v-img
              src="@/assets/CafeMenu/아메리카노.png"
              height="200px"
          ></v-img>
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
              <v-checkbox v-model="size[idx]" value="3" v-if="item.va === 123"/>
              <p v-if="item.va===123">Venti</p>
              <v-checkbox v-model="size[idx]" value="2" v-if="item.gr === 123"/>
              <p v-if="item.gr===1">Grande</p>
              <v-checkbox v-model="size[idx]" value="1" v-if="item.ta === 123"/>
              <p v-if="item.ta===1">Tall</p>
              <v-btn v-on:click="PushCof(item.name, size[idx], idx, idSt, placeSW)">확인</v-btn>
            </v-card-actions>
        </v-card>
      </v-row>
    </div>
    <v-btn v-on:click="Order()">주문하기</v-btn>
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
    dialog3: false
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
        for(let i = 0; i<res.data.length; i++)
        {
          this.size[i] = ''
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
#HO {
  position: sticky;
  float: right;
  width: 15vw;
  height: 100vh;
  margin-right:30px;
}
#MU {
  width: 75vw;
}
</style>
