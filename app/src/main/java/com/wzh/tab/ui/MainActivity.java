package com.wzh.tab.ui;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import com.wzh.tab.R;
import com.wzh.tab.tab.BarEntity;
import com.wzh.tab.tab.BottomTabBar;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements BottomTabBar.OnSelectListener{
    private BottomTabBar tb ;
    private List<BarEntity> bars ;
    private HomeFragment homeFragment ;
    private PicFragment picFragment ;
    private PersonFragment personFragment ;
    private FragmentManager manager ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        manager = getSupportFragmentManager();
        tb = (BottomTabBar) findViewById(R.id.tb);
        bars = new ArrayList<>();
        bars.add(new BarEntity("首页",R.drawable.home_select,R.drawable.home_unselect));
        bars.add(new BarEntity("图库",R.drawable.pic_select,R.drawable.pic_unselect));
        bars.add(new BarEntity("个人",R.drawable.person_select,R.drawable.person_unselect));
        tb.setManager(manager).setOnSelectListener(this).setBars(bars);
    }

    @Override
    public void onSelect(int position) {
        switch (position){
            case 0:
                if (homeFragment==null){
                    homeFragment = new HomeFragment();
                }
                tb.switchContent(homeFragment);
                break;
            case 1:
                if (picFragment==null){
                    picFragment = new PicFragment();
                }
                tb.switchContent(picFragment);
                break;
            case 2:
                if (personFragment==null){
                    personFragment = new PersonFragment();
                }
                tb.switchContent(personFragment);
                break;
            default:
                break;
        }
    }
}
