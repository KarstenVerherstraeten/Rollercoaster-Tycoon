<script>
export default {
	data() {
		return {
			attraction: {
				name: "",
				description: "",
				buildyear: "",
				category: "",
				capacity: "",
				minHeight: "",
				maxHeight: "",
				categoryName: "",
				fastpass: false,
				disabled: false,
				picture: "", // Toegevoegd veld voor foto URL
			},
		};
	},
	methods: {
		createAttraction() {
			fetch("http://localhost:1234/attractions", {
				method: "POST",
				body: JSON.stringify(this.attraction),
				headers: {
					"Content-Type": "application/json",
				},
			}).then(() => {
				this.$router.push("/");
			});
		},
	},
};
</script>

<template>
	<div class="create-view">
		<h1>Create Attraction</h1>
		<form @submit.prevent="createAttraction">
			<div class="form-group">
				<label for="name">Name:</label>
				<input type="text" id="name" v-model="attraction.name" required />
			</div>
			<div class="form-group">
				<label for="description">Description:</label>
				<textarea id="description" v-model="attraction.description" required></textarea>
			</div>
			<div class="form-group">
				<label for="buildyear">Buildyear:</label>
				<input type="number" id="buidlyear" v-model="attraction.buildyear" required />
			</div>
			<div class="form-group">
				<label for="category">Category:</label>
				<select id="category" v-model="attraction.categoryName" required>
					<option value="Rollercoaster">Rollercoaster</option>
					<option value="water-ride">Water Ride</option>
					<option value="carousel">Carousel</option>
				</select>
			</div>
			<div class="form-group">
				<label for="capacity">Capacity:</label>
				<input type="number" id="capacity" v-model="attraction.capacity" required />
			</div>
			<div class="form-group">
				<label for="min-height">Minimum height:</label>
				<input type="number" id="min-height" v-model="attraction.minHeight" required />
			</div>
			<div class="form-group">
				<label for="max-height">Maximum height:</label>
				<input type="number" id="max-height" v-model="attraction.maxHeight" required />
			</div>
			<div class="form-group">
				<label for="fastpass">Fastpass:</label>
				<input type="checkbox" id="fastpass" v-model="attraction.fastpass" required />
			</div>
			<div class="form-group">
				<label for="url">Foto url:</label>
				<input type="url" id="url" v-model="attraction.picture" placeholder="https://image.com" pattern="https://.*" size="30" required />
			</div>
			<div class="form-group">
				<label for="url1">Video url:</label>
				<input type="url1" name="url1" id="url1" placeholder="https://video.com" pattern="https://.*" size="30" required />
			</div>
			<button type="submit">Create</button>
		</form>
	</div>
</template>

<style scoped>
.create-view {
	max-width: 400px;
	margin: 0 auto;
}

.form-group {
	margin-bottom: 1rem;
}

label {
	display: block;
	font-weight: bold;
}

input[type="text"],
textarea,
select {
	width: 100%;
	padding: 0.5rem;
	border: 1px solid #ccc;
	border-radius: 4px;
}

button[type="submit"] {
	padding: 0.5rem 1rem;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
</style>
