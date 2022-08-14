package org.example.controller;

import org.example.domain.Account;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/14
 * @version: 1.0.0
 * @description:
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 查询所有账户信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model) {

//        List<Account> accountList = new ArrayList<>();
//        Account account = new Account();
//        account.setId(1);
//        account.setName("小绿");
//        account.setMoney(888d);
//        Account account1 = new Account();
//        account1.setId(2);
//        account1.setName("小红");
//        account1.setMoney(888d);
//
//        accountList.add(account);
//        accountList.add(account1);

        List<Account> accountList = accountService.findAll();
        model.addAttribute("list", accountList);
        return "list";
    }

    /**
     * 插入一条用户信息
     *
     * @param account
     */
    @RequestMapping("/save")
    public String save(Account account) {
        accountService.save(account);
        return "redirect:/account/findAll";
    }

    /**
     * 根据id查找用户信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/findById")
    public String findById(Integer id, Model model) {
        Account account = accountService.findById(id);
        model.addAttribute("account", account);
        return "update";
    }

    /**
     * 更新用户信息
     *
     * @param account
     * @return
     */
    @RequestMapping("/update")
    public String update(Account account) {
        accountService.update(account);
        return "redirect:/account/findAll";
    }

    /**
     * 批量删除用户信息
     *
     * @param ids
     * @return
     */
//    @RequestMapping("/deleteBatch")
//    public String deleteBatch(Integer[] ids) {
//        for (Integer id : ids) {
//            accountService.delete(id);
//        }
//        return "redirect:/account/findAll";
//    }

    @RequestMapping("/deleteBatch")
    public String deleteBatch(Integer[] ids) {
        accountService.deleteBatch(ids);
        return "redirect:/account/findAll";
    }

}
