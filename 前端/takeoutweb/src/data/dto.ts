

//统一返回格式
export interface JsonResult<T>{
	success?:boolean,
	errorCode?:string
	errorMsg?:string,
	data?:T
}


//登录
export interface loginDto{
	name:string,
	password:string
}
