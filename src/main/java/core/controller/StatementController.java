package core.controller;

import core.dao.StatementDao;
import core.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatementController {
    @Autowired
    StatementDao statementDao;

    @PostMapping(path = "/statement")
    public List<Transaction> getStatementList(@RequestBody Transaction transaction){
        return statementDao.getStatementList(transaction);
    }

}
