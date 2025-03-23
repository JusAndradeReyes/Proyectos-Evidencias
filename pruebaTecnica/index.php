<?php
session_start();
if (isset($_SESSION['usuario'])) {
    header("Location: dashboard.php");
    exit();
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $json = file_get_contents("data/usuarios.json");
    $usuarios = json_decode($json, true);
    
    $puesto = $_POST["puesto"];
    $pass = $_POST["password"];
    
    foreach ($usuarios as $u) {
        if ($u["puesto"] == $puesto && $u["password"] == $pass) {
            if ($u["activo"]) { 
                $_SESSION["usuario"] = $puesto;
                header("Location: dashboard.php");
                exit();
            } else {
                $error = "Este usuario está inactivo y no puede iniciar sesión.";
                break;
            }
        }
    }
    if (!isset($error)) {
        $error = "Usuario o contraseña incorrectos";
    }
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Estilos personalizados -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="d-flex align-items-center justify-content-center vh-100">
    <div class="card p-4 shadow-sm" style="width: 350px;">
        <h3 class="text-center">Iniciar Sesión</h3>
        <form method="POST">
            <div class="mb-3">
                <label class="form-label">Puesto</label>
                <input type="text" name="puesto" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Contraseña</label>
                <input type="password" name="password" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Ingresar</button>
        </form>
        <?php if(isset($error)) echo "<p class='text-danger mt-2 text-center'>$error</p>"; ?>
    </div>
</body>
</html>
