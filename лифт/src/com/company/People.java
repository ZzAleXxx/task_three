package com.company;

public class People {
    private int number;
    private int currentLevel;
    private int necessaryLevel;

    public People(int number, int currentLevel, int necessaryLevel) {
        this.number = number;
        this.currentLevel = currentLevel;
        this.necessaryLevel = necessaryLevel;
    }

    public int getNecessaryLevel() {
        return necessaryLevel;
    }

    public void setNecessaryLevel(int necessaryLevel) {
        this.necessaryLevel = necessaryLevel;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getNumber() {
        return number;
    }
}
