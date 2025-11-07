package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.contract.AssetIssueContractOuterClass;

public class AssetIssueCapsuleDiffblueTest {
  /**
   * Method under test: {@link AssetIssueCapsule#createDbKeyString(String, long)}
   */
  @Test
  public void testCreateDbKeyString() {
    // Arrange, Act and Assert
    assertEquals("Name_1", AssetIssueCapsule.createDbKeyString("Name", 1L));
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance())).getData().length);
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1, 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A', 'b', 'b', 'r',
            ' ', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, '8', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -54, 2, 2, '4',
            '2'},
        (new AssetIssueCapsule(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, "42", "Name", "Abbr", -1L, -1))
            .getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    ByteString newUrl = mock(ByteString.class);
    when(newUrl.isEmpty()).thenReturn(true);

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(newUrl);

    // Act
    byte[] actualData = assetIssueCapsule.getData();

    // Assert
    verify(newUrl, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    ByteString newUrl = mock(ByteString.class);
    when(newUrl.isEmpty()).thenReturn(true);

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setOrder(-1L);
    assetIssueCapsule.setUrl(newUrl);

    // Act
    byte[] actualData = assetIssueCapsule.getData();

    // Assert
    verify(newUrl, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'X', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  public void testGetData4() {
    // Arrange
    ByteString newUrl = mock(ByteString.class);
    when(newUrl.isEmpty()).thenReturn(true);

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setFreeAssetNetLimit(-1L);
    assetIssueCapsule.setUrl(newUrl);

    // Act
    byte[] actualData = assetIssueCapsule.getData();

    // Assert
    verify(newUrl, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{-80, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  public void testGetData5() {
    // Arrange
    ByteString newUrl = mock(ByteString.class);
    when(newUrl.isEmpty()).thenReturn(true);

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setPublicFreeAssetNetLimit(-1L);
    assetIssueCapsule.setUrl(newUrl);

    // Act
    byte[] actualData = assetIssueCapsule.getData();

    // Assert
    verify(newUrl, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{-72, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  public void testGetData6() {
    // Arrange
    ByteString newUrl = mock(ByteString.class);
    when(newUrl.isEmpty()).thenReturn(true);

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);
    assetIssueCapsule.setUrl(newUrl);

    // Act
    byte[] actualData = assetIssueCapsule.getData();

    // Assert
    verify(newUrl, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{-64, 1, '*'}, actualData);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  public void testGetData7() {
    // Arrange
    ByteString newUrl = mock(ByteString.class);
    when(newUrl.isEmpty()).thenReturn(true);

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);
    assetIssueCapsule.setUrl(newUrl);

    // Act
    byte[] actualData = assetIssueCapsule.getData();

    // Assert
    verify(newUrl, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{-56, 1, '\n'}, actualData);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  public void testGetData8() {
    // Arrange
    ByteString newUrl = mock(ByteString.class);
    when(newUrl.isEmpty()).thenReturn(true);
    ByteString description = mock(ByteString.class);
    when(description.isEmpty()).thenReturn(true);

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setDescription(description);
    assetIssueCapsule.setUrl(newUrl);

    // Act
    byte[] actualData = assetIssueCapsule.getData();

    // Assert
    verify(description, atLeast(1)).isEmpty();
    verify(newUrl, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getInstance()}
   */
  @Test
  public void testGetInstance() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(assetIssueContract, (new AssetIssueCapsule(assetIssueContract)).getInstance());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Act
    ByteString actualName = assetIssueCapsule.getName();

    // Assert
    assertSame(assetIssueContract, assetIssueCapsule.getInstance());
    ByteString byteString = actualName.EMPTY;
    assertSame(byteString, assetIssueCapsule.getDesc());
    assertSame(byteString, actualName);
    assertSame(byteString, assetIssueCapsule.getOwnerAddress());
    assertSame(byteString, assetIssueCapsule.getUrl());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getName()}
   */
  @Test
  public void testGetName2() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act
    ByteString actualName = assetIssueCapsule.getName();

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    ByteString byteString = actualName.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(17).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(18).toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertSame(byteString, getResult.getDefaultValue());
    assertSame(byteString, assetIssueCapsule.getDesc());
    assertSame(byteString, actualName);
    assertSame(byteString, assetIssueCapsule.getOwnerAddress());
    assertSame(byteString, instance.getAbbr());
    assertSame(byteString, instance.getDescription());
    assertSame(byteString, instance.getName());
    assertSame(byteString, instance.getOwnerAddress());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getId()}
   */
  @Test
  public void testGetId() {
    // Arrange, Act and Assert
    assertEquals("",
        (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance())).getId());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getId()}
   */
  @Test
  public void testGetId2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertEquals("", assetIssueCapsule.getId());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getPrecision()}
   */
  @Test
  public void testGetPrecision() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance())).getPrecision());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getPrecision()}
   */
  @Test
  public void testGetPrecision2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertEquals(0, assetIssueCapsule.getPrecision());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  public void testSetPrecision() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, assetIssueCapsule.getPrecision());
    assertEquals(1, instance.getPrecision());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'8', 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  public void testSetPrecision2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        new byte[]{'A', Byte.MIN_VALUE, 'A', Byte.MIN_VALUE, 'A', Byte.MIN_VALUE, 'A', Byte.MIN_VALUE}, "42", "Name",
        "Abbr", 128L, 128);

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert
    byte[] data = assetIssueCapsule.getData();
    assertEquals((byte) -54, data[27]);
    assertEquals(1, assetIssueCapsule.getPrecision());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getPrecision());
    assertEquals((byte) 1, data[26]);
    assertEquals((byte) 2, data[28]);
    assertEquals(Integer.SIZE, instance.getSerializedSize());
    assertEquals(Integer.SIZE, data.length);
    assertEquals('2', data[31]);
    assertEquals('4', data[30]);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  public void testSetPrecision3() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert
    assertEquals(1, assetIssueCapsule.getPrecision());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getPrecision());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'8', 1, -86, 1, 0}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  public void testSetPrecision4() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setDescription(mock(ByteString.class));

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert
    assertEquals(1, assetIssueCapsule.getPrecision());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getPrecision());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'8', 1, -94, 1, 0}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  public void testSetPrecision5() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setOrder(128L);

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert
    assertEquals(1, assetIssueCapsule.getPrecision());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getPrecision());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'8', 1, 'X', Byte.MIN_VALUE, 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  public void testSetPrecision6() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setFreeAssetNetLimit(128L);

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert
    assertEquals(1, assetIssueCapsule.getPrecision());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getPrecision());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'8', 1, -80, 1, Byte.MIN_VALUE, 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  public void testSetPrecision7() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicFreeAssetNetLimit(128L);

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert
    assertEquals(1, assetIssueCapsule.getPrecision());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getPrecision());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'8', 1, -72, 1, Byte.MIN_VALUE, 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  public void testSetPrecision8() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert
    assertEquals(1, assetIssueCapsule.getPrecision());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getPrecision());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'8', 1, -64, 1, '*'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  public void testSetPrecision9() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert
    assertEquals(1, assetIssueCapsule.getPrecision());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getPrecision());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'8', 1, -56, 1, '\n'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance())).getOrder());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getOrder()}
   */
  @Test
  public void testGetOrder2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getOrder());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setOrder(long)}
   */
  @Test
  public void testSetOrder() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Act
    assetIssueCapsule.setOrder(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getOrder());
    assertEquals(1L, instance.getOrder());
    assertEquals(2, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'X', 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setOrder(long)}
   */
  @Test
  public void testSetOrder2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, "42",
        "Name", "Abbr", 2048L, 2048);

    // Act
    assetIssueCapsule.setOrder(1L);

    // Assert
    byte[] data = assetIssueCapsule.getData();
    assertEquals((byte) -54, data[30]);
    assertEquals(1L, assetIssueCapsule.getOrder());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1L, instance.getOrder());
    assertEquals((byte) 1, data[29]);
    assertEquals((byte) 2, data[31]);
    assertEquals((byte) 2, data[Integer.SIZE]);
    assertEquals(35, instance.getSerializedSize());
    assertEquals(35, data.length);
    assertEquals(7, instance.getAllFields().size());
    assertEquals('2', data[34]);
    assertEquals('4', data[33]);
    assertEquals('X', data[28]);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setOrder(long)}
   */
  @Test
  public void testSetOrder3() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act
    assetIssueCapsule.setOrder(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getOrder());
    assertEquals(1L, instance.getOrder());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'X', 1, -86, 1, 0}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setOrder(long)}
   */
  @Test
  public void testSetOrder4() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setDescription(mock(ByteString.class));

    // Act
    assetIssueCapsule.setOrder(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getOrder());
    assertEquals(1L, instance.getOrder());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'X', 1, -94, 1, 0}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setOrder(long)}
   */
  @Test
  public void testSetOrder5() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setFreeAssetNetLimit(2048L);

    // Act
    assetIssueCapsule.setOrder(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getOrder());
    assertEquals(1L, instance.getOrder());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'X', 1, -80, 1, Byte.MIN_VALUE, 16}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setOrder(long)}
   */
  @Test
  public void testSetOrder6() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicFreeAssetNetLimit(2048L);

    // Act
    assetIssueCapsule.setOrder(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getOrder());
    assertEquals(1L, instance.getOrder());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'X', 1, -72, 1, Byte.MIN_VALUE, 16}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setOrder(long)}
   */
  @Test
  public void testSetOrder7() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Act
    assetIssueCapsule.setOrder(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getOrder());
    assertEquals(1L, instance.getOrder());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'X', 1, -64, 1, '*'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setOrder(long)}
   */
  @Test
  public void testSetOrder8() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Act
    assetIssueCapsule.setOrder(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getOrder());
    assertEquals(1L, instance.getOrder());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'X', 1, -56, 1, '\n'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#createDbV2Key()}
   */
  @Test
  public void testCreateDbV2Key() {
    // Arrange, Act and Assert
    assertNull(
        (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance())).createDbV2Key());
    assertArrayEquals(new byte[]{'4', '2'},
        (new AssetIssueCapsule(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, "42", "Name", "Abbr", 1L, 1))
            .createDbV2Key());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#createDbV2Key()}
   */
  @Test
  public void testCreateDbV2Key2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertNull(assetIssueCapsule.createDbV2Key());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey() {
    // Arrange, Act and Assert
    assertEquals(0, (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()))
        .createDbKey().length);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey2() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualCreateDbKeyResult = (new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1))
        .createDbKey();

    // Assert
    assertArrayEquals("Name".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey3() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertEquals(0, assetIssueCapsule.createDbKey().length);
  }

  /**
   * Method under test:
   * {@link AssetIssueCapsule#createDbKeyFinal(DynamicPropertiesStore)}
   */
  @Test
  public void testCreateDbKeyFinal() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(1L);

    // Act
    byte[] actualCreateDbKeyFinalResult = assetIssueCapsule.createDbKeyFinal(dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertNull(actualCreateDbKeyFinalResult);
  }

  /**
   * Method under test:
   * {@link AssetIssueCapsule#createDbKeyFinal(DynamicPropertiesStore)}
   */
  @Test
  public void testCreateDbKeyFinal2() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L,
        1);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(1L);

    // Act
    byte[] actualCreateDbKeyFinalResult = assetIssueCapsule.createDbKeyFinal(dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertArrayEquals(new byte[]{'4', '2'}, actualCreateDbKeyFinalResult);
  }

  /**
   * Method under test:
   * {@link AssetIssueCapsule#createDbKeyFinal(DynamicPropertiesStore)}
   */
  @Test
  public void testCreateDbKeyFinal3() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);

    // Act
    byte[] actualCreateDbKeyFinalResult = assetIssueCapsule.createDbKeyFinal(dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertEquals(0, actualCreateDbKeyFinalResult.length);
  }

  /**
   * Method under test:
   * {@link AssetIssueCapsule#createDbKeyFinal(DynamicPropertiesStore)}
   */
  @Test
  public void testCreateDbKeyFinal4() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L,
        1);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);

    // Act
    byte[] actualCreateDbKeyFinalResult = assetIssueCapsule.createDbKeyFinal(dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertArrayEquals("Name".getBytes("UTF-8"), actualCreateDbKeyFinalResult);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getNum()}
   */
  @Test
  public void testGetNum() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance())).getNum());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getNum()}
   */
  @Test
  public void testGetNum2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertEquals(0, assetIssueCapsule.getNum());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getTrxNum()}
   */
  @Test
  public void testGetTrxNum() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance())).getTrxNum());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getTrxNum()}
   */
  @Test
  public void testGetTrxNum2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertEquals(0, assetIssueCapsule.getTrxNum());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getStartTime()}
   */
  @Test
  public void testGetStartTime() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance())).getStartTime());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getStartTime()}
   */
  @Test
  public void testGetStartTime2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getStartTime());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getEndTime()}
   */
  @Test
  public void testGetEndTime() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance())).getEndTime());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getEndTime()}
   */
  @Test
  public void testGetEndTime2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getEndTime());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getOwnerAddress()}
   */
  @Test
  public void testGetOwnerAddress() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Act
    ByteString actualOwnerAddress = assetIssueCapsule.getOwnerAddress();

    // Assert
    assertSame(assetIssueContract, assetIssueCapsule.getInstance());
    ByteString byteString = actualOwnerAddress.EMPTY;
    assertSame(byteString, assetIssueCapsule.getDesc());
    assertSame(byteString, assetIssueCapsule.getName());
    assertSame(byteString, actualOwnerAddress);
    assertSame(byteString, assetIssueCapsule.getUrl());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getOwnerAddress()}
   */
  @Test
  public void testGetOwnerAddress2() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act
    ByteString actualOwnerAddress = assetIssueCapsule.getOwnerAddress();

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    ByteString byteString = actualOwnerAddress.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(17).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(18).toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertSame(byteString, getResult.getDefaultValue());
    assertSame(byteString, assetIssueCapsule.getDesc());
    assertSame(byteString, assetIssueCapsule.getName());
    assertSame(byteString, actualOwnerAddress);
    assertSame(byteString, instance.getAbbr());
    assertSame(byteString, instance.getDescription());
    assertSame(byteString, instance.getName());
    assertSame(byteString, instance.getOwnerAddress());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getFrozenSupplyCount()}
   */
  @Test
  public void testGetFrozenSupplyCount() {
    // Arrange, Act and Assert
    assertEquals(0, (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()))
        .getFrozenSupplyCount());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getFrozenSupplyCount()}
   */
  @Test
  public void testGetFrozenSupplyCount2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertEquals(0, assetIssueCapsule.getFrozenSupplyCount());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getFrozenSupplyList()}
   */
  @Test
  public void testGetFrozenSupplyList() {
    // Arrange, Act and Assert
    assertTrue((new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()))
        .getFrozenSupplyList()
        .isEmpty());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getFrozenSupplyList()}
   */
  @Test
  public void testGetFrozenSupplyList2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertTrue(assetIssueCapsule.getFrozenSupplyList().isEmpty());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getFrozenSupply()}
   */
  @Test
  public void testGetFrozenSupply() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()))
        .getFrozenSupply());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getFrozenSupply()}
   */
  @Test
  public void testGetFrozenSupply2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getFrozenSupply());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getFreeAssetNetLimit()}
   */
  @Test
  public void testGetFreeAssetNetLimit() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()))
        .getFreeAssetNetLimit());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getFreeAssetNetLimit()}
   */
  @Test
  public void testGetFreeAssetNetLimit2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getFreeAssetNetLimit());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetFreeAssetNetLimit() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Act
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getFreeAssetNetLimit());
    assertEquals(1L, instance.getFreeAssetNetLimit());
    assertEquals(3, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-80, 1, 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetFreeAssetNetLimit2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, "42",
        "Name", "Abbr", 32768L, 32768);

    // Act
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Assert
    byte[] data = assetIssueCapsule.getData();
    assertEquals((byte) -54, data[33]);
    assertEquals((byte) -80, data[30]);
    assertEquals(1L, assetIssueCapsule.getFreeAssetNetLimit());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1L, instance.getFreeAssetNetLimit());
    assertEquals((byte) 1, data[31]);
    assertEquals((byte) 1, data[Integer.SIZE]);
    assertEquals((byte) 2, data[34]);
    assertEquals((byte) 2, data[35]);
    assertEquals(38, instance.getSerializedSize());
    assertEquals(38, data.length);
    assertEquals(7, instance.getAllFields().size());
    assertEquals('2', data[37]);
    assertEquals('4', data[36]);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetFreeAssetNetLimit3() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getFreeAssetNetLimit());
    assertEquals(1L, instance.getFreeAssetNetLimit());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-86, 1, 0, -80, 1, 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetFreeAssetNetLimit4() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setDescription(mock(ByteString.class));

    // Act
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getFreeAssetNetLimit());
    assertEquals(1L, instance.getFreeAssetNetLimit());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-94, 1, 0, -80, 1, 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetFreeAssetNetLimit5() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setOrder(32768L);

    // Act
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getFreeAssetNetLimit());
    assertEquals(1L, instance.getFreeAssetNetLimit());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'X', Byte.MIN_VALUE, Byte.MIN_VALUE, 2, -80, 1, 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetFreeAssetNetLimit6() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicFreeAssetNetLimit(32768L);

    // Act
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getFreeAssetNetLimit());
    assertEquals(1L, instance.getFreeAssetNetLimit());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-80, 1, 1, -72, 1, Byte.MIN_VALUE, Byte.MIN_VALUE, 2}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetFreeAssetNetLimit7() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Act
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getFreeAssetNetLimit());
    assertEquals(1L, instance.getFreeAssetNetLimit());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-80, 1, 1, -64, 1, '*'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetFreeAssetNetLimit8() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Act
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getFreeAssetNetLimit());
    assertEquals(1L, instance.getFreeAssetNetLimit());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-80, 1, 1, -56, 1, '\n'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getPublicFreeAssetNetLimit()}
   */
  @Test
  public void testGetPublicFreeAssetNetLimit() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()))
        .getPublicFreeAssetNetLimit());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getPublicFreeAssetNetLimit()}
   */
  @Test
  public void testGetPublicFreeAssetNetLimit2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getPublicFreeAssetNetLimit());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetLimit() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getPublicFreeAssetNetLimit());
    assertEquals(1L, instance.getPublicFreeAssetNetLimit());
    assertEquals(3, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-72, 1, 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetLimit2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, "42",
        "Name", "Abbr", 65536L, 65536);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Assert
    byte[] data = assetIssueCapsule.getData();
    assertEquals((byte) -54, data[33]);
    assertEquals((byte) -72, data[30]);
    assertEquals(1L, assetIssueCapsule.getPublicFreeAssetNetLimit());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1L, instance.getPublicFreeAssetNetLimit());
    assertEquals((byte) 1, data[31]);
    assertEquals((byte) 1, data[Integer.SIZE]);
    assertEquals((byte) 2, data[34]);
    assertEquals((byte) 2, data[35]);
    assertEquals(38, instance.getSerializedSize());
    assertEquals(38, data.length);
    assertEquals(7, instance.getAllFields().size());
    assertEquals('2', data[37]);
    assertEquals('4', data[36]);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetLimit3() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getPublicFreeAssetNetLimit());
    assertEquals(1L, instance.getPublicFreeAssetNetLimit());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-86, 1, 0, -72, 1, 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetLimit4() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setDescription(mock(ByteString.class));

    // Act
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getPublicFreeAssetNetLimit());
    assertEquals(1L, instance.getPublicFreeAssetNetLimit());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-94, 1, 0, -72, 1, 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetLimit5() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setOrder(65536L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getPublicFreeAssetNetLimit());
    assertEquals(1L, instance.getPublicFreeAssetNetLimit());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'X', Byte.MIN_VALUE, Byte.MIN_VALUE, 4, -72, 1, 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetLimit6() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setFreeAssetNetLimit(65536L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getPublicFreeAssetNetLimit());
    assertEquals(1L, instance.getPublicFreeAssetNetLimit());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-80, 1, Byte.MIN_VALUE, Byte.MIN_VALUE, 4, -72, 1, 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetLimit7() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getPublicFreeAssetNetLimit());
    assertEquals(1L, instance.getPublicFreeAssetNetLimit());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-72, 1, 1, -64, 1, '*'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetLimit8() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(1L, assetIssueCapsule.getPublicFreeAssetNetLimit());
    assertEquals(1L, instance.getPublicFreeAssetNetLimit());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-72, 1, 1, -56, 1, '\n'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getPublicFreeAssetNetUsage()}
   */
  @Test
  public void testGetPublicFreeAssetNetUsage() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()))
        .getPublicFreeAssetNetUsage());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getPublicFreeAssetNetUsage()}
   */
  @Test
  public void testGetPublicFreeAssetNetUsage2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getPublicFreeAssetNetUsage());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetUsage() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(42L, assetIssueCapsule.getPublicFreeAssetNetUsage());
    assertEquals(42L, instance.getPublicFreeAssetNetUsage());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-64, 1, '*'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetUsage2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, "42",
        "Name", "Abbr", 131072L, 131072);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Assert
    byte[] data = assetIssueCapsule.getData();
    assertEquals((byte) -54, data[33]);
    assertEquals((byte) -64, data[30]);
    assertEquals((byte) 1, data[31]);
    assertEquals((byte) 2, data[34]);
    assertEquals((byte) 2, data[35]);
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(38, instance.getSerializedSize());
    assertEquals(38, data.length);
    assertEquals(42L, assetIssueCapsule.getPublicFreeAssetNetUsage());
    assertEquals(42L, instance.getPublicFreeAssetNetUsage());
    assertEquals(7, instance.getAllFields().size());
    assertEquals('*', data[Integer.SIZE]);
    assertEquals('2', data[37]);
    assertEquals('4', data[36]);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetUsage3() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(42L, assetIssueCapsule.getPublicFreeAssetNetUsage());
    assertEquals(42L, instance.getPublicFreeAssetNetUsage());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-86, 1, 0, -64, 1, '*'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetUsage4() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setDescription(mock(ByteString.class));

    // Act
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(42L, assetIssueCapsule.getPublicFreeAssetNetUsage());
    assertEquals(42L, instance.getPublicFreeAssetNetUsage());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-94, 1, 0, -64, 1, '*'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetUsage5() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setOrder(131072L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(42L, assetIssueCapsule.getPublicFreeAssetNetUsage());
    assertEquals(42L, instance.getPublicFreeAssetNetUsage());
    assertEquals(7, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'X', Byte.MIN_VALUE, Byte.MIN_VALUE, '\b', -64, 1, '*'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetUsage6() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setFreeAssetNetLimit(131072L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(42L, assetIssueCapsule.getPublicFreeAssetNetUsage());
    assertEquals(42L, instance.getPublicFreeAssetNetUsage());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-80, 1, Byte.MIN_VALUE, Byte.MIN_VALUE, '\b', -64, 1, '*'},
        assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetUsage7() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicFreeAssetNetLimit(131072L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(42L, assetIssueCapsule.getPublicFreeAssetNetUsage());
    assertEquals(42L, instance.getPublicFreeAssetNetUsage());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-72, 1, Byte.MIN_VALUE, Byte.MIN_VALUE, '\b', -64, 1, '*'},
        assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}
   */
  @Test
  public void testSetPublicFreeAssetNetUsage8() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(42L, assetIssueCapsule.getPublicFreeAssetNetUsage());
    assertEquals(42L, instance.getPublicFreeAssetNetUsage());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-64, 1, '*', -56, 1, '\n'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getPublicLatestFreeNetTime()}
   */
  @Test
  public void testGetPublicLatestFreeNetTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()))
        .getPublicLatestFreeNetTime());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getPublicLatestFreeNetTime()}
   */
  @Test
  public void testGetPublicLatestFreeNetTime2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getPublicLatestFreeNetTime());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}
   */
  @Test
  public void testSetPublicLatestFreeNetTime() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Act
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, assetIssueCapsule.getPublicLatestFreeNetTime());
    assertEquals(10L, instance.getPublicLatestFreeNetTime());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(3, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-56, 1, '\n'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}
   */
  @Test
  public void testSetPublicLatestFreeNetTime2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, "42",
        "Name", "Abbr", 262144L, 262144);

    // Act
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Assert
    byte[] data = assetIssueCapsule.getData();
    assertEquals((byte) -54, data[33]);
    assertEquals((byte) -56, data[30]);
    assertEquals(10L, assetIssueCapsule.getPublicLatestFreeNetTime());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(10L, instance.getPublicLatestFreeNetTime());
    assertEquals((byte) 1, data[31]);
    assertEquals((byte) 2, data[34]);
    assertEquals((byte) 2, data[35]);
    assertEquals(38, instance.getSerializedSize());
    assertEquals(38, data.length);
    assertEquals(7, instance.getAllFields().size());
    assertEquals('2', data[37]);
    assertEquals('4', data[36]);
    assertEquals('\n', data[Integer.SIZE]);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}
   */
  @Test
  public void testSetPublicLatestFreeNetTime3() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Assert
    assertEquals(10L, assetIssueCapsule.getPublicLatestFreeNetTime());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(10L, instance.getPublicLatestFreeNetTime());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-86, 1, 0, -56, 1, '\n'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}
   */
  @Test
  public void testSetPublicLatestFreeNetTime4() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setDescription(mock(ByteString.class));

    // Act
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Assert
    assertEquals(10L, assetIssueCapsule.getPublicLatestFreeNetTime());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(10L, instance.getPublicLatestFreeNetTime());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-94, 1, 0, -56, 1, '\n'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}
   */
  @Test
  public void testSetPublicLatestFreeNetTime5() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setOrder(262144L);

    // Act
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Assert
    assertEquals(10L, assetIssueCapsule.getPublicLatestFreeNetTime());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(10L, instance.getPublicLatestFreeNetTime());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'X', Byte.MIN_VALUE, Byte.MIN_VALUE, 16, -56, 1, '\n'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}
   */
  @Test
  public void testSetPublicLatestFreeNetTime6() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setFreeAssetNetLimit(262144L);

    // Act
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Assert
    assertEquals(10L, assetIssueCapsule.getPublicLatestFreeNetTime());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(10L, instance.getPublicLatestFreeNetTime());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-80, 1, Byte.MIN_VALUE, Byte.MIN_VALUE, 16, -56, 1, '\n'},
        assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}
   */
  @Test
  public void testSetPublicLatestFreeNetTime7() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicFreeAssetNetLimit(262144L);

    // Act
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Assert
    assertEquals(10L, assetIssueCapsule.getPublicLatestFreeNetTime());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(10L, instance.getPublicLatestFreeNetTime());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-72, 1, Byte.MIN_VALUE, Byte.MIN_VALUE, 16, -56, 1, '\n'},
        assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}
   */
  @Test
  public void testSetPublicLatestFreeNetTime8() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Act
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Assert
    assertEquals(10L, assetIssueCapsule.getPublicLatestFreeNetTime());
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(10L, instance.getPublicLatestFreeNetTime());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-64, 1, '*', -56, 1, '\n'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  public void testSetUrl() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    ByteString newUrl = mock(ByteString.class);

    // Act
    assetIssueCapsule.setUrl(newUrl);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(3, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertSame(newUrl, assetIssueCapsule.getUrl());
    assertSame(newUrl, instance.getUrl());
    assertArrayEquals(new byte[]{-86, 1, 0}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  public void testSetUrl2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, "42",
        "Name", "Abbr", 16384L, 16384);
    ByteString newUrl = mock(ByteString.class);

    // Act
    assetIssueCapsule.setUrl(newUrl);

    // Assert
    byte[] data = assetIssueCapsule.getData();
    assertEquals((byte) -54, data[33]);
    assertEquals((byte) -86, data[30]);
    assertEquals((byte) 0, data[Integer.SIZE]);
    assertEquals((byte) 1, data[31]);
    assertEquals((byte) 2, data[34]);
    assertEquals((byte) 2, data[35]);
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(38, instance.getSerializedSize());
    assertEquals(38, data.length);
    assertEquals(7, instance.getAllFields().size());
    assertEquals('2', data[37]);
    assertEquals('4', data[36]);
    assertSame(newUrl, assetIssueCapsule.getUrl());
    assertSame(newUrl, instance.getUrl());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  public void testSetUrl3() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setId("42");
    ByteString newUrl = mock(ByteString.class);

    // Act
    assetIssueCapsule.setUrl(newUrl);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertSame(newUrl, assetIssueCapsule.getUrl());
    assertSame(newUrl, instance.getUrl());
    assertArrayEquals(new byte[]{-86, 1, 0, -54, 2, 2, '4', '2'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  public void testSetUrl4() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPrecision(16384);
    ByteString newUrl = mock(ByteString.class);

    // Act
    assetIssueCapsule.setUrl(newUrl);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertSame(newUrl, assetIssueCapsule.getUrl());
    assertSame(newUrl, instance.getUrl());
    assertArrayEquals(new byte[]{'8', Byte.MIN_VALUE, Byte.MIN_VALUE, 1, -86, 1, 0}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  public void testSetUrl5() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setOrder(16384L);
    ByteString newUrl = mock(ByteString.class);

    // Act
    assetIssueCapsule.setUrl(newUrl);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertSame(newUrl, assetIssueCapsule.getUrl());
    assertSame(newUrl, instance.getUrl());
    assertArrayEquals(new byte[]{'X', Byte.MIN_VALUE, Byte.MIN_VALUE, 1, -86, 1, 0}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  public void testSetUrl6() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setFreeAssetNetLimit(16384L);
    ByteString newUrl = mock(ByteString.class);

    // Act
    assetIssueCapsule.setUrl(newUrl);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertSame(newUrl, assetIssueCapsule.getUrl());
    assertSame(newUrl, instance.getUrl());
    assertArrayEquals(new byte[]{-86, 1, 0, -80, 1, Byte.MIN_VALUE, Byte.MIN_VALUE, 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  public void testSetUrl7() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicFreeAssetNetLimit(16384L);
    ByteString newUrl = mock(ByteString.class);

    // Act
    assetIssueCapsule.setUrl(newUrl);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertSame(newUrl, assetIssueCapsule.getUrl());
    assertSame(newUrl, instance.getUrl());
    assertArrayEquals(new byte[]{-86, 1, 0, -72, 1, Byte.MIN_VALUE, Byte.MIN_VALUE, 1}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  public void testSetUrl8() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);
    ByteString newUrl = mock(ByteString.class);

    // Act
    assetIssueCapsule.setUrl(newUrl);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertSame(newUrl, assetIssueCapsule.getUrl());
    assertSame(newUrl, instance.getUrl());
    assertArrayEquals(new byte[]{-86, 1, 0, -64, 1, '*'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  public void testSetUrl9() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);
    ByteString newUrl = mock(ByteString.class);

    // Act
    assetIssueCapsule.setUrl(newUrl);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertSame(newUrl, assetIssueCapsule.getUrl());
    assertSame(newUrl, instance.getUrl());
    assertArrayEquals(new byte[]{-86, 1, 0, -56, 1, '\n'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  public void testSetUrl10() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setDescription(mock(ByteString.class));
    ByteString newUrl = mock(ByteString.class);

    // Act
    assetIssueCapsule.setUrl(newUrl);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(19, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertSame(newUrl, assetIssueCapsule.getUrl());
    assertSame(newUrl, instance.getUrl());
    assertArrayEquals(new byte[]{-94, 1, 0, -86, 1, 0}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getUrl()}
   */
  @Test
  public void testGetUrl() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Act
    ByteString actualUrl = assetIssueCapsule.getUrl();

    // Assert
    assertSame(assetIssueContract, assetIssueCapsule.getInstance());
    ByteString byteString = actualUrl.EMPTY;
    assertSame(byteString, assetIssueCapsule.getDesc());
    assertSame(byteString, assetIssueCapsule.getName());
    assertSame(byteString, assetIssueCapsule.getOwnerAddress());
    assertSame(byteString, actualUrl);
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getUrl()}
   */
  @Test
  public void testGetUrl2() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act
    ByteString actualUrl = assetIssueCapsule.getUrl();

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(19, fields.size());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    ByteString byteString = actualUrl.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, assetIssueCapsule.getDesc());
    assertSame(byteString, assetIssueCapsule.getName());
    assertSame(byteString, assetIssueCapsule.getOwnerAddress());
    assertSame(byteString, instance.getAbbr());
    assertSame(byteString, instance.getDescription());
    assertSame(byteString, instance.getName());
    assertSame(byteString, instance.getOwnerAddress());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  public void testSetDescription() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    ByteString description = mock(ByteString.class);

    // Act
    assetIssueCapsule.setDescription(description);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    assertEquals(3, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    ByteString byteString = description.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, assetIssueCapsule.getName());
    assertSame(byteString, assetIssueCapsule.getOwnerAddress());
    assertSame(byteString, assetIssueCapsule.getUrl());
    assertSame(byteString, instance.getAbbr());
    assertSame(byteString, instance.getName());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getUrl());
    assertSame(description, assetIssueCapsule.getDesc());
    assertSame(description, instance.getDescription());
    assertArrayEquals(new byte[]{-94, 1, 0}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  public void testSetDescription2() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, "42",
        "Name", "Abbr", 8192L, 8192);
    ByteString description = mock(ByteString.class);

    // Act
    assetIssueCapsule.setDescription(description);

    // Assert
    byte[] data = assetIssueCapsule.getData();
    assertEquals((byte) -54, data[31]);
    assertEquals((byte) -94, data[28]);
    assertEquals((byte) 0, data[30]);
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(19, fields.size());
    assertEquals((byte) 1, data[29]);
    assertEquals((byte) 2, data[33]);
    assertEquals((byte) 2, data[Integer.SIZE]);
    assertEquals(36, instance.getSerializedSize());
    assertEquals(36, data.length);
    assertEquals(7, instance.getAllFields().size());
    assertEquals('2', data[35]);
    assertEquals('4', data[34]);
    ByteString byteString = description.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, assetIssueCapsule.getUrl());
    AssetIssueContractOuterClass.AssetIssueContract defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAbbr());
    assertSame(byteString, defaultInstanceForType.getDescription());
    assertSame(byteString, defaultInstanceForType.getName());
    assertSame(byteString, defaultInstanceForType.getOwnerAddress());
    assertSame(byteString, instance.getUrl());
    assertSame(byteString, defaultInstanceForType.getUrl());
    assertSame(description, assetIssueCapsule.getDesc());
    assertSame(description, instance.getDescription());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  public void testSetDescription3() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setId("42");
    ByteString description = mock(ByteString.class);

    // Act
    assetIssueCapsule.setDescription(description);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    ByteString byteString = description.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, assetIssueCapsule.getName());
    assertSame(byteString, assetIssueCapsule.getOwnerAddress());
    assertSame(byteString, assetIssueCapsule.getUrl());
    assertSame(byteString, instance.getAbbr());
    assertSame(byteString, instance.getName());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getUrl());
    assertSame(description, assetIssueCapsule.getDesc());
    assertSame(description, instance.getDescription());
    assertArrayEquals(new byte[]{-94, 1, 0, -54, 2, 2, '4', '2'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  public void testSetDescription4() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPrecision(8192);
    ByteString description = mock(ByteString.class);

    // Act
    assetIssueCapsule.setDescription(description);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    ByteString byteString = description.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, assetIssueCapsule.getName());
    assertSame(byteString, assetIssueCapsule.getOwnerAddress());
    assertSame(byteString, assetIssueCapsule.getUrl());
    assertSame(byteString, instance.getAbbr());
    assertSame(byteString, instance.getName());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getUrl());
    assertSame(description, assetIssueCapsule.getDesc());
    assertSame(description, instance.getDescription());
    assertArrayEquals(new byte[]{'8', Byte.MIN_VALUE, '@', -94, 1, 0}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  public void testSetDescription5() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setOrder(8192L);
    ByteString description = mock(ByteString.class);

    // Act
    assetIssueCapsule.setDescription(description);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    ByteString byteString = description.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, assetIssueCapsule.getName());
    assertSame(byteString, assetIssueCapsule.getOwnerAddress());
    assertSame(byteString, assetIssueCapsule.getUrl());
    assertSame(byteString, instance.getAbbr());
    assertSame(byteString, instance.getName());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getUrl());
    assertSame(description, assetIssueCapsule.getDesc());
    assertSame(description, instance.getDescription());
    assertArrayEquals(new byte[]{'X', Byte.MIN_VALUE, '@', -94, 1, 0}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  public void testSetDescription6() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setFreeAssetNetLimit(8192L);
    ByteString description = mock(ByteString.class);

    // Act
    assetIssueCapsule.setDescription(description);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    ByteString byteString = description.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, assetIssueCapsule.getName());
    assertSame(byteString, assetIssueCapsule.getOwnerAddress());
    assertSame(byteString, assetIssueCapsule.getUrl());
    assertSame(byteString, instance.getAbbr());
    assertSame(byteString, instance.getName());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getUrl());
    assertSame(description, assetIssueCapsule.getDesc());
    assertSame(description, instance.getDescription());
    assertArrayEquals(new byte[]{-94, 1, 0, -80, 1, Byte.MIN_VALUE, '@'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  public void testSetDescription7() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicFreeAssetNetLimit(8192L);
    ByteString description = mock(ByteString.class);

    // Act
    assetIssueCapsule.setDescription(description);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    ByteString byteString = description.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, assetIssueCapsule.getName());
    assertSame(byteString, assetIssueCapsule.getOwnerAddress());
    assertSame(byteString, assetIssueCapsule.getUrl());
    assertSame(byteString, instance.getAbbr());
    assertSame(byteString, instance.getName());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getUrl());
    assertSame(description, assetIssueCapsule.getDesc());
    assertSame(description, instance.getDescription());
    assertArrayEquals(new byte[]{-94, 1, 0, -72, 1, Byte.MIN_VALUE, '@'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  public void testSetDescription8() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);
    ByteString description = mock(ByteString.class);

    // Act
    assetIssueCapsule.setDescription(description);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    ByteString byteString = description.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, assetIssueCapsule.getName());
    assertSame(byteString, assetIssueCapsule.getOwnerAddress());
    assertSame(byteString, assetIssueCapsule.getUrl());
    assertSame(byteString, instance.getAbbr());
    assertSame(byteString, instance.getName());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getUrl());
    assertSame(description, assetIssueCapsule.getDesc());
    assertSame(description, instance.getDescription());
    assertArrayEquals(new byte[]{-94, 1, 0, -64, 1, '*'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  public void testSetDescription9() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);
    ByteString description = mock(ByteString.class);

    // Act
    assetIssueCapsule.setDescription(description);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    ByteString byteString = description.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, assetIssueCapsule.getName());
    assertSame(byteString, assetIssueCapsule.getOwnerAddress());
    assertSame(byteString, assetIssueCapsule.getUrl());
    assertSame(byteString, instance.getAbbr());
    assertSame(byteString, instance.getName());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getUrl());
    assertSame(description, assetIssueCapsule.getDesc());
    assertSame(description, instance.getDescription());
    assertArrayEquals(new byte[]{-94, 1, 0, -56, 1, '\n'}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  public void testSetDescription10() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setUrl(mock(ByteString.class));
    ByteString description = mock(ByteString.class);

    // Act
    assetIssueCapsule.setDescription(description);

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    ByteString byteString = description.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, assetIssueCapsule.getName());
    assertSame(byteString, assetIssueCapsule.getOwnerAddress());
    assertSame(byteString, instance.getAbbr());
    assertSame(byteString, instance.getName());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(description, assetIssueCapsule.getDesc());
    assertSame(description, instance.getDescription());
    assertArrayEquals(new byte[]{-94, 1, 0, -86, 1, 0}, assetIssueCapsule.getData());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getDesc()}
   */
  @Test
  public void testGetDesc() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Act
    ByteString actualDesc = assetIssueCapsule.getDesc();

    // Assert
    assertSame(assetIssueContract, assetIssueCapsule.getInstance());
    ByteString byteString = actualDesc.EMPTY;
    assertSame(byteString, actualDesc);
    assertSame(byteString, assetIssueCapsule.getName());
    assertSame(byteString, assetIssueCapsule.getOwnerAddress());
    assertSame(byteString, assetIssueCapsule.getUrl());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#getDesc()}
   */
  @Test
  public void testGetDesc2() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Act
    ByteString actualDesc = assetIssueCapsule.getDesc();

    // Assert
    AssetIssueContractOuterClass.AssetIssueContract instance = assetIssueCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    ByteString byteString = actualDesc.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(17).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(18).toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertSame(assetIssueContract, instance.getDefaultInstanceForType());
    assertSame(byteString, getResult.getDefaultValue());
    assertSame(byteString, actualDesc);
    assertSame(byteString, assetIssueCapsule.getName());
    assertSame(byteString, assetIssueCapsule.getOwnerAddress());
    assertSame(byteString, instance.getAbbr());
    assertSame(byteString, instance.getDescription());
    assertSame(byteString, instance.getName());
    assertSame(byteString, instance.getOwnerAddress());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AssetIssueCapsule#AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract)}
   *   <li>{@link AssetIssueCapsule#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    // Act
    AssetIssueCapsule actualAssetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Assert
    assertEquals("", actualAssetIssueCapsule.toString());
    assertSame(assetIssueContract, actualAssetIssueCapsule.getInstance());
  }

  /**
   * Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  public void testNewAssetIssueCapsule() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new AssetIssueCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new AssetIssueCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new AssetIssueCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new AssetIssueCapsule(" XAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new AssetIssueCapsule("*XAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new AssetIssueCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new AssetIssueCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new AssetIssueCapsule("0XAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new AssetIssueCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new AssetIssueCapsule("8XAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new AssetIssueCapsule("@XAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new AssetIssueCapsule(new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new AssetIssueCapsule("HXAXAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new AssetIssueCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new AssetIssueCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new AssetIssueCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
    assertNull((new AssetIssueCapsule(" X*XAXAX".getBytes("UTF-8"))).getInstance());
    assertNull((new AssetIssueCapsule(new byte[]{'*', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }
}
