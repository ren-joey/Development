<template>
    <div id="app">
        <img src="./assets/logo.png">
        <router-view/>
    </div>
</template>

<script>
export default {
    name: 'App'
};
</script>

<style lang="scss">
    @import '@/styles/element-variables.scss';
    @import '@/styles/z-index.scss';
    @import '@/styles/global.scss';

// #app {
//     font-family: "Avenir", Helvetica, Arial, sans-serif;
//     -webkit-font-smoothing: antialiased;
//     -moz-osx-font-smoothing: grayscale;
//     text-align: center;
//     color: #2c3e50;
//     margin-top: 60px;
// }

</style>
