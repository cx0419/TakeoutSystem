<template>
	<div>name:{{name}}</div>
	<div>age:{{age}}</div>
	<img :src="avatar || 'vite.svg'"/>
</template>

<script setup lang="ts">
	defineProps<{name:string,age:string,avatar?:string}>()
</script>