package bsuir.webtech.lab2.business.products;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Product {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int marketLaunchYear;

    public int getMarketLaunchYear() {
        return marketLaunchYear;
    }

    public void setMarketLaunchYear(int marketLaunchYear) {
        this.marketLaunchYear = marketLaunchYear;
    }

    public Product(String name, double price, int marketLaunchYear, String description) {
        this.name = name;
        this.price = price;
        this.marketLaunchYear = marketLaunchYear;
        this.description = description;
    }

    public Map<String, String> getPropertiesText() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("Дата выхода на рынок", marketLaunchYear + " год");
        return map;
    }
}
