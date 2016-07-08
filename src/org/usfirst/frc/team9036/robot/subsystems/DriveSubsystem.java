package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.commands.DriveStickCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
    RobotDrive robotDrive = Robot.oi.robotDrive;
    
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveStickCommand());
    }
    
    public void drive(double speed, double curve) {
    	robotDrive.drive(speed, curve);
    }
    
    public void drive(Joystick joystick) {
    	robotDrive.arcadeDrive(joystick);
    }
    
    public void stop() {
    	robotDrive.stopMotor();
    }
}

