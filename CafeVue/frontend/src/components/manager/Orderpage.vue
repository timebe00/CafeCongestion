<template>
  <div class="basmargin">
    <v-app id="inspire">
      <div>
        <br/><br/>
        <v-btn @click="stopin()">Stop</v-btn>
        <v-data-table
            :headers="headers"
            :items="orderlist"
        >
          <template v-slot:item.ok="{ item }">
            <v-btn @click="okbtn(item.id)">확인</v-btn>
          </template>
          <template v-slot:item.tru="{ item }">
            <v-icon @click="dle(item.orderNo)">mdi-delete</v-icon>
          </template>
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
      getinterval: '',
      getponNum: '',
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
        { text: '주문', value: 'orders'},
        { text: '아이디', value: 'id' },
        { text: '크기', value: 'size' },
        { text: '주문 확인', value: 'ok' },
        { text: '삭제', value: 'tru' }
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
    },
    async okbtn (id) {
      console.log("id : " + id)
      let pho = ''
      await axios.post('http://localhost:1234/register/phonnum', {id})
        .then(res => {
          console.log(res.data.pn)
          pho = res.data.pn
        })
      console.log('pho : ' + pho)

      axios.post('http://localhost:1234/phone_msg_send', {pho})
    },
    dle (orderNo) {
      axios.post('http://localhost:1234/orderby/remove', {orderNo})
    },
    stopin () {
      console.log("stopin")
      clearInterval(this.getinterval)
    }
  },
  mounted() {
    if (this.idSt != "null" && this.adSt != "null") {
      this.haveME()
      this.getinterval = setInterval(this.haveME, 5000)
    }
    else {
      router.push("/")
    }
  }
}
</script>

<style>
</style>
