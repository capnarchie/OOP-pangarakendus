public class Inimene{
    String kasutajaNimi;
    String kontonr;
    double kontojääk;

    public Inimene(String kasutajaNimi, String kontonr) {
        this.kasutajaNimi = kasutajaNimi;
        this.kontonr = kontonr;
        this.kontojääk = suvaline();
    }
    public static double suvaline(){
        String[] pangad = {"10", "22", "77"};
        double summa =(Math.random()*(1000-0)+100);
        summa = Math.round(summa);
        return summa;
    }
}
