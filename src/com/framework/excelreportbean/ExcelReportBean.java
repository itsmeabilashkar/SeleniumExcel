package com.framework.excelreportbean;

/**
 * Created by Lenovo on 8/5/2018.
 */
public class ExcelReportBean {


    String userName;
    String password;
  
    public ExcelReportBean(String uName,String pwd) {
        this.userName=uName;
        this.password=pwd;
        
        System.err.println(this);
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
  
    @Override
    public String toString() {
        return "ExcelReportBean [userName=" + userName + ", pwd=" + password+ "]";
    }


}
