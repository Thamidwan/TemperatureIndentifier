/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.pojo;

/**
 *
 * @author USER
 */
public class Employee {
    private String name;
    private double temp;

    public Employee() {
    }

    public Employee(String name, double temp) {
        this.name = name;
        this.temp = temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", temp=" + temp + '}';
    }
    
    
}
