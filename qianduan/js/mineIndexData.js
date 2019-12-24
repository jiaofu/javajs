var table = new Array();

var pageInit = new Object(); // 分页类
var  currentLock = new Object(); //当期锁仓
var lockRecord = new Object(); // 锁仓记录
var unlockRecord = new Object(); // 锁仓记录

var applicationRecord = new Object(); // 申请记录

var bonusRecord = new Object(); // 分红记录

var mineRecord = new Object(); // 挖矿记录


currentLock.id = 1;
currentLock.name = "当期锁仓";
currentLock.title= [new tit("锁仓记录","lockDate"),new tit("锁仓数量","lockAmount"),new tit("最小锁仓时间","minLockDay"),new tit("已锁天数","lockedDay"),new tit("忠诚积分","loyaltyPoints"),new tit("锁仓积分","lockPoints"),new tit("仓位编号","storeNum")];

lockRecord.id = 2;
lockRecord.name = "锁仓记录";
lockRecord.title= [new tit("申请日期","applicationDate"),new tit("锁仓数量","lockAmount"),new tit("最小锁仓时间","minLockDay"),new tit("锁仓日期","lockDate"),new tit("仓位编号","storeNum")];


unlockRecord.id=3;
unlockRecord.name = "解锁记录";
unlockRecord.title= [new tit("申请日期","applicationDate"),new tit("解锁数量","unlockAmount"),new tit("已锁天数","lockedDay"),new tit("解锁日期","unlockDate"),new tit("忠诚积分扣减","loyaltyPoints"),new tit("锁仓积分扣减","lockPoints"),new tit("仓位编号","storeNum")];

applicationRecord.id=4;
applicationRecord.name = "申请记录";
applicationRecord.title= [new tit("申请日期","applicationDate"),new tit("类型","type",function (type) {
    if(type ==1){
        return "锁仓"
    }else {
        return "解锁"
    }

}),new tit("数量","amount"),new tit("状态","status",function (status) {
    if(status==0){
        return "申请中";
    }else if(status ==1){
        return "已取消"
    }else {
        return "";
    }

})];


bonusRecord.id=5;
bonusRecord.name = "分红记录";
bonusRecord.title= [new tit("日期","bonusDate"),new tit("分红手续费","feeAmount"),new tit("分红积分","bonusPoints"),new tit("忠诚积分","loyaltyPoints"),new tit("锁仓积分","lockPoints"),new tit("推广积分","generalizePoints")];

mineRecord.id=6;
mineRecord.name = "挖矿记录";
mineRecord.title= [new tit("日期","bonusDate"),new tit("被抵扣手续费","feeAmount"),new tit("矿加权价格","minePrice"),new tit("矿数量","mineAmount"),new tit("状态","status",function (status) {
    if(status==1){
        return "没有计算";
    }else if(status ==1){
        return "计算";
    }else {
        return "发放";
    }

})];





table.push(currentLock);
table.push(lockRecord);
table.push(unlockRecord);

table.push(applicationRecord);

table.push(bonusRecord);

table.push(mineRecord);

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
//size,preTotal,first,last,index



