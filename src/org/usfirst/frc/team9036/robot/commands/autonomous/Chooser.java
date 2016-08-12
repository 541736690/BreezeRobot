package org.usfirst.frc.team9036.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chooser {
	
	SendableChooser chooser;
	Command autonomousCommand;
	
	public Chooser() {
		chooser = new SendableChooser();
		
		chooser.addDefault("什么也不干", null);
		chooser.addObject("慢速跨越障碍", new SlowCross());
		chooser.addObject("快速跨越障碍", new FastCross());
		
		SmartDashboard.putData("Auto selector", chooser);
	}
	
	public void run() {
		autonomousCommand = (Command) chooser.getSelected();
		
		if (autonomousCommand != null)
			autonomousCommand.start();
	}
	
	public void cancel() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}
}
