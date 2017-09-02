package cl.gestiona.appmascotas.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roman on 01-09-17.
 */

public class CrudMascota {

    private ConexionHelper helper;
    private SQLiteDatabase db;
    private ContentValues values = new ContentValues();

    public CrudMascota(Context context) {
        helper = new ConexionHelper(context);
    }

    public void insertar(Mascota m){
        db = helper.getWritableDatabase();
        values.clear();
        values.put(ConexionHelper.COLUMN_NOMBRE, m.getNombre());
        values.put(ConexionHelper.COLUMN_RAZA, m.getRaza());
        values.put(ConexionHelper.COLUMN_GENERO, m.getGenero());
        values.put(ConexionHelper.COLUMN_PESO, m.getPeso());
        db.insert(ConexionHelper.TABLE_NAME, null, values);
        db.close();
    }

    public void editar(Mascota m){
        db = helper.getWritableDatabase();
        values.clear();
        values.put(ConexionHelper.COLUMN_NOMBRE, m.getNombre());
        values.put(ConexionHelper.COLUMN_RAZA, m.getRaza());
        values.put(ConexionHelper.COLUMN_GENERO, m.getGenero());
        values.put(ConexionHelper.COLUMN_PESO, m.getPeso());
        db.update(ConexionHelper.TABLE_NAME, values, "id=?", new String[]{String.valueOf(m.getId())});
        db.close();
    }

    public void eliminar(int id){
        db = helper.getWritableDatabase();
        db.delete(ConexionHelper.TABLE_NAME, "id=?", new String[]{String.valueOf(id)});
        db.close();
    }


    public List<Mascota> mascotasList(){
        ArrayList<Mascota> list = new ArrayList<>();
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+ConexionHelper.TABLE_NAME, null);
        while (cursor.moveToNext()){
            Mascota m = new Mascota(cursor.getInt(0),
                                    cursor.getString(1),
                                    cursor.getString(2),
                                    cursor.getString(3),
                                    cursor.getDouble(4));
            list.add(m);
        }
        db.close();
        return list;
    }


    public Mascota buscaMascota(int id){
        Mascota m = null;
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+ConexionHelper.TABLE_NAME+" where id=?",
                                                new String[]{String.valueOf(id)});
        if (cursor.moveToNext()){
            m = new Mascota(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getDouble(4));
        }
        db.close();
        return m;
    }


}
