/*
 * COM220 - Programação Orientada a Objetos I
 * Trabalho Final - 28/11/2016
 * 34154 - Matheus Santos Corrêa
 * 34332 - Pedro Spina Guemureman
 * 33672 - Nixon Moreira Silva
 */
package Limites;

import Controles.ControleCliente;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class limiteCliente extends JFrame implements ActionListener
{
    ControleCliente ctrCliente;
    // Elementos - Cadastro
    JPanel painelNome, painelEndereco, painelEmail, painelCPF,pBtn, pPrincipal;
    JPanel pForm;
    JTextField txt_nome, txt_endereco, txt_email, txt_cpf;
    JLabel lNome, lEndereco, lEmail, lCpf;
    JButton btnCadastra;
            
    // Elementos - Consulta
    JPanel painelTexto;
    JTextArea txt_resultados;
    JButton btnConsulta, btnFechar;
	
	//////////////////////////////////
    //Elementos - Consulta Faturamento
    JPanel painelTexto1;
    JTextArea txt_resultados_faturamento;
    JButton btnConsultaFaturamento, btnFecharFaturamento;
    //////////////////////////////////
    
    public limiteCliente(ControleCliente controle, int operacao, String pCpf){
        super("Cliente");
        this.ctrCliente = controle;
        
        // Botões
        btnCadastra = new JButton ("Cadastra");
        btnCadastra.addActionListener (this);
        btnConsulta = new JButton ("Consulta");
        btnConsulta.addActionListener (this);
        btnFechar = new JButton ("Fechar");
        btnFechar.addActionListener (this);
        btnConsultaFaturamento = new JButton ("Consultar Faturamento");
        btnConsultaFaturamento.addActionListener (this);
        
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
            lNome = new JLabel("Nome:");
            lEndereco = new JLabel("Endereco");
            lEmail = new JLabel("E-mail:");
            lCpf = new JLabel("CPF:");

            //JtextField
            txt_nome = new JTextField(15);
            txt_endereco = new JTextField(15);
            txt_email = new JTextField(15);
            txt_cpf = new JTextField(15);
            txt_cpf.setText (pCpf);
            
            //Adicao dos label e textField
            yLabelGroup.addComponent (lNome);
            yLabelGroup.addComponent (lEmail);
            yLabelGroup.addComponent (lCpf);
            yLabelGroup.addComponent (lEndereco);
            
            yFieldGroup.addComponent (txt_nome, p, p, p);
            yFieldGroup.addComponent (txt_email, p, p, p);
            yFieldGroup.addComponent (txt_cpf, p, p, p);
            yFieldGroup.addComponent (txt_endereco, p, p, p);
            
            vGroup.addGroup (layout.createParallelGroup ().addComponent(lNome).addComponent(txt_nome, p, p, p));
            vGroup.addGroup (layout.createParallelGroup ().addComponent(lEmail).addComponent(txt_email, p, p, p));
            vGroup.addGroup (layout.createParallelGroup ().addComponent(lCpf).addComponent(txt_cpf, p, p, p));
            vGroup.addGroup (layout.createParallelGroup ().addComponent(lEndereco).addComponent(txt_endereco, p, p, p));

            pBtn.add (btnCadastra);

            pPrincipal.add (pForm);
            pPrincipal.add (pBtn);
        }
        else if (operacao == 1)
        {
            pPrincipal = new JPanel(new FlowLayout());
            painelCPF = new JPanel(new FlowLayout());
            painelTexto = new JPanel(new FlowLayout());
            pBtn = new JPanel ();

            //Labeis
            lCpf = new JLabel("CPF:");

            // Campo de Texto
            txt_cpf = new JTextField (15);

            // Área de Texto
            txt_resultados = new JTextArea(7, 20);
            txt_resultados.setEditable (false);

            // Adição aos Painéis
            painelCPF.add (lCpf);
            painelCPF.add (txt_cpf);
            painelTexto.add (txt_resultados);
            
            pBtn.add (btnConsulta);
            pBtn.add (btnFechar);
            
            pPrincipal.add (painelCPF);
            pPrincipal.add (painelTexto);
            pPrincipal.add (pBtn);
        }
        else if(operacao == 2) 
        {
            pPrincipal = new JPanel(new FlowLayout());
            painelCPF = new JPanel(new FlowLayout());
            painelTexto1 = new JPanel(new FlowLayout());
            pBtn = new JPanel(new FlowLayout());
            
            //Labeis
            lCpf = new JLabel("CPF:");

            // Campo de Texto
            txt_cpf = new JTextField(15);

            // Área de Texto
            txt_resultados_faturamento = new JTextArea(7, 20);
            txt_resultados_faturamento.setEditable (false);
            
            // Adição aos Painéis
            
            painelCPF.add(lCpf);
            painelCPF.add(txt_cpf);
            
            painelTexto1.add(txt_resultados_faturamento);
            
            pBtn.add(btnConsultaFaturamento);
            pBtn.add(btnFechar);
            pPrincipal.add(painelCPF);
            pPrincipal.add(painelTexto1);
            pPrincipal.add(pBtn);
        }
        //////////////////////////////////
        //Frame
        this.add(pPrincipal);
        this.setSize(290,270);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable (false);
        this.revalidate ();
        this.repaint ();
        this.setVisible(true);
    }

    public void cadastrarCliente() 
    {
        try {
             ctrCliente.concluiCadastroCliente(txt_nome.getText(),txt_email.getText(),txt_cpf.getText(),
                    txt_endereco.getText());
            JOptionPane.showMessageDialog (null,"Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null, e.getMessage ());
        }
        this.dispose();
    }
    
    public void consultarCliente(){
        String dados;
        try {
            dados = ctrCliente.concluiConsultaCliente (txt_cpf.getText ());
            txt_resultados.setText (dados);
            this.revalidate ();
            this.repaint ();
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null, e.getMessage ());
        }
        
    }
    
    public void consultarFaturamento() {
        String dados;
        try {
            dados = ctrCliente.concluiConsultaFaturamento(txt_cpf.getText());
            txt_resultados_faturamento.setText(dados);
            this.revalidate();
            this.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCadastra)
        {
            cadastrarCliente ();
        }
        else if (e.getSource () == btnConsulta)
            consultarCliente ();
        else if (e.getSource() == btnConsultaFaturamento) {
            consultarFaturamento();
        }
        else if (e.getSource () == btnFechar)
            this.dispose();
    }
    
}
