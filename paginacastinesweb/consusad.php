<?php
    include("cabad.php");
    include("conexion.php");
    $conexion = new conect();
    $c=$conexion->conectar();
    $query = "SELECT u.idusuario,u.matricula,u.nombres,u.apellido1,u.apellido2,u.password,u.estados_usuarios_id,r.nombrerol,d.nombredivision
    FROM usuarios as u
    INNER JOIN roles as r
    ON r.idrol= u.rolid
    INNER JOIN divisiones as d
    ON d.iddivision = u.divisionid";
    $result = pg_query($c, $query);

    
    
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
    <h2>Usuarios</h2>
    <div  class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-12">
                <div id="containerinvenatrio" class="card">
                    <div class="card-header">
                        <h3>Usuarios dados de alta</h3>
                    </div>
                    <div class="card-body">
                        <table class="table table-success"style="text-align: center; font-size:small;">
                            <thead>
                                <th>ID_US</th>
                                <th>MATRÍCULA</th>
                                <th>NOMBRES</th>
                                <th>APELLIDO_P</th>
                                <th>APELLIDO_M</th>
                                <th>ROL</th>
                                <th>DIVISIÓN</th>
                                <th>ESTADO</th>
                            </thead>
                            <tbody>
                                <?php while($tupla = pg_fetch_assoc($result)){ ?>
                                <tr>
                                    <td><?php echo $tupla['idusuario']; ?></td>
                                    <td><?php echo $tupla['matricula']; ?></td>
                                    <td><?php echo $tupla['nombres']; ?></td> 
                                    <td><?php echo $tupla['apellido1']; ?></td> 
                                    <td><?php echo $tupla['apellido2']; ?></td>
                                    <td><?php echo $tupla['nombrerol']; ?></td> 
                                    <td><?php echo $tupla['nombredivision']; ?></td>
                                    <td><?php echo $tupla['estados_usuarios_id']; ?></td>
                                </tr>
                                <?php } ?>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>  
<p></p><p></p><p></p><p></p><p></p><p></p><p></p>   
<?php include("piead.php"); ?>