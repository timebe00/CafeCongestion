<template>
  <div class="basmargin">
    <v-app id="inspire">
      <table>
        <tr>
          <td>번호</td>
          <td><v-text-field type="number" v-model="number" /></td>
        </tr>
        <tr>
          <td>메세지</td>
          <td><v-text-field type="text" v-model="mess" /></td>
        </tr>
      </table>
      <v-btn v-on:click="colltest(number)">전화</v-btn>
      <v-btn v-on:click="end()">전화 종료</v-btn>
      <v-btn v-on:click="txtmestest(number, mess)">문자</v-btn>
    </v-app>
  </div>
</template>

<script>
import * as axios from "axios";

export default {
  name: "Gsm",
  components: {},
  data() {
    return {
      number: 0,
      mess: ""
    };
  },
  computed: {},
  methods: {
    colltest(num) {
      console.log("coll" + this.number);
      axios.post("http://localhost:1234/phone_call", {num})
    },
    txtmestest(num, mess) {
      console.log("txtmes" + this.mess);
      axios.post("http://localhost:1234/phone_msg_send2", {num, mess})
    },
    end() {
      console.log("end")
      axios.get("http://localhost:1234/phone_finish")
    }
  },
  mounted() {}
};
</script>

<style>
table {
  border: black solid 1px;
}
</style>
