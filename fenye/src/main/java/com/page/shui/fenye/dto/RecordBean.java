package com.page.shui.fenye.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RecordBean {

    private String symbolName;
    private int period;

    private String position;  //期权头寸

    private String price;  // 期权价格

    private Date createdDate;
}
