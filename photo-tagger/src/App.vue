<template>
    <div id="app">
        <header>
            <h1>Photo Tagger</h1>
        </header>
        <main>
            <div class="content">
                <router-view/>
            </div>
        </main>
    </div>
</template>

<script>
    export default {
        name: 'app',
    }
</script>

<style>
    #app {
        background-color: #cd4851;
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        display: flex;
        height: 100%;
        flex-direction: column;
    }

    html, body {
        height: 100%;
        margin: 0;
        padding: 0;
    }

    h1 {
        color: #FFFFFF;
    }

    header {
        padding: 25px;
    }
</style>
