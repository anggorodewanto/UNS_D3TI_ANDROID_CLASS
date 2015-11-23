package M3113123_Ridwan_Yoga_Pradana.musicplayer;

import java.util.ArrayList;
import java.util.Random;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentUris;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;

public class MusicService extends Service implements 
MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener,
MediaPlayer.OnCompletionListener {

	private MediaPlayer player;
	private ArrayList<Song> songs;
	private int songPosn;
	private final IBinder musicBind = new MusicBinder();
	private String songTitle = "";
	private static final int NOTIFY_ID = 1;
	private boolean shuffle = false;
	private Random rand;

	public void onCreate(){
		super.onCreate();
		songPosn = 0;
		rand = new Random();
		player = new MediaPlayer();
		initMusicPlayer();
	}

	public void initMusicPlayer(){
		player.setWakeMode(getApplicationContext(),
				PowerManager.PARTIAL_WAKE_LOCK);
		player.setAudioStreamType(AudioManager.STREAM_MUSIC);
		player.setOnPreparedListener(this);
		player.setOnCompletionListener(this);
		player.setOnErrorListener(this);
	}

	public void setList(ArrayList<Song> theSongs){
		songs=theSongs;
	}

	public class MusicBinder extends Binder {
		MusicService getService() {
			return MusicService.this;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return musicBind;
	}

	@Override
	public boolean onUnbind(Intent intent){
		player.stop();
		player.release();
		return false;
	}

	public void playSong(){
		player.reset();
		Song playSong = songs.get(songPosn);
		songTitle=playSong.getTitle();
		long currSong = playSong.getID();
		Uri trackUri = ContentUris.withAppendedId(
				android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
				currSong);
		try{
			player.setDataSource(getApplicationContext(), trackUri);
		}
		catch(Exception e){
			Log.e("MUSIC SERVICE", "Error setting data source", e);
		}
		player.prepareAsync(); 
	}

	public void setSong(int songIndex){
		songPosn=songIndex;	
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		if(player.getCurrentPosition()>0){
			mp.reset();
			playNext();
		}
	}

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		Log.v("MUSIC PLAYER", "Playback Error");
		mp.reset();
		return false;
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		mp.start();
		Intent notIntent = new Intent(this, MainActivity.class);
		notIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		PendingIntent pendInt = PendingIntent.getActivity(this, 0,
				notIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		Notification.Builder builder = new Notification.Builder(this);

		builder.setContentIntent(pendInt)
		.setSmallIcon(R.drawable.play)
		.setTicker(songTitle)
		.setOngoing(true)
		.setContentTitle("Playing")
		.setContentText(songTitle);
		Notification not = builder.build();
		startForeground(NOTIFY_ID, not);
	}

	public int getPosn(){
		return player.getCurrentPosition();
	}

	public int getDur(){
		return player.getDuration();
	}

	public boolean isPng(){
		return player.isPlaying();
	}

	public void pausePlayer(){
		player.pause();
	}

	public void seek(int posn){
		player.seekTo(posn);
	}

	public void go(){
		player.start();
	}

	//skip to previous track
	public void playPrev(){
		songPosn--;
		if(songPosn<0) songPosn = songs.size()-1;
		playSong();
	}

	//skip to next
	public void playNext(){
		if(shuffle){
			int newSong = songPosn;
			while(newSong == songPosn){
				newSong = rand.nextInt(songs.size());
			}
			songPosn = newSong;
		}
		else{
			songPosn++;
			if(songPosn>=songs.size()) songPosn=0;
		}
		playSong();
	}

	@Override
	public void onDestroy() {
		stopForeground(true);
	}

	public void setShuffle(){
		if(shuffle) shuffle = false;
		else shuffle = true;
	}

}
