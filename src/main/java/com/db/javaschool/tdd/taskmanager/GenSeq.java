package com.db.javaschool.tdd.taskmanager;

/**
 * Created by oglujul on 26.12.2014.
 */
public class GenSeq {
    private static int id = 0;

    public static int genId() {
        return ++id;
    }
    public static void resetId() {
        id = 0;
    }
}
