<template>
    <div class="moon">
        <div class="crater"></div>
    </div>
    <div class="footprints">
        <span></span>
        <span></span>
        <span></span>
    </div>
    <div class="astronaut">
        <div class="backpack"></div>
        <div class="head">
            <div class="helmet"></div>
        </div>
        <div class="neck"></div>
        <div class="body"></div>
        <div class="arm right">
            <div class="top"></div>
            <div class="bot"></div>
            <div class="hand"></div>
        </div>
        <div class="arm left">
            <div class="top"></div>
            <div class="bot"></div>
            <div class="hand"></div>
        </div>
        <div class="leg right">
            <div class="top"></div>
            <div class="bot"></div>
            <div class="foot"></div>
        </div>
        <div class="leg left">
            <div class="top"></div>
            <div class="bot"></div>
            <div class="foot"></div>
        </div>
    </div>
    <div class="star comet"></div>
        
    <!-- <div id="app"> -->
    <form class="box" @submit.prevent="onSubmit">
        <h1>登录</h1>
        <input type="text" v-model="form.username" placeholder="用户名">
        <input type="password" v-model="form.password" placeholder="密码">
        <input type="submit" value="登录">
    </form>
    <!-- </div> -->
                  
</template>

<script setup>
// 引入 Element Plus 中的用户、锁图标
import { User, Lock } from '@element-plus/icons-vue'
import { login } from '@/api/admin/user'
import { reactive } from 'vue' 
import { useRouter } from 'vue-router';
import '@/assets/star.css';
import '@/assets/style.css';
// 定义响应式的表单对象
const form = reactive({
    username: '',
    password: ''
})

const router = useRouter()
// 登录
const onSubmit = () => {
    console.log('登录')
    login(form.username, form.password).then((res) => {
        console.log(res)
        // 判断是否成功
        if (res.data.success == true) {
            // 跳转到后台首页
            router.push('/admin/index')
        }
    })
}

const wH = window.innerHeight;
const wW = window.innerWidth;

const generateStars = n => {
  for (let i = 0; i < n; i++) {
    const div = document.createElement('div');
    div.className = i % 20 == 0 ? 'star star--big' : i % 9 == 0 ? 'star star--medium' : 'star';
    // random everywhere!
    div.setAttribute('style', `top:${Math.round(Math.random() * wH)}px;left:${Math.round(Math.random() * wW)}px;animation-duration:${Math.round(Math.random() * 3000) + 3000}ms;animation-delay:${Math.round(Math.random() * 3000)}ms;`);
    document.body.appendChild(div);
  }
};

generateStars(150);

</script>
<script scoped>

</script>

<style scoped>

</style>


