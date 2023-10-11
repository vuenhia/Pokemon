package model;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private String boxName;
    private String cardName;
    private int amount;

    public Pokemon() {

    }

    public Pokemon(String boxName, String cardName, int amount) {
        this.boxName = boxName;
        this.cardName = cardName;
        this.amount = amount;
    }

    public String getBoxName() {
        return boxName;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "boxName='" + boxName + '\'' +
                ", cardName='" + cardName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
