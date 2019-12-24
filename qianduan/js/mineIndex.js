var wrapperVue = new Vue({
    el: "#wrapper",
    data: {
        getUser: "/mine/getUserData.do",
        getUserRecord: "/mine/getUserRecord.do",
        user: new Object(),        // 用户数据
        mine: new Object(),         // 挖矿数据
        bonus: new Object(),         // 分红数据
        index: 0,                    // 选择哪一个标题
        items: table,                 // 数据
        posts: {
            dataList: [],            // 查询出来的数据
            pageList: [],           // 显示 分页数据
            title: []
        },
        input: new Object(),    // 页面输入框


    },
    mounted: function () {
        // this.get()
    },
    methods: {
        getData: function () {
            var vm = this;
            if (typeof (vm.input.userId) == "undefined" && typeof (vm.input.userName) == "undefined" && typeof (vm.input.bankCard) == "undefined") {
                alert("没有输入");
                return;
            }

            vm.$http.get(vm.getUser, {
                params: {
                    "userId": vm.input.userId, phone: vm.input.userName, bankCard: vm.input.bankCard
                }
            }).then(function (response) {
                handSuccess(response.data, function () {
                    var res = response.data.data;
                    if (res.hasOwnProperty("user")) {
                        vm.user = res.user;
                        vm.input.userId =res.user.userId;
                    }
                    if (res.hasOwnProperty("mine")) {
                        vm.mine = res.mine;
                    }

                    if (res.hasOwnProperty("bonus")) {
                        vm.bonus = res.bonus;
                    }

                })
            }, function () {
                alert("获取数据出错");
            });
        },
        getRecord: function (id) {

            var vm = this;
            if (typeof (vm.input.userId) == "undefined") {
                alert("用户为空");
                return;
            }
            vm.index = id;
            vm.page = pageInit.init();
            vm.$http.get(vm.getUserRecord, {
                params: {
                    "userId": vm.input.userId, "id": vm.index, "size": vm.page.size, "preTotal": vm.page.preTotal
                }
            }).then(function (response) {
                handSuccess(response.data, function () {
                    vm.$refs.component.firstGetData(vm.items,vm.index,response.data.data)
                })
            });
        },


        nextPage: function () {
            var vm = this;
            page.preTotal = vm.posts.dataList.length;

            vm.page.preTotal = length
            vm.$http.get(vm.getUserRecord, {
                params: {
                    "userId": vm.input.userId, "id": vm.index, "size": vm.page.size, "preTotal": vm.page.preTotal
                }
            }).then(function (response) {
                handSuccess(response.data, function () {
                    vm.$refs.component.nextGetData(response.data.data)
                })
            });
        }
    }
})