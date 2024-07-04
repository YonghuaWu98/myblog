import Index from '@/pages/frontend/index.vue'
import { createRouter, createWebHashHistory } from 'vue-router'
import Login2 from '@/pages/admin/login.vue'
import AdminIndex from '@/pages/admin/index.vue'

import Login from '@/pages/admin/login2.vue'
// 统一在这里声明所有路由
const routes = [
    {
        path: '/', // 路由地址
        component: Index, // 对应组件
        meta: { // meta 信息
            title: 'Wyhblog 首页' // 页面标题
        }
        
    },
    {
        path: '/login2', // 路由地址
        component: Login2, // 对应组件
        meta: { // meta 信息
            title: 'Wyhblog 登录页' // 页面标题
        }
    },
    {
        path: '/admin/index',//后台首页
        component: AdminIndex,
        meta: {
            title: 'Admin 后台首页'
        }
    },
    {
        path: '/login',//登录页
        component: Login,
        meta: {
            title: 'Wyh blog 登录页'
        }
    }

]

// 创建路由
const router = createRouter({
    // 指定路由的历史管理方式，hash 模式指的是 URL 的路径是通过 hash 符号（#）进行标识
    history: createWebHashHistory(),
    // routes: routes 的缩写
    routes, 
})

// ES6 模块导出语句，它用于将 router 对象导出，以便其他文件可以导入和使用这个对象
export default router