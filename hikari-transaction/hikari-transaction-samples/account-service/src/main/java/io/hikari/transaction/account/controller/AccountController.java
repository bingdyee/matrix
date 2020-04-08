package io.hikari.transaction.account.controller;

import io.hikari.transaction.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestParam("id") Long id,
                                             @RequestParam("commodityCode")  String commodityCode,
                                             @RequestParam("orderCount")  Integer orderCount) {
        accountService.purchase(id, commodityCode, orderCount);
        return ResponseEntity.ok("下单成功！");
    }

}
