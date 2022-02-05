/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizer.lex;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

import analizer.lex.Token.Tipos;

/**
 *
 * @author Juan Pedro Dominguez Padilla Piter  
 */
public class AnalizerLex {

     static DeleteComentario delComentario = new DeleteComentario();
    static contador_lineas cont_line = new contador_lineas();
   static  File fichero;
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION)
        {
             fichero = fileChooser.getSelectedFile();
           // Aquí debemos abrir el fichero para escritura
           // y salvar nuestros datos.
           
        }
        
        //Lectura de archivos txt
        //Se reconoce el texto para convertirlo en lineas de texto
        Scanner scanner = new Scanner(fichero);

        //Se crea un lista de objetos dinamica 
        ArrayList<Token> tokens;
            
        //Se coloca en un ciclo para extraer cada una de las lineas leidas
            while (scanner.hasNextLine()) {
                //Se manda a llamar la clase que se encargara de reconocer los caracteres
                    cont_line.setLine(); 
                    System.out.println(scanner.nextLine());       
                    tokens = lex(scanner.nextLine()); 

                    //Cuando termina el proceso se recorre la lista dinamica
                    for(Token token : tokens){
                        System.out.println(token.getTipos() + " " + token.getValor());
                    }
                    tokens.clear(); //Se limpia la lista
            }
            scanner.close(); //Se cierra el archivo que se ha leido
            
            
            
            
    }

    private static ArrayList<Token> lex(String entrada){
        final ArrayList<Token> tokens = new ArrayList<Token>();
        final StringTokenizer st = new StringTokenizer(entrada);
        String palabra;

        while(st.hasMoreTokens()) {
            palabra = st.nextToken();
            boolean matched = false;
            cont_line.setword();

            for (Tipos tokenTipo : Tipos.values()) {
                Pattern patron = Pattern.compile(tokenTipo.patron);
                Matcher matcher = patron.matcher(palabra);

                if(matcher.find()) {
                    Token tk = new Token();
                    tk.setTipo(tokenTipo);
                    tk.setValor(palabra);
                    tokens.add(tk);
                    matched = true;
                }
            }

            if (!matched) {
                throw new RuntimeException("Se encontró un token invalido. En la linea " + cont_line.getLine());
            }
        }
        cont_line.clear_word();

        return tokens;   
}

}
