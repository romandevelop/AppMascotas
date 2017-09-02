package cl.gestiona.appmascotas.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by roman on 01-09-17.
 */

public class ConexionHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "data";
    private static final int VERSION = 1;
    private static final String SCRIPT="create table mascota(id integer primary key autoincrement," +
            "nombre text, raza text, genero text, peso double)";

    public static final String TABLE_NAME="mascota";
    public static final String ID="id";
    public static final String COLUMN_NOMBRE="nombre";
    public static final String COLUMN_RAZA="raza";
    public static final String COLUMN_GENERO="genero";
    public static final String COLUMN_PESO="peso";



    public ConexionHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRIPT);
        db.execSQL("insert into mascota values(null,'Boby', 'Boxer', 'macho', 2.5 )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
