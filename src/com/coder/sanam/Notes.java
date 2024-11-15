package com.coder.sanam;

public class Notes {

    private int id;
    private String note;
    private long tagId;

    public Notes(int id, String note, long tagId) {
        this.id = id;
        this.note = note;
        this.tagId = tagId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }
}
