# language: es
Característica: Busqueda

Esquema del escenario: Busqueda de blusas

Dado el usuario esta en la pagina de inicio
Cuando el usuario ingresa <item> en la caja de busqueda
Y el usuario da click en el boton de busqueda
Entonces la pagina de resultados muestra solo <numero> items

Ejemplos:
| item   | numero |
| blouse |      1 |
| blue   |      2 |
| black  |      4 |