document.addEventListener("DOMContentLoaded", init, true);

function init() {
    document.querySelector("#btn-registrar-usuario").addEventListener("click", registrarUsuario, true);

    function registrarUsuario(e) {
        e.preventDefault();
        var txtUsuario = document.querySelector("#usu-usuario");
        var txtNombres = document.querySelector("#dat-nombre");
        var txtApellidos = document.querySelector("#dat-apellido");
        var txtEmail = document.querySelector("#usu-email");
        var txtTelefono = document.querySelector("#dat-telefono");
        var userdata = '{"usu-usuario":' + txtUsuario.value +
                ',"dat-nombre":' + txtNombres.value +
                ',"dat-apellido":' + txtApellidos.value +
                ',"dat-telefono":' + txtTelefono.value +
                ',"usu-email":' + txtEmail.value + '}';
        RegistarAjax(userdata);
        resetForm();
    }

    function RegistarAjax(data) {
        var request = new XMLHttpRequest();
        request.open("POST", "RegistroUsuario", true);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.onreadystatechange = function () {
            // si la respuesta fue exitosa
            if (request.readyState == 4 && request.status == 200) {
                var message = request.responseText;
                switch (message) {
                    case'¡Elige otro nombre de usuario!':
                        Swal.fire(
                                {
                                    icon: 'error',
                                    text: '¡Elige otro nombre de usuario!',
                                    showConfirmButton: false,
                                    timer: 2000,
                                    width: 300,
                                    heigth: 400
                                });
                        break;
                    case'¡Usuario creado, porfavor revisa tu correo!':
                        Swal.fire(
                                {
                                    icon: 'success',
                                    text: '¡Usuario creado!',
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
        var form = document.querySelector("#fResgitroUsuario");
        var controls = form.querySelectorAll("input, select");

        for (var i = 0; i < controls.length; i++) {
            var control = controls[i];
            if (control.nodeName === "INPUT")
                control.value = "";
        }
        controls[0].focus();
    }

}
