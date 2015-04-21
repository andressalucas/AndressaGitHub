package andressapessoa;

import dao.Conexão;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Pessoa;

public class TesteBanco {
    public static void main(String[] args) {
        inserir();
        List<Pessoa> Lista = Listar();
        for (Pessoa pessoa : Lista) {
            System.out.println(pessoa.getNome()+ "\n");
            
        }
    }
    
    public static List<Pessoa>Listar()
    {
        List<Pessoa> jogadores = new ArrayList<Pessoa>();
        try {
        String sql= "SELECT * FROM pessoa";
        PreparedStatement pst
                = Conexão.getPreparedStatement(sql);
       
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                //pega a estrutura do resultset relaciona com a classe
               Pessoa pes = new Pessoa();
                pes.setCodigo(res.getInt("codigo"));
                pes.setNome(res.getString("nome"));
                pes.setSexo(res.getString("sexo"));
                //adiciona na lista 
                jogadores.add(pes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TesteBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jogadores;
    }
    
   
       public static void inserir()
       {
           String codigo , nome, sexo;
           codigo= JOptionPane.showInputDialog("Codigo : ");
           nome= JOptionPane.showInputDialog("Nome: ");
           sexo= JOptionPane.showInputDialog("Sexo : ");           
          String sql;
          
          sql= "INSERT INTO pessoa(nome,sexo) VALUES (? ,?)";
          PreparedStatement pst

                    = Conexão.getPreparedStatement(sql);         
        try {
            //pst.setString(1,codigo);
            pst.setString(1,nome);
            pst.setString(2,sexo);
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TesteBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       

}
