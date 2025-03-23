<?php
    include("cabus.php");
    include("conexion.php");
    $conexion = new conect();
    $c=$conexion->conectar();
    $query = "SELECT p.matricula,p.nombres,p.apellido1,p.apellido2,p.pago,d.nombredivision
    FROM pasajeros as p
    INNER JOIN divisiones as d
    ON d.iddivision = p.divisionid";
    $result = pg_query($c, $query);
?>

<div class="col-md-9">
    <h2>Pasajeros</h2>
    <div  class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-12">
                <div id="containerinvenatrio" class="card">
                    <div class="card-header">
                        <h3>Pasajeros dados de alta</h3>
                    </div>
                    <div class="card-body">
                        <table class="table table-success text-center">
                            <thead>
                                <th>MATRÍCULA</th>
                                <th>NOMBRES</th>
                                <th>APELLIDO P</th>
                                <th>APELLIDO M</th>
                                <th>PAGO</th>
                                <th>DIVISIÓN</th>
                            </thead>
                            <tbody>
                                <?php while($tupla = pg_fetch_assoc($result)){ ?>
                                <tr>
                                    <td><?php echo $tupla['matricula']; ?></td>
                                    <td><?php echo $tupla['nombres']; ?></td> 
                                    <td><?php echo $tupla['apellido1']; ?></td> 
                                    <td><?php echo $tupla['apellido2']; ?></td> 
                                    <td><?php echo $tupla['pago']; ?></td>
                                    <td><?php echo $tupla['nombredivision']; ?></td> 
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