package org.usfirst.frc.team9036.robot.commands;

import org.usfirst.frc.team9036.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDirectionChangeCommand extends Command {

    public DriveDirectionChangeCommand() {
    }

    protected void initialize() {
    	DriveSubsystem.driveDirection = DriveSubsystem.driveDirection * -1;
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    	end();
    }
}
