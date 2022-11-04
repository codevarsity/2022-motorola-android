// IStringConcat.aidl
package com.example.boundservice;

// Declare any non-default types here with import statements

interface IStringConcat {
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);
    String concat(in List<String> items);
}