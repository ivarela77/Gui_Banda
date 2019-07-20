# Gui_Banda
> Gui de ejemplo para la conexión de una aplicación con una base de datos.

### DESCRIPCIÓN
```
Primer Gui entregado con conexión a BBDD en el primer año de DAW en la asignatura de programación. Lo que 
hicimos fue crear un entorno gráfico muy sencillo para gestionar miembros de una banda de música utilizando
la conexión con MySQL para conseguir la persistencia de los datos en la aplicación.

```
### DISEÑO

* Para el entorno gráfico utilizamos un JFrame principal compuesto por un jTable para mostrar y seleccionar
  los datos de los músicos y un jTabbedPanel para las opciones de añadir y eliminar músicos a la base de datos.

* Para la persistencia y gestión de los datos creamos la clase Utilidades con la que se realiza la conexión a 
  la BBDD mediante el conector para mysql.
  
### FUNCIONAMIENTO

* Si quieres probar su funcionamiento tienes que cambiar los parametros de la conexión en el método "conexiónDB" de
  la clase "Utilidades" con tus datos, también debes añadir el conector a las librerias del proyecto.

  

> En la carpeta dist/lib se encuentra el conector ["mysql-connector-java-8.0.15.jar"](https://github.com/ivarela77/Gui_Banda/blob/master/dist/lib/mysql-connector-java-8.0.15.jar)
  y el [script](https://github.com/ivarela77/Gui_Banda/blob/master/dist/banda.sql) para crear la base de datos.
