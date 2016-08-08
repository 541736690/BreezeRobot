package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallCollectorSubsystem extends Subsystem {
	VictorSP ballCollectorMotor1 = new VictorSP(RobotMap.BallCollectorMotorPort1);
	VictorSP ballCollectorMotor2 = new VictorSP(RobotMap.BallCollectorMotorPort2);
	public void collect(){
    	ballCollectorMotor1.set(RobotMap.BallCollectorMotorSpeed);
    }
	public void stop(){
		ballCollectorMotor1.stopMotor();
	}
    public void initDefaultCommand() {
    }
}

