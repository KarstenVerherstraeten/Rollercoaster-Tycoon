<script>
export default {
	data() {
		return {
			attraction: {
				name: "",
				description: "",
				buildYear: "",
				categoryName: "",
				capacity: "",
				minHeight: "",
				maxHeight: "",
				fastpass: false,
				disabled: false,
				picture: "",
				video: "",
			},
			categories: []
		};
	},
	created() {
		this.fetchCategories();
	},
	methods: {
		async fetchCategories() {
			try {
				const response = await fetch("http://localhost:1234/categories");
				if (!response.ok) {
					throw new Error("Failed to fetch categories");
				}
				const data = await response.json();
				this.categories = data.map(category => category.name); // Assume each category object has a 'name' property
			} catch (error) {
				console.error("Error fetching categories:", error);
			}
		},
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
				<label for="buildYear">Buildyear:</label>
				<input type="number" id="buildYear" v-model="attraction.buildYear" required />
			</div>
			<div class="form-group">
				<label for="category">Category:</label>
				<select id="category" v-model="attraction.categoryName" required>
					<option v-for="category in categories" :key="category" :value="category">
						{{ category }}
					</option>
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
				<input type="checkbox" id="fastpass" v-model="attraction.fastpass" />
			</div>
			<div class="form-group">
				<label for="url">Photo URL:</label>
				<input type="url" id="url" v-model="attraction.picture" placeholder="https://image.com" pattern="https://.*" size="30" required />
			</div>
			<div class="form-group">
				<label for="url1">Video URL:</label>
				<input type="url" name="url1" id="url1" v-model="attraction.video" placeholder="https://video.com" pattern="https://.*" size="30" required />
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
