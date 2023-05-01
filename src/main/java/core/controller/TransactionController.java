package core.controller;

import core.dao.AccountDao;
import core.dao.TransactionDao;
import core.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
public class TransactionController {

    @Autowired
    TransactionDao transactionDao;

    @RequestMapping (path = "/execute_transaction", method = RequestMethod.POST)
    public BigDecimal executeTransaction(@RequestBody Transaction transaction){
        BigDecimal newBalance=transactionDao.executeTransaction(transaction);
        return newBalance;
    }

}
