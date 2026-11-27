package br.upe.alexapatterns.playlist.iterator;

import br.upe.alexapatterns.track.entity.Track;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Requisito #2 - Iterator: controla um percurso independente pelas faixas.
 */
public class PlaylistIterator implements Iterator<Track> {

  private final List<Track> tracks;
  private int index;

  /**
   * Inicia o percurso sobre uma cópia da sequência recebida.
   */
  public PlaylistIterator(List<Track> tracks) {
    Objects.requireNonNull(tracks, "tracks");
    this.tracks = List.copyOf(tracks);
    this.index = 0;
  }

  @Override
  public boolean hasNext() {
    return index < tracks.size();
  }

  @Override
  public Track next() {
    if (!hasNext()) {
      throw new NoSuchElementException("Não há mais faixas na sequência");
    }
    return  tracks.get(index++);
  }
}
