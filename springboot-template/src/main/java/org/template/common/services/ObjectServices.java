package org.template.common.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.template.common.constants.MessageConstants;
import org.template.common.models.ResponseObject;

@Service
public class ObjectServices {

    public <T> ResponseEntity<ResponseObject> getResponseBody(T body) {

        ResponseObject ro = new ResponseObject();
        ro.setStatus(true);
        ro.setMessage(MessageConstants.successMessage);
        ro.setBody(body);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ro);
    }

    public <T> ResponseEntity<ResponseObject> setStatusVO(T body, boolean status, String errorMessage) {

        ResponseObject ro = new ResponseObject();
        ro.setStatus(status);
        ro.setMessage(errorMessage);
        ro.setBody(body);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ro);
    }

}
