package io.blackberry.spring.homework3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

    public static final String URL = "jdbc:mysql://localhost:3306/demo";
    public static final String USER = "demo";
    public static final String PASSWORD = "123456";


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        // 获得数据库链接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);



        // 查询
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select id, username from user");
        while (resultSet.next()) {
            System.out.println("id: " + resultSet.getLong("id") + ", username: " + resultSet.getString("username"));
        }

        // 新增
        String insertSql = "INSERT INTO USER(id, username) values (?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(insertSql);
        preparedStatement.setLong(1, 1001L);
        preparedStatement.setString(2, "张三");
        preparedStatement.execute();

        // 更新
        String updateSql = "UPDATE USER SET username=? where id=?";
        PreparedStatement preparedStatement1 = conn.prepareStatement(updateSql);
        preparedStatement1.setString(1, "李四");
        preparedStatement1.setLong(2, 1001L);
        preparedStatement1.execute();
    }
}
