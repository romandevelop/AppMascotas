package cl.gestiona.appmascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

import cl.gestiona.appmascotas.data.CrudMascota;
import cl.gestiona.appmascotas.data.Mascota;

public class EditarMascota extends AppCompatActivity {

    private CrudMascota crud;
    private Mascota m;

    private EditText txtnombre, txtpeso, txtraza;
    private Spinner txtgenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_mascota);

        crud = new CrudMascota(this);
        int id = getIntent().getIntExtra("KEY_ID",0);
        m = crud.buscaMascota(id);

        txtnombre = (EditText) findViewById(R.id.txt_edit_nombre);
        txtpeso = (EditText) findViewById(R.id.txt_edit_peso);
        txtraza = (EditText) findViewById(R.id.txt_edit_raza);
        txtgenero = (Spinner) findViewById(R.id.txt_edit_genero);

        if (m != null){
            txtnombre.setText(m.getNombre());
            txtraza.setText(m.getRaza());
            txtpeso.setText(String.valueOf(m.getPeso()));
            txtgenero.setSelection((m.getGenero().equalsIgnoreCase("Macho"))?0:1);

        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_editar_mascota, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_edit_mascota:
                editarMascota();
                return true;
            case R.id.item_delete_mascota:
                eliminarMascota();
                return true;

            default:
                finish();

        }
        return true;
    }

    private void editarMascota(){
        String nombre = txtnombre.getText().toString();
        String raza = txtraza.getText().toString();
        String genero = txtgenero.getSelectedItem().toString();
        double peso = Double.parseDouble(txtpeso.getText().toString());
        if (m!=null){
            m.setNombre(nombre);
            m.setGenero(genero);
            m.setPeso(peso);
            m.setRaza(raza);
            crud.editar(m);
        }
        finish();

    }

    private void eliminarMascota(){
        if (m!=null){
            crud.eliminar(m.getId());
        }
        finish();
    }





}
