package org.tron.common.bloom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.capsule.TransactionRetCapsule;

public class BloomDiffblueTest {
  /**
   * Test {@link Bloom#Bloom()}.
   *
   * <p>Method under test: {@link Bloom#Bloom()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Bloom.<init>()"})
  public void testNewBloom() {
    // Arrange, Act and Assert
    assertEquals(Bloom.BLOOM_BYTE_SIZE, new Bloom().getData().length);
  }

  /**
   * Test {@link Bloom#Bloom(byte[])}.
   *
   * <p>Method under test: {@link Bloom#Bloom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Bloom.<init>(byte[])"})
  public void testNewBloom2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new Bloom("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Bloom#getLowBits(int)}.
   *
   * <p>Method under test: {@link Bloom#getLowBits(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Bloom.getLowBits(int)"})
  public void testGetLowBits() {
    // Arrange, Act and Assert
    assertEquals(0, Bloom.getLowBits(3));
  }

  /**
   * Test {@link Bloom#create(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return array length is {@link Bloom#BLOOM_BYTE_SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link Bloom#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Bloom Bloom.create(byte[])"})
  public void testCreate_whenAxaxaxaxBytesIsUtf8_thenReturnArrayLengthIsBloom_byte_size()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        Bloom.BLOOM_BYTE_SIZE, Bloom.create("AXAXAXAX".getBytes("UTF-8")).getData().length);
  }

  /**
   * Test {@link Bloom#createBloom(TransactionRetCapsule)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link Bloom#createBloom(TransactionRetCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Bloom Bloom.createBloom(TransactionRetCapsule)"})
  public void testCreateBloom_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    TransactionRetCapsule transactionRetCapsule = mock(TransactionRetCapsule.class);
    when(transactionRetCapsule.getInstance()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Bloom.createBloom(transactionRetCapsule));
    verify(transactionRetCapsule).getInstance();
  }

  /**
   * Test {@link Bloom#createBloom(TransactionRetCapsule)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Bloom#createBloom(TransactionRetCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Bloom Bloom.createBloom(TransactionRetCapsule)"})
  public void testCreateBloom_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Bloom.createBloom(null));
  }

  /**
   * Test {@link Bloom#createBloom(TransactionRetCapsule)}.
   *
   * <ul>
   *   <li>When {@link TransactionRetCapsule#TransactionRetCapsule()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Bloom#createBloom(TransactionRetCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Bloom Bloom.createBloom(TransactionRetCapsule)"})
  public void testCreateBloom_whenTransactionRetCapsule_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Bloom.createBloom(new TransactionRetCapsule()));
  }

  /**
   * Test {@link Bloom#matches(Bloom)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Bloom#matches(Bloom)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Bloom.matches(Bloom)"})
  public void testMatches_whenA_thenReturnFalse() {
    // Arrange
    Bloom bloom = new Bloom();

    // Act and Assert
    assertFalse(bloom.matches(Bloom.create(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Test {@link Bloom#matches(Bloom)}.
   *
   * <ul>
   *   <li>When {@link Bloom#Bloom()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Bloom#matches(Bloom)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Bloom.matches(Bloom)"})
  public void testMatches_whenBloom_thenReturnTrue() {
    // Arrange
    Bloom bloom = new Bloom();

    // Act and Assert
    assertTrue(bloom.matches(new Bloom()));
  }

  /**
   * Test {@link Bloom#getData()}.
   *
   * <p>Method under test: {@link Bloom#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Bloom.getData()", "java.lang.String Bloom.toString()"})
  public void testGetData() {
    // Arrange and Act
    byte[] actualData = new Bloom().getData();

    // Assert
    assertEquals((byte) 0, actualData[0]);
    assertEquals((byte) 0, actualData[1]);
    assertEquals((byte) 0, actualData[10]);
    assertEquals((byte) 0, actualData[11]);
    assertEquals((byte) 0, actualData[12]);
    assertEquals((byte) 0, actualData[13]);
    assertEquals((byte) 0, actualData[14]);
    assertEquals((byte) 0, actualData[15]);
    assertEquals((byte) 0, actualData[17]);
    assertEquals((byte) 0, actualData[18]);
    assertEquals((byte) 0, actualData[19]);
    assertEquals((byte) 0, actualData[2]);
    assertEquals((byte) 0, actualData[20]);
    assertEquals((byte) 0, actualData[21]);
    assertEquals((byte) 0, actualData[22]);
    assertEquals((byte) 0, actualData[23]);
    assertEquals((byte) 0, actualData[231]);
    assertEquals((byte) 0, actualData[232]);
    assertEquals((byte) 0, actualData[233]);
    assertEquals((byte) 0, actualData[234]);
    assertEquals((byte) 0, actualData[235]);
    assertEquals((byte) 0, actualData[236]);
    assertEquals((byte) 0, actualData[237]);
    assertEquals((byte) 0, actualData[238]);
    assertEquals((byte) 0, actualData[239]);
    assertEquals((byte) 0, actualData[24]);
    assertEquals((byte) 0, actualData[240]);
    assertEquals((byte) 0, actualData[241]);
    assertEquals((byte) 0, actualData[242]);
    assertEquals((byte) 0, actualData[243]);
    assertEquals((byte) 0, actualData[244]);
    assertEquals((byte) 0, actualData[245]);
    assertEquals((byte) 0, actualData[246]);
    assertEquals((byte) 0, actualData[247]);
    assertEquals((byte) 0, actualData[248]);
    assertEquals((byte) 0, actualData[249]);
    assertEquals((byte) 0, actualData[250]);
    assertEquals((byte) 0, actualData[251]);
    assertEquals((byte) 0, actualData[252]);
    assertEquals((byte) 0, actualData[253]);
    assertEquals((byte) 0, actualData[254]);
    assertEquals((byte) 0, actualData[255]);
    assertEquals((byte) 0, actualData[3]);
    assertEquals((byte) 0, actualData[4]);
    assertEquals((byte) 0, actualData[5]);
    assertEquals((byte) 0, actualData[6]);
    assertEquals((byte) 0, actualData[7]);
    assertEquals((byte) 0, actualData[8]);
    assertEquals((byte) 0, actualData[9]);
    assertEquals((byte) 0, actualData[Short.SIZE]);
    assertEquals(Bloom.BLOOM_BYTE_SIZE, actualData.length);
  }

  /**
   * Test {@link Bloom#copy()}.
   *
   * <p>Method under test: {@link Bloom#copy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Bloom Bloom.copy()"})
  public void testCopy() {
    // Arrange
    Bloom bloom = new Bloom();

    // Act
    Bloom actualCopyResult = bloom.copy();

    // Assert
    assertEquals(bloom, actualCopyResult);
  }

  /**
   * Test {@link Bloom#equals(Object)}, and {@link Bloom#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Bloom#equals(Object)}
   *   <li>{@link Bloom#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Bloom.equals(Object)", "int Bloom.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Bloom bloom = new Bloom();
    Bloom bloom2 = new Bloom();

    // Act and Assert
    assertEquals(bloom, bloom2);
    assertEquals(bloom.hashCode(), bloom2.hashCode());
  }

  /**
   * Test {@link Bloom#equals(Object)}, and {@link Bloom#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Bloom#equals(Object)}
   *   <li>{@link Bloom#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Bloom.equals(Object)", "int Bloom.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Bloom bloom = new Bloom();

    // Act and Assert
    assertEquals(bloom, bloom);
    int expectedHashCodeResult = bloom.hashCode();
    assertEquals(expectedHashCodeResult, bloom.hashCode());
  }

  /**
   * Test {@link Bloom#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Bloom#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Bloom.equals(Object)", "int Bloom.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual()
      throws UnsupportedEncodingException {
    // Arrange
    Bloom createResult = Bloom.create("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(createResult, new Bloom());
  }

  /**
   * Test {@link Bloom#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Bloom#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Bloom.equals(Object)", "int Bloom.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Bloom(), null);
  }

  /**
   * Test {@link Bloom#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Bloom#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Bloom.equals(Object)", "int Bloom.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Bloom(), "Different type to Bloom");
  }
}
