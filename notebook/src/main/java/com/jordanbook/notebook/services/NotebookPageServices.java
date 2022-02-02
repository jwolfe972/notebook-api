package com.jordanbook.notebook.services;


import com.jordanbook.notebook.models.NotebookPage;
import com.jordanbook.notebook.repos.NotebookPageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotebookPageServices {


    private final NotebookPageRepo notebookPageRepo;


    @Autowired
    public NotebookPageServices(NotebookPageRepo notebookPageRepo) {
        this.notebookPageRepo = notebookPageRepo;
    }



    public NotebookPage AddPage(NotebookPage nP){



        return notebookPageRepo.save(nP);
    }


    public NotebookPage UpdatePage(NotebookPage nP){


        return notebookPageRepo.save(nP);
    }

    public List<NotebookPage> AllPagesInBook(Long b_id){



        return notebookPageRepo.findAll();

    }




}
