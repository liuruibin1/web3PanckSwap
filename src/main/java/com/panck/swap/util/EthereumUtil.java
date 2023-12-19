package com.panck.swap.util;

import okhttp3.OkHttpClient;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class EthereumUtil {

    private static final String PATTERN1 = "^0x[0-9a-fA-F]{40}$";

    public static boolean checksumAddress(String address) {
        return Pattern.matches(PATTERN1, address);
    }

    public static String getAddressByPrivateKey(String privateKey) {
        Credentials credentials = Credentials.create(privateKey);
        return Keys.toChecksumAddress(credentials.getAddress());
    }

    public static Web3j getWeb3jByRpcUrl(boolean enableProxy, String rpcUrl) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder
                .connectTimeout(Duration.of(10, ChronoUnit.SECONDS));
        if (enableProxy) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
            httpClientBuilder.proxy(proxy);
        }
        //
        return Web3j.build(new HttpService(rpcUrl, httpClientBuilder.build()));
    }

    private static BigInteger getGasPrice(Web3j web3j) throws IOException {
        //gas价格
        EthGasPrice ethGasPrice = web3j.ethGasPrice().send();
        BigInteger gasPrice = ethGasPrice.getGasPrice();
        //增加 5% 的价格
        return gasPrice.add(ethGasPrice.getGasPrice().divide(BigInteger.valueOf(20)));
    }
}
