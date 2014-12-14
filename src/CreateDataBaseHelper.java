import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class CreateDataBaseHelper extends SQLiteOpenHelper {
	//�@�R���X�g���N�^��`
	public CreateDataBaseHelper(Context con) {
		//�@SQLiteOpenHelper�̃R���X�g���N�^�Ăяo��
		super(con, "dbkabu", null, 1);
	}
	
	@Override
	public void onOpen(SQLiteDatabase db){
		super.onOpen(db);
	}
	
	// �f�[�^�x�[�X�쐬���Ƀe�[�u���쐬
	//�@onCreate���\�b�h
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE �A���[�g�ݒ�e�[�u�� (" +
				"�A���[�gNO primary key," +
				"���� text," +
				"�����R�[�h integer," +
				"�{���o���v�Z���� integer" +
				"�{���o���g���K�[�l integer," +
				"RSI�v�Z���� integer," +
				"RSI�g���K�[�l integer," +
				"�{���o���A���[�g�L�� text," +
				"RSI�A���[�g�L�� text," +				
				"�������� integer");
	
		
		db.execSQL("CREATE TABLE �A���[�g�p�����e�[�u�� (" +
				"�A���[�gNO integer not null" +
				"���t date not null," +
				"�I�l integer not null," +
				"primary key(�A���[�gNO, ���t)");		
	}

	//�@onUpgrade���\�b�h
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

}
