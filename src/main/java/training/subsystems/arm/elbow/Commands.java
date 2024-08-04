package training.subsystems.arm.elbow;

public class CommandsBuilder {

    private final Elbow elbow;
    public CommandsBuilder(Elbow clbow){
        this.elbow = elbow;
    }
    public Commnad moveToPosition(Rotation2d angle){

        return new FunctionalCommand(
                () -> elbow.moveToAngle(angle),
                () -> {},
                interrupted ->  elbow.stayInPlace(),
                () -> elbow.isAtAngle(angle) );

    }
}
