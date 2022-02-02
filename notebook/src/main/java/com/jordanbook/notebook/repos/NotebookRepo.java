package com.jordanbook.notebook.repos;


import com.jordanbook.notebook.models.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotebookRepo extends JpaRepository<Notebook, Long> {


    Optional<Notebook> findNotebookBynoteBookID(Long id);
}
