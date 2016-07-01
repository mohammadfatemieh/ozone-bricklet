Imports System
Imports Tinkerforge

Module ExampleSimple
    Const HOST As String = "localhost"
    Const PORT As Integer = 4223
    Const UID As String = "XYZ" ' Change XYZ to the UID of your Ozone Bricklet

    Sub Main()
        Dim ipcon As New IPConnection() ' Create IP connection
        Dim o As New BrickletOzone(UID, ipcon) ' Create device object

        ipcon.Connect(HOST, PORT) ' Connect to brickd
        ' Don't use device before ipcon is connected

        ' Get current ozone concentration (unit is ppb)
        Dim ozoneConcentration As Integer = o.GetOzoneConcentration()
        Console.WriteLine("Ozone Concentration: " + ozoneConcentration.ToString() + " ppb")

        Console.WriteLine("Press key to exit")
        Console.ReadLine()
        ipcon.Disconnect()
    End Sub
End Module
