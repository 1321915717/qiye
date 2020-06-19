package com.zyc.qiye.dto;



public class ResultOssInfo {

    private String  fileType;

    private  String  fileDownLoadUrl;
    private  String fileName;



    private  String  error;
    private  String errorMsg;
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileDownLoadUrl() {
        return fileDownLoadUrl;
    }

    public void setFileDownLoadUrl(String fileDownLoadUrl) {
        this.fileDownLoadUrl = fileDownLoadUrl;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
