# web3PanckSwap

Call Panckswap V2 interface to query USDT price.

## 1. Pom Explanation

You can check the corresponding dependencies on [Maven Repository](https://mvnrepository.com/artifact/org.web3j/core/5.0.0).

```xml
<dependency>
    <groupId>org.web3j</groupId>
    <artifactId>core</artifactId>
    <version>5.0.0</version>
</dependency>
<dependency>
    <groupId>com.squareup.okhttp3</groupId>
    <artifactId>okhttp</artifactId>
    <version>4.3.1</version>
</dependency>
```
        
## 2.Compile ABI to Generate Java Code

<h2>maven command:</h2>

<p>mvn web3j:generate-sources</p>

```xml
         <plugin>
                <groupId>org.web3j</groupId>
                <artifactId>web3j-maven-plugin</artifactId>
                <version>4.8.7</version> <!-- 替换为最新版本 -->
                <configuration>
                    <packageName>com.example.contract.abi</packageName>
                    <abiSourceFiles>
                        <directory>src/main/resources</directory>
                        <includes>
                            <include>abi/*.json</include>
                        </includes>
                    </abiSourceFiles>
                    <outputDirectory>
                        <java>src/main/java</java>
                    </outputDirectory>
                </configuration>
            </plugin>
```

## 3.RPC Explanation
    <h2>Using free BNB network RPC endpoints:</h2>
     <p>PRC1("https://binance.llamarpc.com"), </p>
     <p>PRC2("https://bsc.blockpi.network/v1/rpc/public"),</p>
     <p>PRC3("https://bsc-dataseed3.defibit.io"),</p>
     <p>PRC4("https://rpc.ankr.com/bsc"),</p>
     <p>PRC5("https://bsc-dataseed3.defibit.io");</p>

## Note
This is an interface to request PanckSwap for querying token-to-USDT exchange prices. It can be directly deployed to a server.


<h2>Demo</h2>
![image](https://github.com/liuruibin1/web3PanckSwap/assets/68451339/34b5410e-3436-4832-b485-ef58a6d4c276)

<h2>Application Configuration</h2>

```yml
app:
  apiKey: ethscan 的apikey or bscscan 的 apikey
  # 代理
  http:
    proxy:
      enable: true
      host: localhost
      port: 7890
```

## 4.Code Consideration
```java
public class ContractUtil {
    public static Panckswap getPanckSwap(RpcConfig rpcConfig, String erc20Address) {
        Web3j web3j = EthereumUtil.getWeb3jByRpcUrl(rpcConfig.isEnableProxy(), rpcConfig.getRpcUrl());
        // 此处改为自己钱包的私钥地址
        Credentials credentials = Credentials.create("<privite key>");
        return Panckswap.load(erc20Address, web3j, credentials, new DefaultGasProvider());
    }
}
```


