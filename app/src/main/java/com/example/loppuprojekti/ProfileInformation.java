package com.example.loppuprojekti;
// luodaan profiilitiedoille oma olioluokka, josta yritimme tehdä singletonia, mutta emme onnistuneet
public class ProfileInformation {
    String name;
    int age;
    int sleep;
    int calories;
    int height;
    int weight;
    // luo singletonin instance
    private static final ProfileInformation ourInstance = new ProfileInformation();

    // palautetaan singletonin instance
    public static ProfileInformation getInstance() {
        return ourInstance;
    }
    // singletonin konstruktori
    private ProfileInformation() {

    }
    // Profiiliolioluokan konstruktori
    public ProfileInformation(String name, int age, int sleep, int calories, int height, int weight) {
        this.name = name;
        this.age = age;
        this.sleep = sleep;
        this.calories = calories;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Hakee käyttäjän syöttämän nimen
     * @return palauttaa käyttäjän syöttämän nimen
     * @author Tuomas Heikkilä
     */
    public String getName() {
        return this.name;
    }

    /**
     * Hakee käyttäjän syöttämän iän
     * @return palauttaa käyttäjän syöttämän iän
     * @author Tuomas Heikkilä
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Hakee käyttäjän syöttämän unen määrän
     * @return palauttaa käyttäjän syöttämän unen määrän
     * @author Tuomas Heikkilä
     */
    public int getSleep() {
        return this.sleep;
    }

    /**
     * Hakee käyttäjän syöttämän päivittäiset kalorisaannit
     * @return palauttaa käyttäjän syöttämän päivittäiset kalorisaannit
     * @author Tuomas Heikkilä
     */
    public int getCalories() {
        return this.calories;
    }
    /**
     * Hakee käyttäjän syöttämän pituuden
     * @return palauttaa käyttäjän syöttämän pituuden
     * @author Tuomas Heikkilä
     */
    public int getHeight() {
        return this.height;
    }
    /**
     * Hakee käyttäjän syöttämän painon
     * @return palauttaa käyttäjän syöttämän painon
     * @author Tuomas Heikkilä
     */
    public int getWeight() {
        return this.weight;
    }
    /**
     * palauttaa kaikki käyttäjän syöttämät tiedot merkkijonona
     * @return palauttaa kaikki käyttäjän syöttämät tiedot merkkijonona
     * @author Tuomas Heikkilä
     */
    public String toString() {
        return "Nimi on " + this.name + ", ikä " + this.age + " vuotta, unenmäärä " + this.sleep +
                "h, kaloreita päivässä " + this.calories + ", pituus " + this.height + " cm ja paino " + this.weight + " kg";
    }
}
