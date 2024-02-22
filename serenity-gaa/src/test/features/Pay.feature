# language: es
Característica: Realizar compra de productos desde la web Demoblaze

  Como cliente registrado en la web Demoblaze
  Quiero reservar productos en el carrito de compras
  Para realizar el pago total del pedido

  # Escenarios de negocio
  @ComprarProductos
  Esquema del escenario: Comprar productos desde la web de Demoblaze

    Dado que el cliente accede a la web de DemoBlaze

    Y el cliente decide registrarse como usuario indicando su user <user> y password <password>

    Y el cliente accede de forma automática a la web de compras

    Cuando el cliente decide seleccionar el segundo producto <producto>

    Y el cliente decide selecciona el segundo producto <producto2>

    Y el cliente confirma la totalidad de productos a comprar

    Entonces deberá visualizar el mensaje de éxito de compra

    Ejemplos:
      | user                          | password   | producto          | producto2     |
      | jorgebacaelera258@yopmail.com | Abc123456$ | Samsung galaxy s6 | Iphone 6 32gb |
      | vanessaprueba2227@yopmail.com | Abc123456$ | Sony vaio i5      | HTC One M9    |

