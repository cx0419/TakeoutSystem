<script lang="ts" setup>
import {useRequest} from 'vue-request'
import _axios  from '../api/request'
import {computed}  from 'vue'
import {AxiosRespList,book} from '../model/model8080'

//获取响应式数据
let { data:data} = useRequest(()=>_axios.get('/book'));
let {data:data1} = useRequest(()=>_axios.get('/book/1'));

//寻址
let books = computed(()=>{
	//-----响应式val(resp)-.data.data
	let { data:data2} = useRequest<AxiosRespList<book>>(()=>_axios.get('/book'));
	return data2?.value?.data.data || [] 
})
let book1 = computed(()=>{
	return data?.value?.data.data || [] 
})
</script>


<template>
	<h3>数据列表</h3>
	<h3 v-if="books.length === 0">暂无数据</h3>
	<template v-else>
		<ul class="list">
			<li class="col" v-for="b of books" key="b.id">
				<span>{{b.id}}||</span>
				<span>{{b.name}}||</span>
				<span>{{b.description}}</span>
			</li>
		</ul>
	</template>

</template>


<style>


</style>