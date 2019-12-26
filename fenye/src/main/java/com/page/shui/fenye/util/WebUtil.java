package com.page.shui.fenye.util;

import com.page.shui.fenye.dto.AdminResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WebUtil {
    public static <T> void outputAdmin(AdminResult<T> adminResult, HttpServletResponse httpServletResponse) {
        outputAdmin(adminResult, httpServletResponse, "application/json", "UTF-8");
    }
    public static <T> void outputAdmin(AdminResult<T> adminResult, HttpServletResponse httpServletResponse, String ContentType, String encoding) {
        PrintWriter out = null;
        httpServletResponse.setContentType(ContentType);
        httpServletResponse.setCharacterEncoding(encoding);
        try {
            out = httpServletResponse.getWriter();
            out.print(adminResult.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } finally {
            out.close();
        }
    }
}
