AFyAL, Autómata Finito y Analizador de Léxico
Analizador de Léxico hecho JFlex y Maven
Construya un Analizador de Léxico usando la herramienta generadora JFlex y Maven, para un subconjunto del lenguaje prolog y el autómata.
ϵ = {átomo, variable, predicado, entero, pto_fijo, pto_flot, (,), implica, lista, (coma), ;(punto y coma), (punto), cadena}
Donde:
•	Átomo: se define en base a 3 reglas: 
o	I. Secuencia de uno o más símbolos tomados del conjunto: 
	Letras
	Dígitos
	_ (Guion Bajo)
	Debe iniciar con letra minúscula
	Ejemplo: padre, padre0madre, raícesReales
o	II. Secuencia de uno o más símbolos entre apostrofes: 
	Ejemplo: 'RealCompleja', '&-'
o	III. Secuencia de uno o más símbolos especiales: 
	Ejemplo: +>=, &!, -->
•	Variable: Secuencia de uno o más símbolos tomados del conjunto:
o	letra
o	digito
o	_ (Guion Bajo)
o	Inicia con letra mayúscula o _
o	Ejemplo: Luis, X, _1, Raiz_1
•	Pto_fijo: Número real signado en notación de punto fijo: 
o	Ejemplo: -.5, +3.1416, 4., +1803.16 
•	Implica: Secuencia de caracteres :-
•	Pto_flot: Número real signado en notación del punto flotante con el siguiente formato: 
o	Monto(entero o pto_fijo)
o	Base(E o e)
o	Exponente(entero)
o	Ejemplo: 4E5, 4.6e3, 4.5e2, 4E-5
•	Cadena: Cualquier secuencia de caracteres entre comillas
o	Ejemplo: "", "Hola", "alexestameco"
•	Entero: Numero entero signado: 
o	Ejemplo: 5, +5, -500
•	Lista: Es una secuencia de cero o más (si es más de uno se separan por comas) símbolos entre parámetros rectangulares. Cada símbolo puede ser: 
o	Variable
o	Átomo
o	Predicado
o	Numero
o	Cadena
o	Ejemplo: [], [hola, 23, "Alfa"], [A,b,c,(x), d]
•	Predicado: Tiene la estructura: átomo (argumento), donde argumento es 1 o más argumentos separados por comas.
o	Ejemplo: -->(x, Luis), invierte ([1, 2,3], Lisa), concatena ("Hola", "?")
Autómata Finito
EL diagrama para el autómata finito reside en:
Luthor, lex
