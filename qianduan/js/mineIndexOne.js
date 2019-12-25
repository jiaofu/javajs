var wrapperVue = new Vue({
    el: "#wrapper",
    data: {
        getUserRecord: "http://localhost:8080/mine/getRecordBeans.do",
        index: 1,                    // 选择哪一个标题
        items: table,                 // 数据
        symbolName:"" ,              //搜索内容
        page:new Object(),           // 分页类
        posts: {
            dataList: [],            // 查询出来的数据
            pageList: [],           // 显示 分页数据
            title: []
        }
    },
    mounted: function () {
         this.getRecord();
    },
    methods: {
        getRecord: function () {
            var vm = this;
            vm.page = pageInit.init();
            vm.$http.get(vm.getUserRecord, {
                params: {
                    "symbolName": vm.symbolName,  "size": vm.page.size, "preTotal": vm.page.preTotal
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
                    "symbolName": vm.symbolName,"size": vm.page.size, "preTotal": vm.page.preTotal
                }
            }).then(function (response) {
                handSuccess(response.data, function () {
                    vm.$refs.component.nextGetData(response.data.data)
                })
            });
        }
    }
})