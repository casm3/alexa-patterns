package br.upe.alexapatterns.playback.observer;

import br.upe.alexapatterns.playback.event.PlaybackEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Requisito #5 - Observer: mantém assinantes e publica eventos de reprodução.
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
    observers.remove(observer);
  }

  @Override
  public void publish(PlaybackEvent event) {
    for (PlaybackObserver observer : new ArrayList<>(observers)) {
      observer.update(event);
    }
  }
}