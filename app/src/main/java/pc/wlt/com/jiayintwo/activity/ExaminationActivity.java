package pc.wlt.com.jiayintwo.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import pc.wlt.com.jiayintwo.R;
import pc.wlt.com.jiayintwo.base.BaseAppCompatActivity;
import pc.wlt.com.jiayintwo.fragment.CombinationSelectionFG;
import pc.wlt.com.jiayintwo.fragment.MultipleSelectionFG;
import pc.wlt.com.jiayintwo.fragment.RecordSelecitonFG;
import pc.wlt.com.jiayintwo.fragment.SingleSelectionFG;
import pc.wlt.com.jiayintwo.fragment.WordSelecitonFG;
import pc.wlt.com.superlibrary.adapter.ComFragmentAdapter;

/***
 * 答题页面
 */
public class ExaminationActivity extends BaseAppCompatActivity {

    @BindView(R.id.vp_examination)
    ViewPager mVP;

    ComFragmentAdapter mAdapter;
    Fragment testFragment;

    @BindView(R.id.toolbar_title)
    TextView mTitle;
    @BindView(R.id.title_examination_toolbar)
    Toolbar mToolBar;
    @Override
    protected int resId() {
        return R.layout.activity_examination;
    }

    @Override
    protected void initData() {
        //actionbar设置为空 配置文件中不起作用
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);
        //设置返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mTitle.setText(""+this.getClass().getSimpleName());
        String[] strings={"a","b","c","D","E"};
        mAdapter=new ComFragmentAdapter(getSupportFragmentManager(),strings) {
            @Override
            public Fragment getItem(int postion) {
                switch (postion){
                    case 0:
                        testFragment= new SingleSelectionFG();
                        break;
                    case 1:
                        testFragment= new MultipleSelectionFG();
                        break;
                    case 2:
                        testFragment= new RecordSelecitonFG();
                        break;
                    case 3:
                        testFragment= new WordSelecitonFG();
                        break;
                    case 4:
                        testFragment= new CombinationSelectionFG();
                        break;
                }


                return testFragment;
            }
        };
        mVP.setAdapter(mAdapter);
    }

     
}
