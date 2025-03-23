<?php 
    include("cabecera.php");
    include("conexion.php");
    session_start();
    if($_POST){
        $conexion = new conect();
        $c=$conexion->conectar();
        $usuario = $_POST['txtUsuario'];
        $password = $_POST['password'];
        $estación = $_POST['estacion'];
        $sql="SELECT rolid   FROM usuarios WHERE matricula = '$usuario' AND password= '$password' AND estados_usuarios_id = '1'";
        $consulta = pg_query ($c, $sql );
        
        $row=pg_fetch_array($consulta);

        if(is_array($row)){
            $valor = $row['rolid'];
            settype($valor,"integer");
            if($valor == 1){
                $_SESSION['txtUsuario']=$usuario;
                $_SESSION['estacion']=$estación;
    
                $user = "INSERT INTO usuarios_estaciones(dia,
                h_inicio,
                h_fin,
                usuarioid,
                estacionid
                ) 
                VALUES(now(),now(),now(),(SELECT idusuario FROM usuarios WHERE matricula = '$usuario'),'$_REQUEST[estacion]')";
                pg_query($c,$user);
    
                header("location: indexad.php");
            }else if($valor == 2){
                $_SESSION['txtUsuario']=$usuario;
                $_SESSION['estacion']=$estación;
    
                $user = "INSERT INTO usuarios_estaciones(dia,
                h_inicio,
                h_fin,
                usuarioid,
                estacionid
                ) 
                VALUES(now(),now(),now(),(SELECT idusuario FROM usuarios WHERE matricula = '$usuario'),'$_REQUEST[estacion]')";
                pg_query($c,$user);
    
                header("location: indexus.php");
            }
        }else{
            echo "<script> alert('Usuario o contraseña incorrectos, prueba de nuevo...')</script>"; 
        }
    }
?>

<br><br><br>
<div class="container-fluid">
    <div class="row justify-content-md-center">
        <div class="col-md-4">
            <div class="card">
                <div class="card-header text-center">
                    <img class="rounded-circle" src="img/usuario.png" alt="usuario" style="width: 90px;">
                </div>
                <div class="card-body">
                    <form action="login.php" method="post">
                        <div class="mb-3">
                            <input type="text"
                            class="form-control" name="txtUsuario" id="txtUsuario" aria-describedby="helpId" placeholder="USUARIO">
                            <small id="helpId" class="form-text text-muted"></small>
                            <br>
                            <input type="password"
                            class="form-control" name="password" id="password" aria-describedby="helpId" placeholder="PASSWORD">
                            <small id="helpId" class="form-text text-muted"></small>
                            <br>
                            <label for="rolid">Estación:</label>
                            <select name="estacion" id="estacion">
                                <option value="1">Colombres</option>
                                <option value="2">Metrobus</option>
                                <option value="3">Gimnasio</option>
                                <option value="4">Cafetería</option>
                                <option value="5">D3</option>
                                <option value="6">D4</option>
                            </select>
                            <br><br>
                            <button type="submit" class="btn btn-success">ACCEDER</button>
                            <br><br>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>

<?php include("pie.php"); ?>