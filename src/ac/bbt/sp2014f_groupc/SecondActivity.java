package ac.bbt.sp2014f_groupc;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
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
			
			return rootView;
		}
		
        // クリックリスナー定義
     	class ButtonClickListener implements OnClickListener {
     		// onClickメソッド(ボタンクリック時イベントハンドラ)
     		public void onClick(View v) {
     			//タグの取得
 				String tag = (String)v.getTag();
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
