package cl.gestiona.appmascotas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import cl.gestiona.appmascotas.data.CrudMascota;
import cl.gestiona.appmascotas.data.Mascota;

public class NuevaMascota extends AppCompatActivity {

    private EditText txtnombre, txtpeso, txtraza;
    private Spinner txtgenero;
    private CrudMascota crud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_mascota);
        crud = new CrudMascota(this);

        txtnombre = (EditText) findViewById(R.id.txt_new_nombre);
        txtpeso = (EditText) findViewById(R.id.txt_new_peso);
        txtraza = (EditText) findViewById(R.id.txt_new_raza);
        txtgenero = (Spinner) findViewById(R.id.txt_new_genero);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_nueva_mascota, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_new_mascota_ok:
                guardaMascota();
                return true;
            default:
                finish();
        }
        return true;
    }

    private void guardaMascota() {
        String nombre = txtnombre.getText().toString();
        String raza = txtraza.getText().toString();
        String genero = txtgenero.getSelectedItem().toString();
        double peso = Double.parseDouble(txtpeso.getText().toString());

        Mascota m = new Mascota(nombre, raza, genero, peso);
        crud.insertar(m);
        finish();
    }



}
