package co.edu.udea.compumovil.gr04_20211.lab2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.compumovil.gr04_20211.lab2.Models.SitiosEntity;
import co.edu.udea.compumovil.gr04_20211.lab2.R;

public class SitioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<SitiosEntity> sitios = new ArrayList<>();
    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public void setmOnItemClickListener(final OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public SitioAdapter(List<SitiosEntity> sitios, Context ctx) {
        this.sitios = sitios;
        this.ctx = ctx;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagenSitio;
        public TextView nombre, descripcion;
        public CardView lyt_parent;

        public OriginalViewHolder(View itemView) {
            super(itemView);
            lyt_parent = itemView.findViewById(R.id.lyt_parent);
            imagenSitio = (ImageView) itemView.findViewById(R.id.imagenSitio);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            descripcion = (TextView) itemView.findViewById(R.id.descripcion);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sitio, parent, false);

        vh = new OriginalViewHolder(v);
        return vh;

    }

    //aqui es donde seteo los sitios
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final SitiosEntity sitiosEntity = sitios.get(position);
        OriginalViewHolder view = (OriginalViewHolder) holder;
        view.nombre.setText(sitiosEntity.nombre+"");
        view.descripcion.setText(sitiosEntity.descripcion);
        if(!sitiosEntity.getImagen().isEmpty()){
            Glide.with(ctx)
                    .load(sitiosEntity.getImagen())
                    .fitCenter()
                    .into(view.imagenSitio);
        }
        view.lyt_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListener!=null){
                    mOnItemClickListener.onItemClick(v,sitios.get(position),position);
                }
            }
        });
    }

    public interface OnItemClickListener{
        void onItemClick(View view, SitiosEntity sitiosEntity, int pos);
    }



    @Override
    public int getItemCount() {
        return sitios.size();
    }
}
