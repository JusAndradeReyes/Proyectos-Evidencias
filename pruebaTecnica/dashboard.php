<?php
session_start();
if (!isset($_SESSION['usuario'])) {
    header("Location: index.php");
    exit();
}

$usuarios = json_decode(file_get_contents("data/usuarios.json"), true);
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lista de Usuarios</title>
    
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- DataTables -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css">
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <!-- Estilos personalizados -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h2>Lista de Usuarios</h2>
            <a href="logout.php" class="btn btn-danger">Cerrar sesión</a>
        </div>

        <div class="card shadow-sm p-3">
            <table id="tablaUsuarios" class="table table-striped">
                <thead class="table-dark">
                    <tr>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Fecha Nacimiento</th>
                        <th>Puesto</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach ($usuarios as $u): ?>
                        <tr>
                            <td><?= htmlspecialchars($u["nombre"]) ?></td>
                            <td><?= htmlspecialchars($u["apellidos"]) ?></td>
                            <td><?= htmlspecialchars($u["fecha_nacimiento"]) ?></td>
                            <td><?= htmlspecialchars($u["puesto"]) ?></td>
                            <td class="text-center">
                                <?php if ($u["activo"]): ?>
                                    <i class="fa-solid fa-check-circle text-success fs-4"></i>
                                <?php else: ?>
                                    <i class="fa-solid fa-times-circle text-danger fs-4"></i>
                                <?php endif; ?>
                            </td>
                        </tr>
                    <?php endforeach; ?>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#tablaUsuarios').DataTable();
        });
    </script>
</body>
</html>
