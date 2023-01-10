package cinema;

import java.math.RoundingMode;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Cinema {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        int rowInHall = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsInRow = scan.nextInt();
        String[][] chosenSeat = getCinemaRoom(rowInHall, seatsInRow);
        while(true) {
            menu();
            int userInput = scan.nextInt();
            if (userInput == 1) {
                printer(chosenSeat);
            } else if (userInput == 2) {
                buyTicket(rowInHall, seatsInRow, chosenSeat);
            } else if (userInput == 3) {
                staticstic(rowInHall, seatsInRow, chosenSeat);
            }
            else if (userInput == 0) {
                break;
            } else {
                System.out.println("Incorrect input");
            }
        }
    }

    public static void menu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static String[][] getCinemaRoom(int rowInHall, int seatsInRow){
        int rows = rowInHall + 1;
        int seats = seatsInRow + 1;
        String[][] cinemaRoom = new String[rows][seats];
        cinemaRoom[0][0] = " ";
        for (int i = 1; i < seats; i++) {
            cinemaRoom[0][i] = Integer.toString(i);
        }
        for (int j = 1; j < rows; j++) {
            cinemaRoom[j][0] = Integer.toString(j);
        }
        for (int i = 1; i < rows ; i++) {
            for (int j = 1; j < seats ; j++) {
                cinemaRoom[i][j] = "S";
            }
        }
        return cinemaRoom;
    }

    public static void printer(String[][] cinemaRoom){
        System.out.println();
        System.out.println("Cinema: ");
        for (int i = 0; i < cinemaRoom.length; i++) {
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                System.out.print(cinemaRoom[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void buyTicket(int rows, int seats, String[][] chosenSeat) {
        int highPrice = 10;
        int lowPrice = 8;
        String result = " ";
        int row;
        int seat;
        while (true) {
            System.out.println("Enter a row number:");
            row = scan.nextInt();
            System.out.println("Enter a seat number in that row:");
            seat = scan.nextInt();
            if ((row < 1 || row > rows) || (seat < 1 || seat > seats)) {
                System.out.println("Wrong input!");
                System.out.println();
            } else {
                break;
            }
        }
        //System.out.println();
        if (chosenSeat[row][seat].equals("S")) {
            if (rows * seats <= 60) {
                result = "Ticket price: " + "$" + highPrice;
            } else {
                if (row <= ((rows - 1) / 2)) {
                    result = "Ticket price: " + "$" + highPrice;
                } else {
                    result = "Ticket price: " + "$" + lowPrice;
                }
            }
            System.out.println(result);
            System.out.println();
            chosenSeat[row][seat] = "B";
        } else {
            System.out.println("That ticket has already been purchased!");
            System.out.println();
            buyTicket(rows, seats, chosenSeat);
        }
    }

    public static void staticstic(int rows, int seats, String[][] chosenSeat) {
        int highPrice = 10;
        int lowPrice = 8;
        int countB = 0;
        int countS = 0;
        int count8B = 0;
        int count10B = 0;
        int count8S = 0;
        int count10S = 0;
        int currentIncom = 0;
        int totalIncom = 0;
        for (int i = 0; i < chosenSeat.length; i++) {
            for (int j = 0; j < chosenSeat[i].length; j++) {
                if (chosenSeat[i][j].equals("B")) {
                    countB++;
                }
                if (chosenSeat[i][j].equals("S")) {
                    countS++;
                }
                if (chosenSeat[i][j].equals("B") && i <= rows / 2) {
                    count10B += highPrice;
                }
                if (chosenSeat[i][j].equals("B") &&  i > rows / 2) {
                    count8B += lowPrice;
                }
                if (chosenSeat[i][j].equals("S") && i <= rows / 2) {
                    count10S += highPrice;
                }
                if (chosenSeat[i][j].equals("S") &&  i > rows / 2) {
                    count8S += lowPrice;
                }
            }
        }
        if (rows * seats <= 60) {
            totalIncom = (countB + countS) * highPrice;
            currentIncom = countB * highPrice;
        } else {
            totalIncom = count10B + count10S + count8B + count8S;
            currentIncom = count10B + count8B;
        }

        float persentage = (float) countB / (countS + countB) * 100;
        String persantage1 = String.format("Percentage: %.2f", persentage);
        System.out.printf("Number of purchased tickets: %d\n", countB);
        System.out.println(persantage1 + "%");
        System.out.printf("Current income: $%d\n", currentIncom);
        System.out.printf("Total income: $%d\n", totalIncom);
        System.out.println();

    }
}