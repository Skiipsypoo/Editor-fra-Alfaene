/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.action;

import editor.Document;
import editor.Editor;
import java.awt.event.ActionEvent;

/**
 * This is an example of an action class. You will have to add more. They should
 * call one of the editing methods in the document.
 *
 * @author evenal
 */
public class NavigationAction extends EditorAction {

    Editor editor;
    String direction;

    public NavigationAction(String name, String direction, Editor editor) {
        super(name);
        this.direction = direction;
        this.editor = editor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Document doc = editor.getDocument();
        switch(direction) {

            case "LEFT": doc.moveCursorLeft();
                break;

            case "RIGHT": doc.moveCursorRight();
                break;

            case "UP": doc.moveCursorUp();
                break;

            case "DOWN": doc.moveCursorDown();
                break;

            default: System.out.println("Unknown direction");
                break;
        }
    }
}
