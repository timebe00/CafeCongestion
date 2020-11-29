<template>
  <form @submit.prevent="submit">
    <div align="center" class="basmargin">
      <p id="getTitle">로그인</p>
      <table>
        <tr>
          <td class ="LoginClass1">아이디</td>
          <td><input type="text" v-model="id" class="block" id="Loginid1" label="aadsf"></td>
        </tr>
        <tr>
          <td class ="LoginClass1">비밀번호</td>
          <td><input type="password" v-model="pw" class="block" id="Loginid2"></td>
        </tr>
      </table>

      <table>
        <tr>
          <td>
            <button @click="login" class="block" id="Loginid3">로그인</button>
          </td>
          <td>
            <button @click="$router.push('/')" class="block" id="Loginid4">취소</button>
          </td>
        </tr>
      </table>
      <table>
        <tr>
          <td><a @click="$router.push('/register')">회원가입</a></td>
          <td><a>|</a></td>
          <td><a @click="$router.push('/login/findid')">아이디 찾기</a></td>
          <td><a>|</a></td>
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
  font-size: 50px;
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

.LoginClass1 {
  font-size: 30px;
}
#Loginid1 {
  height: 30px;
  width: 300px;
}
#Loginid2 {
  height: 30px;
  width: 300px;
}
#Loginid3 {
  height: 30px;
  width: 200px;
}
#Loginid4 {
  height: 30px;
  width: 200px;
}
</style>
