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
import coursera.cocodibuja.android.petagram.pojo.MascotaPerfil;
import coursera.cocodibuja.android.petagram.presentador.PerfilFragmentPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements IPerfilFragmentView {

    ArrayList<MascotaPerfil> arrayListMascotas;
    private RecyclerView rvListaMascotas;
    private PerfilFragmentPresenter presenter;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rvListaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new PerfilFragmentPresenter(this,getContext());

        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(llm); // le estoy diciendo que reciclerView se comporte como linearlayoutManager

    }

    @Override
    public MascotaPerfilAdaptador crearAdaptador(ArrayList<MascotaPerfil> mascotas) {

       MascotaPerfilAdaptador mascotaPerfilAdaptador = new MascotaPerfilAdaptador(mascotas,getActivity());
        return mascotaPerfilAdaptador;

    }

    @Override
    public void inicializarAdaptadorEnRecyclerView(MascotaPerfilAdaptador mascotaAdaptador) {
        rvListaMascotas.setAdapter(mascotaAdaptador);
    }

}
