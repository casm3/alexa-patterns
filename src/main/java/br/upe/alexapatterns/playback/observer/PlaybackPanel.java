package br.upe.alexapatterns.playback.observer;

import br.upe.alexapatterns.playback.event.PlaybackEvent;
import java.util.Optional;

/**
 * Requisito #5 - Observer: mantém o último estado publicado da reprodução.
 */
public class PlaybackPanel implements PlaybackObserver {

  private PlaybackEvent latest;

  @Override
  public void update(PlaybackEvent event) {
    this.latest = event;
  }
 
  public Optional<PlaybackEvent> getLatest() {
    return Optional.ofNullable(latest);
  }
}

 
