// import './assets/main.css' // 引入 main.css 样式文件

import '@/assets/main.css'
import 'animate.css';
import 'nprogress/nprogress.css'
import { createApp } from 'vue' // 引入 createApp 方法
import App from '@/App.vue' // 引入 App.vue 组件
// 导入路由
import router from '@/router'
// 导入全局路由守卫
import '@/permission'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

// 引入全局状态管理 Pinia
import pinia from '@/stores'

const app = createApp(App)
// 应用路由
app.use(router)
app.mount('#app')
// 引入图标
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

// 应用 Pinia
app.use(pinia)