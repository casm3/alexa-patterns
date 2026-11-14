package br.upe.alexapatterns.playback.observer;

import br.upe.alexapatterns.playback.event.PlaybackEvent;
import java.util.Optional;

/**
 * Mantém a última atualização recebida pelo painel.
 */
public class PlaybackPanel implements PlaybackObserver {

  private PlaybackEvent latest;

  @Override
  public void update(PlaybackEvent event) {
    latest = event;
  }

  /**
   * Consulta a última atualização recebida.
   */
  public Optional<PlaybackEvent> getLatest() {
    return Optional.ofNullable(latest);
  }
}