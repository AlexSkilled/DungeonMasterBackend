package com.dungeonmaster.errros;

@SuppressWarnings("serial")
public class NoteWasNotFoundException extends RuntimeException {
	  
	private String message;
	  
	  public NoteWasNotFoundException(String message) {
          this.message = message;
      }
      public String getMessage() {
          return message;
      }
      public void setMessage(String message) {
          this.message = message;
      }
}
