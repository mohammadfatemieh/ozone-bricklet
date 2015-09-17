function matlab_example_simple()
    import com.tinkerforge.IPConnection;
    import com.tinkerforge.BrickletOzone;

    HOST = 'localhost';
    PORT = 4223;
    UID = 'XYZ'; % Change to your UID

    ipcon = IPConnection(); % Create IP connection
    o = BrickletOzone(UID, ipcon); % Create device object

    ipcon.connect(HOST, PORT); % Connect to brickd
    % Don't use device before ipcon is connected

    % Get current ozone concentration (unit is ppb)
    ozoneConcentration = o.getOzoneConcentration();
    fprintf('Ozone Concentration: %i ppb\n', ozoneConcentration);

    input('Press key to exit\n', 's');
    ipcon.disconnect();
end
