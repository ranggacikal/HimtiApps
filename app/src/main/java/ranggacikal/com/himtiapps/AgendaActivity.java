package ranggacikal.com.himtiapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import ranggacikal.com.himtiapps.adapter.AgendaAdapter;
import ranggacikal.com.himtiapps.api.ApiService;
import ranggacikal.com.himtiapps.api.ConfigRetrofit;
import ranggacikal.com.himtiapps.model.DataAgendaItem;
import ranggacikal.com.himtiapps.model.ResponseAgenda;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgendaActivity extends AppCompatActivity {

    RecyclerView rvAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        rvAgenda = findViewById(R.id.recyclerAgenda);

        ApiService apiService = ConfigRetrofit.retrofit.create(ApiService.class);
        Call<ResponseAgenda> callAgenda = apiService.tampilAgenda();
        callAgenda.enqueue(new Callback<ResponseAgenda>() {
            @Override
            public void onResponse(Call<ResponseAgenda> call, Response<ResponseAgenda> response) {
                int statusAgenda = response.body().getStatus();

                if (statusAgenda == 1){
                    List<DataAgendaItem> dataAgendaItemList = response.body().getDataAgenda();
                    AgendaAdapter agendaAdapter = new AgendaAdapter(AgendaActivity.this, dataAgendaItemList);
                    rvAgenda.setAdapter(agendaAdapter);
                    rvAgenda.setLayoutManager(new LinearLayoutManager(AgendaActivity.this));
                }else{
                    Toast.makeText(AgendaActivity.this, "Data Tidak Ada", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAgenda> call, Throwable t) {
                Toast.makeText(AgendaActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
