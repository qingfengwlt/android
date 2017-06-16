package pc.wlt.com.jiayintwo.activity;

import android.util.Log;

import pc.wlt.com.jiayintwo.R;
import pc.wlt.com.jiayintwo.base.BaseAppCompatActivity;
import pc.wlt.com.jiayintwo.common.utils.RetrofitManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OKHttpActivity extends BaseAppCompatActivity {


    @Override
    protected int resId() {
        return R.layout.activity_okhttp;
    }

    @Override
    protected void initData() {
//        requestData();
//        String url = "http://dict-co.iciba.com/api/dictionary.php?";
//        OkHttpUtils
//                .get()
//                .url(url)
//                .addParams("w", "hello")
//                .addParams("type","json")
//                .addParams("key","E0FC9F9D320339857E9AE68FA7167AA3")
//                .build()
//                .execute(new StringCallback() {
//                             @Override
//                             public void onError(okhttp3.Call call, Exception e, int id) {
//                                 Log.e(TAG,e.getMessage());
//                             }
//
//                             @Override
//                             public void onResponse(String response, int id) {
//                                 Log.e(TAG,response);
//
//                             }
//                         }
//                );
    }
    private void requestData() {
        String  auth="E0FC9F9D320339857E9AE68FA7167AA3";
        Call call= RetrofitManager.getInstance().getData("hello","json",auth);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.e(TAG,"onResponse");
                String json=response.body().toString();
//                mTvTest.setText(json);
                Log.d(TAG,"json="+json);
                call.cancel();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e(TAG,"onResponse");
            }
        });
    }
}
