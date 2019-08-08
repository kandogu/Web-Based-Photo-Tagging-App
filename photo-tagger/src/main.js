import Vue from 'vue'
import App from './App.vue'
import VueRouter from "vue-router"
import Login from "./pages/Login";
import MainPage from "./pages/MainPage/Index";
import VueCookie from "vue-cookies";

Vue.config.productionTip = false;
Vue.use(VueRouter);
Vue.use(VueCookie);

const routes = [
  { path: '/login', component: Login },
  { path: '/', component: MainPage },
];
const cookies = [

];

const router = new VueRouter({
  routes, // short for routes: routes
  mode: 'history'
});
new Vue({
  router,
  cookies,
  render: h => h(App),
}).$mount('#app');

