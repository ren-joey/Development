var dataListEach = Vue.extend({
    template: '<tr>\
        <th scope="row">{{item.id}}</th>\
        <td>\
        <div class="d-flex align-items-center">\
            <div class="mx-1" v-if="!editContent">{{item.content}}</div>\
            <div class="mx-1" v-else><input @keyup.enter="editSubmit(item)" @keyup.esc="jumpEdit" class="form-control form-control-sm" type="text" v-model.trim="editInput" ref="refEditInput" /></div>\
            <div class="mx-1" v-if="!editContent" @click="editHandler(item)"><i class="pointer fas fa-xs fa-pencil-alt"></i></div>\
            <div class="mx-1" v-else @click="editSubmit(item)"><i class="pointer fas fa-lg fa-check-circle text-success"></i></div>\
        </div>\
        </td>\
        <td></td>\
        <td class="text-right"><button @click="deleteContent(i)" class="btn btn-sm btn-default">DELETE</button></td>\
    </tr>',
    props: ['item', 'i'],
    data() {
        return {
            editContent: false,
            editInput: ''
        }
    },
    methods: {
        editHandler(item) {
            let vm = this;
            vm.editInput = item.content;
            vm.editContent = !vm.editContent;
            if(vm.editContent){
                setTimeout(() => {
                    let target = vm.$refs.refEditInput;
                    target.select()
                });
            }
        },
        jumpEdit() {
            let vm = this;
            vm.editContent = !vm.editContent;
        },
        editSubmit(item) {
            let vm = this;
            if (!vm.editInput || item.content == vm.editInput) {
                vm.editInput = item.content;
                vm.editHandler(item);
            } else {
                bus.$emit('updateContent', {
                    "index": vm.i,
                    "id": item.id,
                    "content": vm.editInput,
                });
                vm.editHandler(item);
            }
        },
        deleteContent(index) {
            bus.$emit('deleteContent', index);
        }
    }
})

var dataList = Vue.extend({
    template: '<table class="table table-striped table-dark">\
        <thead>\
        <tr>\
            <th scope="col">#</th>\
            <th scope="col">Content</th>\
            <th scope="col"></th>\
            <th scope="col"></th>\
        </tr>\
        </thead>\
        <tbody>\
            <data-list-each v-for="(item, i) in data" :key="i" :item="item" :i="i"></data-list-each>\
        </tbody>\
    </table>',
    props: ['data'],
    components: {
        dataListEach
    }
});

var newData = Vue.extend({
    template: '<div class="input-group input-group-sm mb-3">\
        <div class="input-group-prepend">\
            <span class="input-group-text" id="inputGroup-sizing-sm">Add New Content</span>\
        </div>\
        <input v-model.trim="newContent" @keyup.enter="submit" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">\
        <div class="input-group-append">\
            <button @click="submit" class="btn btn-success" type="button" id="button-addon2">Button</button>\
        </div>\
        </div>',
    data() {
        return {
            newContent: ''
        }
    },
    methods: {
        submit() {
            var vm = this;
            if(!vm.newContent) return false;
            bus.$emit('submitInput', vm.newContent);
        }
    }
})

var userContainer = Vue.extend({
    template: '<div class="container mt-4">\
        <div class="row">\
            <div class="col-12">\
                <new-data></new-data>\
            </div>\
            <div class="col-12">\
                <data-list :data="contents"></data-list>\
            </div>\
        </div>\
    </div>',
    data() {
        return {
            contents: ''
        }
    },
    mounted() {
        var vm = this;

        axios.get('http://localhost:3000/data/').then((res) => {
            vm.contents = res.data;
        }).catch((err) => {

        });

        bus.$on('submitInput', (content) => {
            axios.post('http://localhost:3000/data/', {
                "content": content
            }).then((res) => {
                vm.contents.push(res.data);
            }).catch((err) => {

            });
        });

        bus.$on('deleteContent', (index) => {
            let target = vm.contents[index];
            axios.delete(`http://localhost:3000/data/${target.id}`).then((res) => {
                vm.contents.splice(index, 1);
            }).catch((err) => {

            });
        });

        bus.$on('updateContent', (item) => {
            axios({
                method: 'put',
                url: `http://localhost:3000/data/${item.id}`,
                data: {
                    "content": item.content
                }
            }).then((res) => {
                vm.contents[item.index].content = item.content;
            }).catch((err) => {

            });
        })
    },
    components: {
        newData,
        dataList
    }
})