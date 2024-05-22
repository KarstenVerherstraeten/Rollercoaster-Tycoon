<script>
import Categories from "@/components/Categories/ShowCategories.vue";

export default {
	components: {
		Categories,
	},
};
</script>

<template>
	<h1>Maak hier een categorie</h1>
	<router-link class="createCategoryButton" to="/CreateCategory">Voeg categorie toe</router-link>
	<main>
		<Categories />
	</main>
</template>
