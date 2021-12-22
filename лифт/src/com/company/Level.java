package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level {

    int levelNumber;
    private List<People> peoples;

    public Level(int levelNumber, List<People> peoples) {
        this.levelNumber = levelNumber;
        this.peoples = peoples;
    }

    public boolean levelIsEmpty(){
        return peoples.size() <= 0;
    }

    public int getAmount_peoples() {
        return peoples.size();
    }

    public List<People> getPeoples() {
        return peoples;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }
}
