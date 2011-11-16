package models;

/**
 * @author Ludovico Fischer
 */
public class Juice {
    public String getFlavour() {
        return flavour;
    }

    private String flavour;

    public Juice() {
        this.flavour = "water";
    }

    public Juice(Fruit fruit) {
        this.flavour = fruit.getFruit();
    }
}
