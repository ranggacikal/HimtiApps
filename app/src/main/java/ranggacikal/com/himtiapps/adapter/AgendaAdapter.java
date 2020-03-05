package ranggacikal.com.himtiapps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ranggacikal.com.himtiapps.R;
import ranggacikal.com.himtiapps.model.DataAgendaItem;

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.AgendaViewHolder> {

    private List<DataAgendaItem> mDataAgendaItems;
    private Context mcontext;

    public AgendaAdapter(Context context, List<DataAgendaItem> dataAgendaItems){
        this.mcontext = context;
        this.mDataAgendaItems = dataAgendaItems;
    }

    @NonNull
    @Override
    public AgendaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_agenda, parent, false);
        return new AgendaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AgendaViewHolder holder, int position) {
        final String urlImageAgenda = mDataAgendaItems.get(position).getLinkGambarAgenda();

        Glide.with(mcontext)
                .load(urlImageAgenda)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.imgAgenda);

        holder.txtNamaAgenda.setText(mDataAgendaItems.get(position).getNamaAgenda());
        holder.txtTanggal.setText(mDataAgendaItems.get(position).getTanggalAgenda());
        holder.txtTempatAgenda.setText(mDataAgendaItems.get(position).getTempatAgenda());
    }

    @Override
    public int getItemCount() {
        return mDataAgendaItems.size();
    }

    public class AgendaViewHolder extends RecyclerView.ViewHolder {

        ImageView imgAgenda;
        TextView txtNamaAgenda, txtTempatAgenda, txtTanggal;
        public AgendaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAgenda = itemView.findViewById(R.id.imageGambarAgenda);
            txtNamaAgenda = itemView.findViewById(R.id.textNamaAgenda);
            txtTempatAgenda = itemView.findViewById(R.id.textTempatAgenda);
            txtTanggal = itemView.findViewById(R.id.textTanggalAgenda);
        }
    }
}
