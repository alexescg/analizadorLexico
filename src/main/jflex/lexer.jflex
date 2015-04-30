import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import mx.uach.compiladores.analizadorlexico.Token;

%%
%public
%class Lexer
%standalone

%{
    public Token currentToken;
    private List<Token> tokens = new ArrayList<>();
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
            return tokens;
    }
%}

%%

":"     {tokens.add(":"); System.out.println("DOS_PUNTOS");}
";"     {tokens.add(";"); System.out.println("PUNTO_COMA");}
">"     {tokens.add(">"); System.out.println("MAYOR_QUE");}
"<"     {tokens.add("<"); System.out.println("MENOR_QUE");}
={2}    {tokens.add("=="); System.out.println("IGUAL_QUE");}
%{2}    {tokens.add("%%"); System.out.println("DOBLE_MOD");}
[1-9]+  {tokens.add("numero"); System.out.println("NUMERO"); }
[_A-Za-z][A-Za-z]* {tokens.add("id"); System.out.println("IDENTIFICADOR");}



