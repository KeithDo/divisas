package Ventana;

public class ConversionRates {
    private String[][] COL, USD, EUR, GBP, JPY, KRW;

    public ConversionRates() {

    }

    public ConversionRates(String[][] COL, String[][] USD, String[][] EUR, String[][] GBP, String[][] JPY, String[][] KRW) {
        this.COL = COL;
        this.USD = USD;
        this.EUR = EUR;
        this.GBP = GBP;
        this.JPY = JPY;
        this.KRW = KRW;
    }

    public String[][] getCOL() {
        return this.COL;
    }

    public void setCOL(String[][] COL) {
        this.COL = COL;
    }

    public String[][] getUSD() {
        return this.USD;
    }

    public void setUSD(String[][] USD) {
        this.USD = USD;
    }

    public String[][] getEUR() {
        return this.EUR;
    }

    public void setEUR(String[][] EUR) {
        this.EUR = EUR;
    }

    public String[][] getGBP() {
        return this.GBP;
    }

    public void setGBP(String[][] GBP) {
        this.GBP = GBP;
    }

    public String[][] getJPY() {
        return this.JPY;
    }

    public void setJPY(String[][] JPY) {
        this.JPY = JPY;
    }

    public String[][] getKRW() {
        return this.KRW;
    }

    public void setKRW(String[][] KRW) {
        this.KRW = KRW;
    }

    @Override
    public String toString() {
        return "ConversionRates{" +
                "COL=" + this.COL +
                ", EUR=" + this.EUR +
                ", GBP=" + this.GBP +
                ", JPY=" + this.JPY +
                ", KRW=" + this.KRW +
                '}';
    }
}
