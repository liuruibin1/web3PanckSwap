package com.panck.swap.enumer;

import java.util.Random;

public enum Rpc {
    PRC1("https://binance.llamarpc.com"),
    PRC2("https://bsc.blockpi.network/v1/rpc/public"),
    PRC3("https://bsc-dataseed3.defibit.io"),
    PRC4("https://rpc.ankr.com/bsc"),
    PRC5("https://bsc-dataseed3.defibit.io");

    private final String value;

    Rpc(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private static final Rpc[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Rpc getRandomRpc() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
