<template>
  <div id="menu">
    <meun-page v-bind:placeSW="place"/>
  </div>
</template>

<script>
import MeunPage from "@/components/Meun/MeunPage";

export default {
name: "Menu",
  components: {
    MeunPage
  },
  props: {
    place: String
  }
}
</script>
