<template>
	<div class="login_container">
		<div class="login-left">
			<div class="welcome">WelCome!</div>
			<el-space :size="50" direction="vertical">
				<div></div>
			</el-space>
			<div class="smalltext">“饿了么”是2008年创立的本地生活平台，主营在线外卖、新零售、即时配送和餐饮供应链等业务。
				创业12年，饿了么以“Everything 30min”为使命，致力于用科技打造本地生活服务平台，推动了中国餐饮行业的数字化进程，
				将外卖培养成中国人继做饭、堂食后的第三种常规就餐方式。</div>
		</div>
		<div class="login-right">
			<div class="login_form">
				<el-space direction="vertical">
					<div class="green">登录到外卖系统</div>
					<el-space :size="20" class="login_form_top">
						<div class="register">没有账号?</div>
						<a class="signup" href="www.baidu.com">点击注册</a>
					</el-space>
				</el-space>
				<el-space :size="50" direction="vertical" >
					<div></div>
				</el-space>
				<el-space direction="vertical" :size="30">
					<input v-model="input.name"  type="text"  class="demoInput"  placeholder="Please input name"/>
					<input v-model="input.password" type="text" class="demoInput" placeholder="Please input password"/>
					<input @click="login()" class="login-btn" type="button" value="登录">
					<input @click="test()" class="login-btn" type="button" value="测试">
				</el-space>
			
			</div>
		</div>
	</div>
</template >
  
<script setup lang="ts">
import { ElMessage } from 'element-plus'
import { ref } from 'vue'
import {Customer} from '../data/pojo'
import {loginDto,JsonResult} from '../data/dto'
import {LocalStorageService} from '../data/Storage'
import _axios from '../api/request'

let input = ref<loginDto>({
	name:"",
	password:""
})

async function login(){
	console.log("name"+input.value.name);
	console.log("password"+input.value.password);
	let resp = await _axios.post<JsonResult<object>>('/customer/login',{
	
		"name":input.value.name,
		"password":input.value.password,
	
	});
	if(resp.data.success){
		//登录成功
		let token =  resp.headers.token;
		console.log("Login.vue:"+token);
		LocalStorageService?.set('token',token);
	}else{
		//登录失败
		console.log(resp.data.errorMsg);
		console.log(resp.data.errorCode);
	}
}
	
async function test(){
	let resp = await _axios.get<JsonResult<object>>('/customer/123');
	if(resp.data.success){
		//登录成功
		console.log("test success");
	}else{
		//登录失败
		console.log("test fail");
		console.log(resp.data.errorMsg);
		console.log(resp.data.errorCode);
	}
}
	

</script>

<style scoped>
.login_container{
	height: 100%;
	background-color: #fff;
	display: flex;
	
}
.login_box{
	width: 1050px;
	height: 600px;
	background-color: #fff;
	border-radius: 3px;
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%,-50%);
}
.login-left{
	flex:1;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	background-color: #21a675;
}
.smalltext{
	margin-top: 20px;
	padding-left: 20px;
	padding-right: 20px;
	word-wrap: normal;
	font-size: 14px;
    font-weight: 400;
    font-family: "Microsoft soft";
	height: 45px;
	color: #fff;
}
.welcome{
	margin-top: -550px;
	color: #fff;
	width: 300px;
	height: 50px;
	font-weight: 650;
	font-size: 50px;
}
.login-right{
	display: flex;
	justify-content: center;
	align-items: center;
	flex:2;
}
.login_form{
	width: 600px;
	height: 550px;
	display: flex;
	flex-direction: column;
	
}
.login_form_top{
	display: flex;
}
.green{
	font-weight: 550;
	font-size: 42px;
	color: #21a675;
}
.register{
	color: #c2ccd0;
}
.signup{
	color: #21a675;
}

.inputAP {
	border-color: #c2ccd0;
	height: 50px;
	width: 200px;
	border-radius: 10px;
}
.red{
	background-color: red;
}

.aquamarine{
	background-color:aquamarine;
}
.blue{
	background-color: rgb(79, 190, 205);
}
.demoInput {
    outline-style: none ;
    border: 1px solid #ccc; 
    border-radius: 3px;
    padding: 13px 14px;
    width: 620px;
    font-size: 14px;
    font-weight: 700;
    font-family: "Microsoft soft";
}
.demoInput:focus{
    border-color: #66afe9;
    outline: 0;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)
}
.login-btn{
	width: 620px;
	background-color: #21a675;
	border: 1px solid #ccc; 
	border-radius: 3px;
	font-size: 14px;
    font-weight: 700;
    font-family: "Microsoft soft";
	height: 45px;
	color: #fff;
}
.login-btn:hover{
	background-color: #2c8665;
}
</style>
  


  
  