package org.tron.core.zen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.tron.common.zksnark.IncrementalMerkleTreeContainer;
import org.tron.common.zksnark.IncrementalMerkleVoucherContainer;
import org.tron.core.capsule.IncrementalMerkleTreeCapsule;
import org.tron.core.exception.ZksnarkException;
import org.tron.core.zen.address.DiversifierT;
import org.tron.core.zen.address.ExpandedSpendingKey;
import org.tron.core.zen.note.Note;
import org.tron.protos.contract.ShieldContract;

public class ZenTransactionBuilderDiffblueTest {
  /**
   * Method under test:
   * {@link ZenTransactionBuilder#addOutput(byte[], DiversifierT, byte[], long, byte[], byte[])}
   */
  @Test
  public void testAddOutput() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    ZenTransactionBuilder zenTransactionBuilder = new ZenTransactionBuilder();
    byte[] ovk = "AXAXAXAX".getBytes("UTF-8");
    DiversifierT d = DiversifierT.random();
    byte[] pkD = "AXAXAXAX".getBytes("UTF-8");
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    zenTransactionBuilder.addOutput(ovk, d, pkD, 42L, r, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(-42L, zenTransactionBuilder.getValueBalance());
    List<ZenTransactionBuilder.ReceiveDescriptionInfo> receives = zenTransactionBuilder.getReceives();
    assertEquals(1, receives.size());
    ZenTransactionBuilder.ReceiveDescriptionInfo getResult = receives.get(0);
    Note note = getResult.getNote();
    byte[] memo = note.getMemo();
    assertEquals((byte) 0, memo[10]);
    assertEquals((byte) 0, memo[11]);
    assertEquals((byte) 0, memo[12]);
    assertEquals((byte) 0, memo[13]);
    assertEquals((byte) 0, memo[14]);
    assertEquals((byte) 0, memo[15]);
    assertEquals((byte) 0, memo[17]);
    assertEquals((byte) 0, memo[18]);
    assertEquals((byte) 0, memo[19]);
    assertEquals((byte) 0, memo[20]);
    assertEquals((byte) 0, memo[21]);
    assertEquals((byte) 0, memo[22]);
    assertEquals((byte) 0, memo[23]);
    assertEquals((byte) 0, memo[24]);
    assertEquals((byte) 0, memo[487]);
    assertEquals((byte) 0, memo[488]);
    assertEquals((byte) 0, memo[489]);
    assertEquals((byte) 0, memo[490]);
    assertEquals((byte) 0, memo[491]);
    assertEquals((byte) 0, memo[492]);
    assertEquals((byte) 0, memo[493]);
    assertEquals((byte) 0, memo[494]);
    assertEquals((byte) 0, memo[495]);
    assertEquals((byte) 0, memo[496]);
    assertEquals((byte) 0, memo[497]);
    assertEquals((byte) 0, memo[498]);
    assertEquals((byte) 0, memo[499]);
    assertEquals((byte) 0, memo[500]);
    assertEquals((byte) 0, memo[501]);
    assertEquals((byte) 0, memo[502]);
    assertEquals((byte) 0, memo[503]);
    assertEquals((byte) 0, memo[504]);
    assertEquals((byte) 0, memo[505]);
    assertEquals((byte) 0, memo[506]);
    assertEquals((byte) 0, memo[507]);
    assertEquals((byte) 0, memo[508]);
    assertEquals((byte) 0, memo[509]);
    assertEquals((byte) 0, memo[510]);
    assertEquals((byte) 0, memo[511]);
    assertEquals((byte) 0, memo[8]);
    assertEquals((byte) 0, memo[9]);
    assertEquals((byte) 0, memo[Short.SIZE]);
    ShieldContract.ShieldedTransferContract.Builder contractBuilder = zenTransactionBuilder.getContractBuilder();
    Descriptors.Descriptor descriptorForType = contractBuilder.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(11, file.getMessageTypes().size());
    assertEquals(42L, note.getValue());
    assertEquals(512, memo.length);
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getFeatures().findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    ShieldContract.ShieldedTransferContract defaultInstanceForType = contractBuilder.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(contractBuilder.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getReceiveDescriptionList().isEmpty());
    assertTrue(contractBuilder.getReceiveDescriptionBuilderList().isEmpty());
    assertTrue(contractBuilder.getReceiveDescriptionList().isEmpty());
    assertTrue(contractBuilder.getReceiveDescriptionOrBuilderList().isEmpty());
    assertTrue(contractBuilder.getSpendDescriptionBuilderList().isEmpty());
    assertTrue(contractBuilder.getSpendDescriptionList().isEmpty());
    assertTrue(contractBuilder.getSpendDescriptionOrBuilderList().isEmpty());
    assertEquals('A', memo[0]);
    assertEquals('A', memo[2]);
    assertEquals('A', memo[4]);
    assertEquals('A', memo[6]);
    assertEquals('X', memo[1]);
    assertEquals('X', memo[3]);
    assertEquals('X', memo[5]);
    assertEquals('X', memo[7]);
    assertSame(ovk, getResult.getOvk());
    assertSame(pkD, note.getPkD());
    assertSame(r, note.getRcm());
    assertSame(d, note.getD());
  }

  /**
   * Method under test:
   * {@link ZenTransactionBuilder#addOutput(byte[], DiversifierT, byte[], long, byte[], byte[])}
   */
  @Test
  public void testAddOutput2() throws ZksnarkException {
    // Arrange
    ZenTransactionBuilder zenTransactionBuilder = new ZenTransactionBuilder();
    byte[] ovk = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};
    DiversifierT d = DiversifierT.random();
    byte[] pkD = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};
    byte[] r = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    zenTransactionBuilder.addOutput(ovk, d, pkD, 42L, r, null);

    // Assert
    assertEquals(-42L, zenTransactionBuilder.getValueBalance());
    List<ZenTransactionBuilder.ReceiveDescriptionInfo> receives = zenTransactionBuilder.getReceives();
    assertEquals(1, receives.size());
    ZenTransactionBuilder.ReceiveDescriptionInfo getResult = receives.get(0);
    Note note = getResult.getNote();
    byte[] memo = note.getMemo();
    assertEquals((byte) 0, memo[0]);
    assertEquals((byte) 0, memo[1]);
    assertEquals((byte) 0, memo[10]);
    assertEquals((byte) 0, memo[11]);
    assertEquals((byte) 0, memo[12]);
    assertEquals((byte) 0, memo[13]);
    assertEquals((byte) 0, memo[14]);
    assertEquals((byte) 0, memo[15]);
    assertEquals((byte) 0, memo[17]);
    assertEquals((byte) 0, memo[18]);
    assertEquals((byte) 0, memo[19]);
    assertEquals((byte) 0, memo[2]);
    assertEquals((byte) 0, memo[20]);
    assertEquals((byte) 0, memo[21]);
    assertEquals((byte) 0, memo[22]);
    assertEquals((byte) 0, memo[23]);
    assertEquals((byte) 0, memo[24]);
    assertEquals((byte) 0, memo[3]);
    assertEquals((byte) 0, memo[4]);
    assertEquals((byte) 0, memo[487]);
    assertEquals((byte) 0, memo[488]);
    assertEquals((byte) 0, memo[489]);
    assertEquals((byte) 0, memo[490]);
    assertEquals((byte) 0, memo[491]);
    assertEquals((byte) 0, memo[492]);
    assertEquals((byte) 0, memo[493]);
    assertEquals((byte) 0, memo[494]);
    assertEquals((byte) 0, memo[495]);
    assertEquals((byte) 0, memo[496]);
    assertEquals((byte) 0, memo[497]);
    assertEquals((byte) 0, memo[498]);
    assertEquals((byte) 0, memo[499]);
    assertEquals((byte) 0, memo[5]);
    assertEquals((byte) 0, memo[500]);
    assertEquals((byte) 0, memo[501]);
    assertEquals((byte) 0, memo[502]);
    assertEquals((byte) 0, memo[503]);
    assertEquals((byte) 0, memo[504]);
    assertEquals((byte) 0, memo[505]);
    assertEquals((byte) 0, memo[506]);
    assertEquals((byte) 0, memo[507]);
    assertEquals((byte) 0, memo[508]);
    assertEquals((byte) 0, memo[509]);
    assertEquals((byte) 0, memo[510]);
    assertEquals((byte) 0, memo[511]);
    assertEquals((byte) 0, memo[6]);
    assertEquals((byte) 0, memo[7]);
    assertEquals((byte) 0, memo[8]);
    assertEquals((byte) 0, memo[9]);
    assertEquals((byte) 0, memo[Short.SIZE]);
    ShieldContract.ShieldedTransferContract.Builder contractBuilder = zenTransactionBuilder.getContractBuilder();
    Descriptors.Descriptor descriptorForType = contractBuilder.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(11, file.getMessageTypes().size());
    assertEquals(42L, note.getValue());
    assertEquals(512, memo.length);
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getFeatures().findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    ShieldContract.ShieldedTransferContract defaultInstanceForType = contractBuilder.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(contractBuilder.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getReceiveDescriptionList().isEmpty());
    assertTrue(contractBuilder.getReceiveDescriptionBuilderList().isEmpty());
    assertTrue(contractBuilder.getReceiveDescriptionList().isEmpty());
    assertTrue(contractBuilder.getReceiveDescriptionOrBuilderList().isEmpty());
    assertTrue(contractBuilder.getSpendDescriptionBuilderList().isEmpty());
    assertTrue(contractBuilder.getSpendDescriptionList().isEmpty());
    assertTrue(contractBuilder.getSpendDescriptionOrBuilderList().isEmpty());
    assertSame(d, note.getD());
    assertSame(ovk, getResult.getOvk());
    assertSame(pkD, note.getPkD());
    assertSame(r, note.getRcm());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ZenTransactionBuilder.ReceiveDescriptionInfo#ReceiveDescriptionInfo(ZenTransactionBuilder, byte[], Note)}
   *   <li>{@link ZenTransactionBuilder.ReceiveDescriptionInfo#getNote()}
   *   <li>{@link ZenTransactionBuilder.ReceiveDescriptionInfo#getOvk()}
   * </ul>
   */
  @Test
  public void testReceiveDescriptionInfoGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    ZenTransactionBuilder zenTransactionBuilder = new ZenTransactionBuilder();
    byte[] ovk = "AXAXAXAX".getBytes("UTF-8");
    Note note = new Note();

    // Act
    ZenTransactionBuilder.ReceiveDescriptionInfo actualReceiveDescriptionInfo = zenTransactionBuilder.new ReceiveDescriptionInfo(
        ovk, note);
    Note actualNote = actualReceiveDescriptionInfo.getNote();

    // Assert
    assertSame(note, actualNote);
    assertSame(ovk, actualReceiveDescriptionInfo.getOvk());
  }

  /**
   * Method under test:
   * {@link ZenTransactionBuilder#setTransparentInput(byte[], long)}
   */
  @Test
  public void testSetTransparentInput() throws UnsupportedEncodingException {
    // Arrange
    ZenTransactionBuilder zenTransactionBuilder = new ZenTransactionBuilder();

    // Act
    zenTransactionBuilder.setTransparentInput("AXAXAXAX".getBytes("UTF-8"), 42L);

    // Assert
    ShieldContract.ShieldedTransferContract.Builder contractBuilder = zenTransactionBuilder.getContractBuilder();
    ByteString transparentFromAddress = contractBuilder.getTransparentFromAddress();
    assertEquals("AXAXAXAX", transparentFromAddress.toStringUtf8());
    assertEquals(2, contractBuilder.getAllFields().size());
    assertEquals(42L, contractBuilder.getFromAmount());
    Descriptors.Descriptor descriptorForType = contractBuilder.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    assertFalse(transparentFromAddress.isEmpty());
    ByteString.ByteIterator iteratorResult = transparentFromAddress.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
  }

  /**
   * Method under test:
   * {@link ZenTransactionBuilder#setTransparentOutput(byte[], long)}
   */
  @Test
  public void testSetTransparentOutput() throws UnsupportedEncodingException {
    // Arrange
    ZenTransactionBuilder zenTransactionBuilder = new ZenTransactionBuilder();

    // Act
    zenTransactionBuilder.setTransparentOutput("AXAXAXAX".getBytes("UTF-8"), 42L);

    // Assert
    ShieldContract.ShieldedTransferContract.Builder contractBuilder = zenTransactionBuilder.getContractBuilder();
    ByteString transparentToAddress = contractBuilder.getTransparentToAddress();
    assertEquals("AXAXAXAX", transparentToAddress.toStringUtf8());
    assertEquals(2, contractBuilder.getAllFields().size());
    assertEquals(42L, contractBuilder.getToAmount());
    Descriptors.Descriptor descriptorForType = contractBuilder.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    assertFalse(transparentToAddress.isEmpty());
    ByteString.ByteIterator iteratorResult = transparentToAddress.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ZenTransactionBuilder.SpendDescriptionInfo#SpendDescriptionInfo(ExpandedSpendingKey, Note, byte[], byte[], IncrementalMerkleVoucherContainer)}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#setAk(byte[])}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#setAlpha(byte[])}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#setAnchor(byte[])}
   *   <li>
   * {@link ZenTransactionBuilder.SpendDescriptionInfo#setExpsk(ExpandedSpendingKey)}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#setNote(Note)}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#setNsk(byte[])}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#setOvk(byte[])}
   *   <li>
   * {@link ZenTransactionBuilder.SpendDescriptionInfo#setVoucher(IncrementalMerkleVoucherContainer)}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getAk()}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getAlpha()}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getAnchor()}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getExpsk()}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getNote()}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getNsk()}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getOvk()}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getVoucher()}
   * </ul>
   */
  @Test
  public void testSpendDescriptionInfoGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    ExpandedSpendingKey expsk = new ExpandedSpendingKey();
    Note note = new Note();
    byte[] alpha = "AXAXAXAX".getBytes("UTF-8");
    byte[] anchor = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ZenTransactionBuilder.SpendDescriptionInfo actualSpendDescriptionInfo = new ZenTransactionBuilder.SpendDescriptionInfo(
        expsk, note, alpha, anchor,
        new IncrementalMerkleVoucherContainer(new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())));
    byte[] ak = "AXAXAXAX".getBytes("UTF-8");
    actualSpendDescriptionInfo.setAk(ak);
    byte[] alpha2 = "AXAXAXAX".getBytes("UTF-8");
    actualSpendDescriptionInfo.setAlpha(alpha2);
    byte[] anchor2 = "AXAXAXAX".getBytes("UTF-8");
    actualSpendDescriptionInfo.setAnchor(anchor2);
    ExpandedSpendingKey expsk2 = new ExpandedSpendingKey();
    actualSpendDescriptionInfo.setExpsk(expsk2);
    Note note2 = new Note();
    actualSpendDescriptionInfo.setNote(note2);
    byte[] nsk = "AXAXAXAX".getBytes("UTF-8");
    actualSpendDescriptionInfo.setNsk(nsk);
    byte[] ovk = "AXAXAXAX".getBytes("UTF-8");
    actualSpendDescriptionInfo.setOvk(ovk);
    IncrementalMerkleVoucherContainer voucher = new IncrementalMerkleVoucherContainer(
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()));
    actualSpendDescriptionInfo.setVoucher(voucher);
    byte[] actualAk = actualSpendDescriptionInfo.getAk();
    byte[] actualAlpha = actualSpendDescriptionInfo.getAlpha();
    byte[] actualAnchor = actualSpendDescriptionInfo.getAnchor();
    ExpandedSpendingKey actualExpsk = actualSpendDescriptionInfo.getExpsk();
    Note actualNote = actualSpendDescriptionInfo.getNote();
    byte[] actualNsk = actualSpendDescriptionInfo.getNsk();
    byte[] actualOvk = actualSpendDescriptionInfo.getOvk();

    // Assert that nothing has changed
    assertSame(voucher, actualSpendDescriptionInfo.getVoucher());
    assertSame(expsk2, actualExpsk);
    assertSame(note2, actualNote);
    assertSame(ak, actualAk);
    assertSame(alpha2, actualAlpha);
    assertSame(anchor2, actualAnchor);
    assertSame(nsk, actualNsk);
    assertSame(ovk, actualOvk);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ZenTransactionBuilder.SpendDescriptionInfo#SpendDescriptionInfo(byte[], byte[], byte[], Note, byte[], byte[], IncrementalMerkleVoucherContainer)}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#setAk(byte[])}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#setAlpha(byte[])}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#setAnchor(byte[])}
   *   <li>
   * {@link ZenTransactionBuilder.SpendDescriptionInfo#setExpsk(ExpandedSpendingKey)}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#setNote(Note)}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#setNsk(byte[])}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#setOvk(byte[])}
   *   <li>
   * {@link ZenTransactionBuilder.SpendDescriptionInfo#setVoucher(IncrementalMerkleVoucherContainer)}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getAk()}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getAlpha()}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getAnchor()}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getExpsk()}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getNote()}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getNsk()}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getOvk()}
   *   <li>{@link ZenTransactionBuilder.SpendDescriptionInfo#getVoucher()}
   * </ul>
   */
  @Test
  public void testSpendDescriptionInfoGettersAndSetters2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ak = "AXAXAXAX".getBytes("UTF-8");
    byte[] nsk = "AXAXAXAX".getBytes("UTF-8");
    byte[] ovk = "AXAXAXAX".getBytes("UTF-8");
    Note note = new Note();
    byte[] alpha = "AXAXAXAX".getBytes("UTF-8");
    byte[] anchor = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ZenTransactionBuilder.SpendDescriptionInfo actualSpendDescriptionInfo = new ZenTransactionBuilder.SpendDescriptionInfo(
        ak, nsk, ovk, note, alpha, anchor,
        new IncrementalMerkleVoucherContainer(new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())));
    byte[] ak2 = "AXAXAXAX".getBytes("UTF-8");
    actualSpendDescriptionInfo.setAk(ak2);
    byte[] alpha2 = "AXAXAXAX".getBytes("UTF-8");
    actualSpendDescriptionInfo.setAlpha(alpha2);
    byte[] anchor2 = "AXAXAXAX".getBytes("UTF-8");
    actualSpendDescriptionInfo.setAnchor(anchor2);
    ExpandedSpendingKey expsk = new ExpandedSpendingKey();
    actualSpendDescriptionInfo.setExpsk(expsk);
    Note note2 = new Note();
    actualSpendDescriptionInfo.setNote(note2);
    byte[] nsk2 = "AXAXAXAX".getBytes("UTF-8");
    actualSpendDescriptionInfo.setNsk(nsk2);
    byte[] ovk2 = "AXAXAXAX".getBytes("UTF-8");
    actualSpendDescriptionInfo.setOvk(ovk2);
    IncrementalMerkleVoucherContainer voucher = new IncrementalMerkleVoucherContainer(
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()));
    actualSpendDescriptionInfo.setVoucher(voucher);
    byte[] actualAk = actualSpendDescriptionInfo.getAk();
    byte[] actualAlpha = actualSpendDescriptionInfo.getAlpha();
    byte[] actualAnchor = actualSpendDescriptionInfo.getAnchor();
    ExpandedSpendingKey actualExpsk = actualSpendDescriptionInfo.getExpsk();
    Note actualNote = actualSpendDescriptionInfo.getNote();
    byte[] actualNsk = actualSpendDescriptionInfo.getNsk();
    byte[] actualOvk = actualSpendDescriptionInfo.getOvk();

    // Assert that nothing has changed
    assertSame(voucher, actualSpendDescriptionInfo.getVoucher());
    assertSame(expsk, actualExpsk);
    assertSame(note2, actualNote);
    assertSame(ak2, actualAk);
    assertSame(alpha2, actualAlpha);
    assertSame(anchor2, actualAnchor);
    assertSame(nsk2, actualNsk);
    assertSame(ovk2, actualOvk);
  }
}
