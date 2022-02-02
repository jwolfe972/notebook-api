package com.jordanbook.notebook.models;


import javax.persistence.*;

@Entity
public class Notebook {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long noteBookID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user.userID")
    private User user;


    @Column(nullable = false)
    private String noteBookName;



    @Column(nullable = false)
    private int pageCount;


    public Notebook(){}


    public Notebook(User ownerID, String noteBookName, int pageCount) {
        this.user = ownerID;
        this.noteBookName = noteBookName;
        this.pageCount = pageCount;
    }

    public Long getNoteBookID() {
        return noteBookID;
    }

    public void setNoteBookID(Long noteBookID) {
        this.noteBookID = noteBookID;
    }

    public User getOwnerID() {
        return user;
    }

    public void setOwnerID(User ownerID) {
        this.user = ownerID;
    }

    public String getNoteBookName() {
        return noteBookName;
    }

    public void setNoteBookName(String noteBookName) {
        this.noteBookName = noteBookName;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
