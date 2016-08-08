package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.RobotMap;
import org.usfirst.frc.team9036.robot.commands.drive.ButtonDriveCommand;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
	VictorSP driveFrontLeft;
	VictorSP driveFrontRight;
	VictorSP driveRearLeft;
	VictorSP driveRearRight;
	RobotDrive robotDrive;
	
	boolean CurrentDriveDirection;
	
	public DriveSubsystem() {
		driveFrontLeft = new VictorSP(RobotMap.DriverFrontLeftPort);
		driveFrontRight = new VictorSP(RobotMap.DriverFrontRightPort);
		driveRearLeft = new VictorSP(RobotMap.DriverRearLeftPort);
		driveRearRight = new VictorSP(RobotMap.DriverRearRightPort);
		
		robotDrive = new RobotDrive(driveFrontLeft, driveRearLeft, driveFrontRight, driveRearRight);
		
		CurrentDriveDirection = false;
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ButtonDriveCommand());
    }
    
    public void arcadeDrive(double moveValue, double rotateValue) {
    	arcadeDrive(moveValue, rotateValue, RobotMap.IsSquareInput);
    }
    
    public void arcadeDrive(double moveValue, double rotateValue, boolean isSquareInput) {
    	robotDrive.arcadeDrive(moveValue, rotateValue, isSquareInput);
    }
    
    public void tankDrive(double leftValue, double rightValue) {
    	tankDrive(leftValue, rightValue, RobotMap.IsSquareInput);
    }
    
    public void tankDrive(double leftValue, double rightValue, boolean isSquareInput) {
    	robotDrive.tankDrive(leftValue, rightValue, isSquareInput);
    }
    
    private void setDirectionInversed(boolean inversed) {
    	robotDrive.setInvertedMotor(MotorType.kFrontLeft, inversed);
    	robotDrive.setInvertedMotor(MotorType.kFrontRight, inversed);
    	robotDrive.setInvertedMotor(MotorType.kRearLeft, inversed);
    	robotDrive.setInvertedMotor(MotorType.kRearRight, inversed);
    }
    
    public void stop() {
    	robotDrive.stopMotor();
    }
    
    public void setDriveDirection(boolean isInversed) {
    	this.CurrentDriveDirection = isInversed;
    	this.setDirectionInversed(this.getDriveDirection());
    }
    
    public boolean getDriveDirection() {
    	return this.CurrentDriveDirection ^ RobotMap.IsDirectionInversed;
    }
}

