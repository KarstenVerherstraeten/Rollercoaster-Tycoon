<!-- got helped by GPT and Copilot & previous exersices -->

<script>
import DeleteAttracions from "./DeleteAttractions.vue";
import EditAttraction from "./EditAttraction.vue";
import picture from "../../assets/attractiePicture.jpg";
import ReportBreakdown from "../Breakdowns/ReportBreakdown.vue";

export default {
	components: {
		DeleteAttracions,
		EditAttraction,
		ReportBreakdown,
	},
	data() {
		return {
			Attractions: [],
			picture: picture,
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
		goToDetailPage(attraction) {
			// Navigeer naar de detailpagina met behulp van Vue Router
			this.$router.push({ name: "AttractionView", params: { id: attraction.id } });
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
			<div class="attraction-info">
				<img class="picture" :src="picture" alt="fotos" />
				<div class="info">
					<div class="attraction-name">
						<h3>{{ attraction.name }}</h3>
					</div>
				</div>
				<div class="Description">
					<h3>Beschrijving:</h3>
					<p>{{ attraction.description }}</p>
				</div>
			</div>

			<div class="attraction-actions">
				<div class="buttonsHome">
					<DeleteAttracions :id="attraction.id" @attraction-deleted="handleAttractionDeleted"></DeleteAttracions>
					<ReportBreakdown :attractionId="attraction.id" @breakdown-reported="handleBreakdownReported"></ReportBreakdown>
					<EditAttraction :id="attraction.id" :name="attraction.name" :description="attraction.description" @attraction-edited="handelAttrationEdited"></EditAttraction>
				</div>
				<div class="attraction-info2">
					<h3>Type:{{ attraction.categoryName }}</h3>
					<h3>Min height:{{ attraction.minHeight }}</h3>
					<h3>Max height:{{ attraction.maxHeight }}</h3>
				</div>
			</div>
			<button class="arrowButton" style="align-self: flex-end" @click="goToDetailPage(attraction)">
				<span class="material-symbols-outlined"> arrow_forward_ios </span>
				<router-link :to="{ name: 'AttractionView', params: { id: attraction.id } }">Bekijk details</router-link>
			</button>
		</div>
	</div>
</template>
