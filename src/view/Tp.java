
package view;

import dao.CRUD;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juliao LB
 */
public class Tp extends JFrame implements ActionListener{
    CRUD crud = new CRUD();
    private JLabel l1,l2,l3,l4,l5;
    private JTable tb;
    private JTextField t1, t2;
    private JButton btn, btn1;
    private JComboBox cb1, cb2;
    private JScrollPane scr = new JScrollPane();
    private String Query,price,NrTP,destino,qtlugar,RoomType[]={"Onibus-Normal","Oninus-Maior",}, Qtlugar[]={"50","30",};
     private String dest[] = {"Beira-Maputo", "Beira-Nampula","Maputo-Beira", "Maputo-Nampula", "Nampula-beira","Nampula-Maputo"};
    JButton btn5;
    public Tp(){
        super("GERIR TRANSPORTE");
        Container tela = getContentPane();
        //-------------------------------------------
        
        tb = new JTable(5,5);
        tb.setBounds(10, 50, 600, 400);
        tb.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        
       
        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"ID", "NrTranspote", "Tipo","lugar", "Preco", "Status"},
                {null, null, null, null, null},
                
            },
            new String [] {
                 "ID", "NrTranspote", "Tipo","lugar", "Preceo", "Status"
            }
        ));

        scr.setViewportView(tb);
        
        l1 = new JLabel("NrTranspote");
        l1.setBounds(630, 50, 100, 20);
        t1 = new JTextField();
        t1.setBounds(630, 70, 150, 20);
        l2 = new JLabel("Destino");
        l2.setBounds(630, 90, 150, 20);
        cb1 = new JComboBox(dest);
        cb1.setBounds(630, 110, 150, 20);
        l3 = new JLabel("Qt-lugar");
        l3.setBounds(630, 130, 150, 20);
        cb2 = new JComboBox(Qtlugar);
        cb2.setBounds(630, 150, 150, 20);
        l4 = new JLabel("Preco");
        l4.setBounds(630, 170, 100, 20);
        t2 = new JTextField();
        t2.setBounds(630, 190, 150, 20);
        l5 = new JLabel("Gerir Tranporte");
        l5.setBounds(10, 10, 150, 20);
        btn = new JButton("Add Transp");
        btn.setBounds(630, 580, 150, 20);
        
        btn1 = new JButton("listar");
        btn1.setBounds(10, 580, 150, 20);
        btn.addActionListener(this);
        btn1.addActionListener(this);
        //-------------------------------------------
        
        
        tela.add(tb);tela.add(btn1);
        tela.add(l1); tela.add(l2);tela.add(l3);tela.add(l4);tela.add(l5);
        tela.add(t1); tela.add(cb1);tela.add(cb2);tela.add(t2);
        tela.add(btn);tela.add(scr);
        
        /*tela.add(l2);tela.add(l3);tela.add(l4);tela.add(l5);*/
        
        //-------------------------------------------
        setUndecorated(false);
        setLocation(300, 80);
        setLayout(null);
        setSize(820, 640);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    public static void main(String args[]){
        Tp mr = new Tp();
        mr.listRommsn();
        mr.setDefaultCloseOperation(EXIT_ON_CLOSE);
    } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        NrTP = t1.getText();
        destino = cb1.getSelectedItem().toString();
        qtlugar = cb2.getSelectedItem().toString();
        price = t2.getText();
        
        if(e.getSource() == btn){
            try {//Query para inserir Quarto(ROOM)
                if(NrTP.equals("") && destino.equals("") && price.equals("") && qtlugar.equals("")){
                Query="INSERT INTO public.transporte VALUES (nextval('transporte_id_seq'::regclass), '"+NrTP+"', '"+destino+"', '"+qtlugar+"', '"+price+"', 'disponivel');";
                crud.setData(Query, "Sucesss");
                }else{
                    JOptionPane.showMessageDialog(null, "Capos Obrigatorios");
                }
                setVisible(false);
                new Tp().setVisible(true);
                
            } catch (Exception ex) {
                Logger.getLogger(Tp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource() == btn1){//Query para listar todos Quartos(ROOM)
            ResultSet rs=crud.getData("SELECT * FROM public.transporte ;");
            DefaultTableModel model = (DefaultTableModel)tb.getModel();
            model.setRowCount(0);
            try {
                while (rs.next()) {
                    model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
                }rs.close();
                
            } catch (SQLException ex) {
               Logger.getLogger(adminHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
    
    }
    
    public void formComponentShown(ComponentEvent evt) {
           
    }
    //metodo para listar Quartos
    protected void listRommsn() {//Query para listar todos Quartos(ROOM)
            ResultSet rs=crud.getData("SELECT * FROM public.transporte;");
            DefaultTableModel model = (DefaultTableModel)tb.getModel();
            model.setRowCount(0);
            try {
                while (rs.next()) {
                    model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
                }rs.close();
                
            } catch (SQLException ex) {
                //Logger.getLogger(adminHome.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
}
