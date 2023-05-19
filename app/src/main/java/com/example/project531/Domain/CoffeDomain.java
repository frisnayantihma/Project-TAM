package com.example.project531.Domain;

import java.io.Serializable;

public class CoffeDomain implements Serializable {
    private String title;
    private String pic;
    private String description;
    private Double bayar;
    private int star;
    private int driver;
    private int berat;
    private int numberInCart;

    public CoffeDomain(String title, String pic, String description, Double bayar, int star, int driver, int berat) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.bayar = bayar;
        this.star = star;
        this.driver = driver;
        this.berat = berat;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBayar() {
        return bayar;
    }

    public void setBayar(Double bayar) {
        this.bayar = bayar;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getDriver() {
        return driver;
    }

    public void setDriver(int driver) {
        this.driver = driver;
    }

    public int getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }
}
