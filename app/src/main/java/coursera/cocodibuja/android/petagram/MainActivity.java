package coursera.cocodibuja.android.petagram;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import coursera.cocodibuja.android.petagram.adaptader.ViewPagerAdapter;
import coursera.cocodibuja.android.petagram.vista.fragment.PerfilFragment;
import coursera.cocodibuja.android.petagram.vista.fragment.PresentacionFragment;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);



        setUpViewPager(); // aca llamo a mi metodo para que cree los tab y los llene con fragments
        if (toolbar !=null){
            setSupportActionBar(toolbar);
        }



        //*********************************-------------------------****************************

/*
        rvListaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(llm); // le estoy diciendo que reciclerView se comporte como linearlayoutManager

        inicializarListaDeContactos();
        inicializarAdaptador();
*/

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


    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new PresentacionFragment()); // en el primer TAB
        fragments.add(new PerfilFragment());       //Segundo TAB
        return fragments;

    }


    public void setUpViewPager(){



        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_account_circle);
    }


}
