<template>
  <form @submit.prevent="submit">
    <div align="center">
      <h1 id="getTitle">비밀번호 찾기</h1>
      <table>
        <tr>
          <td>이름</td>
          <td><input type="text" v-model="name" class="block"></td>
        </tr>
        <tr>
          <td>아이디</td>
          <td><input type="text" v-model="id" class="block"></td>
        </tr>
        <tr>
          <td>전화번호</td>
          <td><input type="number" v-model="pn" class="block"></td>
        </tr>
      </table>
      <table>
        <tr>
          <td>
            <button @click="findpw()" class="block">확인</button>
          </td>
          <td>
            <button @click="$router.push('/login')" class="block">취소</button>
          </td>
        </tr>
      </table>
    </div>
  </form>
</template>

<script>
export default {
  name: 'FindPwPage',
  data() {
    return {
      id: '',
      name: '',
      br: ''
    }
  },
  methods: {
    findpw() {
      console.log('Find PW Page submit Name : ' + this.name + ' ID : ' + this.id + ' PN : ' + this.pn)
      const {name, id, pn} = this
      this.$emit('findpw', {name, id, pn})
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
