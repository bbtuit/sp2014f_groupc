package ac.bbt.sp2014f_groupc;

import ac.bbt.sp2014f_groupc.MainActivity.PlaceholderFragment.ButtonClickListener;
import android.app.Activity;
import android.app.Fragment;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;





public class BoribanActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_boriban);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.boriban, menu);
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
		
		CreateDataBaseHelper helper = null;
		SQLiteDatabase db = null;
		
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_boriban,
					container, false);
			
            // キャンセルボタンのクリックリスナー定義
            Button bt_can2 = (Button)rootView.findViewById(R.id.bt_can2);
            bt_can2.setTag("bt_can2");
            bt_can2.setOnClickListener(new ButtonClickListener());
						
            //設定ボタンのクリックリスナー定義
            Button bt_set2 = (Button)rootView.findViewById(R.id.bt_set2);
            bt_set2.setTag("bt_set2");
            bt_set2.setOnClickListener(new ButtonClickListener());           
            
            //DB作成
            helper = new CreateDataBaseHelper(rootView.getContext());
                    
			return rootView;
		}
	}
}
