package com.boilerplate.bolilerplate.controller;

import com.boilerplate.bolilerplate.utils.Service;
import com.boilerplate.bolilerplate.utils.Web3jdemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boilerplate.bolilerplate.utils.Web3jdemo;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
//@RequestMapping()
public class HealthCheckController {
    @Autowired
    Service service;
    @Autowired(required = true)
    Web3jdemo web3jdemo;
    @GetMapping("/check/{S}")
    public String healthCheck(@PathVariable String S){
        if(service.checkHealth(S)){
            return "In Good Health";
        }
        return "Not Working";
    }
//    @GetMapping("/")
//    public BigInteger checkbal() throws ExecutionException, InterruptedException, TimeoutException {
//      return web3jdemo.checkBalance();
//    }
    @PostMapping("/bal/{networkaddr}/{contractaddr}")
    public BigInteger checkbal(@PathVariable String networkAddr,@PathVariable String contractAddr) throws ExecutionException, InterruptedException, TimeoutException {
      return web3jdemo.checkBalance(networkAddr,contractAddr);
    }
    @GetMapping("/blocknum")
    public String getBlockNumber() throws ExecutionException, InterruptedException {
        return web3jdemo.checkLatestBlockNumber();
    }
}
