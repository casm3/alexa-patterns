package br.upe.alexapatterns.playback.observer;

import br.upe.alexapatterns.playback.event.PlaybackEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Requisito #3 - Observer: gerencia inscrições e publica eventos.
 */
public class PlaybackEventPublisher implements PlaybackPublisher {

  private final List<PlaybackObserver> observers = new ArrayList<>();

  @Override
  public void subscribe(PlaybackObserver observer) {
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
    List<PlaybackObserver> snapshot = new ArrayList<>(observers);
    for (PlaybackObserver observer : snapshot) {
      observer.update(event);
    }
  }
}