package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.commands.GyroDebugCommand;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GyroSubsystem extends Subsystem {
    
	public AHRS ahrs;
	
    public void initDefaultCommand() {
        setDefaultCommand(new GyroDebugCommand());
        try {
            ahrs = new AHRS(SPI.Port.kMXP); 
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
        }
    }
    
    public double getAngle() {
    	return ahrs.getAngle();
    }
}

