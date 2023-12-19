# web3PanckSwap
call panckswap V2 interface to query usdt price

<h2>1、pom说明</h2>
<h3>可通过https://mvnrepository.com/artifact/org.web3j/core/5.0.0查看相应依赖</h3>

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
        
<h3>编译abi生成java代码</h3>
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
        

<h2>2、PRC说明</h2>
PRC1("https://binance.llamarpc.com"),
    PRC2("https://bsc.blockpi.network/v1/rpc/public"),
    PRC3("https://bsc-dataseed3.defibit.io"),
    PRC4("https://rpc.ankr.com/bsc"),
    PRC5("https://bsc-dataseed3.defibit.io");
使用的是免费的bnb网络的rpc


#注意事项
这是一个请求panckSwap查询代币兑换usdt价格的接口，可直接打包到服务器使用
<h2>效果如下</h2>
![image](https://github.com/liuruibin1/web3PanckSwap/assets/68451339/34b5410e-3436-4832-b485-ef58a6d4c276)
<h3>application配置注意</h3>
app:
  apiKey: ethscan 的apikey or bscscan 的 apikey
  # 代理
  http:
    proxy:
      enable: true
      host: localhost
      port: 7890

<h2>代码注意</h2>
public class ContractUtil {
    public static Panckswap getPanckSwap(RpcConfig rpcConfig, String erc20Address) {
        Web3j web3j = EthereumUtil.getWeb3jByRpcUrl(rpcConfig.isEnableProxy(), rpcConfig.getRpcUrl());
        // 此处改为自己钱包的私钥地址
        Credentials credentials = Credentials.create("<privite key>");
        return Panckswap.load(erc20Address, web3j, credentials, new DefaultGasProvider());
    }
}


