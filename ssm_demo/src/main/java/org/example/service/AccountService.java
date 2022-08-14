package org.example.service;

import org.example.domain.Account;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/14
 * @version: 1.0.0
 * @description:
 */
public interface AccountService {

    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 插入一条用户信息
     *
     * @param account
     */
    public void save(Account account);

    /**
     * 根据id查询账户信息
     * @param id
     * @return
     */
    public Account findById(Integer id);

    /**
     * 更新账户信息
     * @param account
     */
    public void update(Account account);

    /**
     * 根据id删除用户信息
     * @param id
     */
    public void delete(Integer id);


    /**
     * 批量删除
     *
     * @param ids
     */
    public void deleteBatch(Integer[] ids);
}
