package br.upe.alexapatterns.assistant.command;

import br.upe.alexapatterns.playback.state.MusicPlayer;
import java.util.Objects;

/**
 * Encapsula o pedido para avançar para a próxima música.
 */
public class NextCommand implements PlaybackCommand {

  private final MusicPlayer player;

  /**
   * Guarda o tocador, sem executar o pedido.
   */
  public NextCommand(MusicPlayer player) {
    this.player = Objects.requireNonNull(player, "player");
  }

  @Override
  public void execute() {
    player.next();
  }
}