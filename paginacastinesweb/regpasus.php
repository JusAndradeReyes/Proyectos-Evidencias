<?php 
    include("cabus.php"); 
    include("conexion.php");

    $conexion = new conect();
    $co=$conexion->conectar();

    if($_POST){
        //Registrar pasajero
        $insertapasajero = ("INSERT INTO pasajeros(matricula, 
        nombres,
        apellido1,
        apellido2,
        pago,
        divisionid 
        ) 
        VALUES ('$_REQUEST[matricula]','$_REQUEST[nombre]','$_REQUEST[apellidop]','$_REQUEST[apellidom]','$_REQUEST[pago]','$_REQUEST[division]')");
        
        $inspas = pg_query($co,$insertapasajero);

        echo "<script> alert('¡Pasajero Registrado Con Éxito!')</script>";
    }
?>
<div class="col-md-8">
    <div id="contregistrarpasajero" class="container">
    <div class="row justify-content-md-center">
        <div class="col-md-5 text-center">
            <h2>Registrar Nuevo Pasajero</h2>
            <form action="regpasus.php" method="post">
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
                    <p></p>
                    <label for="pago">Pago:</label>
                    <select name="pago" id="pago">
                        <option value="true">SI</option>
                        <option value="false">NO</option>
                    </select>
                    <br><br>
                    <button type="submit" class="btn btn-success">Registrar Nuevo Pasajero</button>
                    <br><br><br>
                </div>
            </form>
        </div>
        <div class="col-md-5 text-center">
            <br><br><br><br><br>
            <img  class="rounded-circle" src="img/usuario.png" alt="scooter">
        </div>
    </div>
    </div>
</div>
<p></p><p></p><p></p><p></p><p></p><p></p>

<?php include("pieus.php"); ?>