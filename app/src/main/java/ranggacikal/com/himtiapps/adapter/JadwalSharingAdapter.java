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
import ranggacikal.com.himtiapps.model.DataJadwalSharingItem;

public class JadwalSharingAdapter extends RecyclerView.Adapter<JadwalSharingAdapter.MyViewHolder> {

    private List<DataJadwalSharingItem> mjadwalSharingList;
    private Context mcontext;

    public JadwalSharingAdapter(Context context, List<DataJadwalSharingItem> jadwalSharingList){
        this.mcontext = context;
        this.mjadwalSharingList = jadwalSharingList;
    }

    @NonNull
    @Override
    public JadwalSharingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_jadwal_sharing, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalSharingAdapter.MyViewHolder holder, int position) {
        final String  urlImageSharing = mjadwalSharingList.get(position).getLinkGambarSharing();

        Glide.with(mcontext)
                .load(urlImageSharing)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.imgSharing);

        holder.txtJudulSharing.setText(mjadwalSharingList.get(position).getJudulSharing());
        holder.txtWaktuSharing.setText(mjadwalSharingList.get(position).getWaktuSharing());
        holder.txtBahasaPemrograman.setText(mjadwalSharingList.get(position).getBahasaPemrograman());
    }

    @Override
    public int getItemCount() {
        return mjadwalSharingList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgSharing;
        TextView txtJudulSharing, txtWaktuSharing, txtBahasaPemrograman;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgSharing = itemView.findViewById(R.id.img_jadwal_sharing);
            txtJudulSharing = itemView.findViewById(R.id.text_judul_sharing);
            txtWaktuSharing = itemView.findViewById(R.id.text_tanggal_sharing);
            txtBahasaPemrograman = itemView.findViewById(R.id.text_bahasa_pemrograman);
        }
    }
}
