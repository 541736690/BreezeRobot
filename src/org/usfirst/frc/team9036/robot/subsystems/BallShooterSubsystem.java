package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallShooterSubsystem extends Subsystem {
	VictorSP leftBallShooterMotor = new VictorSP(RobotMap.LeftBallShooterMotorPort);
	VictorSP rightBallShooterMotor = new VictorSP(RobotMap.RightBallShooterMotorPort);
	
    public void initDefaultCommand() {
    }
    public void start() {
    	leftBallShooterMotor.set(RobotMap.LeftBallShooterMotorSpeed);
    	rightBallShooterMotor.set(RobotMap.RightBallShooterMotorSpeed);
    }
    public void stop(){
    	leftBallShooterMotor.stopMotor();
    	rightBallShooterMotor.stopMotor();
    }
}

