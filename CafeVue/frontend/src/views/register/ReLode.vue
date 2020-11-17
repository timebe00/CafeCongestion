<template>
  <re-lode-page @login="onSubmit"/>
</template>

<script>
import ReLodePage from '@/components/register/ReLodePage.vue'
import router from '../../router'

export default {
  name: 'ReLode',
  components: {
    ReLodePage
  },
  methods: {
    onSubmit(payload) {
      console.log('Re Lode onSubmit() ID : ' + payload.userid + ' PW : ' + payload.password)
      router.push('/myarea/relode/changepw')
    }
  }
}
</script>
