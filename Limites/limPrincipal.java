/*
 * COM220 - Programação Orientada a Objetos I
 * Trabalho Final - 28/11/2016
 * 34154 - Matheus Santos Corrêa
 * 34332 - Pedro Spina Guemureman
 * 33672 - Nixon Moreira Silva
 */
package Limites;

import Controles.ControlePrincipal;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class limPrincipal extends JFrame implements ActionListener, WindowListener {

    JPanel painelProduto, painelCliente, painelPrincipal, painelVenda, painelConsulta;
    JButton btnCliente, btnProduto, btnAtualiza, btnVenda, btnConsultaCliente, btnConsultaEstoque;
    JButton btnDezMais;
    JButton btnConsultaNota, btnConsultaFatProd, btnConsultaFaturamento;
    JButton btnConsultaPrincipal;
    JButton btnConsultaFatPeriodo;
    JButton btnConsultaLucroLiquido;
    JButton btnConsultaClientePeriodo;
    ControlePrincipal ctrPrincipal;
    
    public limPrincipal (ControlePrincipal pCtrPrincipal){
        
        super("Sistema de Gestão de Vendas");
        
        ctrPrincipal = pCtrPrincipal;
        
        //Criacao dos paineis
        painelPrincipal = new JPanel(new GridLayout(5,1));
        painelProduto = new JPanel(new FlowLayout());
        painelCliente = new JPanel(new FlowLayout());
        painelVenda = new JPanel(new FlowLayout());
        painelConsulta = new JPanel(new FlowLayout());
        
        //Criancao dos botoes
        btnProduto = new JButton("Cadastra Produto");
        btnCliente = new JButton("Cadastra Cliente");
        btnAtualiza = new JButton("Atualiza Estoque");
        btnVenda = new JButton("Vender Produto");
        btnConsultaPrincipal = new JButton("Consultas");
    
        //adicao dos ActionListener
        btnProduto.addActionListener(this);
        btnCliente.addActionListener(this);
        btnAtualiza.addActionListener(this);
        btnVenda.addActionListener(this);
		btnConsultaPrincipal.addActionListener(this);
        
        //adicao dos botoes aos paineis respectivos
        painelProduto.add(btnProduto);
        painelProduto.add(btnAtualiza);
        painelCliente.add(btnCliente);
        painelVenda.add(btnVenda);
        painelConsulta.add(btnConsultaPrincipal);
        
        //PAINEL PRINCIPAL
        painelPrincipal.add(painelProduto);
        painelPrincipal.add(painelCliente);
        painelPrincipal.add(painelVenda);
        painelPrincipal.add(painelConsulta);
        
        //Frame Principal
        this.addWindowListener (this);
        this.add(painelPrincipal);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);  
        this.setVisible(true);
    }
	
	//------------------NOVO----
    public void janelaConsultas () 
    {
        JFrame janela = new JFrame("Consultas");
        JPanel pConsulta = new JPanel(new GridLayout(9,1,0,15));
        JPanel pPrincipal = new JPanel();
        btnConsultaCliente = new JButton("Consultar Cliente");
        btnConsultaEstoque = new JButton("Consultar Estoque");
        btnConsultaNota = new JButton("Consultar Nota Fiscal");
        ////////////////////////////////////////////////////////////
        btnConsultaFatProd = new JButton("Consultar Faturamento p/ Produto");
        btnConsultaFaturamento = new JButton("Consultar Faturamento p/ Cliente");
        btnDezMais = new JButton("10 Produtos Mais Vendidos");
        btnConsultaFatPeriodo = new JButton("Consultar Faturamento p/ Período");
        btnConsultaLucroLiquido = new JButton("Consultar Lucro p/ Período");
        btnConsultaClientePeriodo = new JButton("Consultar Vendas p/ Cliente & Período");
        ////////////////////////////////////////////////////////////
        
        pConsulta.add(btnConsultaCliente);
        pConsulta.add(btnConsultaEstoque);
        pConsulta.add(btnConsultaNota);
        ////////////////////////////////////////////////////////////
        pConsulta.add(btnConsultaFatProd);
        pConsulta.add(btnConsultaFaturamento);
        pConsulta.add(btnDezMais);
        pConsulta.add(btnConsultaFatPeriodo);
        pConsulta.add(btnConsultaLucroLiquido);
        pConsulta.add(btnConsultaClientePeriodo);
        ////////////////////////////////////////////////////////////

        btnConsultaCliente.addActionListener(this);
        btnConsultaEstoque.addActionListener(this);
        btnConsultaNota.addActionListener(this);
        ////////////////////////////////////////////////////////////
        btnConsultaFatProd.addActionListener(this);
        btnConsultaFaturamento.addActionListener(this);
        btnDezMais.addActionListener(this);
        btnConsultaFatPeriodo.addActionListener (this);
        btnConsultaLucroLiquido.addActionListener (this);
        btnConsultaClientePeriodo.addActionListener (this);
        ////////////////////////////////////////////////////////////
        
        pPrincipal.add(pConsulta);
        janela.add(pPrincipal);
        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed (ActionEvent e) 
    {
        if (e.getSource().equals(btnProduto)){
            ctrPrincipal.getCtrMercadoria().cadastrarMercadoria();
        } else if (e.getSource().equals(btnCliente)){
            ctrPrincipal.getCtrCliente().cadastraCliente();
        } else if (e.getSource().equals(btnAtualiza)){
            ctrPrincipal.getCtrMercadoria().alteraQtd ();
        } else if (e.getSource().equals(btnVenda)){
            ctrPrincipal.getCtrNota().emitirNota ();
        } else if (e.getSource().equals(btnConsultaCliente)){
            ctrPrincipal.getCtrCliente().consultaCliente();
        } else if (e.getSource().equals(btnConsultaEstoque)){
            ctrPrincipal.getCtrMercadoria().consultarMercadoria();
        } else if (e.getSource().equals(btnConsultaNota)){
            ctrPrincipal.getCtrNota().buscaNota();
        } else if (e.getSource().equals(btnDezMais)) {
            ctrPrincipal.getCtrMercadoria().maisVendidas();
        } else if (e.getSource().equals(btnConsultaFatProd)) {
            ctrPrincipal.getCtrMercadoria().consultaFatProd();
        } else if (e.getSource().equals(btnConsultaFaturamento)) {
            ctrPrincipal.getCtrCliente().consultaFaturamento();
        } else if (e.getSource().equals(btnConsultaFatPeriodo)) {
            ctrPrincipal.getCtrNota().consultaFatPeriodo();
        } else if (e.getSource().equals(btnConsultaLucroLiquido)) {
            
        } else if (e.getSource().equals(btnConsultaClientePeriodo)) {
            
        } else if (e.getSource().equals(btnConsultaPrincipal)){
            janelaConsultas();
        }
    }

    @Override
    public void windowOpened (WindowEvent e)
    {
    }

    @Override
    public void windowClosing (WindowEvent e)
    {
        try {
            ctrPrincipal.finalize ();
        } catch (Throwable ex) {
            Logger.getLogger (limPrincipal.class.getName()).log (Level.SEVERE, null, ex);
        } finally {
            System.exit (0);
        }
    }

    @Override
    public void windowClosed (WindowEvent e)
    {
        
    }

    @Override
    public void windowIconified (WindowEvent e)
    {
        
    }

    @Override
    public void windowDeiconified (WindowEvent e)
    {
        
    }

    @Override
    public void windowActivated (WindowEvent e)
    {
        
    }

    @Override
    public void windowDeactivated (WindowEvent e)
    {
        
    }
}
