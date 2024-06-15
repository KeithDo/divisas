package Ventana;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Notacion {
    private String json;
    private Gson gson;
    private BufferedReader archivo;
    private Divisa notacion;

    public Notacion() {
        this.conectar();
    }

    public void obtenerArchivo() {
        this.json = "";
        try {
            this.archivo = new BufferedReader(new FileReader("src/Ventana/json/exchangeRate.json"));
            String linea;
            while((linea = archivo.readLine()) != null) {
                this.json += linea;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.json();

    }

    public void json() {
        this.gson = new Gson();
        this.notacion = gson.fromJson(this.json, Divisa.class);
    }

    public Divisa retorno() {
        return this.notacion;
    }

    public void conectar() {
        this.json = "";
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder(URI.create("https://v6.exchangerate-api.com/v6/7182dc71c75eb1b0b4c4b0dc/latest/COP")).build();
        try {
            HttpResponse respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            this.json = respuesta.body().toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.json();
    }
}
