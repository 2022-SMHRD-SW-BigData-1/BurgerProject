package CTRL;

import java.util.ArrayList;

import Model.MusicVO;
import javazoom.jl.player.MP3Player;

public class musicCTRL {
	MP3Player mp3 = new MP3Player();
	ArrayList<MusicVO> musicList = new ArrayList<MusicVO>();

	public musicCTRL() {

		musicList.add(new MusicVO("mainbgm",
				"src//music//mainbgm.mp3"));
		musicList.add(new MusicVO("프롤로그",
				"src//music//pro.mp3"));
		musicList.add(new MusicVO("게임진행",
				"src//music//start.mp3"));
		musicList.add(new MusicVO("손님",
				"src//music//customer.mp3"));
		musicList.add(new MusicVO("엔딩",
				"src//music//ending.mp3"));
	}

	public void playstop(String s) {

		for (int i = 0; i < musicList.size(); i++) {
			MusicVO m = musicList.get(i);
			String a = m.getBgmName();
			if (a.equals(s)) {
				if (mp3.isPlaying()) {
					mp3.stop();
				}
				mp3.play(m.getPath());
			}
		}
	}
	
	public MusicVO gamebgm() {
		MusicVO m = musicList.get(2);
		mp3.play(m.getPath());
		return m;
	}
	
	public MusicVO bgmstop() {
		MusicVO m = musicList.get(3);
		mp3.stop();
		return m;
	}
	public MusicVO custbgm() {
		MusicVO m = musicList.get(3);
		mp3.play(m.getPath());
		return m;

	}

	public void stop(String s) {

		for (int i = 0; i < musicList.size(); i++) {
			MusicVO m = musicList.get(i);
			String a = m.getBgmName();
			if (a.equals(s)) {
				if (mp3.isPlaying()) {
					mp3.stop();
				}
			}
		}
		}
}
