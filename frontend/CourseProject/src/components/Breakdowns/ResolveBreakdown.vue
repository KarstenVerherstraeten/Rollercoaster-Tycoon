<script>

export default{
    props:{
        id: Number,
        required: true,
    },
    methods: {
		resolveBreakdown(id) {
			fetch(`http://localhost:1234/breakdowns/${id}/resolve`, {
				method: "PATCH",
			}).then(() => {
				this.$emit("Breakdown resolved", id);
				this.$router.go();
			});
		},
	},
}


    
</script>


<template>
   <button @click="resolveBreakdown(id) ">Breakdown Resolved</button>
</template>