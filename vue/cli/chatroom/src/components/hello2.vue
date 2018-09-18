<template>
<div class="hello container">

    <div class="row mt-4">
        <div class="col-12 col-md-4 order-md-2 mb-4">
            <div class="card">
                <div class="card-header">
                    設定
                </div>
                <div class="card-body">
                    <p class="card-text text-sm">更改姓名</p>
                    <input type="text" class="form-control form-control-sm" placeholder="請輸入名稱" v-model="newName" @keyup.enter="updateUsername()">
                    <a href="#" class="btn btn-primary btn-sm mt-2" @click="updateUsername()">Send</a>
                </div>
            </div>
        </div>
        <div class="col-12 col-md-8 order-md-1">
            <div class="input-group input-group-sm">
                <input id="message" v-model="message" @keyup.enter="submitMessage()" type="text" class="form-control" placeholder="請輸入訊息" aria-label="Recipient's username" aria-describedby="button-addon2" />
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" @click="submitMessage()" type="button" id="button-addon2">GO!</button>
                </div>
            </div>

            <div class="media my-3" v-for="(item, index) in messages" :key="index">
                <img v-if="!isUser(item)" class="mr-3" src="https://picsum.photos/64/?random" alt="Generic placeholder image">
                <div class="media-body" :class="{ 'text-right': isUser(item), 'mr-2': isUser(item), 'text-left': !isUser(item) }">
                    <h5 class="mt-0">{{item.username}}</h5>
                    {{item.message}}
                </div>
                <img v-if="isUser(item)" class="mr-3" src="https://picsum.photos/64/?random" alt="Generic placeholder image">
            </div>
        </div>
    </div>
</div>
</template>

<script>
export default {
    name: "HelloWorld",
    data() {
        return {
            msg: "Welcome to Your Vue.js App",
            username: 'Casper',
            newName: '',
            message: '',
            messages: [{
                    username: 'Casper',
                    message: 'Hello'
                },
                {
                    username: 'Joey',
                    message: 'Hi'
                }
            ]
        };
    },
    methods: {
        isUser(item) {
            return (this.username == item.username);
        },
        submitMessage() {
            var data = {
                username: this.username,
                message: this.message
            }

            this.messages.unshift(data);
        },
        updateUsername() {
            var that = this;

            that.messages.forEach( (message, index) => {
                if(message.username == that.username) {
                    console.log(that.messages[index].username);

                    that.messages[index].username = that.newName;
                }
            });

            that.username = that.newName;
        }
    }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->

<style scoped>

</style>
