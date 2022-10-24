import { def } from '@vue/shared';
import axios from 'axios';
import {LocalStorageService} from '../data/Storage'

const _axios =  axios.create({
	baseURL:import.meta.env.VITE_BACKEND_API_BASE_URL
})
_axios.interceptors.request.use(
	(config)=>{
		config.headers = {
			"Content-Type":"application/json"
		}
		//防止爆红
		if (!config?.headers) {throw new Error(`Expected 'config' and 'config.headers' not to be undefined`);}
		//1.1 获取到浏览器里面一直存储的token，并将它放到
		let uToken =  LocalStorageService.get("token");
		console.log("uToken:"+uToken);

		if(uToken!=null){
			//1.2 注意：给请求头里面添加token（后台判断就是取的这个请求头）请求头，并把随机数的token值也设置进去
			config.headers['token']=uToken;
		}
		return config;

	},
	(error)=>{
		return Promise.reject(error)
	},

)
_axios.interceptors.response.use(
	(response)=>{
		let data = response.data;
		//只要前台被拦截的请求里面含这两个参数，那么就跳转到登录界面
		// if(!data.success && data.msg==="loginFail"){
		// 	location.href = "login.html";
		// }
		return response;
	},
	(error)=>{
		if(error.response.status === 400){

		}else if(error.response.status === 401){
			
		}else if(error.response.status === 403){
			
		}else if(error.response.status === 404){
			
		}else if(error.response.status === 500){
			
		}
		return Promise.resolve({});
	}
)
export default _axios 