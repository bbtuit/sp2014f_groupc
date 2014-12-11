package ac.bbt.sp2014f_groupc;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    //    public void onclick(view v)
        
        
        
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            
            // アラート1ボタンのクリックリスナー定義
            Button button1 = (Button)rootView.findViewById(R.id.btn_1);
            button1.setTag("btn1");
            button1.setOnClickListener(new ButtonClickListener());
            
            // アラート2ボタンのクリックリスナー定義
            Button button2 = (Button)rootView.findViewById(R.id.btn_2);
            button2.setTag("btn2");
            button2.setOnClickListener(new ButtonClickListener());
            
            // アラート3ボタンのクリックリスナー定義
            Button button3= (Button)rootView.findViewById(R.id.btn_3);
            button3.setTag("btn3");
            button3.setOnClickListener(new ButtonClickListener());
       
            // アラート4ボタンのクリックリスナー定義
            Button button4 = (Button)rootView.findViewById(R.id.btn_4);
            button4.setTag("btn4");
            button4.setOnClickListener(new ButtonClickListener());
            
            // アラート5ボタンのクリックリスナー定義
            Button button5 = (Button)rootView.findViewById(R.id.btn_5);
            button5.setTag("btn5");
            button5.setOnClickListener(new ButtonClickListener());
            
            return rootView;    
        }
        
        // クリックリスナー定義
     	class ButtonClickListener implements OnClickListener {
     		// onClickメソッド(ボタンクリック時イベントハンドラ)
     		public void onClick(View v) {
     			//　インテントの生成（呼び出すクラスの指定）
     			Intent intent = new Intent(getActivity(),SecondActivity.class);
     			startActivity(intent);
     			
     		}
     	}
     
        
    }
}
