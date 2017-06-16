package pc.wlt.com.jiayintwo;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import pc.wlt.com.jiayintwo.activity.ListActivity;
import pc.wlt.com.jiayintwo.base.BaseAppCompatActivity;
import pc.wlt.com.jiayintwo.common.utils.ToastUtils;
import pc.wlt.com.jiayintwo.httpUitls.HttpUtil;
import pc.wlt.com.jiayintwo.interfaces.OnResponseListener;

public class MainActivity extends BaseAppCompatActivity {

    @BindView(R.id.tv_main_test)
    TextView mTvTest;
    @BindView(R.id.btn_main_test)
    Button mBtnTest;
    @BindView(R.id.edt_main_word)
    EditText mEdtWord;

    String url="http://dict-co.iciba.com/api/dictionary.php?";
    @Override
    protected int resId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mTvTest.setText("测试butterKnife");
        mBtnTest.setText("button");
    }
    @OnClick({R.id.tv_main_test, R.id.btn_main_test})
    void onClick(View v){
        switch (v.getId()){
            case R.id.tv_main_test:
                ToastUtils.showToast(this,"tv");
                break;
            case R.id.btn_main_test:
                openActivity(ListActivity.class);
                break;
        }
    }

    void getData(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HashMap map=new HashMap<String,String>();
                map.put("w",mEdtWord.getText().toString().trim());
                map.put("type","json");
                map.put("key","E0FC9F9D320339857E9AE68FA7167AA3");

                HttpUtil.requestGet(url, map, new OnResponseListener() {
                    @Override
                    public void onSuccess(int code, final String str) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mTvTest.setText(str);
                            }
                        });
                    }

                    @Override
                    public void onFail(int code, Exception e) {

                    }
                });
            }
        }).start();

    }
    void request(){
        RequestParams params = new RequestParams(url);
        params.addQueryStringParameter("w",mEdtWord.getText().toString().trim());
        params.addQueryStringParameter("type","json");
        params.addQueryStringParameter("key","E0FC9F9D320339857E9AE68FA7167AA3");
        org.xutils.common.Callback.Cancelable cancelable=x.http().get(params, new org.xutils.common.Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "onSuccess result:" + result);
                mTvTest.setText(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled"+cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e(TAG, " onFinished" );
            }
        });

        cancelable.cancel();
    }
//    private void requestData() {
//        Map map=new HashMap<String,String>();
//        map.put("w",mEdtWord.getText().toString().trim());
//        map.put("type","json");
//        map.put("key","E0FC9F9D320339857E9AE68FA7167AA3");
//        Call call= RetrofitManager.getInstance().getData("hello",map.get(""));
//        call.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//                Log.e(TAG,"onResponse");
//                response.body().toString();
//                String json=response.message().toString();
//                mTvTest.setText(json);
//                Log.d(TAG,"json="+json);
//                call.cancel();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                Log.e(TAG,"onResponse");
//            }
//        });
//    }
}
