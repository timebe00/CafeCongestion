<template>
  <div class="home">
    <Map/>
  </div>
</template>

<script>
import {mapState} from 'vuex'
import Map from "../components/Map/Map.vue"

export default {
  name: "Home",
  components: {
    Map
  },
  computed: {
    ...mapState(['id'])
  },
};
</script>
