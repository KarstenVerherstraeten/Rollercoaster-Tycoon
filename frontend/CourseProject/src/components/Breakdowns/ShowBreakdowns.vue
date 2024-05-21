<script>
import ResolveBreakdown from './ResolveBreakdown.vue';

export default{
    components:{
        ResolveBreakdown,
    },
    data(){
        return{
            Breakdowns: [],
        };
    },
    methods:{
        async getBreakdowns(){
            const currentComponent = this;
            fetch("http://localhost:1234/breakdowns")
                .then(function(response){
                    return response.json();
                })
                .then(function(data){
                    currentComponent.Breakdowns = data;
                });
        },
    },
    mounted(){
        this.getBreakdowns();
        console.log("mounted Breakdowns");
    },
}

</script>

<template>
    <div class="Breakdowns">
      <div class="breakdown" v-for="breakdown in Breakdowns" :key="breakdown.id">
        <div class="breakdown-details">
          <h3>Attraction name: {{ breakdown.attractionName }}</h3>
          <h3>Broken down on: {{ breakdown.date }}</h3>
          <h3 :class="{'resolved': breakdown.resolved, 'unresolved': !breakdown.resolved}">
            <span>Attraction is:</span> {{ breakdown.resolved ? 'operational' : 'broken' }}
          </h3>
        </div>
        <ResolveBreakdown v-if="!breakdown.resolved" :id="breakdown.id" @breakdown-resolved="handleBreakdownResolved"></ResolveBreakdown>
      </div>
    </div>
  </template>



<style scoped>
span{
    color: white;
}
.breakdown {
  margin-bottom: 20px;
}
.breakdown-details {
  margin-bottom: 10px;
}
button {
  margin-top: 10px;
}
.resolved {
  color: green;
}
.unresolved {
  color: red;
}
</style>