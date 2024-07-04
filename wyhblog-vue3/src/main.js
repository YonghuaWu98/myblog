// import './assets/main.css' // 引入 main.css 样式文件
import '@/assets/main.css'
import 'animate.css';

import { createApp } from 'vue' // 引入 createApp 方法
import App from '@/App.vue' // 引入 App.vue 组件
// 导入路由
import router from '@/router'

import * as ElementPlusIconsVue from '@element-plus/icons-vue'

// 创建应用，并将 App 根组件挂载到 <div id="#app"></div> 中
const app = createApp(App)
// 应用路由
app.use(router)
app.mount('#app')
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}