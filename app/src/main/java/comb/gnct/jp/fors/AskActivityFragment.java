package comb.gnct.jp.fors;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by chrome on 16/05/20.
 */
public class AskActivityFragment extends Fragment {

    OnFinishListener mOnFinishListener;
    ArrayList<String> mInitializer;

    public AskActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ask, container, false);

        RecyclerView.Adapter adapter = new AskAdapter(getActivity(),mInitializer);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        /* 現在はNextボタンが押されたら無条件で次の質問へ行くようにしています */
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnFinishListener.onFinish(null);
            }
        });

        return view;
    }






    /**
     * @param initializer
     * @return
     */
    public static AskActivityFragment newInstance(ArrayList<String> initializer){
        AskActivityFragment fragment = new AskActivityFragment();
        fragment.mInitializer = initializer;
        return fragment;
    }



    public void setOnFinishListener(OnFinishListener l){
        this.mOnFinishListener = l;
    }

    public interface OnFinishListener{
        void onFinish(String optionAnswer);
    }



}

