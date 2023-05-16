package core.controller;

import core.dao.AccountDao;
import core.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AccountOpenController {

    @Autowired
    AccountDao accountDao;

    @RequestMapping(path = "/create-account", method = RequestMethod.POST)
    public int createAccount(@Valid @RequestBody Customer customer) {
        int newAccount = accountDao.createAccount(customer);
        return newAccount;
    }
}
