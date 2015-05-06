package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pergunta;


public class PerguntaDAO {
    public Boolean cadastrar (Pergunta pergunta){
        Boolean retorno;
        String sql = "INSERT INTO PERGUNTA (ENUNCIADO, A, B, C, D, CERTA, NIVEL)" + "VALUES (?,?,?,?,?,?,?)";
        //PREPARA a execução
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try{
        pst.setString(1, pergunta.getEnunciado());
        pst.setString(2, pergunta.getA());
        pst.setString(3, pergunta.getB());
        pst.setString(4, pergunta.getC());
        pst.setString(4, pergunta.getD());
        pst.setString(4, pergunta.getCerta());
        pst.setString(4, pergunta.getNivel());
        
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
    public List<Pergunta> listar (){
        List<Pergunta> lista = new ArrayList<Pergunta>();
               
        String sql = "SELECT * FROM PERGUNTA";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
 
        ResultSet res;
        try {
            res = pst.executeQuery();
            
                    while (res.next()){
                    Pergunta perguntabanco = new Pergunta();
                    perguntabanco.setEnunciado(res.getString("ENUNCIADO"));
                    perguntabanco.setId(Integer.parseInt(res.getString("ID")));
                    perguntabanco.setA(res.getString("A"));
                    perguntabanco.setB(res.getString("B"));
                    perguntabanco.setC(res.getString("C"));
                    perguntabanco.setD(res.getString("D"));
                    perguntabanco.setCerta(res.getString("CERTA"));
                    perguntabanco.setNivel(res.getString("NIVEL"));
                }
               
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return lista;      
} 
    public Boolean excluir (Pergunta pergunta){
        Boolean retorno;
        String sql = "DELETE FROM PERGUNTA WHERE LOGIN = ?";
        //PREPARA a execusao
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try{
        pst.setInt(1, pergunta.getId());
        
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
       
        public Boolean atualizar (Pergunta pergunta){
        Boolean retorno;
        String sql = "UPDATE PERGUNTA ENUNCIADO=?, A=?, B=?, C=?, D=?, CERTA=?, NIVEL=?" + "WHERE ID=?";
        //PREPARA a execusao
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try{
        pst.setString(1, pergunta.getEnunciado());
        pst.setString(2, pergunta.getA());
        pst.setString(3, pergunta.getB());
        pst.setString(4, pergunta.getC());
        pst.setString(4, pergunta.getD());
        pst.setString(4, pergunta.getCerta());
        pst.setString(4, pergunta.getNivel());
        
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
