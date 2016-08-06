package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.commands.DebugCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DebugSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DebugCommand());
    }
}

