<template>
  <find-id-page @findid="onSubmit"/>
</template>

<script>
import FindIdPage from '@/components/register/FindIdPage.vue'
import router from '../../router'
import axios from 'axios'

export default {
  name: 'FindId',
  components: {
    FindIdPage
  },
  data: () => ({
    id: ''
  }),
  methods: {
    onSubmit(payload) {
      const {name, pn} = payload
      axios.post('http://localhost:1234/register/findid', {name, pn})
          .then(res => {
            if (res.status === 204) {
              alert('잘못 입력하셨습니다.')
            } else {
              this.id = res.data.id
              router.push({name: 'ShowId', params: {id: this.id}})
            }
          })
          .catch(err => {
            alert(err.response.data)
          })
    }
  }
}
</script>
