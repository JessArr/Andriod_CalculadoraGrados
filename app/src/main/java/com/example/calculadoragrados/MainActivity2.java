package com.example.calculadoragrados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.calculadoragrados.models.Celsuis;
import com.example.calculadoragrados.models.Farenheit;
import com.example.calculadoragrados.models.Grado;
import com.example.calculadoragrados.models.Kelvin;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private RadioButton[] radioButtons = new RadioButton[3];
    private Button[] buttons = new Button[3];
    private TextView textView;
    private EditText editText;

    Celsuis celsuis = new Celsuis(0.0);
   Kelvin kelvin = new Kelvin(0.0);
    Farenheit farenheit = new Farenheit(0.0);

   Grado grado = new Grado();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        grado.setUnidad("C");
        grado.setValor(0.0);



        radioButtons[0] = findViewById(R.id.RadionButtonCelsuis);
        radioButtons[1] = findViewById(R.id.RadionButtonKelvin);
        radioButtons[2] = findViewById(R.id.RadionButtonFarenheit);
        buttons[0] = findViewById(R.id.ButtonCelsuis);
        buttons[1] = findViewById(R.id.ButtonKelvin);
        buttons[2] = findViewById(R.id.ButtonFarenheit);

        textView = findViewById(R.id.CantdiadReturn);
        editText = findViewById(R.id.CantdiadIngresada);

        for (RadioButton radioButton : radioButtons) {
            radioButton.setOnClickListener(this);
        }
        for (Button button : buttons) {
            button.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ButtonFarenheit) {
            if(grado.getUnidad().equals("C")){
                celsuis();
                farenheit.parse(celsuis);
            } else {
                kelvin();
                farenheit.parse(kelvin);
            }
            textView.setText(String.valueOf(farenheit.getValor() + " " + farenheit.getUnidad()));


        } else if (view.getId() == R.id.ButtonCelsuis) {
            if (grado.getUnidad()=="F"){
                farenheit();
                celsuis.parse(farenheit);
            }else {
                kelvin();
                celsuis.parse(kelvin);
            }
            textView.setText(String.valueOf(celsuis.getValor() + " " + celsuis.getUnidad()));
        } else if (view.getId() == R.id.ButtonKelvin) {
            if (grado.getUnidad()=="C"){
                celsuis();
                kelvin.parse(celsuis);
            }else {
                farenheit();
                kelvin.parse(farenheit);
            }
            textView.setText(String.valueOf(kelvin.getValor()+kelvin.getUnidad()));


        } else if (view.getId() == R.id.RadionButtonCelsuis) {
            Button  Button = (Button) findViewById(R.id.ButtonCelsuis);
            Button.setVisibility(View.GONE);
            Button = findViewById(R.id.ButtonFarenheit);
            Button.setVisibility(View.VISIBLE);
            Button = findViewById(R.id.ButtonKelvin);
            Button.setVisibility(View.VISIBLE);
            grado.setUnidad("C");



        } else if (view.getId() == R.id.RadionButtonKelvin) {
            Button  Button = (Button) findViewById(R.id.ButtonKelvin);
            Button.setVisibility(View.GONE);
            Button = findViewById(R.id.ButtonCelsuis);
            Button.setVisibility(View.VISIBLE);
            Button = findViewById(R.id.ButtonFarenheit);
            Button.setVisibility(View.VISIBLE);
            grado.setUnidad("K");

        } else if (view.getId() == R.id.RadionButtonFarenheit) {
            Button  Button = (Button) findViewById(R.id.ButtonFarenheit);
            Button.setVisibility(View.GONE);
            Button = findViewById(R.id.ButtonCelsuis);
            Button.setVisibility(View.VISIBLE);
            Button = findViewById(R.id.ButtonKelvin);
            Button.setVisibility(View.VISIBLE);
            grado.setUnidad("F");

        }
    }
    public void farenheit(){
        double valor =Double.parseDouble(String.valueOf(editText.getText()));
        farenheit.setValor(valor);
    }
    public void kelvin(){
        double valor =Double.parseDouble(String.valueOf(editText.getText()));
        kelvin.setValor(valor);
    }

    public void celsuis(){
        double valor =Double.parseDouble(String.valueOf(editText.getText()));
        celsuis.setValor(valor);
    }
}