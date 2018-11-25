const leftMenu = Vue.extend({
    template: `
    <el-menu :default-openeds="['1', '3']">
        <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>导航一</template>
            <el-menu-item-group>
                <template slot="title">分组一</template>
                <router-link to="/dashboard">
                    <el-menu-item index="1-1">Dashboard</el-menu-item>
                </router-link>
                <router-link to="/analytics">
                    <el-menu-item index="1-2">Analytics</el-menu-item>
                </router-link>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
                <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
                <template slot="title">选项4</template>
                <el-menu-item index="1-4-1">选项4-1</el-menu-item>
            </el-submenu>
        </el-submenu>
        <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i>导航二</template>
            <el-menu-item-group>
                <template slot="title">分组一</template>
                <el-menu-item index="2-1">选项1</el-menu-item>
                <el-menu-item index="2-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
                <el-menu-item index="2-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="2-4">
                <template slot="title">选项4</template>
                <el-menu-item index="2-4-1">选项4-1</el-menu-item>
            </el-submenu>
        </el-submenu>
        <el-submenu index="3">
            <template slot="title"><i class="el-icon-setting"></i>导航三</template>
            <el-menu-item-group>
                <template slot="title">分组一</template>
                <el-menu-item index="3-1">选项1</el-menu-item>
                <el-menu-item index="3-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
                <el-menu-item index="3-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="3-4">
                <template slot="title">选项4</template>
                <el-menu-item index="3-4-1">选项4-1</el-menu-item>
            </el-submenu>
        </el-submenu>
    </el-menu>
    `
})

const dashboard = Vue.extend({
    template: `
    <el-main>
        <el-row>
            <el-col :span="24" :xs="24">
                <i class="el-icon-info"></i>

                <br>

                <el-button>默认按钮</el-button>
                <el-button type="primary">主要按钮</el-button>
                <el-button type="success">成功按钮</el-button>
                <el-button type="info">信息按钮</el-button>
                <el-button type="warning">警告按钮</el-button>
                <el-button type="danger">危险按钮</el-button>

                <br>

                <el-button plain>朴素按钮</el-button>
                <el-button type="primary" plain>主要按钮</el-button>
                <el-button type="success" plain>成功按钮</el-button>
                <el-button type="info" plain>信息按钮</el-button>
                <el-button type="warning" plain>警告按钮</el-button>
                <el-button type="danger" plain>危险按钮</el-button>

                <br>

                <el-button round>圆角按钮</el-button>
                <el-button type="primary" round>主要按钮</el-button>
                <el-button type="success" round>成功按钮</el-button>
                <el-button type="info" round>信息按钮</el-button>
                <el-button type="warning" round>警告按钮</el-button>
                <el-button type="danger" round>危险按钮</el-button>

                <br>

                <el-button icon="el-icon-search" circle></el-button>
                <el-button type="primary" icon="el-icon-edit" circle></el-button>
                <el-button type="success" icon="el-icon-check" circle></el-button>
                <el-button type="info" icon="el-icon-message" circle></el-button>
                <el-button type="warning" icon="el-icon-star-off" circle></el-button>
                <el-button type="danger" icon="el-icon-delete" circle></el-button>

                <br>

                <el-button disabled>默认按钮</el-button>
                <el-button type="primary" disabled>主要按钮</el-button>
                <el-button type="success" disabled>成功按钮</el-button>
                <el-button type="info" disabled>信息按钮</el-button>
                <el-button type="warning" disabled>警告按钮</el-button>
                <el-button type="danger" disabled>危险按钮</el-button>

                <br>

                <el-button type="text">文字按钮</el-button>
                <el-button type="text" disabled>文字按钮</el-button>

                <br>

                <el-button type="primary" icon="el-icon-edit"></el-button>
                <el-button type="primary" icon="el-icon-share"></el-button>
                <el-button type="primary" icon="el-icon-delete"></el-button>
                <el-button type="primary" icon="el-icon-search">搜索</el-button>

                <br>

                <el-button-group>
                    <el-button type="primary" icon="el-icon-arrow-left">上一页</el-button>
                    <el-button type="primary">下一页<i class="el-icon-arrow-right el-icon--right"></i></el-button>
                </el-button-group>
                <el-button-group>
                    <el-button type="primary" icon="el-icon-edit"></el-button>
                    <el-button type="primary" icon="el-icon-share"></el-button>
                    <el-button type="primary" icon="el-icon-delete"></el-button>
                </el-button-group>

                <br>

                <el-button type="primary" :loading="true">加载中</el-button>

                <br>

                <el-button>默认按钮</el-button>
                <el-button size="medium">中等按钮</el-button>
                <el-button size="small">小型按钮</el-button>
                <el-button size="mini">超小按钮</el-button>

                <br>

                <el-button round>默认按钮</el-button>
                <el-button size="medium" round>中等按钮</el-button>
                <el-button size="small" round>小型按钮</el-button>
                <el-button size="mini" round>超小按钮</el-button>

                <br>
            </el-col>
            <el-col :span="12" :xs="24">

            </el-col>
            <el-col :span="12" :xs="24">

            </el-col>
        </el-row>
    </el-main>
    `
})

const analytics = Vue.extend({
    template: `
    <div class="p-3">
        <div class="row">
            <div class="col-12 mb-3 pb-3 border-bottom">
                <div class="top-status d-flex">
                    <div class="top-status-title font-weight-bold">
                        User Explore
                        <i class="el-icon-star-on text-success"></i>
                    </div>
                    <div class="top-status-btn ml-auto">
                        <el-button type="primary" icon="el-icon-circle-plus" class="el-button--mini">SAVE</el-button>
                        <el-button type="primary" icon="el-icon-download" class="el-button--mini">EXPORT</el-button>
                        <el-button type="primary" icon="el-icon-share" class="el-button--mini">SHARE</el-button>
                    </div>
                </div>
            </div>
            <div class="col-12 col-lg-4">
                <div class="rounded border d-flex justify-content-center align-items-center p-3">
                    <div class="el-icon-loading icon-lg mr-3"></div>
                    <div>
                        <div class="font-weight-bold">All Users</div>
                        <div class="font-sm">0.00% users</div>
                    </div>
                </div>
            </div>
            <div class="col-12 col-lg-4">
                <div class="rounded border d-flex justify-content-center align-items-center p-3">
                    <div class="el-icon-loading icon-lg mr-3"></div>
                    <div>
                        <div class="font-weight-bold">All Users</div>
                        <div class="font-sm">0.00% users</div>
                    </div>
                </div>
            </div>
            <div class="col-12 col-lg-4">
                <div class="h-100 d-flex flex-column align-items-center">
                    <p class="mb-1 text-left w-100"><span class="font-weight-bold">User Time </span><span class="font-sm">User Activity time</span></p>
                    <div class="d-flex">
                        <el-date-picker type="date" placeholder="Pick date" v-model="form.date1" style="width: 100%;" class="mr-1"></el-date-picker>
                        <el-time-picker type="fixed-time" placeholder="Select time" v-model="form.date2" style="width: 100%;"></el-time-picker>
                    </div>
                </div>
            </div>
            <div class="col-12 mt-3">
                <el-tabs type="border-card">
                    <el-tab-pane label="User Explorer">
                        <div class="p3">
                            <el-table :data="tableData4" style="width: 100%" max-height="350">
                                <el-table-column fixed prop="date" label="日期" width="150">
                                </el-table-column>
                                <el-table-column prop="name" label="姓名" width="120">
                                </el-table-column>
                                <el-table-column prop="province" sortable label="省份" width="120">
                                </el-table-column>
                                <el-table-column prop="city" label="市区" width="120">
                                </el-table-column>
                                <el-table-column prop="address" label="地址" width="300">
                                </el-table-column>
                                <el-table-column prop="zip" label="邮编" width="120">
                                </el-table-column>
                                <el-table-column fixed="right" label="操作" width="120">
                                    <template slot-scope="scope">
                                        <el-button @click.native.prevent="deleteRow(scope.$index, tableData4)" type="text"
                                            size="small">
                                            移除
                                        </el-button>
                                    </template>
                                </el-table-column>
                            </el-table>
                        </div>
                    </el-tab-pane>
                    <el-tab-pane label="User Explorer">table</el-tab-pane>
                    <el-tab-pane label="User Explorer">table</el-tab-pane>
                    <el-tab-pane label="User Explorer">table</el-tab-pane>
                </el-tabs>
            </div>
        </div>
    </div>
    `,
    methods: {
        deleteRow(index, rows) {
            rows.splice(index, 1);
        }
    },
    data() {
        return {
            form: {
                name: '',
                region: '',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            },
            tableData4: [{
                date: '2016-05-03',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1518 弄',
                zip: 200333
            }, {
                date: '2016-05-02',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1518 弄',
                zip: 200333
            }, {
                date: '2016-05-04',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1518 弄',
                zip: 200333
            }, {
                date: '2016-05-01',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1518 弄',
                zip: 200333
            }, {
                date: '2016-05-08',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1518 弄',
                zip: 200333
            }, {
                date: '2016-05-06',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1518 弄',
                zip: 200333
            }, {
                date: '2016-05-07',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1518 弄',
                zip: 200333
            }],
        }
    }
});

const mainContainer = Vue.extend({
    template: `
        <el-container style="height: 100vh; border: 1px solid #eee">
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <left-menu></left-menu>
            </el-aside>

            <el-container>
                <el-header>
                    <el-dropdown>
                        <i class="el-icon-setting" style="margin-right: 15px"></i>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>查看</el-dropdown-item>
                            <el-dropdown-item>新增</el-dropdown-item>
                            <el-dropdown-item>删除</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                    <span>王小虎</span>
                </el-header>

                <router-view></router-view>

                <el-footer></el-footer>
            </el-container>
        </el-container>
        `,
    data() {
        return {
            visible: false,
            data: 'cool'
        }
    },
    components: {
        leftMenu
    }
})