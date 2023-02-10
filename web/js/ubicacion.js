
window.addEventListener("load", inicio);
function inicio() {
    navigator.geolocation.getCurrentPosition(alExito, alError);
}
function alExito(info) {
    campoLatitud.value = info.coords.latitude;
    campoAltitud.value = info.coords.altitud;
    campoLongitud.value = info.coords.longitude;
}
function alError(error) {
    alert("Hubo un error! debe aceptar los permisos de ubicacion");
}


