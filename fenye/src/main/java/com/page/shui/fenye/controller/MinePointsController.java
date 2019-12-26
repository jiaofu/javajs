package com.page.shui.fenye.controller;


import com.page.shui.fenye.MineDataServer;
import com.page.shui.fenye.dto.AdminResult;
import com.page.shui.fenye.dto.RecordBean;
import com.page.shui.fenye.dto.UserMineDTO;
import com.page.shui.fenye.util.StringUtil;
import com.page.shui.fenye.util.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/mine")
public class MinePointsController {



    @RequestMapping("/index.do")
    public void index(HttpServletRequest request, HttpServletResponse response) {
        AdminResult<String> adminResult = new AdminResult<>();
        adminResult.setMsg("hello world");
        WebUtil.outputAdmin(adminResult, response);
    }

    @RequestMapping("getUserData.do")
    public void getUserData(HttpServletRequest request, HttpServletResponse response) {
        try {
            String userIdStr = StringUtil.isEmpty( request.getParameter("userId")) ? "0" : request.getParameter("userId");
            long userId = Long.parseLong(userIdStr);

            AdminResult<UserMineDTO> adminResult = new AdminResult<>();
            UserMineDTO userMineDTO = MineDataServer.getUserData(userId);
            if (userMineDTO == null) {
                adminResult.setMsg(" 没有此用户");
                adminResult.setCode(-1);
            } else {
                adminResult.setData(userMineDTO);
            }
            WebUtil.outputAdmin(adminResult, response);
        } catch (Exception ex) {
            log.error("MinePointsController  getUserData 出错", ex);
        }
    }




    @RequestMapping("getUserRecord.do")
    public void getUserRecord(long userId, int id, int size, long preTotal, HttpServletRequest request, HttpServletResponse response) {
        try {
            AdminResult adminResult = new AdminResult<>();
            if (userId == 0) {
                adminResult.setMsg(" 没有此用户");
                adminResult.setCode(-1);
                WebUtil.outputAdmin(adminResult, response);
                return;
            }
            if(size>100){
                adminResult.setMsg(" size 数量过大");
                adminResult.setCode(-1);
                WebUtil.outputAdmin(adminResult, response);
                return;
            }
            List list = null;
            switch (id) {
                case 1:
                    list = MineDataServer.currentLock(userId,size,preTotal);
                    break;
                case 2:
                    list = MineDataServer.lockRecord(userId,size,preTotal);
                    break;
                case 3:
                    list = MineDataServer.unlockRecord(userId,size,preTotal);
                    break;
                case 4:
                    list = MineDataServer.applicationRecord(userId,size,preTotal);
                    break;
                case 5:
                    list = MineDataServer.userBonusRecord(userId,size,preTotal);
                    break;
                case 6:
                    list = MineDataServer.mineRecord(userId,size,preTotal);
                    break;
                default:
                    adminResult.setMsg(" id参数错误");
                    adminResult.setCode(-1);
                    WebUtil.outputAdmin(adminResult, response);
                    return;
            }
            if(list == null){
                adminResult.setMsg(" 没有查询任何数据");
                adminResult.setCode(-1);
                WebUtil.outputAdmin(adminResult, response);
                return;
            }
            adminResult.setData(list);
            WebUtil.outputAdmin(adminResult, response);

        } catch (Exception ex) {
            log.error("MinePointsController  getUserData 出错", ex);
        }
    }
    @RequestMapping("getRecordBeans.do")
    public void getUserRecord(String symbolName, int size, long preTotal, HttpServletRequest request, HttpServletResponse response) {
        AdminResult adminResult = new AdminResult<>();
        List<RecordBean>  list = MineDataServer.getRecordBeans(symbolName,size,preTotal);
        adminResult.setData(list);
        WebUtil.outputAdmin(adminResult, response);
    }


}
