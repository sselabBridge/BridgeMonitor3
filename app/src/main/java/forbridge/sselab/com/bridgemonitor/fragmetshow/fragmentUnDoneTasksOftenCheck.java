package forbridge.sselab.com.bridgemonitor.fragmetshow;

/**
 * Created by Administrator on 2017/10/11.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import forbridge.sselab.com.bridgemonitor.R;

public class fragmentUnDoneTasksOftenCheck extends Fragment{
    public fragmentUnDoneTasksOftenCheck(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.detail_content_undonetask_oftencheck,container,false);
        return rootView;
    }
}
