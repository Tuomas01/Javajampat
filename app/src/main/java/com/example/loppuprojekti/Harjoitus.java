package com.example.loppuprojekti;

public class Harjoitus {

    private int kesto;
    private int kalorit;
    private int askeleet;

    /**
     * Avaa harjoitussivun aktiviteetin.
     * @param kesto Harjoituksen kesto
     * @param kalorit Harjoituksessa poltetut kalorit
     * @param askeleet Harjoituksen aikana kertyneet askeleet
     * @author Niko Ala-aho
     */
    public Harjoitus(int kesto, int kalorit, int askeleet){
        this.kesto = kesto;
        this.kalorit = kalorit;
        this.askeleet = askeleet;
    }

    public int getKesto(){
        return this.kesto;
    }

    public int getKalorit(){
        return this.kalorit;
    }

    public int getAskeleet(){
        return this.askeleet;
    }


    /**
     * Palauttaa harjoituksen keston, poltetut kalorit ja askeleet.
     * @author Niko Ala-aho
     */
    public String toString(){
        return "Harjoituksen kesto: " + this.kesto + " minuuttia" + "\n" +
                "Kaloreita poltettu: " + this.kalorit +  " kcal\n" +
                "Askeleita: " +  this.askeleet;
    }
}
