package com.jordanbook.notebook.resources;


import com.jordanbook.notebook.models.Notebook;
import com.jordanbook.notebook.services.NotebookServices;
import com.jordanbook.notebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notebook")
public class NotebookController {


    private final NotebookServices notebookServices;
    private final UserService userService;

    @Autowired
    public NotebookController(NotebookServices notebookServices, UserService userService) {
        this.notebookServices = notebookServices;
        this.userService = userService;
    }



    @PostMapping("/create")
    public ResponseEntity<Notebook> addNotebook(@RequestBody Notebook n, @RequestParam("owner") Long id){

        n.setOwnerID(userService.findUserByID(id));
        n.setPageCount(0);
        Notebook u = notebookServices.CreateNoteBook(n);

        return new ResponseEntity<>(u, HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Notebook> getBookByID(@PathVariable("id") Long id){


        Notebook n = notebookServices.FindNoteBookByID(id);


        return new ResponseEntity<>(n, HttpStatus.OK);
    }
}
