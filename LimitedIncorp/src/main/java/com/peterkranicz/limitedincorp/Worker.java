package com.peterkranicz.limitedincorp;


public class Worker extends People{
    
    private String job;
    private final int id;
    
    public Worker(int id, String name, String birthdate,int salary, int property) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.salary = salary;
        this.property = property;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getProperty() {
        return property;
    }

    public void setProperty(int property) {
        this.property = property;
    }

    public void setJob(String job) {
        this.job = job;
    }
    
    @Override
    public String doJob(){
        return job;
    }
    
    @Override
    public void doQuit(){
        for(int d = 0; d < Ltd.getWorkerList().size(); d++){
            if(id == Ltd.getWorkerList().get(d).id){
                String w = Ltd.getWorkerList().get(d).getName();
                Ltd.getWorkerList().remove(d);
                System.out.println("This worker: " + w + "just fired!");
            }
        }
    }
}
