import { createApp } from 'vue'
import './style.css'
import login from './views/Login.vue'
import 'ant-design-vue/dist/antd.css'
import antdv from 'ant-design-vue'
import router from './router/A5'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'


// createApp(A5).mount('#app')
createApp(login).use(antdv).use(router).use(ElementPlus,{ size: 'small', zIndex: 3000 }).mount('#app')
console.log('baseURL:'+import.meta.env.VITE_BACKEND_API_BASE_URL);