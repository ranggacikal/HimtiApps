package ranggacikal.com.himtiapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ranggacikal.com.himtiapps.DetailSharingActivity;
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
    public void onBindViewHolder(@NonNull JadwalSharingAdapter.MyViewHolder holder, final int position) {
        final String  urlImageSharing = mjadwalSharingList.get(position).getLinkGambarSharing();

        Glide.with(mcontext)
                .load(urlImageSharing)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.imgSharing);

        holder.txtJudulSharing.setText(mjadwalSharingList.get(position).getJudulSharing());
        holder.txtWaktuSharing.setText(mjadwalSharingList.get(position).getWaktuSharing());
        holder.txtBahasaPemrograman.setText(mjadwalSharingList.get(position).getBahasaPemrograman());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DetailJadwalSharing = new Intent(mcontext, DetailSharingActivity.class);
                DetailJadwalSharing.putExtra(DetailSharingActivity.EXTRA_IMAGE_SHARING, mjadwalSharingList.get(position).getLinkGambarSharing());
                DetailJadwalSharing.putExtra(DetailSharingActivity.EXTRA_JUDUL_SHARING, mjadwalSharingList.get(position).getJudulSharing());
                DetailJadwalSharing.putExtra(DetailSharingActivity.EXTRA_WAKTU_SHARING, mjadwalSharingList.get(position).getWaktuSharing());
                DetailJadwalSharing.putExtra(DetailSharingActivity.EXTRA_BAHASA_SHARING, mjadwalSharingList.get(position).getBahasaPemrograman());
                DetailJadwalSharing.putExtra(DetailSharingActivity.EXTRA_DETAIL_SHARING, mjadwalSharingList.get(position).getDetailSharing());
                mcontext.startActivity(DetailJadwalSharing);
            }
        });
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
