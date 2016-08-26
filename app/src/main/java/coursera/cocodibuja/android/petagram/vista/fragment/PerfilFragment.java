package coursera.cocodibuja.android.petagram.vista.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import coursera.cocodibuja.android.petagram.R;
import coursera.cocodibuja.android.petagram.adaptader.MascotaPerfilAdaptador;
import coursera.cocodibuja.android.petagram.pojo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Mascota> arrayListMascotas;
    private RecyclerView rvListaMascotas;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvListaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(llm); // le estoy diciendo que reciclerView se comporte como linearlayoutManager

        inicializarListaDeMascotas();
        inicializarAdaptador();

        return v;
    }


    public void inicializarListaDeMascotas(){
        arrayListMascotas = new ArrayList<Mascota>();

        arrayListMascotas.add(new Mascota(R.drawable.perro_orejas,"Amalia Gomez", "55557777","AmaliaGomez@gmail.com",1));
        arrayListMascotas.add(new Mascota(R.drawable.perro_star,"Joana Lopez", "43334444443","Joanalopez@gmail.com",2));
        arrayListMascotas.add(new Mascota(R.drawable.perro_feliz,"pepe Grillo", "7777777","pepegrillo@gmail.com",3));
        arrayListMascotas.add(new Mascota(R.drawable.perro_globo,"Juan peroz", "22222222","juanperoz@gmail.com",4));

    }

    public void inicializarAdaptador() {
        MascotaPerfilAdaptador mascotaAdaptador = new MascotaPerfilAdaptador(arrayListMascotas,getActivity());// aca no hace falta volver a definirlo por que lo declaramos arriba y lo inicializamos y cargamos en public void inicializarListaDeContactos()
        rvListaMascotas.setAdapter(mascotaAdaptador); //lo tengo que mostrar
    }

}
