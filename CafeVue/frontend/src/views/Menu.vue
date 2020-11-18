<template>
  <div id="menu">
    <meun-page v-bind:placeSW="place"/>
  </div>
</template>

<script>
import MeunPage from "@/components/Meun/MeunPage";
import {mapState} from 'vuex'
import router from "@/router";

export default {
name: "Menu",
  components: {
    MeunPage
  },
  props: {
    place: String
  },
  computed: {
    ...mapState(['idSt'])
  },
  mounted() {
    console.log("id : " + this.id)
    if (this.idSt == "null") {
      router.push("/")
    }
  }
}
</script>
