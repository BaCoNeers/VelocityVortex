/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.Opmode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Configuration;
import org.firstinspires.ftc.teamcode.util.Configuration_OBot;

@TeleOp(name = "macanum_nathan", group = "Pushbot")

public class macanum_drive_Nathan extends LinearOpMode {

    /* Declare OpMode members. */
    private Configuration_OBot robot = new Configuration_OBot();   // Use a Pushbot's hardware
    public float power_1, power_2, power_3, power_4;


    @Override
    public void runOpMode() {


        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
        telemetry.update();

        telemetry.setAutoClear(false);


        DriveController.SetupTelemetry(telemetry);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.update();

            power_1 = gamepad1.left_stick_x + gamepad1.left_stick_y - gamepad1.right_stick_x;
            power_2 = gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x;
            power_3 = gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x;
            power_4 = gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x;

            if (power_1 > 1) power_1 = 1;
            if (power_2 > 1) power_2 = 1;
            if (power_3 > 1) power_3 = 1;
            if (power_4 > 1) power_4 = 1;

            robot.DriveFL.setPower(power_1);
            robot.DriveFR.setPower(power_2);
            robot.DriveBL.setPower(power_3);
            robot.DriveBR.setPower(power_4);
        }
        robot.DriveFL.setPower(0);
        robot.DriveFR.setPower(0);
        robot.DriveBL.setPower(0);
        robot.DriveBR.setPower(0);
    }


}


