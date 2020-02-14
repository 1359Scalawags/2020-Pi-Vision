package team1359;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class FanControl{
    public FanControl(){
        GpioController gpio = GpioFactory.getInstance();
        GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Fan Power", PinState.HIGH);

        // set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.LOW);

        // turn off gpio pin #01
        pin.low();
        gpio.shutdown();
    }
}