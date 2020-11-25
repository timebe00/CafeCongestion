package com.example.demo.nativeinterface.cpptest;

public class PositionRec {
    public String symIdent;
    public int quantity;
    public double marketPrice;
    public String toString() {
        return "[" + symIdent + "," + quantity + "," + marketPrice + "]";
    }
}