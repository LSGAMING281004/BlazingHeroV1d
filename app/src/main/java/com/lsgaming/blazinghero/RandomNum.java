package com.lsgaming.blazinghero;

import java.util.Random;

public class RandomNum {
    Random random = new Random();
    int rand;
    public int getOddRand() {
        for(int i=0;i<100;i++) {
            rand = random.nextInt(7);
            if (rand % 2 != 0)
                break;
        }
        return rand;
    }
    public int getEvenRand() {
        for(int i=0;i<100;i++) {
            rand = random.nextInt(7);
            if (rand % 2 == 0 && rand!=0)
                break;
        }
    return rand;
    }

}
