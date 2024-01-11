package com.ua.jelrus.chat_bot_app.persistence.entity.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ua.jelrus.chat_bot_app.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "response")
@JsonIgnoreProperties(value = {"request"})
public class Response extends BaseEntity {

    @Column(name = "opt")
    private String option;

    @Column(name = "respText")
    private String respText;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "request_responses",
            joinColumns = @JoinColumn(name = "response_id"),
            inverseJoinColumns = @JoinColumn(name = "request_id")
    )
    private Request request;

    public Response() {
        super();
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getRespText() {
        return respText;
    }

    public void setRespText(String respText) {
        this.respText = respText;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Response response = (Response) o;
        return Objects.equals(option, response.option) && Objects.equals(respText, response.respText) && Objects.equals(request, response.request);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), option, respText, request);
    }
}
