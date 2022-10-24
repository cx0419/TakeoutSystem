<script setup lang="ts">
import {useMouse,useCounter,useStorage, useRafFn}  from "@vueuse/core"


const {x,y} = useMouse();

const {count,inc,dec} = useCounter();

let a =  useStorage('name',"");

</script>


<template>
	<div>{{x}}</div>
	<div>,</div>
	<div>{{y}}</div>
	<div>value:{{count}}</div>
	<input type="text" @click="inc()" value="+">
	<input type="text" @click="dec()" value="-">
	<input type="text" v-model="a">
</template>



<style>

</style>