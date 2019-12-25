var table = new Array();

var  currentLock = new Object(); //当期锁仓

currentLock.id = 1;
currentLock.name = "交易对流水";
currentLock.title= [new tit("更新时间","createdDate"),new tit("交易对","symbolName"),new tit("头寸","position",function (position) {
    return position+" 张";
    
}),new tit("期权价格","price",function (price) {
    return price+" USDT";

})];

table.push(currentLock);