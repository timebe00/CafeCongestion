<template>
  <div class="basmargin">
    아이디<input type="text" v-model="id">
    장소<input type="text" v-model="place">
    <v-btn @click="okbtn(id, place)"/>
  </div>
</template>

<script>
import axios from "axios";

export default {
name: "AddPlace",
  methods: {
    okbtn (id, place) {
      console.log("id : " + id)
      console.log("place : " + place)
      // let ad = place
      axios.post("http://localhost:1234/place/placecreate", {id, place})
      // axios.post("http://localhost:1234/register/placeupdata", {id, ad})
    }
  },
  data: () => ({
    place: '',
    id: ''
  }),
}
</script>

<style scoped>

</style>
