package cc.com.beans;

public class TestBean {

    private String message = "測試bean";
    private String name = "紅孩兒";
    private int age = 0;

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
