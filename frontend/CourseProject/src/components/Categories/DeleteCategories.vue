<!-- got helped by GPT and Copilot & previous exercises -->

<template>
	<div>
		<button @click="deleteCategory(id)">Delete</button>
		<div v-if="showError" class="error-popup">
			Cannot edit or delete category with attractions.
		</div>
	</div>
</template>

<script>
export default {
	props: {
		id: Number,
		required: true,
	},
	data() {
		return {
			showError: false,
		};
	},
	methods: {
		deleteCategory(id) {
			fetch(`http://localhost:1234/categories/${id}`, {
				method: "DELETE",
			})
				.then((response) => {
					if (response.ok) {
						this.$emit("category deleted", id);
						this.$router.go();
					} else {
						this.showError = true;
					}
				})
				.catch(() => {
					this.showError = true;
				});
		},
	},
};
</script>

<style>
.error-popup {
	background-color: red;
	color: white;
	padding: 10px;
	margin-top: 10px;
}
</style>
