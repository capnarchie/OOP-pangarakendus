import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Konto konto = new Konto(kasutajanimi(), KontoOlemasolu());//kontonumber());
        konto.näitavalikuid();


    }
        //kasutaja dialoog jah/ei küsimuseks
    public static String KontoOlemasolu(){
        int vastus = JOptionPane.showOptionDialog(new JFrame(), "Kas teil on kontonumber?", "Eksisteeriv kasutaja?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[] { "Jah", "Ei" }, JOptionPane.YES_OPTION);
        if (vastus == JOptionPane.YES_OPTION) {
            return kontonumber();
        }
        else if (vastus == JOptionPane.NO_OPTION){
            kontroNR();
        }
        return kontroNR();
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
        //genereerib kasutajale suvalise kontonumbri kui vastatud "ei" kontoOlemasolu dialoogis
    public static String kontroNR(){
        String[] jada = new String[9];
        jada[0] = "EE";

        for (int i = 1; i < 9; i++) {
            jada[i] = Integer.toString((int)(Math.random()*(100-10) + 10));
        }
        jada[2] = suvaline();
        String kontonumber = String.join("", jada);

        return kontonumber;
    }
        //genereerib kasutajale suvalise panga poolt konto
    public static String suvaline(){
        String[] pangad = {"10", "22", "77"};
        int index = (int) (Math.random()*(2-0)+0);
        String pangainitsiatiiv = pangad[index];
        return pangainitsiatiiv;
    }
        //tuvastab mis pangaga on tegemist
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