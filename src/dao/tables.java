/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author lb
 */
public class tables {
    private static String  queryBilhete = "CREATE TABLE public.reserva(id serial NOT NULL, name varchar(200) NOT NULL, cell varchar(200) NOT NULL, nation varchar(200) NOT NULL, gender varchar(200) NOT NULL, email varchar(200) NOT NULL, idProf varchar(200), address varchar(200) not null, checkin varchar(200) NOT NULL, qtlugar varchar(200) NOT NULL, destino varchar(200) NOT NULL, nrTp varchar(200)  NOT NULL, preco INTEGER NOT NULL, tempoV integer, totalPagar varchar(200),  checkout varchar(200), lugarID serial NOT NULL);";
    private static String  Query ="CREATE TABLE users(id serial NOT NULL, name varchar(200) NOT NULL,email varchar(200) NOT NULL,password varchar(50) NOT NULL,securityQ varchar(200) NOT NULL,answerQ varchar(200) NOT NULL,address varchar(200) NOT NULL,status varchar(200) NOT NULL,gender varchar(20) NOT NULL, cell varchar(50) NOT NULL);";
    private static String  msg ="tabela criada com sucesso", msg1="Erro ao criadar tabela";
    private static String  Tranporte ="CREATE TABLE transporte(ID SERIAL NOT NULL PRIMARY KEY,nrTp varchar(20) NOT NULL,destino varchar(200) NOT NULL,qtLugar varchar(200) NOT NULL,price integer NOT NULL,status varchar(50) NOT NULL);";
    public static void main(String[] args) {
       
        Connection con = null;
        Statement stm = null;
        
        try {//pegando conexao -- getting connection
           Dao d = new  Dao();
           con = d.getConnection();
           stm = con.createStatement();
           //Query par criacao de tabelas
           stm.executeUpdate(Query);
           JOptionPane.showMessageDialog(null, msg);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }finally{
            try {
                con.close();
            } catch (Exception e) {
            }
        }
    }
    
}
