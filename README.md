# EcoDev

EcoDev es un proyecto realizado para poner en practica los conocimientos adquiridos en el Bootcamp Full Stack Java Trainee  
 
## Requisitos previos

Asegúrese de tener instalado lo siguiente:

- Java 8 o superior
- Maven
- Spring MVC
- XAMPP

## Tecnologías

| Recursos utilizados       | Enlace                                                                               |
| ------------------------- | -----------------------------------------------------------------------------------  |
| Java                      | [Ir a la web ](https://www.java.com/es/download/ie_manual.jsp)                       |
| Bootstrap 5.2.0           | [Ir a la web ](https://getbootstrap.com/)                                            |
| Font Awesome              | [Ir a la web ](https://fontawesome.com/)                                             |
| Mysql                     | [Ir a la web](https://www.npmjs.com/package/mysql)                                   |
| Spring MVC                | [Ir a la web](https://spring.io/projects/spring-boot)                                |
| Maven                     | [Ir a la web](https://maven.apache.org/)                                             |
| JUnit                     | [Ir a la web](https://junit.org/junit5/)                                             |
| Git                       | [Ir a la web](https://git-scm.com/)                                                  |
| Mysql Connector           | [Ir a la web](https://www.npmjs.com/package/mysql)                                   |
| JSTL                      | [Ir a la web](https://mvnrepository.com/artifact/jstl/jstl))                         |




## Configuración

Siga estos pasos para configurar y ejecutar el proyecto:

1. Clonar el repositorio:
> git clone https://github.com/cmongez/ProyectoJava.git
2. Inicia los módulos de Apache y MySQL haciendo clic en los botones "Start" junto a cada uno situados en el panel de control de XAMPP
3. Abre tu navegador web y ve a "localhost/phpmyadmin".
4. Dirigete a la seccion de ejecucion de sentencias SQL.
5. Copia y pega las sentencias SQL en el archibo ficticia.sql que esta situado en el directorio principal
> ProyectoJava/ficticia.sql
6. Ejecuta las sentencias para que se genere la base de datos con sus datos de prueba
7. Navegar al directorio del proyecto:
8. Compilar y empaquetar el proyecto usando Maven:
> mvn clean package
9. Ejecutar la aplicación
10. Abre tu navegador web y ve a
> http://localhost:8080/
11. El proyecto debiese estar ejecutando correctamente
12. Para ingresar a la zona de administrador debes loguearte ingresando a la vista login usando el menu o a traves de la url 
> http://localhost:8080/login
13. Utilice las credenciales usuario: admin@admin.com, password: 1234


# API
### GET: Obtener usuarios por RUT

`/api/rest/get/:rut`

Devuelve el objeto usuario que coincida con el rut proporcionado, de no existir devuelve un null.

Ejemplo: *http://localhost:8084/api/rest/get/26579154*

## Contacto

Si tienes alguna pregunta o comentario sobre este proyecto, puedes contactarme a través de [correo electrónico](camongez28@gmail.com).
