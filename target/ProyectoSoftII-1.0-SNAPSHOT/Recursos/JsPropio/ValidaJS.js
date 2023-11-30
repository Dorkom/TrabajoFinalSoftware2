function ValidaLogin() {
    // Obtener los valores ingresados por el usuario
    var correo = document.getElementById("correo").value;
    var clave = document.getElementById("clave").value;

    // Validar los campos
    if (correo.trim() === "" || clave.trim() === "") {
        alert("Por favor, ingrese su correo y contraseña.");
        return;
    }

    // Realizar las acciones necesarias para el inicio de sesión

    // Por ejemplo, enviar el formulario
    document.getElementById("formulario").submit();
}

function Volver() {
    window.history.back();
}


function ValidaRegistro() {
    // Obtener los valores de los campos de entrada
    var nombres = document.getElementById("nombres").value;
    var apellidos = document.getElementById("apellidos").value;
    var correo = document.getElementById("correo").value;
    var clave = document.getElementById("clave").value;

    // Validar los campos según tus requisitos
    if (nombres === "") {
        alert("Por favor, ingresa tus nombres.");
        return;
    }

    if (apellidos === "") {
        alert("Por favor, ingresa tus apellidos.");
        return;
    }

    if (correo === "") {
        alert("Por favor, ingresa tu correo.");
        return;
    }

    if (clave === "") {
        alert("Por favor, ingresa tu contraseña.");
        return;
    }

    // Si todos los campos son válidos, puedes enviar el formulario o realizar otras acciones aquí
    document.getElementById("formulario").submit();
}

function ValidaReestablecerContraseña() {
    // Obtener los valores de los campos
    var correo = document.getElementById("correo").value;
    var clave = document.getElementById("clave").value;

    // Validar el correo (expresión regular para verificar un formato de correo válido)
    var correoRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (!correoRegex.test(correo)) {
        alert("Por favor, ingresa un correo válido.");
        return;
    }

    // Validar la contraseña (expresión regular para verificar una contraseña con al menos 8 caracteres, una letra mayúscula, una letra minúscula y un número)
    var claveRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    if (!claveRegex.test(clave)) {
        alert("Por favor, ingresa una contraseña válida. La contraseña debe contener al menos 8 caracteres, una letra mayúscula, una letra minúscula y un número.");
        return;
    }

    // Envía el formulario si todas las validaciones son exitosas
    document.getElementById("formulario").submit();
}


function redireccionar(url) {
    window.location.href = url;
}


