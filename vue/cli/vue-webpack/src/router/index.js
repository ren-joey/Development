import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import hello2 from '@/components/hello2'
import FireChatroom from '@/components/FireChatroom'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: 'HelloWorld',
            component: HelloWorld
        },
        {
            path: '/hello2',
            name: 'hello2',
            component: hello2
        },
        {
            path: '/chatroom',
            name: 'FireChatroom',
            component: FireChatroom
        },
    ]
})
