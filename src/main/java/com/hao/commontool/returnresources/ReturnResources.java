package com.hao.commontool.returnresources;

import java.util.HashMap;
import java.util.Map;

/**  返回字符集公共处理
 * @Description:
 * @Company:
 * @version: 1.0
 * @date 2021/1/20 - 13:47
 */
public class ReturnResources {
    public static Map<String, Object> strToJson(boolean success, Object data, String... params) {

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("success", success);
        m.put("data", data);

        if (null != params && params.length > 0) {
            m.put("msg", params[0]);
            if (params.length > 1) {
                m.put("errorType", params[1]);
            }

        }
        return m;
    }
}
