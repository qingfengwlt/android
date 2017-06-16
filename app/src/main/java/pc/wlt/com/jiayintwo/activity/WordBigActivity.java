package pc.wlt.com.jiayintwo.activity;

import android.app.Activity;
import android.os.Bundle;

import pc.wlt.com.jiayintwo.R;
import pc.wlt.com.jiayintwo.common.utils.DisplayUtils;

public class WordBigActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_big);
        DisplayUtils.init(getBaseContext());
    }
 }
