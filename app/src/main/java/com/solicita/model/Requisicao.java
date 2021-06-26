package com.solicita.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Requisicao {

    @Expose
    @SerializedName("id") private int id;
    @Expose
    @SerializedName("data_pedido") private String data_pedido;
    @Expose
    @SerializedName("hora_pedido") private String hora_pedido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(String data_pedido) {
        this.data_pedido = data_pedido;
    }

    public String getHora_pedido() {
        return hora_pedido;
    }

    public void setHora_pedido(String hora_pedido) {
        this.hora_pedido = hora_pedido;
    }
}
