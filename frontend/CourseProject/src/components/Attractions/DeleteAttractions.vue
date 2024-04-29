<!-- got helped by GPT and Copilot & previous exersices -->

<script>
export default {
	props: {
		id: Number,
		required: true,
	},
	methods: {
		deleteAttraction(id) {
			fetch(`http://localhost:1234/attractions/${id}`, {
				method: "DELETE",
			}).then(() => {
				this.$emit("attraction-deleted", id);
				this.$router.go();
			});
		},
	},
};
</script>

<template>
	<div>
		<button @click="deleteAttraction(id)">Delete</button>
	</div>
</template>
