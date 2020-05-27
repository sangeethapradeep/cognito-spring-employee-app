package com.enkode.cognito.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestException extends RuntimeException {
        private  Integer errorCode;
        private  String errorDescription;

        public static final RequestException NO_DATA = new RequestException(40001, "No Data Found");
}
