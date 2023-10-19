/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CRUD;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author JUliao lb
 */
public class login extends JFrame implements ActionListener {
    //variaveis
    String msgF= "pt: Todos campos sao requeridos";
    boolean statusLogin;
    CRUD  crud = new CRUD();
    private String nome,senha,msg;
    //declarar botoes
    JLabel rotulo1,rotulo2, rt;
    JTextField t1;
    JPasswordField t2;
    JButton btn, btn1, btn2, btA;
  
    public login() throws HeadlessException {
        
        super("Exemplo com Label");
        Container tela = getContentPane();
        tela.setBackground(Color.WHITE);
        //-------------------------------------------
        rt = new JLabel("----------------------------------*----------------------------------Bem Vindo Ao Sistema transporte NAGI----------------------------------*----------------------------------");
        rt.setBounds(10,10,840,40);
        rotulo1 = new JLabel ("Email");
        t1 = new JTextField();
        rotulo2 = new JLabel("Senha");
        t2 = new JPasswordField();
        btn = new JButton("login");
        btn.setBackground(Color.WHITE);
        btn1 = new JButton("Cadastro");
        btn2 = new JButton("Esqueci senha");
       
        btn.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        //-------------------------------------
        
        rotulo1.setBounds(50,80,200,40);
        t1.setBounds(120, 80, 400, 40);
        rotulo2.setBounds(50, 120, 200, 40);
        t2.setBounds(120, 120, 400, 40);
        btn.setBounds(50, 400, 100, 40);
        btn1.setBounds(120, 400, 100, 40);
        btn2.setBounds(200, 400,320, 40);
        //-------------------------------------

        tela.add(rotulo1);tela.add(t1);tela.add(rt);
        tela.add(rotulo2);tela.add(t2);
        tela.add(btn);tela.add(btn1);tela.add(btn2);
       
        Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension tamanhoTela = kit.getScreenSize();
		
	setLocation(500, 250);
        setLayout(null);
        setSize(840, 480);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
       
    }
    
    //botao logar
    public void actionPerformed (ActionEvent e){
        nome = t1.getText();
        senha = t2.getText();
        System.out.println("senha("+senha+")");
        
        //botao login
        if(e.getSource() == btn){
            if(nome.equals("") && senha.equals("")){
                System.out.println(msgF);
                JOptionPane.showMessageDialog(null, msgF); 
            } else if(nome.equalsIgnoreCase("Admin") && senha.equalsIgnoreCase("Admin")){
                setVisible(false);
                new adminHome().setVisible(true);
            }
            
            else if(nome.equalsIgnoreCase("Admin") && senha.equalsIgnoreCase("1234")){//admin
                JOptionPane.showMessageDialog(null, msg ="sucesso!!!");
                setVisible(false);
                new homePage().setVisible(true);
                
            }
            //atendente
            else if(nome != "" && senha != ""){
                //passando argumntos do cadastro para Query
                String Query ="SELECT id, name, password, status FROM public.users WHERE name='"+nome+"'and password='"+senha+"';";
                try {
                    if(crud.login(Query, "PQ")){
                        setVisible(false);
                        new homePage().setVisible(true);
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Aguarde A Permisao do:\n"
                                + "---- ADMINISTRADOR------");
                        setVisible(false);
                        new login().setVisible(true);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }  
            } 
          
        }
        //botao 
        else if (e.getSource() == btn1) {
            setVisible(false);
           new Signup();
        }
        //botao 
        else if (e.getSource() == btn2) {//botao 
            System.out.println(msg ="Esqueci-Senha--sso!!!");
            setVisible(false);
          new ForgotPass();
        }
       //end actionPerformed
    }
   
    public static void main(String args[]){
        login app = new login();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }   
}
