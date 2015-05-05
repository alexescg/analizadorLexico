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
 *  Clase de pruebas para el analizador de Lexico
 * @since 04/05/2015
 * @version 1.0
 * @author Daniela Santillanes, Erik David Zubia Hernandez
 */
public class AnalizadorLexicoTest {
    
    /**
     * Prueba que verifica que el archivo a revisar exista con el nombre dado
     * @throws IOException cuando no encuentra el archivo con el nombre dado no
     * existe
     */
    
     @Test(expected = Exception.class)
     public void FileNotFoundTest() throws IOException {

          Lexer scanner = null;
     java.io.FileInputStream stream = new java.io.FileInputStream("Fil");
     java.io.Reader reader = new java.io.InputStreamReader(stream, "UTF-8");
     scanner = new Lexer(reader);
     }

     /**
     * Prueba que verifica que el nombre del archivo este correctamente escrito
     * así­ como que exista .
     *
     * @throws IOException cuando no existe el archivo con el nombre dado
     */
//    
     @Test
     public void FileFoundTest() throws IOException {
     Lexer scanner = null;
     java.io.FileInputStream stream = new java.io.FileInputStream("FileToInspect");
     java.io.Reader reader = new java.io.InputStreamReader(stream, "UTF-8");
     scanner = new Lexer(reader);
     }

     /**
     * Prueba que verifica si se toma en cuenta correctamente la exprecion regular
     * del atomo primera opcion
     *
     * @throws IOException cuando el archivo no es encontrado
     */

    @Test
    public void atomoVersion1() throws IOException {

        Lexer scanner = null;
        File file = new File("FileToInspect");
        FileOutputStream fooStream = new FileOutputStream(file, false); // true to append
        byte[] myBytes;
        myBytes = "aZubia".getBytes();
        fooStream.write(myBytes);
        fooStream.close();

        java.io.FileInputStream stream = new java.io.FileInputStream("FileToInspect");
        java.io.Reader reader = new java.io.InputStreamReader(stream, "UTF-8");
        scanner = new Lexer(reader);
        scanner.yylex();
        assertTrue("[1 --- Atomo --- aZubia]".equals(scanner.getListaTokens().toString()));
    }
    
    /**
     * Prueba que verifica si se toma en cuenta correctamente la exprecion regular
     * del atomo segunda opcion
     *
     * @throws IOException cuando el archivo no es encontrado
     */

    @Test
    public void atomoVersion2() throws IOException {

        Lexer scanner = null;
        File file = new File("FileToInspect");
        FileOutputStream fooStream = new FileOutputStream(file, false); // true to append
        byte[] myBytes;
        myBytes = "\'aZubia\'".getBytes();
        fooStream.write(myBytes);
        fooStream.close();

        java.io.FileInputStream stream = new java.io.FileInputStream("FileToInspect");
        java.io.Reader reader = new java.io.InputStreamReader(stream, "UTF-8");
        scanner = new Lexer(reader);
        scanner.yylex();
        assertTrue("[1 --- Atomo --- \'aZubia\']".equals(scanner.getListaTokens().toString()));
    }
    
    /**
     * Prueba que verifica si no toma completo el atomo cuando le falta una 
     * comilla
     *
     * @throws IOException cuando el archivo no es encontrado
     */
    
    @Test
    public void atomoVersion2Fail() throws IOException {

        Lexer scanner = null;
        File file = new File("FileToInspect");
        FileOutputStream fooStream = new FileOutputStream(file, false); // true to append
        byte[] myBytes;
        myBytes = "\'aZubia".getBytes();
        fooStream.write(myBytes);
        fooStream.close();

        java.io.FileInputStream stream = new java.io.FileInputStream("FileToInspect");
        java.io.Reader reader = new java.io.InputStreamReader(stream, "UTF-8");
        scanner = new Lexer(reader);
        scanner.yylex();
        assertFalse("[1 --- Atomo --- \'aZubia]".equals(scanner.getListaTokens().toString()));
    }
    
    /**
     * Prueba que verifica si se toma en cuenta correctamente la exprecion regular
     * del atomo tercera opcion
     *
     * @throws IOException cuando el archivo no es encontrado
     */

    @Test
    public void atomoVersion3() throws IOException {

        Lexer scanner = null;
        File file = new File("FileToInspect");
        FileOutputStream fooStream = new FileOutputStream(file, false); // true to append
        byte[] myBytes;
        myBytes = "-->".getBytes();
        fooStream.write(myBytes);
        fooStream.close();

        java.io.FileInputStream stream = new java.io.FileInputStream("FileToInspect");
        java.io.Reader reader = new java.io.InputStreamReader(stream, "UTF-8");
        scanner = new Lexer(reader);
        scanner.yylex();
        assertTrue("[1 --- Atomo --- -->]".equals(scanner.getListaTokens().toString()));
    }
    
    /**
     * Prueba que verifica si se toma en cuenta correctamente la exprecion regular
     * de la variable cuando inicia con una letra mayuscula
     *
     * @throws IOException cuando el archivo no es encontrado
     */

    @Test
    public void variableRegxLetraMayus() throws IOException {

        Lexer scanner = null;
        File file = new File("FileToInspect");
        FileOutputStream fooStream = new FileOutputStream(file, false); // true to append
        byte[] myBytes;
        myBytes = "Hola".getBytes();
        fooStream.write(myBytes);
        fooStream.close();

        java.io.FileInputStream stream = new java.io.FileInputStream("FileToInspect");
        java.io.Reader reader = new java.io.InputStreamReader(stream, "UTF-8");
        scanner = new Lexer(reader);
        scanner.yylex();
        assertTrue("[1 --- Variable --- Hola]".equals(scanner.getListaTokens().toString()));
    }
    
    /**
     * Prueba que verifica el fallo de la exprecion regular cuando se tienen 
     * caracteres que no sean digitos o letras despues de la letra mayuscula
     *
     * @throws IOException cuando el archivo no es encontrado
     */

    @Test
    public void variableRegxLetraMayusFail() throws IOException {

        Lexer scanner = null;
        File file = new File("FileToInspect");
        FileOutputStream fooStream = new FileOutputStream(file, false); // true to append
        byte[] myBytes;
        myBytes = "H+la".getBytes();
        fooStream.write(myBytes);
        fooStream.close();

        java.io.FileInputStream stream = new java.io.FileInputStream("FileToInspect");
        java.io.Reader reader = new java.io.InputStreamReader(stream, "UTF-8");
        scanner = new Lexer(reader);
        scanner.yylex();
        assertFalse("[1 --- Variable --- H+la]".equals(scanner.getListaTokens().toString()));
    }
    
    /**
     * Prueba que verifica si se toma en cuenta correctamente la exprecion regular
     * de la variable cuando inicia con un guion
     *
     * @throws IOException cuando el archivo no es encontrado
     */

    @Test
    public void variableRegxGuion() throws IOException {

        Lexer scanner = null;
        File file = new File("FileToInspect");
        FileOutputStream fooStream = new FileOutputStream(file, false); // true to append
        byte[] myBytes;
        myBytes = "_Hola".getBytes();
        fooStream.write(myBytes);
        fooStream.close();

        java.io.FileInputStream stream = new java.io.FileInputStream("FileToInspect");
        java.io.Reader reader = new java.io.InputStreamReader(stream, "UTF-8");
        scanner = new Lexer(reader);
        scanner.yylex();
        assertTrue("[1 --- Variable --- _Hola]".equals(scanner.getListaTokens().toString()));
    }
    
    /**
     * Prueba que verifica el fallo de la exprecion regular cuando se tienen 
     * caracteres que no sean digitos o letras despues del guion
     *
     * @throws IOException cuando el archivo no es encontrado
     */

    @Test
    public void variableRegxGuionFail() throws IOException {

        Lexer scanner = null;
        File file = new File("FileToInspect");
        FileOutputStream fooStream = new FileOutputStream(file, false); // true to append
        byte[] myBytes;
        myBytes = "_H+la".getBytes();
        fooStream.write(myBytes);
        fooStream.close();

        java.io.FileInputStream stream = new java.io.FileInputStream("FileToInspect");
        java.io.Reader reader = new java.io.InputStreamReader(stream, "UTF-8");
        scanner = new Lexer(reader);
        scanner.yylex();
        assertFalse("[1 --- Variable --- _H+la]".equals(scanner.getListaTokens().toString()));
    }

}