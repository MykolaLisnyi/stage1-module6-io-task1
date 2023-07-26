package com.epam.mjc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try (java.io.FileReader fileReader = new java.io.FileReader (file)) {
            int ch;
            StringBuilder stringBuilder = new StringBuilder();
            while ((ch = fileReader.read()) != -1) {
                stringBuilder.append((char) ch);
            }
            StringTokenizer data = new StringTokenizer(stringBuilder.toString()
                    .replace("Name:", " ")
                    .replace("Age:", " ")
                    .replace("Email:", " ")
                    .replace("Phone:", " "));
            profile.setName(data.nextToken());
            profile.setAge(Integer.parseInt(data.nextToken()));
            profile.setEmail(data.nextToken());
            profile.setPhone(Long.parseLong(data.nextToken()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return profile;
    }
}