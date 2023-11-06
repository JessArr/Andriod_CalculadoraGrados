package com.example.calculadoragrados.models;

public class Farenheit extends Grado{

    public Farenheit(double valor) {
        this.setUnidad("F");
        this.setValor(valor);
    }

    public void parse(Celsuis C) {
        double valor = (C.getValor() * 9 / 5) + 32;
        setValor(valor);  // Actualiza el valor en el objeto actual.
    }

    public void parse(Kelvin K) {
        double valor = (K.getValor() * 9 / 5) - 459.67;
        setValor(valor);  // Actualiza el valor en el objeto actual.
    }


}
