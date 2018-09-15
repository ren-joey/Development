package com.company;

import java.util.BitSet;

public class BitSetTester {
    public BitSetTester(){
        System.out.println("\n***** BitSetTester *****");

        BitSet bs = new BitSet();
        BitSet bs2 = new BitSet();

        for(int i = 0; i < 10000; i++){
            if(i%13 == 0 && i%19 ==0){
                bs.set(i);
            }
        }

        for(int i = 0; i < 10000; i++){
            if(i%3 == 0 && i%5 == 0){
                bs2.set(i);
            }
        }

        System.out.printf("Initial pattern in bits1: %s\nsize: %d\n", bs, bs.size());
        System.out.printf("Initial pattern in bits2: %s\nsize: %d\n", bs2, bs2.size());

        bs2.and(bs);
        System.out.printf("bits2 AND bits1: %s\n", bs2);

        bs2.andNot(bs);
        System.out.printf("bits2 ANDNOT bits1: %s\n", bs2);

        bs2.or(bs);
        System.out.printf("bits2 OR bits1: %s\n", bs2);

        bs2.xor(bs);
        System.out.printf("bits2 XOR bits1: %s\n", bs2);
    }
}
