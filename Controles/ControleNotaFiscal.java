/*
 * COM220 - Programação Orientada a Objetos I
 * Trabalho Final - 28/11/2016
 * 34154 - Matheus Santos Corrêa
 * 34332 - Pedro Spina Guemureman
 * 33672 - Nixon Moreira Silva
 */

package Controles;

import Limites.*;
import entidade.*;
import java.util.ArrayList;

public class ControleNotaFiscal {
    private limiteNotaFiscal limNota;
    private ControlePrincipal ctrPrincipal;
    
    private ArrayList<NotaFiscal> listaNota = new ArrayList<>();
    
    NotaFiscal notaObj;
    
    public ControleNotaFiscal (ControlePrincipal cp) {
        // desserializaNota ();
        ctrPrincipal = cp;
    }
    
    public void emitirNota () {
        limNota = new limiteNotaFiscal (this, 0);
        
    }

    private void desserializaNota ()
    {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean validaCodigo (int pCodigo)
    {
        return ctrPrincipal.getCtrMercadoria ().validaCodigo (pCodigo);
    }
    
    public boolean validaQtd (int pCodigo, int pQtd)
    {
        return ctrPrincipal.getCtrMercadoria ().validaQtd (pCodigo, pQtd);
    }
    
    public boolean validaCPF (String pCPF)
    {
        return ctrPrincipal.getCtrCliente ().validaCPF(pCPF);
    }
    
    public float getPreco (int pCodigo)
    {
        return ctrPrincipal.getCtrMercadoria ().getPreco (pCodigo);
    }
    
    public float getPrecoQtd (int pCodigo, int pQtd)
    {
        return ctrPrincipal.getCtrMercadoria ().getPrecoQtd (pCodigo, pQtd);
    }

    public String getDec (int pCodigo)
    {
        return ctrPrincipal.getCtrMercadoria ().getDesc (pCodigo);
    }
}


