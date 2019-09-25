<template>
  <div>
    <div class="row justify-content-center">
      <div class="col-md-12">
        <div class="card card-default">
          <div class="card-header">New Message</div>

          <div class="card-body center">
            <form @submit.prevent="storeMessage">
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Message Text:</label>
                    <textarea class="form-control" v-model="message.text" required>
                    </textarea>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <button class="btn btn-primary">Create</button>
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
      message: {
        student_id: localStorage.studentId,
        text: ""
      }
    };
  },
  methods: {
    storeMessage() {
      this.axios.post("http://localhost:8080/messages/", this.message).then(() => {
        this.$router.push({ name: "indexMessage" });
      });
    }
  }
};
</script>