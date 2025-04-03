# Introducción al DOM - Proyecto de Ejemplo

Este proyecto ilustra los conceptos básicos del Document Object Model (DOM) utilizando HTML y JavaScript.

## ¿Qué es el DOM?

El **DOM (Document Object Model)** es una interfaz de programación para documentos web. Representa la estructura del documento como un árbol de nodos, donde cada nodo corresponde a un objeto (elementos HTML, texto, atributos, etc.). El DOM permite:

- Acceder y modificar contenido, estructura y estilos.
- Responder a eventos (clics, teclas, etc.).
- Interactuar dinámicamente con la página.



## Ejemplo de Código:

index.html

```html
<!DOCTYPE html>
<html>
    <head>
        <title>Intro DOM</title>
    </head>
    <body>
        <p id="messageText">Parrafo</p>	
        <textarea id="inputText">Ingresa texto aquí...</textarea>
        
        <button onclick="addTextToList()">Agregar a la lista</button>

        <form id="formElement">
            <ul id="formList">
                <li>Elemento 1</li>
                <li>Elemento 2</li>
            </ul>
        </form>

        <button onclick="showMessage()">Mostrar Mensaje</button>
        <button onclick="showParagraph()">Mostrar Contenido del Párrafo</button>

        <script src="index.js"></script>
    </body>
</html>
```



Index.js: 



```javascript
let msgText; 

window.onload = () => {
    msgText = document.getElementById("messageText");
    console.log("Texto inicial del párrafo:", msgText.innerText);

    const input = document.getElementById("inputText");
    console.log("Contenido del textarea:", input.value);

    const listElement = document.getElementById("formList");
    const elements = document.querySelectorAll("#formList li");

    elements.forEach((element, index) => {
        console.log(`Elemento ${index + 1}:`, element);
        element.textContent = `Nuevo elemento ${index + 1}`;
    });

    msgText.addEventListener("click", () => {
        msgText.style.color = "#FF5733";
    });
};

function showMessage() {
    console.log("¡Botón activado! Esta es la función 2.");
}

function showParagraph() {
    console.log("Contenido actual del párrafo:", msgText.innerHTML);
}


function addTextToList() {
    const input = document.getElementById("inputText");
    const list = document.getElementById("formList");
    
    if (input.value.trim() !== "") {  
        const newItem = document.createElement("li");
        newItem.textContent = input.value;
        list.appendChild(newItem);
        input.value = "";  
    }
}
```

### Detalles:

El `window.onload = () => { ... }` en JavaScript es un **event handler** que se ejecuta cuando la página web ha terminado de cargarse por completo, incluyendo todos sus recursos (imágenes, estilos, scripts, etc.).
