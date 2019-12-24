
var pageInit = new Object(); // 分页类
pageInit.init= function(){
    pageInit.size = 50;   // 拉取的条数
    pageInit.preTotal = 0; // 已 拿去的数量
    pageInit.first = true;    // 是否第一页
    pageInit.last = true;  // 是否最后一页
    pageInit.index = 0;    // 当前第几页
    pageInit.showSize = 10;  // 每页多少条
    return pageInit;
}
pageInit.init();

Vue.component('page-component',{
    props: ['posts'],
    data:function () {
        return {
            page:pageInit
        }
    },
    methods:{

        firstGetData:function(table,index,res){
            var vm =this;
            for (var i = 0; i < table.length; i++) {
                if (table[i].id == index) {
                    vm.posts.title = table[i].title;
                }
            }
            vm.posts.dataList = new Array();
            for (var i = 0; i < res.length; i++) {
                vm.posts.dataList.push(res[i]);
            }

            vm.handleData()
        },
        nextGetData:function(res){
            var vm =this;
            var page = vm.page;
            for (var i = 0; i < res.length; i++) {
                vm.posts.dataList.push(res[i]);
            }
            page.index++
            // 这里调用子组件
           vm.handleData()
        },
        handleData:function () {
            var vm =this;
            var page = vm.page;
            vm.posts.pageList = new Array();
            var length = vm.posts.dataList.length;
            for(var i=0;i<page.showSize;i++){
                var getIndex = page.showSize*page.index+i;
                if(getIndex<length){
                 var obj =  vm.posts.dataList[getIndex];
                 var arr = new Array();
                  for(var j=0;j< vm.posts.title.length;j++){
                     var jj = vm.posts.title[j];
                     if( typeof jj.fun == "function"){
                         arr.push( jj.fun(obj[jj.dbName]));
                     }else {
                         arr.push( obj[jj.dbName]);
                     }

                  }
                  vm.posts.pageList.push(arr);
                }
            }
            vm.pageFirstLast();
        },
        pagePre:function () {
            var vm =this;
            var page = vm.page;
            if(page.index==0){
                return;
            }else {
                page.index--
                vm.handleData();
            }
        },
        pageNext:function () {
            var vm =this;
            var page = vm.page;
            var length = vm.posts.dataList.length;
            if(page.last){
                return;
            }else {
                if(page.showSize*(page.index+1)  == length){
                    //  调用方法
                    vm.$emit('next-page',page);
                }
                else{
                    page.index++
                    vm.handleData();
                }

            }

        },
        pageFirstLast:function () {
            var vm =this;
            var page = vm.page;
            if(page.index>0){
                page.first = false;
            }else {
                page.first = true;
            }

            var length = vm.posts.dataList.length;
            if(page.showSize*(page.index+1)  > length){
                page.last = true;
            }else {
                page.last = false;
            }
        }


    },
    template :'      <div style="padding-right: 16px;padding-left: 16px;">\n' +
        '\n' +
        '            <div class="found" id="details">\n' +
        '                <table width="100%" class="table table-striped table-bordered table-hover table-user user-news " border="" style="">\n' +
        '                    <thead>\n' +
        '                    <tr class="bg-fafafa" style="height: 50px;">\n' +
        '                        <td class="center" v-for="item in posts.title">{{item.showName}}</td>\n' +
        '                    </tr>\n' +
        '                    </thead>\n' +
        '                    <tbody id="data">\n' +
        '                    <tr v-for="items in posts.pageList">\n' +
        '                        <td v-for="item in items"> {{item}}</td>\n' +
        '                    </tr>\n' +
        '                    </tbody>\n' +
        '                </table>\n' +
        '                <ul class="flex-center do" style="overflow: hidden">\n' +
        '                    <li><a  class="btn-default  btn" v-on:click="pagePre()" v-bind:class="{\'btn-active\':!page.first}">上一页</a></li>&nbsp;&nbsp;\n' +
        '                    <li><a  class=" btn-default  btn" v-on:click="pageNext()" v-bind:class="{\'btn-active\':!page.last}">下一页</a></li></ul>\n' +
        '            </div>\n' +
        '        </div>'

})


function tit(showName,dbName,fun) {
    var obj = new Object();
    obj.showName = showName;
    obj.dbName = dbName;
    obj.fun =fun;
    return obj;
}