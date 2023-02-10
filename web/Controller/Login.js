document.addEventListener("DOMContentLoaded", init, true);

function init() {
    document.querySelector("#btn-ingresar").addEventListener("click", handleLogin, true);

    function handleLogin(e) {
        e.preventDefault();
        var txtUsuario = document.querySelector("#user_input");
        var txtClave = document.querySelector("#password_input");
        var userdata = '{"usuario":' + txtUsuario.value + ',"clave":' + txtClave.value + '}';
        if (txtUsuario.value == '' && txtClave.value == '') {
            Swal.fire(
                    {
                        icon: 'info',
                        text: '¡Ningun campo debe estar vacio!',
                        toast: true,
                        position: 'top',
                        showConfirmButton: false,
                        timer: 2500
                    }
            );
        } else if (txtUsuario.value == '') {
            Swal.fire(
                    {
                        icon: 'info',
                        text: '¡Ingrese un usuario!',
                        toast: true,
                        position: 'top',
                        showConfirmButton: false,
                        timer: 2500
                    }
            );
        } else if (txtClave.value == '') {
            Swal.fire(
                    {
                        icon: 'info',
                        text: '¡Ingrese una contraseña!',
                        toast: true,
                        position: 'top',
                        showConfirmButton: false,
                        timer: 2500
                    }
            );

        } else {
            loginByAjax(userdata);
        }
    }

    function loginByAjax(data) {
        var request = new XMLHttpRequest();
        request.open("POST", "Login", true);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.onreadystatechange = function () {
            // si la respuesta fue exitosa
            if (request.readyState == 4 && request.status == 200) {
                var message = request.responseText;
                switch (message) {
                    case'¡La clave es incorrecta!':
                        Swal.fire(
                                {
                                    icon: 'warning',
                                    text: '¡Contraseña incorrecta!',
                                    toast: true,
                                    position: 'top',
                                    showConfirmButton: false,
                                    timer: 2500
                                }
                        );
                        document.querySelector("#password_input").value = '';
                        break;
                    case'¡No existe este usuario!':
                        Swal.fire(
                                {
                                    icon: 'error',
                                    text: 'Usuario sin registrar!!!',
                                    toast: true,
                                    position: 'top',
                                    showConfirmButton: false,
                                    timer: 2500
                                }
                        );
                        resetForm();
                        break;
                    case'¡El usuario esta bloquedo!':
                        Swal.fire(
                                {
                                    icon: 'info',
                                    text: message,
                                    showConfirmButton: false,
                                    timer: 2000,
                                    width: 300,
                                    heigth: 400
                                });
                        resetForm();
                        break;
                    case'¡Acceso correcto - cliente!':
                        Swal.fire(
                                {
                                    icon: 'success',
                                    text: '¡Acceso correcto!',
                                    showConfirmButton: false,
                                    timer: 2000,
                                    width: 300,
                                    heigth: 400
                                });
                        setTimeout(function () {
                            window.location.href = "Dashboard?accion=cliente";
                        }, 2000);
                        break;
                    case'¡Verificar!':
                        Swal.fire(
                                {
                                    icon: 'success',
                                    text: '¡Acceso correcto!',
                                    showConfirmButton: false,
                                    timer: 2000,
                                    width: 300,
                                    heigth: 400
                                });
                        setTimeout(function () {
                            window.location.href = "Controller?accion=verificar";
                        }, 2000);
                        break;
                    case'¡Acceso correcto - cliente perfil!':
                        Swal.fire(
                                {
                                    icon: 'success',
                                    text: "¡Acceso correcto!",
                                    showConfirmButton: false,
                                    timer: 2000,
                                    width: 300,
                                    heigth: 400
                                });
                        setTimeout(function () {
                            window.location.href = "Dashboard?accion=cliente";
                        }, 2000);
                        break;
                    case'¡Acceso correcto - administrador perfil!':
                        Swal.fire(
                                {
                                    icon: 'success',
                                    text: '¡Acceso correcto!',
                                    showConfirmButton: false,
                                    timer: 2000,
                                    width: 300,
                                    heigth: 400
                                });
                        setTimeout(function () {
                            window.location.href = "Dashboard?accion=administrador_perfil";
                        }, 2000);
                        break;
                    case'¡Acceso correcto - administrador!':
                        Swal.fire(
                                {
                                    icon: 'success',
                                    text: "¡Acceso correcto!",
                                    showConfirmButton: false,
                                    timer: 2000,
                                    width: 300,
                                    heigth: 400
                                });
                        setTimeout(function () {
                            window.location.href = "Dashboard?accion=administrador";
                        }, 2000);
                        break;
                }
//            
            }
            // si la respuesta trajo error
            else if (request.readyState == 4 && request.status != 200) {
                var message = request.responseText;
                message = request.responseText;
                console.log(message)
                Swal.fire(
                        {
                            icon: 'error',
                            text: 'No se pudo procesar tu peticion',
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
        var form = document.querySelector("#flogin");
        var controls = form.querySelectorAll("input, select");

        for (var i = 0; i < controls.length; i++) {
            var control = controls[i];
            if (control.nodeName === "INPUT")
                control.value = "";
        }
        controls[0].focus();
    }

}
