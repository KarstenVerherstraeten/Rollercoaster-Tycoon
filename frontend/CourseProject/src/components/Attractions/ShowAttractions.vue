<!-- got helped by GPT and Copilot & previous exersices -->

<script>
import Attraction from "./Attraction.vue";
import DeleteAttracions from "./DeleteAttractions.vue";
import EditAttraction from "./EditAttraction.vue";

export default {
	components: {
		Attraction,
		DeleteAttracions,
		EditAttraction,
	},
	data() {
		return {
			Attractions: [],
		};
	},
	methods: {
		async getAttractions() {
			const currentComponent = this;
			fetch("http://localhost:1234/attractions")
				.then(function (response) {
					return response.json();
				})
				.then(function (data) {
					currentComponent.Attractions = data;
				});
		},
		handleAttractionDeleted(deletedID) {
			this.Attractions = this.Attractions.filter((attraction) => attraction.id !== deletedID);
		},
		handelAttrationEdited(editedAttraction) {
			this.Attractions = this.Attractions.map((attraction) => {
				if (attraction.id === editedAttraction.id) {
					return editedAttraction;
				}
				return attraction;
			});
		},
	},
	mounted() {
		this.getAttractions();
		console.log("mounted Attractions");
	},
};
</script>

<template>
	<div class="Attractions">
		<div class="attraction" v-for="attraction in Attractions" :key="attraction.id">
			<div class="attraction-details">
				<h3>{{ attraction.name }}</h3>
				<p>{{ attraction.description }}</p>
			</div>
			<div class="attraction-actions">
				<DeleteAttracions :id="attraction.id" @attraction-deleted="handleAttractionDeleted"></DeleteAttracions>
				<EditAttraction :id="attraction.id" :name="attraction.name" :description="attraction.description" @attraction-edited="handelAttrationEdited"></EditAttraction>
			</div>
		</div>
	</div>
</template>

<style></style>
