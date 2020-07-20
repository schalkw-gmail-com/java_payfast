package com.example.demoForm;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription {
    private int code;
    private String status;
    private Value data;

    public Subscription() {
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Value getData() {
        return data;
    }

    public void setData(Value data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "code='" + code + '\'' +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
