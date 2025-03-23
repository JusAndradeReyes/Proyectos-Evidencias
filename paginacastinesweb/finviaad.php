<?php 
    include("cabad.php"); 
    include("conexion.php");

    if($_POST){
        try {
            $idpatin = $_REQUEST['idpatin'];
            $estacionDestino = $_REQUEST['estacionDestino'];
            $usuarioRecibe = $_REQUEST['usuarioRecibe'];

            if (!is_numeric($idpatin)) {
                throw new Exception("ID de patín inválido. Debe ser un número.");
            }
            if (!is_numeric($usuarioRecibe)) {
                throw new Exception("ID de usuario inválido. Debe ser un número.");
            }

            $conexion = new conect();
            $c=$conexion->conectar();
            $updateviajehrfin = ("UPDATE viajes SET h_fin = now() WHERE idviaje = (select max(idviaje) 
                from viajes where patinid = '$idpatin')");

            $finviaje = pg_query($c,$updateviajehrfin);

            if (!$finviaje) {
                throw new Exception("Error en update hr fin");
            }

            $updateviajeestfin = ("UPDATE viajes SET estacionfinid='$estacionDestino' WHERE idviaje = 
                (select max(idviaje) from viajes where patinid = '$idpatin')");
            
            $finviaje2 = pg_query($c,$updateviajeestfin);

            if (!$finviaje2) {
                throw new Exception("Error en update estafin");
            }

            $updateviajeusfin = ("UPDATE viajes SET usuarifinid ='$usuarioRecibe' WHERE idviaje = 
                (select max(idviaje) from viajes where patinid = '$idpatin')");

            $finviaje3 = pg_query($c,$updateviajeusfin);

            if (!$finviaje3) {
                throw new Exception("Error en update usfin");
            }

            $updatepatin = ("UPDATE patines SET estadoid=1 WHERE idpatin = '$idpatin'");

            $finviaje4 = pg_query($c,$updatepatin);

            if (!$finviaje4) {
                throw new Exception("Error al actualizar estado patín");
            }

            $updatepatin2 = ("UPDATE patines SET estacionid = '$estacionDestino' WHERE idpatin = '$idpatin'");

            $finviaje5 = pg_query($c,$updatepatin2);

            if (!$finviaje5) {
                throw new Exception("Error al actualizar estado patín");
            }
            echo "<script> alert('¡Viaje Finalizado Con Éxito!')</script>";
            
        } catch (Exception $e) {
            echo "<script> alert('Datos ingresados erróneos, prueba de nuevo');</script>";
        }
    }
?>

<div id="forminiciaviaje" class="col-md-8">
    <div class="container">
    <div class="row justify-content-md-center">
        <div class="col-md-5 text-center">
        <br><br><br>
        <form action="finviaad.php" method="post">
            <div class="mb-3">
            <br>
            <h1>Finalizar Viaje</h1>
            <label for="idpatin">ID Patín:</label>
            <input type="text"
                class="form-control" name="idpatin" id="idpatin" aria-describedby="helpId" required>
            <small id="helpId" class="form-text text-muted"></small>
            <br>
            <label for="division">Estacion Destino:</label>
            <select name="estacionDestino" id="estacionDestino">
                <option value="1">1 - Colombres</option>
                <option value="2">2 - Metrobus</option>
                <option value="3">3 - Gimnasio</option>
                <option value="4">4 - Cafetería</option>
                <option value="5">5 - D3</option>
                <option value="6">6 - D4</option>
            </select>
            <br><br>
            <label for="matricula">Usuario que recibe patín:</label>
            <input type="text"
                class="form-control" name="usuarioRecibe" id="usuarioRecibe" aria-describedby="helpId" required>
            <small id="helpId" class="form-text text-muted"></small>
            <br>
            <button type="submit" class="btn btn-success">Finalizar Viaje</button>
            </div>
        </form>
        </div>
        <div class="col-md-5">
        <br><br>
        <img src="img/patin2.0.gif" alt="scooter">
        </div>
    </div>
    </div>
</div>
<p></p><p></p><p></p><p></p><p></p><p></p>

<?php include("piead.php"); ?>