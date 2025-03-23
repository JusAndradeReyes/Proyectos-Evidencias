<?php
    include("cabad.php");
    include("conexion.php");
    $conexion = new conect();
    $c=$conexion->conectar();
    $query = "SELECT * FROM viajes";
    /*$query = "SELECT idviaje,dia,h_inicio,h_fin,viajes.matricula,patinid,est.nombrestacion as EstacionInicio,us.nombres as UsarioQueEntrega ,(SELECT est.nombrestacion as estacionfin
    FROM viajes
    INNER JOIN estaciones est
    ON est.idestacion= viajes.estacionfinid
    ),(SELECT us.nombres as usuarioquerecibe
    FROM viajes
    INNER JOIN usuarios as us
    ON us.idusuario= viajes.usuarifinid
    )
    FROM viajes
    INNER JOIN estaciones est
    ON est.idestacion= viajes.estacioninicioid
    INNER JOIN usuarios as us
    ON us.idusuario= viajes.usuarioinicioid";*/
    $result = pg_query($c, $query);

    if (!$result) {
        die("Error en la consulta");
    }

    $query2 = "SELECT idusuario,nombres FROM usuarios";
    $result2 = pg_query($c, $query2);

    $query3 = "SELECT * FROM estaciones";
    $result3 = pg_query($c, $query3);

    //echo "<script> alert('Viajes Al Día')</script>";
    
    /*if($_POST){
        $conexion = new conect();
        $c=$conexion->conectar();
        $query2 = "SELECT * FROM (SELECT idpatin, es.nombreestado, esta.nombrestacion
        FROM patines
        INNER JOIN estados as es
        ON es.idestado= patines.estadoid
        INNER JOIN estaciones as esta
        ON  esta.idestacion = patines.estacionid) as todos WHERE idpatin = '$_REQUEST[idpatin]'";
        $result2 = pg_query($c, $query2);

        if (!$result2) {
            die("Error en la consulta");
        }
    }*/
?>

<div class="col-md-9">
    <h2>Viajes</h2>
    <div  class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-12" style="font-size:small;">
                <div id="containerinvenatrio" class="card">
                    <div class="card-header">
                        <center><h3>Viajes</h3></center>
                    </div>
                    <div class="card-body">
                        <table class="table table-success"style="text-align: center;">
                            <thead>
                                <th>IDVIAJE</th>
                                <th>DÍA</th>
                                <th>HORA_INICIO</th>
                                <th>HORA_FIN</th>
                                <th>MATRÍCULA</th>
                                <th>ID_PATIN</th>
                                <th>E_INICIO</th>
                                <th>ENTREGA</th>
                                <th>E_FIN</th>
                                <th>RECIBE</th>

                            </thead>
                            <tbody>
                                <?php while($tupla = pg_fetch_assoc($result)){ ?>
                                <tr>
                                    <td><?php echo $tupla['idviaje']; ?></td>
                                    <td><?php echo $tupla['dia']; ?></td>
                                    <td><?php echo $tupla['h_inicio']; ?></td>
                                    <td><?php echo $tupla['h_fin']; ?></td>
                                    <td><?php echo $tupla['matricula']; ?></td>
                                    <td><?php echo $tupla['patinid']; ?></td>
                                    <td><?php echo $tupla['estacioninicioid']; ?></td>
                                    <td><?php echo $tupla['usuarioinicioid']; ?></td>
                                    <td><?php echo $tupla['estacionfinid']; ?></td>
                                    <td><?php echo $tupla['usuarifinid']; ?></td>
                                </tr>
                                <?php } ?>
                            </tbody>
                        </table>
                    </div>
                </div>
                <br><br>
            </div>
            <div class="col-md-4" style="font-size:small;">
                <div id="containerinvenatrio" class="card">
                    <div class="card-header">
                        <center><h3>Usuarios</h3></center>
                    </div>
                    <div class="card-body">
                        <table class="table table-success"style="text-align: center;">
                            <thead>
                                <th>ID_US</th>
                                <th>NOMBRES</th>
                            </thead>
                            <tbody>
                                <?php while($tupla2 = pg_fetch_assoc($result2)){ ?>
                                <tr>
                                    <td><?php echo $tupla2['idusuario']; ?></td>
                                    <td><?php echo $tupla2['nombres']; ?></td>
                                </tr>
                                <?php } ?>
                            </tbody>
                        </table>
                    </div>
                </div>
                <br><br><br><br><br><br>
            </div>
            <div class="col-md-4" style="font-size:small;">
                <div id="containerinvenatrio" class="card">
                    <div class="card-header">
                        <center><h3>Estaciones</h3></center>
                    </div>
                    <div class="card-body">
                        <table class="table table-success">
                            <thead>
                                <th>ID_ES</th>
                                <th>NOMBRE</th>
                            </thead>
                            <tbody>
                                <?php while($tupla3 = pg_fetch_assoc($result3)){ ?>
                                <tr>
                                    <td><?php echo $tupla3['idestacion']; ?></td>
                                    <td><?php echo $tupla3['nombrestacion']; ?></td>
                                </tr>
                                <?php } ?>
                            </tbody>
                        </table>
                    </div>
                </div>
                <br><br><br><br><br><br>
            </div>
        </div>
    </div>
</div>  
<p></p><p></p><p></p><p></p><p></p><p></p>

<?php include("piead.php"); ?>