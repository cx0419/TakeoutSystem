<script setup lang="ts">
import {reactive, ref,watch} from 'vue'
let user = ref({
	account:localStorage.getItem('name' ?? ""),
	password:''
})
watch(user.value,(newValue)=>{
	console.log(newValue.account);
	localStorage.setItem('name',newValue.account ?? "");
})
</script>

<template>
	<input v-model="user.account" type="text">

</template>

<style>


</style>