package com.zsj.utils;

import java.util.Random;

/**
 * @author zsj
 */
public class Keyutils{
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}