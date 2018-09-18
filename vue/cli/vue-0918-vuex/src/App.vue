<template>
<div id="app">
    <nav class="navbar navbar-expand-lg navbar-light bg-light"> <a class="navbar-brand" href="#">Navbar</a> <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <router-link class="nav-link" :to="'/'">Home<span class="sr-only">(current)</span></router-link>
                </li>
                <li class="nav-item">
                    <router-link class="nav-link" :to="'/pages'">Users</router-link>
                </li>
                <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Dropdown </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown"> <a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div> <a class="dropdown-item" href="#">Something else here</a> </div>
                </li>
                <li class="nav-item"> <a class="nav-link disabled" href="#">Disabled</a> </li>
            </ul>
            <!-- <form class="form-inline my-2 my-lg-0"> <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"> <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button> </form> -->
            <div class="form-inline mr-3">
                <select name="" id="" class="form-control" @change="changeStatus()" v-model="status">
                    <option value="ONLINE">ONLINE</option>
                    <option value="OFFLINE">OFFLINE</option>
                </select>
            </div>
            <div class="navbar-text">
                Hi, {{showUsername}}
            </div>
        </div>
    </nav>
    <!-- <img src="./assets/logo.png"> -->
    <!-- vuex -->
    <router-view @pushNewName="getNewName" />
</div>
</template>

<script>
export default {
    name: 'App',
    data() {
        return {
            // vuex
            status: this.$store.state.status,
            username: ''
        }
    },
    methods: {
        changeStatus() {
            this.$store.state.status = this.status;
        },
        getNewName(newName) {
            let vm = this;
            vm.username = newName;
        }
    },
    mounted() {
        this.changeStatus();
    },
    computed: {
        showUsername() {
            return this.$store.state.username
        }
    }
}
</script>

<style lang="scss">
@import '~bootstrap/scss/bootstrap'
</style>
