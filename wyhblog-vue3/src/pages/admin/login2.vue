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
        <form class="box">
            <h1>登录</h1>
            <input type="text" v-model="form.username" name="" placeholder="用户名">
            <input type="password" v-model="form.password" name="" placeholder="密码">
            <input type="submit" name="" value="登录" @click="onSubmit">
        </form>  

</template>

<script setup>
// 引入 Element Plus 中的用户、锁图标
// 引入 Element Plus 中的用户、锁图标
import { User, Lock } from '@element-plus/icons-vue'
import { login } from '@/api/admin/user'
import { useRouter } from 'vue-router';
import { showMessage} from '@/composables/util'
import { setToken } from '@/composables/cookie'
import { useUserStore } from '@/stores/user'
import { ref, reactive, onMounted, onBeforeUnmount } from 'vue'
// import '@/assets/star.css';
// import '@/assets/style.css';
// 定义响应式的表单对象

const form = reactive({
    username: '',
    password: ''
})
// 表单引用
const formRef = ref(null)
// 表单验证规则
const rules = {
    username: [
        {
            required: true,
            message: '用户名不能为空',
            trigger: 'blur'
        }
    ],
    password: [
        {
            required: true,
            message: '密码不能为空',
            trigger: 'blur',
        },
    ]
}

const router = useRouter()
const userStore = useUserStore()
// 登录
const onSubmit = () => {
    console.log('登录')
    // 先验证 form 表单字段
    // formRef.value.validate((valid) => {
    //     if (!valid) {
    //         console.log('表单验证不通过')
    //         return false
    //     }

        // 调用登录接口
        login(form.username, form.password).then((res) => {
            console.log(res)
            // 判断是否成功
            if (res.success == true) {
                 // 提示登录成功
                 showMessage('登录成功')
                
                // 存储 Token 到 Cookie 中
                let token = res.data.token
                setToken(token)
                // 获取用户信息，并存储到全局状态中
                userStore.setUserInfo()
                // 跳转到后台首页
                router.push('/admin/index')
            }else {
                // 获取服务端返回的错误消息
                let message = res.message
                // 提示消息
                showMessage(message, 'error')
            }
        })
    // })
}
// 按回车键后，执行登录事件
function onKeyUp(e) {
    console.log(e)
    if (e.key == 'Enter') {
        onSubmit()
    }
}

// 添加键盘监听
onMounted(() => {
    console.log('添加键盘监听')
    document.addEventListener('keyup', onKeyUp)
})

// 移除键盘监听
onBeforeUnmount(() => {
    document.removeEventListener('keyup', onKeyUp)
})

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
<style module>
/* @import '@/assets/star.css';
@import '@/assets/style.css'; */
</style>


