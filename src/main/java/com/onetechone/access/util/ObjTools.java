package com.onetechone.access.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onetechone.access.exception.WrongDataException;
import java.io.IOException;

public class ObjTools {

  private static ObjectMapper mapper = new ObjectMapper();

  public static <T> String toJson(T obj) {
    try {
      return mapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new WrongDataException();
    }
  }

  public static <T> T toObj(String value, Class<T> classType) {
    try {
      return mapper.readValue(value, classType);
    } catch (IOException e) {
      throw new WrongDataException();
    }
  }

}
