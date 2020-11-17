<template>
  <div id="menu">
    <meun-page v-bind:placeSW="place"/>
  </div>
</template>

<script>
import MeunPage from "@/components/Meun/MeunPage";
import {mapState} from 'vuex'

export default {
name: "Menu",
  components: {
    MeunPage
  },
  props: {
    place: String
  },
  computed: {
    ...mapState(['id'])
  },
  mounted() {
    console.log("id : " + this.id)
  }
}
</script>
