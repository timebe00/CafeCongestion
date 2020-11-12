<template>
  <v-main>
    <v-app-bar
        absolute
        color="blue"
    >
      <v-app-bar-nav-icon v-on:click="testopen()"></v-app-bar-nav-icon>
      <v-container style="height: 1000px;"></v-container>
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
        <v-list-item v-on:click="test()">
          <v-list-item-icon>
            <v-icon>mdi-map</v-icon>
          </v-list-item-icon>
          <v-list-item-title>Map</v-list-item-title>
        </v-list-item>
      </v-list-item-group>
    </v-navigation-drawer>
    <Home/>
  </v-main>
</template>

<script>
import Home from "./views/Home.vue"
// import Map from "./components/Map.vue"

export default {
  name: "App",
  components: {
    Home
    // Map
  },
  methods: {
    test() {
      console.log("echo")
    },
    testopen () {
      this.drawer = true
    }
  },
  data: () => ({
    drawer: false,
  })
};
</script>
