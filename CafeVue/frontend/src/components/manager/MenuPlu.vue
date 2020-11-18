<template>
  <div>
    <v-data-table
      :headers="headers"
      :items="orderlist"
    />
  </div>
</template>

<script>
export default {
  name: "MenuPlu",
  computed: {
    headers () {
      return [
        {
          text: '주문 번호',
          align: 'start',
          sortable: false,
          value: 'orderNo',
        },
        {
          text: '주문',
          value: 'orders'
        },
        { text: '닉네임', value: 'nickname' },
        { text: '수량', value: 'cafenum' },
      ]
    },
  },
}
</script>

<style scoped>

</style>
