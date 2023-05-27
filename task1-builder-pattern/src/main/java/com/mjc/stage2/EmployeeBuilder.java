package com.mjc.stage2;

public class EmployeeBuilder extends Employee{
    private String name;
    private String lastName;
    private String position;
    private String phone;
    private String email;
    private String carNumber;
    @Override
    public void setName(String name){
        this.name = name;
    }
    @Override
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    @Override
    public void setPosition(String position){
        this.position = position;
    }
    @Override
    public void setEmail(String email){
        this.email = email;
    }
    @Override
    public void setPhone(String phone){
        this.phone = phone;
    }
    @Override
    public void setCarNumber(String carNumber){
        this.carNumber = carNumber;
    }

}
