package core.controller;

import core.dao.StatementDao;
import core.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatementController {
    @Autowired
    StatementDao statementDao;

    @RequestMapping(path = "/statement", method= RequestMethod.POST)
    public List<Transaction> getStatementList(@RequestBody Transaction transaction){
        return statementDao.getStatementList(transaction);
    }

}
