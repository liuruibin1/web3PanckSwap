package com.panck.swap.controller;

import com.panck.swap.abi.Panckswap;
import com.panck.swap.enumer.Rpc;
import com.panck.swap.util.ContractUtil;
import com.panck.swap.util.vo.RpcConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PanckSwapController {

    @Value("${app.http.proxy.enable}")
    protected boolean httpProxyEnable;

    @Value("${app.http.proxy.host}")
    protected String httpProxyHost;

    @Value("${app.http.proxy.port}")
    protected int httpProxyPort;

    @Value("${app.apiKey}")
    protected String apiKey;

    @GetMapping("/exchangeUsdtPrice")
    public String exchangeUsdtPrice(@RequestParam long amountIn, @RequestParam String redeemedAddress) {
        RpcConfig rpcConfig = new RpcConfig(httpProxyEnable, Rpc.getRandomRpc().getValue(), "", "", apiKey);
        Panckswap panckswap = ContractUtil.getPanckSwap(rpcConfig, "0x10ED43C718714eb63d5aA57B78B54704E256024E");
        List<String> list = new ArrayList<>();
        //默认usdt地址
        list.add("0x55d398326f99059fF775485246999027B3197955");
//        list.add("0x41b264a20bdb59ebbe78795b587a13e3b3530c93");
        list.add(redeemedAddress);
        String price = null;
        try {
            List send = panckswap.getAmountsOut(BigInteger.valueOf(amountIn), list).sendAsync().get();
            if (null != send) {
                Object usdtNum = send.get(0);
                Object num = send.get(1);
                BigDecimal divide = BigDecimal.valueOf(Long.parseLong(usdtNum.toString())).divide(BigDecimal.valueOf(Long.parseLong(num.toString())), 2, RoundingMode.UP);
                price = divide.toString();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return price;
    }
}
