package org.example.controller;

/**
 * @author: ymm
 * @date: 2022/8/10
 * @version: 1.0.0
 * @description:
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/quick")
    public String quick() {
        System.out.println("springmvc");

        // 视图跳转
        return "/WEB-INF/pages/success.jsp";
    }

}
