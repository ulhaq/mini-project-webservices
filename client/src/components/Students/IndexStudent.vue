<template>
  <div class="row justify-content-center">
    <div class="col-md-12">
      <div class="card card-default">
        <div class="card-header">All Students</div>

        <div class="card-body">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="student in students" :key="student.id">
                <th scope="row">{{ student.id }}</th>
                <td>
                  <router-link :to="{name: 'getStudent', params: {id: student.id}}" class="nav-link">{{ student.name }}</router-link>
                </td>
                <td>{{ student.email }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      students: []
    };
  },
  mounted() {
    this.axios.get("http://localhost:8080/students/").then(response => {
      this.students = response.data;
    });
  }
};
</script>