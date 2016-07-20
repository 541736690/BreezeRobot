package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;
import org.usfirst.frc.team9036.robot.commands.DriveStickCommand;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
	VictorSP driveFrontLeft = new VictorSP(RobotMap.DriverFrontLeftPort);
	VictorSP driveFrontRight = new VictorSP(RobotMap.DriverFrontRightPort);
	VictorSP driveRearLeft = new VictorSP(RobotMap.DriverRearLeftPort);
	VictorSP driveRearRight = new VictorSP(RobotMap.DriverRearRightPort);
	RobotDrive robotDrive = new RobotDrive(driveFrontLeft, driveRearLeft, driveFrontRight, driveRearRight);
	
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveStickCommand());
    }
    
    public void drive(double speed, double curve) {
    	robotDrive.drive(speed, curve);
    }
    
    public void arcadeDrive(Joystick joystick) {
    	robotDrive.arcadeDrive(joystick);
    }
    
    public void customDrive(Joystick joystick) {
    	this.customDrive(joystick, true);
    }
    
    public void customDrive(Joystick joystick, boolean safetyEnabled) {
    	robotDrive.arcadeDrive(
    			joystick.getRawAxis(RobotMap.DriveSpeedAxis) 
    			* (safetyEnabled 
    					? joystick.getRawAxis(2) * RobotMap.DriveSafetyRate + RobotMap.DriveSafetyOffset 
    					: 1
    			), 
    			joystick.getRawAxis(RobotMap.DriveDirectionAxis) * (safetyEnabled 
    					? joystick.getRawAxis(2) * RobotMap.DriveSafetyRate + RobotMap.DriveSafetyOffset 
    					: 1
    			), 
    			true);
    }
    
    public void setDirectionInversed(boolean inversed) {
    	robotDrive.setInvertedMotor(MotorType.kFrontLeft, inversed);
    	robotDrive.setInvertedMotor(MotorType.kFrontRight, inversed);
    	robotDrive.setInvertedMotor(MotorType.kRearLeft, inversed);
    	robotDrive.setInvertedMotor(MotorType.kRearRight, inversed);
    }
    
    public void stop() {
    	robotDrive.stopMotor();
    }
}

