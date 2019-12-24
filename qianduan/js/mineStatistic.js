
var  wrapperVue= new Vue({
    el:"#wrapper",
    data:{
        getStatistics:"/mineStatistics/data.do",
        index:1,                    // 选择哪一个标题
        items:table,                 // 数据

        posts:{
            dataList:[],            // 查询出来的数据
            pageList:[],           // 显示 分页数据
            title:[]
        }


    },
    mounted:function () {
        var vm =this;
      this.getRecord(vm.index)
    },
    methods:{
        getRecord:function (index) {
            var vm =this;
            if(index !=0){
                vm.index = index
            }
            vm.page=pageInit.init();
           // var dt = new Object();
           // dt.test = "测试股";
           // vm.posts.dataList.push(dt);
            // vm.$refs.component.handleData()
            axios.get(vm.getStatistics,{
                params:{
                   "index":vm.index,"size":this.$refs.component.page.size,"preTotal":this.$refs.component.page.preTotal,"start":$("#datetimepickerStart").val(),"end":$("#datetimepickerEnd").val()
                }}).then(function (response) {
                handSuccess(response.data,function () {
                    vm.$refs.component.firstGetData(vm.items,vm.index,response.data.data)

                })
            });
        },
        nextPage:function (page) {
            var vm =this;
            page.preTotal =  vm.posts.dataList.length;
            axios.get(vm.getStatistics,{
                params:{
                    "index":vm.index,"size":this.$refs.component.page.size,"preTotal":this.$refs.component.page.preTotal,"start":$("#datetimepickerStart").val(),"end":$("#datetimepickerEnd").val()
                }}).then(function (response) {
                handSuccess(response.data,function () {
                    vm.$refs.component.nextGetData(response.data.data)
                })
            });
        },
        excelData:function () {
            var vm =this;
            var str = JSON.stringify(vm.posts.title);
            axios.get("/mineStatistics/export.do", {
                params:{
                    "index":vm.index,
                    "start":$("#datetimepickerStart").val(),
                    "end":$("#datetimepickerEnd").val(),
                    "json": str
                },
                responseType: 'blob', //二进制流
            }).then(function (response) {
                if(!data){
                    return
                }
               var  fileName = window.decodeURI(response.headers['content-disposition'].split('=')[1]);
                var link = document.createElement("a");
                link.href = window.URL.createObjectURL(new Blob([response.data], {type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"}));
                link.target = "_blank";
                link.download = fileName;
                document.body.appendChild(link);
                link.click();
                document.body.removeChild(link);
            }).catch(function (error) {
                console.log(error)
            });

        }

    }
})