package ranggacikal.com.himtiapps.api;

import ranggacikal.com.himtiapps.model.ResponseAgenda;
import ranggacikal.com.himtiapps.model.ResponseJadwalSharing;
import ranggacikal.com.himtiapps.model.ResponseLogin;
import ranggacikal.com.himtiapps.model.ResponseRegister;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("Login")
    Call<ResponseLogin> Login(@Field("email") String email,
                              @Field("password") String password);

    @FormUrlEncoded
    @POST("Register_user")
    Call<ResponseRegister> Register(@Field("username") String username,
                                    @Field("nim") String nim,
                                    @Field("email") String email,
                                    @Field("password") String password);

    @GET("GetDataJadwalSharing")
    Call<ResponseJadwalSharing> tampilJadwalSharing();

    @GET("GetDataAgenda")
    Call<ResponseAgenda> tampilAgenda();
}
