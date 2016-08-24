package coursera.cocodibuja.android.petagram;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> arrayListMascotas;
    private RecyclerView rvListaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //*********************************-------------------------****************************


        rvListaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(llm); // le estoy diciendo que reciclerView se comporte como linearlayoutManager

        inicializarListaDeContactos();
        inicializarAdaptador();


/*
        //definimos variables con xml
        ListView lstMascotas = (ListView) findViewById(R.id.lstMascotas);




        ArrayList<String> nombresMascotas = new ArrayList<>();
        for(Mascota mascota: arrayListMascotas){
            nombresMascotas.add(mascota.getNombre());
        }



        lstMascotas.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombresMascotas));

        lstMascotas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentAbrirDetalleMascota = new Intent(MainActivity.this,DetalleMascota.class);

                intentAbrirDetalleMascota.putExtra(getResources().getString(R.string.pnombre),arrayListMascotas.get(position).getNombre());
                intentAbrirDetalleMascota.putExtra(getResources().getString(R.string.ptelefono),arrayListMascotas.get(position).getTelefono());
                intentAbrirDetalleMascota.putExtra(getResources().getString(R.string.pemail),arrayListMascotas.get(position).getEmail());


                startActivity(intentAbrirDetalleMascota);

            }
        });


*/

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

    public void inicializarListaDeContactos(){
        arrayListMascotas = new ArrayList<Mascota>();

        arrayListMascotas.add(new Mascota(R.drawable.perro_feliz,"pepe Grillo", "7777777","pepegrillo@gmail.com"));
        arrayListMascotas.add(new Mascota(R.drawable.perro_globo,"Juan peroz", "22222222","juanperoz@gmail.com"));
        arrayListMascotas.add(new Mascota(R.drawable.perro_orejas,"Amalia Gomez", "55557777","AmaliaGomez@gmail.com"));
        arrayListMascotas.add(new Mascota(R.drawable.perro_star,"Joana Lopez", "43334444443","Joanalopez@gmail.com"));

    }

    public void inicializarAdaptador() {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(arrayListMascotas);// aca no hace falta volver a definirlo por que lo declaramos arriba y lo inicializamos y cargamos en public void inicializarListaDeContactos()
        rvListaMascotas.setAdapter(mascotaAdaptador); //lo tengo que mostrar

    }
}
