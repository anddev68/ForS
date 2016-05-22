package comb.gnct.jp.fors;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class AskActivity extends AppCompatActivity {

    int mPageCnt;
    AskActivityFragment mCurrentFragment;
    AskActivityFragmentFactory mFragmentFactory;
    AskActivityFragment.OnFinishListener mOnFinishListener = new AskActivityFragment.OnFinishListener() {
        @Override
        public void onFinish(String optionAnswer) {
            /* フラグメントから帰ってきた答えを使って何かしてくれ */
            nextFragment();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFragmentFactory = new AskActivityFragmentFactory();
        mPageCnt = -1; /* 0-index & add counter*/
        nextFragment();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // MenuInflater の取得
        MenuInflater menuInflater = getMenuInflater();
        // MenuInflater から XML の取得
        menuInflater.inflate(R.menu.menu_ask, menu);
        return true;
    }



    private void nextFragment(){
        mPageCnt++;
        mCurrentFragment = mFragmentFactory.getFragment(mPageCnt);
        if(mCurrentFragment!=null){
            /* fragment ready. */
            mCurrentFragment.setOnFinishListener(mOnFinishListener);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, mCurrentFragment)
                    .commit();
        }else{
            /* finish asking */
            Intent intent = new Intent(this,ResultActivity.class);
            startActivity(intent);
            finish();

        }



    }


}
