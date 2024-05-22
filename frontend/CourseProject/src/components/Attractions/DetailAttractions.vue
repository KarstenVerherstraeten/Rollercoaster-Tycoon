<template>
	<div class="DetailPage">
		<div v-if="selectedAttraction">
			<h1>{{ selectedAttraction.name }}</h1>
			<div>
				<p><strong>Description:</strong> {{ selectedAttraction.description }}</p>
				<p><strong>Build Year:</strong> {{ selectedAttraction.buildyear }}</p>
				<p><strong>Category:</strong> {{ selectedAttraction.categoryName }}</p>
				<p><strong>Capacity:</strong> {{ selectedAttraction.capacity }}</p>
				<p><strong>Minimum Height:</strong> {{ selectedAttraction.minHeight }}</p>
				<p><strong>Maximum Height:</strong> {{ selectedAttraction.maxHeight }}</p>
				<p><strong>Fastpass:</strong> {{ selectedAttraction.fastpass ? "Yes" : "No" }}</p>
				<p><strong>Disabled:</strong> {{ selectedAttraction.disabled ? "Yes" : "No" }}</p>
			</div>
		</div>
		<div v-else>
			<p>Loading...</p>
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			selectedAttraction: null,
		};
	},
	created() {
		// Haal de attractie-id op uit de route-parameters
		const attractionId = this.$route.params.id;
		// Roep de methode getAttraction aan om de gegevens van de attractie op te halen
		this.getAttraction(attractionId).then((attraction) => {
			if (attraction) {
				this.selectedAttraction = attraction;
			} else {
				console.error("Attraction not found with ID:", attractionId);
			}
		});
	},
	methods: {
		async getAttraction(attractionId) {
			try {
				const response = await fetch(`http://localhost:1234/attractions/${attractionId}`);
				if (!response.ok) {
					throw new Error("Failed to fetch attraction");
				}
				const data = await response.json();
				return data;
			} catch (error) {
				console.error("Error fetching attraction:", error);
				return null;
			}
		},
	},
};
</script>

<style scoped>
/* Stijlen hier toevoegen */
</style>
