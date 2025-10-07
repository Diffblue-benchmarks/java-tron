package org.tron.core.vm.trace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import java.io.IOException;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.vm.trace.OpActions.Action;
import org.tron.core.vm.trace.OpActions.Action.Name;
import org.tron.core.vm.trace.Serializers.ByteArraySerializer;
import org.tron.core.vm.trace.Serializers.DataWordSerializer;
import org.tron.core.vm.trace.Serializers.OpCodeSerializer;

public class SerializersDiffblueTest {
  /**
   * Test ByteArraySerializer new {@link ByteArraySerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ByteArraySerializer}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteArraySerializer.<init>()"})
  public void testByteArraySerializerNewByteArraySerializer() {
    // Arrange and Act
    ByteArraySerializer actualByteArraySerializer = new ByteArraySerializer();

    // Assert
    assertNull(actualByteArraySerializer.getDelegatee());
    assertFalse(actualByteArraySerializer.isUnwrappingSerializer());
  }

  /**
   * Test ByteArraySerializer {@link ByteArraySerializer#serialize(byte[], JsonGenerator,
   * SerializerProvider)} with {@code byte[]}, {@code JsonGenerator}, {@code SerializerProvider}.
   *
   * <p>Method under test: {@link ByteArraySerializer#serialize(byte[], JsonGenerator,
   * SerializerProvider)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ByteArraySerializer.serialize(byte[], JsonGenerator, SerializerProvider)"
  })
  public void testByteArraySerializerSerializeWithByteJsonGeneratorSerializerProvider()
      throws IOException {
    // Arrange
    ByteArraySerializer byteArraySerializer = new ByteArraySerializer();
    byte[] memory = "AXAXAXAX".getBytes("UTF-8");

    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeString(Mockito.<String>any());
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(d);
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(d2, true);

    // Act
    byteArraySerializer.serialize(memory, jgen, new Impl());

    // Assert
    verify(d).writeString("4158415841584158");
  }

  /**
   * Test DataWordSerializer new {@link DataWordSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DataWordSerializer}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataWordSerializer.<init>()"})
  public void testDataWordSerializerNewDataWordSerializer() {
    // Arrange and Act
    DataWordSerializer actualDataWordSerializer = new DataWordSerializer();

    // Assert
    assertNull(actualDataWordSerializer.getDelegatee());
    assertFalse(actualDataWordSerializer.isUnwrappingSerializer());
  }

  /**
   * Test DataWordSerializer {@link DataWordSerializer#serialize(DataWord, JsonGenerator,
   * SerializerProvider)} with {@code DataWord}, {@code JsonGenerator}, {@code SerializerProvider}.
   *
   * <p>Method under test: {@link DataWordSerializer#serialize(DataWord, JsonGenerator,
   * SerializerProvider)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataWordSerializer.serialize(DataWord, JsonGenerator, SerializerProvider)"
  })
  public void testDataWordSerializerSerializeWithDataWordJsonGeneratorSerializerProvider()
      throws IOException {
    // Arrange
    DataWordSerializer dataWordSerializer = new DataWordSerializer();
    DataWord energy = DataWord.ZERO();

    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeString(Mockito.<String>any());
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(d);
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(d2, true);

    // Act
    dataWordSerializer.serialize(energy, jgen, new Impl());

    // Assert
    verify(d).writeString("0");
  }

  /**
   * Test OpCodeSerializer new {@link OpCodeSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OpCodeSerializer}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OpCodeSerializer.<init>()"})
  public void testOpCodeSerializerNewOpCodeSerializer() {
    // Arrange and Act
    OpCodeSerializer actualOpCodeSerializer = new OpCodeSerializer();

    // Assert
    assertNull(actualOpCodeSerializer.getDelegatee());
    assertFalse(actualOpCodeSerializer.isUnwrappingSerializer());
  }

  /**
   * Test OpCodeSerializer {@link OpCodeSerializer#serialize(Byte, JsonGenerator,
   * SerializerProvider)} with {@code Byte}, {@code JsonGenerator}, {@code SerializerProvider}.
   *
   * <p>Method under test: {@link OpCodeSerializer#serialize(Byte, JsonGenerator,
   * SerializerProvider)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OpCodeSerializer.serialize(Byte, JsonGenerator, SerializerProvider)"})
  public void testOpCodeSerializerSerializeWithByteJsonGeneratorSerializerProvider()
      throws IOException {
    // Arrange
    OpCodeSerializer opCodeSerializer = new OpCodeSerializer();

    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeString(Mockito.<String>any());
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(d);
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(d2, true);

    // Act
    opCodeSerializer.serialize((byte) 'A', jgen, new Impl());

    // Assert
    verify(d).writeString("COINBASE");
  }

  /**
   * Test {@link Serializers#serializeFieldsOnly(Object, boolean)}.
   *
   * <p>Method under test: {@link Serializers#serializeFieldsOnly(Object, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Serializers.serializeFieldsOnly(Object, boolean)"})
  public void testSerializeFieldsOnly() {
    // Arrange, Act and Assert
    assertEquals(
        "\"0000000000000000000000000000000000000000000000000000000000000000\"",
        Serializers.serializeFieldsOnly(DataWord.ZERO(), false));
  }

  /**
   * Test {@link Serializers#serializeFieldsOnly(Object, boolean)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code 42}.
   *   <li>Then return {@code {"name":"pop","params":{"foo":"42"}}}.
   * </ul>
   *
   * <p>Method under test: {@link Serializers#serializeFieldsOnly(Object, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Serializers.serializeFieldsOnly(Object, boolean)"})
  public void testSerializeFieldsOnly_givenHashMapFooIs42_thenReturnNamePopParamsFoo42() {
    // Arrange
    HashMap<String, Object> params = new HashMap<>();
    params.put("foo", "42");

    Action action = new Action();
    action.setName(Name.pop);
    action.setParams(params);

    // Act and Assert
    assertEquals(
        "{\"name\":\"pop\",\"params\":{\"foo\":\"42\"}}",
        Serializers.serializeFieldsOnly(action, false));
  }

  /**
   * Test {@link Serializers#serializeFieldsOnly(Object, boolean)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link Action} (default constructor) Name is {@code pop}.
   *   <li>Then return {@code {"name":"pop","params":{}}}.
   * </ul>
   *
   * <p>Method under test: {@link Serializers#serializeFieldsOnly(Object, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Serializers.serializeFieldsOnly(Object, boolean)"})
  public void testSerializeFieldsOnly_givenHashMap_whenActionNameIsPop_thenReturnNamePopParams() {
    // Arrange
    Action action = new Action();
    action.setName(Name.pop);
    action.setParams(new HashMap<>());

    // Act and Assert
    assertEquals(
        "{\"name\":\"pop\",\"params\":{}}", Serializers.serializeFieldsOnly(action, false));
  }

  /**
   * Test {@link Serializers#serializeFieldsOnly(Object, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Serializers#serializeFieldsOnly(Object, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Serializers.serializeFieldsOnly(Object, boolean)"})
  public void testSerializeFieldsOnly_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", Serializers.serializeFieldsOnly(null, false));
  }

  /**
   * Test {@link Serializers#serializeFieldsOnly(Object, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Serializers#serializeFieldsOnly(Object, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Serializers.serializeFieldsOnly(Object, boolean)"})
  public void testSerializeFieldsOnly_whenTrue() {
    // Arrange, Act and Assert
    assertEquals(
        "\"0000000000000000000000000000000000000000000000000000000000000000\"",
        Serializers.serializeFieldsOnly(DataWord.ZERO(), true));
  }

  /**
   * Test {@link Serializers#createMapper(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Serializers#createMapper(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper Serializers.createMapper(boolean)"})
  public void testCreateMapper_whenFalse() {
    // Arrange and Act
    ObjectMapper actualCreateMapperResult = Serializers.createMapper(false);

    // Assert
    JsonFactory factory = actualCreateMapperResult.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    assertTrue(actualCreateMapperResult.getSerializerProviderInstance() instanceof Impl);
    assertSame(factory, actualCreateMapperResult.getJsonFactory());
  }

  /**
   * Test {@link Serializers#createMapper(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Serializers#createMapper(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper Serializers.createMapper(boolean)"})
  public void testCreateMapper_whenTrue() {
    // Arrange and Act
    ObjectMapper actualCreateMapperResult = Serializers.createMapper(true);

    // Assert
    JsonFactory factory = actualCreateMapperResult.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    assertTrue(actualCreateMapperResult.getSerializerProviderInstance() instanceof Impl);
    assertSame(factory, actualCreateMapperResult.getJsonFactory());
  }
}
