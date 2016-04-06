package com.yongming.model;

/**
 * Created by jiangyongming on 4/5/16.
 */
public class poetModel {
    private int id;
    private String name;

    /**
     * constructor
     * Constructed by author name
     *
     * @param name
     */
    public poetModel(String name) {
        this.name = name;
    }

    /**
     * Getter and Setter
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
