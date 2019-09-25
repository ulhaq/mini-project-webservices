<template>
  <div>
    <div class="row justify-content-center">
      <div class="col-md-12">
        <div class="card card-default">
          <div class="card-header">Edit a Message</div>

          <div class="card-body">
            <form @submit.prevent="updateMessage">
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Message Text:</label>
                    <textarea class="form-control" v-model="message.text" required></textarea>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <button class="btn btn-primary">Update</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      message: {}
    };
  },
  mounted() {
    this.axios.get(`http://localhost:8080/messages/${this.$route.params.id}`).then(response => {
      this.message = response.data;
    });
  },
  methods: {
    updateMessage() {
      this.axios.put(`http://localhost:8080/messages/${this.$route.params.id}`, this.message).then(() => {
        this.$router.push({ name: "indexMessage" });
      });
    }
  }
};
</script>