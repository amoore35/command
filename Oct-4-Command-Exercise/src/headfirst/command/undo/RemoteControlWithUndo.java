package headfirst.command.undo;

import java.util.*;

//
// This is the invoker
//
public class RemoteControlWithUndo {
  private Command[] onCommands;
  private Command[] offCommands;
  private Command undoCommand;
  private Stack<Command> stack;

  public RemoteControlWithUndo() {
	stack = new Stack<>();
    onCommands = new Command[7];
    offCommands = new Command[7];

    Command noCommand = new NoCommand();
    for (int i = 0; i < 7; i++) {
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }
    undoCommand = noCommand;
  }

  public void setCommand(int slot, Command onCommand, Command offCommand) {
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  public void onButtonWasPushed(int slot) {
    onCommands[slot].execute();
    stack.push(onCommands[slot]);
  }

  public void offButtonWasPushed(int slot) {
    offCommands[slot].execute();
    stack.push(offCommands[slot]);
  }

  public void undoButtonWasPushed() { 
	Command c = stack.pop();
    c.undo();
  }

  public String toString() {
    StringBuffer stringBuff = new StringBuffer();
//    stringBuff.append("\n------ Remote Control -------\n");
//    for (int i = 0; i < onCommands.length; i++) {
//      stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "    "
//                        + offCommands[i].getClass().getName() + "\n");
//    }
//    stringBuff.append("[undo] " + undoCommand.getClass().getName() + "\n");
//    
    stringBuff.append("---UNDO STACK---" + "\n");
    for (int i = stack.size() - 1; i >= 0; i--) {
    	stringBuff.append(stack.get(i).getClass().getName() + "\n");
    }
    return stringBuff.toString();
  }
}
