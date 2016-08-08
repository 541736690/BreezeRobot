package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.Robot;
import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallShooterDebugCommand extends Command {

	
			
    public BallShooterDebugCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	boolean isLeftPressed = Robot.oi.shootJoystick.getRawButton(RobotMap.LeftBallShooterButtonID);
    	boolean isRightPressed = Robot.oi.shootJoystick.getRawButton(RobotMap.RightBallShooterButtonID);
    	if (isLeftPressed && isRightPressed){
    		Robot.ballShooterSubsystem.start();
    	} else {
    		Robot.ballShooterSubsystem.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ballShooterSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
