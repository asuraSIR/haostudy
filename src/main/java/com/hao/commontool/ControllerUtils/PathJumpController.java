package com.hao.commontool.ControllerUtils;

import com.hao.commontool.returnresources.ReturnResources;
import com.hao.commontool.utils.GetDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Company:
 * @version: 1.0
 * @date 2021/1/21 - 10:01
 */
@Controller
public class PathJumpController {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/index")
    public String index() throws IOException {
        return "index";
    }

    /**
     *
     * @param module
     * @param file   如果包含下画线认为是子模块进行路径处理
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/{module}/jsp/{file}")
    public String navigation(@PathVariable String module, @PathVariable String file) throws Exception {
        file = file.replace("_", "/");
        System.out.println("in index path module:" + module + " file:" + file);
        dealXss();
        String path = module + "/" + file;
        return path;
    }

    /*@RequestMapping(value = "/getLoginInfo")
    @ResponseBody
    public Map<String, Object> getLoginInfo(HttpServletRequest request) throws IOException {
        return ReturnResources.strToJson(true, ControllerUtils.getLoginUser(request));
    }*/

    /**
     * 获得服务器当前时间
     *
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/currentTime")
    @ResponseBody
    public String currentTime() throws IOException {
        return GetDate.getStringDate();
    }

    /**
     * @Description:获得所有请求路径
     * @date: 2019年5月30日 下午3:20:52
     * @return
     */
    @RequestMapping(value = "/mapping")
    @ResponseBody
    public Map<String, Object> mappings() {
        List<HashMap<String, String>> urlList = new ArrayList<HashMap<String, String>>();

        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            RequestMappingInfo info = m.getKey();
            HandlerMethod method = m.getValue();
            PatternsRequestCondition p = info.getPatternsCondition();
            for (String url : p.getPatterns()) {
                hashMap.put("url", url);
            }
            hashMap.put("className", method.getMethod().getDeclaringClass().getName()); // 类名
            hashMap.put("method", method.getMethod().getName()); // 方法名

            RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
            String type = methodsCondition.toString();
            if (type != null && type.startsWith("[") && type.endsWith("]")) {
                type = type.substring(1, type.length() - 1);
                hashMap.put("type", type); // 方法名
            }
            urlList.add(hashMap);
        }
        return ReturnResources.strToJson(true, urlList);
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
