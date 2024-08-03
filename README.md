# Challenge - SinergiaRH

Back-end del challenge para SinergiaRH. Desarrollado con Java, por Leo Martinez.

## Entidades

En la carpeta `java/sinergiarh/challenge/entity` se encuentran las clases de tipo entidad, son 4: La entidad `Employee` para los empleados, `Gender` para los géneros, `Task` para las tareas, y `TaskCategory` para las categorías de las tareas

## Repositorios

En la carpeta `java/sinergiarh/challenge/repository` se encuentran las clases de tipo repositorio, que brindan los métodos para administrar las diferentes entidades

## Servicios

En la carpeta `java/sinergiarh/challenge/service` se encuentran las interfaces para los servicios de las entidades, y en `java/sinergiarh/challenge/service/impl` están sus respectivas implementaciones.

## Controladores

En la carpeta `java/sinergiarh/challenge/controller` se encuentran los controladores de empleado y tarea, donde están definidos los endpoints a través de los cuales la aplicación recibirá solicitudes.

## Seeders

Por último, en la carpeta `java/sinergiarh/challenge/seeder` están las clases que se encargan de insertar datos iniciales en las bases de datos