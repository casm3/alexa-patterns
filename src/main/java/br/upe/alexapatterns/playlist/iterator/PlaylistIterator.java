package br.upe.alexapatterns.playlist.iterator;

import br.upe.alexapatterns.track.entity.Track;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Requisito #2 - Iterator: controla um percurso independente pelas faixas.
 */
public class PlaylistIterator implements Iterator<Track> {

  /**
   * Inicia o percurso sobre uma cópia da sequência recebida.
   */
  private final List<Track> tracks;
  private int position;

  public PlaylistIterator(List<Track> tracks) {
    this.tracks = List.copyOf(tracks);
  }

  @Override
  public boolean hasNext() {
    return position < tracks.size();
  }

  @Override
  public Track next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return tracks.get(position++);
  }
}
