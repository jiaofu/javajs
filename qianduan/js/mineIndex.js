var wrapperVue = new Vue({
    el: "#wrapper",
    data: {
        getUser: "http://localhost:8080/mine/getUserData.do",
        getUserRecord: "http://localhost:8080/mine/getUserRecord.do",
        user: new Object(),        // 用户数据 
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
            if (typeof (vm.input.userId) == "undefined" ) {
                alert("没有输入");
                return;
            }

            vm.$http.get(vm.getUser, {
                params: {
                    "userId": vm.input.userId
                }
            }).then(function (response) {
                handSuccess(response.data, function () {
                    var res = response.data.data;
                    if (res.hasOwnProperty("user")) {
                        vm.user = res.user;
                        vm.input.userId =res.user.userId;
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
            vm.page.preTotal = vm.posts.dataList.length;

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