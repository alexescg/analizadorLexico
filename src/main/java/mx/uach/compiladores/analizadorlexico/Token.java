/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.uach.compiladores.analizadorlexico;

/**
 *
 * @author Alejandro Escobedo
 */
public class Token {
    
    
    private String token;
    
    private Integer linea;
    
    private String lexema;

    
    public Token(String token, Integer linea, String lexema) {
        this.token = token;
        this.linea = linea;
        this.lexema = lexema;
    }

    public Token() {
    }

    
    
    
    
    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the linea
     */
    public Integer getLinea() {
        return linea;
    }

    /**
     * @param linea the linea to set
     */
    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    /**
     * @return the lexema
     */
    public String getLexema() {
        return lexema;
    }

    /**
     * @param lexema the lexema to set
     */
    public void setLexema(String lexema) {
        this.lexema = lexema;
    }
    
}
