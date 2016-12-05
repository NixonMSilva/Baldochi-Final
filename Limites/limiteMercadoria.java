/*
 * COM220 - Programação Orientada a Objetos I
 * Trabalho Final - 28/11/2016
 * 34154 - Matheus Santos Corrêa
 * 34332 - Pedro Spina Guemureman
 * 33672 - Nixon Moreira Silva
 */
package Limites;

import Controles.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;

public class limiteMercadoria extends JFrame implements ActionListener 
{

    ControleMercadoria ctrMercadoria;

    JPanel pCod, pDescricao, pPreco, pVenda, pBtn, pPrincipal, pQuant, pResult, pForm;
    JTextField txt_cod, txt_descricao, txt_preco, txt_venda, txt_quant;
    JLabel lCod, lDescricao, lPreco, lVenda, lQuant;
    JButton btnCadastra, btnConsulta, btnFechar, btnAtualiza, btnConsultaFat;
    JTextArea txt_resultados;
    
    JLabel[] ranking;
    JLabel[] nome;
    JLabel[] qtd;

    public limiteMercadoria (ControleMercadoria pCtrMercadoria, int operacao) 
    {
        super("Mercadoria");
        this.ctrMercadoria = pCtrMercadoria;
        
        //botao
        btnCadastra = new JButton("Cadastrar");
        btnCadastra.addActionListener(this);
        btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(this);
        btnConsulta = new JButton("Consulta");
        btnConsulta.addActionListener(this);
        btnAtualiza = new JButton ("Atualizar");
        btnAtualiza.addActionListener(this);
        
        if (operacao == 0)
        {
            pPrincipal = new JPanel (new FlowLayout ());
            pForm = new JPanel ();
            pBtn = new JPanel ();
            
            GroupLayout layout = new GroupLayout (pForm);
            pForm.setLayout (layout);
            layout.setAutoCreateGaps (true);
            
            // Alinhamento do grupo
            GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
            
            GroupLayout.Group yLabelGroup = layout.createParallelGroup (GroupLayout.Alignment.TRAILING);
            hGroup.addGroup (yLabelGroup);
            
            GroupLayout.Group yFieldGroup = layout.createParallelGroup ();
            hGroup.addGroup (yFieldGroup);
            
            layout.setHorizontalGroup (hGroup);
            GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup ();
            layout.setVerticalGroup (vGroup);
            
            int p = GroupLayout.PREFERRED_SIZE;
            
            //Labeis
            lCod = new JLabel("Codigo:");
            lDescricao = new JLabel("Descricao:");
            lQuant = new JLabel("Quantidade:");
            lPreco = new JLabel("Preco de Compra: R$");
            lVenda = new JLabel("Preço de Venda: R$");

            //JtextField
            txt_cod = new JTextField(8);
            txt_descricao = new JTextField(20);
            txt_quant = new JTextField(8);
            txt_preco = new JTextField(8);
            txt_venda = new JTextField(8);
            txt_preco.setText ("0.00");
            txt_venda.setText ("0.00");
            
            //Adicao dos label e textField
            yLabelGroup.addComponent (lCod);
            yLabelGroup.addComponent (lDescricao);
            yLabelGroup.addComponent (lQuant);
            yLabelGroup.addComponent (lPreco);
            yLabelGroup.addComponent (lVenda);
            
            yFieldGroup.addComponent (txt_cod, p, p, p);
            yFieldGroup.addComponent (txt_descricao, p, p, p);
            yFieldGroup.addComponent (txt_quant, p, p, p);
            yFieldGroup.addComponent (txt_preco, p, p, p);
            yFieldGroup.addComponent (txt_venda, p, p, p);
            
            vGroup.addGroup (layout.createParallelGroup ().addComponent(lCod).addComponent(txt_cod, p, p, p));
            vGroup.addGroup (layout.createParallelGroup ().addComponent(lDescricao).addComponent(txt_descricao, p, p, p));
            vGroup.addGroup (layout.createParallelGroup ().addComponent(lQuant).addComponent(txt_quant, p, p, p));
            vGroup.addGroup (layout.createParallelGroup ().addComponent(lPreco).addComponent(txt_preco, p, p, p));
            vGroup.addGroup (layout.createParallelGroup ().addComponent(lVenda).addComponent(txt_venda, p, p, p));

            pBtn.add(btnCadastra);
            
            pPrincipal.add (pForm);
            pPrincipal.add (pBtn);
        }
        else if (operacao == 1)
        {
            pPrincipal = new JPanel(new FlowLayout());
            pBtn = new JPanel(new FlowLayout());
            pCod = new JPanel(new FlowLayout());
            pResult = new JPanel(new FlowLayout());
            lCod = new JLabel("Codigo:");
            txt_cod = new JTextField(15);
            txt_resultados = new JTextArea(7, 20);
            txt_resultados.setEditable (false);
            
            pBtn.add(btnConsulta);
            pBtn.add(btnFechar);
            pCod.add(lCod);
            pCod.add(txt_cod);
            pResult.add(txt_resultados);
            
            pPrincipal.add (pCod);
            pPrincipal.add (pResult);
            pPrincipal.add (pBtn);
        }
        else if (operacao == 2)
        {
            pPrincipal = new JPanel (new FlowLayout ());
            pForm = new JPanel ();
            pBtn = new JPanel ();
            
            GroupLayout layout = new GroupLayout (pForm);
            pForm.setLayout (layout);
            layout.setAutoCreateGaps (true);
            
            // Alinhamento do grupo
            GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
            
            GroupLayout.Group yLabelGroup = layout.createParallelGroup (GroupLayout.Alignment.TRAILING);
            hGroup.addGroup (yLabelGroup);
            
            GroupLayout.Group yFieldGroup = layout.createParallelGroup ();
            hGroup.addGroup (yFieldGroup);
            
            layout.setHorizontalGroup (hGroup);
            GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup ();
            layout.setVerticalGroup (vGroup);
            
            int p = GroupLayout.PREFERRED_SIZE;
            
            txt_cod = new JTextField(15);
            txt_quant = new JTextField(15);
            lCod = new JLabel ("Código:");
            lQuant = new JLabel ("Quantidade:");
            
            yLabelGroup.addComponent (lCod);
            yLabelGroup.addComponent (lQuant);
            
            yFieldGroup.addComponent (txt_cod, p, p, p);
            yFieldGroup.addComponent (txt_quant, p, p, p);
            
            vGroup.addGroup (layout.createParallelGroup ().addComponent(lCod).addComponent(txt_cod, p, p, p));
            vGroup.addGroup (layout.createParallelGroup ().addComponent(lQuant).addComponent(txt_quant, p, p, p));
                   
            
            pBtn.add (btnAtualiza);
            pBtn.add (btnFechar);
            
            pPrincipal.add (pForm);
            pPrincipal.add (pBtn);
        } 
        else if (operacao == 3) 
        {
            pPrincipal = new JPanel(new FlowLayout());
            pBtn = new JPanel(new FlowLayout());
            pCod = new JPanel(new FlowLayout());
            pResult = new JPanel(new FlowLayout());
            lCod = new JLabel("Codigo:");
            txt_cod = new JTextField(15);
            txt_resultados = new JTextArea(7, 25);
            txt_resultados.setEditable (false);
            
            btnConsultaFat = new JButton("Consultar Faturamento");
            btnConsultaFat.addActionListener(this);
            pBtn.add(btnConsultaFat);
            pBtn.add(btnFechar);
            pCod.add(lCod);
            pCod.add(txt_cod);
            pResult.add(txt_resultados);

            pPrincipal.add(pCod);
            pPrincipal.add(pResult);
            pPrincipal.add(pBtn);
        }
        
        //Fram
        this.add(pPrincipal);
        this.pack ();
        if (operacao == 2)
            this.setSize (275, 150);
        else
            this.setSize(400, 275);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable (false);
        this.setVisible(true);
    }
    
    public limiteMercadoria (ControleMercadoria pCtrMercadoria, String classDesc, String classQtde) 
    {
        super("Mercadoria");
        this.ctrMercadoria = pCtrMercadoria;
        
        String[] textos1 = classDesc.split ("\n");
        String[] textos2 = classQtde.split ("\n");
        
        int textosLenghts = (textos1.length);
        
        pBtn = new JPanel (new FlowLayout());
        pPrincipal = new JPanel (new BorderLayout ());
        pResult = new JPanel (new GridLayout (10, 3));
        
        Border padding = BorderFactory.createEmptyBorder (10, 10, 10, 10);
        pResult.setBorder (padding);

        btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(this);
        
        ranking = new JLabel[10];
        nome = new JLabel[10];
        qtd = new JLabel[10];
        
        for (int i = 0; i < 10; ++i)
        {
            ranking[i] = new JLabel ((i + 1) + ".        ", SwingConstants.RIGHT);
            if (i < textosLenghts)
            {
                nome[i] = new JLabel ((textos1[i]));
                qtd[i] = new JLabel ((textos2[i]), SwingConstants.CENTER);
            }
            else
            {
                nome[i] = new JLabel ();
                qtd[i] = new JLabel ();
            }
 
            pResult.add (ranking[i]);
            pResult.add (nome[i]);
            pResult.add (qtd[i]);
        }
        
        pBtn.add (btnFechar);
        
        pPrincipal.add (pResult, BorderLayout.CENTER);
        pPrincipal.add (pBtn, BorderLayout.PAGE_END);

        this.add (pPrincipal);
        this.pack ();
        this.setSize (300, 300);
        this.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo (null);
        this.setVisible (true);
    }
    
    public void consultarMercadoria () {
        int codigo = Integer.parseInt (txt_cod.getText ());
        String dados;
        try {
            dados = ctrMercadoria.concluiConsultaMercadoria (codigo);
            txt_resultados.setText (dados);
            this.revalidate ();
            this.repaint ();
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null, e.getMessage ());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource () == btnCadastra) {
            try {
                ctrMercadoria.concluirCadastroMercadoria(Integer.parseInt(txt_cod.getText()),
                        Integer.parseInt(txt_quant.getText()),
                        txt_descricao.getText(),
                        Float.parseFloat(txt_preco.getText()),
                        Float.parseFloat(txt_venda.getText()));
                JOptionPane.showMessageDialog(null, "Mercadoria cadastrada com sucesso!");
                this.dispose();
            } catch (NumberFormatException exc) {
                JOptionPane.showMessageDialog(this, "Um dos campo está vazio");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        else if (e.getSource() == btnConsulta) {
            consultarMercadoria();
        }
        else if (e.getSource() == btnFechar) {
            this.dispose();
        }
        else if (e.getSource() == btnAtualiza) {
            atualizarMercadoria();
        }
        else if (e.getSource() == btnConsultaFat) {
            consultaFat();
        }
    }

    private void atualizarMercadoria ()
    {
        int codigo, qtd;
        String ans;
        String codigoTxt = txt_cod.getText ();
        String quantTxt = txt_quant.getText ();
        if (codigoTxt.isEmpty () && quantTxt.isEmpty ()) {
            JOptionPane.showMessageDialog (null, "Um dos campos está vazio!");
        }
        else {
            codigo = Integer.parseInt (codigoTxt);
            qtd = Integer.parseInt (quantTxt);
            try {
                ans = ctrMercadoria.concluiAlteraQtd (codigo, qtd);
                JOptionPane.showMessageDialog (null, ans);
            } catch (Exception e) {
                JOptionPane.showMessageDialog (null, e.getMessage ());
            }
        }
    }

    private void consultaFat() 
    {
        int codigo;
        String ans;
        String codigoTxt = txt_cod.getText();
        if (codigoTxt.isEmpty()) {
            JOptionPane.showMessageDialog (null, "O campo codigo esta vazio!");
        } else {
            codigo = Integer.parseInt(codigoTxt);
            try {
                ans = ctrMercadoria.faturamentoMercadoria(codigo);
                txt_resultados.setText(ans);
                this.revalidate();
                this.repaint();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
