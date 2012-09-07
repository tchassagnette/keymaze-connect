package fr.keymaze.connect.back.utils;

import java.io.IOException;

public class KeyMazeException extends Exception {

	public KeyMazeException(Throwable t) {
		super(t);
	}
	
	public KeyMazeException(Exception e) {
		super(e);
	}

}
