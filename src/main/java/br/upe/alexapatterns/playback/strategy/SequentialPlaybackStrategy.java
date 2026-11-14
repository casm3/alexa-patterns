package br.upe.alexapatterns.playback.strategy;

import br.upe.alexapatterns.track.entity.Track;
import java.util.ArrayList;
import java.util.List;

/**
 * Mantém a ordem recebida em uma cópia independente.
 */
public class SequentialPlaybackStrategy implements PlaybackOrderStrategy {

  @Override
  public List<Track> order(List<Track> tracks) {
    return new ArrayList<>(tracks);
  }
}