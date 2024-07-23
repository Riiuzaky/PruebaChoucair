package com.choucair.prueba.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;


public class ConvertJson {
    
    public static Employed  handleJson(String json) {
        Gson gson = new Gson();
        FileReader reader;
        Employed employed;
        try {
            reader = new FileReader(json);
            employed = gson.fromJson(reader, Employed.class);
            return employed ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
        // Usar el objeto data
    }
    
}
