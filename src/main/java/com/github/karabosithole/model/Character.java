package com.github.karabosithole.model;

public class Character {
    private String name;
    private String type; // e.g., Warrior, Mage
    private int health; // Health points

    public Character(String name, String type) {
        this.name = name;
        this.type = type;
        this.health = 100; // Default health
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    // Additional methods for character abilities can be added here
}