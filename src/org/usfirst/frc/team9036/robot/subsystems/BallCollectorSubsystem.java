package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallCollectorSubsystem extends Subsystem {
	VictorSP ballCollectorMotor = new VictorSP(RobotMap.BallCollectorMotor);
	
    public void initDefaultCommand() {
    }
    public void drive(double speed) {
    	ballCollectorMotor.set(speed);
    }
    public void stop(){
    	ballCollectorMotor.stopMotor();
    }
}

