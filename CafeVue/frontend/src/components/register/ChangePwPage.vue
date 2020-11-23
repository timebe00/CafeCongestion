<template>
  <form @submit.prevent="submit">
    <div align="center" class="basmargin">
      <h1 id="getTitle">비밀번호 바꾸기</h1>
      <table>
        <tr>
          <td>비밀번호</td>
          <td><input type="password" v-model="password"></td>
        </tr>
      </table>
      <table>
        <tr>
          <td>
            <button @click="okbutton()">확인</button>
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
  name: 'FindIdPage',
  data() {
    return {
      password: ''
    }
  },
  methods: {
    okbutton() {
      console.log('Find ID Page submit Pw : ' + this.password)
      const {password} = this
      this.$emit('repassword', {password})
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
