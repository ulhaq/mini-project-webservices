<template>
  <div class="row justify-content-center">
    <div class="col-md-12">
      <div class="card card-default">
        <div class="card-header">Details of {{ student.name }}</div>

        <div class="card-body">
          <table class="table">
            <tr>
              <th scope="col">#</th>
              <td scope="row">{{ student.id }}</td>
            </tr>
            <tr>
              <th scope="col">Name</th>
              <td>{{ student.name }}</td>
            </tr>
            <tr>
              <th scope="col">Email</th>
              <td>{{ student.email }}</td>
            </tr>
            <tr>
              <th scope="col">Messages</th>
              <td scope="col">
                <select multiple class="form-control">
                  <option v-for="message in student.messages" :key="message.id">{{ message.text }}</option>
                </select>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <router-link :to="{name: 'editStudent', params: {id: student.id}}" class="btn btn-info">Edit</router-link>
              </td>
            </tr>
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
      student: {
        id: this.$route.params.id
      }
    };
  },
  mounted() {
    this.axios.get(`http://localhost:8080/students/${this.$route.params.id}`).then(response => {
      this.student = response.data;
    });
  }
};
</script>