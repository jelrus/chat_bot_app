package com.ua.jelrus.chat_bot_app.persistence.entity.impl;

import com.ua.jelrus.chat_bot_app.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "request")
public class Request extends BaseEntity {

    @Column(name = "reqText")
    private String reqText;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL)
    private List<Response> responses;

    public Request() {
        super();
    }

    public String getReqText() {
        return reqText;
    }

    public void setReqText(String reqText) {
        this.reqText = reqText;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Request request = (Request) o;
        return Objects.equals(reqText, request.reqText) && Objects.equals(responses, request.responses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), reqText, responses);
    }
}