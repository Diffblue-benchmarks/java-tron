package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.protos.contract.SmartContractOuterClass;

public class ContractCapsuleDiffblueTest {
  /**
   * Method under test: {@link ContractCapsule#getCodeHash()}
   */
  @Test
  public void testGetCodeHash() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance())).getCodeHash().length);
  }

  /**
   * Method under test: {@link ContractCapsule#getCodeHash()}
   */
  @Test
  public void testGetCodeHash2() throws UnsupportedEncodingException {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance());
    contractCapsule.setCodeHash("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCodeHash = contractCapsule.getCodeHash();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCodeHash);
  }

  /**
   * Method under test: {@link ContractCapsule#setCodeHash(byte[])}
   */
  @Test
  public void testSetCodeHash() throws UnsupportedEncodingException {
    // Arrange
    SmartContractOuterClass.SmartContract smartContract = SmartContractOuterClass.SmartContract.getDefaultInstance();
    ContractCapsule contractCapsule = new ContractCapsule(smartContract);

    // Act
    contractCapsule.setCodeHash("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SmartContractOuterClass.SmartContract instance = contractCapsule.getInstance();
    ByteString codeHash = instance.getCodeHash();
    assertEquals("AXAXAXAX", codeHash.toStringUtf8());
    byte[] originAddress = contractCapsule.getOriginAddress();
    assertEquals(0, originAddress.length);
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(11, descriptorForType.getFields().size());
    assertFalse(codeHash.isEmpty());
    ByteString.ByteIterator iteratorResult = codeHash.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(originAddress, contractCapsule.getTrxHash());
    assertSame(smartContract, instance.getDefaultInstanceForType());
    byte[] expectedCodeHash = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedCodeHash, contractCapsule.getCodeHash());
    byte[] expectedData = "J\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, contractCapsule.getData());
  }

  /**
   * Method under test: {@link ContractCapsule#setCodeHash(byte[])}
   */
  @Test
  public void testSetCodeHash2() throws UnsupportedEncodingException {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(new byte[]{});

    // Act
    contractCapsule.setCodeHash("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SmartContractOuterClass.SmartContract instance = contractCapsule.getInstance();
    ByteString codeHash = instance.getCodeHash();
    assertEquals("AXAXAXAX", codeHash.toStringUtf8());
    byte[] originAddress = contractCapsule.getOriginAddress();
    assertEquals(0, originAddress.length);
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(11, descriptorForType.getFields().size());
    assertFalse(codeHash.isEmpty());
    ByteString.ByteIterator iteratorResult = codeHash.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(instance.getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(originAddress, contractCapsule.getTrxHash());
    byte[] expectedCodeHash = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedCodeHash, contractCapsule.getCodeHash());
    byte[] expectedData = "J\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, contractCapsule.getData());
  }

  /**
   * Method under test: {@link ContractCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance())).getData().length);
  }

  /**
   * Method under test: {@link ContractCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance());
    contractCapsule.setCodeHash(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertArrayEquals(new byte[]{'J', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, contractCapsule.getData());
  }

  /**
   * Method under test: {@link ContractCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance());
    contractCapsule.setCodeHash(new byte[]{});

    // Act and Assert
    assertEquals(0, contractCapsule.getData().length);
  }

  /**
   * Method under test: {@link ContractCapsule#getInstance()}
   */
  @Test
  public void testGetInstance() {
    // Arrange
    SmartContractOuterClass.SmartContract smartContract = SmartContractOuterClass.SmartContract.getDefaultInstance();

    // Act and Assert
    assertSame(smartContract, (new ContractCapsule(smartContract)).getInstance());
  }

  /**
   * Method under test: {@link ContractCapsule#getOriginAddress()}
   */
  @Test
  public void testGetOriginAddress() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance())).getOriginAddress().length);
  }

  /**
   * Method under test: {@link ContractCapsule#getConsumeUserResourcePercent()}
   */
  @Test
  public void testGetConsumeUserResourcePercent() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()))
        .getConsumeUserResourcePercent());
  }

  /**
   * Method under test: {@link ContractCapsule#getOriginEnergyLimit()}
   */
  @Test
  public void testGetOriginEnergyLimit() {
    // Arrange, Act and Assert
    assertEquals(10000000L,
        (new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance())).getOriginEnergyLimit());
  }

  /**
   * Method under test: {@link ContractCapsule#clearABI()}
   */
  @Test
  public void testClearABI() {
    // Arrange
    SmartContractOuterClass.SmartContract smartContract = SmartContractOuterClass.SmartContract.getDefaultInstance();
    ContractCapsule contractCapsule = new ContractCapsule(smartContract);

    // Act
    contractCapsule.clearABI();

    // Assert
    SmartContractOuterClass.SmartContract instance = contractCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(11, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasAbi());
    assertSame(smartContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{26, 0}, contractCapsule.getData());
  }

  /**
   * Method under test: {@link ContractCapsule#clearABI()}
   */
  @Test
  public void testClearABI2() {
    // Arrange
    SmartContractOuterClass.SmartContract smartContract = SmartContractOuterClass.SmartContract.getDefaultInstance();

    ContractCapsule contractCapsule = new ContractCapsule(smartContract);
    contractCapsule.setCodeHash(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    contractCapsule.clearABI();

    // Assert
    byte[] data = contractCapsule.getData();
    assertEquals((byte) 0, data[1]);
    SmartContractOuterClass.SmartContract instance = contractCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(11, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[0]);
    assertEquals((byte) 2, data[11]);
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasAbi());
    assertEquals('A', data[10]);
    assertEquals('J', data[2]);
    assertEquals('\b', data[3]);
    assertSame(smartContract, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ContractCapsule#clearABI()}
   */
  @Test
  public void testClearABI3() {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(new byte[]{});

    // Act
    contractCapsule.clearABI();

    // Assert
    SmartContractOuterClass.SmartContract instance = contractCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(11, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(instance.getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasAbi());
    assertArrayEquals(new byte[]{26, 0}, contractCapsule.getData());
  }

  /**
   * Method under test: {@link ContractCapsule#getTrxHash()}
   */
  @Test
  public void testGetTrxHash() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance())).getTrxHash().length);
  }

  /**
   * Method under test: {@link ContractCapsule#getContractVersion()}
   */
  @Test
  public void testGetContractVersion() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance())).getContractVersion());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ContractCapsule#ContractCapsule(SmartContractOuterClass.SmartContract)}
   *   <li>{@link ContractCapsule#setRuntimecode(byte[])}
   *   <li>{@link ContractCapsule#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    SmartContractOuterClass.SmartContract smartContract = SmartContractOuterClass.SmartContract.getDefaultInstance();

    // Act
    ContractCapsule actualContractCapsule = new ContractCapsule(smartContract);
    actualContractCapsule.setRuntimecode("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("", actualContractCapsule.toString());
    assertSame(smartContract, actualContractCapsule.getInstance());
  }

  /**
   * Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  public void testNewContractCapsule() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ContractCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new ContractCapsule(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new ContractCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new ContractCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new ContractCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new ContractCapsule("\"XAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new ContractCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new ContractCapsule("(XAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new ContractCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new ContractCapsule("0XAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new ContractCapsule(":XAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new ContractCapsule(new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new ContractCapsule("@XAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new ContractCapsule(new byte[]{'\n', 2, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new ContractCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new ContractCapsule(new byte[]{18, 2, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new ContractCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new ContractCapsule(new byte[]{26, 2, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new ContractCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new ContractCapsule(new byte[]{'"', 2, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new ContractCapsule(new byte[]{'"', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }
}
