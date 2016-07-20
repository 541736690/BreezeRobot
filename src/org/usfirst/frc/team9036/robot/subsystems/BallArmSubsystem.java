package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallArmSubsystem extends Subsystem {
	public VictorSP ballArmMotor = new VictorSP(RobotMap.MotorArmPort);
	
    public void initDefaultCommand() {

    }
    public void drive(double speed) {
    	ballArmMotor.set(speed);
    }
    public void stop(){
    	ballArmMotor.stopMotor();
    }
}

