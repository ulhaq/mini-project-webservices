<template>
  <div>
    <div class="row justify-content-center">
      <div class="col-md-12">
        <div class="card card-default">
          <div class="card-header">Edit a Student</div>

          <div class="card-body">
            <form @submit.prevent="updateStudent">
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Student Name:</label>
                    <input type="text" class="form-control" v-model="student.name" required />
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Student Email:</label>
                    <input type="text" class="form-control" v-model="student.email" required />
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
      student: {}
    };
  },
  mounted() {
    this.axios.get(`http://localhost:8080/students/${this.$route.params.id}`).then(response => {
      this.student = response.data;
    });
  },
  methods: {
    updateStudent() {
      this.axios.put(`http://localhost:8080/students/${this.$route.params.id}`, this.student).then(() => {
        this.$router.push({ name: "indexStudent" });
      });
    }
  }
};
</script>