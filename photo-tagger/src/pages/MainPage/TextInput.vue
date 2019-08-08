<template>
    <form @submit.prevent="putTag(customTag), clear()" id="textInput">
        <b-form-input class="center-block text-area" v-model="customTag"></b-form-input>
    </form>
</template>

<script>
    export default {
        name: "TextInput",
        data: function () {
            return {
                customTag: ""
            }
        },
        methods: {
            putTag(tag) {
                this.$emit("putTagText", tag)
            },
            //clears input text are for each input
            clear() {
                this.customTag = "";
            },
        }

    }
</script>

<style scoped>
    .center-block {
        display: table; /* Instead of display:block */
        margin-left: auto;
        margin-right: auto;
    }

    .text-area {
        width: 400px;
        margin-top: 10px;
        margin-bottom: 10px;
    }
</style>
