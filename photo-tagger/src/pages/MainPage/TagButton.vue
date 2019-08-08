<template>
    <div id="buttons">
        <div aria-label="Basic example" role="group">
            <button class="buttonController"
                    id="btn1" name="Tag"
                    type="button" v-on:click="putTag('Dış Cephe')"
                    value="Dış Cephe"> Dış Cephe
            </button>
            <button class="buttonController"
                    id="btn2" name="Tag"
                    type="button" v-on:click="putTag('Mutfak')" value="Mutfak"> Mutfak
            </button>
            <button class="buttonController"
                    id="btn3" name="Tag"
                    type="button" v-on:click="putTag('Banyo')" value="Banyo"> Banyo
            </button>
        </div>
        <div aria-label="Basic example" role="group">
            <button class="buttonController"
                    id="btn4"
                    name="Tag"
                    type="button" v-on:click="putTag('Yatak Odası')" value="Yatak Odası">
                Yatak Odası
            </button>
            <button class="buttonController"
                    id="btn5" name="Tag"
                    type="button" v-on:click="putTag('Balkon')" value="Balkon"> Balkon
            </button>
            <button class="buttonController"
                    id="btn6" name="Tag"
                    type="button" v-on:click="putTag('Antre')" value="Antre"> Antre
            </button>
        </div>
        <div aria-label="Basic example" role="group">
            <button class="buttonController"
                    id="btn7" name="Tag"
                    type="button" v-on:click="putTag('Havuz')" value="Havuz"> Havuz
            </button>
            <button class="buttonController"
                    id="btn8" name="Tag"
                    type="button" v-on:click="putTag('Villa')" value="Villa"> Villa
            </button>
            <button class="buttonController"
                    id="btn9" name="Tag"
                    type="button" v-on:click="putTag('Bahçe')" value="Bahçe"> Bahçe
            </button>
        </div>
        <button @click="logout" class="buttonController"> Log out</button>
    </div>


</template>

<script>
    export default {
        name: "TagButtons",
        methods: {
            putTag(tag) {
                this.$emit('putTag', tag)
            },

            logout() {
                this.$emit('logout');
            }

        }
    }

</script>

<style scoped>
    .buttonController {
        width: 130px;
        height: 30px;
        margin-top: 5px;
        background: #cd4851;
        color: white;
        transition: all .3s ease-in-out;
        border-color: #cd4851;
        user-select: none;
        outline: none;
        border-radius: 10px;

    }

    .buttonController:hover {
        transform: scale(0.9);
        box-shadow: 1px 1px 0px black;
        transition: all .3s ease-in-out;
        background: #d35f67;
        color: white;
        border-color: #d35f67;
        user-select: none;
        outline: none;
    }
</style>
