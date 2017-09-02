package cl.gestiona.appmascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import cl.gestiona.appmascotas.data.CrudMascota;
import cl.gestiona.appmascotas.data.Mascota;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CrudMascota crud;

    private ImageView image_empty;
    private TextView txt_empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crud = new CrudMascota(this);

        listView = (ListView) findViewById(R.id.list_mascotas);
        txt_empty = (TextView) findViewById(R.id.txt_empty);
        image_empty = (ImageView) findViewById(R.id.image_empty);

        List<Mascota> list = crud.mascotasList();
        if (list.isEmpty()){
            txt_empty.setVisibility(View.VISIBLE);
            image_empty.setVisibility(View.VISIBLE);
        }else {
            listView.setAdapter(new ArrayAdapter<Mascota>(this, android.R.layout.simple_list_item_1, list));
            txt_empty.setVisibility(View.INVISIBLE);
            image_empty.setVisibility(View.INVISIBLE);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(listView.getAdapter().getItem(position));
                Mascota m = (Mascota)listView.getAdapter().getItem(position);
                launchEditarMascota(m);
            }
        });




    }



    public void addMascota(View view) {
        Intent i = new Intent(this, NuevaMascota.class);
        startActivity(i);
    }

    public void launchEditarMascota(Mascota m){
        Intent i = new Intent(this, EditarMascota.class);
        i.putExtra("KEY_ID", m.getId());
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Mascota> list = crud.mascotasList();
        listView.setAdapter(new ArrayAdapter<Mascota>(this, android.R.layout.simple_list_item_1, list));
        if (list.isEmpty()){
            txt_empty.setVisibility(View.VISIBLE);
            image_empty.setVisibility(View.VISIBLE);
        }else {

            txt_empty.setVisibility(View.INVISIBLE);
            image_empty.setVisibility(View.INVISIBLE);
        }

    }
}
