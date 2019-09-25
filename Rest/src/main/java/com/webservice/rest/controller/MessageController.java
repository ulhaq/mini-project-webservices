package com.webservice.rest.controller;

import com.webservice.rest.model.Message;
import com.webservice.rest.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("messages")
public class MessageController {

    @Autowired
    private MessageRepository repository;

    @GetMapping("/")
    public List<Message> index() {
        return repository.findAll();
    }

    @PostMapping("/")
    public Message store(@RequestBody Message newMessage) {
        return repository.save(newMessage);
    }

    @GetMapping("/{id}")
    public Message show(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PutMapping("/{id}")
    public Message update(@RequestBody Message newMessage, @PathVariable Long id) {
        return repository.findById(id).map(message -> {
            message.setText(newMessage.getText());
            return repository.save(message);
        }).orElseGet(() -> {
            newMessage.setId(id);
            return repository.save(newMessage);
        });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
