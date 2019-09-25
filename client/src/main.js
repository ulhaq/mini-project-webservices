import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router';
import axios from 'axios';
import VueAxios from 'vue-axios';
import 'bootstrap/dist/css/bootstrap.min.css'
Vue.use(VueRouter);
Vue.use(VueAxios, axios);
Vue.config.productionTip = false;

import Index from './components/Index.vue';

import IndexStudent from './components/Students/IndexStudent.vue';
import GetStudent from './components/Students/GetStudent.vue';
import CreateStudent from './components/Students/CreateStudent.vue';
import EditStudent from './components/Students/EditStudent.vue';

import IndexMessage from './components/Messages/IndexMessage.vue';
import GetMessage from './components/Messages/GetMessage.vue';
import CreateMessage from './components/Messages/CreateMessage.vue';
import EditMessage from './components/Messages/EditMessage.vue';

Vue.mixin({
  mounted() {
    if (!localStorage.studentId && this.$route.name != "index") {
      router.push({ name: "index" });
    }
  }
})

const routes = [
  { name: 'index', path: '/', component: Index },

  { name: 'indexStudent', path: '/students', component: IndexStudent, },
  { name: 'createStudent', path: '/students/create', component: CreateStudent },
  { name: 'getStudent', path: '/students/:id', component: GetStudent },
  { name: 'editStudent', path: '/students/edit/:id', component: EditStudent },

  { name: 'indexMessage', path: '/messages', component: IndexMessage },
  { name: 'createMessage', path: '/messages/create', component: CreateMessage },
  { name: 'getMessage', path: '/messages/:id', component: GetMessage },
  { name: 'editMessage', path: '/messages/edit/:id', component: EditMessage },
];

const router = new VueRouter({ mode: 'history', routes: routes });

new Vue(Vue.util.extend({ router }, App)).$mount('#app');