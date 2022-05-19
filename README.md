# devOpsAppQuiz - Grupo 3
* Andrés Rodríguez
* Jhon Sepulveda
* Eidher Cadavid

[5%] Realizar un fork del proyecto, y agregar miembros del team aca en el encabezado

- https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax
- https://github.com/othneildrew/Best-README-Template

[15%] Hacer un code Review encontrado las razones por las cuales el codigo en el repo es un APIRest o no y justificar, y escribir el resultado del code review dentro de este readme, utilizar las syntaxis propuesta en:

- https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax
- https://github.com/othneildrew/Best-README-Template

## RestBarriosController

- No retorna los métodos
- El parámetro barrioDTO no lo está usando

## RestDevOpsController

- El método getUsuario está repetido
- Error de tipado en el método getUsuario, debería ser getUsuarios y eliminar el caracter '}' en la ruta del método

## Entidad PaisDTO

- Entidad vacía

## Entidad EmpleoDTO

- Entidad vacía

## ManejoUsuarioService

- El método saveUsuarios, updateUsuarios y deleteUsuarios no están definidos en la interface, entonces no están siendo sobreescritos
- Las cadenas de las URLs están quemadas y deberían ser consatntes
- No hay manejo de excepciones en getUsuario y getUsuarios. 

## Carpeta utils

- No es propiamente un utilitario

## Tests

- No hay pruebas 


# Conclusiones

### Sí es un API RestNo se está siguiendo con los estándares. No hay congruencia entre los nombres de las clases y los métodos que tiene
### Una de las clases no tiene la anotación @RestController 


[50%] Completar la implementacion usando: hacer commit en el master branch

- https://mockapi.io/ Crear llamados a APis para ganerar datos aleatorios y completar las estructuras si es necesario
- https://www.baeldung.com/spring-boot-json
- https://www.baeldung.com/spring-resttemplate-post-json
- Postman

[30%] Implementar GitFlow Startegy en el proyecto
