# AFyAL, Automata Finito y Analizador de Lexico
Analizador de Lexico hecho JFlex y Maven

Construya un Analizador de Lexico usando la herramienta generadora JFlex y Maven, para un subconjunto del lenguaje prolog y el automata.

ϵ = {atomo, variable, predicado, entero, pto_fijo, pto_flot, (, ), implica, lista, ,(coma) , ;(punto y coma), .(punto), cadena}

donde:
<ul>
  <li> Atomo: se define en base a 3 reglas: </li>
    <ul>
  <li> I. Secuencia de uno o mas simbolos tomados del conjunto:
      <ul>
        <li>Letras</li>
        <li>Digitos</li>
        <li>_ (Guion Bajo)</li>
        <li>Debe iniciar con letra minuscula</li>
        <li>Ejemplo: padre, padre0madre, raicesReales</li>
      </ul>
  </li>
<li>
      II. Secuencia de uno o mas simbolos entre apostrofes: 
  </li>
      <ul>
        <li>Ejemplo: 'RealCompleja', '&-'</li>
      </ul>
        
</li>
<li>
      III. Secuencia de uno o mas simbolos especiales: 
  </li>
      <ul>
        <li>Ejemplo: +>=, &!, --></li>
      </ul>
</li>
</ul>
  <li>Variable: Secuencia de uno o mas simbolos tomados del conjunto:</li>
    <ul>
      <li>letra</li>
      <li>digito</li>
      <li>_ (Guion Bajo)</li>
      <li>Inicia con letra mayuscula o _</li>
      <li>Ejemplo: Luis, X, _1, Raiz_1</li>
    </ul>
  <li>Pto_fijo: Numero real signado en notacion de punto fijo: </li>
    <ul>
      <li>Ejemplo: -.5, +3.1416, 4., +1803.16 </li></ul>
  <li>Implica: Secuencia de caracteres :-</li>
  <li>Pto_flot: Numero real signado en notacion del punto flotante con el siguiente formato: </li>
    <ul>
      <li>Monto(entero o pto_fijo)</li>
      <li>Base(E o e)</li>
      <li>Exponente(entero)</li>
      <li>Ejemplo: 4E5, 4.6e3, 4.5e2, 4E-5</li>
    </ul>
  <li>Cadena: Cualquier secuencia de caracteres entre comillas</li>
    <ul>
      <li>Ejemplo: "", "Hola", "alex es el mejor :D"</li>
    </ul>
  <li>Entero: Numero entero signado: </li>
  <ul><li>Ejemplo: 5, +5, -500</li></ul>
  
  <li>Lista: Es una secuencia de cero o mas (si es mas de uno se separan por comas) simbolos entre parametros rectangulares. Cada simbolo puede ser: 
  <ul>
  <li>Variable</li>
  <li>Atomo</li>
  <li>Predicado</li>
  <li>Numero</li>
  <li>Cadena</li>
  <li>Ejemplo: [], [hola, 23, "Alfa"], [A,b,c,(x), d]</li>
  </ul>
  </li>
  
  <li>Predicado: Tiene la estructura: atomo(argumento), donde argumento es 1 o mas argumentos separados por comas.</li><ul><li>Ejemplo: -->(x,Luis), invierte([1,2,3], Lisa), concatena("Hola", "?")</li></ul>
</ul>

  
#Automata Finito
EL diagrama para el automata finito reside en:


Luthor, lex

