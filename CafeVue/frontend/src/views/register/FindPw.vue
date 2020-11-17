<template>
  <find-pw-page @findpw="onSubmit"/>
</template>

<script>
import FindPwPage from '@/components/register/FindPwPage.vue'
import router from '../../router'
import axios from 'axios'

export default {
  name: 'FindPw',
  components: {
    FindPwPage
  },
  data: () => ({
    id: ''
  }),
  methods: {
    onSubmit(payload) {
      const {name, id, pn} = payload
      axios.post('http://localhost:1234/register/findpw', {name, id, pn})
          .then(res => {
            if (res.status === 204) {
              alert('잘못 입력하셨습니다.  :  ')
            } else {
              this.id = res.data.id
              router.push({name: 'HavePw', params: {id}})
            }
          })
          .catch(err => {
            alert(err.response.data)
          })
    }
  }
}
</script>
