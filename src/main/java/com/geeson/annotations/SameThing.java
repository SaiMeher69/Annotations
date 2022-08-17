package com.geeson.annotations;

import com.google.gson.internal.Primitives;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SameThing {
    public String convertToJson(Object object) throws IllegalAccessException, IOException {
        Class<?> clapp = object.getClass();
        HashMap<String, String> variables = new HashMap<>();
        for(Field field: clapp.getDeclaredFields()){
            if(field.isAnnotationPresent(NameToName.class)){
                field.setAccessible(true);
                variables.put(getValue(field), field.get(object).toString());
            }else{
                variables.put(field.getName(), field.get(object).toString());
            }
        }
        String jsonString = variables.entrySet().stream().map(entry -> "\n\t" + "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"").collect(Collectors.joining(","));
        FileWriter fw = new FileWriter("D:\\Office stuff\\annotations\\src\\main\\java\\com\\geeson\\annotations\\employee.json", true);
        fw.write("\n{" + jsonString + "\n}");
        fw.close();

        return jsonString;

    }

    private String getValue(Field field){
        return field.getAnnotation(NameToName.class).value();
    }

    public Object jsonToObject(Object object) throws IOException, NoSuchFieldException, IllegalAccessException {
        Class<?> clapp = object.getClass();
        FileReader fr = new FileReader("D:\\Office stuff\\annotations\\src\\main\\java\\com\\geeson\\annotations\\employee.txt");
        Properties p = new Properties();
        p.load(fr);
        fr.close();
        for(Field field : clapp.getDeclaredFields()){
            field.setAccessible(true);
            Class<?> type = field.getType();
            String value;
            if(field.isAnnotationPresent(NameToName.class)){
                value = field.getAnnotation(NameToName.class).value();
            }else{
                value = field.getName();
            }
            if(type.equals(int.class)){
                int temp = Integer.parseInt(p.getProperty(value));
                field.set(object,temp);
            }else if(type.equals(String.class)){
                String temp = p.getProperty(value);
                field.set(object,temp);
            }
        }
        return object;
    }


}
