package org.template.common.models;

import org.springframework.http.ResponseEntity;

public class ResponseObject extends BaseObject{

    private Object body;

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
