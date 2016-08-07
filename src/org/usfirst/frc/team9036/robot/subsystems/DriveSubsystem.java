package org.usfirst.frc.team9036.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;
import org.usfirst.frc.team9036.robot.commands.DriveButtonCommand;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
	
	public static int driveDirection = 1;
	
	VictorSP driveFrontLeft = new VictorSP(RobotMap.DriverFrontLeftPort);
	VictorSP driveFrontRight = new VictorSP(RobotMap.DriverFrontRightPort);
	VictorSP driveRearLeft = new VictorSP(RobotMap.DriverRearLeftPort);
	VictorSP driveRearRight = new VictorSP(RobotMap.DriverRearRightPort);
	RobotDrive robotDrive = new RobotDrive(driveFrontLeft, driveRearLeft, driveFrontRight, driveRearRight);
	
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveButtonCommand());
    }
    
    public void drive(double speed, double curve) {
    	robotDrive.drive(speed, curve);
    }
    
    public void arcadeDrive(Joystick joystick) {
    	robotDrive.arcadeDrive(joystick);
    }
    
    public void arcadeDrive(double moveValue, double rotateValue) {
    	robotDrive.arcadeDrive(moveValue, rotateValue);
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

