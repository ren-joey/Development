const store = new Vuex.Store({
    state: {
        data: [],
        filter: {
            order: false,
            age30d: false,
            age30u: false
        }
    },
    getters: {
        filterData(state) {
            let alias = [];
            state.data.forEach((user, i) => {
                if(!state.filter.order || i%2 == 1){
                    if(!state.filter.age30d || user.dob.age < 30){
                        if(!state.filter.age30u || user.dob.age > 30){
                            alias.push(user);
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            });

            return alias;
        }
    },
    mutations: {
        increment (state, results) {
            state.data = results;
        },
        updateFilter(state, filter) {
            state.filter = filter;
        }
    },
    actions: {
        DATA_READ: (context) => {
            return axios.get('https://randomuser.me/api', {
                params: {
                    'results': 50
                }
            }).then((res) => {
                let alias = [];

                res.data.results.forEach((user, i) => {
                    user['id'] = i;
                    alias.push(user);
                });
                context.commit('increment', alias);
            }).catch((err) => {

            });
        }
    }
});