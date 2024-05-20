<!-- got helped by GPT and Copilot & previous exersices -->

<script>
export default {
	props: {
		id: Number,
		required: true,
	},
	methods: {
		deleteCategory(id) {
			fetch(`http://localhost:1234/categories/${id}`, {
				method: "DELETE",
			}).then(() => {
				this.$emit("category deleted", id);
				this.$router.go();
			});
		},
	},
};
</script>

<template>
	<div>
		<button @click="deleteCategory(id)">Delete</button>
	</div>
</template>
