package com.peterkranicz.limitedincorp;


public class Boss extends People{
    
    private String job;
    private final int id;
    
    public Boss(int id,String name, String birthdate,int salary, int property) {
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
            
    @Override
    public String doJob(){
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    
    @Override
    public void doQuit(){
        for(int d = 0; d < Ltd.getBossesList().size(); d++)
        if(id == Ltd.getBossesList().get(d).id){
            String w = Ltd.getBossesList().get(d).getName();
            Ltd.getBossesList().remove(d);
            System.out.println("This boss: " + w + "just fired!");
        }
    }
    
    public static void doFire(int i, int k){
        if( k == 3){
            String w = Ltd.getWorkerList().get(i).getName();
            Ltd.getWorkerList().remove(i);
            System.out.println("This worker: " + w + "just fired!");
        }
    }
}
