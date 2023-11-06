package com.example.calculadoragrados.models;

public class Kelvin extends Grado{

    public Kelvin(double valor) {
        this.setUnidad("K");
        this.setValor(valor);
    }
    public void parse(Celsuis C) {
        double valor = C.getValor() + 273.15;
        setValor(valor);  // Actualiza el valor en el objeto actual.
    }

    public void parse(Farenheit F) {
        double valor = (F.getValor() + 459.67) * 5 / 9;
        setValor(valor);  // Actualiza el valor en el objeto actual.
    }

}
