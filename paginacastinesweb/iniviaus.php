<?php 
    include("cabus.php"); 
    include("conexion.php");

    if ($_POST) {
        try {
            $matricula = $_REQUEST['matricula'];
            $idpatin = $_REQUEST['idpatin'];
            $estacionOrigen = $_REQUEST['estacionOrigen'];
            $usuarioEntrega = $_REQUEST['usuarioEntrega'];
            $estacionDestino = $_REQUEST['estacionDestino'];

            if (!is_numeric($idpatin)) {
                throw new Exception("ID de patín inválido. Debe ser un número.");
            }

            $conexion = new conect();
            $c = $conexion->conectar();

            $insertaviaje = ("INSERT INTO viajes(dia, h_inicio, h_fin, matricula, patinid, estacioninicioid, usuarioinicioid, estacionfinid, usuarifinid)
                VALUES(now(), now(), null, '$matricula', '$idpatin', '$estacionOrigen', '$usuarioEntrega', '$estacionDestino', null)");
            $iniviaje = pg_query($c, $insertaviaje);

            if (!$iniviaje) {
                throw new Exception("Error al iniciar viaje");
            }

            $updatepatin = ("UPDATE patines SET estadoid=2 WHERE idpatin = '$idpatin'");
            $iniviaje2 = pg_query($c, $updatepatin);

            if (!$iniviaje2) {
                throw new Exception("Error al actualizar estado patín");
            }

            $updatepatin3 = ("UPDATE patines SET estacionid = '$estacionDestino' WHERE idpatin = '$idpatin'");
            $iniviaje3 = pg_query($c, $updatepatin3);

            if (!$iniviaje3) {
                throw new Exception("Error al actualizar estado patín");
            }

            echo "<script> alert('¡Viaje iniciado con éxito!')</script>";
        } catch (Exception $e) {
            echo "<script> alert('Datos ingresados erróneos, prueba de nuevo');</script>";
        }
    }
?>

<div id="forminiciaviaje" class="col-md-8">
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-5 text-center">
                <br><br>
                <h1>Iniciar Viaje</h1>
                <form action="iniviaus.php" method="post">
                    <div class="mb-3">
                    <br>
                    <label for="matricula">Matrícula:</label>
                    <input type="text"
                        class="form-control" name="matricula" id="matricula" aria-describedby="helpId" required>
                    <small id="helpId" class="form-text text-muted"></small>
                    <label for="idpatin">ID Patín:</label>
                    <input type="number"
                        class="form-control" name="idpatin" id="idpatin" aria-describedby="helpId" required>
                    <small id="helpId" class="form-text text-muted"></small>
                    <br>
                    <label for="estacionOrigen">Estación Origen:</label>
                    <select name="estacionOrigen" id="estacionOrigen">
                        <option value="1">1 - Colombres</option>
                        <option value="2">2 - Metrobus</option>
                        <option value="3">3 - Gimnasio</option>
                        <option value="4">4 - Cafetería</option>
                        <option value="5">5 - D3</option>
                        <option value="6">6 - D4</option>
                    </select>
                    <br><br>
                    <label for="estacionDestino">Estación Destino:</label>
                    <select name="estacionDestino" id="estacionDestino">
                        <option value="1">1 - Colombres</option>
                        <option value="2">2 - Metrobus</option>
                        <option value="3">3 - Gimnasio</option>
                        <option value="4">4 - Cafetería</option>
                        <option value="5">5 - D3</option>
                        <option value="6">6 - D4</option>
                    </select>
                    <br><br>
                    <label for="usuarioEntrega">Usuario que entrega patín:</label>
                    <input type="number"
                        class="form-control" name="usuarioEntrega" id="usuarioEntrega" aria-describedby="helpId" required>
                    <small id="helpId" class="form-text text-muted"></small>
                    <br>
                    <button type="submit" class="btn btn-success">Iniciar Viaje</button>
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

<?php include("pieus.php"); ?>