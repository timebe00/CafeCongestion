<template>
  <div>
    <orderpage/>
  </div>
</template>

<script>
import Orderpage from "@/components/manager/Orderpage.vue"
import {mapState} from 'vuex'

export default {
name: "getOrder",
  components: {
    Orderpage
  },
  computed: {
    ...mapState(["idSt"]),
    ...mapState(["adSt"])
  },
  mounted() {}
}
</script>

<style scoped>

</style>
