package com.beefnb.dbdemo.db.bean;

public class NoteBean {

    private String id;

    private String content;

    private String time;

    public NoteBean(String id, String content, String time) {
        this.id = id;
        this.content = content;
        this.time = time;
    }

    public NoteBean() {}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "NoteBean{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
