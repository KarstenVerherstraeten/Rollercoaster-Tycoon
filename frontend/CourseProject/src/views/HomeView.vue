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
			<h1>Attracties</h1>
			<router-link to="/create">Voeg attractie toe</router-link>
		</div>
		<div class="blueRectangle">
			<div class="content-wrapper">
				<Attractions />
			</div>
		</div>
	</main>
</template>
