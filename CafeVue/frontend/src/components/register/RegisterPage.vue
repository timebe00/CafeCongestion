<template>
  <form @submit.prevent="submit">
    <div align="center">
      <h1 id="getTitle">회원가입</h1>
      <table>
        <tr>
          <td>이름</td>
          <td><input type="text" v-model="name" class="block"></td>
        </tr>
        <tr>
          <td>아이디</td>
          <td><input type="text" v-model="id" class="block"></td>
          <td>
            <button @click="clickUse(id)" class="block">중복확인</button>
          </td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td><input type="password" v-model="pw" class="block"></td>
        </tr>
        <tr>
          <td>닉네임</td>
          <td><input type="text" v-model="nn" class="block"></td>
          <td><button @click="clickUseNick(nn)" class="block">중복확인</button></td>
        </tr>
        <tr>
          <td>전화번호</td>
          <td><input type="number" v-model="pn" class="block"></td>
        </tr>
      </table>

      <table>
        <tr>
          <td>
            <button @click="registerOK()" class="block">확인</button>
          </td>
          <td>
            <button @click="$router.push('/login')" type="null" class="block">취소</button>
          </td>
        </tr>
      </table>
    </div>
  </form>
</template>

<script>
import axios from 'axios'

export default {
  name: 'LoginPage',
  data() {
    return {
      name: '',
      id: '',
      pw: '',
      nn: '',
      pn: ''
    }
  },
  methods: {
    registerOK() {
      console.log('Register Page submit Name : ' + this.name + ' ID : ' + this.id + ' PW : ' + this.pw)
      const {name, id, pw, nn, pn} = this
      this.$emit('registerOK', {name, id, pw, nn, pn})
    },
    clickUse(id) {
      console.log('clickUse : ' + id)
      axios.post('http://localhost:1234/register/overlapID', {id})
          .then(res => {
            console.log('res : ' + res.status)
            if (res.status === 204) {
              alert('유효하지 않는 아이디/아이디 중복 입니다.')
            } else {
              alert('사용 가능한 아이디')
            }
          })
          .catch(err => {
            alert(err)
          })
    },
    clickUseNick(nn) {
      axios.post('http://localhost:1234/register/overlapNN', {nn})
          .then(res => {
            console.log('res : ' + res.status)
            if (res.status === 204) {
              alert('유효하지 않는 닉네임/중복되지 않는 닉네임 입니다.')
            } else {
              alert('사용 가능한 닉네임')
            }
          })
          .catch(err => {
            alert(err)
          })
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
