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
		


		
		// ���݂�intent���擾����
		Intent intent = getIntent();
		// intent����w��̃L�[�̕�������擾����
		String alertNo = intent.getStringExtra("alertNo");		
        // �\������e�L�X�g�̐ݒ�
        String txt = "�A���[�g" + alertNo;
		// �g�[�X�g�Ŋm�F�i�C���e���g�Ŏ擾����������j
		//Toast.makeText(this, txt, Toast.LENGTH_LONG).show();  
		
		

		
		setContentView(R.layout.activity_second);	//�@	�ʂ�ۉ����I�I�@(R.layout.Activity_second);�@���@(R.layout.fragment_second);
		
        // ID����TextView�C���X�^���X���擾		
//		TextView tvalert = (TextView)findViewById(R.id.No);	//�ʂ�ۉ����I�I
//        tvalert.setText(txt);	//�ʂ�ۉ����I�I
        
        // Activity��View��ݒ�
//        setContentView(tvalert);	//�@�ʂ�ۉ����I�I�@�@�����́A���������s�v�������I	

		
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
		
		//�t�@�C����
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
			
            // �{�����W���[�o���h�ݒ�{�^���̃N���b�N���X�i�[��`
            Button bt_boriban = (Button)rootView.findViewById(R.id.sect_e);
            bt_boriban.setTag("bt_boriban");
            bt_boriban.setOnClickListener(new ButtonClickListener());
            
            // �q�r�h�ݒ�{�^���̃N���b�N���X�i�[��`
            Button bt_RSI = (Button)rootView.findViewById(R.id.sect_f);
            bt_RSI.setTag("bt_RSI");
            bt_RSI.setOnClickListener(new ButtonClickListener());
            
            // �L�����Z���{�^���̃N���b�N���X�i�[��`
            Button bt_can = (Button)rootView.findViewById(R.id.bt_can);
            bt_can.setTag("bt_can");
            bt_can.setOnClickListener(new ButtonClickListener());		
            
            // �q�r�h�ݒ�{�^���̃N���b�N���X�i�[��`
            Button bt_set = (Button)rootView.findViewById(R.id.bt_set);
            bt_set.setTag("bt_set");
            bt_set.setOnClickListener(new ButtonClickListener());		            
            
            //DB�쐬
            helper = new CreateDataBaseHelper(rootView.getContext());
            
            
			
			return rootView;
		}
		
        // �N���b�N���X�i�[��`
     	class ButtonClickListener implements OnClickListener {
     		// onClick���\�b�h(�{�^���N���b�N���C�x���g�n���h��)
     		public void onClick(View v) {
     			
     			
     			//�^�O�̎擾
 				String tag = (String)v.getTag();
 				

		     			
		     		//�L�����Z���{�^���������ꂽ�ꍇ
		     		if(tag.equals("bt_can")){
		     			getActivity().finish();
		     			
		     		//�o�^�{�^���������ꂽ�ꍇ
		     		}else{
		     			
		     			//���͏��擾
		     			int alertNo = 1;
		     			EditText name=(EditText)getActivity().findViewById(R.id.alert);
		     			String Mcode="998407.O";
		     			
		     			//�Y��DB�I�u�W�F�N�g�擾
		     			SQLiteDatabase db = helper.getReadableDatabase();
		     			try{
		     				//�g�����U�N�V��������J�n
		     				db.beginTransaction();
		     				
		     				//�o�^�f�[�^�ݒ�
		     				ContentValues val = new ContentValues();
		     				val.put("�A���[�gNO", alertNo);
		     				val.put("����", name.toString());
		     				val.put("�����R�[�h", Mcode);
		     				
		     				//�f�[�^�o�^
		     				db.insert("�A���[�g�ݒ�e�[�u��", null, val);
		     				//�R�~�b�g
		     				db.setTransactionSuccessful();
		     				//�g�����U�N�V��������I��
		     				db.endTransaction();		     				
		     			}catch(Exception e){
		     				
		     			}
		     			
						
					}
	 				
     				//�{�����W���[�o���h�ݒ�{�^���������ꂽ�ꍇ
	     			if(tag.equals("bt_boriban")){
		     			//�@�C���e���g�̐����i�Ăяo���N���X�̎w��j
		     			Intent intent = new Intent(getActivity(),BoribanActivity.class);
		     			startActivity(intent);
	     			}
	     			
	     			//�q�r�h�ݒ�{�^���������ꂽ�ꍇ
	     			if(tag.equals("bt_RSI")){
		     			//�@�C���e���g�̐����i�Ăяo���N���X�̎w��j
		     			Intent intent = new Intent(getActivity(),RSIActivity.class);
		     			startActivity(intent);
     			}     			
     			
     		}
     	}
		
	}
}
