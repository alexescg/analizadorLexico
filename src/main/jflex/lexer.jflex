import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
%%
%public
%class Lexer
%standalone

%{
    private List<String> tokens = new ArrayList<>();
%}

%{
    public List<String> analizar(String archivo){
        FileReader in = null;
        try{
            in = new FileReader(archivo);
            Lexer lex = new Lexer(in);
            while(!lexer.zzAtEOF){
            lexer.yylex();
            }
        }catch(Exception ex){
            System.out.println("NO JALO D:");
        }finally{
            try{
                in.close();
            }catch(Exception ex){
                System.out.println("NO CERRO D:");
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



