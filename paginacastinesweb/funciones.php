<?php 
    include("conexion.php");
    class funciones{
        function registrarusuario($c){
            //Registrar pasajero
            $insertausuario = ("INSERT INTO usuarios(matricula,
            nombres,
            apellido1,
            apellido2,
            telefono,
            password,
            rolid,
            divisionid
            ) 
            VALUES ('$_REQUEST[matricula]','$_REQUEST[nombre]','$_REQUEST[apellidop]','$_REQUEST[apellidom]','$_REQUEST[telefono]','$_REQUEST[password]','2','$_REQUEST[division]')");
            
            $insus = pg_query($c,$insertausuario);
            
            header("Location: regusad.php");
        }
    }
?>