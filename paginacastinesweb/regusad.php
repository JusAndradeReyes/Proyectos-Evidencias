<?php
  include("cabad.php"); 
  include("conexion.php");

  $conexion = new conect();
  $co=$conexion->conectar();

  if($_POST){
      //Registrar usuario
      $insertausuaro = ("INSERT INTO usuarios(matricula, 
      nombres,
      apellido1,
      apellido2,
      telefono,
      password,
      rolid ,
      divisionid
      ) 
      VALUES ('$_REQUEST[matricula]','$_REQUEST[nombre]','$_REQUEST[apellidop]','$_REQUEST[apellidom]','$_REQUEST[telefono]','$_REQUEST[password]','$_REQUEST[rolid]','$_REQUEST[division]')");
      
      $inspas = pg_query($co,$insertausuaro);

      echo "<script> alert('¡Usuario Registrado Con Éxito!')</script>";
  }
?>

<div class="col-md-8">
  <div id="contregistrarpasajero" class="container">
    <div class="row justify-content-md-center">
      <div class="col-md-5 text-center">
        <br>
        <h2>Registrar Usuarios</h2>
        <form action="regusad.php" method="post">
          <div class="mb-3">
            <br>
            <label for="matricula">Matrícula:</label>
            <input type="text"
              class="form-control" name="matricula" id="matricula" aria-describedby="helpId" required>
            <small id="helpId" class="form-text text-muted"></small>
            <label for="nombre">Nombre:</label>
            <input type="text"
              class="form-control" name="nombre" id="nombre" aria-describedby="helpId" required>
            <small id="helpId" class="form-text text-muted"></small>
            <label for="apellidop">Apellido Paterno:</label>
            <input type="text"
              class="form-control" name="apellidop" id="apellidop" aria-describedby="helpId" required>
            <small id="helpId" class="form-text text-muted"></small>
            <label for="apellidom">Apellido Materno:</label>
            <input type="text"
              class="form-control" name="apellidom" id="apellidom" aria-describedby="helpId" required>
            <small id="helpId" class="form-text text-muted"></small>
            <label for="telefono">Teléfono:</label>
            <input type="number"
              class="form-control" name="telefono" id="telefono" aria-describedby="helpId" required>
            <small id="helpId" class="form-text text-muted"></small>
            <label for="password">Password:</label>
            <input type="password"
              class="form-control" name="password" id="password" aria-describedby="helpId" required>
            <small id="helpId" class="form-text text-muted"></small>
            <p></p>
            <label for="rolid">Rol:</label>
            <select name="rolid" id="rolid">
              <option value="1">Administrador</option>
              <option value="2">Usuario</option>
            </select>
            <p></p>
            <label for="division">División:</label>
            <select name="division" id="division">
              <option value="1">Sistemas Automotrices</option>
              <option value="2">Tecnologías de la Información </option>
              <option value="3">Energías ALternativas Y Medio Ambiente</option>
              <option value="4">Gastronomía</option>
              <option value="5">Procesos Industriales</option>
              <option value="6">Mantenimiento Industrial</option>
              <option value="7">Mecatrónica</option>
              <option value="8">Negocios</option>
            </select>
            <br><br>
            <button type="submit" class="btn btn-success">Registrar Usuario</button>
            <br><br><br>
          </div>
        </form>
      </div>
      <div class="col-md-5 text-center">
        <br><br><br><br><br><br><br><br>
        <img  class="rounded-circle" src="img/usuario.png" alt="scooter">
      </div>
    </div>
  </div>
</div>
<p></p><p></p><p></p><p></p><p></p><p></p>

<?php include("piead.php"); ?>