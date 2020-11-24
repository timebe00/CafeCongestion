<template>
  <div>
    <menu-plu @menuset="setMenu"/>
  </div>
</template>

<script>
import MenuPlu from "@/components/manager/MenuPlu";
import axios from "axios";
import router from "@/router";

export default {
name: "MenuUpdata",
  components: {
    MenuPlu
  },
  methods: {
    setMenu (payload) {
      console.log("setMenu" + payload)
      console.log(payload)
      const { gr, imgN, name, place, pr, ta, va } = payload
      axios.post('http://localhost:1234/menu/create', { gr, imgN, name, place, pr, ta, va })
        .then(res => {
          console.log(res)
        })
      router.push("/menu/voidpage")
    }
  }
}
</script>

<style scoped>

</style>
