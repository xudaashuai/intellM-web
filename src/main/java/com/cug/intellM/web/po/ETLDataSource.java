package com.cug.intellM.web.po;

public class ETLDataSource {
    private Integer id;

    private Integer type;

    private String url;

    private String username;

    private String password;

    private Integer extract;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getExtract() {
        return extract;
    }

    public void setExtract(Integer extract) {
        this.extract = extract;
    }
}