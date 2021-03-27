package com.dungeonmaster.errros;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {
	  
	private String message;
	  
	  public ProductNotFoundException(String message) {
          this.message = message;
      }
      public String getMessage() {
          return message;
      }
      public void setMessage(String message) {
          this.message = message;
      }
}
