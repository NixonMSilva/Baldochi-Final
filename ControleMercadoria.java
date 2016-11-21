/*
 * COM220 - Programação Orientada a Objetos I
 * Trabalho Final - 28/11/2016
 * 34154 - Matheus Santos Corrêa
 * 34332 - Pedro Spina Guemureman
 * XXXXX - Nixon Moreira Silva
 */
package Controles;

import entidade.*;
import Limites.*;

public class ControleMercadoria {

    limiteMercadoria limMercadoria;
    ControlePrincipal ctrPrincipal;

    public ControleMercadoria(ControlePrincipal pCtr) {
        ctrPrincipal = pCtr;
    }

    public void criaJanelaMercadoria() {
        new limiteMercadoria(this);
    }

    public void cadastrarMercadoria(int pCod, int pQt, String pDesc, float pPreco, float pV_venda) {
        Mercadoria m = new Mercadoria(pCod, pQt, pDesc, pPreco, pV_venda);
        m.getListaMercadoria().add(m);
    }

    public void AlterarQt(int pCod, int pQt) {
        
    }

    public void consultarMercadoria() {

    }
}
