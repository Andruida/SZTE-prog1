package prog1.kotprog.dontstarve.solution.character.actions;

import prog1.kotprog.dontstarve.solution.GameManager;
import prog1.kotprog.dontstarve.solution.character.MutableCharacter;
import prog1.kotprog.dontstarve.solution.utility.Direction;
import prog1.kotprog.dontstarve.solution.utility.Position;

/**
 * A lépés akció leírására szolgáló osztály: a karakter egy lépést tesz balra, jobbra, fel vagy le.
 */
public class ActionStep extends Action {
    /**
     * A mozgás iránya.
     */
    private final Direction direction;

    /**
     * Az akció létrehozására szolgáló konstruktor.
     *
     * @param direction a mozgás iránya
     */
    public ActionStep(Direction direction) {
        super(ActionType.STEP);
        this.direction = direction;
    }

    /**
     * A direction gettere.
     * @return a mozgás iránya
     */
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void execute(MutableCharacter executor) {
        Position pos = executor.getCurrentPosition();
        float posX = pos.getX();
        float posY = pos.getY();
        float speed = executor.getSpeed();
        switch (direction) {
            case UP:
                executor.setPosition(posX, posY-speed);
                break;
            case DOWN:
                executor.setPosition(posX, posY+speed);
                break;
            case LEFT:
                executor.setPosition(posX-speed, posY);
                break;
            case RIGHT:
                executor.setPosition(posX+speed, posY);
                break;
        }

        Position newPos = executor.getCurrentPosition().getNearestWholePosition();
        if (!GameManager.getInstance().getField((int)newPos.getX(), (int)newPos.getY()).isWalkable()) {
            executor.setPosition(pos);
        }
        
        super.execute(executor);
    }
}
