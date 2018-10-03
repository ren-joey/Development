class _item {
    /**
     *
     * @param {string} name -> item name
     * @param {string} type -> group|device|card
     * @param {string} parent -> item parent
     * @param {json} element -> original data
     */
    constructor(name, type, parent, element) {
        this.name = name;
        this.type = type;
        this.element = element;
        this.parent = parent;
        this.children = [];
    }
}

// var bus = new Vue({});

Vue.component('groupTableList', {
    template: `
        <div class="d-flex flex-column d-relative" :class="{'ml-30': (item.parent != '')}">
            <div class="list-left-border" v-if="border"></div>
            <div class="list-arrow" v-if="item.parent != ''"></div>
            <div class="d-flex m-2" @click="clickList">
                <div class="mx-2" style="width: 15px">
                    <template v-if="item.children.length > 0">
                        <i v-if="!open" class="fas fas-sm fa-plus-square"></i>
                        <i v-else class="fas fas-sm fa-minus-square"></i>
                    </template>
                </div>
                <div class="mx-2">{{id}}</div>
                <div class="mx-2">{{name}}</div>
                <div class="mx-2">{{parent}}</div>
                <div class="flex-grow-1 mx-2">{{create}}</div>
            </div>
            <transition
                @enter="enter"
                @leave="leave"
                >
                <div v-show="open" v-if="item.children.length > 0" ref="children">
                    <group-table-list v-for="(item, i) in item.children" :key="i" :item="item" :i="i" :border="shouldBorder"></group-table-list>
                </div>
            </transition>
        </div>
        `,
    props: {
        item: Object,
        i: Number,
        border: {
            type: Boolean,
            default: false
        }
    },
    data() {
        return {
            open: false,
            showLeftBorder: false,
            currentClick: false,
            currentHeight: 0
        };
    },
    computed: {
        id() {
            return this.item.element.GROUP_ID;
        },
        name() {
            return this.item.element.GROUP_NAME;
        },
        parent() {
            let parent = this.item.element.GROUP_DATA.PARENT;
            if (!parent) return 'root';
            return parent;
        },
        create() {
            return this.item.element.CREATE_DATE;
        },
        isFolder() {
            return this.children;
        },
        hasNext() {
            return (this.$el.nextElementSibling != null);
        },
        shouldBorder() {
            if (this.parent != 'root') {
                if (this.open) {
                    if (this.hasNext) {
                        return true;
                    }
                }
            }

            return false;
        }
    },
    methods: {
        clickList() {
            let vm = this;
            vm.open = !vm.open;

            // vm.currentClick = true;
            // bus.$emit('changeStatus');
            // vm.currentClick = false;
        },
        enter(el, done) {
            let vm = this;

            /**
             * 跑動畫前才將 overflow 設為 hidden
             */
            el.style.overflow = 'hidden';

            done();
            TweenMax.fromTo(el, .3, {
                'height': 0
            }, {
                'height': vm.currentHeight,
                onComplete: function () {
                    /**
                     * 動畫完成後將高度刪除，
                     * 讓 dom 變回自動增長
                     */
                    el.style.height = '';

                    /**
                     * 動畫完成後要將 overflow 的設定取消
                     * 避免左側的樹狀虛線消失
                     */
                    el.style.overflow = '';
                }
            });
        },
        leave(el, done) {
            let vm = this;

            /**
             * 關閉前記憶當前的高度
             * 因為最早 mounted 所定義的高度有可能因為後代展開而改變
             */
            vm.currentHeight = el.clientHeight;

            /**
             * 跑動畫前才將 overflow 設為 hidden
             */
            el.style.overflow = 'hidden';

            TweenMax.to(el, .3, {
                'height': 0,
                onComplete: function () {
                    /**
                     * 動畫完成後要將 overflow 的設定取消
                     * 避免左側的樹狀虛線消失
                     */
                    el.style.overflow = '';

                    done();
                }
            });
        }
    },
    mounted() {
        let vm = this;

        // bus.$on('changeStatus', () => {
        //     if(!vm.currentClick) vm.open = false;
        // });

        if ( vm.item.children.length > 0 ) {

            let a = this.$refs.children.cloneNode(true);
            a.style.display = 'block';
            let aHeight = document.body.appendChild(a).clientHeight;

            a.remove();

            this.currentHeight = aHeight;
        }
    }
});

var groupTable = Vue.extend({
    template: `
    <div class="text-white">
        <group-table-list class="border-bottom border-info" v-for="(item, i) in data" :key="i" :item="item" :i="i"></group-table-list>
    </div>
    `,
    props: ['data']
});

var groupContainer = Vue.extend({
    template: '<div class="container">\
        <div class="row">\
            <div class="col-12">\
                <group-table :data="treeData"></group-table>\
            </div>\
        </div>\
    </div>',
    data() {
        return {
            data: [],
            dataObject: {},
            treeData: []
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
            vm.treeDataGenerator();

        }).catch((err) => {

            console.log(err);

        }).then(() => {

            vm.data = [{
                "GROUP_ID": 2,
                "GROUP_NAME": "abc",
                "GROUP_DATA": {
                    "ID": "2",
                    "NAME": "abc",
                    "LEVEL": "1",
                    "PARENT": ""
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T05:54:48.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 3,
                "GROUP_NAME": "abc01",
                "GROUP_DATA": {
                    "ID": "3",
                    "NAME": "abc01",
                    "LEVEL": "2",
                    "PARENT": "2"
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T05:55:12.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 4,
                "GROUP_NAME": "abc02",
                "GROUP_DATA": {
                    "ID": "4",
                    "NAME": "abc02",
                    "LEVEL": "3",
                    "PARENT": "3"
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T05:55:34.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 10,
                "GROUP_NAME": "test1",
                "GROUP_DATA": {
                    "ID": "10",
                    "NAME": "test1",
                    "LEVEL": "2",
                    "PARENT": "2"
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T06:33:15.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 11,
                "GROUP_NAME": "1-1",
                "GROUP_DATA": {
                    "ID": "11",
                    "NAME": "1-1",
                    "LEVEL": "3",
                    "PARENT": "10"
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T06:33:22.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 12,
                "GROUP_NAME": "abc01-1",
                "GROUP_DATA": {
                    "ID": "12",
                    "NAME": "abc01-1",
                    "LEVEL": "3",
                    "PARENT": "3"
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T06:33:33.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 18,
                "GROUP_NAME": "1",
                "GROUP_DATA": {
                    "ID": "18",
                    "NAME": "1",
                    "LEVEL": "1",
                    "PARENT": ""
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T08:09:42.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 19,
                "GROUP_NAME": "2",
                "GROUP_DATA": {
                    "ID": "19",
                    "NAME": "2",
                    "LEVEL": "2",
                    "PARENT": "18"
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T08:09:44.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 20,
                "GROUP_NAME": "3",
                "GROUP_DATA": {
                    "ID": "20",
                    "NAME": "3",
                    "LEVEL": "3",
                    "PARENT": "19"
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T08:09:46.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 21,
                "GROUP_NAME": "4",
                "GROUP_DATA": {
                    "ID": "21",
                    "NAME": "4",
                    "LEVEL": "4",
                    "PARENT": "20"
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T08:12:23.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 22,
                "GROUP_NAME": "2-1",
                "GROUP_DATA": {
                    "ID": "22",
                    "NAME": "2-1",
                    "LEVEL": "2",
                    "PARENT": "18"
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T10:42:30.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 23,
                "GROUP_NAME": "2-2",
                "GROUP_DATA": {
                    "ID": "23",
                    "NAME": "2-2",
                    "LEVEL": "2",
                    "PARENT": "18"
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T10:42:52.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 24,
                "GROUP_NAME": "3-1",
                "GROUP_DATA": {
                    "ID": "24",
                    "NAME": "3-1",
                    "LEVEL": "3",
                    "PARENT": "23"
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T10:42:58.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 28,
                "GROUP_NAME": "1-1",
                "GROUP_DATA": {
                    "ID": "28",
                    "NAME": "1-1",
                    "LEVEL": "1",
                    "PARENT": ""
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T10:45:57.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 29,
                "GROUP_NAME": "2-1",
                "GROUP_DATA": {
                    "ID": "29",
                    "NAME": "2-1",
                    "LEVEL": "2",
                    "PARENT": "28"
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T10:46:03.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 30,
                "GROUP_NAME": "3-1",
                "GROUP_DATA": {
                    "ID": "30",
                    "NAME": "3-1",
                    "LEVEL": "3",
                    "PARENT": "29"
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T10:46:06.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }, {
                "GROUP_ID": 31,
                "GROUP_NAME": "4-1",
                "GROUP_DATA": {
                    "ID": "31",
                    "NAME": "4-1",
                    "LEVEL": "4",
                    "PARENT": "30"
                },
                "OWNER": "lucas",
                "MANAGER": null,
                "CREATE_USER": "lucas",
                "CREATE_DATE": "2018-09-03T10:46:09.000Z",
                "UPDATE_USER": null,
                "UPDATE_DATE": null
            }];
            vm.treeDataGenerator();

        });
    },
    methods: {
        treeDataGenerator() {
            var vm = this;

            vm.data.forEach((item) => {
                vm.dataObject[item.GROUP_ID] = new _item(item.GROUP_NAME, 'group', item.GROUP_DATA.PARENT, item);
            });

            vm.data.forEach((item) => {
                if (item.GROUP_DATA.PARENT != '') {
                    vm.dataObject[item.GROUP_DATA.PARENT].children.push(vm.dataObject[item.GROUP_ID]);
                }
            });

            let dataObjectAlias = vm.dataObject;
            Object.values(dataObjectAlias).forEach((item) => {
                if (item.parent == '') {
                    vm.treeData.push(item);
                }
            });
        }
    },
    components: {
        groupTable
    }
});