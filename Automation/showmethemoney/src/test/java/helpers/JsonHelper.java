package helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

import smtm.resources.Data;

public class JsonHelper {
    public static Data Data;

    public static Data readJson() {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("src/main/java/smtm/resources/Data.json");
            return gson.fromJson(reader, Data.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}