# Programa Java que utiliza procesos para ejecutar `grep` en Linux

Este programa muestra cómo un **programa Java** puede interactuar con **procesos del sistema operativo** para ejecutar el comando `grep` en Linux.

---

## Descripción

- El programa crea un **proceso hijo** que ejecuta `grep` con un patrón específico.
- El programa padre (Java) envía varias **líneas de texto** al proceso hijo mediante su **entrada estándar** (`stdin`).
- El proceso hijo filtra las líneas que contienen el patrón y devuelve el resultado, que el programa padre lee desde la **salida estándar** (`stdout`).

---

## Funcionalidad

1. Se definen las líneas de texto que se quieren filtrar.
2. Se lanza el proceso `grep` con un patrón, por ejemplo `"PSP"`.
3. Se escriben las líneas en la entrada del proceso hijo.
4. Se leen y muestran en la consola solo las líneas que contienen el patrón.

---

## Ejemplo de salida

Si las líneas de entrada son:

