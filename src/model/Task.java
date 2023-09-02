package model;

import javax.swing.*;

public class Task {

    private int id;

    private String text;

    private boolean done;

    public Task (final String text) {
        this.text = text;
        done = false;
    }

    public Task (final int id, String text, boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    public void setId (final int editedId) {
        id = editedId;
    }

    public int getId() {
        return id;
    }

    public void setText(final String editedText) {
        text = editedText;
    }

    public String getText() {
        return text;
    }

    public void setDone(final boolean action) {
        done = action;
    }

    public boolean isDone() {
        return done;
    }

}
