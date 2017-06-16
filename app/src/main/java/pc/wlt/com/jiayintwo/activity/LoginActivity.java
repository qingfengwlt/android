package pc.wlt.com.jiayintwo.activity;

import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import pc.wlt.com.jiayintwo.MPresenter;
import pc.wlt.com.jiayintwo.MView;
import pc.wlt.com.jiayintwo.R;
import pc.wlt.com.jiayintwo.base.BaseAppCompatActivity;
import pc.wlt.com.jiayintwo.common.utils.RetrofitManager;
import pc.wlt.com.jiayintwo.common.utils.ToolUtil;
import pc.wlt.com.superlibrary.utils.L;
import retrofit2.Call;

public class LoginActivity extends BaseAppCompatActivity implements MView{

    @BindView(R.id.btn_test)
    Button mTvTest;

    MPresenter mPresenter;
    @Override
    protected int resId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        mPresenter=new MPresenter(this);
    }

    @OnClick(R.id.btn_test)
    void onClick(View view) {
        Map map=new HashMap<String,String>();
        map.put("xsid","100011");
        Call call= RetrofitManager.getInstance().test(ToolUtil.getRequesBody(map));
        mPresenter.loadData(call,0);

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showLoadFailMsg(String msg) {
        L.e(TAG,""+msg);
    }

    @Override
    public void refreshData(String response, int position) {
        L.e(TAG,""+response);
    }


}
