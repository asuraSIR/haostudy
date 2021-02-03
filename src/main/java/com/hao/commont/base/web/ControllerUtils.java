package com.hao.commont.base.web;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 */
public class ControllerUtils {

	/**
	 * @Description: 全局返回处理结果json
	 * @date: 2019年5月30日 上午9:23:10
	 * @param success
	 * @param data
	 * @param params  第一个参数是错误信息 第二个参数是 错误类型errorType 编码
	 * @return
	 */
	public static Map<String, Object> dealResult(boolean success, Object data, String... params) {

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
