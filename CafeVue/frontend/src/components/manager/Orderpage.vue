<template>
  <div id="app">
    <v-app id="inspire">
      <div>
        <v-data-table
            :headers="headers"
            :items="orderlist"
        >
        </v-data-table>
      </div>
    </v-app>
  </div>
</template>

<script>
import axios from 'axios'
import {mapState} from 'vuex'
import router from "@/router";

export default {
  name:'Orderpage',
  data () {
    return {
      search: '',
      calories: '',
      places: 'a',
      testidx: '',
      orderlist: []
    }
  },
  computed: {
    ...mapState(["idSt"]),
    ...mapState(["adSt"]),
    headers () {
      return [
        {
          text: '주문 번호',
          align: 'start',
          sortable: false,
          value: 'orderNo',
        },
        {
          text: '주문',
          value: 'orders'
        },
        { text: '아이디', value: 'id' },
        { text: '크기', value: 'size' },
      ]
    },
  },
  methods: {
    async haveME () {
      console.log("echo")
      // const place = this.adSt
      const place = "커피빈 종각역점"
      await axios.post('http://localhost:1234/orderby/list', {place})
          .then(res => {
            this.orderlist = res.data
          })
    }
  },
  mounted() {
    if (this.idSt != "null" && this.adSt != "null") {
      this.haveME()
      setInterval(this.haveME, 5000)
    }
    else {
      router.push("/")
    }
  }
}
</script>

<style>
</style>
