package com.ua.jelrus.chat_bot_app.persistence.repository.crud.impl;

import com.ua.jelrus.chat_bot_app.persistence.entity.BaseEntity;
import com.ua.jelrus.chat_bot_app.persistence.repository.BaseRepository;
import com.ua.jelrus.chat_bot_app.persistence.repository.crud.BaseCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseCrudRepositoryImpl<E extends BaseEntity, R extends BaseRepository<E>>
        implements BaseCrudRepository<E, R> {

    @Override
    public E create(R rep, E e) {
        System.out.println(e);
        return rep.save(e);
    }

    @Override
    public E update(R rep, E e) {
        return rep.save(e);
    }

    @Override
    public E delete(R rep, Long id) {
        E e = rep.findById(id).orElseThrow(
                () -> new RuntimeException("Entity with (id = " + id + ") not found")
        );
        rep.deleteById(id);
        return e;
    }

    @Override
    public Optional<E> findById(R rep, Long id) {
        return rep.findById(id);
    }

    @Override
    public List<E> findAll(R rep) {
        return rep.findAll();
    }
}