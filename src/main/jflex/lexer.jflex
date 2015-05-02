 import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import mx.uach.compiladores.analizadorlexico.Token;
import java.util.stream.Collectors;

%%
%public
%class Lexer
%standalone

%{

    Token token = null;
    private List<Token> listaTokens = new ArrayList<>();
    private static Integer linea = 1;

    //Alfabeto
    private static final String IMPLICA = "Implica"; 
    private static final String ATOMO = "Atomo"; 
    private static final String VARIABLE = "Variable"; 
    private static final String PREDICADO = "Predicado"; 
    private static final String ENTERO = "Entero"; 
    private static final String PTO_FLOT = "Punto Flotante"; 
    private static final String CADENA = "Cadena"; 
    private static final String LISTA = "Lista"; 
    private static final String PTO_FIJO = "Punto Fijo"; 
    private static final String PARENTESIS_DER = "Parentesis Derecho"; 
    private static final String PARENTESIS_IZQ = "Parentesis Izquierdo"; 
    private static final String PUNTO = "Punto"; 
    private static final String PUNTO_COMA = "Punto y coma"; 
    private static final String COMA = "Coma";

%}

%{
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
%}

%%
            //Constructor de token(linea, token, lexema)
:-        {token = new Token(this.linea, IMPLICA, yytext()); listaTokens.add(token); System.out.println("Tokens = " + listaTokens.stream().collect(Collectors.toList()));}
";"         {token = new Token(this.linea, PUNTO_COMA, yytext()); listaTokens.add(token); System.out.println("Tokens = " + listaTokens.stream().collect(Collectors.toList())); this.linea++;}
"("         {token = new Token(this.linea, PARENTESIS_IZQ, yytext()); listaTokens.add(token); System.out.println("Tokens = " + listaTokens.stream().collect(Collectors.toList()));}
")"         {token = new Token(this.linea, PARENTESIS_DER, yytext()); listaTokens.add(token); System.out.println("Tokens = " + listaTokens.stream().collect(Collectors.toList()));}
"\."        {token = new Token(this.linea, PUNTO, yytext()); listaTokens.add(token); System.out.println("Tokens = " + listaTokens.stream().collect(Collectors.toList()));}
","         {token = new Token(this.linea, COMA, yytext()); listaTokens.add(token); System.out.println("Tokens = " + listaTokens.stream().collect(Collectors.toList()));}
[+-]?[0-9]+     {token = new Token(this.linea, ENTERO, yytext()); listaTokens.add(token); System.out.println("Tokens = " + listaTokens.stream().collect(Collectors.toList()));}

//Entero
[0-9]+     {token = new Token(this.linea, ENTERO, yytext()); listaTokens.add(token); System.out.println("Tokens = " + listaTokens.stream().collect(Collectors.toList()));}

//Punto fijo
[+-]?(\.[0-9]+|[0-9]\.[0-9]*|[0-9]\.)  {token = new Token(this.linea, PTO_FIJO, yytext()); listaTokens.add(token); System.out.println("Tokens = " + listaTokens.stream().collect(Collectors.toList()));}

//Atomo
[a-z][\w]*     {token = new Token(this.linea, ATOMO, yytext()); listaTokens.add(token); System.out.println("Tokens = " + listaTokens.stream().collect(Collectors.toList()));}
[^0-9 a-zA-Z_]+[^ ]     {token = new Token(this.linea, ATOMO, yytext()); listaTokens.add(token); System.out.println("Tokens = " + listaTokens.stream().collect(Collectors.toList()));}
"(.*?)"           {token = new Token(this.linea, ATOMO, yytext()); listaTokens.add(token); System.out.println("Tokens = " + listaTokens.stream().collect(Collectors.toList()));}


//Variable
[A-Z_][\w]*          {token = new Token(this.linea, VARIABLE, yytext()); listaTokens.add(token); System.out.println("Tokens = " + listaTokens.stream().collect(Collectors.toList()));}

//Punto Flotante
[+-]?([0-9]*?\.[0-9]+|[0-9]+)[Ee][+-]?[0-9]+  {token = new Token(this.linea, PTO_FLOT, yytext()); listaTokens.add(token); System.out.println("Tokens = " + listaTokens.stream().collect(Collectors.toList()));}





