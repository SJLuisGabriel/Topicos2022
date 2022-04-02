package com.example.topicos2022_proyecto.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static String server = "127.0.0.1";
    private static String user = "gabosj";
    private static String pwd = "852741";
    private static String db = "taqueriadb";

    public static Connection conexion;
    public static void getConexion(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mariadb://" + server + ":3306/" + db, user, pwd);
            System.out.println("Se conecto correctamente");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}