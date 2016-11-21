package Limites;
import entidade.*;
import Controles.ControleCliente;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author pedrosg
 */
public class limiteCliente extends JFrame implements ActionListener{
    
    ControleCliente ctrCliente;
    
    JPanel painelNome, painelEndereco, painelEmail, painelCPF,pBtn, pPrincipal;
    JTextField txt_nome, txt_endereco, txt_email, txt_cpf;
    JLabel lNome, lEndereco, lEmail, lCpf;
    JButton btnCadastra;
    
    public limiteCliente(ControleCliente cl){
        super("Cliente");
        ctrCliente = cl;
        
        //Paineis
        pPrincipal = new JPanel(new GridLayout(5,1));
        painelNome = new JPanel();
        painelNome.setLayout(new FlowLayout());
        painelEndereco = new JPanel();
        painelEndereco.setLayout(new FlowLayout());
        painelEmail = new JPanel();
        painelEmail.setLayout(new FlowLayout());
        painelCPF = new JPanel();
        painelCPF.setLayout(new FlowLayout());
        pBtn = new JPanel();
        
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
        
        //botao
        btnCadastra = new JButton("Cadastrar");
        btnCadastra.addActionListener(this);
        pBtn.add(btnCadastra);
        
        //Adicao dos label e textField
        painelNome.add(lNome);
        painelNome.add(txt_nome);
        
        painelEmail.add(lEmail);
        painelEmail.add(txt_email);
        
        painelCPF.add(lCpf);
        painelCPF.add(txt_cpf);
        
        painelEndereco.add(lEndereco);
        painelEndereco.add(txt_endereco);
        
        pPrincipal.add(painelNome);
        pPrincipal.add(painelEmail);
        pPrincipal.add(painelCPF);
        pPrincipal.add(painelEndereco);
        pPrincipal.add(pBtn);
        
        //Frame
        this.add(pPrincipal);
        this.setSize(290,270);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);  
        this.setVisible(true);
    }
    
    public void cadastrarCliente(){
        
    }
    
    public void consultarCliente(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
