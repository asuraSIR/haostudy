package com.hao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aa")
public class ADS {
@RequestMapping("/bb")
    public String bb(){
        return "casepage/richtexteditor/ueditor";
    }
}
