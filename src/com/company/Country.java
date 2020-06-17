package com.company;

public class Country {
    private String name;
    private int area;
    private int population;

    public Country() {

    }

    public Country(String name, int population, int area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public int getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "{name:" + name +
                ", area:" + area +
                ", population:" + population +
                '}' + '\n'; // \ნ სპეციალურად დავამატე გარჩევადოებისთვის
    }
}
