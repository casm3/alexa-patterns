package br.upe.alexapatterns.playback.observer;

import br.upe.alexapatterns.playback.event.PlaybackEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Registra os eventos recebidos em ordem de publicação.
 */
public class PlaybackHistory implements PlaybackObserver {

  private final List<PlaybackEvent> events = new ArrayList<>();

  @Override
  public void update(PlaybackEvent event) {
    events.add(event);
  }

  /**
   * Consulta uma cópia não modificável do histórico.
   */
  public List<PlaybackEvent> getEvents() {
    return List.copyOf(events);
  }
}