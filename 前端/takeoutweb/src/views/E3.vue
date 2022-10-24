<script setup lang="ts">

import axios  from '../api/request'

async function getBook(){
	let resp = await axios.get('customer/123');
	console.log(resp.data);
}
getBook();
</script>

<template>
aaa
</template>