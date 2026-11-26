package br.upe.alexapatterns.assistant.command;

import br.upe.alexapatterns.playback.state.MusicPlayer;
import br.upe.alexapatterns.track.entity.Track;
import java.util.List;
import java.util.Objects;

/**
 * Requisito #5 - Command: pedido para iniciar uma sequência de músicas.
 */
public class PlayCommand implements PlaybackCommand {

  private final MusicPlayer player;
  private final List<Track> tracks;

  /**
   * Guarda o tocador e uma cópia da sequência, sem iniciar a reprodução.
   */
  public PlayCommand(MusicPlayer player, List<Track> tracks) {
    this.player = Objects.requireNonNull(player, "player");
    this.tracks = List.copyOf(tracks);
  }

  @Override
  public void execute() {
    player.play(tracks);
  }
}