<template>
<div class="hello">
    <div class="container-fluid">
        <div class="d-flex">
            <div class="mt-4">
                <h6>Status: {{status}}</h6>
            </div>
            <div class="form-inline ml-auto">
                <input type="text" class="form-control form-control-sm mr-1" v-model="username">
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
                    <th scope="col">tools</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(item, i) in listData" :key="i" :class="{'active': item.selected}">
                    <th scope="row">{{i+1}}</th>
                    <td><img :src="item.picture.thumbnail" width="50" height="50" alt=""></td>
                    <td>{{item.name.first}} {{item.name.last}}</td>
                    <td>{{item.email}}</td>
                    <td><button class="btn btn-sm" :class="{'btn-primary': !item.selected, 'btn-default': item.selected}" @click="clickMe(item)">click</button></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
</template>

<script>
export default {
    name: "HelloWorld",
    props: [
        'status'
    ],
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
            let vm = this;
            vm.$emit('pushNewName', vm.username);
        },
        clickMe(item) {
            item.selected = !item.selected;
            console.log(item.selected);
        }
    },
    // vue 運行完成後自動執行
    mounted() {
        this.getData();
    }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->

<style scoped lang="scss">
    img{
        box-sizing: border-box;
    }

    .active{
        background-color: cornflowerblue !important;
        color: white;
        img{
            border: 1px solid white;
        }
    }

    tr{
        transition: .3s all;
        line-height: 50px;
    }
</style>
