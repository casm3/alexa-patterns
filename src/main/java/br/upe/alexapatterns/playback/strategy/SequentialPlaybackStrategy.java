package br.upe.alexapatterns.playback.strategy;

import br.upe.alexapatterns.track.entity.Track;
import java.util.List;

/**
 * Requisito #1 - Strategy: mantém a ordem original das faixas.
 */
public class SequentialPlaybackStrategy implements PlaybackOrderStrategy {

  @Override
  public List<Track> order(List<Track> tracks) {
    return List.copyOf(tracks);
  }
}
