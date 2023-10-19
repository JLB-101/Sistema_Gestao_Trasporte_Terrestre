/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author JUliao lb
 */
public class homePage extends JFrame implements ActionListener  {
    //
    JButton btn1, btn2, btn3, btn4, btn5;
    
    public homePage() throws HeadlessException {
        super("HOME_PAGE");
        Container tela = getContentPane();
        tela.setBackground(Color.WHITE);
        //-------------------------------------------
        btn1 = new JButton("Gerir Trasporte");
        btn2 = new JButton("Agendar Viagem");
        btn3 = new JButton("Cancelar Vaigem");
        btn4 = new JButton("Logout");
        btn5 = new JButton("LOGOUT");
        
        
        
        //set--positions
        btn1.setBounds(1,  10, 150, 20);
        btn2.setBounds(160, 10, 180, 20);
        btn3.setBounds(350, 10, 200, 20);
        btn4.setBounds(560, 10, 220, 20);
        //btn5.setBounds(790, 10, 150, 20);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
       // btn5.addActionListener(this);
       
        
        //add--tela
        tela.add(btn1);tela.add(btn2);tela.add(btn3);tela.add(btn4);tela.add(btn5);
        //------------------------------------
        setUndecorated(true);
        setLocation(200, 18);
        setLayout(null);
        setSize(1024, 720);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
       
    }

    
    
    //botao logar
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == btn1){
              System.out.println("mr");
              setVisible(true);
             Tp mr = new Tp();
        }   
        else if (e.getSource() == btn2) {
                System.out.println("ccin");
                setVisible(true);
                new ccin();
        }else if (e.getSource() == btn3) {
                System.out.println("CCOUT");
                setVisible(true);
                new ccout();
        }else if (e.getSource() == btn4) {
                System.out.println("logout");
                setVisible(false);
                new login();
        }else if (e.getSource() == btn5) {
                System.out.println("ADMIN");
                setVisible(false);
                new adminHome();
               
        }
       
    }
    //  
   public static void main(String args[]){
        homePage hp = new homePage(); 
        hp.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }    
}
