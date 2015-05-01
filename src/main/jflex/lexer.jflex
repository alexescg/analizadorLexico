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
    private static final String IMPLICA = "Implica"; 

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
":-"     {token = new Token(this.linea, IMPLICA, yytext()); listaTokens.add(token); System.out.println("Tokens = " + listaTokens.stream().collect(Collectors.toList()));}
