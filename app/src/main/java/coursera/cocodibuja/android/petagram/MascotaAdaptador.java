package coursera.cocodibuja.android.petagram;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nicopro on 24/8/16.
 */
public class MascotaAdaptador extends RecyclerView.Adapter <MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> arrayListMascotas;

    public MascotaAdaptador(ArrayList<Mascota> arrayListMascotas) {
        this.arrayListMascotas = arrayListMascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = arrayListMascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvTelefono.setText(mascota.getTelefono());

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
/*
    ArrayList<Mascota> arrayListMascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> arrayListMascotas) {
        this.arrayListMascotas = arrayListMascotas;
       // this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent,false);
        return new MascotaViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
            final Mascota mascota = arrayListMascotas.get(position);
            mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
            mascotaViewHolder.tvNombre.setText(mascota.getNombre());
            mascotaViewHolder.tvTelefono.setText(mascota.getTelefono());
    }

    @Override
    public int getItemCount() { // cantidad de elementos que contiene el arraylist
        return 1;//arrayListMascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        // declaramos lo que tenemos en el cardview_mascota

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvTelefono;
       // private ImageButton btnLike;
       // private TextView tvLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre    = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefono  = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
         //   btnLike     = (ImageButton) itemView.findViewById(R.id.btnLike);
         //   tvLikes     = (TextView) itemView.findViewById(R.id.tvLikes);
        }
    }

    */
}
