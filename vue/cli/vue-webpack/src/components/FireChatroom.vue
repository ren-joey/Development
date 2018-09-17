<template>
<div class="hello container">

    <div class="row mt-4">
        <div class="col-12 col-md-3 order-md-2 mb-4">
            <div class="card text-left">
                <div class="card-header">
                    設定
                </div>
                <div class="card-body">
                    <p class="card-text font-sm">請設定您的姓名</p>
                    <input type="text" class="form-control form-control-sm" placeholder="請輸入名稱" v-model="newName" @keyup.enter="updateUsername()">
                    <a href="#" class="btn btn-primary btn-sm mt-2" @click="updateUsername()">Send</a>
                </div>
            </div>
        </div>
        <div class="col-12 col-md-9 order-md-1">
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
import firebase from 'firebase';
var config = {
            apiKey: "AIzaSyAA1Vi8GDPkLB56Q6gm6k5NpiDrDuMX8_o",
            authDomain: "vue-js-test-c3c45.firebaseapp.com",
            databaseURL: "https://vue-js-test-c3c45.firebaseio.com",
            projectId: "vue-js-test-c3c45",
            storageBucket: "vue-js-test-c3c45.appspot.com",
            messagingSenderId: "<SENDER_ID>",
        };
        firebase.initializeApp(config);

var chatroomRef = firebase.database().ref('/chatroom/');

export default {
    data() {
        return {
            msg: "Welcome to Your Vue.js App",
            username: '未命名',
            newName: '未命名',
            message: '',
            messages: []
        };
    },
    methods: {
        isUser(item) {
            return (this.username == item.username);
        },
        submitMessage() {
            // var that = this;
            var timestamp = Math.floor(Date.now() / 1000);

            var data = {
                username: this.username,
                message: this.message,
                timestamp: timestamp
            }

            chatroomRef.child(timestamp).set(data);
        },
        updateUsername() {
            var that = this;

            // that.messages.forEach( (message, index) => {
            //     if(message.username == that.username) {
            //         console.log(that.messages[index].username);

            //         that.messages[index].username = that.newName;
            //     }
            // });

            that.username = that.newName;
        }
    },
    mounted() {
        // var that = this;
        chatroomRef.orderByChild('timestamp').on('value',  (snapshot) => {
            var msg = [];
            console.log(snapshot.val());
            Object.values(snapshot.val()).forEach( (value) => {
                msg.unshift(value);
            });
            this.messages = msg;
        });
    }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->

<style scoped>

</style>
