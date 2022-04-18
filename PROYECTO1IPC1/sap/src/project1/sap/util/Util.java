package project1.sap.util;

import project1.sap.store.pets.Pet;

import java.util.Random;
import java.util.Scanner;

public class Util {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static int requestNumber(String message, int limInf, int limSup) {
        int entryNumber = 0;
        boolean inputNumberErrorExist = false;
        do {
            try {
                System.out.println("\n" + "\t\t"+message);
                entryNumber = scanner.nextInt();
                if ((entryNumber >= limInf) && (entryNumber <= limSup)) {
                    inputNumberErrorExist = false;
                } else {
                    inputNumberErrorExist = true;
                    System.out.println(
                            "\t\tYou must enter a number between [" + limInf + " . . " + limSup + "]");
                    System.out.println("\t\tRe-enter a number .");
                }
            } catch (Exception e) {
                inputNumberErrorExist = true;
                System.out.println(
                        "\t\tYou must enter a number between [" + limInf + " . . " + limSup + "]");
                System.out.println("\t\tEnter an integer number.");

            }
            scanner.nextLine();
        } while (inputNumberErrorExist);
        return entryNumber;
    }

    public static int generateRandomNumber(int min, int max) {
        return random.nextInt(max - (min-1)) + 1 + (min-1);
    }

    public static String requestString(String message) {
        String answer = "";
        boolean inputStringErrorExist = false;

        do {
            System.out.println("\n" + "\t\t"+message);
            answer = scanner.nextLine();
            answer = answer.trim();
            if (answer.length() > 0) {
                inputStringErrorExist = false;
            } else {
                inputStringErrorExist = true;
                System.out.println("\t\tPlease enter at least one character.");
            }

        } while (inputStringErrorExist);

        return answer;
    }

    public static String requestEnter(String message) {
        String answer = "";

        System.out.println("\n" + message);
        answer = scanner.nextLine();
        return answer;
    }

    public static int turnUser(int times, int min, int max, String message) {
        System.out.println("\n     ******* " + message);
        int res = 0;
        int tmp = 0;
        for (int i = 1; i <= times; i++) {
            requestEnter("     Press enter to roll the dice, time: "+i+"\n");
            tmp = generateRandomNumber(min, max);
            System.out.println("          The result is:" + tmp);
            if (tmp > res) {
                res = tmp;
            }
        }
        System.out.println("     The highest number obtained was:" + res);
        requestEnter("     Press enter to continue");

        return res;
    }

    public static String fixStringLength(int longitude, String word) {
        if (word.length() > longitude) {
            return word.substring(0, longitude - 1);
        } else {
            int difference = longitude - word.length();
            if (difference % 2 != 0) {
                word = " " + word;
                difference--;
            }
            difference /= 2;
            for (int i = 0; i < difference; i++) {
                word = " " + word + " ";
            }
        }

        return word;
    }

    // Function to remove the element
    public static Pet[] removeTheElement(Pet[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        Pet[] anotherArray = new Pet[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }

            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }

    public static int rollDiceNTimesGreaterNumber(int times, int amount, String message) {
        System.out.println("\n     ******* " + message);
        int res = 0;
        int tmp = 0;
        for (int i = 1; i <= times; i++) {
            requestEnter("     Press enter to roll the dice, time: "+i+"\n");
            tmp = amount;
            System.out.println("          The result is:" + tmp);
            if (tmp > res) {
                res = tmp;
            }
        }
        System.out.println("     The highest number obtained was:" + res);
        requestEnter("     Press enter to continue");

        return res;

    }
}