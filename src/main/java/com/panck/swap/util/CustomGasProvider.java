package com.panck.swap.util;

import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;

public class CustomGasProvider implements ContractGasProvider {
    private final BigInteger gasPrice;
    private final BigInteger gasLimit;

    public CustomGasProvider(BigInteger gasPrice, BigInteger gasLimit) {
        this.gasPrice = gasPrice;
        this.gasLimit = gasLimit;
    }

    @Override
    public BigInteger getGasPrice(String contractFunc) {
        return gasPrice;
    }

    @Override
    public BigInteger getGasPrice() {
        return gasPrice;
    }

    @Override
    public BigInteger getGasLimit(String contractFunc) {
        return gasLimit;
    }

    @Override
    public BigInteger getGasLimit() {
        return gasLimit;
    }
}
