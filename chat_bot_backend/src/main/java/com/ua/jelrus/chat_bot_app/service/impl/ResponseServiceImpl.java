package com.ua.jelrus.chat_bot_app.service.impl;

import com.ua.jelrus.chat_bot_app.persistence.entity.impl.Request;
import com.ua.jelrus.chat_bot_app.persistence.entity.impl.Response;
import com.ua.jelrus.chat_bot_app.persistence.repository.crud.BaseCrudRepository;
import com.ua.jelrus.chat_bot_app.persistence.repository.impl.ResponseRepository;
import com.ua.jelrus.chat_bot_app.service.ResponseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {

    private final ResponseRepository responseRepository;

    private final BaseCrudRepository<Response, ResponseRepository> crudRepo;

    public ResponseServiceImpl(ResponseRepository responseRepository,
                               BaseCrudRepository<Response, ResponseRepository> crudRepo) {
        this.responseRepository = responseRepository;
        this.crudRepo = crudRepo;
    }

    @Override
    public Response create(Response response) {
        return crudRepo.create(responseRepository, response);
    }

    @Override
    public Response findById(Long id) {
        return crudRepo.findById(responseRepository, id).orElseThrow(
                () -> new RuntimeException("Request with (id = " + id + ") not found")
        );
    }

    @Override
    public Response update(Response response) {
        return crudRepo.update(responseRepository, response);
    }

    @Override
    public Response delete(Long id) {
        return crudRepo.delete(responseRepository, id);
    }

    @Override
    public List<Response> findAll() {
        return crudRepo.findAll(responseRepository);
    }
}