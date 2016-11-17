/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author pedrosg
 */
public class NotaFiscal {
    private ArrayList<Integer> Produtos = new ArrayList<>();
    private int  nroNota;
    private boolean cancelada;
    private String dia,mes,ano;
    
    public NotaFiscal(int pNroNota, boolean pCancelada, String pDia, String pMes, String pAno){
        nroNota = pNroNota;
        cancelada = pCancelada;
        dia = pDia;
        mes = pMes;
        ano = pAno;
    }

    public int getNroNota() {
        return nroNota;
    }

    public void setNroNota(int nroNota) {
        this.nroNota = nroNota;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    
    
}
