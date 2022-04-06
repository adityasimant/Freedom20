package com.example.freedom20.Models;

public class LogsModel {


    String header,websiteabt,info,img;

    public LogsModel(String img, String header, String websiteabt, String info) {
        this.img = img;
        this.header = header;
        this.websiteabt = websiteabt;
        this.info = info;

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getWebsiteabt() {
        return websiteabt;
    }

    public void setWebsiteabt(String websiteabt) {
        this.websiteabt = websiteabt;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
