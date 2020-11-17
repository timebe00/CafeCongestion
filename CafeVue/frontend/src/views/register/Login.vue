<template>
  <login-page @login="onSubmit"/>
</template>

<script>
import LoginPage from '@/components/register/LoginPage.vue'
import router from '../../router'
import axios from 'axios'
import {mapActions} from 'vuex'

export default {
  name: 'Login',
  components: {
    LoginPage
  },
  data: () => ({
    a: ''
  }),
  methods: {
    ...mapActions(['getIdAc']),
    onSubmit(payload) {
      const {id, pw} = payload
      axios.post('http://localhost:1234/register/login', {id, pw})
          .then(res => {
            if (res.status === 204) {
              alert('잘못 입력하셨습니다.')
            } else {
              console.log(res.data.id)
              this.getIdAc(res.data.id)
              router.push('/')
            }
          })
          .catch(err => {
            alert(err.response.data)
          })
    }
  }
}
</script>
