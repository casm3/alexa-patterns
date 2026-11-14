package br.upe.alexapatterns.assistant.command;

import br.upe.alexapatterns.playback.state.MusicPlayer;
import java.util.Objects;

/**
 * Encapsula o pedido para continuar a reprodução.
 */
public class ResumeCommand implements PlaybackCommand {

  private final MusicPlayer player;

  /**
   * Guarda o tocador, sem executar o pedido.
   */
  public ResumeCommand(MusicPlayer player) {
    this.player = Objects.requireNonNull(player, "player");
  }

  @Override
  public void execute() {
    player.resume();
  }
}