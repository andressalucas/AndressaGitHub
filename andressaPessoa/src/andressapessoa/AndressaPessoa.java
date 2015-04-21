/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andressapessoa;
import javax.swing.JOptionPane;
import modelo.Pessoa;
/**
 *
 * @author Andressa
 */
public class AndressaPessoa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Pessoa pessoa = new Pessoa ();
        
        pessoa.setNome(JOptionPane.showInputDialog("Informe o Nome: "));
        pessoa.setCodigo(Integer.parseInt (JOptionPane.showInputDialog("Informe o Código: ")));
        pessoa.setSexo(JOptionPane.showInputDialog("Informe o Sexo: "));
        
        JOptionPane.showMessageDialog(null, "Nome: " + pessoa.getNome() + "\n Código: " + pessoa.getCodigo() + "\n Sexo: " + pessoa.getSexo());
    }
    
}
