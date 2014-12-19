package ac.bbt.sp2014f_groupc;

import android.app.Fragment;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends FragmentActivity {


	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		


		
		// 現在のintentを取得する
		Intent intent = getIntent();
		// intentから指定のキーの文字列を取得する
		String alertNo = intent.getStringExtra("alertNo");		
        // 表示するテキストの設定
        String txt = "アラート" + alertNo;
		// トーストで確認（インテントで取得した文字列）
		//Toast.makeText(this, txt, Toast.LENGTH_LONG).show();  
		
		

		
		setContentView(R.layout.activity_second);	//　	ぬるぽ解消！！　(R.layout.Activity_second);　→　(R.layout.fragment_second);
		
        // IDからTextViewインスタンスを取得		
//		TextView tvalert = (TextView)findViewById(R.id.No);	//ぬるぽ解消！！
//        tvalert.setText(txt);	//ぬるぽ解消！！
        
        // ActivityにViewを設定
//        setContentView(tvalert);	//　ぬるぽ解消！！　　ここは、そもそも不要だった！	

		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		
		//ファイル名
		//private static final String FILE_NAME = "Alert_settings";

		CreateDataBaseHelper helper = null;
		SQLiteDatabase db = null;
		
		
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_second,
					container, false);
			
            // ボリンジャーバンド設定ボタンのクリックリスナー定義
            Button bt_boriban = (Button)rootView.findViewById(R.id.sect_e);
            bt_boriban.setTag("bt_boriban");
            bt_boriban.setOnClickListener(new ButtonClickListener());
            
            // ＲＳＩ設定ボタンのクリックリスナー定義
            Button bt_RSI = (Button)rootView.findViewById(R.id.sect_f);
            bt_RSI.setTag("bt_RSI");
            bt_RSI.setOnClickListener(new ButtonClickListener());
            
            // キャンセルボタンのクリックリスナー定義
            Button bt_can = (Button)rootView.findViewById(R.id.bt_can);
            bt_can.setTag("bt_can");
            bt_can.setOnClickListener(new ButtonClickListener());		
            
            // ＲＳＩ設定ボタンのクリックリスナー定義
            Button bt_set = (Button)rootView.findViewById(R.id.bt_set);
            bt_set.setTag("bt_set");
            bt_set.setOnClickListener(new ButtonClickListener());		            
            
            //DB作成
            helper = new CreateDataBaseHelper(rootView.getContext());
            
            
			
			return rootView;
		}
		
        // クリックリスナー定義
     	class ButtonClickListener implements OnClickListener {
     		// onClickメソッド(ボタンクリック時イベントハンドラ)
     		public void onClick(View v) {
     			
     			
     			//タグの取得
 				String tag = (String)v.getTag();
 				

		     			
		     		//キャンセルボタンが押された場合
		     		if(tag.equals("bt_can")){
		     			getActivity().finish();
		     			
		     		//登録ボタンが押された場合
		     		}else{
		     			
		     			//入力情報取得
		     			int alertNo = 1;
		     			EditText name=(EditText)getActivity().findViewById(R.id.alert);
		     			String Mcode="998407.O";
		     			
		     			//該当DBオブジェクト取得
		     			SQLiteDatabase db = helper.getReadableDatabase();
		     			try{
		     				//トランザクション制御開始
		     				db.beginTransaction();
		     				
		     				//登録データ設定
		     				ContentValues val = new ContentValues();
		     				val.put("アラートNO", alertNo);
		     				val.put("名称", name.toString());
		     				val.put("銘柄コード", Mcode);
		     				
		     				//データ登録
		     				db.insert("アラート設定テーブル", null, val);
		     				//コミット
		     				db.setTransactionSuccessful();
		     				//トランザクション制御終了
		     				db.endTransaction();		     				
		     			}catch(Exception e){
		     				
		     			}
		     			
						
					}
	 				
     				//ボリンジャーバンド設定ボタンが押された場合
	     			if(tag.equals("bt_boriban")){
		     			//　インテントの生成（呼び出すクラスの指定）
		     			Intent intent = new Intent(getActivity(),BoribanActivity.class);
		     			startActivity(intent);
	     			}
	     			
	     			//ＲＳＩ設定ボタンが押された場合
	     			if(tag.equals("bt_RSI")){
		     			//　インテントの生成（呼び出すクラスの指定）
		     			Intent intent = new Intent(getActivity(),RSIActivity.class);
		     			startActivity(intent);
     			}     			
     			
     		}
     	}
		
	}
}
