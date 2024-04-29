<script>
export default {
	data() {
		return {
			name: "",
			description: "",
			errorMessage: "",
		};
	},
	methods: {
		createAttraction() {
			if (this.name && this.description) {
				fetch("http://localhost:1234/attractions", {
					method: "POST",
					body: JSON.stringify({
						name: this.name,
						description: this.description,
					}),
					headers: {
						"Content-Type": "application/json",
					},
				}).then(() => {
					this.$router.go();
				});
			} else {
				this.errorMessage = "Please fill in all fields.";
			}
		},
	},
};
</script>

<template>
	<form action="">
		<label for="name">Name</label>
		<input type="text" id="name" v-model="name" />
		<label for="description">Description</label>
		<input type="text" id="description" v-model="description" />
		<button @click="createAttraction()">Create</button>
		<p v-if="errorMessage">{{ errorMessage }}</p>
	</form>
</template>
