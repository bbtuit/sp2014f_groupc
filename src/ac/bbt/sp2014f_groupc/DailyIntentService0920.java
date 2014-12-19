package ac.bbt.sp2014f_groupc;

import android.app.IntentService;
import android.content.Intent;
import android.text.format.Time;
import android.widget.Toast;

public class DailyIntentService0920 extends IntentService {
	
	  final static String TAG = "Service0920";

	  public DailyIntentService0920() {
	    super(TAG);
	  }	
	  @Override
	  protected void onHandleIntent(Intent intent) {
			Time time = new Time("Asia/Tokyo");
			time.setToNow();
			String yp=String.valueOf(time.year-1);
			String y=String.valueOf(time.year);
			String m=String.valueOf(time.month+1);		
			String d=String.valueOf(time.monthDay);	
			String url = "http://info.finance.yahoo.co.jp/history/?code=998407.O&sy=" + yp + "&sm=" + m + "&sd=" + d + "&ey=" + y + "&em=" + m + "&ed=" + d + "&tm=d&p=1";

//	    Log.d(TAG, url);
			//�g�[�X�g�Ŋm�F�i�C���e���g�Ŏ擾����������j
			Toast.makeText(this, url, Toast.LENGTH_SHORT).show();  
			
			
	  }

}
