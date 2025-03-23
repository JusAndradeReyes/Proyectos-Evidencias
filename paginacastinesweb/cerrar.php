<?php
    include("conexion.php");
    session_start();
    session_destroy();
    $conexion = new conect();
    $c=$conexion->conectar();

    $dropuser = "UPDATE usuarios_estaciones SET h_fin= now() 
    WHERE id_usuarios_estaciones = (SELECT MAX(id_usuarios_estaciones )
    from usuarios_estaciones)";
    pg_query($c,$dropuser);

    header("location: login.php");
    pg_close($conn);
?>