package com.ua.jelrus.chat_bot_app.service;

import com.ua.jelrus.chat_bot_app.persistence.entity.BaseEntity;

import java.util.List;

public interface BaseService<E extends BaseEntity, T> {

    E create(E e);

    E findById(T id);

    E update(E e);

    E delete(T id);

    List<E> findAll();
}