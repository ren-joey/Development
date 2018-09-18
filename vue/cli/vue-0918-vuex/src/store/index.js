import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

const state = {
    status: 'ONLINE',
    username: ''
}
const getters = {}
const actions = {}
const mutations = {}

export default new Vuex.Store({
    state,
    getters,
    actions,
    mutations
})
