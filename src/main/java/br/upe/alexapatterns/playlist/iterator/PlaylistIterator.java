package br.upe.alexapatterns.playlist.iterator;

import br.upe.alexapatterns.track.entity.Track;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Requisito #2 - Iterator: controla um percurso independente pelas faixas.
 */
public class PlaylistIterator implements Iterator<Track> {

  private final List<Track> tracks;
  private int cursor;

  /**
   * Inicia o percurso sobre uma cópia da sequência recebida.
   *
   * @param tracks lista de faixas a serem percorridas
   */
  public PlaylistIterator(List<Track> tracks) {
    Objects.requireNonNull(tracks, "tracks");
    this.tracks = new ArrayList<>(tracks);
    this.cursor = 0;
  }

  @Override
  public boolean hasNext() {
    return cursor < tracks.size();
  }

  @Override
  public Track next() {
    if (!hasNext()) {
      throw new NoSuchElementException("Não há mais faixas na playlist.");
    }
    return tracks.get(cursor++);
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("Remoção não suportada em PlaylistIterator.");
  }
}