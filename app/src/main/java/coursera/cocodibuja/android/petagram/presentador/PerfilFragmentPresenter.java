package coursera.cocodibuja.android.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import coursera.cocodibuja.android.petagram.db.ConstructorMascotasPerfil;
import coursera.cocodibuja.android.petagram.pojo.MascotaPerfil;
import coursera.cocodibuja.android.petagram.vista.fragment.IPerfilFragmentView;

/**
 * Created by nicopro on 26/8/16.
 */
public class PerfilFragmentPresenter implements IPresentacionFragmentPresenter {



    private IPerfilFragmentView iPerfilFragmentView;
    private Context context;
    private ConstructorMascotasPerfil constructorMascotasPerfil; //<-- ver uno que se conecte al API y otro al sqlite
    ArrayList<MascotaPerfil> mascotasPerfil;


    public PerfilFragmentPresenter(IPerfilFragmentView iPerfilFragmentView, Context context) {
        this.iPerfilFragmentView = iPerfilFragmentView;
        this.context = context;
        obtenerDatosDeBaseDatos();
    }

    @Override
    public void obtenerDatosDeBaseDatos() {
        constructorMascotasPerfil = new ConstructorMascotasPerfil(context);
        mascotasPerfil = constructorMascotasPerfil.obtenerDatos();
        mostarMascotasEnRecyclerView();

    }

    @Override
    public void mostarMascotasEnRecyclerView() {

        iPerfilFragmentView.inicializarAdaptadorEnRecyclerView(iPerfilFragmentView.crearAdaptador(mascotasPerfil));
        iPerfilFragmentView.generarLinearLayoutVertical();

    }
}
