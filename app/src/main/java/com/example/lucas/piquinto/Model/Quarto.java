package com.example.lucas.piquinto.Model;

/**
 * Created by Lucas on 22/03/2018.
 */

public class Quarto {

    private int quartoID;
    private int quartoNum;
    private int quartoAndar;
    private int hospedeID;
    private int situacao;

    public Quarto() {
    }

    public Quarto(int quartoID, int quartoNum, int quartoAndar, int hospedeID, int situacao) {
        this.quartoID = quartoID;
        this.quartoNum = quartoNum;
        this.quartoAndar = quartoAndar;
        this.hospedeID = hospedeID;
        this.situacao = situacao;
    }

    public int getQuartoID() {
        return quartoID;
    }

    public void setQuartoID(int quartoID) {
        this.quartoID = quartoID;
    }

    public int getQuartoNum() {
        return quartoNum;
    }

    public void setQuartoNum(int quartoNum) {
        this.quartoNum = quartoNum;
    }

    public int getQuartoAndar() {
        return quartoAndar;
    }

    public void setQuartoAndar(int quartoAndar) {
        this.quartoAndar = quartoAndar;
    }

    public int getHospedeID() {
        return hospedeID;
    }

    public void setHospedeID(int hospedeID) {
        this.hospedeID = hospedeID;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
}
