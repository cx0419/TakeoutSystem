

<script setup lang="ts">
import {reactive, ref,computed} from 'vue';
import axios from 'axios'

const msg = ref('Hello World');
const user = reactive({name:"张三"});
const path = "https://ts1.cn.mm.bing.net/th?id=OIP-C.Russj_ScHRzeGEodKscxEgHaEo&w=316&h=197&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2";
let i = ref(0);
function add(){
	i.value ++;
}
function dec(){
	i.value --;
}


let firstname = ref("三");
let lastname = ref("张");

let fullname = computed(()=>{
	return lastname.value + firstname.value;
});


</script>
	

<template>
	<h1 class="ref">{{msg}}</h1>
	<h2 class="reactive">{{user.name}}</h2>
	<img :src="path">
	<h2>{{i}}</h2>
	<button class="btngreen" value="+111" @click="add"></button>
	<button class="btnred" value="-1" @click="dec"></button>
	<h2>computed</h2>
	<h2>{{fullname}}</h2>
</template>

<style>

.ref{
	color: lightcoral;
}

.reactive{
	color: deepskyblue;
}

.btngreen{
	color: black;
	background-color: lightgreen;
}
.btnred{
	color: black;
	background-color: lightsalmon;
}
</style>