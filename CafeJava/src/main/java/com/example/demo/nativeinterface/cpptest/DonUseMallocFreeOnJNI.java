package com.example.demo.nativeinterface.cpptest;

public class DonUseMallocFreeOnJNI {
    native public static PositionRec[] getPositionBlotter();
    native public static void newBasedArray(long[] dist, long[] angle1, int len);

    static {
        System.loadLibrary("cpptest");
    }
}
