var userTableList = Vue.extend({
    template: `
    <tr>
        <th scope="row">{{user.id}}</th>
        <td class="d-relative">
            <img @mouseenter="popup = !popup" @mouseleave="popup = !popup" class="mr-2 rounded-circle" :src="user.picture.thumbnail" width="30" height="30"/>
            <transition name="fade">
                <div v-show="popup" class="imgPopup y-center rounded" style="overflow: hidden;">
                    <img :src="user.picture.large"/>
                </div>
            </transition>
            {{user.name.first + ' ' + user.name.last}}
        </td>
        <td>{{user.dob.age}}</td>
        <td>{{user.cell}}</td>
        <td>{{user.city}}</td>
    </tr>
    `,
    props: ['user', 'i'],
    data() {
        return {
            popup: false
        };
    },
    methods: {}
});

var userTable = Vue.extend({
    template: `
    <table class="table table-striped table-dark" style="transition: .3s height;">
        <thead>
            <tr>
                <th scope="col" style="width: 50px;">#</th>
                <th scope="col">Name</th>
                <th scope="col" style="width: 50px;">Age</th>
                <th scope="col">Cell</th>
                <th scope="col">City</th>
            </tr>
        </thead>
        <transition-group name="o-fade" tag="tbody">
            <user-table-list v-for="(user, i) in data" :key="user.id" :user="user" :i="i"></user-table-list>
            <tr v-if="data.length < 1" :key="dataOrigin.length + 1">
                <td></td>
                <td>Nothing to show</td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </transition-group>
    </table>
    `,
    computed: {
        data() {
            return this.$store.getters.filterData;
        },
        dataOrigin() {
            return this.$store.state.data;
        }
    },
    mounted() {
        this.$store.dispatch('DATA_READ');
    },
    components: {
        userTableList
    }
});

var vuexContainer = Vue.extend({
    template: `
    <div class="container">
        <div class="row">
            <div class="col-12 text-center mb-2 mt-4">
                <div class="btn-group" role="group">

                    <button @click="filters(1)"
                    type="button" class="btn"
                    :class="{'btn-outline-light': !filter.order, 'btn-light': filter.order}"
                    >order odd</button>

                    <button @click="filters(2)"
                    type="button" class="btn"
                    :class="{'btn-outline-light': !filter.age30d, 'btn-light': filter.age30d}"
                    >less then 30</button>

                    <button @click="filters(3)"
                    type="button" class="btn"
                    :class="{'btn-outline-light': !filter.age30u, 'btn-light': filter.age30u}"
                    >over then 30</button>

                </div>
            </div>
            <div class="col-12">
                <user-table></user-table>
            </div>
        </div>
    </div>
    `,
    data() {
        return {
            filter: {
                order: false,
                age30d: false,
                age30u: false
            }
        };
    },
    methods: {
        filters(val) {
            let vm = this;
            if(val == 1){
                vm.filter.order = !vm.filter.order;
            } else if (val == 2){
                vm.filter.age30d = !vm.filter.age30d;
            } else if (val == 3){
                vm.filter.age30u = !vm.filter.age30u;
            }

            vm.$store.commit('updateFilter', vm.filter);
        }
    },
    components: {
        userTable
    },
});