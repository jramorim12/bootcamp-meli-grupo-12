package br.com.marcello.LinkTracer.entities;

public class Link {

    private Long id;
    private String url;
    private Integer accessCount;
    private String accessPassword;

    public Link(Long id, String url, Integer accessCount, String accessPassword) {
        this.id = id;
        this.url = url;
        this.accessCount = accessCount;
        this.accessPassword = accessPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Integer accessCount) {
        this.accessCount = accessCount;
    }

    public String getAccessPassword() {
        return accessPassword;
    }

    public void setAccessPassword(String accessPassword) {
        this.accessPassword = accessPassword;
    }
}
