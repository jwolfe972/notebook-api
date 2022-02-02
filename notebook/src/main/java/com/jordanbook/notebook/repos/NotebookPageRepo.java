package com.jordanbook.notebook.repos;

import com.jordanbook.notebook.models.NotebookPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotebookPageRepo extends JpaRepository<NotebookPage, Long> {


}
