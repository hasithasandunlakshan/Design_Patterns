package Structural.Bridge;

// Implementor interface: TV
interface TV {
    void on();

    void off();

    void setChannel(int channel);

    void setVolume(int volume);
}

// Concrete Implementor: SonyTV
class SonyTV implements TV {
    @Override
    public void on() {
        System.out.println("Sony TV is turned on");
    }

    @Override
    public void off() {
        System.out.println("Sony TV is turned off");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Sony TV channel is set to " + channel);
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("Sony TV volume is set to " + volume);
    }
}

// Concrete Implementor: SamsungTV
class SamsungTV implements TV {
    @Override
    public void on() {
        System.out.println("Samsung TV is turned on");
    }

    @Override
    public void off() {
        System.out.println("Samsung TV is turned off");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Samsung TV channel is set to " + channel);
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("Samsung TV volume is set to " + volume);
    }
}

// Abstraction interface: RemoteControl
interface RemoteControl {
    void powerOn();

    void powerOff();

    void setChannel(int channel);

    void setVolume(int volume);
}

// Refined Abstraction: BasicRemote
class BasicRemote implements RemoteControl {
    protected TV tv;

    public BasicRemote(TV tv) {
        this.tv = tv;
    }

    @Override
    public void powerOn() {
        tv.on();
    }

    @Override
    public void powerOff() {
        tv.off();
    }

    @Override
    public void setChannel(int channel) {
        tv.setChannel(channel);
    }

    @Override
    public void setVolume(int volume) {
        tv.setVolume(volume);
    }
}

// Client
public class main {
    public static void main(String[] args) {
        // Using BasicRemote with Sony TV
        TV sonyTV = new SonyTV();
        RemoteControl basicRemoteSony = new BasicRemote(sonyTV);
        basicRemoteSony.powerOn();
        basicRemoteSony.setChannel(5);
        basicRemoteSony.setVolume(20);
        basicRemoteSony.powerOff();

        // Using BasicRemote with Samsung TV
        TV samsungTV = new SamsungTV();
        RemoteControl basicRemoteSamsung = new BasicRemote(samsungTV);
        basicRemoteSamsung.powerOn();
        basicRemoteSamsung.setChannel(10);
        basicRemoteSamsung.setVolume(15);
        basicRemoteSamsung.powerOff();
    }
}
