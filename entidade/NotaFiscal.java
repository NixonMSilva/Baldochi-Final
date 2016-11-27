/*
 * COM220 - Programação Orientada a Objetos I
 * Trabalho Final - 28/11/2016
 * 34154 - Matheus Santos Corrêa
 * 34332 - Pedro Spina Guemureman
 * 33672 - Nixon Moreira Silva
 */
package entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class NotaFiscal implements Serializable {
    private ArrayList<Integer> vendas = new ArrayList<Integer>();
    private int  nroNota;
    private boolean cancelada;
    private String cpf;
    private Date data;
    
    public NotaFiscal(int nroNota, String cpf, boolean cancelada, Date data){
        this.nroNota = nroNota;
        this.cpf = cpf;
        this.cancelada = cancelada;
        this.data = data;
    }
    
    public NotaFiscal(int nroNota, String cpf, boolean cancelada, Date data, int[] codigo, int[] qtd)
    {
        this.nroNota = nroNota;
        this.cpf = cpf;
        this.cancelada = cancelada;
        this.data = data;
    }

    public ArrayList<Integer> getProdutos ()
    {
        return vendas;
    }

    public void setProdutos (ArrayList<Integer> vendas)
    {
        this.vendas = vendas;
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

    public void setCancelada() {
        this.cancelada = false;
    }
    
    public void setCorrente(){
        this.cancelada = true;
    }
    
}
