package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.DataWord;

public class JsonUtilDiffblueTest {
  /**
   * Test {@link JsonUtil#json2Obj(String, Class)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return intValue is {@link DecodeUtil#ADDRESS_SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#json2Obj(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtil.json2Obj(String, Class)"})
  public void testJson2Obj_when42_thenReturnIntValueIsAddress_size() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(DecodeUtil.ADDRESS_SIZE, ((Integer) JsonUtil.json2Obj("42", clazz)).intValue());
  }

  /**
   * Test {@link JsonUtil#json2Obj(String, Class)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#json2Obj(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtil.json2Obj(String, Class)"})
  public void testJson2Obj_whenEmptyString_thenReturnNull() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(JsonUtil.json2Obj("", clazz));
  }

  /**
   * Test {@link JsonUtil#json2Obj(String, Class)}.
   *
   * <ul>
   *   <li>When {@code Json String}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#json2Obj(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtil.json2Obj(String, Class)"})
  public void testJson2Obj_whenJsonString_thenThrowRuntimeException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.json2Obj("Json String", clazz));
  }

  /**
   * Test {@link JsonUtil#json2Obj(String, Class)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#json2Obj(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtil.json2Obj(String, Class)"})
  public void testJson2Obj_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JsonUtil.json2Obj("  ", null));
  }

  /**
   * Test {@link JsonUtil#json2Obj(String, Class)}.
   *
   * <ul>
   *   <li>When space space.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#json2Obj(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonUtil.json2Obj(String, Class)"})
  public void testJson2Obj_whenSpaceSpace_thenThrowRuntimeException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.json2Obj("  ", clazz));
  }

  /**
   * Test {@link JsonUtil#obj2Json(Object)}.
   *
   * <p>Method under test: {@link JsonUtil#obj2Json(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonUtil.obj2Json(Object)"})
  public void testObj2Json() {
    // Arrange, Act and Assert
    assertEquals(
        "\"0000000000000000000000000000000000000000000000000000000000000000\"",
        JsonUtil.obj2Json(DataWord.ZERO));
  }

  /**
   * Test {@link JsonUtil#obj2Json(Object)}.
   *
   * <ul>
   *   <li>When {@link DecodeUtil#ADDRESS_SIZE}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#obj2Json(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonUtil.obj2Json(Object)"})
  public void testObj2Json_whenAddress_size_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", JsonUtil.obj2Json(DecodeUtil.ADDRESS_SIZE));
  }

  /**
   * Test {@link JsonUtil#obj2Json(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#obj2Json(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonUtil.obj2Json(Object)"})
  public void testObj2Json_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JsonUtil.obj2Json(null));
  }
}
