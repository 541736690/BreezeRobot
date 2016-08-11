package org.usfirst.frc.team9036.robot.commands.shooter;

import org.usfirst.frc.team9036.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallCollectorPrepareCommand extends Command {

    public BallCollectorPrepareCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.ballCollectorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(1.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ballCollectorSubsystem.collect(0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ballCollectorSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
