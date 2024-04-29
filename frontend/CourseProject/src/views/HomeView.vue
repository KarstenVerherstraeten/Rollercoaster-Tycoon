<script>
import Attractions from "@/components/Attractions/ShowAttractions.vue";
export default {
	components: {
		Attractions,
	},
};
</script>

<template>
	<main>
		<div class="header">
			<h1>Rollercoasters</h1>
			<router-link to="/create">Create</router-link>
		</div>

		<Attractions />
	</main>
</template>
