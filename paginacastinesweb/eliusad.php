<?php
  include("cabad.php"); 
  include("conexion.php");

  /*if($_POST){
      //Elimina pasajero
      $eliminausuario = ("DELETE FROM usuarios WHERE matricula = '$_REQUEST[matricula]'");
      
      $elus = pg_query($co,$eliminausuario);

      echo "<script> alert('¡Usuario Eliminado Con Éxito!')</script>";
  }*/
  if($_POST){
    $conexion = new conect();
    $c=$conexion->conectar();
    $actuser="UPDATE usuarios SET estados_usuarios_id = '$_REQUEST[estadous]' WHERE idusuario = '$_REQUEST[idus]'";
    $query = pg_query($c,$actuser);

    echo "<script> alert('¡Estado de usuario actualizado!')</script>";
  }
?>

<div class="col-md-8">
<br><br><br>
  <div id="contregistrarpasajero" class="container">
    <div class="row justify-content-md-center">
      <div class="col-md-5 text-center">
        <h3>Actualizar Estado De Usuarios</h3>
        <form action="eliusad.php" method="post">
          <label for="idus">Ingresa ID del usuario que deseas actualizar:</label>
          <p></p>
          <input type="number" name="idus" id="idus">
          <p></p>
          <label for="estadous">Selecciona estado:</label>
          <p></p>
          <select name="estadous" id="estadous">
              <option value="1">1 - Activo</option>
              <option value="2">2 - Inactivo</option>
          </select>
          <p></p>
          <button type="submit" class="btn btn-success">Actualizar Estado</button>
      </form>
      <p></p>
      </div>
      <div class="col-md-5 text-center">
        <img  class="rounded-circle" src="img/usuario.png" alt="scooter">
      </div>
    </div>
  </div>
</div>
<p></p><p></p><p></p><p></p><p></p><p></p>
<?php include("piead.php"); ?>