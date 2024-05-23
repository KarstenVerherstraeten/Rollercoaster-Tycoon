<script>
export default {
	props: {
		id: Number,
		name: String,
		description: String,
	},
	data() {
		return {
			editedName: "",
			editedDescription: "",
			editedBuildyear: "",
			editedCapacity: "",
			editedMinHeight: "",
			editedMaxHeight: "",
			isEditMode: false,
			errorMessage: "",
		};
	},
	methods: {
		editAttraction(id) {
			if (this.editedName && this.editedDescription && this.editedBuildyear && this.editedCapacity && this.editedMinHeight && this.editedMaxHeight) {
				fetch(`http://localhost:1234/attractions/${id}`, {
					method: "PUT",
					body: JSON.stringify({
						name: this.editedName,
						description: this.editedDescription,
					}),
					headers: {
						"Content-Type": "application/json",
					},
				}).then(() => {
					this.$emit("attraction-edited", { id: id, name: this.editedName, description: this.editedDescription, buildyear: this.editedBuildyear, capacity: this.editedCapacity, minHeight: this.editedMinHeight, maxHeight: this.editedMaxHeight, fastpass: this.fastpass});
					this.$router.go();
				});
			} else {
				this.errorMessage = "Please fill in all fields";
			}
		},
		enterEditMode() {
			console.log("enterEditMode");
			this.isEditMode = true;
			this.editedName = "";
			this.editedDescription = "";
			this.editedBuildyear = "";
			this.editedCapacity = "";
			this.editedMinHeight = "";
			this.editedMaxHeight = "";
			this.errorMessage = "";
		},
		cancelEditMode() {
			this.isEditMode = false;
			this.editedName = this.name; // Reset editedName to the original name
			this.editedDescription = this.description; // Reset editedDescription to the original description
			this.editedBuildyear = this.buildyear;
			this.editedCapacity = this.capacity;
			this.editedMinHeight = this.minHeight;
			this.editedMaxHeight = this.maxHeight;
			this.errorMessage = "";
		},
	},
};
</script>

<template>
	<div>
		<div v-if="isEditMode" class="editButtons">
			<div>
				<input v-model="editedName" placeholder="Naam:" type="text" />
				<input v-model="editedDescription" placeholder="Beschrijving:" type="text" />
				<input v-model="editedBuildyear" placeholder="Bouwjaar:" type="number" />
				<input v-model="editedCapacity" placeholder="Capaciteit:" type="number" />
				<input v-model="editedMinHeight" placeholder="Minimale lengte:" type="number" />
				<input v-model="editedMaxHeight" placeholder="Maximale lengte:" type="number" />
			</div>
			<div>
				<button @click="editAttraction(id)">Save</button>
				<button @click="cancelEditMode()">Cancel</button>
			</div>
			<p v-if="errorMessage">{{ errorMessage }}</p>
		</div>
		<div v-else>
			<!-- Display editedName and editedDescription when in edit mode -->
			<!-- <p>{{ editedName }}</p>
        <p>{{ editedDescription }}</p> -->

			<!-- gaat niet weg na calcel -->
			<button @click="enterEditMode()">Edit</button>
		</div>
	</div>
</template>
