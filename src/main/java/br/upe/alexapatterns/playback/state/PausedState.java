package br.upe.alexapatterns.playback.state;

import br.upe.alexapatterns.playback.entity.PlaybackStatus;
import br.upe.alexapatterns.track.entity.Track;
import java.util.List;

/**
 * Representa uma reprodução pausada.
 */
public class PausedState implements PlaybackState {

  @Override
  public PlaybackStatus getStatus() {
    return PlaybackStatus.PAUSED;
  }

  @Override
  public void play(MusicPlayer player, List<Track> tracks) {
    player.beginPlaylist(tracks);
    player.changeState(new PlayingState());
  }

  @Override
  public void resume(MusicPlayer player) {
    player.changeState(new PlayingState());
  }

  @Override
  public void next(MusicPlayer player) {
    if (!player.advance()) {
      player.clearPlaylist();
      player.changeState(new StoppedState());
    }
  }

  @Override
  public void stop(MusicPlayer player) {
    player.clearPlaylist();
    player.changeState(new StoppedState());
  }
}