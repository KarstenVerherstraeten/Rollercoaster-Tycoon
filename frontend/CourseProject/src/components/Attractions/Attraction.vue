<script>
export default {
	props: {
		name: String,
		description: String,
		image: String,
	},
};
</script>

<template>
	<div class="Attraction">
		<!-- <div class="AttractionItem__image">
            <img :src="image" :alt="name" />
        </div> -->
		<div class="Attraction__content">
			<h2>{{ name }}</h2>
			<p>{{ description }}</p>
		</div>
	</div>
</template>
