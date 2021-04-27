package me.luligabi.incantationem;

import java.util.Random;

public class Util {

    public static int randomNumber(Random random, int min, int max){
        return random.nextInt(max + 1 - min) + min;
    }
}
