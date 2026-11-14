package br.upe.alexapatterns.playback.observer;

import br.upe.alexapatterns.playback.event.PlaybackEvent;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Gerencia as inscrições e distribui os eventos de reprodução.
 */
public class PlaybackEventPublisher implements PlaybackPublisher {

  private final Set<PlaybackObserver> observers = new LinkedHashSet<>();

  @Override
  public void subscribe(PlaybackObserver observer) {
    observers.add(Objects.requireNonNull(observer, "observer"));
  }

  @Override
  public void unsubscribe(PlaybackObserver observer) {
    observers.remove(observer);
  }

  @Override
  public void publish(PlaybackEvent event) {
    for (PlaybackObserver observer : List.copyOf(observers)) {
      observer.update(event);
    }
  }
}