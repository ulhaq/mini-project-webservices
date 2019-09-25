<template>
  <div class="row justify-content-center">
    <div class="col-md-12">
      <div class="card card-default">
        <div class="card-header">Welcome</div>

        <div class="card-body">
          <table class="table">
            <tbody>
              <tr>
                <td>
                  <div class="row text-center">
                    <div class="col-md-6 divider">
                      <h3>Login as...</h3>
                      <select v-model="selected" @change="login($event)">
                        <option
                          v-for="student in students"
                          :key="student.id"
                          :value="student.id"
                        >{{ student.name }}</option>
                      </select>
                    </div>
                    <div class="col-md-6">
                      <h3>Statistics</h3>
                      <p>Total Users: {{ stats.users }}</p>
                      <p>Total Messages: {{ stats.messages }}</p>
                      <p>Total Comments: {{ stats.comments }}</p>
                    </div>
                  </div>
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
      students: [],
      selected: "",
      stats: {
        users: 0,
        messages: 0,
        comments: 0
      }
    };
  },
  mounted() {
    this.axios.get("http://localhost:8080/students/").then(response => {
      this.students = response.data;
    });

    let xmls = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tns="http://localhost:8081/stats"><soapenv:Header/><soapenv:Body><tns:getStatsRequest/></soapenv:Body></soapenv:Envelope>';
    this.axios.post("http://localhost:8081/ws/stats.wsdl", xmls, {
      headers: { "Content-Type": "text/xml" }
    })
    .then(response => {
      let parser = require("fast-xml-parser");

      let jsonObj = parser.convertToJson(parser.getTraversalObj(response.data));

      this.stats.users = jsonObj['SOAP-ENV:Envelope']['SOAP-ENV:Body']['ns3:getStatsResponse']['users'];
      this.stats.messages = jsonObj['SOAP-ENV:Envelope']['SOAP-ENV:Body']['ns3:getStatsResponse']['messages'];
      this.stats.comments = jsonObj['SOAP-ENV:Envelope']['SOAP-ENV:Body']['ns3:getStatsResponse']['comments'];
    })
    .catch(err => {
      console.log(err);
    });
  },
  methods: {
    login() {
      localStorage.studentId = event.target.value;
      this.$router.push({ name: "indexMessage" });
    }
  }
};
</script>

<style>
.divider {
  border-right: 2px solid #dee2e6;
}
</style>