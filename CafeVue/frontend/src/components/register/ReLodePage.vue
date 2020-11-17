<template>
  <form @submit.prevent="submit">
    <div align="center">
      <h1 id="getTitle">로그인</h1>
      <table>
        <tr>
          <td>아이디</td>
          <td><input type="text" v-model="userid"></td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td><input type="password" v-model="pw"></td>
        </tr>
      </table>
      <table>
        <tr>
          <td>
            <button @click="login">로그인</button>
          </td>
          <td>
            <button @click="$router.push('/myarea')">취소</button>
          </td>
        </tr>
      </table>
    </div>
  </form>
</template>

<script>
export default {
  name: 'ReLodePage',
  data() {
    return {
      userid: '',
      pw: ''
    }
  },
  methods: {
    login() {
      console.log('Re Lode Page submit ID : ' + this.userid + 'PW : ' + this.pw)
      const {userid, pw} = this
      this.$emit('login', {userid, pw})
    },
    submit() {
    }
  }
}
</script>

<style>
#getTitle {
  margin-top: 10%;
}

table {
  margin-top: 20px;
}

td {
  padding: 5px;
}

button {
  padding-right: 40px;
  padding-left: 40px;
}
</style>
