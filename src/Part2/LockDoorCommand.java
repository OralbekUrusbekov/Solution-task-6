package Part2;

// Concrete Command to lock the door
public class LockDoorCommand implements Command {
    private DoorLock doorLock;

    public LockDoorCommand(DoorLock doorLock) {
        this.doorLock = doorLock;
    }

    public void execute() {
        doorLock.lock();
    }

    public void undo() {
        doorLock.unlock();
    }
}

