package br.upe.alexapatterns.playback.strategy;

import br.upe.alexapatterns.track.entity.Track;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Embaralha uma cópia das faixas usando o gerador recebido.
 */
public class ShuffledPlaybackStrategy implements PlaybackOrderStrategy {

  private final Random random;

  /**
   * Recebe o gerador utilizado no embaralhamento.
   */
  public ShuffledPlaybackStrategy(Random random) {
    this.random = Objects.requireNonNull(random, "random");
  }

  @Override
  public List<Track> order(List<Track> tracks) {
    List<Track> result = new ArrayList<>(tracks);
    Collections.shuffle(result, random);
    return result;
  }
}