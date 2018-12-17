package xyz.zhangzibao.myqmui;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.qmuiteam.qmui.layout.QMUIButton;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/com/Activity1")
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.test1)
    QMUIRoundButton qmuiButton;
    @BindView(R.id.test2)
    QMUIRoundButton qmuiButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
        ButterKnife.bind(this, root);
        initTopBar();
        setContentView(root);

    }

    private void initTopBar() {
        mTopBar.setBackgroundColor(ContextCompat.getColor(this, R.color.app_color_theme_4));
        QMUIStatusBarHelper.translucent(this);
        mTopBar.setTitle("沉浸式状态栏示例");
        qmuiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/com/Activity2").navigation();
            }
        });
        qmuiButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/com/Activity3").navigation();
            }
        });
    }

}
