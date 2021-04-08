import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Konto konto1 = new Konto(kasutajanimi(), kontonumber());
        konto1.näitavalikuid();
    }

    public static String kasutajanimi() {
        String sisestatakse = JOptionPane.showInputDialog(null, "Sisesta enda kasutajanimi ", "Andmete sisestamine",
                JOptionPane.QUESTION_MESSAGE);
        return sisestatakse;
    }

    public static String kontonumber(){
        String sisestatakse = JOptionPane.showInputDialog(null, "Sisesta enda kontonumber ", "Andmete sisestamine",
                JOptionPane.QUESTION_MESSAGE);
        return sisestatakse;
    }

    public static String misPank(String kontonr){
            String[] loend = kontonr.split("", kontonr.length());
            String arv = loend[4] + loend[5];
            String pank = new String();
            if (arv.equals("10")){
                pank = "SEB";
            }
            if (arv.equals("22")){
                pank = "Swedbank";
            }
            if (arv.equals("77")){
                pank = "LHV";
            }
            return pank;
    }

}