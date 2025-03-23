<?php
    include("conexion.php");

    if($_POST){
        $conexion = new conect();
        $c=$conexion->conectar();
        $password = $_REQUEST['password'];
        $password2 = $_REQUEST['password2'];
        $matricula = $_REQUEST['matricula'];

        $contrabd = "SELECT password FROM usuarios WHERE matricula = '$matricula'";
        $query1 = pg_query($c,$contrabd);
        $row=pg_fetch_array($query1);

        if(is_array($row)){
            $valor = $row['password'];
            settype($valor,"string");
            if($password2 != $valor){
                if($password == $password2){
                    $actuser="UPDATE usuarios SET password = '$password' WHERE matricula = '$matricula'";
                    $query = pg_query($c,$actuser);
                    echo "<script> alert('¡Contraseña de usuario actualizado!')</script>";
                }else{
                    echo "<script> alert('Las contraseñas deben ser iguales')</script>";
                }
            }else{
                echo "<script> alert('La nueva contraseña no puede ser igual a la anterior')</script>";
            }
        }else{
            echo "<script> alert('La matrícula ingresada es incorrecta, prueba de nuevo')</script>";
        }
    }
?>

<!doctype html>
<html lang="en">

<head>
  <title>Title</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS v5.2.1 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

</head>

<style>
    #contrpass{
        border: solid 3px black;
        background-color: rgb(171, 255, 189);
        width: 50%;
        height: 50%;
    }       
</style>

<body>
  <main>
  <div class="container">
        <center>
            <p></p>
            <div id="contrpass" class="row justify-content-md-center">
                <div class="colm-md-5">
                <h3>Actualizar Contraseña De Usuarios</h3>
                    <form action="usupcontr.php" method="post">
                        <label for="matricula">Ingresa matrícula del usuario que deseas actualizar:</label>
                        <p></p>
                        <input type="text" name="matricula" id="matricula" required>
                        <p></p>
                        <label for="password">Ingresa nueva contraseña:</label>
                        <p></p>
                        <input type="password" name="password" id="password" required>
                        <p></p>
                        <label for="password2">Confirma nueva contraseña:</label>
                        <p></p>
                        <input type="password" name="password2" id="password2" required>
                        <p></p>
                        <button type="submit" class="btn btn-success">Actualizar Contraseña</button>
                    </form>
                    <p></p>
                    <a href="indexad.php" class="btn btn-primary active" role="button">Regresar a Inicio</a>
                    <p></p>
                </div>
            </div>
        </center>
  </main>
  <!-- Bootstrap JavaScript Libraries -->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
    integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
  </script>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
    integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
  </script>
</body>

</html>