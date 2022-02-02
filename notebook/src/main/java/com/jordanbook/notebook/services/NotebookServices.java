package com.jordanbook.notebook.services;

import com.jordanbook.notebook.models.Notebook;
import com.jordanbook.notebook.repos.NotebookRepo;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.element.UnknownElementException;

@Service
public class NotebookServices {


    private final NotebookRepo notebookRepo;


    @Autowired
    public NotebookServices(NotebookRepo notebookRepo) {
        this.notebookRepo = notebookRepo;
    }


    public Notebook CreateNoteBook(Notebook n){


        return notebookRepo.save(n);
    }


    public Notebook FindNoteBookByID(Long id){



        return notebookRepo.findNotebookBynoteBookID(id).orElseThrow(


                () -> new IllegalArgumentException("Notebook not found!!")
        );
    }


    public void RemoveNoteBook(Long id){


        notebookRepo.deleteById(id);
    }





}
