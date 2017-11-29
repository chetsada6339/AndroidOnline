package com.chet.androidonlinequizapp.Common;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import com.chet.androidonlinequizapp.R;


public class Music {

	public static boolean OFF = false;

	public static void playCorrent() {


	}

	public static void playBackgroundMusic() {
			if (!OFF) {
				MediaPlayer mp = MediaPlayer.create(Shared.context,R.raw.background_music);
				mp.setOnCompletionListener(new OnCompletionListener() {
					@Override
					public void onCompletion(MediaPlayer mp) {
						mp.reset();
						mp.release();
						mp = null;
					}

				});
				mp.start();
			}

	}

	public static void showStar() {


	}
}
