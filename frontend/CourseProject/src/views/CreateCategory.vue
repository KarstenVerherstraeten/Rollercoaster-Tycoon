<script>
export default {
	data() {
		return {
			category: {
				name: "",
			},
		};
	},
	methods: {
		createCategory() {
			fetch("http://localhost:1234/categories", {
				method: "POST",
				body: JSON.stringify(this.category),
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
    <h1>Create a new category</h1>

    <form action="">
        <label for="name">Name</label>
        <input type="text" id="name" v-model="category.name" />
        <button @click="createCategory()">Create</button>
        <p v-if="errorMessage">{{ errorMessage }}</p>

    </form>
</template>