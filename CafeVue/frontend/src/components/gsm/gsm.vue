<template>
  <div id="app">
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

      <v-btn v-on:click="colltest()">전화</v-btn>
      <v-btn v-on:click="txtmestest()">문자</v-btn>
    </v-app>
  </div>
</template>

<script>
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
    colltest() {
      console.log("coll" + this.number);
    },
    txtmestest() {
      console.log("txtmes" + this.mess);
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
