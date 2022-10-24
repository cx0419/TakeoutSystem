<template>
<div>100</div>
<person :src="user.src" :name="user.name" :age="user.age">

</person>
</template>


<script lang="ts" setup>
import person from '../components/person.vue'
import {ref} from 'vue'
let user = ref(
	{
		name:"java",
		src:"https://ts3.cn.mm.bing.net/th?id=OIP-C.atTl-J5TF3GE5FWfRtTIygHaJ8&w=215&h=289&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2",
		age:"12"
	}
)

</script>