package piano;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.sound.midi.MidiUnavailableException;

import midi.Midi;
import music.Pitch;

import org.junit.Test;

public class PianoMachineTest {
	
	PianoMachine pm = new PianoMachine();
	
    @Test
    public void singleNoteTest() throws MidiUnavailableException {
        String expected0 = "on(61,PIANO) wait(100) off(61,PIANO)";
        
    	Midi midi = Midi.getInstance();

    	midi.clearHistory();
    	
        pm.beginNote(new Pitch(1));
		Midi.wait(100);
		pm.endNote(new Pitch(1));

        //System.out.println(midi.history());
        assertEquals(expected0,midi.history());
    }
    @Test
    public void muplitpleNotesTest() throws MidiUnavailableException {
        String expected0 = "on(61,PIANO) wait(100) off(61,PIANO) wait(0) on(63,PIANO) wait(100) off(63,PIANO) wait(0) on(68,PIANO) wait(50) off(68,PIANO)";
        
    	Midi midi = Midi.getInstance();

    	midi.clearHistory();
    	
        pm.beginNote(new Pitch(1));
		Midi.wait(100);
		pm.endNote(new Pitch(1));
		
		//pm.changeInstrument();
		
		pm.beginNote(new Pitch(3));
			Midi.wait(100);
		pm.endNote(new Pitch(3));
		
		pm.beginNote(new Pitch(8));
		Midi.wait(50);
		pm.endNote(new Pitch(8));

        System.out.println(midi.history());
        System.out.println(expected0);
        assertEquals(expected0,midi.history());
    }
    @Test
    public void changeInstrumentsSameNote() throws MidiUnavailableException {
        String expected0 = "on(61,PIANO) wait(100) off(61,PIANO) wait(0) on(61,BRIGHT_PIANO) wait(100) off(61,BRIGHT_PIANO) wait(0) on(61,ELECTRIC_GRAND) wait(50) off(61,ELECTRIC_GRAND)";
        
    	Midi midi = Midi.getInstance();

    	midi.clearHistory();
    	
        pm.beginNote(new Pitch(1));
		Midi.wait(100);
		pm.endNote(new Pitch(1));
		
		pm.changeInstrument();
		
		pm.beginNote(new Pitch(1));
			Midi.wait(100);
		pm.endNote(new Pitch(1));
		pm.changeInstrument();
		pm.beginNote(new Pitch(1));
		Midi.wait(50);
		pm.endNote(new Pitch(1));

        System.out.println(midi.history());
        System.out.println(expected0);
        assertEquals(expected0,midi.history());
    }
}
