/*
 * COM220 - Programação Orientada a Objetos I
 * Trabalho Final - 28/11/2016
 * 34154 - Matheus Santos Corrêa
 * 34332 - Pedro Spina Guemureman
 * 33672 - Nixon Moreira Silva
 */

package Limites;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import Controles.ControleNotaFiscal;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import entidade.NotaFiscal;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;

public class limiteNotaFiscal extends JFrame implements ActionListener {

    ControleNotaFiscal ctrNota;
    
    String cliente;
    
    int[] codigo;
    int[] qtd;
    int[] validade;
    float[] preco;
    float[] precoXqtd;
    float[] lucroXqtd;
    
    JPanel pPrincipal, pCliente, pMercadoria, pPreco, pData, pBotoes;
    JLabel lCliente, lPreco, lData;
    JTextField txtPreco, txtCPFCliente, txtData;
    
    JLabel[] lExists, lItem, lItemQtd, lPrecoUnit;
    JComboBox[] cbItem;
    JTextField[] txtCod, txtQtd, txtPrecoUnit;
    
    JPanel[] pGrupo;
    
    JButton btnConfirma, btnAtualizar;
    
    JPanel pNroNota, pResultados;
    JLabel lNroNota;
    JTextField txtNroNota;
    JButton btnBusca, btnFecha, btnCancela;
    JTextArea areaResultados;
    
    JPanel pDatas, pResultadoData;
    JTextField txtDataInicio, txtDataFim;
    JTextArea txtResultadoData;
    JLabel lDataInicio, lDataFim;
    JButton btnBuscaPorData, btnBuscaPorDataC, btnBuscaLL;
    
    public limiteNotaFiscal (ControleNotaFiscal cn, int operacao) 
    {
        super ("Nota Fiscal");
        this.ctrNota = cn;
        pPrincipal = new JPanel (new FlowLayout());
        pBotoes = new JPanel (new FlowLayout());
        
        btnFecha = new JButton ("Fechar");
        btnFecha.addActionListener (this);
        
        if (operacao == 0) {
            // Botões
            btnConfirma = new JButton ("Confirma");
            btnConfirma.addActionListener (this);
            btnAtualizar = new JButton ("Atualizar Preço");
            btnAtualizar.addActionListener (this);
            
            // Painéis
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
                String auxLabel = (i + 1) + ".  Cod.";
                lItem[i] = new JLabel (auxLabel);
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
            
            // Adição ao painel pBotoes
            pBotoes.add (btnConfirma);
            pBotoes.add (btnAtualizar);
            
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
            pPrincipal.add (pBotoes);
            
            this.setSize (650, 450);
        }
        else if (operacao == 1)
        {
            // Paineis
            pNroNota = new JPanel (new FlowLayout());
            pResultados = new JPanel (new FlowLayout());
            
            // Labels e Textos
            lNroNota = new JLabel ("Número da Nota:");
            txtNroNota = new JTextField (9);
            areaResultados = new JTextArea (15, 20);
            areaResultados.setEditable (false);
            
            // Botões
            btnBusca = new JButton ("Buscar");
            btnBusca.addActionListener (this);
            btnCancela = new JButton ("Cancelar Nota");
            btnCancela.addActionListener (this);
            
            // Adesão aos painéis
            pNroNota.add (lNroNota);
            pNroNota.add (txtNroNota);
            
            pBotoes.add (btnBusca);
            pBotoes.add (btnFecha);
            pBotoes.add (btnCancela);
            
            pResultados.add (areaResultados);
            
            pPrincipal.add (pNroNota);
            pPrincipal.add (pResultados);
            pPrincipal.add (pBotoes);
            
            this.setSize (300, 375);
        }
        else if (operacao == 2)
        {
            pDatas = new JPanel (new GridLayout (2, 2, 0, 15));
            pResultadoData = new JPanel (new FlowLayout());
            
            txtDataInicio = new JTextField (10);
            txtDataFim = new JTextField (10);
            
            txtResultadoData = new JTextArea (15, 20);
            txtResultadoData.setEditable (false);
            
            lDataInicio = new JLabel ("Início");
            lDataFim = new JLabel ("Fim");
            
            btnBuscaPorData = new JButton ("Buscar");
            btnBuscaPorData.addActionListener (this);
            
            pDatas.add (lDataInicio);
            pDatas.add (txtDataInicio);
            pDatas.add (lDataFim);
            pDatas.add (txtDataFim);
            
            pResultadoData.add (txtResultadoData);
            
            pBotoes.add (btnBuscaPorData);
            pBotoes.add (btnFecha);
            
            pPrincipal.add (pDatas);
            pPrincipal.add (pResultadoData);
            pPrincipal.add (pBotoes);
            
            this.setSize (300, 400);
        }
        else if (operacao == 3)
        {
            pDatas = new JPanel (new GridLayout(3, 3, 0, 15));
            pResultadoData = new JPanel (new BorderLayout());
            
            txtCPFCliente = new JTextField (10);
            txtDataInicio = new JTextField (10);
            txtDataFim = new JTextField (10);
            
            txtResultadoData = new JTextArea (15, 20);
            txtResultadoData.setEditable (false);
            txtResultadoData.setWrapStyleWord (true);
            txtResultadoData.setLineWrap (true);
            
            JScrollPane sp = new JScrollPane ();
            sp.setPreferredSize (new Dimension (10, 200));
            sp.setViewportView (txtResultadoData);
            
            lDataInicio = new JLabel ("Início");
            lDataFim = new JLabel ("Fim");
            lCliente = new JLabel ("CPF do Cliente:");
            
            btnBuscaPorDataC = new JButton ("Buscar");
            btnBuscaPorDataC.addActionListener (this);
            
            pDatas.add (lDataInicio);
            pDatas.add (txtDataInicio);
            
            pDatas.add (lDataFim);
            pDatas.add (txtDataFim);
            pDatas.add (lCliente);
            
            pDatas.add (txtCPFCliente);
            
            pResultadoData.add (txtResultadoData, BorderLayout.CENTER);
            pResultadoData.add (sp, BorderLayout.LINE_END);
            
            pBotoes.add (btnBuscaPorDataC);
            pBotoes.add (btnFecha);
            
            pPrincipal.add (pDatas);
            pPrincipal.add (pResultadoData);
            pPrincipal.add (pBotoes);
            
            this.setSize (300, 425);
        }
        else if (operacao == 4)
        {
            pDatas = new JPanel (new GridLayout(3, 3, 0, 15));
            pResultadoData = new JPanel (new FlowLayout());
            
            txtDataInicio = new JTextField (10);
            txtDataFim = new JTextField (10);
            
            txtResultadoData = new JTextArea (10, 20);
            txtResultadoData.setEditable (false);
            
            JScrollPane sp = new JScrollPane (txtResultadoData);
            
            lDataInicio = new JLabel ("Início");
            lDataFim = new JLabel ("Fim");
            
            btnBuscaLL = new JButton ("Buscar");
            btnBuscaLL.addActionListener (this);
            
            pDatas.add (lDataInicio);
            pDatas.add (txtDataInicio);
            pDatas.add (lDataFim);
            pDatas.add (txtDataFim);
            
            pResultadoData.add (txtResultadoData);
            pResultadoData.add (sp);
            
            pBotoes.add (btnBuscaLL);
            pBotoes.add (btnFecha);
            
            pPrincipal.add (pDatas);
            pPrincipal.add (pResultadoData);
            pPrincipal.add (pBotoes);
            
            this.setSize (300, 350);
        }
        
        
        this.add (pPrincipal);
        this.setResizable (false);
        this.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo (null);
        this.revalidate ();
        this.repaint ();
        this.setVisible (true);
    }
    
    // !----------------------------------------------! //
    // MÉTODOS DE FUNCIONAMENTO                         //
    // !----------------------------------------------! //
    
    public void emitirNota (String pCPF, String pData)
    {
        ctrNota.concluirEmissaoNota (pCPF, pData, codigo, qtd, validade, getPrecoTotal(), getLucroTotal());
        this.dispose ();
    }
    
    public void cancelarNota ()
    {
        try {
            ctrNota.cancelarNota (Integer.parseInt (txtNroNota.getText ()));
            JOptionPane.showMessageDialog (null, "Nota cancelada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null, e.getMessage ());
        }
    }
    
    public void consultarNota ()
    {
        int nroNota = Integer.parseInt (txtNroNota.getText ());
        if (!ctrNota.concluirBuscaNota (nroNota))
            JOptionPane.showMessageDialog (null, "Nota de número inexistente!");   
    }
    
    public void imprimeNota (NotaFiscal nota, int ocasiao)
    {
        String saida = ctrNota.imprimeNota (nota);
        if (ocasiao == 0)
            JOptionPane.showMessageDialog (null, saida);
        else
            areaResultados.setText (saida);
    }
    
    public void consultaFaturamentoData (String inicio, String fim)
    {
        double valorFaturamento;
        try {
            valorFaturamento = ctrNota.concluiFatPeriodo (inicio, fim);
            txtResultadoData.setText ("Faturamento: R$ " + valorFaturamento);
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null, e.getMessage ());
        }    
    }
    
    private void consultaFaturamentoDataCliente (String inicio, String fim, String cpf)
    {
        String saida;
        try {
            saida = ctrNota.concluiConsultaClientePeriodo (inicio, fim, cpf);
            txtResultadoData.setText (saida);
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null, e.getMessage ());
        }
    }
    
    public void consultaLucroLiquido (String inicio, String fim)
    {
        double valorLucro;
        try {
            valorLucro = ctrNota.concluiConsultaLucroLiquido (inicio, fim);
            txtResultadoData.setText ("Lucro: R$ " + valorLucro);
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null, e.getMessage ());
        }    
    }
    
    // !----------------------------------------------! //
    // VALIDAÇÕES                                       //
    // !----------------------------------------------! //
    
    public boolean iniciaValidacao (String pCPF, String pData)
    {
        String erro = "";
        boolean flag = true;
        if (!validaNota (pCPF, pData))
        {
            for (int i = 0; i < 10; ++i)
            {
                if (validade[i] == 1)
                    erro += "Erro com o produto " + (i+1) + ": Código inexistente\n";
                else if (validade[i] == 2)
                    erro += "Erro com o produto " + (i+1) + ": Quantidade excede aquela do estoque ou valores inválidos\n";    
                else if (validade[i] == 3)
                    erro += "Erro com o produto " + (i+1) +  ": Campo de quantidade vazio\n";
                else if (validade[i] == 4)
                    erro += "Erro com o produto " + (i+1) + ": Campo de código vazio\n";
            }
            if (!erro.isEmpty ())
                JOptionPane.showMessageDialog (null, erro);
            return false;
        }
        if (!checaTotalmenteVazio ())
        {
            flag = false;
            erro += "Erro: Não há nenhuma mercadoria posta para venda!";
        }
        else
        {
            flag = checaCamposRepetidos ();
            if (!flag)
                erro += "Erro: Campos diferentes com códigos de produtos iguais!";
        }
        if (!erro.isEmpty ())
            JOptionPane.showMessageDialog (null, erro);
        return flag;
    }
    
    public boolean validaCPFCadastrado (String pCPF)
    {
        if ((!pCPF.isEmpty ()) && (!ctrNota.validaCPF (pCPF)))
        {
            int resposta = JOptionPane.showConfirmDialog (null, "CPF não cadastrado. Realizar cadastro?");
            if (resposta == JOptionPane.YES_OPTION)
            {
               ctrNota.cadastraCPF (pCPF);
               return false;
            }
        }
        else if (pCPF.isEmpty ())
        {
            JOptionPane.showMessageDialog (null, "Campo de CPF vazio!");
            return false;
        }
        else
        {
            System.out.println (ctrNota.validaCPF (pCPF));
        }
        return ctrNota.validaCPF (pCPF);
    }
    
    public boolean validaNota (String pCPF, String pData)
    {
        codigo = new int[10];
        qtd = new int[10];
        preco = new float[10];
        precoXqtd = new float[10];
        lucroXqtd = new float[10];
        validade = new int[10];
        Boolean valido = true;
        for (int i = 0; i < 10; ++i)
        {
            validade[i] = -1;
        }
        if (!ctrNota.validaData (pData, "dd/MM/yyyy"))
        {
            JOptionPane.showMessageDialog (null, "Data inválida!");
            return false;
        }
        vetoresAtualiza ();
        for (int i = 0; i < 10; ++i)
        {
            if (validade[i] > 0)
            {
                valido = false;
                lExists[i].setText ("Erro!");
            }
            else
            {
                lExists[i].setText (ctrNota.getDesc(codigo[i]));
                txtPrecoUnit[i].setText (String.valueOf (ctrNota.getPreco (codigo[i])));
            }
        }
        txtPreco.setText (String.valueOf (getPrecoTotal()));
        return valido;
    }
    
    public boolean validaCodigo (int pCodigo) 
    {
        return ctrNota.validaCodigo (pCodigo);
    }
    
    public boolean validaQtd (int pCodigo, int pQtd)
    {
        return ctrNota.validaQtd (pCodigo, pQtd);
    }   
    
    public boolean checaCamposRepetidos ()
    {
        for (int i = 0; i < 10; ++i)
        {
            // System.out.println ("Validade [" + i + "] = " + validade[i]);
            if (validade[i] == 0)
            { 
                for (int j = i + 1; j < 10; ++j)
                {
                    if (codigo[i] != 0 && codigo[i] == codigo[j])
                        return false;
                } 
            } 
        }
        return true;
    }
    
    public boolean checaTotalmenteVazio ()
    {
        for (int i = 0; i < 10; ++i)
        {
            if (validade[i] >= 0)
                return true;
        }
        return false;
    }
    
    // !----------------------------------------------! //
    // GETTERS                                          //
    // !----------------------------------------------! //
    
    private float getPrecoTotal ()
    {
        float soma = 0;
        for (int i = 0; i < 10; ++i)
        {
            soma += precoXqtd[i];
        }
        return soma;
    }
    
    private float getLucroTotal () 
    {
        float soma = 0;
        for (int i = 0; i < 10; ++i)
        {
            soma += lucroXqtd[i];
        }
        return soma;
    }

    private void vetoresAtualiza ()
    {
        int codInteiro, qtdInteiro;
        for (int k = 0; k < 10; ++k) 
        {
            String codFieldAux = txtCod[k].getText ();
            String qtdFieldAux = txtQtd[k].getText ();
            
            if ((!codFieldAux.isEmpty ()) && (!qtdFieldAux.isEmpty ()))
            {
                codInteiro = Integer.parseInt (codFieldAux);
                qtdInteiro = Integer.parseInt (qtdFieldAux);
                if (validaCodigo (codInteiro)) 
                {
                    if (validaQtd (codInteiro, qtdInteiro))
                    {    
                        validade[k] = 0;
                        preco[k] = ctrNota.getPreco (codInteiro);
                        precoXqtd[k] = ctrNota.getPrecoQtd (codInteiro, qtdInteiro);
                        lucroXqtd[k] = ctrNota.getLucroQtd (codInteiro, qtdInteiro);
                        codigo[k] = codInteiro;
                        qtd[k] = qtdInteiro;
                    }
                    else
                    {
                        validade[k] = 2;
                        precoXqtd[k] = 0;
                    }
                }
                else
                    validade[k] = 1;
            }
            else if ((codFieldAux.isEmpty()) && (!qtdFieldAux.isEmpty ()))
            {
                validade[k] = 4;
            }
            else if ((!codFieldAux.isEmpty()) && (qtdFieldAux.isEmpty ()))
            {
                validade[k] = 3;
            }
        }
    }
    
    // !----------------------------------------------! //
    // ACTION PERFORMED                                 //
    // !----------------------------------------------! //
    
    @Override
    public void actionPerformed (ActionEvent e) 
    {
        if (e.getSource () == btnConfirma)
        {
            String pCPF = txtCPFCliente.getText ();
            String pData = txtData.getText ();
            if ((validaCPFCadastrado (pCPF)) && (iniciaValidacao (pCPF, pData)))
                emitirNota (pCPF, pData);
        }
        else if (e.getSource () == btnAtualizar)
        {
            String pCPF = txtCPFCliente.getText ();
            String pData = txtData.getText ();
            iniciaValidacao (pCPF, pData);
        }
        else if (e.getSource () == btnBusca)
        {
            consultarNota ();
        }
        else if (e.getSource () == btnBuscaPorData)
        {   
            String inicio = txtDataInicio.getText ();
            String fim = txtDataFim.getText ();
            consultaFaturamentoData (inicio, fim);
        }
        else if (e.getSource () == btnBuscaPorDataC)
        {
            String inicio = txtDataInicio.getText ();
            String fim = txtDataFim.getText ();
            String cpf = txtCPFCliente.getText ();
            consultaFaturamentoDataCliente (inicio, fim, cpf);
        }
        else if (e.getSource () == btnBuscaLL)
        {
            String inicio = txtDataInicio.getText ();
            String fim = txtDataFim.getText ();
            consultaLucroLiquido (inicio, fim);
        }
        else if (e.getSource () == btnFecha)
        {
            this.dispose ();
        }
        else if (e.getSource () == btnCancela)
        {
            cancelarNota ();
        }
    }
}
