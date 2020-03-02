package ranggacikal.com.himtiapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import ranggacikal.com.himtiapps.adapter.JadwalSharingAdapter;
import ranggacikal.com.himtiapps.api.ApiService;
import ranggacikal.com.himtiapps.api.ConfigRetrofit;
import ranggacikal.com.himtiapps.model.DataJadwalSharingItem;
import ranggacikal.com.himtiapps.model.ResponseJadwalSharing;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalSharingActivity extends AppCompatActivity {

    RecyclerView recyclerViewSharing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_sharing);

        recyclerViewSharing = findViewById(R.id.rv_sharing);

        ApiService apiService = ConfigRetrofit.retrofit.create(ApiService.class);
        Call<ResponseJadwalSharing> call = apiService.tampilJadwalSharing();
        call.enqueue(new Callback<ResponseJadwalSharing>() {
            @Override
            public void onResponse(Call<ResponseJadwalSharing> call, Response<ResponseJadwalSharing> response) {
                int status = response.body().getStatus();

                if (status==1){
                    List<DataJadwalSharingItem> dataJadwalSharingItems = response.body().getDataJadwalSharing();
                    JadwalSharingAdapter sharingAdapter = new JadwalSharingAdapter(JadwalSharingActivity.this, dataJadwalSharingItems);
                    recyclerViewSharing.setAdapter(sharingAdapter);
                    recyclerViewSharing.setLayoutManager(new LinearLayoutManager(JadwalSharingActivity.this));
                }else{
                    Toast.makeText(JadwalSharingActivity.this, "Data Tidak Ada", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseJadwalSharing> call, Throwable t) {
                Toast.makeText(JadwalSharingActivity.this, "PERIKSA JARINGAN ANDA", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
