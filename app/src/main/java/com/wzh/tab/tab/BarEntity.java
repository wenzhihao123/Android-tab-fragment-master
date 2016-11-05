package com.wzh.tab.tab;

/**
 * Created by zhihao.wen on 2016/11/4.
 * 底部tab的实体类
 */

public class BarEntity {
    /**
     * 导航菜单文字
     */
    private String tabText;
    /**
     * 选中后的tab的图片
     */
    private int tabSelectedResId ;
    /**
     * 未选中时图片
     */
    private int tabUnSelectedResId ;

    public BarEntity(String tabText, int tabSelectedResId, int tabUnSelectedResId) {
        this.tabText = tabText;
        this.tabSelectedResId = tabSelectedResId;
        this.tabUnSelectedResId = tabUnSelectedResId;
    }

    public String getTabText() {
        return tabText;
    }

    public void setTabText(String tabText) {
        this.tabText = tabText;
    }

    public int getTabSelectedResId() {
        return tabSelectedResId;
    }

    public void setTabSelectedResId(int tabSelectedResId) {
        this.tabSelectedResId = tabSelectedResId;
    }

    public int getTabUnSelectedResId() {
        return tabUnSelectedResId;
    }

    public void setTabUnSelectedResId(int tabUnSelectedResId) {
        this.tabUnSelectedResId = tabUnSelectedResId;
    }
}

