package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class ManageWorkshop {
    private List<Workshop> workshopList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    void manageWorkshop() {
        Scanner scannerManage = new Scanner(System.in);
        int input;
        do {
            System.out.println("Choose option:\n1 - view all workshops;\n2 - add workshop;\n3 - delete workshop;\n" +
                    "4 - view workshops by author;\n5 - find the most visited workshop;\n0 - exit");
            input = scannerManage.nextInt();

            switch (input){
                case 0:
                    break;
                case 1:
                    viewAll();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    viewByAuthor();
                    break;
                case 5:
                    viewMostVisited();
                    break;
                default:
                    System.out.println("Wrong input. Try again");
            }
        } while (input != 0);
    }

    private void add() {

        Date workshopDate = null;
        System.out.println("Type workshop date in format dd/MM/yy");
        try {
            workshopDate = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.next());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Type workshop topic");
        String workshopTopic = scanner.next();

        System.out.println("Type workshop author");
        String workshopAuthor = scanner.next();

        System.out.println("Type workshop attenders quantity");
        int workshopAttendersQuantity = scanner.nextInt();

        Workshop workshop = new Workshop(workshopDate, workshopTopic, workshopAuthor, workshopAttendersQuantity);
        workshopList.add(workshop);
    }

    private void viewAll() {
        for (int i = 0; i < workshopList.size(); i++) {
            System.out.print(i + "). ");
            view(workshopList.get(i));
        }
    }

    private void delete() {
        int workshopEntity;
        System.out.println("Please select workshop for deleting:\n");
        viewAll();
        workshopEntity = scanner.nextInt();
        System.out.println("Are you sure want to remove workshop #" + workshopEntity + "? Type yes/no");
        if (scanner.next().equals("yes")) {
            workshopList.remove(workshopEntity);
            System.out.println("Workshop #" + workshopEntity + " removed successfully");
        }
    }

    private void viewByAuthor() {
        System.out.println("Type author's name");
        String author = scanner.next();
        int quantity = 0;
        for (Workshop workshop : workshopList) {
            if (workshop.getWorkshopAuthor().equals(author)) {
                view(workshop);
                quantity++;
            }
        }
        if (quantity == 0) {
            System.out.println("No results!");
        }
    }

    private void viewMostVisited() {
        List<Workshop> mostVisited = new ArrayList<>();
        int quantity = 0;
        for (Workshop aWorkshopList : workshopList) {
            if (aWorkshopList.getWorkshopAttendersQuantity() >= quantity) {
                mostVisited.add(aWorkshopList);
                quantity = aWorkshopList.getWorkshopAttendersQuantity();
                for (int j = 0; j < mostVisited.size(); j++) {
                    if (mostVisited.get(j).getWorkshopAttendersQuantity() < aWorkshopList.getWorkshopAttendersQuantity()) {
                        mostVisited.remove(j);
                    }
                }
            }
        }
        System.out.println("Most visited workshop(s):");
        for (Workshop integer : mostVisited) {
            view(integer);
        }
    }

    private void view(Workshop workshop) {
        System.out.println("Date: " + new SimpleDateFormat("dd/MM/yyyy").format(workshop.getWorkshopDate()) +
                ", topic: " + workshop.getWorkshopTopic() + ", author: " + workshop.getWorkshopAuthor() +
                ", attenders quantity: " + workshop.getWorkshopAttendersQuantity());
    }

}
