<script>

import Categories from "@/components/Categories/ShowCategories.vue";

export default {
    components: {
        Categories,
    },
};
</script>

<template>
    <router-link to="/CreateCategory">Voeg categorie toe</router-link>
    <main>
        <Categories />
    </main>
</template>