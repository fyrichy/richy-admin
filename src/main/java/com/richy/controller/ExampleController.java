package com.richy.controller;

import com.richy.constants.JWTConstant;
import com.richy.dto.UserDTO;
import com.richy.util.JWTUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
    @GetMapping("info")
    public String queryUserInfo(String name,Integer age){
        return "getInfo";
    }

    /**
     * @desc:
     * 获取token
     * @method: getToken
     * @param:	userDTO:
     * @date:   2021-01-10 18:32
     * @return: java.lang.String
     */
    @PostMapping("getToken")
    public String getToken(@RequestBody UserDTO userDTO,HttpServletResponse response){
       String token = JWTUtil.createToken(userDTO.getUsername());
       response.addCookie(JWTUtil.buildCookie(token));
       return token;
    }

    /**
     * @desc:
     * 模拟请求
     * @method: doRequest
     * @param:	request:
     * @param:	response:
     * @date:   2021-01-10 18:37
     * @return: java.lang.String
     */
    @PostMapping("doRequest")
    public String doRequest(HttpServletRequest request, HttpServletResponse response){
        String token = JWTUtil.getCookie(request, JWTConstant.TOKEN_COOKIE_KEY);
        String username = JWTUtil.verifyToken(token);
        return username;
    }
}
