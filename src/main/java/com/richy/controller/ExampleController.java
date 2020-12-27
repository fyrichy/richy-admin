package com.richy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * 
 * @author: Richy
 * @date: 2020/12/27/0027 17:31
 */
@RequestMapping("example")
@RestController
public class ExampleController {

    /**
     * 获取详情
     * @return
     */
    @PostMapping("info")
    public String getInfo(){
        return "getInfo";
    }
}
