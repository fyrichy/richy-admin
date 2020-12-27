package com.richy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * 示例接口
 * @author: Richy
 * @date: 2020-12-27 18:27
 */
@RequestMapping("example")
@RestController
public class ExampleController {

    /**
     * @desc:
     * 查询用户详细信息
     * @method: queryUserInfo
     * @param:	name: 姓名
     * @param:	age: 年龄
     * @date:   2020-12-27 18:32
     * @return: java.lang.String
     */
    @PostMapping("info")
    public String queryUserInfo(String name,Integer age){
        return "getInfo";
    }
}
