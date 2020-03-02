package ranggacikal.com.himtiapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailSharingActivity extends AppCompatActivity {

    public static final String EXTRA_IMAGE_SHARING = "extra_image_sharing";
    public static final String EXTRA_JUDUL_SHARING = "extra_judul_sharing";
    public static final String EXTRA_WAKTU_SHARING = "extra_waktu_sharing";
    public static final String EXTRA_BAHASA_SHARING = "extra_bahasa_sharing";
    public static final String EXTRA_DETAIL_SHARING = "extra_detail_sharing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sharing);

        TextView txtJudulSharing = findViewById(R.id.TextDetailJudulSharing);
        TextView txtWaktuSharing = findViewById(R.id.TextDetailWaktu);
        TextView txtBahasa = findViewById(R.id.TextDetailBahasaPemrograman);
        TextView txtDetail = findViewById(R.id.TextDetail);
        ImageView imgDetail = findViewById(R.id.ImgDetailSharing);

        String LinkGambarSharing = getIntent().getStringExtra(EXTRA_IMAGE_SHARING);
        String JudulSharing = getIntent().getStringExtra(EXTRA_JUDUL_SHARING);
        String WaktuSharing = getIntent().getStringExtra(EXTRA_WAKTU_SHARING);
        String BahasaSHaring = getIntent().getStringExtra(EXTRA_BAHASA_SHARING);
        String DetailSharing = getIntent().getStringExtra(EXTRA_DETAIL_SHARING);

        Glide.with(DetailSharingActivity.this)
                .load(LinkGambarSharing)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imgDetail);
        txtJudulSharing.setText(JudulSharing);
        txtWaktuSharing.setText(WaktuSharing);
        txtBahasa.setText(BahasaSHaring);
        txtDetail.setText(DetailSharing);
    }
}
