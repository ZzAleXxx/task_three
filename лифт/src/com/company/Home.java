package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Home {

    private List<Level> levels;
    private List<People> peoples;
    private Elevator elevator;

    public Home(int amount_levels, int amount_peoples, int allowedPeoplesInElevator) {
        this.peoples = createRandomPeoples(amount_peoples, amount_levels);
        this.levels = buildLevels(amount_levels);
        this.elevator = new Elevator(allowedPeoplesInElevator, levels);
    }

    private List<Level> buildLevels(int amountLevels){
        List<Level> newLevels = new ArrayList<>();
        for (int i = 0; i < amountLevels; i++) {
            newLevels.add(new Level(i, findPeoplesForLevel(i)));
        }
        return newLevels;
    }

    private List<People> findPeoplesForLevel(int levelNumber){
        List<People> peoplesForLevel = new ArrayList<>();
        for (People p : peoples) {
            if (p.getCurrentLevel() == levelNumber) {
                peoplesForLevel.add(p);
            }
        }
        return peoplesForLevel;
    }

    private List<People> createRandomPeoples(int amountPeoples, int amountLevels){
        Random rnd = new Random();
        List<People> newPeoples = new ArrayList<>();
        for (int i = 0; i < amountPeoples; i++) {
            newPeoples.add(new People(i, rnd.nextInt(amountPeoples), rnd.nextInt(amountLevels)));
        }
        return newPeoples;
    }

    public void print_peoples(){
        for (People p: peoples) {
            System.out.println("Человек номер " + (p.getNumber()) + " Необходимый этаж " + p.getNecessaryLevel() +
                    " Текущий этаж " + p.getCurrentLevel());
        }
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }
}
