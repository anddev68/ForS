package comb.gnct.jp.fors;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Fragment creator.
 * A question
 *
 * Created by chrome on 16/05/20.
 */
public class AskActivityFragmentFactory {

    private ArrayList<ArrayList<String>> mData;

    public AskActivityFragmentFactory(){
        mData = new ArrayList<>();
        mData.add(strings("それはボールを使う？","使う","使わない","どちらでもよい"));
        mData.add(strings("何人くらい？","少人数","中規模","大規模"));
        mData.add(strings("いつ？","仕事・学校帰り","休日","いつでも","いますぐ"));
    }

    public AskActivityFragment getFragment(int pageNum){
        if(mData.size()<=pageNum) return null;
        return AskActivityFragment.newInstance(mData.get(pageNum));
    }

    private ArrayList<String> strings(String... strings){
        ArrayList<String> r = new ArrayList<String>();
        for(String str : strings){
            r.add(str);
        }
        return r;
    }



}

