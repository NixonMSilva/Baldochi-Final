/*
 * COM220 - Programação Orientada a Objetos I
 * Trabalho Final - 28/11/2016
 * 34154 - Matheus Santos Corrêa
 * 34332 - Pedro Spina Guemureman
 * 33672 - Nixon Moreira Silva
 */
package Controles;

import Limites.*;
import entidade.Cliente;
import java.util.ArrayList;

public class ControleCliente {
    
    private limiteCliente limCliente;
    private ControlePrincipal ctrPrincipal;
    private ArrayList<Cliente> listaCliente;
    
    public ControleCliente(ControlePrincipal cp){
        ctrPrincipal = cp;
    }
    
    public void cadastraCliente (){
        limCliente = new limiteCliente (this);
        limCliente.cadastrarCliente ();
    }
    
    public void concluiCadastroCliente (String nome, String email, String cpf, String endereco){
        Cliente clienteObj = new Cliente (nome, email, cpf, endereco);
        listaCliente.add (clienteObj);
    }
    
    public void consultaCliente (){
        limCliente = new limiteCliente (this);
        limCliente.consultarCliente ();
    }
    
    public String concluiConsultaCliente (String cpf){
        for (Cliente c: listaCliente)
        {
            if (cpf.equals(c.getCpf ()))
            {
                return c.getNome () + "\n" + c.getEndereco () + "\n" +
                        c.getEmail ();
            }    
        }
        return "error";
    }
}
