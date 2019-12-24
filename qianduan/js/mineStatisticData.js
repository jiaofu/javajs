var table = new Array();


var bonusRecord = new Object(); // 分红记录

var mineRecord = new Object(); // 挖矿记录
var  currentLock = new Object(); //当期锁仓

mineRecord.id = 1;
mineRecord.title =[ new tit("日期","mineData"),  new tit("用户ID","userId"),new tit("挖矿数量","amount")];

bonusRecord.id = 2;
bonusRecord.title = [ new tit("日期","bonusDate"),  new tit("用户ID","userId"),new tit("分红USDT","feeAmount"),  new tit("分红JEX","reduceAmount")];



currentLock.id = 3;
currentLock.name = "当期锁仓";
currentLock.title= [new tit("用户id","userId"),new tit("锁仓记录","lockDate"),new tit("锁仓数量","lockAmount"),new tit("最小锁仓时间","minLockDay"),new tit("已锁天数","lockedDay"),new tit("忠诚积分","loyaltyPoints"),new tit("锁仓积分","lockPoints"),new tit("仓位编号","storeNum")];



table.push(bonusRecord);

table.push(mineRecord);
table.push(currentLock);


