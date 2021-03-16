package com.mei.entity;

/**
 * 该user没有写全gtiee返回的user
 */
public class user {
    private Integer id;
    private String login;
    private String name;
    private String html_url;

    public user() {
    }

    public user(Integer id, String login, String name, String html_url) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.html_url = html_url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", html_url='" + html_url + '\'' +
                '}';
    }
}
