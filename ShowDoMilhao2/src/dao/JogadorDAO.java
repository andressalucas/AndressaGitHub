package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Jogador;

public class JogadorDAO {
    public Boolean cadastrar (Jogador jogador){
        Boolean retorno;
        String sql = "INSERT INTO jogador (login,senha,email)" + "VALUES (?,?,?)";
        //PREPARA a execução
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try{
        pst.setString(1, jogador.getLogin());
        pst.setString(2, jogador.getSenha());
        pst.setString(3, jogador.getEmail());
        
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
    public List<Jogador> listar (){
        List<Jogador> lista = new ArrayList<Jogador>();
               
        String sql = "SELECT * FROM jogador";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
 
        ResultSet res;
        try {
            res = pst.executeQuery();
            
                    while (res.next()){
                    Jogador jogadorbanco = new Jogador();
                    jogadorbanco.setLogin(res.getString("login"));
                    jogadorbanco.setSenha(res.getString("senha"));
                    jogadorbanco.setEmail(res.getString("email"));
                    lista.add(jogadorbanco);
                }
               
               
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return lista;      
} 
    public Boolean excluir (Jogador jogador){
        Boolean retorno;
        String sql = "DELETE FROM JOGADOR WHERE LOGIN = ?";
        //PREPARA a execusao
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try{
        pst.setString(1, jogador.getLogin());
        
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
       
        public Boolean atualizar (Jogador jogador){
        Boolean retorno;
        String sql = "UPDATE JOGADOR LOGIN = ?, EMAIL=?, SENHA=?" + "WHERE ID=?";
        //PREPARA a execusao
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try{
        pst.setString(1, jogador.getLogin());
        pst.setString(2, jogador.getEmail());
        pst.setString(3, jogador.getSenha());
        
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
        public Jogador consultar (Jogador jogador){
        Jogador retorno;
        retorno=null;
        String sql = "SELECT * FROM JOGADOR WHERE LOGIN =?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
 
        ResultSet res;
        try {
            res = pst.executeQuery();
            
                    if (res.next()){
                    Jogador jogadorbanco = new Jogador();
                    jogadorbanco.setId(Integer.parseInt(res.getString("id")));
                    jogadorbanco.setLogin(res.getString("login"));
                    jogadorbanco.setSenha(res.getString("senha"));
                    jogadorbanco.setEmail(res.getString("email"));
                }
               
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;  
        }
}
