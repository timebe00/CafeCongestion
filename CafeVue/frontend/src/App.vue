<template>
  <v-main>
    <v-app-bar id="hed"
        absolute
    >
      <v-app-bar-nav-icon v-on:click="testopen()"></v-app-bar-nav-icon>
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
    <router-view/>
  </v-main>
</template>

<script>

export default {
  name: "App",
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

<style>
#hed {
  color: blue
}
</style>
