/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mx.uach.compiladores.analizadorlexico.Token;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dani
 */
public class AnalizadorLexicoTest {
    /*
     @Test(expected = Exception.class)
     public void FileNotFoundTest() throws IOException {

     //        Lexer lex = new Lexer();
     //      lex.analizar("caca");
     }

     /**
     * Prueba que verifica que el nombre del archivo este correctamente escrito
     * asÃ­ como que exista y este no este vacio.
     *
     * @throws IOException cuando no existe el archivo con el nombre dado
     */
    /*
     @Test
     public void FileFoundTest() throws IOException {
     Lexer scanner = null;
     java.io.FileInputStream stream = new java.io.FileInputStream("FileToInspect");
     java.io.Reader reader = new java.io.InputStreamReader(stream, "UTF-8");
     scanner = new Lexer(reader);
     }

     @Test
     public void test() throws IOException {
        
    
     }
     /*
     List<Token> listaTokens = new ArrayList<>();
     public List<Token> analizar(String archivo){
     FileReader in = null;
     try{
     in = new FileReader(archivo);
     Lexer lex = new Lexer(in);
     while(!lex.zzAtEOF){
     lex.yylex();
     }
     }catch(Exception ex){
     System.out.println("no work");
     }finally{
     try{
     in.close();
     }catch(Exception ex){
     System.out.println("no close");
     }
     }
     return listaTokens;
     }
    
     /**
     * Prueba que verifica si se puede compilar una expresion valida dentro de
     * un archivo
     *
     * @throws IOException cuando el archivo no es encontrado
     */

    @Test
    public void procesarExpresion() throws IOException {

        Lexer scanner = null;
        File file = new File("FileToInspect");
        FileOutputStream fooStream = new FileOutputStream(file, false); // true to append
        byte[] myBytes;
        myBytes = "aZubia".getBytes();
        fooStream.write(myBytes);
        fooStream.close();
        String toEval = "aZubia";

        java.io.FileInputStream stream = new java.io.FileInputStream("FileToInspect");
        java.io.Reader reader = new java.io.InputStreamReader(stream, "UTF-8");
        scanner = new Lexer(reader);
        while (!scanner.tempEOF) {
            scanner.yylex();
            System.out.println("scanner.yytext() = " + scanner.yytext());
        }

        System.out.println("ESTE ES EL SEGUNDO PERRA!!!");
        System.out.println(scanner.yytext() + "gf");
        System.out.println("-------");
        //assertTrue(("Tokens = [1 --- Atomo --- aZubia]").equals(scanner.yytext()));

    }
//
//    /**
//     * Prueba que verifica que las llaves "()" y "{]" tengan su cierre al abrir.
//     *
//     */
//    @Test
//    public void testCerraduraDerecha() {
//        CompiladorSoloPaso analizador = new CompiladorSoloPaso();
//        String codigo = "<Variable1>::={(<Variable3>)}&{(<Variable2>)};";
//        analizador.getTokenizer(codigo.trim()).hasMoreTokens();
//        analizador.parser();
//    }
//
//    /**
//     * Prueba que verifica el error de dejar una llave sin su par, mientras se
//     * extrae el codigo de un archivo.
//     *
//     * @throws IOException cuando no encuentra el archivo a leer
//     */
//    @Test(expected = Error.class)
//    public void testCerraduraDerechaError() throws IOException {
//        CompiladorSoloPaso analizador = new CompiladorSoloPaso();
//        String codigo = readFile("FileToInspect");
//        analizador.getTokenizer(codigo.trim()).hasMoreTokens();
//        analizador.parser();
//    }
//
//    /**
//     * Prueba que verifica que las llaves "()" y "{]" tengan una apertura antes
//     * de cerrarlo del lado derecho.
//     *
//     */
//    @Test
//    public void testCerraduraIzquierda() {
//        CompiladorSoloPaso analizador = new CompiladorSoloPaso();
//        String codigo = "<Variable1>::={(<Variable3>)}&{(<Variable2>)};";
//        analizador.getTokenizer(codigo.trim()).hasMoreTokens();
//        analizador.parser();
//    }
//
//    /**
//     * Prueba que verifica el error de dejar una llave sin abrir pero cerrandola
//     * mas adelante en la expresiÃ³n.
//     *
//     */
//    @Test(expected = Error.class)
//    public void testCerraduraIzquierdaError() {
//        CompiladorSoloPaso analizador = new CompiladorSoloPaso();
//        String codigo = "<Variable1>::=<Variable3>)}&{(<Variable2>)};";
//        analizador.getTokenizer(codigo.trim()).hasMoreTokens();
//        analizador.parser();
//    }
//
//    /**
//     * Prueba que verifica los inicios y cierres de variable entre el diamante
//     * (<>).
//     *
//     */
//    @Test
//    public void testInicioFinVariable() {
//        CompiladorSoloPaso analizador = new CompiladorSoloPaso();
//        String codigo = "<Entero>::=<Variable>;";
//        analizador.getTokenizer(codigo.trim()).hasMoreTokens();
//        analizador.parser();
//    }
//
//    /**
//     * Prueba que verifica el fallo de los inicios de variable entre el diamante
//     * (<>).
//     *
//     */
//    @Test(expected = Error.class)
//    public void testInicioFinVariableError() {
//        CompiladorSoloPaso analizador = new CompiladorSoloPaso();
//        String codigo = "<Entero>::=<Variable;";
//        analizador.getTokenizer(codigo.trim()).hasMoreTokens();
//        analizador.parser();
//    }
//
//    /**
//     * Prueba que verifica que despues de la apertura de la variable esta
//     * comienze con una letra sin importar lo siguiente a esa letra.
//     *
//     */
//    @Test
//    public void testVariableEmpiezaLetra() {
//        CompiladorSoloPaso analizador = new CompiladorSoloPaso();
//        String codigo = "<Entero>::=<Variable>;";
//        analizador.getTokenizer(codigo.trim()).hasMoreTokens();
//        analizador.parser();
//    }
//
//    /**
//     * Prueba que verifica que el fallo de poner un digito despues de la
//     * apertura de una variable.
//     * 
//     */
//    @Test(expected = Error.class)
//    public void testVariableEmpiezaLetraError() {
//        CompiladorSoloPaso analizador = new CompiladorSoloPaso();
//        String codigo = "<Entero>::=<5ariable;";
//        analizador.getTokenizer(codigo.trim()).hasMoreTokens();
//        analizador.parser();
//    }
//
//    /**
//     * Prueba que verifica que el simbolo de asignaciÃ³n (::=) este correctamente
//     * escrito asÃ­ como que este se encuentre despues de una variable.
//     *
//     */
//    @Test
//    public void testAsignacion() {
//        CompiladorSoloPaso analizador = new CompiladorSoloPaso();
//        String codigo = "<Entero>::={{['+'|'-']&<Variable>}};";
//        analizador.getTokenizer(codigo.trim()).hasMoreTokens();
//        analizador.parser();
//    }
//
//    /**
//     * Prueba que verifica si el token de asignacion es mal utilizado.
//     * 
//     */
//    @Test(expected = Error.class)
//    public void testAsignacionError() {
//        CompiladorSoloPaso analizador = new CompiladorSoloPaso();
//        String codigo = "<Entero>:={{['+'|'-']&<Variable>}};";
//        analizador.getTokenizer(codigo.trim()).hasMoreTokens();
//        analizador.parser();
//    }
//
//    /**
//     * Prueba que verifica que el token de concatenacion sea utilizado de manera
//     * adecuada.
//     * 
//     */
//    @Test
//    public void testConcatenacion() {
//        CompiladorSoloPaso analizador = new CompiladorSoloPaso();
//        String codigo = "<Entero>::={{<Variable1>&<Variable>&<Variable33>}};";
//        analizador.getTokenizer(codigo.trim()).hasMoreTokens();
//        analizador.parser();
//    }
//
//    /**
//     * Prueba que verifica que cuando el token de concatenacion sea utilizado de
//     * manera erronea, mande un error.
//     * 
//     */
//    @Test(expected = Error.class)
//    public void testConcatenacionError() {
//        CompiladorSoloPaso analizador = new CompiladorSoloPaso();
//        String codigo = "<Entero>::={{<Variable1><Variable>&<Variable33>}};";
//        analizador.getTokenizer(codigo.trim()).hasMoreTokens();
//        analizador.parser();
//    }
//
//    /**
//     * Prueba que verifica si se esta utilizando de manera correcta el token de
//     * alternacion.
//     * 
//     */
//    @Test
//    public void testAlternacion() {
//        CompiladorSoloPaso analizador = new CompiladorSoloPaso();
//        String codigo = "<Entero>::={{['+'|'-']&<Variable>}};";
//        analizador.getTokenizer(codigo.trim()).hasMoreTokens();
//        analizador.parser();
//    }
//
//    /**
//     * Prueba que verifica si el token de alternacion es utilizado de manera
//     * incorrecta y manda un error en caso de que sea el caso.
//     * 
//     */
//    @Test(expected = Error.class)
//    public void testAlternacionError() {
//        CompiladorSoloPaso analizador = new CompiladorSoloPaso();
//        String codigo = "<Entero>::={{['+''-']&<Variable>}};";
//        analizador.getTokenizer(codigo.trim()).hasMoreTokens();
//        analizador.parser();
//    }

}