package roche;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

/**
 * Created by helio on 20/7/17.
 */
public class TicTacToe {

    private static final Integer BOARD_SIZE = 3;

    // board representation as a matrix
    private char[][] board;
    // symbol used by user
    private char user;
    // Symbol used by computer
    private char computer;

    public TicTacToe(@JsonProperty("user") char user,
                     @JsonProperty("computer") char computer,
                     @JsonProperty("board") char[][] board) {
        this.setBoard(board);
        this.setUser(user);
        this.setComputer(computer);
    }

    public TicTacToe(TicTacToe source) {
        this.computer = source.computer;
        this.user = source.user;
        this.board = source.board;
    }

    // check if a winner move is possible. If yes, it will avoid the user to win or we will win the game
    // if not, it will just the get first empty spot in the matrix
    public void getComputerMove() {
        if (!winnerRowMove() && !winnerColumnMove() && !winnerCrossMove()) {
            for (int counterX = 0; counterX < BOARD_SIZE; counterX++) {
                for (int counterY = 0; counterY < BOARD_SIZE; counterY++)
                    if (this.getBoard()[counterX][counterY] == ' ') {
                        this.getBoard()[counterX][counterY] = this.getComputer();
                        return;
                    }
            }
        }
    }

    // A function that returns true if any of the row
    // is crossed with the same player's move
    public boolean winnerRowMove() {

        // let's check the rows
        for (int counter = 0; counter < BOARD_SIZE; counter++) {

            HashMap<Character, Integer> control = new HashMap<>();

            for (int counterY = 0; counterY < BOARD_SIZE; counterY++) {
                int value = control.containsKey(this.board[counter][counterY]) ? control.get(this.board[counter][counterY]) + 1 : 1;
                control.put(this.board[counter][counterY], value);
            }

            // let's win the game or avoid the user to win
            for (Map.Entry<Character, Integer> entry : control.entrySet()) {
                if (entry.getKey() != ' ' && entry.getValue() == BOARD_SIZE - 1) {
                    for (int counterY = 0; counterY < BOARD_SIZE; counterY++) {
                        if (this.board[counter][counterY] == ' ') {
                            this.board[counter][counterY] = this.computer;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean winnerColumnMove() {

        // let's check the rows
        for (int counter = 0; counter < BOARD_SIZE; counter++) {

            HashMap<Character, Integer> control = new HashMap<>();

            for (int counterX = 0; counterX < BOARD_SIZE; counterX++) {
                int value = control.containsKey(this.board[counterX][counter]) ? control.get(this.board[counterX][counter]) + 1 : 1;
                control.put(this.board[counterX][counter], value);
            }

            // let's win the game or avoid the user to win
            for (Map.Entry<Character, Integer> entry : control.entrySet()) {
                if (entry.getKey() != ' ' && entry.getValue() == BOARD_SIZE - 1) {
                    for (int counterX = 0; counterX < BOARD_SIZE; counterX++) {
                        if (this.board[counterX][counter] == ' ') {
                            this.board[counterX][counter] = this.computer;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean winnerCrossMove() {

        // let's check the diagonal..
        // first one
        HashMap<Character, Integer> control = new HashMap<>();

        for (int counter = 0; counter < BOARD_SIZE; counter++) {

            int value = control.containsKey(this.board[counter][counter]) ? control.get(this.board[counter][counter]) + 1 : 1;
            control.put(this.board[counter][counter], value);
        }
        // let's win the game or avoid the user to win
        for (Map.Entry<Character, Integer> entry : control.entrySet()) {
            if (entry.getKey() != ' ' && entry.getValue() == BOARD_SIZE - 1) {
                for (int counterX = 0; counterX < BOARD_SIZE; counterX++) {
                    if (this.board[counterX][counterX] == ' ') {
                        this.board[counterX][counterX] = this.computer;
                        return true;
                    }
                }
            }
        }

        // second one
        control.clear();

        for (int counter = 0; counter < BOARD_SIZE; counter++) {

            int counterY = BOARD_SIZE - counter - 1;

            int value = control.containsKey(this.board[counter][counterY]) ? control.get(this.board[counter][counterY]) + 1 : 1;
            control.put(this.board[counter][counterY], value);
        }
        // let's win the game or avoid the user to win
        for (Map.Entry<Character, Integer> entry : control.entrySet()) {
            if (entry.getKey() != ' ' && entry.getValue() == BOARD_SIZE - 1) {
                for (int counterX = 0; counterX < BOARD_SIZE; counterX++) {
                    int counterY = BOARD_SIZE - counterX - 1;

                    if (this.board[counterX][counterY] == ' ') {
                        this.board[counterX][counterY] = this.computer;
                        return true;
                    }
                }
            }
        }

        return false;
    }


    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public char getUser() {
        return user;
    }

    public void setUser(char user) {
        this.user = user;
    }

    public char getComputer() {
        return computer;
    }

    public void setComputer(char computer) {
        this.computer = computer;
    }
}
