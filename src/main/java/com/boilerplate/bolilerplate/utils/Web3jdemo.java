package com.boilerplate.bolilerplate.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGetBlockTransactionCountByNumber;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.core.DefaultBlockParameter;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.web3j.protocol.core.methods.response.EthGetBalance;
@Service
public class Web3jdemo {

    @Autowired
    constants constants;
    public BigInteger checkBalance(String networkAddr,String contractAddr) throws ExecutionException, InterruptedException, TimeoutException {
        System.out.println("Hello world!");
        final Web3j client = Web3j.build(new HttpService(networkAddr));
        final EthGetBalance bal= client.ethGetBalance(contractAddr, DefaultBlockParameter.valueOf("latest")).sendAsync().get(10, TimeUnit.SECONDS);
        final BigInteger unscalebal= bal.getBalance();
        System.out.println(unscalebal);
        return unscalebal;
    }

    public String checkLatestBlockNumber() throws ExecutionException, InterruptedException {
        final Web3j client = Web3j.build(new HttpService(constants.networkAddr));
        final EthBlockNumber blocknum=client.ethBlockNumber().sendAsync().get();
        System.out.println(blocknum);
        return blocknum.toString();
    }
}