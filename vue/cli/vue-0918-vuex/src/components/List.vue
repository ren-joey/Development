<template>
<div class="hello">
    <div class="container-fluid">
        <div class="d-flex">
            <div class="mt-4">
                <h6>Status: {{showStatus}}</h6>
            </div>
            <div class="form-inline ml-auto">
                <input type="text" class="form-control form-control-sm mr-1" v-model="username" @keyup.enter="updateUsername">
                <button class="btn btn-primary btn-sm" @click="updateUsername">更新姓名</button>
            </div>
        </div>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Photo</th>
                    <th scope="col">Full Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Todo</th>
                    <th scope="col">tools</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(item, i) in listData" :key="i" :class="{'active': item.selected}">
                    <th scope="row">{{i+1}}</th>
                    <td><img :src="item.picture.thumbnail" width="50" height="50" alt=""></td>
                    <td>{{item.name.first}} {{item.name.last}}</td>
                    <td>{{item.email}}</td>
                    <td>
                        <ul>
                            <li v-for="(item, i) in allTodos" :class="{'done': item.done}" :key="i">{{item.text}}</li>
                        </ul>
                    </td>
                    <td><button class="btn btn-sm" :class="{'btn-primary': !item.selected, 'btn-default': item.selected}" @click="clickMe(item)">click</button></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
</template>

<script>
import {mapGetters, mapMutations, mapState} from 'vuex';

export default {
    name: "HelloWorld",
    data() {
        return {
            msg: "Welcome to Your Vue.js App",
            listData: [],
            username: 'Joey'
        };
    },
    methods: {
        getData() {
            let vm = this;

            // Make a request for a user with a given ID
            vm.axios
                .get("https://randomuser.me/api/?results=50")
                .then(function (response) {
                    console.log(response);

                    vm.listData = response.data.results;

                    // 一開始不存在的資料
                    vm.listData.forEach((item) => {
                        vm.$set(item, 'selected', false);
                    });
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        updateUsername() {
            this.$store.state.username = this.username;
        },
        clickMe(item) {
            item.selected = !item.selected;
            console.log(item.selected);
        },
        mutationTest() {
            this.$store.commit('increment', 10);
            console.log(this.getCount);
        }
    },
    // vue 運行完成後自動執行
    mounted() {
        var vm = this;
        vm.getData();
        vm.updateUsername();

        console.log(vm.$store.getters.doneTodos);
        console.log(vm.$store.getters.doneTodosCount);
        console.log(vm.$store.getters.getTodoById(2));
        console.log(vm.doneTodosCount);

        vm.mutationTest();

        vm.$store.commit('newTodo', {
            text: '睡覺打東東',
            done: true
        });
    },
    computed: {
        showStatus() {
            return this.$store.state.status;
        },
        doneTodos() {
            return this.$store.getters.doneTodos;
        },
        allTodos() {
            return this.$store.getters.allTodos;
        },
        /**
         * https://stackoverflow.com/questions/48091687/how-exactly-does-the-mapgetters-syntax-work
         */
        ...mapGetters([
            'doneTodosCount',
            'getCount'
        ])
    }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->

<style scoped lang="scss">
    img{
        box-sizing: border-box;
    }

    .done{
        color: green;
    }

    .active{
        background-color: cornflowerblue !important;
        color: white;
        img{
            border: 1px solid white;
        }
        .done{
            color: white;
        }
    }

    tr{
        transition: .3s background-color;
        // line-height: 50px;
    }
</style>
