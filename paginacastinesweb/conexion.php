<?php
    class conect{
        public static function conectar(){
            //Estableciendo los parametros para la conección
             $server = "otto.db.elephantsql.com";//se quita lo ultimo, solo se deja hasta el .com
             $port = "5432"; //El puerto siempre debe ser este 
             $dbname = "xovklzuh"; //Lo proporciona elephant
             $user = "xovklzuh";//Es el mismo que la db
             $password = "72I5kECZpe43Vah8Xwe_J260X46U1kCC";//Ya ni modo, hay la ves jaja
            //Hacemos la conexión, asegurate de que la linea extension=pgsql en php.ini (de php my admin) no tenga un ; al principio
            $conn = pg_connect("host=$server port=$port dbname=$dbname user=$user password=$password");
            if (!$conn) {//Si no funciona
                die("Error de conexión: " . pg_last_error());
            }
            return $conn;
            //echo "Conexión exitosa";//Por si funciona
            // Cerramos la conexión
            
        }
    }
?>