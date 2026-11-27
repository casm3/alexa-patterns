package br.upe.alexapatterns.playback.strategy;

import br.upe.alexapatterns.track.entity.Track;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Requisito #1 - Strategy: mantém a ordem original das faixas.
 */
public class SequentialPlaybackStrategy implements PlaybackOrderStrategy {

  @Override
  public List<Track> order(List<Track> tracks) {
    Objects.requireNonNull(tracks, "tracks");
    return new ArrayList<>(tracks);
  }
}
