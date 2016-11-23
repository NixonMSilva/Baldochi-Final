/*
 * COM220 - Programação Orientada a Objetos I
 * Trabalho Final - 28/11/2016
 * 34154 - Matheus Santos Corrêa
 * 34332 - Pedro Spina Guemureman
 * XXXXX - Nixon Moreira Silva
 */
package Controles;

import entidades.*;
import Limites.*;
import java.util.ArrayList;

public class ControleMercadoria {

    private limiteMercadoria limMercadoria;
    private ControlePrincipal ctrPrincipal;
    private ArrayList<Mercadoria> listaMercadoria = new ArrayList<>();

    public ControleMercadoria(ControlePrincipal pCtr) {
        ctrPrincipal = pCtr;
    }

    public void criaJanelaMercadoria() {
        new limiteMercadoria(this);
    }

    public void cadastrarMercadoria(int pCod, int pQt, String pDesc, float pPreco, float pV_venda) {
        Mercadoria m = new Mercadoria(pCod, pQt, pDesc, pPreco, pV_venda);
        listaMercadoria.add(m);
    }

    public void criaJanelaQt() {
        new limiteEstoque(this);
    }

    public int verificaCodigo(int pCod){        
        for(Mercadoria ObjM : merc.getListaMercadoria()){           
            if( ObjM.getCod() == pCod){
                System.out.println("Encontrou");
                return 1;
            }
        }
        System.out.println("Nao encontrou");
        return 0;
    }
    
    public void AlteraQtd(int pCod, int pQtd){
        for(Mercadoria ObjM : merc.getListaMercadoria()){
            if( ObjM.getCod() == pCod){
                System.out.println("Quantide: " + ObjM.getQt_disp());
                ObjM.setQt_disp(ObjM.getQt_disp() + pQtd);  //Altero a qtde
                System.out.println("Quantide: " + ObjM.getQt_disp());
            }
        }
    }
    
    public void consultarMercadoria() {

    }
}
