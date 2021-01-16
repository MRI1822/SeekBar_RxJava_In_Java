package com.mrigankprojects.seekbar_java_rxjava;

import java.util.ArrayList;

public class DataSource {

    private static ArrayList<Task> arrayList = new ArrayList<>();

    public static ArrayList<Task> createDataSource(){

        arrayList.add(new Task("This is task 1", 1, true));
        arrayList.add(new Task("This is task 2", 2, true));
        arrayList.add(new Task("This is task 3", 3, false));
        arrayList.add(new Task("This is task 4", 4, false));

        return arrayList;
    }
}
