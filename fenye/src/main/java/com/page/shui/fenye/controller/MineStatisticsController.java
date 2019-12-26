package com.page.shui.fenye.controller;

import com.alibaba.fastjson.JSON;
import com.page.shui.fenye.MineDataServer;
import com.page.shui.fenye.dto.*;
import com.page.shui.fenye.util.DateUtil;
import com.page.shui.fenye.util.ExportUtil;
import com.page.shui.fenye.util.StringUtil;
import com.page.shui.fenye.util.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/mineStatistics")
public class MineStatisticsController {
    /**
     * index 0 返回参数错误，1 挖矿，2 分红
     * @param index
     * @param request
     * @param response
     */
    @RequestMapping("/data.do")
    public void mineData(int index, int size, long preTotal, HttpServletRequest request, HttpServletResponse response) {
        try {
            Date startDate = formDate("start",request);
            Date endDate = formDate("end",request);
            if(startDate == null){
                startDate = new Date();
            }
            if(endDate == null){
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DATE,100);
                endDate = calendar.getTime();
            }
            AdminResult adminResult = new AdminResult<>();
            if(index == 1){
                List<MineStatisticsDTO> mineDTO = MineDataServer.mineRecord(size, preTotal, startDate, endDate);
                adminResult.setData(mineDTO);
            }else if(index ==2){
                List<BonusStatisticsDTO> bonusDTO = MineDataServer.userBonusRecord(size, preTotal, startDate, endDate);
                adminResult.setData(bonusDTO);
            }else if(index==3){
                List<CurrentLockDTO> currentLockDTOS = MineDataServer.currentLock(size, preTotal, startDate, endDate);
                adminResult.setData(currentLockDTOS);
            }else {
                adminResult.setMsg(" index 参数错误");
                adminResult.setCode(-1);
                WebUtil.outputAdmin(adminResult, response);
                return;
            }
            WebUtil.outputAdmin(adminResult, response);
        } catch (Exception ex) {
           log.error("MineStatisticsController  mineData 出错", ex);
        }
    }
    private Date formDate(String name, HttpServletRequest request){
        String dataStr = request.getParameter(name);
        Date date = StringUtil.isEmpty(dataStr) ? null : DateUtil.getDate(dataStr.replace("&nbsp;", " "), DateUtil.DATE_FORMAT_ZH_CN);
        return date;
    }

    @RequestMapping(value = "/export.do", method = {RequestMethod.GET,RequestMethod.POST})
    public void export(Integer index,  HttpServletRequest request, HttpServletResponse response) {

        try {


            String jsonStr2 =  request.getParameter("jsonstr");
            String json = URLDecoder.decode(jsonStr2, "utf-8");

            Date startDate = formDate("start",request);
            Date endDate = formDate("end",request);

            if(startDate == null){
                startDate = new Date();
            }
            if(endDate == null){
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DATE,100);
                endDate = calendar.getTime();
            }
            AdminResult adminResult = new AdminResult<>();
            List<TitleDTO> titleDTOS = JSON.parseArray(json,TitleDTO.class);
            String fName = "挖矿";
            List<Map<String, Object>> maps = new ArrayList<>();
            if(index == 1){
                List<MineStatisticsDTO> mineDTO = MineDataServer.mineRecord(10000, 0, startDate, endDate);
                maps = MineDataServer.exportData(mineDTO);
            }else if(index ==2){
                fName = "分红";
                List<BonusStatisticsDTO> bonusDTO = MineDataServer.userBonusRecord(10000, 0, startDate, endDate);
                maps = MineDataServer.exportData(bonusDTO);
            }else if(index ==2){
                fName = "当前挖矿";
                List<CurrentLockDTO> bonusDTO = MineDataServer.currentLock(10000, 0, startDate, endDate);
                maps = MineDataServer.exportData(bonusDTO);
            }else {
                adminResult.setMsg(" index 参数错误");
                adminResult.setCode(-1);
                WebUtil.outputAdmin(adminResult, response);
                return;
            }
            OutputStream os = response.getOutputStream();
            ExportUtil.responseSetProperties(fName, response);
            ExportUtil.doExport(maps, titleDTOS, os);
        }catch (Exception ex){
           log.error(" MinePointsStatisticsController export 出错",ex);
        }


    }
}
