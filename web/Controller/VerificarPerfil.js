document.addEventListener("DOMContentLoaded", init, true);

function init() {
    document.querySelector("#btn-confirmar").addEventListener("click", registrarUsuario, true);

    function registrarUsuario(e) {
        e.preventDefault();
        var txtUsuario = document.querySelector("#user_input");
        var txtClaveTemporal = document.querySelector("#temporal_password_input");
        var txtNueva = document.querySelector("#new_password_input");
        var userdata = '{"user_input":' + txtUsuario.value +
                ',"temporal_password_input":' + txtClaveTemporal.value +
                ',"new_password_input":' + txtNueva.value + '}';
        ConfirmarUsuAjax(userdata);
        resetForm();
    }

    function ConfirmarUsuAjax(data) {
        var request = new XMLHttpRequest();
        request.open("POST", "ConfirmarCuenta", true);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.onreadystatechange = function () {
            // si la respuesta fue exitosa
            if (request.readyState == 4 && request.status == 200) {
                var message = request.responseText;
                switch (message) {
                    case'¡Clave incorrecta!':
                        Swal.fire(
                                {
                                    icon: 'error',
                                    text: '¡Clave temporal incorrecta!',
                                    showConfirmButton: false,
                                    timer: 2000,
                                    width: 300,
                                    heigth: 400
                                });
                        break;
                    case'¡No existe este usuario!':
                        Swal.fire(
                                {
                                    icon: 'error',
                                    text: '¡No existe este usuario!',
                                    showConfirmButton: false,
                                    timer: 2000,
                                    width: 300,
                                    heigth: 400
                                });
                        break;
                    case'¡Error al actualizar clave del usuario!':
                        Swal.fire(
                                {
                                    icon: 'error',
                                    text: '¡No se pudo verificar la cuenta!',
                                    showConfirmButton: false,
                                    timer: 2000,
                                    width: 300,
                                    heigth: 400
                                });
                        break;
                    case'¡Estado no actualizado!':
                        Swal.fire(
                                {
                                    icon: 'error',
                                    text: '¡No se pudo verificar la cuenta!',
                                    showConfirmButton: false,
                                    timer: 2000,
                                    width: 300,
                                    heigth: 400
                                });
                        break;
                    case'¡Estado actualizado!':
                        Swal.fire(
                                {
                                    icon: 'success',
                                    text: '¡Cuenta Verificada!',
                                    showConfirmButton: false,
                                    timer: 2000,
                                    width: 300,
                                    heigth: 400
                                });
                        setTimeout(function () {
                            window.location.href = "Controller?accion=iniciar-sesion";
                        }, 2000);
                        break;
                }
            }
            // si la respuesta trajo error
            else if (request.readyState == 4 && request.status != 200) {
                var message = request.responseText;
                message = request.responseText;
                console.log(message)
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

    function resetForm(form) {
        var form = document.querySelector("#fVerificarUsu");
        var controls = form.querySelectorAll("input");

        for (var i = 0; i < controls.length; i++) {
            var control = controls[i];
            if (control.nodeName === "INPUT")
                control.value = "";
        }
        controls[0].focus();
    }

}
