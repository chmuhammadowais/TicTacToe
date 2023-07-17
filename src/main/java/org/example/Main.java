package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char[][] tt = new char[3][3];
        for (char[] chars : tt) {
            Arrays.fill(chars, ' ');
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("======== Gameplay Information =========");

        System.out.print("Enter your character : ");

        char player;
        char computer;

        while(true){
            String player_choice = scanner.nextLine();
            if(player_choice.length() > 1){
                System.out.println("Enter a character only");
            }
            else{
                player = player_choice.charAt(0);
                System.out.println("Player chooses character : "+player);
                if(player == 'x' || player ==  'X'){
                    computer = 'O';
                    System.out.println("Computer chooses character : O");
                }
                else{
                    computer = 'X';
                    System.out.println("Computer chooses character : X");
                }
                break;
            }
        }
        System.out.println("=======================================");


        while (true) {
            while(true){

                System.out.print("Enter the row no. of your character: ");
                int player_row = scanner.nextInt();
                player_row -= 1;
                System.out.print("Enter the column no. of your character: ");
                int player_col = scanner.nextInt();
                player_col -= 1;
                try {
                    if (tt[player_row][player_col] == ' ') {
                        tt[player_row][player_col] = player;
                        print(tt);
                        break;
                    } else {
                        System.out.println("Clash of turns");
                    }
                }
                catch (Exception e){
                    System.out.println("Exception : "+e);
                    System.out.println("Index out of bound. Please ");
                }
            }

            if(checkWinner(tt) != ' '){
                System.out.println("=======================");
                String winner = "";
                if(checkWinner(tt) == player){
                    winner = "Player wins";
                }
                else if(checkWinner(tt) == computer){
                    winner = "Computer wins";
                }
                int totalWidth = 23;
                int textWidth = winner.length();
                int spacing = (totalWidth - textWidth) / 2;

                String formattedText = String.format("%" + spacing + "s%s%" + spacing + "s", "", winner, "");
                System.out.println(formattedText);
                System.out.println("=======================");
                break;
            }
            else if(isArrayFull(tt) && checkWinner(tt) != ' '){
                System.out.println("=======================");
                String text = "Its a DRAW";
                int totalWidth = 23;
                int textWidth = text.length();
                int spacing = (totalWidth - textWidth) / 2;

                String formattedText = String.format("%" + spacing + "s%s%" + spacing + "s", "", text, "");
                System.out.println(formattedText);
                System.out.println("=======================");
            }

            while(true){
                try{
                    String rand = randGenerator();
                    int row = Integer.parseInt(String.valueOf(rand.charAt(0)));
                    int column = Integer.parseInt(String.valueOf(rand.charAt(2)));
                    System.out.println("Row : "+(row+1));
                    System.out.println("Column : "+(column+1));
                    if(tt[row][column] == ' '){
                        tt[row][column] = computer;
                        break;
                    }
                    else{
                        System.out.println("Clash of turn");
                        System.out.println("Trying again. Please Wait!");
                    }
                }
                catch (Exception e){
                    System.out.println("Exception : "+e);
                }

            }

            // Printing the table
            print(tt);

            if(checkWinner(tt) != ' '){
                System.out.println("=======================");
                String winner = "";
                if(checkWinner(tt) == player){
                    winner = "Player wins";
                }
                else if(checkWinner(tt) == computer){
                    winner = "Computer wins";
                }
                int totalWidth = 23;
                int textWidth = winner.length();
                int spacing = (totalWidth - textWidth) / 2;

                String formattedText = String.format("%" + spacing + "s%s%" + spacing + "s", "", winner, "");
                System.out.println(formattedText);
                System.out.println("=======================");

                break;
            }
            else if(isArrayFull(tt) && checkWinner(tt) != ' '){
                System.out.println("=======================");
                String text = "Its a DRAW";
                int totalWidth = 23;
                int textWidth = text.length();
                int spacing = (totalWidth - textWidth) / 2;

                String formattedText = String.format("%" + spacing + "s%s%" + spacing + "s", "", text, "");
                System.out.println(formattedText);
                System.out.println("=======================");
            }




        }//end of while loop (game)

    }//end of main
    public static void print(char[][] arr){
        for (char[] chars : arr) {
            for (int j = 0; j < arr.length; j++) {
                if (j == arr.length - 1) {
                    System.out.print(chars[j]);
                } else {
                    System.out.print(chars[j] + " | ");
                }

            }
            System.out.println();
        }
    }
    public static String randGenerator(){
        Random rand = new Random();
        int row = rand.nextInt(3);
        int column = rand.nextInt(3);
        return row + " " + column;
    }
    public static char checkWinner(char[][] board) {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != ' ') {
                return board[row][0];
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != ' ') {
                return board[0][col];
            }
        }

        // Check diagonals
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')) {
            return board[1][1];
        }

        // No winner
        return ' ';
    }
    public static boolean isArrayFull(char[][] arr) {
        for (char[] chars : arr) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

}//end of class
