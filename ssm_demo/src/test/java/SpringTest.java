import org.example.domain.Account;
import org.example.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/14
 * @version: 1.0.0
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SpringTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void findAll(){
        List<Account> accountList = accountService.findAll();

        for (Account account : accountList) {
            System.out.println("account = " + account);
        }
    }
}

