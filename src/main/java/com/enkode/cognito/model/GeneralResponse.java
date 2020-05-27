package com.enkode.cognito.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class GeneralResponse<T> {

        private Integer statusCode;
        private String statusDescription;
        private ZonedDateTime dateTime;

        private T data;

        public GeneralResponse(Integer code, String desciption, ZonedDateTime date) {
                this.statusCode = code;
                this.statusDescription = desciption;
                this.dateTime = date;
        }

        public GeneralResponse(T data) {
                this.statusCode = 20000;
                this.statusDescription = "Success";
                this.dateTime = ZonedDateTime.now();
                this.data = data;
        }
}
