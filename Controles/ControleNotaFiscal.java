/*
 * COM220 - Programação Orientada a Objetos I
 * Trabalho Final - 28/11/2016
 * 34154 - Matheus Santos Corrêa
 * 34332 - Pedro Spina Guemureman
 * 33672 - Nixon Moreira Silva
 */

package Controles;

import Limites.*;
import entidade.NotaFiscal;
import java.util.ArrayList;

public class ControleNotaFiscal {
    private limiteNotaFiscal limNota;
    private ControlePrincipal ctrPrincipal;
    
    private ArrayList<NotaFiscal> listaNota = new ArrayList<>();
    
    NotaFiscal notaObj;
    
    public ControleNotaFiscal (ControlePrincipal cp) {
        desserializaNota ();
        ctrPrincipal = cp;
    }
    
    

    private void desserializaNota ()
    {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


