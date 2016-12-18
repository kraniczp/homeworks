package com.peterkranicz.limitedincorp;


public abstract class People {
    
    protected String name;
    protected String birthdate;
    protected int salary;
    protected int property;
    
    public abstract int getSalary();
    public abstract String doJob();
    public abstract void doQuit();
}
