<script>

import Category from './Category.vue';
import DeleteCategories from './DeleteCategories.vue';



export default {
    components: {
        Category,
        DeleteCategories,
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
            <DeleteCategories :id="category.id" @category-deleted="handleCategoryDeleted"></DeleteCategories>
        </div>
    </div>
</template>