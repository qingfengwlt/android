package pc.wlt.com.jiayintwo.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import pc.wlt.com.jiayintwo.R;
import pc.wlt.com.jiayintwo.base.BaseAppCompatActivity;
import pc.wlt.com.superlibrary.common.CommonAdapter;
import pc.wlt.com.superlibrary.common.CommonViewHolder;

/**
 * 列表
 */
public class ListActivity extends BaseAppCompatActivity {

    @BindView(R.id.lv_list_listView)
    ListView mLv;
    CommonAdapter mAdapter;
    @Override
    protected int resId() {
        return R.layout.activity_list;
    }

    @Override
    protected void initData() {
        List list=new ArrayList<String>();
        list.add("speech");
        list.add("wave");
        list.add("wordView");
        list.add("speechEvaluator");
        list.add("QR");
        list.add("TextDecorator");
        list.add("WordColorDrawing");
        list.add("BaseCountDownTimer");
        list.add("waveView");
        list.add("Examination");
        list.add("okhttp");
        list.add("login");
        for (int i=0;i<30;i++){
            list.add("item"+i);
        }
        mAdapter=new CommonAdapter<String>(this,list,R.layout.item_list) {
            @Override
            public void setViewContent(CommonViewHolder holder, String o) {
                holder.setText(R.id.tv_list_item,o.toString());

            }
        };
        mLv.setAdapter(mAdapter);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        openActivity(SpeechActivity.class);
                        break;
                    case 1:
                        openActivity(WaveActivity.class);
                        break;
                    case 2:
                        openActivity(WordViewActivity.class);
                        break;
                    case 3:
                        openActivity(SpeechEvaluatorActivity.class);
                        break;
                    case 4:
                        openActivity(QRActivity.class);
                        break;
                    case 5:
                        openActivity(TextDecoratorActivity.class);
                        break;
                    case 6:
                        openActivity(WordColorDrawingActivity.class);
                        break;
                    case 7:
                        openActivity(BaseCountDownTimerActivity.class);
                        break;
                    case 8:
                        openActivity(WaveViewActivity.class);
                        break;
                    case 9:
                        openActivity(ExaminationActivity.class);
                        break;
                    case 10:
                        openActivity(OKHttpActivity.class);
                        break;
                    case 11:
                        openActivity(LoginActivity.class);
                        break;

                }
            }
        });
    }
}
