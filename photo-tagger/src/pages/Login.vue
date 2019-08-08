<template>
    <div id="login">
        <form class="form-horizontal" role="form">
            <div class="form-group centered">
                <form @submit.prevent="login()">
                    <input v-model="username" id="user-name" class="text-area center-block form-control"
                           name="user-name"
                           type="text"
                           placeholder="Enter Your Name"/>
                </form>
            </div>
        </form>

    </div>
</template>

<script>
    import 'bootstrap/dist/css/bootstrap.css'
    import 'bootstrap-vue/dist/bootstrap-vue.css'
    import Vue from 'vue'
    import BootstrapVue from 'bootstrap-vue'
    import axios from 'axios'
    import service from '../service/LoginPageService'

    Vue.use(axios);
    Vue.prototype.axios = axios;
    Vue.use(BootstrapVue);
    export default {
        name: "login",
        data: function () {
            return {
                username: "",
            }
        },
        methods: {
            login() {
                service.login(this.username).then(response => {
                    this.$cookies.config('10s');
                    this.$cookies.set("userName", response.data);
                    this.$router.push({path: '/'});
                    // eslint-disable-next-line no-console,no-unused-vars
                }).catch(error => {
                    // eslint-disable-next-line no-console
                    console.log(error);
                })
            },

        },
    }

</script>

<style scoped>
    .text-area {
        width: 400px;
        margin-top: 10px;
        margin-bottom: 10px;
    }

    .center-block {
        display: table; /* Instead of display:block */
        margin-left: auto;
        margin-right: auto;
    }

    .centered {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -100%);
    }

</style>
