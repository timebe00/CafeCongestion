<template>
  <register-page @registerOK="onSubmit"/>
</template>

<script>
import RegisterPage from '@/components/register/RegisterPage.vue'
import router from '../../router'
import axios from 'axios'

export default {
  name: 'Login',
  components: {
    RegisterPage
  },
  methods: {
    onSubmit(payload) {
      console.log('Register submit Name : ' + payload.name + ' ID : ' + payload.id + ' PW : ' + payload.pw + ' BR : ' + payload.br)
      const {name, id, pw, nn, pn} = payload
      axios.post('http://localhost:1234/register/register', {name, id, pw, nn, pn})
          .then(res => {
            console.log(res)
            if(res.status === 200) {
              alert('회원가입 성공')
              router.push('/login')
            } else {
              alert('정보를 바르게 입력해 주세요')
            }
          })

    }
  }
}
</script>
