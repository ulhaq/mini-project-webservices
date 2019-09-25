<template>
  <div class="row justify-content-center">
    <div class="col-md-12">
      <div class="card card-default">
        <div class="card-header">Details of Message #{{ message.id }}</div>

        <div class="card-body">
          <table class="table">
            <tr>
              <td>{{ message.text }}
                <br />
                <router-link :to="{name: 'editMessage', params: {id: message.id}}" class="btn btn-info">Edit</router-link>
              </td>
            </tr>
            <tr>
              <td>
                <div v-for="comment in message.comments" :key="comment.id">{{ comment.text }}</div>
              </td>
            </tr>
            <tr>
              <td>
                <form @submit.prevent="storeComment">
                  <div class="row">
                    <div class="col-md-10">
                      <input type="text" class="form-control" v-model="newComment.text" required />
                    </div>
                    <div class="col-md-2">
                      <button class="btn btn-primary">Add Comment</button>
                    </div>
                  </div>
                </form>
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
      message: {
        id: this.$route.params.id
      },
      newComment: {
        student_id: localStorage.studentId,
        message_id: this.$route.params.id,
        text: ""
      }
    };
  },
  mounted() {
    this.getMessage();
  },
  methods: {
    getMessage() {
      this.axios.get(`http://localhost:8080/messages/${this.$route.params.id}`).then(response => {
        this.message = response.data;
      });
    },
    storeComment() {
      this.axios.post("http://localhost:8080/comments/", this.newComment).then(() => {
        this.getMessage();
        this.newComment.text = "";
      });
    }
  }
};
</script>