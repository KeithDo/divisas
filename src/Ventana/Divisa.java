package Ventana;

import java.util.Map;

public class Divisa {
    private String result, base_code;
    private Map conversion_rates;

    public Divisa() {}

    public Divisa(String result, String base_code, Map<?,Double> conversion_rates) {
        this.result = result;
        this.base_code = base_code;
        this.conversion_rates = conversion_rates;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getBase_code() {
        return this.base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public Map getConversion_rates() {
        return this.conversion_rates;
    }

    public void setConversion_rates(Map conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    public String convertirDivisa(String condicion) {
        return "hola";
    }

    @Override
    public String toString() {
        return "Divisa{" +
                "result='" + result + '\'' +
                ", base_code='" + base_code + '\'' +
                //", conversion_rates=" + conversion_rates +
                '}';
    }
}
