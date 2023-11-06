package com.example.calculadoragrados.models;

public class Celsuis extends Grado{

    public Celsuis(double valor) {

        this.setUnidad("C");
        this.setValor(valor);

    }

    public void parse(Farenheit F) {
        double valor = (F.getValor() - 32) * 5 / 9;
        setValor(valor);
    }

    public void parse(Kelvin K) {
        double valor = K.getValor() - 273.15;
        setValor(valor);
    }


}
