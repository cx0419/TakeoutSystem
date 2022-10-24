import {createRouter,createWebHistory} from 'vue-router'

const routes = [
	
	{
		path:'/a1',
		component: ()=>import('../views/A51.vue')
	},
	{
		path:'/a2',
		component: ()=>import('../views/A52.vue')
	},

	{
		path:'/a3',
		component: ()=>import('../views/A53.vue'),
		// redirect:'/a3/a32',
		children :[
			{
				path:'a31',
				component: ()=>import('../views/A531.vue'),	
			},
			{
				path:'a32',
				component: ()=>import('../views/A532.vue'),	
			}
		]
	},
	//没有此页面
	{
		path:'/:pathMatcher(.*)*',//可以匹配剩余的路径
		name:'remaining',
		redirect:'/a2'
	}

]


const router = createRouter({
	history:createWebHistory(),//路径格式
	routes:routes//对应路由数组
})
// 4. 你还可以监听路由拦截，比如权限验证。
router.beforeEach((to, from, next) => {
	// 1. 每个条件执行后都要跟上 next() 或 使用路由跳转 api 否则页面就会停留一动不动
	// 2. 要合理的搭配条件语句，避免出现路由死循环。
	// const token = cookies.get('token')
	// if (to.meta.auth) {
	// 	if (!token) {
	// 		return router.replace({
	// 		name: 'login'
	// 	  })
	// 	}
	// 	next()
	// } else {
	//   next()
	// }
  })
export default router