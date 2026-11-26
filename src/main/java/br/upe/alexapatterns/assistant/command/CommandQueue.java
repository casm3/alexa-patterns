package br.upe.alexapatterns.assistant.command;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * Requisito #5 - Command: armazena pedidos para execução posterior em ordem de inclusão.
 */
public class CommandQueue {

  private final Queue<PlaybackCommand> commands = new ArrayDeque<>();

  /**
   * Registra um comando não nulo, sem executá-lo.
   */
  public void enqueue(PlaybackCommand command) {
    Objects.requireNonNull(command, "command");
    commands.add(command);
  }

  /**
   * Remove e executa o próximo comando; devolve false se a fila estiver vazia.
   */
  public boolean executeNext() {
    PlaybackCommand command = commands.poll();
    if (command == null) {
      return false;
    }
    command.execute();
    return true;
  }

  /**
   * Executa os pedidos em ordem e devolve a quantidade concluída, ou propaga o erro.
   */
  public int executeAll() {
    int executed = 0;
    while (executeNext()) {
      executed++;
    }
    return executed;
  }

  /**
   * Informa quantos comandos ainda estão pendentes.
   */
  public int size() {
    return commands.size();
  }

  /**
   * Descarta os comandos pendentes, sem alterar o tocador.
   */
  public void clear() {
    commands.clear();
  }
}