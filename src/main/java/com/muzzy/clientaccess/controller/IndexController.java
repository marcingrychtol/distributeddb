package com.muzzy.clientaccess.controller;

import com.muzzy.dto.TransactionSet;
import com.muzzy.service.TransactionOutputService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("prototype")
public class IndexController {
    private final TransactionOutputService transactionOutputService;
    private final TransactionSet transactionSet;

    public IndexController(TransactionOutputService transactionOutputService, TransactionSet transactionSet) {
        this.transactionOutputService = transactionOutputService;
        this.transactionSet = transactionSet;
    }


    @GetMapping({"/","index"})
    public String getIndexPage(Model model){
            model.addAttribute("transactions", transactionOutputService.getAll());

        return "transaction/index";
    }


    @PostMapping("/add")
    public String doAdd(Model model){


//        transactionService.save(transaction);
//        transactionSet.sendAllTransaction();
        model.addAttribute("transactions", transactionOutputService.getAll());
        return "index";
    }

}
