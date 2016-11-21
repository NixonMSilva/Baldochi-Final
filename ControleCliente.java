/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;
import Limites.*;
import Controles.ControlePrincipal;
/**
 *
 * @author pedrosg
 */
public class ControleCliente {
    limiteCliente limCliente;
    ControlePrincipal ctrPrincipal;
    
    public ControleCliente(ControlePrincipal cp){
        ctrPrincipal = cp;
    }
    
    public void criaJanelaCliente(){
        new limiteCliente(this);
    }
}
