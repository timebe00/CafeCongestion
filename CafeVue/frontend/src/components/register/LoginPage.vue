<template>
  <form @submit.prevent="submit">
    <div align="center" class="basmargin">
      <h1 id="getTitle">로그인</h1>
      <table>
        <tr>
          <td>아이디</td>
          <td><input type="text" v-model="id" class="block"></td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td><input type="password" v-model="pw" class="block"></td>
        </tr>
      </table>

      <table>
        <tr>
          <td>
            <button @click="login" class="block">로그인</button>
          </td>
          <td>
            <button @click="$router.push('/')" class="block">취소</button>
          </td>
        </tr>
      </table>
      <table>
        <tr>
          <td><a @click="$router.push('/register')">회원가입</a></td>
          <td><a @click="$router.push('/login/findid')">아이디 찾기</a></td>
          <td><a @click="$router.push('/login/findpw')">비밀번호 찾기</a></td>
        </tr>
      </table>
    </div>
  </form>
</template>

<script>
export default {
  name: 'LoginPage',
  data() {
    return {
      id: '',
      pw: ''
    }
  },
  methods: {
    login() {
      console.log('Login Page submit ID : ' + this.id + 'PW : ' + this.pw)
      const {id, pw} = this
      this.$emit('login', {id, pw})
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

.block {
  border: solid 1px black;
}
</style>
