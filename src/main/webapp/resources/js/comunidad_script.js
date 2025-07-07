// Y reemplaza la función seleccionar en tu <script> con esta:
function seleccionar(btn) {
    document.querySelectorAll(".opciones button").forEach(b => b.classList.remove("seleccionado"));
    btn.classList.add("seleccionado");
    document.getElementById("unete").disabled = false;
  
    const mensaje = document.getElementById("mensaje-rol");
    if (btn.textContent.includes("descubrir")) {
      mensaje.textContent = "🎁 Si eres cliente, recibe 10% en tus primeras 5 compras al compartir el link a tus amigos.";
    } else if (btn.textContent.includes("vendedor")) {
      mensaje.textContent = "👨‍🍳 Si eres vendedor, aumenta tu visibilidad compartiendo tu perfil con este enlace.";
    } else if (btn.textContent.includes("domiciliario")) {
      mensaje.textContent = "🚴‍♂️ Si eres domiciliario, gana más entregas al invitar amigos y ampliar tu zona de reparto.";
    } else {
      mensaje.textContent = "";
    }
}
  
  
// Copiar enlace
function copiarEnlace() {
const enlace = "https://Sabor-bajo-el-radar.com/unete";
navigator.clipboard.writeText(enlace)
    .then(() => alert("¡Enlace copiado!"))
    .catch(() => alert("No se pudo copiar el enlace."));
}
  
// Carrusel
let index = 0;

const slider = document.getElementById("slider");

function mover(direccion) {

    const total = slider.children.length;
    index = (index + direccion + total) % total;
    slider.style.transform = `translateX(-${index * 300}px)`; // Ajustado al nuevo ancho
}
setInterval(() => mover(1), 4000);
  
// Boton de unirse
document.querySelector('.cta-final button').onclick = () => {
    window.location.href = "registro.html";
};