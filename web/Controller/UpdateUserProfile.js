document.addEventListener("DOMContentLoaded", init, true);

function init() {
    document.querySelector("#actualizarPerfil").addEventListener("click", actualizarUsuario, true);

    function actualizarUsuario(e) {
        e.preventDefault();
        var txtTelefono = document.querySelector("#txtTelefono");
        var txtDireccion = document.querySelector("#txtDireccion");
        var txtCiudad = document.querySelector("#txtCiudad");
        var txtPais = document.querySelector("#txtPais");
        var txtPostal = document.querySelector("#txtPostal");

        var userdata = '{"txtTelefono":' + txtTelefono.value +
                ',"txtDireccion":' + txtDireccion.value +
                ',"txtCiudad":' + txtCiudad.value +
                ',"txtPais":' + txtPais.value +
                ',"txtPostal":' + txtPostal.value + '}';
        RegistarAjax(userdata);
    }

    function RegistarAjax(data) {
        var request = new XMLHttpRequest();
        request.open("POST", "UsuarioActualizar", true);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.onreadystatechange = function () {
            // si la respuesta fue exitosa
            if (request.readyState == 4 && request.status == 200) {
                var message = request.responseText;
                switch (message) {
                    case'¡Datos actualizados':
                        Swal.fire(
                                {
                                    icon: 'success',
                                    text: '¡Los datos del perfil fieron actualizados',
                                    showConfirmButton: false,
                                    toast: true,
                                    position: 'top',
                                    timer: 2500
                                });
                        break;
                    case'No se pudo actualizar':
                        Swal.fire(
                                {
                                    icon: 'error',
                                    text: '¡No se pudo actualizar los datos!',
                                    showConfirmButton: false,
                                    toast: true,
                                    position: 'top',
                                    timer: 2500
                                });
                        break;
                }
            }
            // si la respuesta trajo error
            else if (request.readyState == 4 && request.status != 200) {
                var message = request.responseText;
                message = request.responseText;
//                console.log(message)
                Swal.fire(
                        {
                            icon: 'error',
                            text: 'Error al procesar tu peticion',
                            showConfirmButton: false,
                            timer: 2000,
                            width: 300,
                            heigth: 400
                        });
            }
        };
        request.send("datosUsuario=" + data);
    }



}
