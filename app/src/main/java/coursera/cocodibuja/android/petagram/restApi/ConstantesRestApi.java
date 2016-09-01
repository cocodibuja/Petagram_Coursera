package coursera.cocodibuja.android.petagram.restApi;

/**
 * Created by nicopro on 30/8/16.
 */
public final class ConstantesRestApi {

    // es final por que son constante

    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "3687996825.ce605dc.35f2a1f7a7614d84ba72777d40d5b535";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String KEY_SEARCH_MEDIA_1 = "users/search?q=";
    public static final String KEY_SEARCH_MEDIA_2 = "&access_token="+ConstantesRestApi.ACCESS_TOKEN;
    public static final String KEY_USERID_MEDIA_1 = "users/";
    public static final String KEY_USERID_MEDIA_2 = "/media/recent/?access_token="+ACCESS_TOKEN;




}
