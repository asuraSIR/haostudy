package com.hao.commontool.ControllerUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @Description:
 * @Company:
 * @version: 1.0
 * @date 2021/1/21 - 10:01
 */
@Controller
public class PathJumpController {

    private HttpServletRequest request;
    /**
     *  WEB-INF目录下的文件，浏览器一般无法直接方法，只能通过重定向后才可以访问，如果需要直接访问，可以放在和WEB-INF同级目录下
     *  这里通过公共controller跳转路径路径
     * @param module
     * @param
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/{module}/jsp/{file}")
    public String navigation(@PathVariable String module, @PathVariable String file) throws Exception {
        file = file.replace("_", "/");
        System.out.println("in index path module:" + module + " file:" + file);
        //dealXss();
        return module + "/" + file;
    }

    // 处理参数, 反射型xss
    private void dealXss() throws Exception {
        Map<String, String[]> params = request.getParameterMap();

        for (String key : params.keySet()) {
            String[] values = params.get(key);
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    checkXssStr(values[i]);

                    values[i] = HtmlUtils.htmlEscape(values[i]);

                }
            }

        }

    }
    private void checkXssStr(String v) throws Exception {
        if (v != null) {
            for (int i = 0; i < XSS_STR.length; i++) {
                if (v.toUpperCase().contains(XSS_STR[i])) {
                    throw new Exception("请求参数中包含非发字符串!");
                }
            }
        }
    }
    private static String[] XSS_STR = new String[] { "'", ";", "\"", "(", ")", "ALERT", "FUNCTION", ">", "<", "SCRIPT" };
}
