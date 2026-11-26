package br.upe.alexapatterns.playback.observer;

import br.upe.alexapatterns.playback.event.PlaybackEvent;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Requisito #3 - Observer: gerencia inscrições e publica eventos.
 */
public class PlaybackEventPublisher implements PlaybackPublisher {

  private final Set<PlaybackObserver> observers = new LinkedHashSet<>();

  @Override
  public void subscribe(PlaybackObserver observer) {
    this.observers.add(Objects.requireNonNull(observer, "observer"));
  }

  @Override
  public void unsubscribe(PlaybackObserver observer) {
    this.observers.remove(observer);
  }

  @Override
  public void publish(PlaybackEvent event) {
    PlaybackEvent nonNullEvent = Objects.requireNonNull(event, "event");
    for (PlaybackObserver observer : List.copyOf(this.observers)) {
      observer.update(nonNullEvent);
    }
  }
}
