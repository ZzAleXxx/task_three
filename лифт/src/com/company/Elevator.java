package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Elevator {

    private List<People> peoplesInElevator = new ArrayList<>();
    private List<Level> levels;
    private int allowed_amount_peoples;
    private boolean doorIsOpen;
    private boolean elevatorIsFull;
    private Level current_level;
    private boolean currentLevelTaken;

    public Elevator(int allowed_amount_peoples, List<Level> levels) {
        this.allowed_amount_peoples = allowed_amount_peoples;
        this.levels = levels;
        current_level = levels.get(0);
    }

    public void goUp() {
        currentLevelTaken = false;
        current_level = levels.get(current_level.getLevelNumber() + 1);
        for (People p : peoplesInElevator) {
            p.setCurrentLevel(current_level.getLevelNumber());
        }
    }

    public void goDown() {
        currentLevelTaken = false;
        current_level = levels.get(current_level.getLevelNumber() - 1);
        for (People p : peoplesInElevator) {
            p.setCurrentLevel(current_level.getLevelNumber());
        }
    }

    public void openDoor() {
        doorIsOpen = true;
    }

    public void closeDoor() throws InterruptedException {
        waitNSeconds(3);
        doorIsOpen = false;
    }

    public void addPeoplesToElevator() throws InterruptedException {
        openDoor();
        if (!currentLevelTaken) {
            if (peoplesInElevator.size() + current_level.getPeoples().size() < allowed_amount_peoples) {
                peoplesInElevator.addAll(current_level.getPeoples());
            } else {
                int k = 0;
                while (peoplesInElevator.size() < allowed_amount_peoples) {
                    peoplesInElevator.add(current_level.getPeoples().get(k));
                }
                elevatorIsFull = true;
            }
            currentLevelTaken = true;
            closeDoor();
        }
    }

    public void LetPeopleOutFromElevator() throws InterruptedException {
        List<People> peoplesInElevatorCopy = new ArrayList<>(peoplesInElevator);
        openDoor();
        for (People p : peoplesInElevator) {
            if (p.getNecessaryLevel() == current_level.getLevelNumber()) {
                peoplesInElevatorCopy.remove(p);
                p.setCurrentLevel(current_level.getLevelNumber());
            }
        }
        peoplesInElevator = peoplesInElevatorCopy;
        elevatorIsFull = false;
        closeDoor();
    }

    public void printPeoplesInElevator() {
        if (peoplesInElevator.size() == 0) {
            System.out.println("лифт пуст");
        } else {
            for (People p : peoplesInElevator) {
                System.out.println("Человек " + p.getNumber() + " Необходимый этаж " + p.getNecessaryLevel() +
                        " Текущий этаж " + p.getCurrentLevel());
            }
        }
    }

    private void waitNSeconds(int n) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            Thread.sleep(1000);
            System.out.println(i + 1);
        }
    }

    public boolean isElevatorIsFull() {
        return elevatorIsFull;
    }

    public Level getCurrent_level() {
        return current_level;
    }

    public List<People> getPeoplesInElevator() {
        return peoplesInElevator;
    }

    public boolean isCurrentLevelTaken() {
        return currentLevelTaken;
    }
}
