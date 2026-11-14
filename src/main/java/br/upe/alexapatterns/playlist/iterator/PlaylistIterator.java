package br.upe.alexapatterns.playlist.iterator;

import br.upe.alexapatterns.track.entity.Track;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Percorre uma cópia da sequência com posição independente.
 */
public class PlaylistIterator implements Iterator<Track> {

  private final List<Track> tracks;
  private int index;

  /**
   * Guarda uma cópia da sequência recebida.
   */
  public PlaylistIterator(List<Track> tracks) {
    this.tracks = List.copyOf(tracks);
  }

  @Override
  public boolean hasNext() {
    return index < tracks.size();
  }

  @Override
  public Track next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return tracks.get(index++);
  }
}