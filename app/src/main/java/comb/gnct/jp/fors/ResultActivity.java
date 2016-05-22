package comb.gnct.jp.fors;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    CollapsingToolbarLayout toolbarLayout;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /* ヘッダー部分の設定 */
        toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle("あなたのスポーツ計画書");
        toolbarLayout.setBackground(ContextCompat.getDrawable(this, R.drawable.tabletennis));

        /* メインコンテンツの設定 */
        ArrayList<ResultRow> rows = new ArrayList<>();
        rows.add(new ResultRow(ContextCompat.getDrawable(this, android.R.drawable.ic_menu_my_calendar),"日付","2016/05/20"));
        rows.add(new ResultRow(ContextCompat.getDrawable(this, android.R.drawable.ic_lock_idle_alarm),"時間","18:00-20:00"));
        rows.add(new ResultRow(ContextCompat.getDrawable(this, android.R.drawable.ic_dialog_map),"場所","○×体育館"));
        rows.add(new ResultRow(ContextCompat.getDrawable(this, R.drawable.accessibility),"種目","卓球"));

        RecyclerView.Adapter adapter = new ResultAdapter(this,rows);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
