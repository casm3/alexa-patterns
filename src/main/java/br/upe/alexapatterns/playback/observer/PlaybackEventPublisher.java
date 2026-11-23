package br.upe.alexapatterns.playback.observer;

import br.upe.alexapatterns.playback.event.PlaybackEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Requisito #3 - Observer: gerencia inscrições e publica eventos.
 */
public class PlaybackEventPublisher implements PlaybackPublisher {

  private final List<PlaybackObserver> observers = new ArrayList<>();

  @Override
  public void subscribe(PlaybackObserver observer) {
    Objects.requireNonNull(observer, "observer");
    if (!observers.contains(observer)) {
      observers.add(observer);
    }
  }

  @Override
  public void unsubscribe(PlaybackObserver observer) {
    if (observer != null) {
      observers.remove(observer);
    }
  }

  @Override
  public void publish(PlaybackEvent event) {
    Objects.requireNonNull(event, "event");
    List<PlaybackObserver> snapshot = new ArrayList<>(observers);
    for (PlaybackObserver observer : snapshot) {
      observer.update(event);
    }
  }
}
