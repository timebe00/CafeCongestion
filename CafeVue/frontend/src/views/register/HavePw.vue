<template>
  <have-pw-page @repw="onSubmit"/>
</template>

<script>
import HavePwPage from '@/components/register/HavePwPage.vue'
import router from '../../router'
import axios from 'axios'

export default {
  name: 'HavePw',
  components: {
    HavePwPage
  },
  data: () => ({
    id: ''
  }),
  methods: {
    onSubmit(payload) {
      this.id = this.$route.params.id
      payload.id = this.id
      const {id, pw} = payload
      axios.post('http://localhost:1234/register/uplodpw', {id, pw})
          .then(res => {
            if(res.status == 200)
            {
              console.log(res)
              alert('비밀번호 변경 성공')
              router.push('/login')
            } else {
              console.log(res)
            }
          })
          .catch(err => {
            alert(err.response.data)
          })
    }
  }
}
</script>
