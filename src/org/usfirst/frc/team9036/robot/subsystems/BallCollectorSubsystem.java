package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallCollectorSubsystem extends Subsystem {
	VictorSP ballCollectorMotor= new VictorSP(RobotMap.BallCollectorButtonID);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void collect(){
    	ballCollectorMotor.set(RobotMap.BallCollectorMotorSpeed);
    }
	public void stop(){
		ballCollectorMotor.set(0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

