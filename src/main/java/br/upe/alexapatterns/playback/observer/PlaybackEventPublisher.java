package br.upe.alexapatterns.playback.observer;

import br.upe.alexapatterns.playback.event.PlaybackEvent;
import java.util.ArrayList;
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
    Objects.requireNonNull(observer, "observer");
    observers.add(observer);
  }

  @Override
  public void unsubscribe(PlaybackObserver observer) {
    Objects.requireNonNull(observer, "observer");
    observers.remove(observer);
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