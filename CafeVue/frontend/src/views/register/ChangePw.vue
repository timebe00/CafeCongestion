<template>
  <change-pw-page @repassword="onSubmit"/>
</template>

<script>
import ChangePwPage from '@/components/register/ChangePwPage.vue'
import router from '../../router'

export default {
  name: 'ChangePw',
  components: {
    ChangePwPage
  },
  methods: {
    onSubmit(payload) {
      console.log('Login onSubmit() ID : ' + payload.userid + ' PW : ' + payload.password)
      router.push('/myarea')
    }
  }
}
</script>
