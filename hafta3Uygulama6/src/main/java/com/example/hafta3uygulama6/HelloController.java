package com.example.hafta3uygulama6;

import javafx.beans.binding.DoubleExpression;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    TextField txt;
    @FXML Button btn;
    String islem; //"+,-,*,/" işlemlerinden seçileni tutacak
    double yedek; //ilk girilen sayıyı tutacak

    @FXML
    public void rakamTikla(ActionEvent event){ //0-9 ve "." düğmeleri için olay
        Button x=(Button) event.getSource(); //basılan düğmeyi x' e al
        txt.setText(txt.getText()+x.getText());
        //txt' nin değerine, tıklanan düğmenin başlığını ekLe
    }

    public void operator(ActionEvent event) { //+,-,/ ve * düğmeleri olayı
        if (txt.getText().equals("")) return; //txt boş ise olaydan çık
        Button y=(Button) event.getSource();
        islem=y.getText();
        yedek=Double.valueOf(txt.getText()); //txt' deki değeri double değere çevir
        txt.clear();
    }

    public void esittir(){
        double sonuc;
        if (txt.getText().equals("")) return;
        if (islem.equals("+")){
            sonuc=Double.valueOf(txt.getText())+yedek;
            txt.setText(String.valueOf(sonuc));
        }

        if (islem.equals("-")){
            sonuc=Double.valueOf(txt.getText());
            if (sonuc>yedek)
                sonuc=sonuc-yedek;
            else
                sonuc=yedek-sonuc;
            txt.setText(String.valueOf(sonuc));
        }

        if (islem.equals("*")){
            sonuc=Double.valueOf(txt.getText())*yedek;
            txt.setText(String.valueOf(sonuc));
        }

        if (islem.equals("/")){
            sonuc=yedek/Double.valueOf(txt.getText());
            txt.setText(String.valueOf(sonuc));
        }

        if (islem.equals("%")) {
            sonuc=yedek%Double.valueOf(txt.getText());
            txt.setText(String.valueOf(sonuc));
        }
    }

    public void sil(){
        txt.clear();
        yedek=0;
    }
}