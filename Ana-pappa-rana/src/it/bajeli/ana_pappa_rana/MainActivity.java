package it.bajeli.ana_pappa_rana;

// GITHUB INFO http://www.vogella.com/articles/EclipseGit/article.html

import java.util.HashMap;
import it.bajeli.ana_pappa_rana.R;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
public class MainActivity extends Activity implements OnClickListener, OnTouchListener {

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
	
	final static int SOUND_DO = 7;
	final static int SOUND_RE = 8;
	final static int SOUND_MI = 9;
	final static int SOUND_FA = 9;
	final static int SOUND_SOL = 10;
	final static int SOUND_LA = 11;
	final static int SOUND_SI = 12;
	
	static Vibrator myVib=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
		
		mSoundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
		mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		mSoundPoolMap = new HashMap();
		
		mSoundPoolMap.put(SOUND_FX_ANA, mSoundPool.load(this, R.raw.voce00004, 1));
		mSoundPoolMap.put(SOUND_FX_PAPPA, mSoundPool.load(this, R.raw.voce00005, 1));
		mSoundPoolMap.put(SOUND_FX_RANA, mSoundPool.load(this, R.raw.voce00003, 1));
		mSoundPoolMap.put(SOUND_FX_SCIMMIA, mSoundPool.load(this, R.raw.voce00007, 1));
		mSoundPoolMap.put(SOUND_FX_PESCE, mSoundPool.load(this, R.raw.voce00008, 1));
		mSoundPoolMap.put(SOUND_FX_CAPRA, mSoundPool.load(this, R.raw.voce00006, 1));
		
		mSoundPoolMap.put(SOUND_DO, mSoundPool.load(this, R.raw.voce00009, 1));
		mSoundPoolMap.put(SOUND_RE, mSoundPool.load(this, R.raw.voce00010, 1));
		mSoundPoolMap.put(SOUND_MI, mSoundPool.load(this, R.raw.voce00011, 1));
		mSoundPoolMap.put(SOUND_FA, mSoundPool.load(this, R.raw.voce00012, 1));
		mSoundPoolMap.put(SOUND_SOL, mSoundPool.load(this, R.raw.voce00013, 1));
		mSoundPoolMap.put(SOUND_LA, mSoundPool.load(this, R.raw.voce00014, 1));
		mSoundPoolMap.put(SOUND_SI, mSoundPool.load(this, R.raw.voce00015, 1));
		
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
		
		Button doButt=(Button) findViewById(R.id.button_do);
		doButt.setOnClickListener(this);
		doButt.setOnTouchListener(this);
		
		Button reButt=(Button) findViewById(R.id.button_re);
		reButt.setOnClickListener(this);
		reButt.setOnTouchListener(this);
		
		Button miButt=(Button) findViewById(R.id.button_mi);
		miButt.setOnClickListener(this);
		miButt.setOnTouchListener(this);
		
		Button faButt=(Button) findViewById(R.id.button_fa);
		faButt.setOnClickListener(this);
		faButt.setOnTouchListener(this);
		
		Button solButt=(Button) findViewById(R.id.button_sol);
		solButt.setOnClickListener(this);
		solButt.setOnTouchListener(this);
		
		Button laButt=(Button) findViewById(R.id.button_la);
		laButt.setOnClickListener(this);
		laButt.setOnTouchListener(this);
		
		Button siButt=(Button) findViewById(R.id.button_si);
		siButt.setOnClickListener(this);
		siButt.setOnTouchListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onTouch( View v , MotionEvent theMotion ) {
		Log.d("Touch", "Touch "+theMotion.getAction());
	    switch ( theMotion.getAction() ) {
		    case MotionEvent.ACTION_HOVER_ENTER: 
		    	doPlay(v); 
		    	break;
		    case MotionEvent.ACTION_DOWN: 
		    	doPlay(v); 
		    	break;
		    case MotionEvent.ACTION_UP: break;
	    }
	    return true;
	}
	
	public void onClick(View v) {
		doPlay(v);
	
	
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
	
	private void doPlay(View v){
		float streamVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
		streamVolume = streamVolume / mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		myVib.vibrate(50);
		
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
				
			case R.id.button_do:
				mSoundPool.stop(mStream1);
				mStream1= mSoundPool.play(mSoundPoolMap.get(SOUND_DO), streamVolume, streamVolume, 1, LOOP_1_TIME, 1f);
				break;
				
			case R.id.button_re:
				mSoundPool.stop(mStream1);
				mStream1= mSoundPool.play(mSoundPoolMap.get(SOUND_RE), streamVolume, streamVolume, 1, LOOP_1_TIME, 1f);
				break;
				
			case R.id.button_mi:
				mSoundPool.stop(mStream1);
				mStream1= mSoundPool.play(mSoundPoolMap.get(SOUND_MI), streamVolume, streamVolume, 1, LOOP_1_TIME, 1f);
				break;
				
			case R.id.button_fa:
				mSoundPool.stop(mStream1);
				mStream1= mSoundPool.play(mSoundPoolMap.get(SOUND_FA), streamVolume, streamVolume, 1, LOOP_1_TIME, 1f);
				break;
				
			case R.id.button_sol:
				mSoundPool.stop(mStream1);
				mStream1= mSoundPool.play(mSoundPoolMap.get(SOUND_SOL), streamVolume, streamVolume, 1, LOOP_1_TIME, 1f);
				break;
			case R.id.button_la:
				mSoundPool.stop(mStream1);
				mStream1= mSoundPool.play(mSoundPoolMap.get(SOUND_LA), streamVolume, streamVolume, 1, LOOP_1_TIME, 1f);
				break;
			case R.id.button_si:
				mSoundPool.stop(mStream1);
				mStream1= mSoundPool.play(mSoundPoolMap.get(SOUND_SI), streamVolume, streamVolume, 1, LOOP_1_TIME, 1f);
				break;
								
			case 7:
				mSoundPool.stop(mStream1);
				mSoundPool.stop(mStream2);
				break;
		}
	}
	
}

