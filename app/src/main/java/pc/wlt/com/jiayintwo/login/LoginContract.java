package pc.wlt.com.jiayintwo.login;

import pc.wlt.com.superlibrary.BasePresenter;
import pc.wlt.com.superlibrary.BaseView;

/**
 * Created by PC_WLT on 2017/5/26.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter>{
        void setTitle();
        void showData();
    }
    interface Presenter extends BasePresenter{
        void getData();
    }

}
