package core.controller;

import core.dao.StatementDao;
import core.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatementController {
    @Autowired
    StatementDao statementDao;

    @RequestMapping(path = "/getlist", method= RequestMethod.GET)
    public int getStatementList(@RequestBody Transaction transaction){
        statementList = statementDao.
    }

}
