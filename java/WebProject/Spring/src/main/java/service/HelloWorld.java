package service;

public class HelloWorld {
    private String msg;
    private String msg2;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg2() {
        return msg2;
    }

    public void setMsg2(String msg2) {
        this.msg2 = msg2;
    }

    /**
     * Bean 「起始」時要執行的行為，名稱自定義
     * 需要 Beans.xml 中指定
     */
    public void init(){
        System.out.println("Bean is going through init.");
    }

    /**
     * Bean 「銷毀」時要執行的行為，名稱自定義
     * 需要 Beans.xml 中指定
     */
    public void destroy(){
        System.out.println("Bean will destroy now.");
    }
}
