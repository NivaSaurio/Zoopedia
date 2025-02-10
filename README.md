## ZOOPEDIA

```mermaid
---
title: Diagrama de secuencia 
---
sequenceDiagram

    participant U as USUARIO
    participant A as APP
    Note right of A: Guardar en fichero
    participant F as FICHERO
    
    loop
    U->>A: Registrar animal
    A->>U: Registro Ok
    A->>F: Animales
    A->>U: Mostrar animales
    end

    A->>U: Puntuación total
```
<br><br><br>

```mermaid
---
title: Diagrama de clases
---

classDiagram
    class Animal{
        -String: Nombre
        -String: Tipo
        -int: nCuernos
        -int: nColmillos
        -boolean: Favorito
        -ENUM: Nivel
    }

    class Nivel{
        <<enumeration>>
        +NORMAL
        +RARO
        +POKÉMON
    }

    Animal<|--Nivel

```

## Explicaciones de código
Clase Animal, en esta clase el constructor solicita SOLO la información necesaria para el animal, el resto de atributos se controlan con la lógica aplicada. Por ejemplo, en base a los atributos nCol y nCuer se establece el "nivel" del animal.
<BR>
El nivel del animal esta en su constructor, este llama a un método que lo establece con return. Cabe recordar que determinados atributos del animal son ENUM.
