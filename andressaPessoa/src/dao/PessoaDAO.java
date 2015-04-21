package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pessoa;

public class PessoaDAO {
    public Boolean inserir (Pessoa pessoa){
        Boolean retorno;
        String sql = "INSERT INTO pessoa (nome, sexo )" + "VALUES (?,?)";
        //PREPARA a execusao
        PreparedStatement pst = Conexão.getPreparedStatement(sql);
        try{
        pst.setString(1, pessoa.getNome());
        pst.setString(2, pessoa.getSexo());
        
        pst.executeUpdate();
        retorno = true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
        
    }
    
    public List<Pessoa> listar (){
        List<Pessoa> lista = new ArrayList<Pessoa>();
        
       
        String sql = "SELECT * FROM pessoa";
        PreparedStatement pst = Conexão.getPreparedStatement(sql);
 
        ResultSet res;
        try {
            res = pst.executeQuery();
            
                     while (res.next()){
                    Pessoa pessoabd = new Pessoa();
                    pessoabd.setNome(res.getString("nome"));
                    pessoabd.setSexo(res.getString("sexo"));
                    
                    lista.add(pessoabd);
                }
               
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;      
        } public Boolean excluir (Pessoa pessoa){
        Boolean retorno;
        String sql = "DELETE FROM pessoa WHERE ID = ?";
        //PREPARA a execusao
        PreparedStatement pst = Conexão.getPreparedStatement(sql);
        try{
        pst.setInt(1, pessoa.getCodigo());
        
        pst.executeUpdate();
        retorno = true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;

    }
}
