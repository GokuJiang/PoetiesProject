package com.yongming.model;

/**
 * Created by jiangyongming on 4/5/16.
 */
public class poetoryModel {

    private int id;
    private int poet_id;
    private String content;
    private String title;
    private String name;

    /**
     * Contructor
     * Contructed with poet_id
     *
     * @param poet_id
     */
    public poetoryModel(int poet_id) {
        this.poet_id = poet_id;
    }


    /**
     * Contructor
     * Contructed with none
     */
    public poetoryModel() {

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

    public int getPoet_id() {
        return poet_id;
    }

    public void setPoet_id(int poet_id) {
        this.poet_id = poet_id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
