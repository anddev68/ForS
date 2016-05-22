package comb.gnct.jp.fors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kano on 2016/05/20.
 */

public class ResultAdapter extends  RecyclerView.Adapter<ResultAdapter.ViewHolder>{

    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<ResultRow> mData;

    public ResultAdapter(Context context,ArrayList<ResultRow> data){
        super();
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.row_result, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /* 値を代入したりする処理 */
        holder.imageView.setBackground(mData.get(position).icon);
        holder.textView.setText(mData.get(position).mainText);
        holder.textView2.setText(mData.get(position).subText);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;
        ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            // 2
            textView = (TextView) v.findViewById(R.id.textView);
            textView2 = (TextView) v.findViewById(R.id.textView2);
            imageView = (ImageView) v.findViewById(R.id.imageView);
        }
    }


}
