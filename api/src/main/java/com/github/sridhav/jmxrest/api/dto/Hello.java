package com.github.sridhav.jmxrest.api.dto;

/**
 * Created by sridhav on 10/14/17.
 */
public class Hello {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Hello(String name){
        this.name = name;
    }

}
