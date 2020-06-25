package com.company.person;

public class Person {
    private String name="";
    private String surname="";
    private String birthTown="";
    public Person(){

    }
    public Person(String name,String surname,String birthTown){
        this.birthTown=birthTown;
        this.name=name;
        this.surname=surname;
    }


    public void setBirthTown(String birthTown) {
        this.birthTown = birthTown;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getBirthTown() {
        return birthTown;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthTown='" + birthTown + '\'' +
                '}';
    }
}


