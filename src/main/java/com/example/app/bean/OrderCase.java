package com.example.app.bean;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderCase {

    private int type;

    private String name;

    private List<String> traces;

    public void append(String message) {
        this.traces.add(message);
    }
}
