package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: ymm
 * @date: 2022/8/13
 * @version: 1.0.0
 * @description:
 */

@RestController // 组合注解，相当于组合了@Controller和@ResponseBody
@RequestMapping("/restful")
public class RestfulController {

    /**
     * 查询方法
     *
     * @param id
     * @return
     */
    //    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @GetMapping("/user/{id}")
    public String findById(@PathVariable Integer id) {
        return "findById: " + id;
    }

    /**
     * 新增方法
     *
     * @return
     */
    @PostMapping("/user")
    public String post() {

        return "post:";
    }

    /**
     * 更新方法
     *
     * @return
     */
    @PutMapping("/user")
    public String put() {

        return "put";
    }

    /**
     * 删除方法
     *
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Integer id) {

        return "delete:" + id;
    }

}
