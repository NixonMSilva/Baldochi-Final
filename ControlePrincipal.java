/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;
import Limites.*;
/**
 *
 * @author pedrosg
 */
public class ControlePrincipal {
    ControleMercadoria ctrMercadoria;
    ControleCliente ctrCliente;
    ControleNotaFiscal ctrNota;
    limPrincipal limPrinc;

    public ControlePrincipal(){
        limPrinc = new limPrincipal(this);
        ctrMercadoria = new ControleMercadoria(this);
        ctrCliente = new ControleCliente(this);
    }
    
    public ControleMercadoria getCtrMercadoria() {
        return ctrMercadoria;
    }

    public ControleCliente getCtrCliente() {
        return ctrCliente;
    }

    public ControleNotaFiscal getCtrNota() {
        return ctrNota;
    }

    public limPrincipal getLimPrincipal() {
        return limPrinc;
    }
    
}
