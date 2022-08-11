package com.geeson.annotations;

import com.google.gson.Gson;
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
        String jsonString = sameThing.convertToJson(employee);
        System.out.println(jsonString);
        Employee employee1 = (Employee) sameThing.jsonToObject(new Employee());
        System.out.println(employee1.toString());
    }
    public static void serializedEmployee(){
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
    }

    }
