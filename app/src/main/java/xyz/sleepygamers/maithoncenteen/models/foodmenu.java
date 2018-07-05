package xyz.sleepygamers.maithoncenteen.models;

import java.io.Serializable;

public class foodmenu implements Serializable {
    private  String cat;
    private int id;
    private String name;
    private String price;
    private String img;
    private int count;

    public foodmenu (int id, String name, String price, String img) {
        this.count = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }

}
