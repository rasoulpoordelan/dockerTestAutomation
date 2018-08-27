package com.onetechone.access.exception;

public class WrongDataException extends CustomException {

  public WrongDataException() {
    super("wrong_data");
  }

  public WrongDataException(String msg) {
    super("wrong_data");
    this.setErrMsg(msg);
  }
}

