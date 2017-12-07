package org.firstinspires.ftc.teamcode.Opmode;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by me on 6/12/2017.
 */

public class DriveController {

    public static Telemetry.Item
            _turning_power,
            _drive_power,
            _direction_x,
            _direction_y;

    public static void SetupTelemetry(Telemetry telemetry)
    {
        _turning_power = telemetry.addData("turning_power" , "%12.3f", 0.0);
        _drive_power = telemetry.addData("drive_power" , "%12.3f", 0.0);
        _direction_x = telemetry.addData("direction_x" , "%12.3f", 0.0);
        _direction_y = telemetry.addData("direction_y" , "%12.3f", 0.0);
    }

    public static vec2 GetDriveBias(Gamepad gamepad) {

        // Retrieve the power
        double drive_power = gamepad.left_stick_y;
        double turning_power = gamepad.right_stick_x;

        return GetDriveBias(drive_power, turning_power);
    }

    public static vec2 GetDriveBias(double drive_power, double turning_power) {

        // Bias Settings
        vec2 clockwise_bias = new vec2(1,-1);
        vec2 forward_bias = new vec2(1,1);

        vec2 movement_bias = forward_bias.multiply(1.0 - Math.abs(turning_power));

        _drive_power.setValue(drive_power);
        _turning_power.setValue(turning_power);

        vec2 direction = vec2.lerp(forward_bias, clockwise_bias, turning_power);

        _direction_x.setValue(direction.x);
        _direction_y.setValue(direction.y);


        vec2 result = direction.multiply(drive_power);

        return result;
    }
}
