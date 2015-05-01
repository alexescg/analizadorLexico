/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.uach.compiladores.analizadorlexico;
/**
 * El modelo que contiene los elementos que conforman la expresion divididos en
 * los elementos que describe el alfabeto y la gramatica.
 *
 * @author Alejandro Escobedo
 * @since 01/05/2015
 * @version 1.0
 */
public class Token {

    //num linea donde esta el token
    private Integer linea;
    //valor del token / identificador
    private String token;
    //el conjunto de caracteres que va a ser identificado a traves del token 
    //por ejemplo ; (punto y coma) -- la cadena como tal
    private String lexema;

    /**
     * Constructor basico para generar los tokens
     *
     * @param linea Posicion donde se localiza el lexema(token)
     * @param token identificador numerico
     * @param lexema caracter o cadena de caracteres (valor real )
     */
    public Token(Integer linea, String token, String lexema) {
        this.linea = linea;
        this.token = token;
        this.lexema = lexema;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    /**
     * Metodo que sobreescribe el metodo toStirng y genera una caedna con los elementos del token
     * @return cadena con el formato linea - token - lexema
     */
    @Override
    public String toString() {
        return String.format("%s --- %s --- %s", 
                this.linea, this.token, this.lexema);
    }


}
