<script>
  export default {
    props: {
      attractionId: {
        type: Number,
        required: true
      }
    },
    methods: {
      reportBreakdown() {
        const requestBody = {
          attractionId: this.attractionId,
          date: new Date().toISOString()
        };
  
        fetch(`http://localhost:1234/breakdowns`, {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(requestBody)
        }).then(() => {
          this.$emit("breakdown-reported", this.attractionId);
        });
      }
    }
  };
  </script>
  

  <template>
    <button @click="reportBreakdown">Report Breakdown</button>
  </template>