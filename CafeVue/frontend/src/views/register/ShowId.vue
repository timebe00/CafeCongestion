<template>
  <show-id-page @idshow="onSubmit" v-bind:id="id"/>
</template>

<script>
import ShowIdPage from '@/components/register/ShowIdPage.vue'
import router from '../../router'

export default {
  name: 'ShowId',
  components: {
    ShowIdPage
  },
  methods: {
    onSubmit(payload) {
      console.log(payload)
      router.push('/login')
    }
  },
  props: {
    id: String
  },
  mounted() {
    console.log('id : ' + this.id)
  }
}
</script>
