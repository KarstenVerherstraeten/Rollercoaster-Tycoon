<script>
export default {
	props: {
		id: Number,
		name: String,
	},
	data() {
		return {
			editedName: "",
			isEditMode: false,
			errorMessage: "",
		};
	},
	methods: {
		editCategory(id) {
			if (this.editedName) {
				fetch(`http://localhost:1234/categories/${id}`, {
					method: "PUT",
					body: JSON.stringify({
						name: this.editedName,
					}),
					headers: {
						"Content-Type": "application/json",
					},
				}).then(() => {
					this.$emit("attraction-edited", { id: id, name: this.editedName });
					this.$router.go();
				});
			} else {
				this.errorMessage = "Please fill in all fields.";
			}
		},
		enterEditMode() {
			console.log("enterEditMode");
			this.isEditMode = true;
			this.editedName = "";
			this.errorMessage = "";
		},
		cancelEditMode() {
			this.isEditMode = false;
			this.editedName = this.name; // Reset editedName to the original name
			this.errorMessage = "";
		},
	},
};
</script>
<template>
	<div>
		<div v-if="isEditMode">
			<input v-model="editedName" type="text" />
			<button @click="editCategory(id)">Save</button>
			<button @click="cancelEditMode()">Cancel</button>
			<p v-if="errorMessage">{{ errorMessage }}</p>
		</div>
		<div v-else>
			<button @click="enterEditMode()">Edit</button>
		</div>
	</div>
</template>
