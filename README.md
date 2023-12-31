# BICGestionUsuario

Realizado por Lucila Llanos (lucila.llanos@gmail.com)

Prerequisitos:
* git
* gradle

Para descargar el proyecto

Desde la consola ejecutar las siguiente lineas 

git clone https://github.com/Lucila020/BICGestionUsuario

Para poder comenzar, en la raiz del directorio ejecutar

gradle clean build

Para realizar las pruebas

gradle clean bootrun


Métodos
*Crear Usuario
Crea un usuario con los datos provistos. La respuesta genera un identificador único para el mismo en formato UUID y un token de acceso JWT que es almacenado en base de datos.

Método http: Post
URL: localhost:8080/v1.0/user
Body:
{
    "name":"Lucila",
    "email":"lucila@llanos.cl",
    "password":"Password1!",
    "phones": [
        {
            "number":"4309226",
            "citycode":"358",
            "contrycode":"54"   
        }
    ]
}

Restricciones:
El campo email el dominio debe ser ".cl".
El campo password debe contener una mayúscula al inicio seguido de letras minúscula, con 1 números al final y como minimó 8 digitos 

*Buscar Usuario por Id
Retorna un usuario activo para el id provisto.

Método http: Get
URL: localhost:8080/v1.0/user/{id}
{id}: campo id obtenido en la respuesta del método de creación de usuario en formato UUID.

*Buscar todos los usuarios
Retorna todos los usuarios existentes.

Método http: Get
URL: localhost:8080/v1.0/user/

*Buscar todos los usuarios activos
Retorna todos los usuarios activos.

Método http: Get
URL: localhost:8080/v1.0/user/activo


*Editar Usuario
Permite editar campos de un usuario

Método http: Put
URL: localhost:8080/v1.0/user/{id}
{id}: campo id obtenido en la respuesta del método de creación de usuario en formato UUID.
Body:
{
  "name":"Lucila",
  "email":"lucila@llanos.cl",
  "password":"Password1!",
  "phones": [
        {
        "number":"4309226",
        "citycode":"358",
        "contrycode":"54"   
        }
    ]
}

Restricciones:
El campo email el dominio debe ser ".cl".
El campo password debe contener una mayúscula al inicio seguido de letras minúscula, con 1 números al final y como minimó 8 digitos

*Borrado lógico de usuario por Id
Realiza el borrado lógico de un usuario colocando el campo IsActive en false en la base de datos.

Método http: Delete
URL: localhost:8080/v1.0/user/{id}
{id}: campo id obtenido en la respuesta del método de creación de usuario en formato UUID.

*Login de Usuario
Permite realizar la autenticación del usuario con email y contraseña, retorna el token de acceso UUID

Método http: Post
URL: localhost:8080/v1.0/login
Body:
{
    "email":"lucila@llanos.cl",
     "password":"Password1!",
}

En la carpeta src\main\resources\documentosAdicionales podran encontrar

Postman Collection Desde la colección de Postman provista en el directorio bajo el archivo BCI-GestionUsuario.postman_collection.json

Diagramas
![](src/main/resources/documentosAdicionales/DiagramadeSolucion.png)

![](src/main/resources/documentosAdicionales/DiagramaSecuencia.png)

Script  - script_user_ddl.sql

