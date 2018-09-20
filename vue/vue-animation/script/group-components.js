
class _item {
    /**
     *
     * @param {string} name -> item name
     * @param {string} type -> group|device|card
     * @param {string} parent -> item parent
     * @param {json} element -> original data
     */
    constructor(name, type, parent, element){
        this.name = name;
        this.type = type;
        this.element = element;
        this.parent = parent;
        this.children = [];
    }
}

var groupTableList = Vue.extend({
    template: '<tr v-if="parent == \'root\'" ref="id" class="pointer" >\
        <td><i class="fas fas-sm fa-plus-square"></i></td>\
        <th scope="row">{{id}}</th>\
            <td>{{name}}</td>\
            <td>{{parent}}</td>\
            <td>{{create}}</td>\
        </tr>',
    props: ['item', 'i'],
    computed: {
        id() {
            return this.item.GROUP_ID;
        },
        name() {
            return this.item.GROUP_NAME;
        },
        parent() {
            let parent = this.item.GROUP_DATA.PARENT;
            if (!parent) return 'root';
            return parent;
        },
        create() {
            return this.item.CREATE_DATE
        }
    }
})

var groupTable = Vue.extend({
    template: '<table class="table table-striped table-dark">\
        <thead>\
        <tr>\
            <th scope="col">ID</th>\
            <th scope="col">NAME</th>\
            <th scope="col">PARENT</th>\
            <th scope="col">CREATE</th>\
        </tr>\
        </thead>\
        <tbody>\
            <group-table-list v-for="(item, i) in data" :key="i" :item="item" :i="i"></group-table-list>\
        </tbody>\
    </table>',
    props: ['data'],
    components: {
        groupTableList
    }
})

var groupContainer = Vue.extend({
    template: '<div class="container">\
        <div class="row">\
            <div class="col-12">\
                <group-table :data="data"></group-table>\
            </div>\
        </div>\
    </div>',
    data() {
        return {
            data: [],
            dataObject: {},
            treeData: [],
        };
    },
    mounted() {
        var vm = this;
        const domain = 'https://mmm.bmdiot.com:5555';

        axios({
            method: 'post',
            url: `${domain}/group_info`,
            data: {
                'METHOD': 'SELECT',
                'DATA': {
                    'OPERATOR': 'or'
                },
                'SENDER': USER_ID,
                'TOKEN': TOKEN
            }
        }).then((res) => {
            vm.data = res.data.DATA;

            vm.data.forEach( (item) => {
                vm.dataObject[item.GROUP_ID] = new _item(item.GROUP_NAME, 'group', item.GROUP_DATA.PARENT, item);
            });

            vm.data.forEach( (item) => {
                if(item.GROUP_DATA.PARENT != ''){
                    vm.dataObject[item.GROUP_DATA.PARENT].children.push(vm.dataObject[item.GROUP_ID]);
                }
            });

            let dataObjectAlias = vm.dataObject;
            Object.values(dataObjectAlias).forEach((item) => {
                if(item.parent == ''){
                    vm.treeData.push(item);
                    delete dataObjectAlias[item.GROUP_ID];
                }
            });
        }).catch((err) => {
            console.log(err);
        });
    },
    components: {
        groupTable
    }
});