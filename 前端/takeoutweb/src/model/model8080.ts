export interface book{
	id : number,
	name : string,
	description : string
}

export interface SpringError{
	timestamp: string,
	status: number,
	message: string,
	path: string
}

export interface SpringList<T>{
	data:T[],
	message?:String,
	code: number
}

export interface SpringPage<T>{
	data:{list :T[],total:number}
	message?:string,
	code:number
}
export interface SpringString{
	data:string,
	message?:string,
	code:number
}

import {AxiosResponse} from 'axios'
import { func } from 'vue-types'

export interface AxiosRespError extends AxiosResponse<SpringError>{}
export interface AxiosRespList<T> extends AxiosResponse<SpringList<T>>{}
export interface AxiosRespPage<T> extends AxiosResponse<SpringPage<T>>{}
export interface AxiosRespString extends AxiosResponse<SpringString>{}

export interface BookQueryDto {
	name?:String,
	price?:String,//11,15
	size:number,
	page:number
}


export interface Route{
	path:string,
	component:string,
	name:string,
	parentName:string
}

export interface Menu{
	id:number,
	pid: number,
	title: string,
	icon?:string,
	routePath?:string
	routeComponent?:string,
	routeName:string,
	routeParentName?:string,
	children?:Menu[]
}

export interface SpringMenuAndRoute{
	data:{
		routList:Route[],
		menuTree:Menu[]
	},
	message?:string,
	code:number
}

