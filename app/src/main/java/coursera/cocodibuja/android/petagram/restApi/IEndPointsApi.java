package coursera.cocodibuja.android.petagram.restApi;

import coursera.cocodibuja.android.petagram.restApi.modelo.MascotaPerfilResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nicopro on 30/8/16.
 */
public interface IEndPointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaPerfilResponse> getRecentMedia();

    /*
    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<ContactoResponse> getRecentMedia();

    @GET(ConstantesRestApi.KEY_USERID_MEDIA_1+"{id}"+ConstantesRestApi.KEY_USERID_MEDIA_2)
    Call<ContactoResponse> getUserIDMedia(@Path("id") String id);

    @GET(ConstantesRestApi.KEY_SEARCH_MEDIA_1+"username"+ConstantesRestApi.KEY_SEARCH_MEDIA_2)
    Call<ContactoResponse> getUserNameID(@Query("q") String username);
    */
}
