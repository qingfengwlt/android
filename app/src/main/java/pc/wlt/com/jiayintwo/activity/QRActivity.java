package pc.wlt.com.jiayintwo.activity;

import android.widget.ImageView;

import butterknife.BindView;
import pc.wlt.com.jiayintwo.R;
import pc.wlt.com.jiayintwo.base.BaseAppCompatActivity;
import pc.wlt.com.superlibrary.utils.QRCodeUtil;
import pc.wlt.com.superlibrary.utils.ScreenUtils;

/**
 * 生产二维码
 */
public class QRActivity extends BaseAppCompatActivity {

    @BindView(R.id.iv_qr)
    ImageView mIvQR;

    String path="http://47.93.45.118:8080/wanshida/file/app/mkapp.apk";
    @Override
    protected int resId() {
        return R.layout.activity_qr;
    }

    @Override
    protected void initData() {
        int width=ScreenUtils.getScreenWidth(this)-20;
        mIvQR.setImageBitmap(QRCodeUtil.createQRImage(path,width ,width));

    }
}
