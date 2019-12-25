var mask=(function () {
    //.bgbody{ display: none;  position: fixed;  top: 0;  left: 0; bottom: 0  ;left:0;width: 100%;  height: 100%;  background-color: black;  z-index:1001;    opacity:.70;  filter: alpha(opacity=70);}

    var show=function () {
        if($("#bgbody").length==1){
            $("#bgbody").show();
        }else{
        var bgbody="<div id=\"bgbody\"></div>";
        $("body").append(bgbody);
        $("#bgbody").css({
            "position": "fixed",
            "top": 0,
              "left": 0,
            "bottom": 0  ,
            "left":0,
            "width": "100%",
            "height": "100%",
            "background-color": "black",
            "z-index":"1001",
            "opacity":0.70,
            "filter": "alpha(opacity=70)"
        })

        }
    }
    var hide=function () {
        $("#bgbody").hide();
    }
    var showHtml=function (obj) {

        //        #show{display: none;  position: fixed;  top: 200px;  left:50px;  width: 30%;  height: 30%;  padding: 8px;  border: 8px solid #E8E9F7;  background-color: white;  z-index:1002;  overflow: auto;}

        if( $(obj).attr("z-index")>1000 &&  $(obj).attr("position")=="fixed"){
            $(obj).show();

        }else{
            var objwidth= $(obj).width();
            var objHeigth=$(obj).height();
            var bodyheight=window.innerHeight;
            var bodywidth=$("body").width();
            var  offsetwidth= (bodywidth-  objwidth)/2;
            var  offsetheigth= (bodyheight-  objHeigth)/2;
            if(offsetheigth>200){
                offsetheigth=offsetheigth-50;
            }
            $(obj).css("top",offsetheigth+"px");
            $(obj).css("left",offsetwidth+"px");
            $(obj).css("position","fixed");
            $(obj).css("z-index",1002);
            $(obj).show();
        }
    }
    var hideHtml=function (obj) {
        $(obj).hide();

    }
    return {
        show:show,
        hide:hide,
        showHtml:showHtml,
        hideHtml:hideHtml
    }
    
})();