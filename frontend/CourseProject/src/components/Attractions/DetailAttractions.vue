<template>
	<div class="DetailPage">
		<div v-if="selectedAttraction">
			<h1>{{ selectedAttraction.name }}</h1>

			<div>
				<p><strong>Video:</strong></p>
				<iframe
					width="100%"
					height="356"
					:src="`${selectedAttraction.video}`"
					title="YouTube video player"
					frameborder="0"
					allowfullscreen
				></iframe>
			</div>
			<div>
				<p><strong>Description:</strong> {{ selectedAttraction.description }}</p>
				<p><strong>Build Year:</strong> {{ selectedAttraction.buildyear }}</p>
				<p><strong>Category:</strong> {{ selectedAttraction.categoryName }}</p>
				<p><strong>Capacity:</strong> {{ selectedAttraction.capacity }}</p>
				<p><strong>Minimum Height:</strong> {{ selectedAttraction.minHeight }}</p>
				<p><strong>Maximum Height:</strong> {{ selectedAttraction.maxHeight }}</p>
				<p><strong>Fastpass:</strong> {{ selectedAttraction.fastpass ? "Yes" : "No" }}</p>
				<p><strong>breakdowns:</strong> {{ selectedAttraction.breakdowns.length }}</p>
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
.DetailPage {
	max-width: 800px;
	margin: 0 auto;
	padding: 20px;
	background-color: #1b1b38;
	border-radius: 15px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
}

.DetailPage h1 {
	color: #d0e2ff;
	font-size: 2.5em;
	margin-bottom: 20px;
	text-align: center;
}

.attraction-details {
	background-color: #282a36;
	border-radius: 10px;
	padding: 20px;
}

.attraction-details p {
	margin: 10px 0;
	font-size: 1.2em;
}

.attraction-details strong {
	color: #d0e2ff;
}

.loading {
	text-align: center;
	font-size: 1.5em;
	color: #d0e2ff;
}
</style>
