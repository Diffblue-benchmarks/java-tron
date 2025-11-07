package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class JsonUtilDiffblueTest {
  /**
   * Method under test: {@link JsonUtil#json2Obj(String, Class)}
   */
  @Test
  public void testJson2Obj() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(JsonUtil.json2Obj("", clazz));
  }

  /**
   * Method under test: {@link JsonUtil#json2Obj(String, Class)}
   */
  @Test
  public void testJson2Obj2() {
    // Arrange, Act and Assert
    assertNull(JsonUtil.json2Obj("Json String", null));
  }

  /**
   * Method under test: {@link JsonUtil#json2Obj(String, Class)}
   */
  @Test
  public void testJson2Obj3() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.json2Obj("Json String", clazz));
  }

  /**
   * Method under test: {@link JsonUtil#obj2Json(Object)}
   */
  @Test
  public void testObj2Json() {
    // Arrange, Act and Assert
    assertEquals("\"Obj\"", JsonUtil.obj2Json("Obj"));
    assertNull(JsonUtil.obj2Json(null));
    assertEquals("42", JsonUtil.obj2Json(DecodeUtil.ADDRESS_SIZE));
  }
}
