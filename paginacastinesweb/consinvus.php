<?php 
    include("cabus.php");
    include("conexion.php");
    $conexion = new conect();
    $c=$conexion->conectar();
    $query = "SELECT idpatin, es.nombreestado, esta.nombrestacion
    FROM patines
    INNER JOIN estados as es
    ON es.idestado= patines.estadoid
    INNER JOIN estaciones as esta
    ON  esta.idestacion = patines.estacionid";
    $result = pg_query($c, $query);

    if($_POST){
        $conexion = new conect();
        $c=$conexion->conectar();
        $query2 = "UPDATE patines SET estadoid = '$_REQUEST[actualizaestado]'  WHERE idpatin = '$_REQUEST[idpatin]'";
        $result2 = pg_query($c, $query2);

        if (!$result2) {
            die("Error en la consulta");
        }
        echo "<script> alert('¡Estado De Patín Actualizado Con Éxito!')</script>";  
    }
?>

<div class="col-md-9">
    <h2>Inventario de Patines</h2>
    <div  class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-6">
                <div id="containerinvenatrio" class="card">
                    <div class="card-header">
                        <h3>Patines en existencia</h3>
                    </div>
                    <div class="card-body">
                        <table class="table table-success text-center">
                            <thead>
                                <th>ID PATÍN</th>
                                <th>ESTACIÓN</th>   
                                <th>ESTADO</th>
                            </thead>
                            <tbody>
                                <?php while($tupla = pg_fetch_assoc($result)){ ?>
                                <tr>
                                    <td><?php echo $tupla['idpatin']; ?></td>
                                    <td><?php echo $tupla['nombreestado']; ?></td>
                                    <td><?php echo $tupla['nombrestacion']; ?></td> 
                                </tr>
                                <?php } ?>
                            </tbody>
                        </table>
                    </div>
                </div>
                <br><br><br><br>
            </div>
            <div class="col-md-6 text-center">
                <div id="containerinvenatrio" class="card">
                    <div class="card-header">
                        <h3>Actualizar estado de Patín</h3>
                    </div>
                    <div class="card-body">
                        <form action="consinvus.php" method="post">
                            <label for="idpatin">Ingresa id del patín a modificar:</label>
                            <p></p>
                            <input type="number"
                            class="form-control" name="idpatin" id="idpatin" aria-describedby="helpId">
                            <small id="helpId" class="form-text text-muted"></small>
                            <p></p>
                            <label for="actualizaestado">Selecciona nuevo estado:</label>
                            <p></p>
                            <select name="actualizaestado" id="actualizaestado">
                                <option value="1">1 - Disponible</option>
                                <option value="2">2 - En uso</option>
                                <option value="3">3 - En reparación</option>
                                <option value="4">4 - No localizado</option>
                            </select>
                            <p></p>
                            <button type="submit" class="btn btn-success">Actualizar estado</button>
                        </form>
                    </div>
                </div>        
            </div>
        </div>
    </div>
</div>

<?php include("pieus.php"); ?>