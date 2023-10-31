package hello.jdbc.connection;

public abstract class ConnectionConst { //추상클래스는 객체생성을 못한다.
    public static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "0000";
}


