package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: ymm
 * @date: 2022/8/13
 * @version: 1.0.0
 * @description:
 */
@Controller
public class TargetController {


    @RequestMapping("/target")
    public String targetMethod() {
        System.out.println("TargetController.targetMethod");
        return "success";
    }

}
