<script setup lang="ts">

import _axios  from '../api/request'
import {ref,onMounted} from 'vue'
import {book,SpringList} from '../model/model8080'


const books = ref<book[]>([]);
async function getBooks(){
	const resp = await _axios.get<SpringList<book>>('/book');
	console.log(resp.data.data);
	console.log(resp.data.message);
	//resp.data == SpringList
	books.value = resp.data.data;
}
getBooks();

</script>

<template>
	<div class="outer" >
		<div class="titile">书籍列表</div>
		<div class="tbody">
			<template class="col" v-if="books.length===0">暂无数据</template>
			<template v-else>
					<div class="row" v-for="b of books">
						<div class="col">{{b.id}}</div><div>||</div><div class="col">{{b.name}}</div><div>||</div><div class="col">{{b.description}}</div>
					</div>
			</template>
		</div>
	</div>
</template>

<style>
.row{
	display: flex;
	flex-direction: row;
}
.col{
	color: red;
}
</style>