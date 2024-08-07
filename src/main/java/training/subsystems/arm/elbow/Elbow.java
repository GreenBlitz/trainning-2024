package training.subsystems.arm.elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {
    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }
  
    private  CommandsBuilder commmands;
    private  IElbow iElbow;
    

    public Elbow(){
        this.commmands = new CommandsBuilder(this);
        this.iElbow = ElbowFactory.create();
        
    }
    public CommandsBuilder getCommmands(){
        return this.commmands;
    }

    public Rotation2d getCurrentAngle(){
        return iElbow.getCurrentAngle();
    }
    public void setPower(double power){
        iElbow.setPower(power);
    }
    public boolean isAtAngle(Rotation2d angle){
         return Math.abs((getCurrentAngle().getDegrees() - angle.getDegrees())) <= Constants.TOLERANCE.getDegrees();
    }
    public Rotation2d getCurrentVelocity(){
        return iElbow.getCurrentVelocity();
    }
    public void moveToAngle(Rotation2d angle){
        iElbow.moveToAngle(angle);

    }
    
    public void stayInPlace(){
       iElbow.stayInPlace();

    }
}
