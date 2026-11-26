package br.upe.alexapatterns.playback.observer;

import br.upe.alexapatterns.playback.event.PlaybackEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Requisito #5 - Observer: registra o histórico cronológico dos eventos de reprodução.
 */
public class PlaybackHistory implements PlaybackObserver {

  private final List<PlaybackEvent> events = new ArrayList<>();

  @Override
  public void update(PlaybackEvent event) {
    events.add(event);
  }

  /**
   * Devolve uma cópia não modificável dos eventos recebidos.
   */
  public List<PlaybackEvent> getEvents() {
    return List.copyOf(events);
  }
}