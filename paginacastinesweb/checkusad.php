<?php
    include("cabad.php");
    include("conexion.php");
    $conexion = new conect();
    $c=$conexion->conectar();
    $query = "SELECT ue.id_usuarios_estaciones,(ue.h_fin-ue.h_inicio)as tiempologeado,ue.dia,ue.h_inicio,ue.h_fin,u.matricula,u.nombres,u.apellido1,e.nombrestacion
    FROM usuarios_estaciones as ue
    INNER JOIN usuarios as u
    ON u.idusuario = ue.usuarioid
    INNER JOIN estaciones as e
    ON e.idestacion = ue.estacionid";
    $result = pg_query($c, $query);
?>

<div class="col-md-9">
    <h2>Checador</h2>
    <div  class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-12">
                <div id="containerinvenatrio" class="card">
                    <div class="card-header">
                        <h3>Checador de Usuarios</h3>
                    </div>
                    <div class="card-body">
                        <table class="table table-success text-center" style="font-size:small;">
                            <thead>
                                <th>ID_US_ES</th>
                                <th>DÍA</th>
                                <th>HORA_LOGIN</th>
                                <th>HORA_LOGOUT</th>
                                <th>DURACIÓN_LOG</th>
                                <th>MATRÍCULA</th>
                                <th>NOMBRES</th>
                                <th>APELLIDO_P</th>
                                <th>ESTACIÓN</th>
                            </thead>
                            <tbody>
                                <?php while($tupla = pg_fetch_assoc($result)){ ?>
                                <tr>
                                    <td><?php echo $tupla['id_usuarios_estaciones']; ?></td>
                                    <td><?php echo $tupla['dia']; ?></td>
                                    <td><?php echo $tupla['h_inicio']; ?></td> 
                                    <td><?php echo $tupla['h_fin']; ?></td>
                                    <td><?php echo $tupla['tiempologeado']; ?></td> 
                                    <td><?php echo $tupla['matricula']; ?></td> 
                                    <td><?php echo $tupla['nombres']; ?></td> 
                                    <td><?php echo $tupla['apellido1']; ?></td> 
                                    <td><?php echo $tupla['nombrestacion']; ?></td> 
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