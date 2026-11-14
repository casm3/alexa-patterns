package br.upe.alexapatterns.playback.state;

import br.upe.alexapatterns.playback.entity.PlaybackStatus;
import br.upe.alexapatterns.track.entity.Track;
import java.util.List;

/**
 * Representa o tocador sem uma reprodução em andamento.
 */
public class StoppedState implements PlaybackState {

  @Override
  public PlaybackStatus getStatus() {
    return PlaybackStatus.STOPPED;
  }

  @Override
  public void play(MusicPlayer player, List<Track> tracks) {
    player.beginPlaylist(tracks);
    player.changeState(new PlayingState());
  }

  @Override
  public void stop(MusicPlayer player) {
    // O tocador já está parado.
  }
}