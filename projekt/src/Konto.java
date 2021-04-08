import java.util.Scanner;

public class Konto extends Inimene{
    double eelmineÜlekanne;

    public Konto(String kasutajaNimi, String kontonr) {
        super(kasutajaNimi, kontonr);
    }

    void rahaÜlekanne(double kogus){
        if (kogus != 0){
            kontojääk = kontojääk + kogus;
            eelmineÜlekanne = kogus;
        }
    }

    void võtanRahavälja(double kogus){
        if (kogus != 01){
            kontojääk = kontojääk - kogus;
            eelmineÜlekanne = -kogus;
        }
    }

    void näitaÜlekannet(){
        if (eelmineÜlekanne > 0) {
            System.out.println("Kandsite kontole " + eelmineÜlekanne + "eurot");
        }else if (eelmineÜlekanne < 0){
            System.out.println("Võtsite kontolt välja " + Math.abs(eelmineÜlekanne) + " eurot");
        }else System.out.println("Ülekannet pole täna toimunud.");
    }


    void näitavalikuid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tere tulemast " + Main.misPank(kontonr) + " pangalehele " + kasutajaNimi);
        System.out.println("Teie kontonr on " + kontonr);
        System.out.println("Mida te soovite teha?");
        System.out.println("Menüü: 1) Vaatan kontojääki, 2) Kannan kontole raha, 3) Võtan kontolt raha välja, 4) Vaatan viimast tehingut, 5) Logi välja");


        int vastus;
        do {
            System.out.println("Valiku tegemiseks kirjutage vastav number: ");
            vastus = sc.nextInt();


            switch (vastus) {
                case 1:
                    System.out.println("Kontojääk on " + kontojääk + " eurot");
                    break;
                case 2:
                    System.out.println("Sisestage kogus, mida soovite kontole kanda");
                    double kantavKogus = sc.nextDouble();
                    rahaÜlekanne(kantavKogus);
                    break;
                case 3:
                    System.out.println("Sisestage kogus, mida soovite kontolt välja võtta");
                    double väljavõetavKogus = sc.nextDouble();
                    if (kontojääk-väljavõetavKogus <= 0){
                        System.out.println("Summat ei saa välja võtta, pole piisavalt vabu vahendeid");
                        break;
                    }
                    else{
                        võtanRahavälja(väljavõetavKogus);
                        break;
                    }

                case 4:
                    näitaÜlekannet();
                    break;
                case 5:
                    break;
            }
        }while (vastus != 5);
        System.out.println("Logisite välja");
    }

}
