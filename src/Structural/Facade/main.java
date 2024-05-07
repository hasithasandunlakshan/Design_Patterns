package Structural.Facade;

// Subsystem classes
class AudioPlayer {
    public void play() {
        System.out.println("Playing audio");
    }

    public void stop() {
        System.out.println("Stopping audio");
    }
}

class VideoPlayer {
    public void play() {
        System.out.println("Playing video");
    }

    public void stop() {
        System.out.println("Stopping video");
    }
}

class Screen {
    public void show() {
        System.out.println("Displaying screen");
    }

    public void hide() {
        System.out.println("Hiding screen");
    }
}

// Facade
class MultimediaFacade {
    private AudioPlayer audioPlayer;
    private VideoPlayer videoPlayer;
    private Screen screen;

    public MultimediaFacade() {
        audioPlayer = new AudioPlayer();
        videoPlayer = new VideoPlayer();
        screen = new Screen();
    }

    public void startMultimedia() {
        audioPlayer.play();
        videoPlayer.play();
        screen.show();
        System.out.println("Multimedia started successfully");
    }

    public void stopMultimedia() {
        audioPlayer.stop();
        videoPlayer.stop();
        screen.hide();
        System.out.println("Multimedia stopped successfully");
    }
}

// Client
public class main {
    public static void main(String[] args) {
        MultimediaFacade multimediaFacade = new MultimediaFacade();
        multimediaFacade.startMultimedia();
        // Do some other operations...
        multimediaFacade.stopMultimedia();
    }
}
