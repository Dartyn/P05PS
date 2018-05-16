package com.example.a16022667.p05ps;

import java.io.Serializable;

public class Note implements Serializable {

    private int id;

    private String noteContent;

    public Note(int id, String song ) {
        this.id = id;
        this.noteContent = song;

    }

    public int getId() { return id; }

    public String getNoteContent() { return noteContent; }

    public void setNoteContent(String song) {
        this.noteContent = song;
    }

    @Override
    public String toString() {
        return "ID:" + id + ", " + noteContent;
    }

}
