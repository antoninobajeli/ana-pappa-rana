package it.bajeli.ana_pappa_rana;

import java.util.HashMap;
import it.bajeli.ana_pappa_rana.R;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class MainActivity extends Activity implements OnClickListener {

	MediaPlayer mediaAna, mediaRana, mediaPappa;
	
	
	private SoundPool mSoundPool;
	private AudioManager  mAudioManager;
	private HashMap<Integer, Integer> mSoundPoolMap;
	private int mStream1 = 0;
	private int mStream2 = 0;
	private int mStream3 = 0;
	private int mStream4 = 0;
	private int mStream5 = 0;
	private int mStream6 = 0;
	final static int LOOP_1_TIME = 0;
	final static int LOOP_3_TIMES = 2;
	final static int SOUND_FX_ANA = 1;
	final static int SOUND_FX_PAPPA = 2;
	final static int SOUND_FX_RANA = 3;
	final static int SOUND_FX_SCIMMIA = 4;
	final static int SOUND_FX_PESCE = 5;
	final static int SOUND_FX_CAPRA = 6;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		
		mSoundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
		mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		mSoundPoolMap = new HashMap();
		
		mSoundPoolMap.put(SOUND_FX_ANA, mSoundPool.load(this, R.raw.voce00004, 1));
		mSoundPoolMap.put(SOUND_FX_PAPPA, mSoundPool.load(this, R.raw.voce00005, 1));
		mSoundPoolMap.put(SOUND_FX_RANA, mSoundPool.load(this, R.raw.voce00003, 1));
		mSoundPoolMap.put(SOUND_FX_SCIMMIA, mSoundPool.load(this, R.raw.voce00007, 1));
		mSoundPoolMap.put(SOUND_FX_PESCE, mSoundPool.load(this, R.raw.voce00008, 1));
		mSoundPoolMap.put(SOUND_FX_CAPRA, mSoundPool.load(this, R.raw.voce00006, 1));
		
		//wire buttons
		/*Button b = (Button)findViewById(R.id.fx01);
		b.setOnClickListener(this);
		b = (Button)findViewById(R.id.fx02);
		b.setOnClickListener(this);
		b = (Button)findViewById(R.id.stop);
		b.setOnClickListener(this);
		
		*/
		
		
		
		/*
		mediaAna=MediaPlayer.create(getApplicationContext(),R.raw.voce00003);
		mediaRana=MediaPlayer.create(getApplicationContext(),R.raw.voce00004);
		mediaPappa=MediaPlayer.create(getApplicationContext(),R.raw.voce00005);
		*/
		Button ranaButt=(Button) findViewById(R.id.button_rana);
		/*ranaButt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//int resID=getResources().getIdentifier("voce0001", "res/raw", getPackageName());
		        //MediaPlayer mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.voce00004);
		        mediaAna.start();
			}
		});*/
		
		ranaButt.setOnClickListener(this);
		
		
		Button anaButt=(Button) findViewById(R.id.button_ana);
		/*anaButt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//int resID=getResources().getIdentifier("voce0001", "res/raw", getPackageName());
				mediaRana.start();
			}
		});*/
		anaButt.setOnClickListener(this);
		
		Button pappaButt=(Button) findViewById(R.id.button_pappa);
		/*pappaButt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//int resID=getResources().getIdentifier("voce0001", "res/raw", getPackageName());
		        //mediaPappa.start();
		        
		        SoundPool sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

		        int iTmp = sp.load(getApplicationContext(), R.raw.voce00006, 1); // in 2nd param u have to pass your desire ringtone
		        sp..o

		        sp.play(iTmp, 1, 1, 0, 0, 1);

		        //MediaPlayer mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.voce00007); // in 2nd param u have to pass your desire ringtone
		        //mPlayer.prepare();
		        //mPlayer.start();
		        
		        
		        
			}
		});*/
		pappaButt.setOnClickListener(this);
		
		Button scimmButt=(Button) findViewById(R.id.button_scimmia);
		scimmButt.setOnClickListener(this);
		
		Button pescButt=(Button) findViewById(R.id.button_pesce);
		pescButt.setOnClickListener(this);
		
		Button ginoButt=(Button) findViewById(R.id.button_capra);
		ginoButt.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void onClick(View v) {
		float streamVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
		streamVolume = streamVolume / mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		switch (v.getId()) {
			case R.id.button_rana:
				mSoundPool.stop(mStream1);
				mStream1= mSoundPool.play(mSoundPoolMap.get(SOUND_FX_RANA), streamVolume, streamVolume, 1, LOOP_1_TIME, 1f);
				break;
			case R.id.button_pappa:
				mSoundPool.stop(mStream1);
				mStream1= mSoundPool.play(mSoundPoolMap.get(SOUND_FX_PAPPA), streamVolume, streamVolume, 1, LOOP_1_TIME, 1f);
				break;
			case R.id.button_ana:
				mSoundPool.stop(mStream1);
				mStream1= mSoundPool.play(mSoundPoolMap.get(SOUND_FX_ANA), streamVolume, streamVolume, 1, LOOP_1_TIME, 1f);
				break;
			case R.id.button_scimmia:
				mSoundPool.stop(mStream1);
				mStream1= mSoundPool.play(mSoundPoolMap.get(SOUND_FX_SCIMMIA), streamVolume, streamVolume, 1, LOOP_1_TIME, 1f);
				break;
			case R.id.button_pesce:
				mSoundPool.stop(mStream1);
				mStream1= mSoundPool.play(mSoundPoolMap.get(SOUND_FX_PESCE), streamVolume, streamVolume, 1, LOOP_1_TIME, 1f);
				break;
			case R.id.button_capra:
				mSoundPool.stop(mStream1);
				mStream1= mSoundPool.play(mSoundPoolMap.get(SOUND_FX_CAPRA), streamVolume, streamVolume, 1, LOOP_1_TIME, 1f);
				break;
			case 7:
				mSoundPool.stop(mStream1);
				mSoundPool.stop(mStream2);
				break;
		}
	
	
	
	
	/*
	@Override
    public void onItemClick(AdapterView<?> arg0, View view, int position,long id) {                 
        TextView txtView=(TextView)view.findViewById(R.id.txt_view);
        String fname=txtView.getText().toString().toLowerCase();
        int resID=getResources().getIdentifier(fname, "raw", getPackageName());
        MediaPlayer mediaPlayer=MediaPlayer.create(this,resID);
        mediaPlayer.start();
    }*/

}
	
}

