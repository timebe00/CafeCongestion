<template>
  <v-main>
    <v-app-bar id="hed"
        absolute
    >
      <v-app-bar-nav-icon v-on:click="drawer=true"></v-app-bar-nav-icon>
      <v-spacer></v-spacer>
      <p id="Tit" @click="$router.push('/')">Cafe Congestion</p>
      <v-spacer></v-spacer>
      <v-btn id="Log" @click="$router.push('/login')" v-if="idSt === 'null'">로그인/회원</v-btn>
      <div id="Log" v-else>
        {{ idSt }}
        <v-btn id="LogOut" v-on:click="logout()">로그아웃</v-btn>
      </div>
    </v-app-bar>
    <v-navigation-drawer
        v-model="drawer"
        absolute
        temporary
    >
      <v-list-item-group
          v-model="group"
          active-class="deep-purple--text text--accent-4"
      >

        <v-list-item @click="$router.push('/')">
          <v-list-item-icon>
            <v-icon>mdi-map</v-icon>
          </v-list-item-icon>
          <v-list-item-title>
            Map
          </v-list-item-title>
        </v-list-item>

        <v-list-item @click="$router.push('/menuupdata')">
          <v-list-item-title>
            메뉴수정
          </v-list-item-title>
        </v-list-item>

        <v-list-item @click="$router.push('/order')">
          <v-list-item-title>
            주문
          </v-list-item-title>
        </v-list-item>
      </v-list-item-group>
    </v-navigation-drawer>
    <router-view/>
  </v-main>
</template>

<script>
// import {mapState, mapActions} from 'vuex'
import {mapState} from 'vuex'

export default {
  name: "App",
  methods: {
    logout() {
      console.log("logout")
      // this.getIdAc("null")
      this.$store.dispatch("getIdAc", "null")
      console.log("logout id : " + this.id)
    }
  },
  computed: {
    ...mapState(['idSt'])
    // ...mapState(['idSt']),
    // ...mapActions(['getIdAc'])
  },
  data: () => ({
    drawer: false
  }),
};
</script>

<style>
#hed {
  background: lightseagreen;
}
#Tit {
  font-size: 30px
}
#Log {
  font-size: 17px;
  margin-right: 10px;
  background: lightskyblue;
}
.basmargin {
  margin-top: 65px;
  width: 100vw;
  height: 92.9vh;
}
</style>
