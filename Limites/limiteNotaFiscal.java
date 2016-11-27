/*
 * COM220 - Programação Orientada a Objetos I
 * Trabalho Final - 28/11/2016
 * 34154 - Matheus Santos Corrêa
 * 34332 - Pedro Spina Guemureman
 * XXXXX - Nixon Moreira Silva
 */
package Limites;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import Controles.ControleNotaFiscal;
import entidade.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public class limiteNotaFiscal extends JFrame implements ActionListener {

    ControleNotaFiscal ctrNota;
    
    String[] clientes;
    String[] mercadorias;
    
    JPanel pPrincipal, pCliente, pMercadoria, pPreco, pData;
    JLabel lCliente, lPreco, lData;
    JTextField txtPreco, txtCPFCliente, txtData;
    
    JLabel[] lExists, lItem, lItemQtd, lPrecoUnit;
    JComboBox[] cbItem;
    JTextField[] txtCod, txtQtd, txtPrecoUnit;
    
    JPanel[] pGrupo;
    
    JButton btnConfirma;
    
    public limiteNotaFiscal (ControleNotaFiscal cn, int operacao, ArrayList<Cliente> vc, ArrayList<Mercadoria> vm) {
        super ("Emissão de Nota Fiscal");
        this.ctrNota = cn;
        vetoresNormaliza (vc, vm);
        
        btnConfirma = new JButton ("Confirma");
        btnConfirma.addActionListener (this);
        
        if (operacao == 0) {
            // Painéis
            pPrincipal = new JPanel (new FlowLayout());
            
            pCliente = new JPanel (new FlowLayout());
            pData = new JPanel (new FlowLayout());
            pMercadoria = new JPanel (new GridLayout(10, 1));
            pGrupo = new JPanel[10];
            pPreco = new JPanel (new FlowLayout());
            
            // Labels
            lCliente = new JLabel ("CPF do Cliente:");
            lData = new JLabel ("Data da Emissão:");
            lPreco = new JLabel ("Preço Total:");
            lItem = new JLabel[10];
            lItemQtd = new JLabel[10];
            lPrecoUnit = new JLabel[10];
            lExists = new JLabel[10];
            for (int i = 0; i < 10; ++i)
            {
                lItem[i] = new JLabel ("Cod.");
                lItemQtd[i] = new JLabel ("Qtd.");
                lPrecoUnit[i] = new JLabel ("Preço Unit.");
                lExists[i] = new JLabel ("(VAZIO)");
            }
            
                
            // TextField
            txtCPFCliente = new JTextField (15);
            txtData = new JTextField (15);
            txtPreco = new JTextField (8);
            txtCod = new JTextField[10];
            txtQtd = new JTextField[10];
            txtPrecoUnit = new JTextField[10];
            for (int i = 0; i < 10; ++i)
            {
                txtCod[i] = new JTextField (10);
                txtQtd[i] = new JTextField (10);
                txtPrecoUnit[i] = new JTextField (5);
                txtPrecoUnit[i].setEditable (false);
            }
            
            // Adição ao painel pCliente
            pCliente.add (lCliente);
            pCliente.add (txtCPFCliente);
            
            // Adição ao painel pData
            pData.add (lData);
            pData.add (txtData);
            
            // Adição aos paineis sub-pMercadoria 
            
            for (int i = 0; i < 10; ++i) 
            {
                pGrupo[i] = new JPanel (new FlowLayout());
                
                pGrupo[i].add (lItem[i]);
                pGrupo[i].add (txtCod[i]);
                pGrupo[i].add (lItemQtd[i]);
                pGrupo[i].add (txtQtd[i]);
                pGrupo[i].add (lPrecoUnit[i]);
                pGrupo[i].add (txtPrecoUnit[i]);
                pGrupo[i].add (lExists[i]);  
                pMercadoria.add (pGrupo[i]);
            }
            
            // Adição ao painel pPreco
            pPreco.add (lPreco);
            pPreco.add (txtPreco);
            
            // Adição ao painel pPrincipal
            pPrincipal.add (pCliente);
            pPrincipal.add (pData);
            pPrincipal.add (pMercadoria);
            pPrincipal.add (pPreco);
            
        }
        this.add (pPrincipal);
        this.setSize (800, 400);
        // this.setResizable (false);
        this.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo (null);
        this.revalidate ();
        this.repaint ();
        this.setVisible (true);
    }
    
    
    public void emitirNota ()
    {
        
    }
    
    public void cancelarNota ()
    {
        
    }
    
    public void consultarNota(){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void vetoresNormaliza (ArrayList<Cliente> vc, ArrayList<Mercadoria> vm)
    {
        clientes = new String[vc.size ()];
        mercadorias = new String[vm.size ()];
        for (int i = 0; i < vc.size(); ++i)
        {
            Cliente c_aux = vc.get (i);
            clientes[i] = c_aux.getNome ();
        }
        for (int i = 0; i < vm.size(); ++i)
        {
            Mercadoria m_aux = vm.get (i);
            mercadorias[i] = m_aux.getDescricao ();
        }
        // testa_vetores ();
    }

    private void testa_vetores ()
    {
        System.out.println ("CLIENTES:");
        for (int i = 0; i < clientes.length; ++i)
            System.out.println (clientes[i]);
        System.out.println ("\nMERCADORIAS:");
        for (int i = 0; i < mercadorias.length; ++i)
            System.out.println (mercadorias[i]);
    }
    
    
    
}
