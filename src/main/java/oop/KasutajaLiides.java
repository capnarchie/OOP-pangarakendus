package oop;

import javafx.application.Application;
import javafx.css.ParsedValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.*;


public class KasutajaLiides extends Application implements EventHandler<ActionEvent> {
    private Button login;
    private Button viimaneÜlekanne;
    private Button rahaLisaja;
    private Button võtanRaha;
    private Button genereeri;

    private Stage lava;
    private Stage lava2;
    private TextField kasutajanimi;
    private PasswordField parool;

    private Label rahajääk;
    private Label eelmineTehing;
    private Label tutvustus;
    private Label kontonr;
    private Label juhend;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sisselogimine");
        this.lava = primaryStage;
        GridPane võre = new GridPane();
        võre.setAlignment(Pos.CENTER);
        võre.setHgap(10);
        võre.setVgap(10);
        võre.setPadding(new Insets(25,25,25,25));

        Scene stseen = new Scene(võre,500,300);

        this.login = new Button("login");
        login.setOnAction(this);
        this.genereeri = new Button("Genereeri kontonumber");
        genereeri.setOnAction(this);

        Label kasutaja = new Label("Kasutajanimi");
        this.juhend = new Label("Näide õigest kontonumbrist: " + "EE901011123456789012");
        võre.add(juhend,0,0);
        võre.add(kasutaja, 0,1);
        this.kasutajanimi = new TextField();
        võre.add(kasutajanimi, 1,1);
        Label kontosilt = new Label("Kontonumber");

        võre.add(kontosilt,0,2);
        this.parool = new PasswordField();
        võre.add(parool,1,2);

        HBox hbButton = new HBox(10);
        hbButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbButton.getChildren().add(login);
        HBox hbButton2 = new HBox(10);
        hbButton2.setAlignment(Pos.BOTTOM_LEFT);
        hbButton2.getChildren().add(genereeri);
        võre.add(hbButton2,0,4);
        võre.add(hbButton,1,4);

        lava.setScene(stseen);
        lava.show();
    }

    private void KasutajaKonto() {
        double raha = konto.kontojääk;
        this.lava2 = new Stage();
        lava2.setTitle("Pangaleht");
        GridPane võre2 = new GridPane();
        võre2.setAlignment(Pos.TOP_CENTER);
        võre2.setHgap(10);
        võre2.setVgap(10);
        võre2.setPadding(new Insets(50,25,25,25));


        this.tutvustus = new Label("Tere tulemast " + Main.misPank(parool.getText()) + " pangalehele " + kasutajanimi.getText());
        this.kontonr = new Label("Teie kontonumber on: " + parool.getText());
        võre2.add(kontonr,0,4);
        võre2.add(tutvustus,0,3);


        this.eelmineTehing = new Label("");
        this.rahajääk = new Label("Kontojääk: "+0+"€");
        võre2.add(eelmineTehing,0,2);
        võre2.add(rahajääk,0,1);
        rahajääk.setAlignment(Pos.CENTER_LEFT);

        Scene stseen2 = new Scene(võre2,500,500);

        this.viimaneÜlekanne = new Button("Vaata viimast tehingut");
        viimaneÜlekanne.setOnAction(this);
        this.rahaLisaja = new Button("lisa raha juurde");

        võre2.add(viimaneÜlekanne, 0,0);
        rahaLisaja.setOnAction(this);
        võre2.add(rahaLisaja, 1,0);
        this.võtanRaha = new Button("Võta raha välja");
        võtanRaha.setOnAction(this);
        võre2.add(võtanRaha,2,0);

        lava2.setScene(stseen2);
        lava2.show();


    }

    public static double PaljuRahaLisada() {
        double sisestatakse = Double.parseDouble(JOptionPane.showInputDialog(null, "Sisesta rahasumma mida soovite lisada ", "Andmete sisestamine",
                JOptionPane.QUESTION_MESSAGE));
        return sisestatakse;
    }

    public static double PaljuRahaVõtta() {
        double sisestatakse = Double.parseDouble(JOptionPane.showInputDialog(null, "Sisesta rahasumma mida soovite võtta välja ", "Andmete sisestamine",
                JOptionPane.QUESTION_MESSAGE));
        return sisestatakse;
    }




    private Konto konto;
    double summa = 0;
    @Override
    public void handle(ActionEvent event) {

        if (event.getSource() == login) {
            if (parool.getText()==null || parool.getText().length() < 6 || kasutajanimi.getText().length() == 0){
                Alert hoiatus = new Alert(Alert.AlertType.ERROR);
                hoiatus.setContentText("Teie kontonumber või kasutajanimi on kas tühi või liiga lühike, palun vaadake et see oleks pikem kui 5 tähte");
                hoiatus.show();
                throw new lühikeKontonrErind("Teie kontonumber on kas tühi või liiga lühike, palun vaadake et see oleks pikem kui 5 tähte");
            }
            konto = new Konto(kasutajanimi.getText(), parool.getText());
            lava.hide();
            KasutajaKonto();
        } else if (event.getSource() == viimaneÜlekanne) {
            eelmineTehing.setText(konto.näitaÜlekannet());
        } else if (event.getSource() == rahaLisaja) {
            summa = konto.rahaÜlekanne(PaljuRahaLisada());
            rahajääk.setText("Kontojääk: "+ summa);
        } else if (event.getSource() == võtanRaha){
            summa = konto.võtanRahavälja(PaljuRahaVõtta());
            rahajääk.setText("Kontojääk: " + summa);
        } else if (event.getSource() == genereeri){
            parool.setText(Main.kontroNR());
        }
    }




    public static void main(String[] args) {
        launch(args);

    }
}
