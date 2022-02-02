package com.jordanbook.notebook.models;


import javax.persistence.*;

@Entity
public class NotebookPage {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pageID;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "notebook.noteBookID")
    private Notebook notebook;


    private String notebookPageName;


    @Column(length = 4000)
    private String notebookPageContents;



    public NotebookPage(){}

    public NotebookPage(Notebook notebook, String notebookPageName, String notebookPageContents) {
        this.notebook = notebook;
        this.notebookPageName = notebookPageName;
        this.notebookPageContents = notebookPageContents;
    }

    public Long getPageID() {
        return pageID;
    }

    public void setPageID(Long pageID) {
        this.pageID = pageID;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public String getNotebookPageName() {
        return notebookPageName;
    }

    public void setNotebookPageName(String notebookPageName) {
        this.notebookPageName = notebookPageName;
    }

    public String getNotebookPageContents() {
        return notebookPageContents;
    }

    public void setNotebookPageContents(String notebookPageContents) {
        this.notebookPageContents = notebookPageContents;
    }

    @Override
    public String toString() {
        return "NotebookPage{" +
                "pageID=" + pageID +
                ", notebook=" + notebook +
                ", notebookPageName='" + notebookPageName + '\'' +
                ", notebookPageContents='" + notebookPageContents + '\'' +
                '}';
    }
}
