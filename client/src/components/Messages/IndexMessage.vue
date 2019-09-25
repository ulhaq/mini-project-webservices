<template>
  <div class="row justify-content-center">
    <div class="col-md-12">
      <div class="card card-default">
        <div class="card-header">All Messages</div>

        <div class="card-body">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Text</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="message in messages" :key="message.id">
                <th scope="row">{{ message.id }}</th>
                <td>
                  <router-link :to="{name: 'getMessage', params: {id: message.id}}" class="nav-link">{{ message.text }}</router-link>
                </td>
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
      messages: []
    };
  },
  mounted() {
    this.axios.get("http://localhost:8080/messages/").then(response => {
      this.messages = response.data;
    });
  }
};
</script>