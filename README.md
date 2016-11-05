# Android-tab-fragment-master
很多项目都会有那个到底部导航菜单，上面是Fragment相互切换，但是每次来项目都需要重新写一堆底部菜单栏布局及代码还有切换逻辑，
挺麻烦，所以索性写一个通用的这种底部导航栏切换的View,不用写布局、几句代码就可以实现底部菜单+Fragment切换,原理其实很简单就是利用动态创建布局的方式来添加我们的底部布局。
Activity内Fragment切换的逻辑也大大减少，看一下使用的样子！

![](http://p1.bqimg.com/567571/9a5d4e36bfe8e094.jpg)
![](http://p1.bqimg.com/567571/aa280019b6e32607.jpg)
```
<com.wzh.tab.tab.BottomTabBar
        android:id="@+id/tb"
        android:layout_width="match_parent"
        app:backgroundColor="@color/white"
        app:textColor="@color/font_color"
        app:textSelectColor="@color/colorAccent"
        android:layout_height="match_parent">

```
主布局只需要这一个就够了，其他都不用，这里自定义了几个属性，导航栏背景颜色、导航栏字体颜色以及切换时候的字体颜色！
```
 private void initView() {
        manager = getSupportFragmentManager();
        tb = (BottomTabBar) findViewById(R.id.tb);
        bars = new ArrayList<>();
        bars.add(new BarEntity("首页",R.drawable.home_select,R.drawable.home_unselect));
        bars.add(new BarEntity("图库",R.drawable.pic_select,R.drawable.pic_unselect));
        bars.add(new BarEntity("个人",R.drawable.person_select,R.drawable.person_unselect));
        tb.setManager(manager).setOnSelectListener(this).setBars(bars);
    }
```
Activity里面需要传递给BottomTabBar一个manager和BarEntity对象，并设置监听，在监听里切换fragment:
```
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
```
好了，这样就可以实现我们的底部导航菜单切换了~
详细了解的可以参考BottomTabBar源码，如有错误还望指出，谢谢！