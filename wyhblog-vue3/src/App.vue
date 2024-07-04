<script setup>
import HelloWorld from './components/HelloWorld.vue'
import TheWelcome from './components/TheWelcome.vue'
</script>

<template>
   <router-view></router-view>
  <!-- html 代码 -->
  <h1></h1>
</template>
<style setup>
  /* js 代码, setup 标识通常和组合式 API 搭配使用, 
  用于告诉 Vue 需要在编译时进行一些处理，让我们可以更简洁地使用组合式 API 
  */

</style>
<style scoped>
  /* css 代码， scoped 表示节点内 css 样式只针对此组件有效，不影响其他组件 */
</style>
