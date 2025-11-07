package org.tron.common.bloom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.capsule.TransactionRetCapsule;
import org.tron.protos.Protocol;

public class BloomDiffblueTest {
  /**
   * Method under test: {@link Bloom#getLowBits(int)}
   */
  @Test
  public void testGetLowBits() {
    // Arrange, Act and Assert
    assertEquals(0, Bloom.getLowBits(3));
  }

  /**
   * Method under test: {@link Bloom#create(byte[])}
   */
  @Test
  public void testCreate() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    byte[] data = Bloom.create("AXAXAXAX".getBytes("UTF-8")).getData();
    assertEquals((byte) 0, data[0]);
    assertEquals((byte) 0, data[1]);
    assertEquals((byte) 0, data[10]);
    assertEquals((byte) 0, data[11]);
    assertEquals((byte) 0, data[12]);
    assertEquals((byte) 0, data[13]);
    assertEquals((byte) 0, data[14]);
    assertEquals((byte) 0, data[15]);
    assertEquals((byte) 0, data[17]);
    assertEquals((byte) 0, data[18]);
    assertEquals((byte) 0, data[19]);
    assertEquals((byte) 0, data[2]);
    assertEquals((byte) 0, data[20]);
    assertEquals((byte) 0, data[21]);
    assertEquals((byte) 0, data[22]);
    assertEquals((byte) 0, data[23]);
    assertEquals((byte) 0, data[231]);
    assertEquals((byte) 0, data[232]);
    assertEquals((byte) 0, data[233]);
    assertEquals((byte) 0, data[234]);
    assertEquals((byte) 0, data[235]);
    assertEquals((byte) 0, data[236]);
    assertEquals((byte) 0, data[237]);
    assertEquals((byte) 0, data[238]);
    assertEquals((byte) 0, data[239]);
    assertEquals((byte) 0, data[24]);
    assertEquals((byte) 0, data[240]);
    assertEquals((byte) 0, data[241]);
    assertEquals((byte) 0, data[242]);
    assertEquals((byte) 0, data[243]);
    assertEquals((byte) 0, data[244]);
    assertEquals((byte) 0, data[245]);
    assertEquals((byte) 0, data[246]);
    assertEquals((byte) 0, data[247]);
    assertEquals((byte) 0, data[248]);
    assertEquals((byte) 0, data[249]);
    assertEquals((byte) 0, data[250]);
    assertEquals((byte) 0, data[251]);
    assertEquals((byte) 0, data[252]);
    assertEquals((byte) 0, data[253]);
    assertEquals((byte) 0, data[254]);
    assertEquals((byte) 0, data[255]);
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 0, data[4]);
    assertEquals((byte) 0, data[5]);
    assertEquals((byte) 0, data[6]);
    assertEquals((byte) 0, data[7]);
    assertEquals((byte) 0, data[8]);
    assertEquals((byte) 0, data[9]);
    assertEquals((byte) 0, data[Short.SIZE]);
    assertEquals(Bloom.BLOOM_BYTE_SIZE, data.length);
  }

  /**
   * Method under test: {@link Bloom#createBloom(TransactionRetCapsule)}
   */
  @Test
  public void testCreateBloom() {
    // Arrange, Act and Assert
    assertNull(Bloom.createBloom(new TransactionRetCapsule()));
    assertNull(Bloom.createBloom(null));
  }

  /**
   * Method under test: {@link Bloom#createBloom(TransactionRetCapsule)}
   */
  @Test
  public void testCreateBloom2() {
    // Arrange
    TransactionRetCapsule transactionRetCapsule = new TransactionRetCapsule();
    transactionRetCapsule.addTransactionInfo(Protocol.TransactionInfo.getDefaultInstance());

    // Act and Assert
    assertNull(Bloom.createBloom(transactionRetCapsule));
  }

  /**
   * Method under test: {@link Bloom#matches(Bloom)}
   */
  @Test
  public void testMatches() {
    // Arrange
    Bloom bloom = new Bloom();

    // Act and Assert
    assertTrue(bloom.matches(new Bloom()));
  }

  /**
   * Method under test: {@link Bloom#matches(Bloom)}
   */
  @Test
  public void testMatches2() {
    // Arrange
    Bloom bloom = new Bloom();

    // Act and Assert
    assertFalse(bloom.matches(Bloom.create(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Method under test: {@link Bloom#copy()}
   */
  @Test
  public void testCopy() {
    // Arrange
    Bloom bloom = new Bloom();

    // Act and Assert
    assertEquals(bloom, bloom.copy());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Bloom#equals(Object)}
   *   <li>{@link Bloom#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Bloom bloom = new Bloom();
    Bloom bloom2 = new Bloom();

    // Act and Assert
    assertEquals(bloom, bloom2);
    int expectedHashCodeResult = bloom.hashCode();
    assertEquals(expectedHashCodeResult, bloom2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Bloom#equals(Object)}
   *   <li>{@link Bloom#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Bloom bloom = new Bloom();

    // Act and Assert
    assertEquals(bloom, bloom);
    int expectedHashCodeResult = bloom.hashCode();
    assertEquals(expectedHashCodeResult, bloom.hashCode());
  }

  /**
   * Method under test: {@link Bloom#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    Bloom createResult = Bloom.create("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(createResult, new Bloom());
  }

  /**
   * Method under test: {@link Bloom#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Bloom(), null);
  }

  /**
   * Method under test: {@link Bloom#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Bloom(), "Different type to Bloom");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Bloom#toString()}
   *   <li>{@link Bloom#getData()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Bloom bloom = new Bloom();

    // Act
    String actualToStringResult = bloom.toString();
    byte[] actualData = bloom.getData();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "000000000000", actualToStringResult);
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
   * Method under test: {@link Bloom#Bloom()}
   */
  @Test
  public void testNewBloom() {
    // Arrange, Act and Assert
    byte[] data = (new Bloom()).getData();
    assertEquals((byte) 0, data[0]);
    assertEquals((byte) 0, data[1]);
    assertEquals((byte) 0, data[10]);
    assertEquals((byte) 0, data[11]);
    assertEquals((byte) 0, data[12]);
    assertEquals((byte) 0, data[13]);
    assertEquals((byte) 0, data[14]);
    assertEquals((byte) 0, data[15]);
    assertEquals((byte) 0, data[17]);
    assertEquals((byte) 0, data[18]);
    assertEquals((byte) 0, data[19]);
    assertEquals((byte) 0, data[2]);
    assertEquals((byte) 0, data[20]);
    assertEquals((byte) 0, data[21]);
    assertEquals((byte) 0, data[22]);
    assertEquals((byte) 0, data[23]);
    assertEquals((byte) 0, data[231]);
    assertEquals((byte) 0, data[232]);
    assertEquals((byte) 0, data[233]);
    assertEquals((byte) 0, data[234]);
    assertEquals((byte) 0, data[235]);
    assertEquals((byte) 0, data[236]);
    assertEquals((byte) 0, data[237]);
    assertEquals((byte) 0, data[238]);
    assertEquals((byte) 0, data[239]);
    assertEquals((byte) 0, data[24]);
    assertEquals((byte) 0, data[240]);
    assertEquals((byte) 0, data[241]);
    assertEquals((byte) 0, data[242]);
    assertEquals((byte) 0, data[243]);
    assertEquals((byte) 0, data[244]);
    assertEquals((byte) 0, data[245]);
    assertEquals((byte) 0, data[246]);
    assertEquals((byte) 0, data[247]);
    assertEquals((byte) 0, data[248]);
    assertEquals((byte) 0, data[249]);
    assertEquals((byte) 0, data[250]);
    assertEquals((byte) 0, data[251]);
    assertEquals((byte) 0, data[252]);
    assertEquals((byte) 0, data[253]);
    assertEquals((byte) 0, data[254]);
    assertEquals((byte) 0, data[255]);
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 0, data[4]);
    assertEquals((byte) 0, data[5]);
    assertEquals((byte) 0, data[6]);
    assertEquals((byte) 0, data[7]);
    assertEquals((byte) 0, data[8]);
    assertEquals((byte) 0, data[9]);
    assertEquals((byte) 0, data[Short.SIZE]);
    assertEquals(Bloom.BLOOM_BYTE_SIZE, data.length);
  }

  /**
   * Method under test: {@link Bloom#Bloom(byte[])}
   */
  @Test
  public void testNewBloom2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new Bloom("AXAXAXAX".getBytes("UTF-8")));
  }
}
