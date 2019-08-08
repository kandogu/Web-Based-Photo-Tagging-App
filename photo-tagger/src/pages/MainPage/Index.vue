<template>
    <div>
        <div id="mainpage" key="end-of-program" v-if="flag">
            <my-picture :src="picAdr"></my-picture>
            <text-input @putTagText="putTag"></text-input>
            <tag-button @logout="logout" @putTag="putTag"></tag-button>
        </div>
        <div key="end-of-program" v-else>
            <h2 id="no-img-msg"> {{ noImgMsg }} </h2>
        </div>
    </div>
</template>

<script>
    import Vue from 'vue'
    import BootstrapVue from 'bootstrap-vue'
    import 'bootstrap/dist/css/bootstrap.css'
    import 'bootstrap-vue/dist/bootstrap-vue.css'
    import axios from 'axios'
    import service from '../../service/MainPageService'
    import TagButton from './TagButton'
    import TextInput from './TextInput'
    import Picture from './Picture'


    Vue.use(axios);
    Vue.prototype.axios = axios;
    Vue.use(BootstrapVue);


    export default {
        name: "Index",
        data: function () {
            return {
                id: "",
                picAdr: "",
                flag: true,
                noImgMsg: "There are no more images to show"
            };
        },


        components: {
            'tagButton': TagButton,
            'textInput': TextInput,
            'myPicture': Picture
        },


        mounted: function () {
            this.getPic();
            if (this.$cookies.get("userName") == null) {
                this.$router.push({path: "login"})
            }
        },
        methods: {

            getPic() {
                if (this.$cookies.get("userName") != null) {
                    service.getPic(this.$cookies.get("userName")).then(response => {
                        if (response.data.id == null) {
                            this.flag = false;
                        } else {
                            this.flag = true;
                            this.picAdr = response.data.address;
                            this.id = response.data.id;
                        }
                    })
                }
            },

            putTag(tag) {
                if (this.$cookies.get("userName") != null) {
                    service.putTag(this.id, tag).then(response => {
                        // eslint-disable-next-line no-console
                        console.log(response);
                        this.getPic();
                    });
                } else {
                    this.$router.push({path: "login"})
                }

            },

            logout() {
                if (this.$cookies.get("userName") != null) {
                    service.delete(this.$cookies.get("userName"));
                    this.$cookies.remove("userName");
                }
                this.$router.push("/login");
            }
        },
    }
</script>

<style scoped>

    #no-img-msg {
        color: #FFFFFF;
    }

</style>

