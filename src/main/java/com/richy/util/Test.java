package com.richy.util;

import java.util.UUID;

/**
 * TODO
 *
 * @author Richy
 * @date 2021-01-10 17:51
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-","").toUpperCase());
    }
}
