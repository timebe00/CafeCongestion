<template>
  <v-app id="app">
    <wrapper/>
  </v-app>
</template>

<script>
import Wrapper from './layout/Wrapper.vue'

export default {
  name: 'App',
  data: () => ({}),
  components: {
    Wrapper
  },
}
</script>

<style lang="scss" src="./App.scss">
</style>
