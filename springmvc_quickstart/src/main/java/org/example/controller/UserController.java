package org.example.controller;

/**
 * @author: ymm
 * @date: 2022/8/10
 * @version: 1.0.0
 * @description:
 */

import org.example.domain.QueryVo;
import org.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping("/user") // 一级访问目录
@SessionAttributes("username") // 向request中存入的key为username时，同步到session域中
public class UserController {

    /**
     * @RequestMapping path等同于value
     * method：限定请求方式，不符合会报错
     * params：限定请求参数，不符合会报错
     */
    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {})// 二级访问目录
    public String quick() {
        System.out.println("springmvc");

        // 视图跳转
//        return "/WEB-INF/pages/success.jsp"; // 已配置viewResolver
        return "success";
    }

    /**
     * 获取基本类型请求参数
     *
     * @param id
     * @param username
     * @return
     */
    @RequestMapping("/simpleParam")
    public String simpleParam(Integer id, String username) {
        System.out.println("id = " + id);
        System.out.println("username = " + username);

        return "success";
    }

    /**
     * 获取对象类型参数
     *
     * @param user
     * @return
     */
    @RequestMapping("/pojoParam")
    public String pojoParam(User user) {
        System.out.println("user = " + user);

        return "success";
    }

    /**
     * 获取数组类型参数
     *
     * @param ids
     * @return
     */
    @RequestMapping("/arrayParam")
    public String arrayParam(Integer[] ids) {
        System.out.println("ids = " + Arrays.toString(ids));

        return "success";
    }

    /**
     * 获取集合类型参数
     *
     * @param queryVo
     * @return
     */
    @RequestMapping("/queryParam")
    public String queryParam(QueryVo queryVo) {
        System.out.println("queryVo = " + queryVo);

        return "success";
    }

    /**
     * 获取日期类型参数（自定义类型转换器）
     *
     * @param birthday
     * @return
     */
    @RequestMapping("/converterParam")
    public String converterParam(Date birthday) {
        System.out.println("birthday = " + birthday);

        return "success";
    }

    /**
     * \@RequestParam的使用
     * name：页面传递的参数名
     * defaultValue 默认值
     * required  是否必须传递该参数，默认true，如果设置defaultValue该值自动改为false
     *
     * @param myBirthday
     * @return
     */
    @RequestMapping("/requestParam")
    public String requestParam(@RequestParam(name = "birthday", defaultValue = "1999-9-9", required = true) Date myBirthday) {
        System.out.println("myBirthday = " + myBirthday);

        return "success";
    }

    /**
     * 获取请求头数据
     *
     * @param cookie
     * @return
     */
    @RequestMapping("requestHeader")
    public String requestHeader(@RequestHeader("cookie") String cookie) {
        System.out.println("cookie = " + cookie);
        return "success";
    }

    /**
     * \@CookieValue
     *
     * @param jsessionId
     * @return
     */
    @RequestMapping("cookieValue")
    public String cookieValue(@CookieValue("JSESSIONID") String jsessionId) {
        System.out.println("jsessionId = " + jsessionId);
        return "success";
    }

    /**
     * 原始ServletAPI的获取
     *
     * @return
     */
    @RequestMapping("servletAPI")
    public String servletAPI(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        return "success";
    }

    /**
     * 通过原始ServletAPI进行页面跳转
     *
     * @return
     */
    @RequestMapping("/returnVoid")
    public void returnVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 直接返回数据
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("响应数据");

        // 借助request对象完成请求转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

        // 借助response对象完成重定向,两次请求，WEB-INF是安全目录，只能进行服务器内转发
//        response.sendRedirect(request.getContextPath() + "index.jsp");
    }

    /**
     * forward进行请求转发
     *
     * @return
     */
    @RequestMapping("/forward")
    public String forward(Model model) {
        // 向模型值设置值
        model.addAttribute("value", "转发参数");


        // 使用请求转发，既可以转发到jsp也可以转发到其他控制器方法
//        return "forward:/user/quick";
        return "forward:/WEB-INF/pages/success.jsp";
    }





    @RequestMapping("/redirect")
    public String redirect(Model model) {
        // 底层使用的还是request.setAttribute("key","value") 域范围是一次请求，重定向时取不出model的值
        model.addAttribute("value", "重定向参数");
        model.addAttribute("username", "张飞");
        return "redirect:/index.jsp";
    }
    /**
     * \@sessionAttributes的效果
     */
    @RequestMapping("sessionAttributes")
    public String sessionAttributes() {
        return "success";
    }


    /**
     * 使用forward或redirect时，不会再走视图解析器
     */


    /**
     * 方式1
     *
     * @return
     */
    @RequestMapping("/returnModelAndView")
    public ModelAndView returnModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        // 设置模型数据
        modelAndView.addObject("value", "ModelAndView方式一");
        // 设置视图名称，视图解析器解析modelAndView 拼接前缀和后缀
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 方式2：SpringMVC会自动注入ModelAndView参数
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping("/returnModelAndView2")
    public ModelAndView returnModelAndView2(ModelAndView modelAndView) {
        // 设置模型数据
        modelAndView.addObject("value", "ModelAndView方式二");
        // 设置视图名称，视图解析器解析modelAndView 拼接前缀和后缀
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
