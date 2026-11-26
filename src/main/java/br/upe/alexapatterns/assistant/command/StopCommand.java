package br.upe.alexapatterns.assistant.command;

import br.upe.alexapatterns.playback.state.MusicPlayer;
import java.util.Objects;

/**
 * Requisito #5 - Command: pedido para encerrar a reprodução.
 */
public class StopCommand implements PlaybackCommand {

  private final MusicPlayer player;

  /**
   * Guarda o tocador, sem executar o pedido.
   */
  public StopCommand(MusicPlayer player) {
    this.player = Objects.requireNonNull(player, "player");
  }

  @Override
  public void execute() {
    this.player.stop();
  }
}
