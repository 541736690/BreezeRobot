package org.usfirst.frc.team9036.robot.commands.drive;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GyroStraightDrivingCommand extends Command {

	private double speed;
	private double finalAngle;
	private double timeout;
	
    public GyroStraightDrivingCommand(double speed, double timeout) {
        requires(Robot.driveSubsystem);
        this.speed = speed;
        this.timeout = timeout;
    }
    
    public GyroStraightDrivingCommand(double speed) {
        this(speed, 0);
    }
    
    protected void initialize() {
    	finalAngle = Robot.gyroSubsystem.getAngle();
    	if (timeout != 0) {
    		setTimeout(timeout);
    	}
    }
    
    protected void execute() {
    	double currentAngle = Robot.gyroSubsystem.getAngle();
    	double delta = Math.abs(currentAngle - finalAngle);
		Robot.driveSubsystem.arcadeDrive(speed, 
				delta < RobotMap.GyroStraightRotateTolerance
				? 0
				: RobotMap.GyroStraightRotateAdjust * Math.signum(currentAngle - finalAngle));
    }
    
    protected boolean isFinished() {
        return isTimedOut();
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    	end();
    }
}
