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
public class ExceptionController {

    @RequestMapping("/testException")
    public String testException() {
        int i = 1 / 0;
        return "success";
    }
}
