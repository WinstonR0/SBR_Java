let contadorCliente = document.getElementById("contador-cliente");
let contadorVendedor = document.getElementById("contador-vendedor");
let contadorDomiciliario = document.getElementById("contador-domiciliario");

let numero = 0;
let metaCliente = 8000;
let metaVendedor = 5000;
let metaDomiciliario = 6500;
let velocidad = 1; // velocidad en milisegundos

let intervaloCliente = setInterval(() => {
    if (numero < metaCliente) {
       numero++;
        contadorCliente.textContent = "+ " + numero;
    } else {
        clearInterval(intervaloCliente); // Detiene el contador
    }
}, velocidad);

let intervaloVendedor = setInterval(() => {
    if (numero < metaVendedor) {
       numero++;
        contadorVendedor.textContent = "+ " + numero;
    } else {
        clearInterval(intervaloVendedor); // Detiene el contador
    }
}, velocidad);

let intervaloDomiciliario = setInterval(() => {
    if (numero < metaDomiciliario) {
       numero++;
        contadorDomiciliario.textContent = "+ " + numero;
    } else {
        clearInterval(intervaloDomiciliario); // Detiene el contador
    }
}, velocidad);


