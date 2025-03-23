<?php 
    include("cabus.php");
    include("conexion.php");

    $conexion = new conect();
    $co=$conexion->conectar();
    if($_POST){
        $insertapatines = ("INSERT INTO patines(estadoid, 
        estacionid) 
        VALUES ('$_REQUEST[estado]','$_REQUEST[estacionInicio]')");
        
        $inspat = pg_query($co,$insertapatines);
        
        if (!$inspat) {
            die("Error al añadir patín");
        }
        echo "<script> alert('¡Patín Añadido Con Éxito!')</script>";
    }
?>

<div class="col-md-8">
    <div id="contañadirpatin" class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-5 text-center">
            <br><br><br><br>
            <h2>Añadir Patín</h2>
            <form action="aniapatus.php" method="post">
                <div class="mb-3">
                <br>
                <label for="estacionInicio">Estación De Inicio:</label>
                <select name="estacionInicio" id="estacionInicio">
                    <option value="1">1 - Colombres</option>
                    <option value="2">2 - Metrobus</option>
                    <option value="3">3 - Gimnasio</option>
                    <option value="4">4 - Cafetería</option>
                    <option value="5">5 - D3</option>
                    <option value="6">6 - D4</option>
                </select>
                <br><br>
                <label for="estado">Estado:</label>
                <select name="estado" id="estado">
                    <option value="1">Disponible</option>
                    <option value="2">En uso</option>
                    <option value="3">En reparación</option>
                    <option value="4">No localizado</option>
                </select>
                <br><br>
                <button type="submit" class="btn btn-success">Añadir Patín</button>
                </div>
            </form>
            </div>
            <div class="col-md-5">
            <br><br>
            <img src="img/patin2.0.gif" alt="scooter" style="height:80%">
            </div>
        </div>
    </div>
</div>
<p></p><p></p><p></p><p></p><p></p><p></p>

<?php include("pieus.php"); ?>