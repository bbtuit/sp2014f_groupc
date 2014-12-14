import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class CreateDataBaseHelper extends SQLiteOpenHelper {
	//　コンストラクタ定義
	public CreateDataBaseHelper(Context con) {
		//　SQLiteOpenHelperのコンストラクタ呼び出し
		super(con, "dbkabu", null, 1);
	}
	
	@Override
	public void onOpen(SQLiteDatabase db){
		super.onOpen(db);
	}
	
	// データベース作成時にテーブル作成
	//　onCreateメソッド
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE アラート設定テーブル (" +
				"アラートNO primary key," +
				"名称 text," +
				"銘柄コード integer," +
				"ボリバン計算期間 integer" +
				"ボリバントリガー値 integer," +
				"RSI計算期間 integer," +
				"RSIトリガー値 integer," +
				"ボリバンアラート有無 text," +
				"RSIアラート有無 text," +				
				"当日株価 integer");
	
		
		db.execSQL("CREATE TABLE アラート用株価テーブル (" +
				"アラートNO integer not null" +
				"日付 date not null," +
				"終値 integer not null," +
				"primary key(アラートNO, 日付)");		
	}

	//　onUpgradeメソッド
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
