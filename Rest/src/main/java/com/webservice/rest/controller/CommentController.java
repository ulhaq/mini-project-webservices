package com.webservice.rest.controller;

import com.webservice.rest.model.Comment;
import com.webservice.rest.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    private CommentRepository repository;

    @GetMapping("/")
    public List<Comment> index() {
        return repository.findAll();
    }

    @PostMapping("/")
    public Comment store(@RequestBody Comment newComment) {
        return repository.save(newComment);
    }

    @GetMapping("/{id}")
    public Comment show(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PutMapping("/{id}")
    public Comment update(@RequestBody Comment newComment, @PathVariable Long id) {
        return repository.findById(id).map(comment -> {
            comment.setText(newComment.getText());
            return repository.save(comment);
        }).orElseGet(() -> {
            newComment.setId(id);
            return repository.save(newComment);
        });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
