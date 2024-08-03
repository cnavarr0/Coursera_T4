package com.example.appbar2.pojo;

public class Imagenes {

    private String rait;
    private int foto;


    public Imagenes(int foto, String rait) {
        this.foto = foto;
        this.rait = rait;

    }

    public String getRait() {
        return rait;
    }

    public void setRait(String rait) {
        this.rait = rait;
    }


    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

}

