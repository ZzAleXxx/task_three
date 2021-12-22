package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scn = new Scanner(System.in);
        Home home = new Home(10, 10, 5);
        while (true) {
            String command = scn.nextLine();
            if (command.equalsIgnoreCase("go down")) {
                home.getElevator().goDown();
                System.out.println(home.getElevator().getCurrent_level().getLevelNumber() + " этаж");
            }
            else
                if (command.equalsIgnoreCase("go up")) {
                    home.getElevator().goUp();
                    System.out.println(home.getElevator().getCurrent_level().getLevelNumber() + " этаж");
                }
            else
                if (command.equalsIgnoreCase("elevator peoples")) {
                    home.getElevator().printPeoplesInElevator();
            }
            else
                if (command.equalsIgnoreCase("let out peoples")) {
                    home.getElevator().LetPeopleOutFromElevator();
                    System.out.println("Люди выпущены");
                    System.out.println("Люди в лифте:");
                    System.out.println(home.getElevator().getCurrent_level().getLevelNumber());

                }
            else
                if (command.equalsIgnoreCase("take peoples")) {
                    if (home.getElevator().isCurrentLevelTaken()){
                        System.out.println("Этаж уже обслужен");
                    }
                    else
                        if (home.getElevator().getCurrent_level().levelIsEmpty()){
                            System.out.println("Этаж пуст");
                        }
                    else
                        if (home.getElevator().isElevatorIsFull()){
                            System.out.println("Лифт переполнен");
                        }
                    else {
                            System.out.println("Дверь открыта");
                            System.out.println("Люди забраны");
                            System.out.println("Дверь закрывается");
                            home.getElevator().addPeoplesToElevator();
                            System.out.println("Дверь закрыта");
                        }
            }
            else
                if (command.equalsIgnoreCase("elevator level")) {
                    System.out.println(home.getElevator().getPeoplesInElevator());
                }
            else
                if (command.equalsIgnoreCase("peoples")) {
                    home.print_peoples();
            }
            else
                if (command.equalsIgnoreCase("open door")) {
                home.getElevator().openDoor();
                System.out.println("Дверь открыта");
            }
            else
                if (command.equalsIgnoreCase("close door")) {
                    home.getElevator().closeDoor();
                    System.out.println("Дверь закрыта");
                }
            else
                if (command.equalsIgnoreCase("elevator is full")){
                    if (home.getElevator().isElevatorIsFull()){
                        System.out.println("в лифте есть место");
                    } else {
                        System.out.println("лифт заполнен");
                    }
                }
        }
    }
}
