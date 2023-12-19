package com.panck.swap.util;

import com.panck.swap.abi.Panckswap;
import com.panck.swap.util.vo.RpcConfig;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.DefaultGasProvider;

public class ContractUtil {


    public static Panckswap getPanckSwap(RpcConfig rpcConfig, String erc20Address) {
        Web3j web3j = EthereumUtil.getWeb3jByRpcUrl(rpcConfig.isEnableProxy(), rpcConfig.getRpcUrl());
        Credentials credentials = Credentials.create("<privite key>");
        return Panckswap.load(erc20Address, web3j, credentials, new DefaultGasProvider());
    }
}
