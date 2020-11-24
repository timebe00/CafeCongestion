import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import AddPlace from "../views/AddPlace.vue";
import Menu from "../views/Menu.vue";
import getOrder from "../views/manager/getOrder.vue";
import MenuUpdata from "../views/manager/MenuUpdata.vue";
import voidpage from "../views/manager/voidpage.vue";

import Login from "../views/register/Login.vue";
import Register from "../views/register/Register.vue";
import FindId from "../views/register/FindId.vue";
import FindPw from "../views/register/FindPw.vue";
import ShowId from "../views/register/ShowId.vue";
import HavePw from "../views/register/HavePw.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/menu",
    name: "Menu",
    components: {
      default: Menu
    },
    props: {
      default: true
    }
  },
  {
    path: "/order",
    name: "getOrder",
    component: getOrder
  },
  {
    path: "/menuupdata",
    name: "MenuUpdata",
    component: MenuUpdata
  },
    /////////////////////////////////////////////////////////////////////
  {
  path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/register',
        name: 'Register',
      component: Register
  },
  {
    path: '/login/findid',
        name: 'FindId',
      components: {
  default: FindId
  }
  },
  {
    path: '/login/findpw',
        name: 'FindPw',
      component: FindPw,
      props: true
  },
  {
    path: '/login/showid',
        name: 'ShowId',
      components: {
  default: ShowId
  },
    props: {
    default: true
    }
  },
  {
    path: '/login/havepw',
        name: 'HavePw',
      component: HavePw
  },
  {
    path: '/admin/addplace',
    name: 'AddPlace',
    component: AddPlace
  },
  {
    path: '/menu/voidpage',
    name: 'voidpage',
    component: voidpage
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
