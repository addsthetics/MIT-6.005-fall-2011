package piano;

import javax.sound.midi.MidiUnavailableException;

import midi.Midi;
import music.Pitch;
import midi.Instrument;

public class PianoMachine {
	
	private Midi midi;
	private Instrument instrument = Midi.DEFAULT_INSTRUMENT;
    
	/**
	 * constructor for PianoMachine.
	 * 
	 * initialize midi device and any other state that we're storing.
	 */
    public PianoMachine() {
    	try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }
    
    /**
	 * Begins to play a note if a note is not playing already on the current instrument.
	 * @param rawPitch: Pitch of the Note to be played.
	 */
    public void beginNote(Pitch rawPitch) {
    	midi.beginNote(rawPitch.toMidiFrequency(), instrument);
    }
    
    /**
   	 * Stops stops playing a note appropriate note if it's playing upon the release
   	 * corresponding key.
   	 * @param rawPitch: Pitch of the Note being played.
   	 */
    public void endNote(Pitch rawPitch) {
    	
    	midi.endNote(rawPitch.toMidiFrequency(),instrument);

    }
    
    /**
   	 * Switch the current instrument playing by cycling throw a list of Mid instruments.
   	 * 'i' key is used to cycle. 
   	 */
    public void changeInstrument() {
       	instrument = instrument.next();
    }
    
    //TODO write method spec
    public void shiftUp() {
    	//TODO: implement for question 3
    }
    
    //TODO write method spec
    public void shiftDown() {
    	//TODO: implement for question 3
    }
    
    //TODO write method spec
    public boolean toggleRecording() {
    	return false;
    	//TODO: implement for question 4
    }
    
    //TODO write method spec
    protected void playback() {    	
        //TODO: implement for question 4
    }

}
