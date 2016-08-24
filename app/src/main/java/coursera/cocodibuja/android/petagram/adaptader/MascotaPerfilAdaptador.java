package coursera.cocodibuja.android.petagram.adaptader;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import coursera.cocodibuja.android.petagram.R;
import coursera.cocodibuja.android.petagram.pojo.Mascota;

/**
 * Created by nicopro on 24/8/16.
 */
public class MascotaPerfilAdaptador extends RecyclerView.Adapter <MascotaPerfilAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> arrayListMascotas;
    Activity activity;

    public MascotaPerfilAdaptador(ArrayList<Mascota> arrayListMascotas, Activity activity) {
        this.arrayListMascotas = arrayListMascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_perfil,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = arrayListMascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvTelefono.setText(mascota.getTelefono());

        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,mascota.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayListMascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        // declaramos lo que tenemos en el cardview_mascota

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvTelefono;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre    = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefono  = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
                 }
    }

}
