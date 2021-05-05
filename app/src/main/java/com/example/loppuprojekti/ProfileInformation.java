package com.example.loppuprojekti;

public class ProfileInformation {
    String name;
    int age;
    int sleep;
    int calories;
    int height;
    int weight;
    private static final ProfileInformation ourInstance = new ProfileInformation();

    public static ProfileInformation getInstance() {
        return ourInstance;
    }

    private ProfileInformation() {

    }

    public ProfileInformation(String name, int age, int sleep, int calories, int height, int weight) {
        this.name = name;
        this.age = age;
        this.sleep = sleep;
        this.calories = calories;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getSleep() {
        return this.sleep;
    }

    public int getCalories() {
        return this.calories;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public String toString() {
        return "Nimi on " + this.name + ", ikä " + this.age + " vuotta, unenmäärä " + this.sleep +
                "h, kaloreita päivässä " + this.calories + ", pituus " + this.height + " cm ja paino " + this.weight + " kg";
    }
}
