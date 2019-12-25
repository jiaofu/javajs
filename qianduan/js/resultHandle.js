function handSuccess(data,fnOk,fnError) {
    if(data.hasOwnProperty('code')){
        if(data.code==0){
            if(typeof fnOk == "function"){
                fnOk(data.data);
            }else{
                alert("操作成功");
            }
        }else{
            if(typeof fnError == "function"){
                fnError(data);
            }else if("msg" in data){
                alert(data.msg)
            }else{
                alert("操作失败");
            }
        }
    }else {
        if(typeof fnOk == "function"){
            fnOk(data.data);
        }
        return data;
    }

}
