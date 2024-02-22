## Pruebas automatizadas de la web ecommerce DemoBlaze

En el feature Pay se detalla los pasos a seguir de los flujos de creacion de usuario, reserva de 2 productos y su pago respectivo con tarjeta.
Se trabajó con la librería Selenium para la obtención de elementos y Serenity BDD para los reportes.

La estructura del proyecto es a través de : Feature -> StepDefinitios -> Steps -> ElementsPage

Se aplicaron validaciones tales como el nombre del usuario al loguearse, los productos seleccionados y el monto total de la venta.
## Como requisito a la ejecución contar Java desde la versión 8 en adelante

Para verificar la versión de java, abrir una ventana de comando de window y ejecutar:

    java -version 

## Contar con Maven instalado

Para verificar la versión de Maven, abrir una ventana de comando de window y ejecutar:

    mvn --version 

## Ejecutar los casos de prueba automatizadas web

Para ejecutar el escenario de prueba ejecutar el siguiente comando Maven:

    mvn clean verify -pl serenity-gaa -am

## Visualizar los reportes

Para visualizar el  reporte de la prueba, se creará el reporte index.html automáticamente en el directorio

    /target/site/serenity/index.html

