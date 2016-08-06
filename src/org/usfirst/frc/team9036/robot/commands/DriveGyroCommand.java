package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveGyroCommand extends Command {

    public DriveGyroCommand() {
    	requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int mod=0; double i=0;
    	if (Robot.oi.mainJoystick.getRawButton(RobotMap.LeftTurningButtonPort)==true){
    		i=-1;
    	}else if (Robot.oi.mainJoystick.getRawButton(RobotMap.RightTurningButtonPort)==true){
    		i=1;
    	}else if (Robot.oi.mainJoystick.getRawButton(RobotMap.ForwardTurningButtonPort)==true){
    		mod=1;
    	}else if (Robot.oi.mainJoystick.getRawButton(RobotMap.BackwardTurningButtonPort)==true){
    		mod=2;
    	}
    	
    	if (mod==0){
    		double startAngle = Math.abs(Robot.gyroSubsystem.getAngle());
    		double finalAngle = Math.abs(startAngle + i*90.0);
    		double currentAngle = Math.abs(Robot.gyroSubsystem.getAngle());
    		double leftAngle = Math.abs(finalAngle - currentAngle);
    		double speed = 0;
    		if (leftAngle>=40){
    			speed=RobotMap.DriveGyroRotateMaxSpeed;
    		}else if (leftAngle<40 && leftAngle>0){
    			speed=leftAngle/80;
    		}
    		Robot.driveSubsystem.drive(0,speed);
    		mod=0;
    	}else if (mod==1 || mod==2){
    		double currentAngle = Math.abs(Robot.gyroSubsystem.getAngle() % 360);
    		double speed = 0;double finalAngle = 0;
    		if (mod==1 && currentAngle>=0 && currentAngle<180){
    			finalAngle = 0;i=1;
    		}else if (mod==1 && currentAngle>=180 && currentAngle<360){
    			finalAngle = 360;i=-1;
    		}else if (mod==2 && currentAngle>=0 && currentAngle<180){
    			finalAngle = 180;i=1;
    		}else if (mod==2 && currentAngle>=180 && currentAngle<360){
    			finalAngle = 180;i=-1;
    		}
    		double leftAngle = Math.abs(currentAngle - finalAngle);
    		if (leftAngle>=30){
        		speed=i*RobotMap.DriveGyroRotateMaxSpeed;
        	}else if (leftAngle<30 && leftAngle>0){
        		speed=i*leftAngle/60;
        	}
    	Robot.driveSubsystem.drive(0,speed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
