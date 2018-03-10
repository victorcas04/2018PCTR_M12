## Título:

P02_Simulación de objetos físicos con comportamientos autónomos


## Autores: 

Víctor de Castro Hurtado

Guillermo Paredes Muga


## Asignatura:

Programación Concurrente y de Tiempo Real

Universidad de Burgos


## Índice:

 1. Objetivos
 2. Enunciado
    - Repositorio Original
    - Enunciado Completo
 3. Instrucciones


## 1.- Objetivos:

 - Implementar código concurrente para simular objetos físicos con comportamientos autónomos independientes

 - Conocer una aplicación concurrente y su motivación

 - Conocer la concurrencia aplicada en tratamiento de eventos gráficos en Java

 - Creación y destrucción de hilos en aplicaciones concurrentes Java

 - Definición y comprobación de invariantes/postcondiciones como técnica que garantiza la imposición de diseño de seguridad

 - Sincronización de métodos modificadores como técnica que garantiza la imposición de diseño de seguridad


## 2.- Enunciado:

Se quiere desarrollar un juego de billar donde cada bola de la mesa tiene un comportamiento independientede las demás. En una primera versión de la aplicación, disponible en:

#### Repositorio Original
  https://gist.github.com/clopezno/6b5a192596f0c7e3745f

 - Continuar el desarrollo de esta versión implementando la activación y parada del movimientoindependiente de las bolas utilizando hilos de Java. Consultar las etiquetas //TODO disponibles en elcódigo fuente para evolucionar de forma incremental a la nueva versión.

 - El número de bolas que hay que añadir al  tablero debe ser xx + 3, donde xx es el número del grupode práctica asignado por el profesor. 

 - Definir y comprobar las postcondiciones de los métodos modificadores. Se tiene que utilizar  asertosde Java para modelar el invariante  “las bolas no  pueden salirse fuera del tablero”
 
Nota: El código propuesto tiene objetivos docentes relacionados con programación concurrente acorde a losconocimientos disponibles por alumnos de sexto semestre del Grado de Ingeniería Informática de la UBU.No tiene pretensiones de pasar a explotación, ya que sería más apropiado usar otras clases del API de lainterfaz gráfica de Java que se salen fuera del alcance del objetivo docente buscado.

#### Enunciado completo:
  https://www.dropbox.com/s/aknxwog5sacbeok/01SimulacionObjetosF%C3%ADsicosconComportamaientosAut%C3%B3nomos.pdf?dl=0


## 3.- Instrucciones:

 - Pulsar el botón 'Empezar' para que las bolas empiecen a moverse (o continúen haciéndolo si estaban detenidas tras pulsar el botón 'Parar').
 - Pulsar el botón 'Parar' para que las bolas se detengan en su posición actual hasta que se pulse otro botón.
 - Pulsar el botón 'Reiniciar' para que las bolas se detengan y vuelvan a su posición original.

IMPORTANTE: tras pulsar el botón 'Empezar', las bolas se irán deteniendo poco a poco, si se quiere darlas más impulso, no se podrá pulsar el botón 'Empezar' directamente, sino que habrá que pulsar el botón 'Parar' y a continuación 'Empezar'.
Este comportamiento lo realiza para evitar que pulsemos varias veces seguidas al botón 'Empezar' y las bolas adquieran demasiada velocidad.
