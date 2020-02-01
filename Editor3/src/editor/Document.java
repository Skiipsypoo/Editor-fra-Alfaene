/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import editor.display.CharacterDisplay;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * This class represents the document being edited. Using a 2d array to hold the
 * document content is probably not a very good choice. Fixing this class is the
 * main focus of the exercise. In addition to designing a better data model, you
 * must add methods to do at least basic editing: write and delete text, and
 * moving the cursor
 *
 * @author evenal
 */
public class Document {

    private CharacterDisplay display;
    private int cursorRow;
    private int cursorCol;
    private char[][] data;
    LinkedList<Character> column = new LinkedList<>();


    LinkedList<Character> cursorC = new LinkedList<>();
    LinkedList<Character> cursorR = new LinkedList<>();

    public Document(CharacterDisplay display) {
        this.display = display;
        cursorCol = cursorRow = 0;

        // Fill the Linked List with ' ' to avoid getting IndexOutOfBoundsException while traversing
        int i = 0;
        int j = 0;
         while (i <= 800) {
            cursorR.add(' ');
            i++;
          }

          while (j <= 800) {
              cursorC.add(' ');
              j++;
          }
    }

    public void shiftChars() {

        //ListIterator itCol = cursorC.listIterator(cursorCol);
        //ListIterator itRow = cursorC.listIterator(cursorRow);

        int i = 0;
        int j = 1;

        int colIndex = cursorCol;
        int rowIndex = cursorRow;

        while(colIndex < cursorC.size() -1) {

            Character val = cursorC.get(colIndex + 1);
            cursorC.add(colIndex + 2, val);

            cursorC.removeLast();


            colIndex++;
        }

        while(rowIndex < cursorR.size() -1) {

            Character val = cursorR.get(rowIndex + 1);
            cursorR.add(rowIndex + 2, val);

            cursorR.removeLast();

            rowIndex++;
        }
    }

    public void insertChar(char c) {
        cursorR.add(cursorRow, c);
        cursorC.add(cursorCol, c);
        // cursorR.removeLast();
        // cursorC.removeLast();

        shiftChars();

        display.displayChar(c, cursorRow, cursorCol);
        display.displayCursor(' ', cursorRow, cursorCol);


        if (cursorCol == 39 && cursorRow == 19) {
        } else {
            cursorCol++;
            if (cursorCol >= CharacterDisplay.WIDTH) {
                cursorCol = 0;
                cursorRow++;
            }
        }
    }


    public void removeChar(char c) {
        if (cursorC.contains(cursorCol) && cursorR.contains(cursorRow)) {
            cursorR.remove();
            cursorC.remove();
        }

        display.displayChar(' ', cursorRow, cursorCol);

        if (cursorCol == 0 && cursorRow == 0) {

        } else if (cursorCol == 0 && cursorRow >= 0) {
            cursorCol = 39;
            cursorRow--;
        } else {
            cursorCol--;
        }
        display.displayCursor(' ', cursorRow, cursorCol);
    }

    public void shiftChar(char c) {
        cursorC.add(cursorCol, c);
        cursorR.add(cursorRow, c);

        display.displayChar(c, cursorRow, cursorCol);
        if (cursorRow < 19) {
            int ant = CharacterDisplay.WIDTH - cursorCol;
            System.out.println(ant);
            for (int i = 0; i < ant; i++) {
                cursorC.add('c');
            }
            System.out.println(cursorC.size());
            cursorCol = 0;
            cursorRow++;
        }
        display.displayCursor(' ', cursorRow, cursorCol);
    }

    public void moveCursorUp() {
        if (cursorRow == 0) {

        } else if (cursorRow > 0) {
            cursorRow--;
        }
        display.displayCursor(' ', cursorRow, cursorCol);
    }

    public void moveCursorDown() {
        if (cursorCol == 19) {

        } else if (cursorRow < 19) {
            cursorRow++;
        }
        display.displayCursor(' ', cursorRow, cursorCol);
    }

    public void moveCursorRight() {

        if (cursorCol == 39 && cursorRow == 19) {
        } else {
            cursorCol++;
            if (cursorCol >= CharacterDisplay.WIDTH) {
                cursorCol = 0;
                cursorRow++;
            }
        }

        display.displayCursor(' ', cursorRow, cursorCol);
    }

    public void moveCursorLeft() {
        if (cursorCol == 0 && cursorRow == 0) {

        } else if (cursorCol == 0 && cursorRow >= 0) {
            cursorCol = 39;
            cursorRow--;
        } else {
            cursorCol--;
        }
        display.displayCursor(' ', cursorRow, cursorCol);
    }
}

