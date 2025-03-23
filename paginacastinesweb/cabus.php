<?php
  session_start();
  if(isset($_SESSION['txtUsuario']) != "user"){
    header("location: login.php");
  }
?>

<!doctype html>
<html lang="en">

<head>
  <title>Inicio</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS v5.2.1 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="shortcut icon" href="img/sc3.png">
</head>

<body>
  <header>
    <div class="container-fluid">
      <div id="principal" class="row">
        <div class="col-md-2">
          <img id="logo" src="img/logo.png" alt="logo">
        </div>
        <div id="titulo" class="col-md-4">
          <h3>
            CASTINES
            <br>
            SERVICIO DE PRÉSTAMO
            <br>
            DE PATINES
          </h3>
        </div>
        <div class="col-md-4"></div>
        <div class="col-md-2">
          <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      <p></p>
                      <img id="user" class="rounded-circle" src="img/user.png" alt="user">
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="#">Usuario: <?php echo($_SESSION['txtUsuario']); ?></a></li>
                      <li><a class="dropdown-item" href="#">Estación: <?php echo($_SESSION['estacion']); ?></a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="cerrar.php">Salir</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
        </div>
      </div>
    </div>
    <div class="row">
        <nav id="navmenu" class="navbar navbar-expand navbar-light"><p></p></nav>
    </div>
    <div  id="espacio" class="row"><p></p></div>
  </header>
  <main>
    <br>
    <div id="pagprincipal" class="container-fluid">
      <div class="row">
        <div class="col-md-3">
          <div class="card">
            <div class="card-header">
              Menú - Usuario
            </div>
            <div class="card-body">
              <ul class="nav flex-column">
                <li class="nav-item">
                  <a class="nav-link active" href="indexus.php" aria-current="page"> <i class="bi-house-fill"></i> Inicio</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" href="consvius.php" aria-current="page"> <i class="bi bi-arrow-left-right"></i> Viajes</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" href="iniviaus.php" aria-current="page"> <i class="bi bi-compass"></i> Iniciar Viaje</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" href="finviaus.php" aria-current="page"> <i class="bi bi-check-square"></i> Finalizar Viaje</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" href="consinvus.php" aria-current="page"> <i class="bi bi-pin-map-fill"></i>Patines</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" href="aniapatus.php" aria-current="page"> <i class="bi bi-plus-square"></i> Añadir Patín Nuevo</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" href="conspasus.php" aria-current="page"> <i class="bi bi-people"></i> Pasajeros</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" href="regpasus.php" aria-current="page"> <i class="bi bi-file-person"></i> Registrar Nuevo Pasajero</a>
                </li>
              </ul>
            </div>
          </div>
        </div>