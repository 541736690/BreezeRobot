package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallShooterSubsystem extends Subsystem {
	VictorSP ballShooterMotor = new VictorSP(RobotMap.BallShooterMotor);
	
    public void initDefaultCommand() {
    }
    public void drive(double speed) {
    	ballShooterMotor.set(speed);
    }
    public void stop(){
    	ballShooterMotor.stopMotor();
    }
}

