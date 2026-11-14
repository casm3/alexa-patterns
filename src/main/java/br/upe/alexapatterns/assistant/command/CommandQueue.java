package br.upe.alexapatterns.assistant.command;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * Armazena e executa os comandos na ordem de inclusão.
 */
public class CommandQueue {

  private final Queue<PlaybackCommand> commands = new ArrayDeque<>();

  /**
   * Registra um pedido para execução posterior.
   */
  public void enqueue(PlaybackCommand command) {
    commands.add(Objects.requireNonNull(command, "command"));
  }

  /**
   * Remove e executa um pedido, se existir.
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
   * Executa os pedidos até esvaziar a fila ou ocorrer um erro.
   */
  public int executeAll() {
    int count = 0;
    while (executeNext()) {
      count++;
    }
    return count;
  }

  /**
   * Conta os pedidos pendentes.
   */
  public int size() {
    return commands.size();
  }

  /**
   * Descarta as pendências.
   */
  public void clear() {
    commands.clear();
  }
}