import java.util.Scanner;

public class Konto {
    double kontojääk;
    double eelmineÜlekanne;
    String kasutajaNimi;
    String kontonr;


    public Konto(String kasutajaNimi, String kontonr) {
        this.kasutajaNimi = kasutajaNimi;
        this.kontonr = kontonr;
    }

    void rahaÜlekanne(double kogus){
        if (kogus != 0){
            kontojääk = kontojääk + kogus;
            eelmineÜlekanne = kogus;
        }
    }

    void võtanRahavälja(double kogus){
        if (kogus != 0){
            kontojääk = kontojääk - kogus;
            eelmineÜlekanne = -kogus;
        }
    }

    void näitaÜlekannet(){
        if (eelmineÜlekanne > 0) {
            System.out.println("kandsite kontole " + eelmineÜlekanne + "eurot");
        }else if (eelmineÜlekanne < 0){
            System.out.println("võtsite kontolt välja " + Math.abs(eelmineÜlekanne) + "eurot");
        }else System.out.println("Ülekannet pole veel toimunud");
    }

    void näitavalikuid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Teretulemast Swedbanki " + kasutajaNimi);
        System.out.println("teie kontonr on " + kontonr);
        System.out.println("mida te soovite teha?");
        System.out.println("valikud on: 1) Vaatan kontojääki, 2) Kannan kontole raha, 3) Võtan kontolt raha välja, 4) Vaatan viimast tehingut, 5) Logi välja");


        int vastus;
        do {
            System.out.println("valiku tegemiseks kirjutage vastav number ");
            vastus = sc.nextInt();


            switch (vastus) {
                case 1:
                    System.out.println("kontojääk on " + kontojääk + " eurot");
                    break;
                case 2:
                    System.out.println("Sisestage kogus mida soovite kontole kanda");
                    double kantavKogus = sc.nextDouble();
                    rahaÜlekanne(kantavKogus);
                    break;
                case 3:
                    System.out.println("Sisestage kogus mida soovite kontolt välja võtta");
                    double väljavõetavKogus = sc.nextDouble();
                    võtanRahavälja(väljavõetavKogus);
                    break;
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
