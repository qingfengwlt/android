package pc.wlt.com.jiayintwo.interfaces;


import pc.wlt.com.jiayintwo.enity.ComBean;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by PC_WLT on 2017/4/26.
 */

public interface AppAPI {

    public final String BASE_URL_ROOT="https://api.github.com/";
    @GET("word")
    Call<ComBean> getData(@Body ComBean word);

}
