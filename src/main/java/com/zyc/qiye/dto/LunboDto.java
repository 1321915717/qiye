package com.zyc.qiye.dto;

public class LunboDto {
    private  String url;
    private  String type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LunboDto{" +
                "url='" + url + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}