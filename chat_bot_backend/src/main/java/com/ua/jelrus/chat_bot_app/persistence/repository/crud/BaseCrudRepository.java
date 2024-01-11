package com.ua.jelrus.chat_bot_app.persistence.repository.crud;

import com.ua.jelrus.chat_bot_app.persistence.entity.BaseEntity;
import com.ua.jelrus.chat_bot_app.persistence.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface BaseCrudRepository<E extends BaseEntity, R extends BaseRepository<E>> {

    E create(R rep, E e);

    E update(R rep, E e);

    E delete(R rep, Long id);

    Optional<E> findById(R rep, Long id);

    List<E> findAll(R rep);
}