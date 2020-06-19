package com.solicita.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jamiltondamasceno
 */

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_SOLICITA_TESTE";
    public static String TABELA_USUARIO = "usuario";

    public DbHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_USUARIO
                + " (nome VARCHAR(190)  NOT NULL, "
                + " email VARCHAR(190) NOT NULL, "
                + " status INT(1) NOT NULL, "
                + " token TEXT NOT NULL); ";

        String sqlUsuario = "INSERT INTO usuario VALUES('usuario', 'usuario@gmail.com', 0, 'token')";
        String sqlLeitura = "SELECT*FROM usuario";

        try {
            db.execSQL( sql );
            db.execSQL(sqlUsuario);
            db.execSQL(sqlLeitura);
            Log.i("INFO DB", "Sucesso ao criar a tabela" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage() );
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

      //  String sql = "DROP TABLE IF EXISTS " + TABELA_USUARIO + " ;" ;

        try {
           // db.execSQL( sql );
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar App" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar App" + e.getMessage() );
        }

    }

}
