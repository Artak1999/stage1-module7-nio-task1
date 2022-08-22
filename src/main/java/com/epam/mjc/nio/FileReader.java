package com.epam.mjc.nio;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        StringBuilder result = new StringBuilder();
        try {
            int i;
            FileInputStream inputStream = new FileInputStream(file.getPath());
            while ((i = inputStream.read()) != -1) {
                result.append((char) i);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < result.length(); i++) {
            if (result.toString().contains("Name: "))
                result = new StringBuilder(result.toString().replace("Name: ", ""));
            if (result.toString().contains("Age: "))
                result = new StringBuilder(result.toString().replace("Age: ", ""));
            if (result.toString().contains("Email: "))
                result = new StringBuilder(result.toString().replace("Email: ", ""));
            if (result.toString().contains("Phone: "))
                result = new StringBuilder(result.toString().replace("Phone: ", ""));
        }
        String[] lines = result.toString().split("\\R");
        profile.setName(lines[0]);
        profile.setAge(Integer.parseInt(lines[1]));
        profile.setEmail(lines[2]);
        profile.setPhone(Long.parseLong(lines[3]));
        return new Profile(profile.getName(), profile.getAge(), profile.getEmail(), profile.getPhone());
    }
}
