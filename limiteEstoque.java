/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Limites;
import Controles.ControleMercadoria;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Pedro
 */
public class limiteEstoque extends JFrame implements ActionListener{

    ControleMercadoria ctrMerc;
    
    JPanel painelCod, painelEstoque, painelPrincipal;
    JButton btn_Confirma, btn_procura; // botao procura = verifica codigo;
    JLabel lcod, lestoque;
    JTextField txt_cod,txt_qtd;
    
    public limiteEstoque(ControleMercadoria cm){
        super("Estoque");
        ctrMerc = cm;
        
        //criacao dos paineis
        painelPrincipal = new JPanel(new GridLayout(3,1));
        painelCod = new JPanel(new FlowLayout());
        painelEstoque = new JPanel();
    
        //painel para verificar o codigo;
        lcod = new JLabel("Codigo da mercadoria:");
        txt_cod = new JTextField(15);
        
        lestoque = new JLabel("Quantidade:");
        txt_qtd = new JTextField(15);
        txt_qtd.setEnabled(false); //so pode editar quando fica true
        txt_qtd.setOpaque(true);
        
        btn_Confirma = new JButton("Confirmar");
        btn_procura = new JButton("Procurar");
        btn_Confirma.addActionListener(this);
        btn_procura.addActionListener(this);
        
        painelCod.add(lcod);
        painelCod.add(txt_cod);
        painelCod.add(btn_procura);
        
        painelEstoque.add(lestoque);
        painelEstoque.add(txt_qtd);
        
        painelPrincipal.add(painelCod);
        painelPrincipal.add(painelEstoque);
        painelPrincipal.add(btn_Confirma);
        
        this.add(painelPrincipal);
        this.setVisible(true);
        this.setSize(350,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int status; // para verificar se achou a mercadoria ou nao
        if(e.getSource().equals(btn_procura)){
            status = ctrMerc.verificaCodigo(Integer.parseInt(txt_cod.getText()));
            if(status == 1){
                txt_qtd.setEnabled(true);
                ctrMerc.AlteraQtd(Integer.parseInt(txt_cod.getText())
                ,Integer.parseInt(txt_qtd.getText()));
                JOptionPane.showMessageDialog(null, "Estoque Atualizado!");
                this.dispose();
            }
        }
    }
    
}
