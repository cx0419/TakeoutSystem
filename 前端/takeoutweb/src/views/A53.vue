<template class="bac">
	<!-- <div class="color">容器53</div> -->
	<a-layout>
		<a-layout-header class="a-layout-header"></a-layout-header>
		<a-layout>
			<a-layout-sider class="a-layout-sider"></a-layout-sider>
			<a-layout-content class="a-layout-content">
				<router-view></router-view>
			</a-layout-content>
		</a-layout>
	</a-layout>
</template>


<style>
.bac{
	height: 100%;
	background-color: rgb(220, 225, 255);
	padding: 20px;
	box-sizing: border-box;
}
.color{
	color: aqua;
}
.a-layout-header{
	height: 50px;
	width: 300px;
	background-color: coral;
}
.a-layout-sider{
	height: 50px;
	width: 300px;
	background-color:aqua;
}
.a-layout-content{
	height: 50px;
	width: 300px;
	background-color:rgb(195, 190, 47);
}
</style>

