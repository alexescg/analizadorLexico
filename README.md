# AFyAL, Autómata Finito y Analizador de Léxico
Analizador de Léxico hecho JFlex y Maven

Construya un Analizador de Léxico usando la herramienta generadora JFlex y Maven, para un subconjunto del lenguaje prolog y el autómata.

ϵ = {átomo, variable, predicado, entero, pto_fijo, pto_flot, (,), implica, lista, (coma), ;(punto y coma), (punto), cadena}

Donde:
<ul>
  <li> Átomo: se define en base a 3 reglas: </li>
    <ul>
  <li> I. Secuencia de uno o más símbolos tomados del conjunto:
      <ul>
        <li>Letras</li>
        <li>Dígitos</li>
        <li>_ (Guion Bajo)</li>
        <li>Debe iniciar con letra minúscula</li>
        <li>Ejemplo: padre, padre0madre, raícesReales</li>
      </ul>
  </li>
<li>
      II. Secuencia de uno o más símbolos entre apostrofes: 
  </li>
      <ul>
        <li>Ejemplo: 'RealCompleja', '&-'</li>
      </ul>
        
</li>
<li>
      III. Secuencia de uno o más símbolos especiales: 
  </li>
      <ul>
        <li>Ejemplo: +>=, &!, --></li>
      </ul>
</li>
</ul>
  <li>Variable: Secuencia de uno o más símbolos tomados del conjunto:</li>
    <ul>
      <li>letra</li>
      <li>digito</li>
      <li>_ (Guion Bajo)</li>
      <li>Inicia con letra mayúscula o _</li>
      <li>Ejemplo: Luis, X, _1, Raiz_1</li>
    </ul>
  <li>Pto_fijo: Número real signado en notación de punto fijo: </li>
    <ul>
      <li>Ejemplo: -.5, +3.1416, 4., +1803.16 </li></ul>
  <li>Implica: Secuencia de caracteres :-</li>
  <li>Pto_flot: Número real signado en notación del punto flotante con el siguiente formato: </li>
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
  
  <li>Lista: Es una secuencia de cero o más (si es más de uno se separan por comas) símbolos entre parámetros rectangulares. Cada símbolo puede ser: 
  <ul>
  <li>Variable</li>
  <li>Átomo</li>
  <li>Predicado</li>
  <li>Numero</li>
  <li>Cadena</li>
  <li>Ejemplo: [], [hola, 23, "Alfa"], [A,b,c,(x), d]</li>
  </ul>
  </li>
  
  <li>Predicado: Tiene la estructura: átomo(argumento), donde argumento es 1 o más argumentos separados por comas.</li><ul><li>Ejemplo: -->(x,Luis), invierte([1,2,3], Lisa), concatena("Hola", "?")</li></ul>
</ul>

  
#Autómata Finito
EL diagrama para el autómata finito reside en:
http://imgur.com/XhXcXyl

Luthor, lex
