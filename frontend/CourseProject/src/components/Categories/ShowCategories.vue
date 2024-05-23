<script>
import Category from "./Category.vue";
import DeleteCategories from "./DeleteCategories.vue";
import EditCategory from "./EditCategory.vue";

export default {
	components: {
		Category,
		DeleteCategories,
		EditCategory,
	},
	data() {
		return {
			Categories: [],
		};
	},
	methods: {
		async getCategories() {
			const currentComponent = this;
			fetch("http://localhost:1234/categories")
				.then(function (response) {
					return response.json();
				})
				.then(function (data) {
					currentComponent.Categories = data;
				});
		},
	},
	mounted() {
		this.getCategories();
		console.log("mounted Categories");
	},
};
</script>

<template>
	<div class="Categories">
		<div class="category" v-for="category in Categories" :key="category.id">
			<div class="category-details">
				<h3>{{ category.name }}</h3>
			</div>
			<div class="categoryButton">
				<EditCategory :id="category.id" :name="category.name" @category-edited="handleCategoryEdited" />
				<DeleteCategories :id="category.id" @category-deleted="handleCategoryDeleted"></DeleteCategories>
			</div>
		</div>
	</div>
</template>
