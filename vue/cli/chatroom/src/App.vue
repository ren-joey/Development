<template>
<div id="app">
    <nav class="navbar navbar-expand-lg navbar-light bg-light"> <a class="navbar-brand" href="#">Navbar</a> <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                <li class="nav-item">
                    <router-link class="nav-link" :to="'/'">Hello1</router-link>
                </li>
                <li class="nav-item">
                    <router-link class="nav-link" :to="'/Hello2'">Hello2</router-link>
                </li>
                <li class="nav-item">
                    <router-link class="nav-link" :to="'/chatroom'">聊天室</router-link>
                </li>
            </ul>
        </div>
    </nav>
    <router-view />
</div>
</template>

<script>
export default {
    name: "App"
};
</script>

<style lang="scss">
@import "~bootstrap/scss/bootstrap";

#app {
    font-family: "Avenir", Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}
</style>
