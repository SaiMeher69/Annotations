package com.geeson.annotations;

import com.google.gson.Gson;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AnnotationsApplication {

    public static void main(String[] args) throws IOException, IllegalAccessException, NoSuchFieldException, SQLException, ClassNotFoundException {
        //SpringApplication.run(AnnotationsApplication.class, args);
        Employee employee = new Employee("Meher", "SDE", 123, 20, 100000);
        SameThing sameThing = new SameThing();
        //String jsonString = sameThing.convertToJson(employee);
        //System.out.println(jsonString);
        //Employee employee1 = (Employee) sameThing.jsonToObject(new Employee());
        //System.out.println(employee1.toString());


        String query = "insert into STUDENT_DATA (first_name, last_name, gender, country_name, email, password) values (?,?,?,?,?,?)";
        insertElement(query, employee);

    }

    public static void insertElement(String query, Employee emp) throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/test";
        String userName = "postgres";
        String password = "Kyouma#001";

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,emp.getName());
        preparedStatement.setString(2,emp.getName());
        preparedStatement.setString(3,emp.getJobTitle());
        preparedStatement.setString(4,"India");
        preparedStatement.setString(5,"email@email.com");
        preparedStatement.setString(6,"HyvdcUbc");

        int affectedRows = preparedStatement.executeUpdate();
        System.out.println(affectedRows);
        con.close();
    }
    /*public static void serializedEmployee(){
        Employee employee = new Employee("Meher", "SDE", 123, 20, 100000);
        Gson gson = new Gson();
        String json = gson.toJson(employee);
        System.out.println(json);
    }
    public static void deSerializedEmployee() throws IOException {
        Scanner scan = new Scanner(new File("D:\\Office stuff\\annotations\\src\\main\\java\\com\\geeson\\annotations\\employee.json"));
        String content = scan.useDelimiter("\\Z").next();
        scan.close();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(content, Employee.class);
        System.out.println(employee.toString());
    }*/

    }
