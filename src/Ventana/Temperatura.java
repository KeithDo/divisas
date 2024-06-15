package Ventana;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Temperatura {
    public Temperatura() {
        this.obtenerArchivoJson();
    }

    private void obtenerArchivoJson() {
        String json = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader("src/Ventana/json/exchangeRate.json"));
            json = file.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(json);
    }
}
