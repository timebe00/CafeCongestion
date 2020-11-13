<template>
  <div id="card">
    <div id="HO">
    </div>
    <div id="MU">
      <v-row>
        <v-card
            class="mx-auto"
            max-width="344"
        >
          <v-img
              src="@/assets/CafeMenu/아메리카노.png"
              height="200px"
          ></v-img>
          <v-card-title>아메리카노</v-card-title>
          <v-card-subtitle>3000원</v-card-subtitle>
          <v-card-actions>
            <v-btn
                color="orange lighten-2"
                text
            >
              선택하기
            </v-btn>

            <v-spacer></v-spacer>

            <v-btn
                icon
                v-on:click="show = !show"
            >
              <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
            </v-btn>
          </v-card-actions>

          <v-expand-transition>
            <div v-show="show">
              <v-divider></v-divider>

              <v-card-actions>
                Size :
                <v-checkbox v-model="size" value="3" id="up"/>
                Venti
                <v-checkbox v-model="size" value="2" id="up"/>
                Grande
                <v-checkbox v-model="size" value="1" id="up"/>
                Tall
                <v-btn v-on:click="PushCof()">확인</v-btn>
              </v-card-actions>
            </div>
          </v-expand-transition>
        </v-card>
      </v-row>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: "MeunPage",
  data: () => ({
    show: false,
    size: [],
    dialog3: false
  }),
  methods: {
    PushCof() {
      console.log(this.size)
    }
  },
  props: {
    placeSW: String
  },
  created() {
    let place = this.placeSW
    console.log(place)
    axios.post('http://localhost:1234/menu/show', {place})
      .then(res => {
        console.log("성공")
        console.log(res.data)
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
  border: 1px solid black;
  width: 15vw;
  height: 100vh;
  margin-right:30px;
}
#MU {
  border: 1px solid black;
  width: 75vw;
}
</style>
