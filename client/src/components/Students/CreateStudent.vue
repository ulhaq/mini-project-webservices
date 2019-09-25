<template>
  <div>
    <div class="row justify-content-center">
      <div class="col-md-12">
        <div class="card card-default">
          <div class="card-header">Create a Student</div>

          <div class="card-body center">
            <form @submit.prevent="storeStudent">
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
      student: {
        name: "",
        email: ""
      }
    };
  },
  methods: {
    storeStudent() {
      this.axios.post("http://localhost:8080/students/", this.student).then(() => {
        this.$router.push({ name: "indexStudent" });
      });
    }
  }
};
</script>