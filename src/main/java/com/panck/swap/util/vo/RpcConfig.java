package com.panck.swap.util.vo;

public class RpcConfig {

    boolean enableProxy;

    String rpcUrl;

    String rpcUrl2;

    String rpcUrl3;

    String apiKey;

    public RpcConfig(boolean enableProxy, String rpcUrl, String rpcUrl2, String rpcUrl3, String apiKey) {
        this.enableProxy = enableProxy;
        this.rpcUrl = rpcUrl;
        this.rpcUrl2 = rpcUrl2;
        this.rpcUrl3 = rpcUrl3;
        this.apiKey = apiKey;
    }

    public boolean isEnableProxy() {
        return enableProxy;
    }

    public void setEnableProxy(boolean enableProxy) {
        this.enableProxy = enableProxy;
    }

    public String getRpcUrl() {
        return rpcUrl;
    }

    public void setRpcUrl(String rpcUrl) {
        this.rpcUrl = rpcUrl;
    }

    public String getRpcUrl2() {
        return rpcUrl2;
    }

    public void setRpcUrl2(String rpcUrl2) {
        this.rpcUrl2 = rpcUrl2;
    }

    public String getRpcUrl3() {
        return rpcUrl3;
    }

    public void setRpcUrl3(String rpcUrl3) {
        this.rpcUrl3 = rpcUrl3;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
