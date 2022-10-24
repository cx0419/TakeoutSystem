<template>
	<input type="text" placeholder="请输入名字" v-model="dto.name">
	<select>
		<option value="">请选择性别</option>
		<option value="男">男</option>
		<option value="女">女</option>
	</select>
	<input type="text" placeholder="请输入年龄范围" v-model="dto.price">
	<br>
	<input type="text" placeholder="请输入页码" v-model="dto.page">
	<input type="text" placeholder="请输入页大小" v-model="dto.size">
	<input type="button" value="搜索" @click="search()">
	<hr>
	<ul class="list">
			<li class="col" v-for="b of books" key="b.id">
				<span>{{b.id}}||</span>
				<span>{{b.name}}||</span>
				<span>{{b.description}}</span>
			</li>
		</ul>
		<div>总记录数目:{{total}}</div>
		<div>总页数:{{totalPage}}</div>

</template>

<script setup lang="ts">
import _axios  from '../api/request'
import {computed,ref}  from 'vue'
import {usePagination}  from 'vue-request'
import {AxiosRespPage,AxiosRespList,BookQueryDto,book}  from '../model/model8080'

let  dto = ref<BookQueryDto>({name:'三国演义',price:"",page:1,size:5})

//data1 代表的就是 _axios 的响应对象
//参数列表:data:返回的数据的响应式格式
//total总数
//totalPage总页数
//run函数供调用
//泛型参数1:响应类型
//泛型参数2:请求类型
let {data:data1,total,totalPage,run:run1} = usePagination<AxiosRespPage<book>,BookQueryDto[]> (
	(d)=> _axios.get('book/fy',{params:d}),
	{
		defaultParams : [dto.value],
		pagination : {
			//从axios返回值里面拿到,返回到响应式数据当中
			currentKey: 'page',//当前页
			pageSizeKey: 'size',//每一页数目
			totalKey: 'data1.data.total'//总记录数
		}
	}//选项
)
let books = computed(()=>{
	return data1?.value?.data.data.list || []
	
})

function search(){
	run1(dto.value)
}
</script>