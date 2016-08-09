package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.RobotMap;
import org.usfirst.frc.team9036.robot.commands.shooter.BallShooterCommandGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallShooterSubsystem extends Subsystem {
	VictorSP leftBallShooterMotor;
	VictorSP rightBallShooterMotor;

	public BallShooterSubsystem() {
		leftBallShooterMotor = new VictorSP(RobotMap.LeftBallShooterMotorPort);
		rightBallShooterMotor = new VictorSP(RobotMap.RightBallShooterMotorPort);
	}

	public void initDefaultCommand() {
	}

	public void move() {
		leftBallShooterMotor.set(RobotMap.LeftBallShooterMotorSpeed);
		rightBallShooterMotor.set(RobotMap.RightBallShooterMotorSpeed);
	}

	public void stop() {
		leftBallShooterMotor.stopMotor();
		rightBallShooterMotor.stopMotor();
	}
}
