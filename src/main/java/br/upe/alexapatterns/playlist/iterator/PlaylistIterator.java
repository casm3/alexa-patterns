package br.upe.alexapatterns.playlist.iterator;

import br.upe.alexapatterns.track.entity.Track;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Requisito #2 - Iterator: controla um percurso independente pelas faixas.
 */
public class PlaylistIterator implements Iterator<Track> {

  private final List<Track> tracks;
  private int currentIndex;

  /**
   * Inicia o percurso sobre uma cópia da sequência recebida.
   */
  public PlaylistIterator(List<Track> tracks) {
    this.tracks = List.copyOf(tracks);
    this.currentIndex = 0;
  }

  @Override
  public boolean hasNext() {
    return currentIndex < tracks.size();
  }

  @Override
  public Track next() {
    if (!hasNext()) {
      throw new NoSuchElementException("Não há mais faixas na sequência.");
    }
    Track track = tracks.get(currentIndex);
    currentIndex++;
    return track;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("Remoção não suportada em PlaylistIterator.");
  }
}
