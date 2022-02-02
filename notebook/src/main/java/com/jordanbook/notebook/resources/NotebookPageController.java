package com.jordanbook.notebook.resources;


import com.jordanbook.notebook.models.Notebook;
import com.jordanbook.notebook.models.NotebookPage;
import com.jordanbook.notebook.models.User;
import com.jordanbook.notebook.services.NotebookPageServices;
import com.jordanbook.notebook.services.NotebookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pages")
public class NotebookPageController {


    private final NotebookPageServices notebookPageServices;
    private final NotebookServices notebookServices;


    @Autowired
    public NotebookPageController(NotebookPageServices notebookPageServices, NotebookServices notebookServices) {
        this.notebookPageServices = notebookPageServices;
        this.notebookServices = notebookServices;
    }



    @PostMapping("/add")
    public ResponseEntity<NotebookPage> addNotebookPage(@RequestParam("book") Long id){


        NotebookPage n = new NotebookPage(notebookServices.FindNoteBookByID(id), "Untitled", "New page");

        NotebookPage u = notebookPageServices.AddPage(n);

        return new ResponseEntity<>(u, HttpStatus.CREATED);

    }

    @PutMapping("/modify")
    public ResponseEntity<NotebookPage> updatePage(@RequestParam("book") Long b_id, @RequestBody NotebookPage nP){


        nP.setNotebook(notebookServices.FindNoteBookByID(b_id));





        NotebookPage s = notebookPageServices.UpdatePage(nP);

        return new  ResponseEntity<>(s, HttpStatus.OK);





    }







    @GetMapping("/view")
    public ResponseEntity<List<NotebookPage>> getAllPagesInBook(@PathVariable("book") Long b_id){



        List<NotebookPage> n = notebookPageServices.AllPagesInBook(b_id);

        return new ResponseEntity<>(n, HttpStatus.OK);
    }



}
