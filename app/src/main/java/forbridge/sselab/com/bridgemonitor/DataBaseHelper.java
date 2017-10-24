package forbridge.sselab.com.bridgemonitor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

	public DataBaseHelper(Context context, String name, int version) {
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}
	String sql = "create table trade(_id integer primary key autoincrement," +
			"bridgeNo,bridgeName,routeName,routeStatus,centerNo,taskStatus,executeTask,time)";
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(sql);
		db.execSQL("insert into trade values(1,?,?,?,?,?,?,?,?)",
				new String[]{"A001","1#桥","G32","L","91100.00","未完成","进入",null} );
		db.execSQL("insert into trade values(2,?,?,?,?,?,?,?,?)",
				new String[]{"A002","2#桥","G32","R","91100.00","未完成","进入",null} );
		db.execSQL("insert into trade values(3,?,?,?,?,?,?,?,?)",
				new String[]{"A003","3#桥","G32","Z","91100.00","已完成","进入","2017/9/20 15:00"} );
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
