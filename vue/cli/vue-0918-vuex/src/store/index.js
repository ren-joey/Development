import Vue from 'vue'
import Vuex from 'vuex'
// import { mapState } from 'vuex'

Vue.use(Vuex)

const state = {
    status: 'ONLINE',
    username: '',
    todos: [
        { id: 1, text: '遛狗', done: true },
        { id: 2, text: '餵貓', done: false },
        { id: 3, text: '買地瓜', done: false }
      ],
    count: 0
}
const getters = {
    doneTodos: (state) => {
        return state.todos.filter(todo => todo.done);
    },
    doneTodosCount: (state, getters) => {
        return getters.doneTodos.length
    },
    allTodos: (state) => {
        return state.todos;
    },
    getTodoById: (state) => (id) => {
        return state.todos.find(todo => todo.id == id)
    },
    getCount: (state) => {
        return state.count;
    }
}

// https://vuex.vuejs.org/zh/guide/actions.html
const actions = {}
const mutations = {
    updateStatus (value) {
        this.state.status = value;
    },
    increment (state, n) {
        state.count += n;
    },
    newTodo (state, todo){
        let key = state.todos.length + 1;
        todo['id'] = key;
        state.todos.push(todo);
    }
}

export default new Vuex.Store({
    state,
    getters,
    actions,
    mutations
})
