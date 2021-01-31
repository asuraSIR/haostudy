package com.hao.contrellor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Company:
 * @version: 1.0
 * @date 2021/1/31 - 19:07
 */
@Controller
@RequestMapping("/a")
public class UtliController {
    @RequestMapping("/aa")
    public String aa(){
        return "richtexteditor/ueditor";
    }
}
