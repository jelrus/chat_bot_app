package com.ua.jelrus.chat_bot_app.persistence.repository.impl;

import com.ua.jelrus.chat_bot_app.persistence.entity.impl.Request;
import com.ua.jelrus.chat_bot_app.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestRepository extends BaseRepository<Request> {}