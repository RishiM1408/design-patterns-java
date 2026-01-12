package com.learning.patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker.
 * Smart Home Remote Control or Scheduler.
 */
public class SmartHomeRemote {
    private List<Command> history = new ArrayList<>();

    public void submit(Command command) {
        history.add(command);
        command.execute();
    }
}
