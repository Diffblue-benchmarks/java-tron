package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.exception.BadItemException;
import org.tron.protos.Protocol;

public class BlockCapsuleDiffblueTest {
  /**
   * Method under test: {@link BlockCapsule#addAllTransactions(List)}
   */
  @Test
  public void testAddAllTransactions() {
    // Arrange
    Protocol.Block block = Protocol.Block.getDefaultInstance();
    BlockCapsule blockCapsule = new BlockCapsule(block);

    // Act
    blockCapsule.addAllTransactions(new ArrayList<>());

    // Assert
    assertEquals(block, blockCapsule.getInstance());
  }

  /**
   * Method under test: {@link BlockCapsule.BlockId#compareTo(Sha256Hash)}
   */
  @Test
  public void testBlockIdCompareTo() {
    // Arrange
    BlockCapsule.BlockId blockId = new BlockCapsule.BlockId();

    // Act and Assert
    assertEquals(0, blockId.compareTo(new BlockCapsule.BlockId()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BlockCapsule.BlockId#equals(Object)}
   *   <li>{@link BlockCapsule.BlockId#hashCode()}
   * </ul>
   */
  @Test
  public void testBlockIdEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BlockCapsule.BlockId blockId = new BlockCapsule.BlockId();
    BlockCapsule.BlockId blockId2 = new BlockCapsule.BlockId();

    // Act and Assert
    assertEquals(blockId, blockId2);
    int expectedHashCodeResult = blockId.hashCode();
    assertEquals(expectedHashCodeResult, blockId2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BlockCapsule.BlockId#equals(Object)}
   *   <li>{@link BlockCapsule.BlockId#hashCode()}
   * </ul>
   */
  @Test
  public void testBlockIdEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BlockCapsule.BlockId blockId = new BlockCapsule.BlockId();

    // Act and Assert
    assertEquals(blockId, blockId);
    int expectedHashCodeResult = blockId.hashCode();
    assertEquals(expectedHashCodeResult, blockId.hashCode());
  }

  /**
   * Method under test: {@link BlockCapsule.BlockId#equals(Object)}
   */
  @Test
  public void testBlockIdEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BlockCapsule.BlockId(), null);
  }

  /**
   * Method under test: {@link BlockCapsule.BlockId#equals(Object)}
   */
  @Test
  public void testBlockIdEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws UnsupportedEncodingException {
    // Arrange
    BlockCapsule.BlockId blockId = new BlockCapsule.BlockId();
    Sha256Hash sha256Hash = mock(Sha256Hash.class);
    when(sha256Hash.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(blockId, sha256Hash);
  }

  /**
   * Method under test: {@link BlockCapsule.BlockId#equals(Object)}
   */
  @Test
  public void testBlockIdEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BlockCapsule.BlockId(), null);
  }

  /**
   * Method under test: {@link BlockCapsule.BlockId#equals(Object)}
   */
  @Test
  public void testBlockIdEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BlockCapsule.BlockId(), "Different type to BlockId");
  }

  /**
   * Method under test: {@link BlockCapsule.BlockId#getString()}
   */
  @Test
  public void testBlockIdGetString() {
    // Arrange, Act and Assert
    assertEquals("Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000",
        (new BlockCapsule.BlockId()).getString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BlockCapsule.BlockId#toString()}
   *   <li>{@link BlockCapsule.BlockId#getNum()}
   * </ul>
   */
  @Test
  public void testBlockIdGettersAndSetters() {
    // Arrange
    BlockCapsule.BlockId blockId = new BlockCapsule.BlockId();

    // Act
    String actualToStringResult = blockId.toString();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", actualToStringResult);
    assertEquals(0L, blockId.getNum());
  }

  /**
   * Method under test: {@link BlockCapsule.BlockId#BlockId()}
   */
  @Test
  public void testBlockIdNewBlockId() {
    // Arrange and Act
    BlockCapsule.BlockId actualBlockId = new BlockCapsule.BlockId();

    // Assert
    BigInteger toBigIntegerResult = actualBlockId.toBigInteger();
    assertEquals("0", toBigIntegerResult.toString());
    assertEquals("Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000",
        actualBlockId.getString());
    ByteString byteString = actualBlockId.getByteString();
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        byteString.toStringUtf8());
    assertEquals(-1, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, toBigIntegerResult.signum());
    assertEquals(0L, actualBlockId.getNum());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertFalse(byteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertArrayEquals(new byte[]{0}, toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualBlockId.getBytes());
  }

  /**
   * Method under test: {@link BlockCapsule.BlockId#BlockId(Sha256Hash)}
   */
  @Test
  public void testBlockIdNewBlockId2() {
    // Arrange
    BlockCapsule.BlockId blockId = new BlockCapsule.BlockId();

    // Act and Assert
    assertEquals(blockId, new BlockCapsule.BlockId(blockId));
  }

  /**
   * Method under test: {@link BlockCapsule#getBlockId()}
   */
  @Test
  public void testGetBlockId() {
    // Arrange
    BlockCapsule blockCapsule = new BlockCapsule(Protocol.Block.getDefaultInstance());

    // Act
    BlockCapsule.BlockId actualBlockId = blockCapsule.getBlockId();

    // Assert
    BigInteger toBigIntegerResult = actualBlockId.toBigInteger();
    assertEquals("3800201620905452580889821578709714074795303883058992822357", toBigIntegerResult.toString());
    assertEquals("Num:0,ID:00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualBlockId.getString());
    ByteString byteString = actualBlockId.getByteString();
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000���șo�$'�A�d��L���\u001bxR�U",
        byteString.toStringUtf8());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0L, actualBlockId.getNum());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals(1, toBigIntegerResult.signum());
    assertFalse(byteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
    Sha256Hash expectedAccountRoot = actualBlockId.ZERO_HASH;
    assertSame(expectedAccountRoot, blockCapsule.getAccountRoot());
    assertArrayEquals(new byte[]{0, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28, 'd', -101, -109, 'L',
        -92, -107, -103, 27, 'x', 'R', -72, 'U'}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
        'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, actualBlockId.getBytes());
  }

  /**
   * Method under test: {@link BlockCapsule#calcMerkleRoot()}
   */
  @Test
  public void testCalcMerkleRoot() {
    // Arrange
    BlockCapsule blockCapsule = new BlockCapsule(Protocol.Block.getDefaultInstance());

    // Act
    Sha256Hash actualCalcMerkleRootResult = blockCapsule.calcMerkleRoot();

    // Assert
    Sha256Hash sha256Hash = actualCalcMerkleRootResult.ZERO_HASH;
    assertSame(sha256Hash, actualCalcMerkleRootResult);
    assertSame(sha256Hash, blockCapsule.getAccountRoot());
  }

  /**
   * Method under test: {@link BlockCapsule#setMerkleRoot()}
   */
  @Test
  public void testSetMerkleRoot() {
    // Arrange
    Protocol.Block block = Protocol.Block.getDefaultInstance();
    BlockCapsule blockCapsule = new BlockCapsule(block);

    // Act
    blockCapsule.setMerkleRoot();

    // Assert
    Protocol.Block instance = blockCapsule.getInstance();
    Protocol.BlockHeader blockHeader = instance.getBlockHeader();
    Protocol.BlockHeader defaultInstanceForType = blockHeader.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Protocol.BlockHeader.raw rawData = defaultInstanceForType.getRawData();
    assertEquals("", rawData.getInitializationErrorString());
    BlockCapsule.BlockId blockId = blockCapsule.getBlockId();
    BigInteger toBigIntegerResult = blockId.toBigInteger();
    assertEquals("722071150394556400884935433031103754102306678425247192920", toBigIntegerResult.toString());
    assertEquals("Num:0,ID:00000000000000001d72c649f8a4ab55139b439af76ea34d4425e7bda93a9758", blockId.getString());
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u001dr�I���U\u0013�C��n�MD%罩:�X",
        blockId.getByteString().toStringUtf8());
    byte[] bytes = blockId.getBytes();
    assertEquals((byte) -101, bytes[17]);
    assertEquals((byte) -102, bytes[19]);
    assertEquals((byte) -105, bytes[30]);
    assertEquals((byte) -25, bytes[26]);
    assertEquals((byte) -58, bytes[10]);
    assertEquals((byte) -67, bytes[27]);
    assertEquals((byte) -85, bytes[14]);
    assertEquals((byte) -87, bytes[28]);
    assertEquals((byte) -8, bytes[12]);
    assertEquals((byte) -92, bytes[13]);
    assertEquals((byte) -93, bytes[22]);
    assertEquals((byte) -9, bytes[20]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, rawData.getSerializedSize());
    assertEquals(0, rawData.getVersion());
    assertEquals(0L, rawData.getNumber());
    assertEquals(0L, rawData.getTimestamp());
    assertEquals(0L, rawData.getWitnessId());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, blockHeader.getAllFields().size());
    Protocol.BlockHeader.raw rawData2 = blockHeader.getRawData();
    assertEquals(1, rawData2.getAllFields().size());
    assertEquals((byte) 19, bytes[Short.SIZE]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals((byte) 29, bytes[8]);
    assertEquals(3, toBigIntegerResult.getLowestSetBit());
    assertEquals(34, rawData2.getSerializedSize());
    assertEquals(36, blockHeader.getSerializedSize());
    assertEquals(38, instance.getSerializedSize());
    assertEquals(38L, blockCapsule.getSerializedSize());
    assertFalse(blockCapsule.isMerkleRootEmpty());
    assertFalse(defaultInstanceForType.hasRawData());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(rawData.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(rawData.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasBlockHeader());
    assertTrue(blockHeader.hasRawData());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(rawData.isInitialized());
    assertEquals(Integer.SIZE, bytes.length);
    assertEquals('%', bytes[25]);
    assertEquals(':', bytes[29]);
    assertEquals('C', bytes[18]);
    assertEquals('D', bytes[24]);
    assertEquals('I', bytes[11]);
    assertEquals('M', bytes[23]);
    assertEquals('U', bytes[15]);
    assertEquals('X', bytes[31]);
    assertEquals('n', bytes[21]);
    assertEquals('r', bytes[9]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(rawData, defaultInstanceForType.getRawDataOrBuilder());
    assertSame(rawData, rawData2.getDefaultInstanceForType());
    assertSame(rawData, rawData.getDefaultInstanceForType());
    assertSame(block, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{29, 'r', -58, 'I', -8, -92, -85, 'U', 19, -101, 'C', -102, -9, 'n', -93, 'M', 'D', '%',
        -25, -67, -87, ':', -105, 'X'}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{18, '$', '\n', '"', 18, ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, blockCapsule.getData());
  }

  /**
   * Method under test: {@link BlockCapsule#setAccountStateRoot(byte[])}
   */
  @Test
  public void testSetAccountStateRoot() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Block block = Protocol.Block.getDefaultInstance();
    BlockCapsule blockCapsule = new BlockCapsule(block);

    // Act
    blockCapsule.setAccountStateRoot("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.Block instance = blockCapsule.getInstance();
    Protocol.BlockHeader blockHeader = instance.getBlockHeader();
    Protocol.BlockHeader defaultInstanceForType = blockHeader.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Protocol.BlockHeader.raw rawData = defaultInstanceForType.getRawData();
    assertEquals("", rawData.getInitializationErrorString());
    BlockCapsule.BlockId blockId = blockCapsule.getBlockId();
    BigInteger toBigIntegerResult = blockId.toBigInteger();
    assertEquals("1951008271384299538986167461928191100453722984819457538283", toBigIntegerResult.toString());
    Protocol.BlockHeader.raw rawData2 = blockHeader.getRawData();
    ByteString accountStateRoot = rawData2.getAccountStateRoot();
    assertEquals("AXAXAXAX", accountStateRoot.toStringUtf8());
    assertEquals("Num:0,ID:00000000000000004f917a0e8dfab76ab8da58cb3befebb7afb9091e673838eb", blockId.getString());
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000O�z\u000e���j��X�;�뷯�\t\u001eg88�",
        blockId.getByteString().toStringUtf8());
    byte[] bytes = blockId.getBytes();
    assertEquals((byte) -111, bytes[9]);
    assertEquals((byte) -115, bytes[12]);
    assertEquals((byte) -17, bytes[21]);
    assertEquals((byte) -21, bytes[22]);
    assertEquals((byte) -21, bytes[31]);
    assertEquals((byte) -38, bytes[17]);
    assertEquals((byte) -53, bytes[19]);
    assertEquals((byte) -6, bytes[13]);
    assertEquals((byte) -71, bytes[25]);
    assertEquals((byte) -72, bytes[Short.SIZE]);
    assertEquals((byte) -73, bytes[14]);
    assertEquals((byte) -73, bytes[23]);
    assertEquals((byte) -81, bytes[24]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, rawData.getSerializedSize());
    assertEquals(0, rawData.getVersion());
    assertEquals(0L, rawData.getNumber());
    assertEquals(0L, rawData.getTimestamp());
    assertEquals(0L, rawData.getWitnessId());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, blockHeader.getAllFields().size());
    assertEquals(1, rawData2.getAllFields().size());
    assertEquals(10, rawData2.getSerializedSize());
    assertEquals(12, blockHeader.getSerializedSize());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(14L, blockCapsule.getSerializedSize());
    assertEquals((byte) 14, bytes[11]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals((byte) 30, bytes[27]);
    assertFalse(accountStateRoot.isEmpty());
    assertFalse(defaultInstanceForType.hasRawData());
    ByteString.ByteIterator iteratorResult = accountStateRoot.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(rawData.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(rawData.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasBlockHeader());
    assertTrue(blockHeader.hasRawData());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(rawData.isInitialized());
    assertEquals(Integer.SIZE, bytes.length);
    assertEquals('8', bytes[29]);
    assertEquals('8', bytes[30]);
    assertEquals(';', bytes[20]);
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('O', bytes[8]);
    assertEquals('X', bytes[18]);
    assertEquals('\t', bytes[26]);
    assertEquals('g', bytes[28]);
    assertEquals('j', bytes[15]);
    assertEquals('z', bytes[10]);
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(rawData, defaultInstanceForType.getRawDataOrBuilder());
    assertSame(rawData, rawData2.getDefaultInstanceForType());
    assertSame(rawData, rawData.getDefaultInstanceForType());
    assertSame(block, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{18, '\f', '\n', '\n', 'Z', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        blockCapsule.getData());
    assertArrayEquals(new byte[]{'O', -111, 'z', 14, -115, -6, -73, 'j', -72, -38, 'X', -53, ';', -17, -21, -73, -81,
        -71, '\t', 30, 'g', '8', '8', -21}, toBigIntegerResult.toByteArray());
  }

  /**
   * Method under test: {@link BlockCapsule#setWitness(String)}
   */
  @Test
  public void testSetWitness() {
    // Arrange
    Protocol.Block block = Protocol.Block.getDefaultInstance();
    BlockCapsule blockCapsule = new BlockCapsule(block);

    // Act
    blockCapsule.setWitness("Witness");

    // Assert
    Protocol.Block instance = blockCapsule.getInstance();
    Protocol.BlockHeader blockHeader = instance.getBlockHeader();
    Protocol.BlockHeader defaultInstanceForType = blockHeader.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Protocol.BlockHeader.raw rawData = defaultInstanceForType.getRawData();
    assertEquals("", rawData.getInitializationErrorString());
    BlockCapsule.BlockId blockId = blockCapsule.getBlockId();
    BigInteger toBigIntegerResult = blockId.toBigInteger();
    assertEquals("67796618746533791609102070570871144665933427388817161919", toBigIntegerResult.toString());
    assertEquals("Num:0,ID:000000000000000002c3d468f8fdda5efef50dcf8f39c101269841f3a1d53ebf", blockId.getString());
    ByteString witnessAddress = blockCapsule.getWitnessAddress();
    assertEquals("Witness", witnessAddress.toStringUtf8());
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0002��h���^��\rϏ9�\u0001&�A��>�",
        blockId.getByteString().toStringUtf8());
    byte[] bytes = blockId.getBytes();
    assertEquals((byte) -104, bytes[25]);
    assertEquals((byte) -113, bytes[20]);
    assertEquals((byte) -11, bytes[17]);
    assertEquals((byte) -13, bytes[27]);
    assertEquals((byte) -2, bytes[Short.SIZE]);
    assertEquals((byte) -38, bytes[14]);
    assertEquals((byte) -3, bytes[13]);
    assertEquals((byte) -43, bytes[29]);
    assertEquals((byte) -44, bytes[10]);
    assertEquals((byte) -49, bytes[19]);
    assertEquals((byte) -61, bytes[9]);
    assertEquals((byte) -63, bytes[22]);
    assertEquals((byte) -65, bytes[31]);
    assertEquals((byte) -8, bytes[12]);
    assertEquals((byte) -95, bytes[28]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, rawData.getSerializedSize());
    assertEquals(0, rawData.getVersion());
    assertEquals(0L, rawData.getNumber());
    assertEquals(0L, rawData.getTimestamp());
    assertEquals(0L, rawData.getWitnessId());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, blockHeader.getAllFields().size());
    Protocol.BlockHeader.raw rawData2 = blockHeader.getRawData();
    assertEquals(1, rawData2.getAllFields().size());
    assertEquals(11, blockHeader.getSerializedSize());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(13L, blockCapsule.getSerializedSize());
    assertEquals((byte) 1, bytes[23]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals((byte) 2, bytes[8]);
    assertEquals(9, rawData2.getSerializedSize());
    assertFalse(witnessAddress.isEmpty());
    assertFalse(defaultInstanceForType.hasRawData());
    ByteString.ByteIterator iteratorResult = witnessAddress.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(rawData.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(rawData.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasBlockHeader());
    assertTrue(blockHeader.hasRawData());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(rawData.isInitialized());
    assertEquals(Integer.SIZE, bytes.length);
    assertEquals('&', bytes[24]);
    assertEquals('9', bytes[21]);
    assertEquals('>', bytes[30]);
    assertEquals('A', bytes[26]);
    assertEquals('W', iteratorResult.next().byteValue());
    assertEquals('\r', bytes[18]);
    assertEquals('^', bytes[15]);
    assertEquals('h', bytes[11]);
    assertEquals('i', iteratorResult.next().byteValue());
    assertEquals('t', iteratorResult.next().byteValue());
    assertSame(witnessAddress, rawData2.getWitnessAddress());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(rawData, defaultInstanceForType.getRawDataOrBuilder());
    assertSame(rawData, rawData2.getDefaultInstanceForType());
    assertSame(rawData, rawData.getDefaultInstanceForType());
    assertSame(block, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{18, 11, '\n', '\t', 'J', 7, 'W', 'i', 't', 'n', 'e', 's', 's'},
        blockCapsule.getData());
    assertArrayEquals(new byte[]{2, -61, -44, 'h', -8, -3, -38, '^', -2, -11, '\r', -49, -113, '9', -63, 1, '&', -104,
        'A', -13, -95, -43, '>', -65}, toBigIntegerResult.toByteArray());
  }

  /**
   * Method under test: {@link BlockCapsule#getAccountRoot()}
   */
  @Test
  public void testGetAccountRoot() {
    // Arrange and Act
    Sha256Hash actualAccountRoot = (new BlockCapsule(Protocol.Block.getDefaultInstance())).getAccountRoot();

    // Assert
    assertSame(actualAccountRoot.ZERO_HASH, actualAccountRoot);
  }

  /**
   * Method under test: {@link BlockCapsule#getWitnessAddress()}
   */
  @Test
  public void testGetWitnessAddress() {
    // Arrange
    Protocol.Block block = Protocol.Block.getDefaultInstance();
    BlockCapsule blockCapsule = new BlockCapsule(block);

    // Act
    ByteString actualWitnessAddress = blockCapsule.getWitnessAddress();

    // Assert
    assertSame(block, blockCapsule.getInstance());
    ByteString byteString = actualWitnessAddress.EMPTY;
    assertSame(byteString, blockCapsule.getParentHashStr());
    assertSame(byteString, actualWitnessAddress);
  }

  /**
   * Method under test: {@link BlockCapsule#isMerkleRootEmpty()}
   */
  @Test
  public void testIsMerkleRootEmpty() {
    // Arrange, Act and Assert
    assertTrue((new BlockCapsule(Protocol.Block.getDefaultInstance())).isMerkleRootEmpty());
  }

  /**
   * Method under test: {@link BlockCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new BlockCapsule(Protocol.Block.getDefaultInstance())).getData().length);
  }

  /**
   * Method under test: {@link BlockCapsule#getInstance()}
   */
  @Test
  public void testGetInstance() {
    // Arrange
    Protocol.Block block = Protocol.Block.getDefaultInstance();

    // Act and Assert
    assertSame(block, (new BlockCapsule(block)).getInstance());
  }

  /**
   * Method under test: {@link BlockCapsule#getSerializedSize()}
   */
  @Test
  public void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0L, (new BlockCapsule(Protocol.Block.getDefaultInstance())).getSerializedSize());
  }

  /**
   * Method under test: {@link BlockCapsule#getParentHashStr()}
   */
  @Test
  public void testGetParentHashStr() {
    // Arrange
    Protocol.Block block = Protocol.Block.getDefaultInstance();
    BlockCapsule blockCapsule = new BlockCapsule(block);

    // Act
    ByteString actualParentHashStr = blockCapsule.getParentHashStr();

    // Assert
    assertSame(block, blockCapsule.getInstance());
    ByteString byteString = actualParentHashStr.EMPTY;
    assertSame(byteString, actualParentHashStr);
    assertSame(byteString, blockCapsule.getWitnessAddress());
  }

  /**
   * Method under test: {@link BlockCapsule#getNum()}
   */
  @Test
  public void testGetNum() {
    // Arrange, Act and Assert
    assertEquals(0L, (new BlockCapsule(Protocol.Block.getDefaultInstance())).getNum());
  }

  /**
   * Method under test: {@link BlockCapsule#getTimeStamp()}
   */
  @Test
  public void testGetTimeStamp() {
    // Arrange, Act and Assert
    assertEquals(0L, (new BlockCapsule(Protocol.Block.getDefaultInstance())).getTimeStamp());
  }

  /**
   * Method under test: {@link BlockCapsule#hasWitnessSignature()}
   */
  @Test
  public void testHasWitnessSignature() {
    // Arrange, Act and Assert
    assertFalse((new BlockCapsule(Protocol.Block.getDefaultInstance())).hasWitnessSignature());
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(CodedInputStream)}
   */
  @Test
  public void testNewBlockCapsule() throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readFixed64()).thenReturn(1L);
    when(codedInputStream.readTag()).thenReturn(1);

    // Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(codedInputStream));
    verify(codedInputStream).readFixed64();
    verify(codedInputStream).readTag();
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(CodedInputStream)}
   */
  @Test
  public void testNewBlockCapsule2() throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readFixed64())
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(codedInputStream.readTag()).thenReturn(1);

    // Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(codedInputStream));
    verify(codedInputStream).readFixed64();
    verify(codedInputStream).readTag();
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(Protocol.Block)}
   */
  @Test
  public void testNewBlockCapsule3() {
    // Arrange
    Protocol.Block block = Protocol.Block.getDefaultInstance();

    // Act
    BlockCapsule actualBlockCapsule = new BlockCapsule(block);

    // Assert
    ByteString parentHashStr = actualBlockCapsule.getParentHashStr();
    assertEquals("", parentHashStr.toStringUtf8());
    Sha256Hash accountRoot = actualBlockCapsule.getAccountRoot();
    BigInteger toBigIntegerResult = accountRoot.toBigInteger();
    assertEquals("0", toBigIntegerResult.toString());
    BlockCapsule.BlockId blockId = actualBlockCapsule.getBlockId();
    BigInteger toBigIntegerResult2 = blockId.toBigInteger();
    assertEquals("3800201620905452580889821578709714074795303883058992822357", toBigIntegerResult2.toString());
    assertEquals("Num:0,ID:00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855", blockId.getString());
    ByteString byteString = accountRoot.getByteString();
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        byteString.toStringUtf8());
    ByteString byteString2 = blockId.getByteString();
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000���șo�$'�A�d��L���\u001bxR�U",
        byteString2.toStringUtf8());
    assertNull(actualBlockCapsule.getBloom());
    assertNull(actualBlockCapsule.getResult());
    assertEquals(-1, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, toBigIntegerResult2.getLowestSetBit());
    assertEquals(0, toBigIntegerResult.signum());
    assertEquals(0, actualBlockCapsule.getData().length);
    assertEquals(0L, actualBlockCapsule.getNum());
    assertEquals(0L, actualBlockCapsule.getSerializedSize());
    assertEquals(0L, actualBlockCapsule.getTimeStamp());
    assertEquals(0L, blockId.getNum());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    ByteString.ByteIterator iteratorResult2 = byteString2.iterator();
    assertEquals((byte) 0, iteratorResult2.next().byteValue());
    assertEquals((byte) 0, iteratorResult2.next().byteValue());
    assertEquals(1, toBigIntegerResult2.signum());
    assertFalse(byteString.isEmpty());
    assertFalse(byteString2.isEmpty());
    assertFalse(parentHashStr.iterator().hasNext());
    assertFalse(actualBlockCapsule.hasWitnessSignature());
    assertFalse(actualBlockCapsule.isSwitch());
    assertFalse(actualBlockCapsule.generatedByMyself);
    assertTrue(parentHashStr.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertTrue(iteratorResult2.hasNext());
    assertTrue(actualBlockCapsule.getTransactions().isEmpty());
    assertTrue(actualBlockCapsule.isMerkleRootEmpty());
    assertSame(parentHashStr, actualBlockCapsule.getWitnessAddress());
    assertSame(block, actualBlockCapsule.getInstance());
    assertArrayEquals(new byte[]{0}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{0, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28, 'd', -101, -109, 'L',
        -92, -107, -103, 27, 'x', 'R', -72, 'U'}, toBigIntegerResult2.toByteArray());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
        'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, blockId.getBytes());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        accountRoot.getBytes());
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule4() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule5() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule("\bXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule6() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule7() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule("\nXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule8() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule9() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule10() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{'\n', 1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule11() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule12() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule13() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule14() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{'\n', 1, 1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule15() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{'\n', 1, '\n', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule16() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{'\n', 1, 18, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule17() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{'\n', 1, -1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule18() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 1, 1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule19() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 1, '\n', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule20() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 1, 18, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule21() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 1, -1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  public void testNewBlockCapsule22() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 0, 18, 'X', 'A', 'X', 'A', 'X'}));
  }
}
