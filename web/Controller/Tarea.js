document.addEventListener("DOMContentLoaded", init, true);

function init() {
    document.querySelector("#btn-registrar-tarea").addEventListener("click", registrarUsuario, true);

    function registrarUsuario(e) {
        e.preventDefault();
        var txtVencimiento = document.querySelector("#txtVencimiento");
        var txtDescripcion = document.querySelector("#txtDescripcion");
        var userdata = '{"txtVencimiento":' + txtVencimiento.value +
                ',"txtDescripcion":' + txtDescripcion.value + '}';
            regTarea(userdata);
    }

    function regTarea(data) {
        var request = new XMLHttpRequest();
        request.open("POST", "Tarea", true);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.onreadystatechange = function () {
            // si la respuesta fue exitosa
            if (request.readyState == 4 && request.status == 200) {
                var message = request.responseText;
                switch (message) {
                    case'No se pudo crear la tarea':
                        Swal.fire(
                                {
                                    icon: 'warning',
                                    text: '¡No se pudo crear la tarea!',
                                    showConfirmButton: false,
                                    toast: true,
                                    position: 'top',
                                    timer: 2000,
                                    width: 300,
                                    heigth: 400
                                });

                        break;
                    case'Tarea creada':
                        Swal.fire(
                                {
                                    icon: 'success',
                                    text: '¡Tarea registrada correctamente!',
                                    showConfirmButton: false,
                                    toast: true,
                                    position: 'top',
                                    timer: 2000,
                                    width: 300,
                                    heigth: 400
                                });
                        setTimeout(function () {
                            window.location.href = "Dashboard?accion=cliente";
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
                            toast: true,
                            position: 'top',
                            timer: 2000,
                            width: 300,
                            heigth: 400
                        });
            }
        };
        request.send("tareaDatos=" + data);
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
