package comb.gnct.jp.fors;

import android.graphics.drawable.Drawable;

/**
 * Created by kano on 2016/05/20.
 */
public class ResultRow {

    public Drawable icon;
    public String mainText;
    public String subText;

    public ResultRow(Drawable icon,String txt1,String txt2){
        this.icon = icon;
        this.mainText = txt1;
        this.subText = txt2;
    }

}
