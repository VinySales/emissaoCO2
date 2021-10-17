package br.modelo;

import com.google.gson.annotations.SerializedName;

public enum Combustivel {

    @SerializedName("G")
    Gasolina("G"),

    @SerializedName("D")
    Disel("D"),

    @SerializedName("E")
    Etanol("E");

    private String name;

    Combustivel(String name) {
        this.name = name;
    }
}
