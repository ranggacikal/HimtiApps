package ranggacikal.com.himtiapps;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import ranggacikal.com.himtiapps.helper.UrlGambar;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private SliderLayout mSlider;
    private RelativeLayout rl_infosharing, rl_agenda, rl_keanggotaan, rl_berita, rl_info_kampus, rl_modul;
    Context context;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        rl_infosharing = view.findViewById(R.id.rl_info_sharing);
        rl_agenda = view.findViewById(R.id.rl_agenda);
        rl_keanggotaan = view.findViewById(R.id.rl_keanggotaan);
        rl_berita = view.findViewById(R.id.rl_berita);
        rl_info_kampus = view.findViewById(R.id.rl_info_kampus);
        rl_modul = view.findViewById(R.id.rl_modul);


        mSlider = view.findViewById(R.id.slider);
        initSlider();

        rl_infosharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent jadwalSharing = new Intent(getActivity(), JadwalSharingActivity.class);
                startActivity(jadwalSharing);
            }
        });



        return view;
    }



    private void initSlider() {
        HashMap<String, String> urlmaps = new HashMap<>();
        urlmaps.put("HIMTI UMT", UrlGambar.URL_SLider+"logo_himti.png");
        urlmaps.put("FT INFORMATIKA UMT", UrlGambar.URL_SLider+"logo_umt_informatika.png");
        urlmaps.put("Universitas Muhammadiyah Tangerang", UrlGambar.URL_SLider+"img_umt.jpg");

        for(String name : urlmaps.keySet()){
            TextSliderView textSlider = new TextSliderView(getContext());

            textSlider.description(name)
                    .image(urlmaps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSlider.bundle(new Bundle());
            textSlider.getBundle().putString("extra", name);

            mSlider.addSlider(textSlider);
        }

        mSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Right_Top);
        mSlider.setCustomAnimation(new DescriptionAnimation());
        mSlider.setDuration(3000);
        mSlider.addOnPageChangeListener(this);

    }

    @Override
    public void onStop() {
        mSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
