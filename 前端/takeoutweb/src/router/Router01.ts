import {createRouter,createWebHistory} from 'vue-router'

import lose404 from  '../views/404.vue'
import E3 from  '../views/E3.vue'
import { Route } from '../model/model8080'
const routes = [
	{
		path:'/login',
		component: ()=>import('../views/Login.vue')
	},
	// {
	// 	path:'/E0',
	// 	component: E0		
	// },
	// {
	// 	path:'/E3',
	// 	component: E3,
	// 	redirect:'E3/E4',
	// 	children :[
	// 		{
	// 			path:'/E4',
	// 			component: E0	
	// 		},
	// 		{

	// 		}
	// 	]
	// },
	{
		path:'/pathMatcher(.*)*',
		name:'remaining',
		redirect:'/lose404'
	}

]


const router = createRouter({
	history:createWebHistory(),//路径模式
	routes:routes
})

export default router

export function addServerRoutes(routlist:Route[]){
	for(const r of routlist){
		router.addRoute(r.parentName,{
			path: r.path,
			name: r.name,
			component:()=>import(r.component)
		});

	}
}

//重置路由
export function resetRoutes(){
	for(const r of routes){
		router.addRoute(r);
	}
}

