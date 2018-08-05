package SeleniumBrowser;

/**
 * Created by Lenovo on 8/5/2018.
 */
public class ExcelReportBean {


    String userName;
    String password;
    String desc;
    public ExcelReportBean(String uName,String pwd, String desc) {
        this.userName=uName;
        this.password=pwd;
        this.desc=desc;
        System.err.println(this);
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public String getDesc() {
        return desc;
    }
    @Override
    public String toString() {
        return "ExcelReportBean [userName=" + userName + ", pwd=" + password + ", desc=" + desc + "]";
    }


}
