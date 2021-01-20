package me.pimpao.taco;

import java.util.ArrayList;
import java.util.List;

public class Taco {

    private String name;
    private List<String> ingredients = new ArrayList<>();

    public Taco() {

    }

    public Taco(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Taco{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
