package org.example.service.impl;

import org.example.dao.AccountDao;
import org.example.domain.Account;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/14
 * @version: 1.0.0
 * @description:
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    /**
     * 查询所有账户
     *
     * @return
     */
    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
//        System.out.println("AccountServiceImpl.findAll");
//        return null;
    }

    /**
     * 插入一条用户信息
     *
     * @param account
     */
    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    /**
     * 根据id查询账户信息
     *
     * @param id
     * @return
     */
    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    /**
     * 更新账户信息
     *
     * @param account
     */
    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        accountDao.delete(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Override
    public void deleteBatch(Integer[] ids) {
        accountDao.deleteBatch(ids);
    }


}
