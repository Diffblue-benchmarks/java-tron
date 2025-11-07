package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.protos.contract.SmartContractOuterClass;

public class AbiCapsuleDiffblueTest {
  /**
   * Method under test: {@link AbiCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new AbiCapsule(new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance())))
        .getData().length);
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        (new AbiCapsule(
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}))
                .getData());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'},
        (new AbiCapsule(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'}))
            .getData());
  }

  /**
   * Method under test: {@link AbiCapsule#getData()}
   */
  @Test
  public void testGetData2() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualData = (new AbiCapsule("AXAXAXAXAXAXAXAAAXAXAXAX".getBytes("UTF-8"))).getData();

    // Assert
    assertArrayEquals("AXAXAXAXAAAXAXAXAXXAXAXA".getBytes("UTF-8"), actualData);
  }

  /**
   * Method under test:
   * {@link AbiCapsule#AbiCapsule(SmartContractOuterClass.SmartContract.ABI)}
   */
  @Test
  public void testNewAbiCapsule() {
    // Arrange
    SmartContractOuterClass.SmartContract.ABI abi = SmartContractOuterClass.SmartContract.ABI.getDefaultInstance();

    // Act
    AbiCapsule actualAbiCapsule = new AbiCapsule(abi);

    // Assert
    assertEquals(0, actualAbiCapsule.getData().length);
    assertEquals(abi, actualAbiCapsule.getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule4() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule5() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule6() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule7() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule8() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule9() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule10() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("\n\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule11() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, '\b', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule12() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, 16, 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule13() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, 26, 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule14() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, '"', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule15() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, 0, 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule16() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, '*', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule17() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, -1, 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule18() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, '0', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule19() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, '8', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule20() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("\n\n\b\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule21() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(
        new byte[]{'\n', '\n', 16, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'}))
            .getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule22() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("\n\n\"\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule23() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("\n\n*\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule24() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("\n\n0\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule25() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("\n\n8\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  public void testNewAbiCapsule26() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, '@', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link AbiCapsule#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("",
        (new AbiCapsule(new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()))).toString());
  }
}
