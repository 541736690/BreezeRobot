package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.commands.DebugCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DebugSubsystem extends Subsystem {
    

    public void initDefaultCommand() {
    	setDefaultCommand(new DebugCommand());
    }
}

