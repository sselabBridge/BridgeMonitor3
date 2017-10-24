package forbridge.sselab.com.bridgemonitor.fragmetshow;

/**
 * Created by Administrator on 2017/10/11.
 */

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import forbridge.sselab.com.bridgemonitor.DataBaseHelper;
import forbridge.sselab.com.bridgemonitor.MyAdapter;
import forbridge.sselab.com.bridgemonitor.R;

public class fragmentAllTasks extends Fragment{
    public fragmentAllTasks(){

    }

    DataBaseHelper helper;
    private ListView listView;
    private Button addButton;
    private Button editButton;
    private Button deleteButton;
    private ArrayList<String> list1;
    private ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
    private EditText editText1,editText2,editText3,editText4,editText5;
    private EditText editText6,editText7,editText8,editText9;
    private View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.detail_content_alltask,container,false);
        this.root = rootView;
        listView = (ListView) root.findViewById(R.id.listview);
        addButton = (Button) root.findViewById(R.id.add);
        editButton = (Button) root.findViewById(R.id.edit);
        deleteButton = (Button) root.findViewById(R.id.delete);
        initEditText();
        File file = getContext().getFilesDir();
        String path = file.getAbsolutePath()+"/trade.db";
        ArrayList<String> list = new ArrayList<String>();
        list.add("任务序号");
        list.add("桥梁编号");
        list.add("桥梁名称");
        list.add("路线名称");
        list.add("路线类型");
        list.add("中心桩号");
        list.add("任务状态");
        list.add("执行任务");
        list.add("完成任务时间");
        lists.add(list);
        helper = new DataBaseHelper(getContext(), path, 1);
        final SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from trade", null);
        while (cursor.moveToNext()) {
            //"create table trade(_id integer primary key autoincrement,serialNo,money,cardNum,date,status)";
            list1 = new ArrayList<String>();
            list1.add(cursor.getString(cursor.getColumnIndex("_id")));
            list1.add(cursor.getString(cursor.getColumnIndex("bridgeNo")));
            list1.add(cursor.getString(cursor.getColumnIndex("bridgeName")));
            list1.add(cursor.getString(cursor.getColumnIndex("routeName")));
            list1.add(cursor.getString(cursor.getColumnIndex("routeStatus")));
            list1.add(cursor.getString(cursor.getColumnIndex("centerNo")));
            list1.add(cursor.getString(cursor.getColumnIndex("taskStatus")));
            list1.add(cursor.getString(cursor.getColumnIndex("executeTask")));
            list1.add(cursor.getString(cursor.getColumnIndex("time")));

            lists.add(list1);
        }
        cursor.close();
        MyAdapter adapter = new MyAdapter(getContext(), lists);
        listView.setAdapter(adapter);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    db.execSQL("insert into trade values(?,?,?,?,?,?,?,?,?)",
                            new Object[]{Integer.valueOf(editText1.getText().toString()).intValue(),
                                    editText2.getText().toString(),
                                    editText3.getText().toString(),
                                    editText4.getText().toString(),
                                    editText5.getText().toString(),
                                    editText6.getText().toString(),
                                    editText7.getText().toString(),
                                    editText8.getText().toString(),
                                    editText9.getText().toString(),});
                }catch (Exception e){
                    Toast.makeText(getContext(), "添加失败，请检查任务序号", Toast.LENGTH_LONG).show();
                }
                Refresh();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("toRemove",editText1.getText().toString());
                int toRemove = Integer.valueOf(editText1.getText().toString()).intValue();

                Log.e("toRemove",String.valueOf(toRemove));
                try {
                    db.execSQL("delete from trade where _id=?", new Object[]{toRemove});
                }catch (Exception e){
                    Log.e("delete","删除失败，请检查任务序号");
                    Toast.makeText(getContext(), "删除失败，请检查任务序号", Toast.LENGTH_LONG).show();
                }
                Refresh();
            }
        });
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int toEdit = Integer.valueOf(editText1.getText().toString()).intValue();
                //lists.remove(toEdit);
                try {
                    db.execSQL("update trade set bridgeNo=?,bridgeName=?,routeName=?," +
                                    "routeStatus=?,centerNo=?,taskStatus=?,executeTask=?,time=?" +
                                    "where _id=?",
                            new Object[]{editText2.getText().toString(),
                                    editText3.getText().toString(),
                                    editText4.getText().toString(),
                                    editText5.getText().toString(),
                                    editText6.getText().toString(),
                                    editText7.getText().toString(),
                                    editText8.getText().toString(),
                                    editText9.getText().toString(),
                                    toEdit});
                }catch (Exception e){
                    Log.e("update","修改失败，请检查任务序号");
                    Toast.makeText(getContext(), "修改失败，请检查任务序号", Toast.LENGTH_LONG).show();
                }
                Refresh();
            }
        });
        return rootView;
    }

    public void initEditText(){
        editText1 = (EditText) root.findViewById(R.id.TaskNo);
        editText2 = (EditText) root.findViewById(R.id.BridgeNo);
        editText3 = (EditText) root.findViewById(R.id.BridgeName);
        editText4 = (EditText) root.findViewById(R.id.RouteName);
        editText5 = (EditText) root.findViewById(R.id.RouteStatus);
        editText6 = (EditText) root.findViewById(R.id.CenterNo);
        editText7 = (EditText) root.findViewById(R.id.TaskStatus);
        editText8 = (EditText) root.findViewById(R.id.ExecTask);
        editText9 = (EditText) root.findViewById(R.id.Time);
    }

    public void Refresh(){
        FragmentManager fm_alltasks = getFragmentManager();
        FragmentTransaction MfragmentTransaction1 = fm_alltasks.beginTransaction();
        fragmentAllTasks fat = new fragmentAllTasks();
        if(fm_alltasks.findFragmentById(R.id.fragmentForshow)==null){
            MfragmentTransaction1.add(R.id.fragmentForshow,fat);
        }else {
            MfragmentTransaction1.replace(R.id.fragmentForshow,fat);
        }
        MfragmentTransaction1.commit();
    }
}
