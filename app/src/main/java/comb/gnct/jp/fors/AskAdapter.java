package comb.gnct.jp.fors;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kano on 2016/05/20.
 */

public class AskAdapter extends  RecyclerView.Adapter<AskAdapter.ViewHolder>{

    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<String> mData;
    boolean mIsHeader;

    public AskAdapter(Context context, ArrayList<String> data){
        super();
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mData = data;
        mIsHeader = true;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if(mIsHeader){
             v = mLayoutInflater.inflate(R.layout.header_row_ask, parent, false);
            mIsHeader = false;
        }else{
            v = mLayoutInflater.inflate(R.layout.row_ask, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(v,mContext);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /* 値を代入したりする処理 */
        holder.textView.setText(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }




    public interface OnItemClickListener{
        public void onClick(View v);
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;
        CheckBox checkBox;
        Context context;
        View rootView;

        public ViewHolder(View v,Context context) {
            super(v);
            rootView = v;
            textView = (TextView) v.findViewById(R.id.textView);
            checkBox = (CheckBox) v.findViewById(R.id.checkBox);
            this.context = context;
            if(checkBox==null){
                /* headerに対する処理 */
                textView.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary)); /* 色を付ける */
            }else{
                /* ヘッダー以外に対する処理 */
                v.setOnClickListener(this); /* クリックを有効にする */
            }


        }


        @Override
        public void onClick(View view) {
            /* 押されたときの処理 */
            checkBox.setChecked(checkBox.isChecked()); /* チェックボックスを有効にする */
            rootView.setBackgroundColor(ContextCompat.getColor(context,R.color.colorGray));
        }
    }



}
