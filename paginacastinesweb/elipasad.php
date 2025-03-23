<?php
  include("cabad.php"); 
  include("conexion.php");

  $conexion = new conect();
  $co=$conexion->conectar();

  if($_POST){
      //Actualizar pasajero
      $actpas = "UPDATE pasajeros SET estados_usuarios_id = '$_REQUEST[estadous]' WHERE matricula = '$_REQUEST[idus]'";
      
      $acpas = pg_query($co,$actpas);

      echo "<script> alert('¡Pasajero Actualizado Con Éxito!')</script>";
  }
?>

<div class="col-md-8">
<br><br><br>
  <div id="contregistrarpasajero" class="container">
    <div class="row justify-content-md-center">
    <div class="col-md-5 text-center">
      <h3>Actualizar Estado De Pasajeros</h3>
      <form action="elipasad.php" method="post">
        <label for="idus">Ingresa la matrícula del pasajero que deseas actualizar:</label>
        <p></p>
        <input type="text" name="idus" id="idus">
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