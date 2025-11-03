package OpMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;
import Subsystem.DriveTrain;
import Subsystem.Intake;
import Subsystem.Shooter;

/*
 * This OpMode illustrates how to program your robot to drive field relative.  This means
 * that the robot drives the direction you push the joystick regardless of the current orientation
 * of the robot.
 *
 * This OpMode assumes that you have four mecanum wheels each on its own motor named:
 *   front_left_motor, front_right_motor, back_left_motor, back_right_motor
 *
 *   and that the left motors are flipped such that when they turn clockwise the wheel moves backwards
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 *
 */

@TeleOp(name = "Teleop", group = "Robot")


public class Teleop extends OpMode {

    //subsystem init
    DriveTrain s_drive = new DriveTrain();
    Intake s_intake = new Intake();
    Shooter s_shooter = new Shooter();
    // This declares the IMU needed to get the current direction the robot is facing
    IMU imu;



        @Override
    public void init() {}

    @Override
    public void loop() {
        telemetry.addLine("Press A to reset Yaw");
        telemetry.addLine("Hold left bumper to drive in robot relative");
        telemetry.addLine("The left joystick sets the robot direction");
        telemetry.addLine("Moving the right joystick left and right turns the robot");

        // If you press the A button, then you reset the Yaw to be zero from the way
        // the robot is currently pointing
        if (gamepad1.a) {
            imu.resetYaw();
        }

        s_intake.IntakeSetPower(((double) gamepad1.left_trigger));
        s_shooter.ShooterSetPower(((double) gamepad1.right_trigger));
        // If you press the left bumper, you get a drive from the point of view of the robot
        if (gamepad1.left_bumper) {
            s_drive.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        } else {
            s_drive.driveFieldRelative(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        }
    }

}