package com.ua.jelrus.chat_bot_app.service.impl;

import com.ua.jelrus.chat_bot_app.persistence.entity.impl.Request;
import com.ua.jelrus.chat_bot_app.persistence.repository.crud.BaseCrudRepository;
import com.ua.jelrus.chat_bot_app.persistence.repository.impl.RequestRepository;
import com.ua.jelrus.chat_bot_app.service.RequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;

    private final BaseCrudRepository<Request, RequestRepository> crudRepo;

    public RequestServiceImpl(RequestRepository requestRepository,
                              BaseCrudRepository<Request, RequestRepository> crudRepo) {
        this.requestRepository = requestRepository;
        this.crudRepo = crudRepo;
    }


    @Override
    public Request create(Request request) {
        return crudRepo.create(requestRepository, request);
    }

    @Override
    public Request findById(Long id) {
        return crudRepo.findById(requestRepository, id).orElseThrow(
                () -> new RuntimeException("Request with (id = " + id + ") not found")
        );
    }

    @Override
    public Request update(Request request) {
        return crudRepo.update(requestRepository, request);
    }

    @Override
    public Request delete(Long id) {
        return crudRepo.delete(requestRepository, id);
    }

    @Override
    public List<Request> findAll() {
        return crudRepo.findAll(requestRepository);
    }
}