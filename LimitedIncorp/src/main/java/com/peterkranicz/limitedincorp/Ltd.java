package com.peterkranicz.limitedincorp;

import java.util.ArrayList;
import java.util.List;


public class Ltd {
    private static String name;
    private static String location;
    private static String specialise;
    private static Ltd instance;
    private static int property;
    private int sumogpeople;
    private int sumofbosses;
    private static List<Boss> bossesList;
    private static List<Worker> workerList;

    private Ltd(String name, String location, String specialise, int property) {
        Ltd.name = name;
        Ltd.location = location;
        Ltd.specialise = specialise;
        Ltd.property = property;
        Ltd.bossesList = new ArrayList<>();
        Ltd.workerList = new ArrayList<>();
    }

    public static Ltd getInstance(String name, String location, String specialise, int property){
        if(instance == null){
            instance = new Ltd(name,location,specialise,property);
        }
        return instance;    
    }
    
    public static boolean isExist(){
        return Ltd.isExist();
    }
    
    public static List<Boss> getBossesList() {
        return bossesList;
    }

    public static List<Worker> getWorkerList() {
        return workerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Ltd.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        Ltd.location = location;
    }

    public String getSpecialise() {
        return specialise;
    }

    public void setSpecialise(String specialise) {
        Ltd.specialise = specialise;
    }

    public int getProperty() {
        return property;
    }

    public void setProperty(int property) {
        Ltd.property = property;
    }

    public int getSumogpeople() {
        return sumogpeople;
    }

    public void setSumogpeople(int sumogpeople) {
        this.sumogpeople = sumogpeople;
    }

    public int getSumofbosses() {
        return sumofbosses;
    }

    public void setSumofbosses(int sumofbosses) {
        this.sumofbosses = sumofbosses;
    }

    public void getPeopleSalary(int k, int h){
        Ltd.bossesList.get(k).setSalary(h);
    }
    
    public static void doJob(int k, int h, String jobtitle){
        if(h == 3) { Ltd.bossesList.get(k).setJob(jobtitle);}
        if(h == 4) { Ltd.workerList.get(k).setJob(jobtitle);}
    }
    
    public static void doFire(int i, int k){
        if( k == 3){
            String w = Ltd.getWorkerList().get(i).getName();
            Ltd.getWorkerList().remove(i);
            System.out.println("This worker: " + w + "just fired!");
        }
        if( k == 4){
            String w = Ltd.getBossesList().get(i).getName();
            Ltd.getBossesList().remove(i);
            System.out.println("This worker: " + w + "just fired!");
        }
    }
}
