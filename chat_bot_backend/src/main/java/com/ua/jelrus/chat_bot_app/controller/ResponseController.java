package com.ua.jelrus.chat_bot_app.controller;

import com.ua.jelrus.chat_bot_app.persistence.entity.impl.Response;
import com.ua.jelrus.chat_bot_app.service.ResponseService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("response")
public class ResponseController {

    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @PostMapping("/create")
    public HttpEntity<Response> create(@RequestBody Response response) {
        return ResponseEntity.ok().body(responseService.create(response));
    }

    @GetMapping("/{id}")
    public HttpEntity<Response> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(responseService.findById(id));
    }

    @PutMapping("/{id}/update")
    public HttpEntity<Response> update(@PathVariable Long id) {
        return ResponseEntity.ok().body(responseService.update(responseService.findById(id)));
    }

    @DeleteMapping("/{id}/delete")
    public HttpEntity<Response> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(responseService.delete(id));
    }

    @GetMapping("/all")
    public HttpEntity<List<Response>> findAll() {
        return ResponseEntity.ok().body(responseService.findAll());
    }
}