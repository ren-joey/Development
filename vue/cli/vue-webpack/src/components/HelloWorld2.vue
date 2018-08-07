<template>
  <div class="container mt-5">
    <div class="input-group mb-3">
      <input type="text" class="form-control" placeholder="Recipient's username" v-model="message" aria-label="Recipient's username" aria-describedby="basic-addon2">
      <div class="input-group-append">
        <button class="btn btn-primary" type="button" @click="submitMessage">Button</button>
      </div>
    </div>
    <div class="media" v-for="item in messages">
      <img v-if="item.username != username" class="align-self-start mr-3" src="https://dummyimage.com/64x64/AAA/000.png" alt="Generic placeholder image">
      <div :class="[{'text-right': isUser(item.username)}, 'media-body']">
        <h5 class="mt-0">{{ item.username }}</h5>
        <p>{{ item.message }}</p>
      </div>
      <img v-if="item.username == username" class="ml-3" src="https://dummyimage.com/64x64/AAA/000.png" alt="Generic placeholder image">
    </div>
    <!-- <div class="media">
      <div class="media-body">
        <h5 class="mt-0 mb-1">Media object</h5>
        Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
      </div>
      <img class="ml-3" src="https://dummyimage.com/64x64/AAA/000.png" alt="Generic placeholder image">
    </div> -->
  </div>
</template>

<script>
  export default {
    name: "HelloWorld",
    data() {
      return {
        msg: "Welcome to Your Vue.js App 2",
        username: 'Casper',
        message: '',
        messages: [
          {
            username: 'Casper',
            message: 'Hello 你好'
          },
          {
            username: '凱斯柏',
            message: '你好~'
          }
        ]
      };
    },
    methods: {
      submitMessage(){
        let self = this;
        self.messages.unshift({
          username: self.username,
          message: self.message
        });
        self.message = "";
      },
      isUser(user){
        let self = this;
        if( self.username == user )return true;
      }
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
