package coursera.cocodibuja.android.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        //*********************************-------------------------****************************



        //definimos variables con xml
        ListView lstMascotas = (ListView) findViewById(R.id.lstMascotas);


        mascotas = new ArrayList<Mascota>();


        mascotas.add(new Mascota("pepe Grillo", "7777777","pepegrillo@gmail.com"));
        mascotas.add(new Mascota("Juan peroz", "22222222","juanperoz@gmail.com"));
        mascotas.add(new Mascota("Amalia Gomez", "55557777","AmaliaGomez@gmail.com"));
        mascotas.add(new Mascota("Joana Lopez", "43334444443","Joanalopez@gmail.com"));


        ArrayList<String> nombresMascotas = new ArrayList<>();
        for(Mascota mascota: mascotas){
            nombresMascotas.add(mascota.getNombre());
        }



        lstMascotas.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombresMascotas));

        lstMascotas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentAbrirDetalleMascota = new Intent(MainActivity.this,DetalleMascota.class);

                intentAbrirDetalleMascota.putExtra(getResources().getString(R.string.pnombre),mascotas.get(position).getNombre());
                intentAbrirDetalleMascota.putExtra(getResources().getString(R.string.ptelefono),mascotas.get(position).getTelefono());
                intentAbrirDetalleMascota.putExtra(getResources().getString(R.string.pemail),mascotas.get(position).getEmail());


                startActivity(intentAbrirDetalleMascota);

            }
        });




        //*********************************-------------------------****************************


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
