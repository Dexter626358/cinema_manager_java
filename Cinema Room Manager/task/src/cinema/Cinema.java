package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        getPrice();


    }
    public static void gerCinemaRoom(){
        String[][] cinemaRoom = {
                {" ", "1", "2", "3", "4", "5", "6", "7", "8"},
                {"1", "S", "S", "S", "S", "S", "S", "S", "S"},
                {"2", "S", "S", "S", "S", "S", "S", "S", "S"},
                {"3", "S", "S", "S", "S", "S", "S", "S", "S"},
                {"4", "S", "S", "S", "S", "S", "S", "S", "S"},
                {"5", "S", "S", "S", "S", "S", "S", "S", "S"},
                {"6", "S", "S", "S", "S", "S", "S", "S", "S"},
                {"7", "S", "S", "S", "S", "S", "S", "S", "S"}};
        System.out.println("Cinema:");
        for (int i = 0; i < cinemaRoom.length; i++) {
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                System.out.print(cinemaRoom[i][j] + " ");

            }
            System.out.println();
        }

    }

    public static void getPrice() {
        int price60 = 10;
        int priceFirstPart = 10;
        int priceSecondPart = 8;
        int totalCoast;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scan.nextInt();
        if (rows * seats <= 60) {
            totalCoast = price60 * rows * seats;
        } else {
            if (rows % 2 == 0) {
                totalCoast = rows / 2 * seats * priceFirstPart + rows / 2 * seats * priceSecondPart;
            } else {
                totalCoast = rows / 2 * seats * priceFirstPart + (rows / 2 + rows % 2) * seats * priceSecondPart;
            }
        }

        System.out.println("Total income:");
        System.out.println("$" + totalCoast);

    }
}