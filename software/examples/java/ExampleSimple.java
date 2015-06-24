import com.tinkerforge.BrickletOzone;
import com.tinkerforge.IPConnection;

public class ExampleSimple {
	private static final String HOST = "localhost";
	private static final int PORT = 4223;
	private static final String UID = "XYZ"; // Change to your UID

	// Note: To make the example code cleaner we do not handle exceptions. Exceptions you
	//       might normally want to catch are described in the documentation
	public static void main(String args[]) throws Exception {
		IPConnection ipcon = new IPConnection(); // Create IP connection
		BrickletOzone oz = new BrickletOzone(UID, ipcon); // Create device object

		ipcon.connect(HOST, PORT); // Connect to brickd
		// Don't use device before ipcon is connected

		// Get current ozone concentration (unit is ppb)
		int ozoneConcentration = oz.getOzoneConcentration(); // Can throw com.tinkerforge.TimeoutException

		System.out.println("Ozone Concentration: " + ozoneConcentration + " ppb");

		System.out.println("Press key to exit"); System.in.read();
		ipcon.disconnect();
	}
}