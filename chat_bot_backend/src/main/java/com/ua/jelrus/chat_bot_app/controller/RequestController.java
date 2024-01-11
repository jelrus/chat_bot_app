package com.ua.jelrus.chat_bot_app.controller;

import com.ua.jelrus.chat_bot_app.persistence.entity.impl.Request;
import com.ua.jelrus.chat_bot_app.service.RequestService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("request")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/create")
    public HttpEntity<Request> create(@RequestBody Request request) {
        return ResponseEntity.ok().body(requestService.create(request));
    }

    @GetMapping("/{id}")
    public HttpEntity<Request> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(requestService.findById(id));
    }

    @PutMapping("/{id}/update")
    public HttpEntity<Request> update(@PathVariable Long id) {
        return ResponseEntity.ok().body(requestService.update(requestService.findById(id)));
    }

    @DeleteMapping("/{id}/delete")
    public HttpEntity<Request> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(requestService.delete(id));
    }

    @GetMapping("/all")
    public HttpEntity<List<Request>> findAll() {
        return ResponseEntity.ok().body(requestService.findAll());
    }
}