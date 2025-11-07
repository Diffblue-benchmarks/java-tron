package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import com.google.protobuf.ProtocolStringList;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.protos.Protocol;

public class VotesCapsuleDiffblueTest {
  /**
   * Method under test: {@link VotesCapsule#getAddress()}
   */
  @Test
  public void testGetAddress() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();
    VotesCapsule votesCapsule = new VotesCapsule(votes);

    // Act
    ByteString actualAddress = votesCapsule.getAddress();

    // Assert
    assertSame(votes, votesCapsule.getInstance());
    assertSame(actualAddress.EMPTY, actualAddress);
  }

  /**
   * Method under test: {@link VotesCapsule#getAddress()}
   */
  @Test
  public void testGetAddress2() {
    // Arrange
    ByteString address = mock(ByteString.class);
    VotesCapsule votesCapsule = new VotesCapsule(address, new ArrayList<>());

    // Act
    ByteString actualAddress = votesCapsule.getAddress();

    // Assert
    Protocol.Votes instance = votesCapsule.getInstance();
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(3, fields.size());
    ByteString byteString = actualAddress.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, instance.getDefaultInstanceForType().getAddress());
  }

  /**
   * Method under test: {@link VotesCapsule#setAddress(ByteString)}
   */
  @Test
  public void testSetAddress() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();
    VotesCapsule votesCapsule = new VotesCapsule(votes);
    ByteString address = mock(ByteString.class);

    // Act
    votesCapsule.setAddress(address);

    // Assert
    Protocol.Votes instance = votesCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    List<Protocol.Vote> newVotes = votesCapsule.getNewVotes();
    assertTrue(newVotes.isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(newVotes, toProtoResult.getDescriptorForType().toProto().findInitializationErrors());
    assertSame(newVotes, defaultInstanceForType.getEnumTypeList());
    DescriptorProtos.DescriptorProto toProtoResult2 = options.getDescriptorForType().toProto();
    assertSame(newVotes, toProtoResult2.getEnumTypeList());
    assertSame(newVotes, toProtoResult.getEnumTypeList());
    assertSame(newVotes, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(newVotes, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(newVotes, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType.getExtensionList());
    assertSame(newVotes, toProtoResult2.getExtensionList());
    assertSame(newVotes, toProtoResult.getExtensionList());
    assertSame(newVotes, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(newVotes, toProtoResult2.getExtensionOrBuilderList());
    assertSame(newVotes, toProtoResult.getExtensionOrBuilderList());
    assertSame(newVotes, defaultInstanceForType.getExtensionRangeList());
    assertSame(newVotes, toProtoResult.getExtensionRangeList());
    assertSame(newVotes, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(newVotes, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType.getFieldList());
    assertSame(newVotes, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(newVotes, defaultInstanceForType.getNestedTypeList());
    assertSame(newVotes, toProtoResult2.getNestedTypeList());
    assertSame(newVotes, toProtoResult.getNestedTypeList());
    assertSame(newVotes, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(newVotes, toProtoResult2.getNestedTypeOrBuilderList());
    assertSame(newVotes, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType.getOneofDeclList());
    assertSame(newVotes, toProtoResult2.getOneofDeclList());
    assertSame(newVotes, toProtoResult.getOneofDeclList());
    assertSame(newVotes, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(newVotes, toProtoResult2.getOneofDeclOrBuilderList());
    assertSame(newVotes, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(newVotes, defaultInstanceForType.getReservedRangeList());
    assertSame(newVotes, toProtoResult.getReservedRangeList());
    assertSame(newVotes, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(newVotes, toProtoResult.getReservedRangeOrBuilderList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(newVotes, options2.getEditionDefaultsList());
    assertSame(newVotes, options2.getEditionDefaultsOrBuilderList());
    assertSame(newVotes, options2.getUninterpretedOptionList());
    assertSame(newVotes, options2.getUninterpretedOptionOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertSame(newVotes, defaultInstanceForType2.getEnumTypeList());
    assertSame(newVotes, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getExtensionList());
    assertSame(newVotes, toProtoResult3.getExtensionList());
    assertSame(newVotes, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(newVotes, toProtoResult3.getExtensionOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getMessageTypeList());
    assertSame(newVotes, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getServiceList());
    assertSame(newVotes, toProtoResult3.getServiceList());
    assertSame(newVotes, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(newVotes, toProtoResult3.getServiceOrBuilderList());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options3.getDefaultInstanceForType();
    assertSame(newVotes, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(newVotes, options3.getUninterpretedOptionList());
    assertSame(newVotes, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(newVotes, options3.getUninterpretedOptionOrBuilderList());
    assertSame(newVotes, options.getUninterpretedOptionList());
    assertSame(newVotes, options.getUninterpretedOptionOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(newVotes, sourceCodeInfo.getLocationList());
    assertSame(newVotes, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(newVotes, votesCapsule.getOldVotes());
    assertSame(newVotes, instance.getOldVotesList());
    assertSame(newVotes, instance.getOldVotesOrBuilderList());
    assertSame(votes, instance.getDefaultInstanceForType());
    ByteString expectedDefaultValue = address.EMPTY;
    assertSame(expectedDefaultValue, getResult.getDefaultValue());
    assertSame(address, votesCapsule.getAddress());
    assertSame(address, instance.getAddress());
    assertArrayEquals(new byte[]{'\n', 0}, votesCapsule.getData());
  }

  /**
   * Method under test: {@link VotesCapsule#setAddress(ByteString)}
   */
  @Test
  public void testSetAddress2() {
    // Arrange
    ByteString address = mock(ByteString.class);
    ArrayList<Protocol.Vote> oldVotes = new ArrayList<>();
    VotesCapsule votesCapsule = new VotesCapsule(address, oldVotes);
    ByteString address2 = mock(ByteString.class);

    // Act
    votesCapsule.setAddress(address2);

    // Assert
    Protocol.Votes instance = votesCapsule.getInstance();
    assertEquals(oldVotes,
        instance.getDescriptorForType().toProto().getDescriptorForType().toProto().findInitializationErrors());
    assertSame(address2, votesCapsule.getAddress());
    assertSame(address2, instance.getAddress());
  }

  /**
   * Method under test: {@link VotesCapsule#setAddress(ByteString)}
   */
  @Test
  public void testSetAddress3() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    VotesCapsule votesCapsule = new VotesCapsule(votes);
    ArrayList<Protocol.Vote> votesToAdd = new ArrayList<>();
    votesCapsule.addAllNewVotes(votesToAdd);
    ByteString address = mock(ByteString.class);

    // Act
    votesCapsule.setAddress(address);

    // Assert
    Protocol.Votes instance = votesCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    List<Protocol.Vote> newVotes = votesCapsule.getNewVotes();
    assertTrue(newVotes.isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(votesToAdd, toProtoResult.getDescriptorForType().toProto().findInitializationErrors());
    assertSame(newVotes, defaultInstanceForType.getEnumTypeList());
    DescriptorProtos.DescriptorProto toProtoResult2 = options.getDescriptorForType().toProto();
    assertSame(newVotes, toProtoResult2.getEnumTypeList());
    assertSame(newVotes, toProtoResult.getEnumTypeList());
    assertSame(newVotes, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(newVotes, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(newVotes, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType.getExtensionList());
    assertSame(newVotes, toProtoResult2.getExtensionList());
    assertSame(newVotes, toProtoResult.getExtensionList());
    assertSame(newVotes, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(newVotes, toProtoResult2.getExtensionOrBuilderList());
    assertSame(newVotes, toProtoResult.getExtensionOrBuilderList());
    assertSame(newVotes, defaultInstanceForType.getExtensionRangeList());
    assertSame(newVotes, toProtoResult.getExtensionRangeList());
    assertSame(newVotes, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(newVotes, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType.getFieldList());
    assertSame(newVotes, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(newVotes, defaultInstanceForType.getNestedTypeList());
    assertSame(newVotes, toProtoResult2.getNestedTypeList());
    assertSame(newVotes, toProtoResult.getNestedTypeList());
    assertSame(newVotes, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(newVotes, toProtoResult2.getNestedTypeOrBuilderList());
    assertSame(newVotes, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType.getOneofDeclList());
    assertSame(newVotes, toProtoResult2.getOneofDeclList());
    assertSame(newVotes, toProtoResult.getOneofDeclList());
    assertSame(newVotes, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(newVotes, toProtoResult2.getOneofDeclOrBuilderList());
    assertSame(newVotes, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(newVotes, defaultInstanceForType.getReservedRangeList());
    assertSame(newVotes, toProtoResult.getReservedRangeList());
    assertSame(newVotes, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(newVotes, toProtoResult.getReservedRangeOrBuilderList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(newVotes, options2.getEditionDefaultsList());
    assertSame(newVotes, options2.getEditionDefaultsOrBuilderList());
    assertSame(newVotes, options2.getUninterpretedOptionList());
    assertSame(newVotes, options2.getUninterpretedOptionOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertSame(newVotes, defaultInstanceForType2.getEnumTypeList());
    assertSame(newVotes, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getExtensionList());
    assertSame(newVotes, toProtoResult3.getExtensionList());
    assertSame(newVotes, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(newVotes, toProtoResult3.getExtensionOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getMessageTypeList());
    assertSame(newVotes, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getServiceList());
    assertSame(newVotes, toProtoResult3.getServiceList());
    assertSame(newVotes, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(newVotes, toProtoResult3.getServiceOrBuilderList());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options3.getDefaultInstanceForType();
    assertSame(newVotes, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(newVotes, options3.getUninterpretedOptionList());
    assertSame(newVotes, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(newVotes, options3.getUninterpretedOptionOrBuilderList());
    assertSame(newVotes, options.getUninterpretedOptionList());
    assertSame(newVotes, options.getUninterpretedOptionOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(newVotes, sourceCodeInfo.getLocationList());
    assertSame(newVotes, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(newVotes, votesCapsule.getOldVotes());
    assertSame(newVotes, instance.getOldVotesList());
    assertSame(newVotes, instance.getOldVotesOrBuilderList());
    assertSame(votes, instance.getDefaultInstanceForType());
    ByteString expectedDefaultValue = address.EMPTY;
    assertSame(expectedDefaultValue, getResult.getDefaultValue());
    assertSame(address, votesCapsule.getAddress());
    assertSame(address, instance.getAddress());
    assertArrayEquals(new byte[]{'\n', 0}, votesCapsule.getData());
  }

  /**
   * Method under test: {@link VotesCapsule#setAddress(ByteString)}
   */
  @Test
  public void testSetAddress4() {
    // Arrange
    ArrayList<Protocol.Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Protocol.Vote.getDefaultInstance());
    VotesCapsule votesCapsule = new VotesCapsule(mock(ByteString.class), oldVotes);
    ByteString address = mock(ByteString.class);

    // Act
    votesCapsule.setAddress(address);

    // Assert
    List<Protocol.Vote> oldVotes2 = votesCapsule.getOldVotes();
    assertEquals(1, oldVotes2.size());
    Protocol.Votes instance = votesCapsule.getInstance();
    assertSame(oldVotes2, instance.getOldVotesList());
    assertSame(oldVotes2, instance.getOldVotesOrBuilderList());
    assertSame(address, votesCapsule.getAddress());
    assertSame(address, instance.getAddress());
  }

  /**
   * Method under test: {@link VotesCapsule#setAddress(ByteString)}
   */
  @Test
  public void testSetAddress5() {
    // Arrange
    ArrayList<Protocol.Vote> votesToAdd = new ArrayList<>();
    votesToAdd.add(Protocol.Vote.getDefaultInstance());
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    VotesCapsule votesCapsule = new VotesCapsule(votes);
    votesCapsule.addAllNewVotes(votesToAdd);
    ByteString address = mock(ByteString.class);

    // Act
    votesCapsule.setAddress(address);

    // Assert
    Protocol.Votes instance = votesCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(4, instance.getSerializedSize());
    List<Protocol.Vote> oldVotes = votesCapsule.getOldVotes();
    assertTrue(oldVotes.isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(votesToAdd, votesCapsule.getNewVotes());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType.getEnumTypeList());
    DescriptorProtos.DescriptorProto toProtoResult2 = options.getDescriptorForType().toProto();
    assertSame(oldVotes, toProtoResult2.getEnumTypeList());
    assertSame(oldVotes, toProtoResult.getEnumTypeList());
    assertSame(oldVotes, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionList());
    assertSame(oldVotes, toProtoResult2.getExtensionList());
    assertSame(oldVotes, toProtoResult.getExtensionList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult.getExtensionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionRangeList());
    assertSame(oldVotes, toProtoResult.getExtensionRangeList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getFieldList());
    assertSame(oldVotes, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getNestedTypeList());
    assertSame(oldVotes, toProtoResult.getNestedTypeList());
    assertSame(oldVotes, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getOneofDeclList());
    assertSame(oldVotes, toProtoResult.getOneofDeclList());
    assertSame(oldVotes, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(oldVotes, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getReservedRangeList());
    assertSame(oldVotes, toProtoResult.getReservedRangeList());
    assertSame(oldVotes, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getReservedRangeOrBuilderList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(oldVotes, options2.getEditionDefaultsList());
    assertSame(oldVotes, options2.getEditionDefaultsOrBuilderList());
    assertSame(oldVotes, options2.getUninterpretedOptionList());
    assertSame(oldVotes, options2.getUninterpretedOptionOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType2.getEnumTypeList());
    assertSame(oldVotes, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionList());
    assertSame(oldVotes, toProtoResult3.getExtensionList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getExtensionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getMessageTypeList());
    assertSame(oldVotes, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getServiceList());
    assertSame(oldVotes, toProtoResult3.getServiceList());
    assertSame(oldVotes, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getServiceOrBuilderList());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options3.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(oldVotes, options3.getUninterpretedOptionList());
    assertSame(oldVotes, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, options3.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, options.getUninterpretedOptionList());
    assertSame(oldVotes, options.getUninterpretedOptionOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(oldVotes, sourceCodeInfo.getLocationList());
    assertSame(oldVotes, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
    assertSame(votes, instance.getDefaultInstanceForType());
    ByteString expectedDefaultValue = address.EMPTY;
    assertSame(expectedDefaultValue, getResult.getDefaultValue());
    assertSame(address, votesCapsule.getAddress());
    assertSame(address, instance.getAddress());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0}, votesCapsule.getData());
  }

  /**
   * Method under test: {@link VotesCapsule#getOldVotes()}
   */
  @Test
  public void testGetOldVotes() {
    // Arrange, Act and Assert
    assertTrue((new VotesCapsule(Protocol.Votes.getDefaultInstance())).getOldVotes().isEmpty());
  }

  /**
   * Method under test: {@link VotesCapsule#getOldVotes()}
   */
  @Test
  public void testGetOldVotes2() {
    // Arrange
    ByteString address = mock(ByteString.class);

    // Act and Assert
    assertTrue((new VotesCapsule(address, new ArrayList<>())).getOldVotes().isEmpty());
  }

  /**
   * Method under test: {@link VotesCapsule#setOldVotes(List)}
   */
  @Test
  public void testSetOldVotes() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();
    VotesCapsule votesCapsule = new VotesCapsule(votes);

    // Act
    votesCapsule.setOldVotes(new ArrayList<>());

    // Assert
    assertTrue(votesCapsule.getNewVotes().isEmpty());
    assertTrue(votesCapsule.getOldVotes().isEmpty());
    assertEquals(votes, votesCapsule.getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#setOldVotes(List)}
   */
  @Test
  public void testSetOldVotes2() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    VotesCapsule votesCapsule = new VotesCapsule(votes);
    votesCapsule.addAllNewVotes(new ArrayList<>());

    // Act
    votesCapsule.setOldVotes(new ArrayList<>());

    // Assert
    assertTrue(votesCapsule.getNewVotes().isEmpty());
    assertTrue(votesCapsule.getOldVotes().isEmpty());
    assertEquals(votes, votesCapsule.getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#setOldVotes(List)}
   */
  @Test
  public void testSetOldVotes3() {
    // Arrange
    ArrayList<Protocol.Vote> votesToAdd = new ArrayList<>();
    votesToAdd.add(Protocol.Vote.getDefaultInstance());
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    VotesCapsule votesCapsule = new VotesCapsule(votes);
    votesCapsule.addAllNewVotes(votesToAdd);

    // Act
    votesCapsule.setOldVotes(new ArrayList<>());

    // Assert
    Protocol.Votes instance = votesCapsule.getInstance();
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    List<Protocol.Vote> oldVotes = votesCapsule.getOldVotes();
    assertTrue(oldVotes.isEmpty());
    assertEquals(votesToAdd, votesCapsule.getNewVotes());
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
    assertSame(votes, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link VotesCapsule#getNewVotes()}
   */
  @Test
  public void testGetNewVotes() {
    // Arrange, Act and Assert
    assertTrue((new VotesCapsule(Protocol.Votes.getDefaultInstance())).getNewVotes().isEmpty());
  }

  /**
   * Method under test: {@link VotesCapsule#getNewVotes()}
   */
  @Test
  public void testGetNewVotes2() {
    // Arrange
    ByteString address = mock(ByteString.class);

    // Act and Assert
    assertTrue((new VotesCapsule(address, new ArrayList<>())).getNewVotes().isEmpty());
  }

  /**
   * Method under test: {@link VotesCapsule#clearNewVotes()}
   */
  @Test
  public void testClearNewVotes() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();
    VotesCapsule votesCapsule = new VotesCapsule(votes);

    // Act
    votesCapsule.clearNewVotes();

    // Assert
    assertEquals(0, votesCapsule.getData().length);
    List<Protocol.Vote> newVotes = votesCapsule.getNewVotes();
    assertTrue(newVotes.isEmpty());
    assertEquals(votes, votesCapsule.getInstance());
    assertSame(newVotes, votesCapsule.getOldVotes());
  }

  /**
   * Method under test: {@link VotesCapsule#clearNewVotes()}
   */
  @Test
  public void testClearNewVotes2() {
    // Arrange
    ByteString address = mock(ByteString.class);
    ArrayList<Protocol.Vote> oldVotes = new ArrayList<>();
    VotesCapsule votesCapsule = new VotesCapsule(address, oldVotes);

    // Act
    votesCapsule.clearNewVotes();

    // Assert
    assertEquals(oldVotes,
        votesCapsule.getInstance()
            .getDescriptorForType()
            .toProto()
            .getDescriptorForType()
            .toProto()
            .findInitializationErrors());
  }

  /**
   * Method under test: {@link VotesCapsule#clearNewVotes()}
   */
  @Test
  public void testClearNewVotes3() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    VotesCapsule votesCapsule = new VotesCapsule(votes);
    votesCapsule.addAllNewVotes(new ArrayList<>());

    // Act
    votesCapsule.clearNewVotes();

    // Assert
    assertEquals(0, votesCapsule.getData().length);
    List<Protocol.Vote> newVotes = votesCapsule.getNewVotes();
    assertTrue(newVotes.isEmpty());
    assertEquals(votes, votesCapsule.getInstance());
    assertSame(newVotes, votesCapsule.getOldVotes());
  }

  /**
   * Method under test: {@link VotesCapsule#clearNewVotes()}
   */
  @Test
  public void testClearNewVotes4() {
    // Arrange
    ArrayList<Protocol.Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Protocol.Vote.getDefaultInstance());
    VotesCapsule votesCapsule = new VotesCapsule(mock(ByteString.class), oldVotes);

    // Act
    votesCapsule.clearNewVotes();

    // Assert
    List<Protocol.Vote> oldVotes2 = votesCapsule.getOldVotes();
    assertEquals(1, oldVotes2.size());
    Protocol.Votes instance = votesCapsule.getInstance();
    assertSame(oldVotes2, instance.getOldVotesList());
    assertSame(oldVotes2, instance.getOldVotesOrBuilderList());
  }

  /**
   * Method under test: {@link VotesCapsule#clearNewVotes()}
   */
  @Test
  public void testClearNewVotes5() {
    // Arrange
    ArrayList<Protocol.Vote> votesToAdd = new ArrayList<>();
    votesToAdd.add(Protocol.Vote.getDefaultInstance());
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    VotesCapsule votesCapsule = new VotesCapsule(votes);
    votesCapsule.addAllNewVotes(votesToAdd);

    // Act
    votesCapsule.clearNewVotes();

    // Assert
    assertEquals(0, votesCapsule.getData().length);
    List<Protocol.Vote> newVotes = votesCapsule.getNewVotes();
    assertTrue(newVotes.isEmpty());
    assertEquals(votes, votesCapsule.getInstance());
    assertSame(newVotes, votesCapsule.getOldVotes());
  }

  /**
   * Method under test: {@link VotesCapsule#clearOldVotes()}
   */
  @Test
  public void testClearOldVotes() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();
    VotesCapsule votesCapsule = new VotesCapsule(votes);

    // Act
    votesCapsule.clearOldVotes();

    // Assert
    assertEquals(votes, votesCapsule.getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#clearOldVotes()}
   */
  @Test
  public void testClearOldVotes2() {
    // Arrange
    ByteString address = mock(ByteString.class);
    ArrayList<Protocol.Vote> oldVotes = new ArrayList<>();
    VotesCapsule votesCapsule = new VotesCapsule(address, oldVotes);

    // Act
    votesCapsule.clearOldVotes();

    // Assert
    Protocol.Votes instance = votesCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult = options.getDescriptorForType().toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    Descriptors.Descriptor descriptorForType2 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType2.getName());
    assertEquals("MessageOptions", toProtoResult.getName());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    Descriptors.Descriptor messageType = fields.get(1).getMessageType();
    assertEquals("Vote", messageType.getName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType2.getFullName());
    assertEquals("protocol.Vote", messageType.getFullName());
    assertNull(messageType.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, instance.getOldVotesCount());
    assertEquals(1, toProtoResult.getExtensionRangeCount());
    assertEquals(1, messageType.getIndex());
    assertEquals(1, instance.getAllFields().size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    Descriptors.Descriptor descriptorForType3 = toProtoResult2.getDescriptorForType();
    assertEquals(10, descriptorForType3.getFields().size());
    assertEquals(19, descriptorForType2.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, votesCapsule.getData().length);
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(45, file.toProto().getMessageTypeList().size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    assertEquals(5, toProtoResult.getReservedRangeCount());
    assertEquals(500, toProtoResult.getSerializedSize());
    assertEquals(7, toProtoResult.getFieldCount());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(messageType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(descriptorForType2.isExtendable());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertEquals(oldVotes, descriptorForType3.toProto().findInitializationErrors());
    assertEquals(oldVotes, messageType.getEnumTypes());
    assertEquals(oldVotes, messageType.getExtensions());
    assertEquals(oldVotes, descriptorForType2.getExtensions());
    assertEquals(oldVotes, messageType.getNestedTypes());
    assertEquals(oldVotes, descriptorForType2.getNestedTypes());
    assertEquals(oldVotes, messageType.getOneofs());
    assertEquals(oldVotes, descriptorForType2.getOneofs());
    assertEquals(oldVotes, messageType.getRealOneofs());
    assertEquals(oldVotes, descriptorForType2.getRealOneofs());
    assertSame(file, messageType.getFile());
    assertSame(messageType, fields.get(2).getMessageType());
    assertSame(messageType, messageTypes.get(1));
  }

  /**
   * Method under test: {@link VotesCapsule#clearOldVotes()}
   */
  @Test
  public void testClearOldVotes3() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    VotesCapsule votesCapsule = new VotesCapsule(votes);
    votesCapsule.addAllNewVotes(new ArrayList<>());

    // Act
    votesCapsule.clearOldVotes();

    // Assert
    assertEquals(votes, votesCapsule.getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#clearOldVotes()}
   */
  @Test
  public void testClearOldVotes4() {
    // Arrange
    ArrayList<Protocol.Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Protocol.Vote.getDefaultInstance());
    VotesCapsule votesCapsule = new VotesCapsule(mock(ByteString.class), oldVotes);

    // Act
    votesCapsule.clearOldVotes();

    // Assert
    Protocol.Votes instance = votesCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult = options.getDescriptorForType().toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    Descriptors.Descriptor descriptorForType2 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType2.getName());
    assertEquals("MessageOptions", toProtoResult.getName());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    Descriptors.Descriptor messageType = fields.get(1).getMessageType();
    assertEquals("Vote", messageType.getName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType2.getFullName());
    assertEquals("protocol.Vote", messageType.getFullName());
    assertNull(messageType.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, instance.getOldVotesCount());
    assertEquals(1, toProtoResult.getExtensionRangeCount());
    assertEquals(1, messageType.getIndex());
    assertEquals(1, instance.getAllFields().size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    Descriptors.Descriptor descriptorForType3 = toProtoResult2.getDescriptorForType();
    assertEquals(10, descriptorForType3.getFields().size());
    assertEquals(19, descriptorForType2.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, votesCapsule.getData().length);
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(45, file.toProto().getMessageTypeList().size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    assertEquals(5, toProtoResult.getReservedRangeCount());
    assertEquals(500, toProtoResult.getSerializedSize());
    assertEquals(7, toProtoResult.getFieldCount());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(messageType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(descriptorForType2.isExtendable());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertSame(file, messageType.getFile());
    assertSame(messageType, fields.get(2).getMessageType());
    assertSame(messageType, messageTypes.get(1));
  }

  /**
   * Method under test: {@link VotesCapsule#clearOldVotes()}
   */
  @Test
  public void testClearOldVotes5() {
    // Arrange
    ArrayList<Protocol.Vote> votesToAdd = new ArrayList<>();
    votesToAdd.add(Protocol.Vote.getDefaultInstance());
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    VotesCapsule votesCapsule = new VotesCapsule(votes);
    votesCapsule.addAllNewVotes(votesToAdd);

    // Act
    votesCapsule.clearOldVotes();

    // Assert
    Protocol.Votes instance = votesCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    List<Protocol.Vote> oldVotes = votesCapsule.getOldVotes();
    assertTrue(oldVotes.isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType.getEnumTypeList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult2 = options.getDescriptorForType().toProto();
    assertSame(oldVotes, toProtoResult2.getEnumTypeList());
    assertSame(oldVotes, toProtoResult.getEnumTypeList());
    assertSame(oldVotes, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionList());
    assertSame(oldVotes, toProtoResult2.getExtensionList());
    assertSame(oldVotes, toProtoResult.getExtensionList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult.getExtensionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionRangeList());
    assertSame(oldVotes, toProtoResult.getExtensionRangeList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getFieldList());
    assertSame(oldVotes, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getNestedTypeList());
    assertSame(oldVotes, toProtoResult.getNestedTypeList());
    assertSame(oldVotes, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getOneofDeclList());
    assertSame(oldVotes, toProtoResult.getOneofDeclList());
    assertSame(oldVotes, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(oldVotes, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getReservedRangeList());
    assertSame(oldVotes, toProtoResult.getReservedRangeList());
    assertSame(oldVotes, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getReservedRangeOrBuilderList());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertSame(oldVotes, options2.getEditionDefaultsList());
    assertSame(oldVotes, options2.getEditionDefaultsOrBuilderList());
    assertSame(oldVotes, options2.getUninterpretedOptionList());
    assertSame(oldVotes, options2.getUninterpretedOptionOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType2.getEnumTypeList());
    assertSame(oldVotes, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionList());
    assertSame(oldVotes, toProtoResult3.getExtensionList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getExtensionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getMessageTypeList());
    assertSame(oldVotes, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getServiceList());
    assertSame(oldVotes, toProtoResult3.getServiceList());
    assertSame(oldVotes, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getServiceOrBuilderList());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options3.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(oldVotes, options3.getUninterpretedOptionList());
    assertSame(oldVotes, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, options3.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, options.getUninterpretedOptionList());
    assertSame(oldVotes, options.getUninterpretedOptionOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(oldVotes, sourceCodeInfo.getLocationList());
    assertSame(oldVotes, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
    assertSame(votes, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link VotesCapsule#addNewVotes(ByteString, long)}
   */
  @Test
  public void testAddNewVotes() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();
    VotesCapsule votesCapsule = new VotesCapsule(votes);
    ByteString voteAddress = mock(ByteString.class);

    // Act
    votesCapsule.addNewVotes(voteAddress, 3L);

    // Assert
    List<Protocol.Vote> newVotes = votesCapsule.getNewVotes();
    assertEquals(1, newVotes.size());
    Protocol.Vote getResult = newVotes.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Vote defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals("Vote", toProtoResult.getName());
    assertEquals("Vote", descriptorForType.getName());
    assertEquals("protocol.Vote", descriptorForType.getFullName());
    assertNull(descriptorForType.getContainingType());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getVoteCount());
    assertEquals(1, descriptorForType.getIndex());
    Protocol.Votes instance = votesCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getNewVotesCount());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, getResult.getAllFields().size());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(3, fields.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    assertEquals(3L, getResult.getVoteCount());
    assertEquals(4, getResult.getSerializedSize());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertEquals(45, toProtoResult2.getMessageTypeList().size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    assertEquals(48, toProtoResult.getSerializedSize());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    ProtocolStringList reservedNameList = toProtoResult3.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Protocol.Vote> oldVotes = votesCapsule.getOldVotes();
    assertTrue(oldVotes.isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertEquals(oldVotes, defaultInstanceForType2.findInitializationErrors());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertEquals(oldVotes, defaultInstanceForType3.findInitializationErrors());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals(oldVotes, sourceCodeInfo.findInitializationErrors());
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertEquals(oldVotes, defaultInstanceForType4.findInitializationErrors());
    assertEquals(oldVotes, options.getFeatures().findInitializationErrors());
    assertEquals(oldVotes, toProtoResult.findInitializationErrors());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertEquals(oldVotes, options3.findInitializationErrors());
    assertEquals(oldVotes, getResult2.toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertEquals(oldVotes, getResult3.toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertEquals(oldVotes, getResult4.toProto().findInitializationErrors());
    assertEquals(oldVotes, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType4 = toProtoResult3.getDescriptorForType();
    assertEquals(oldVotes, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals(oldVotes, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals(oldVotes, getResult5.getEnumTypes());
    Descriptors.Descriptor getResult6 = messageTypes.get(43);
    assertEquals(oldVotes, getResult6.getEnumTypes());
    Descriptors.Descriptor getResult7 = messageTypes.get(44);
    assertEquals(oldVotes, getResult7.getEnumTypes());
    assertEquals(oldVotes, descriptorForType4.getExtensions());
    Descriptors.Descriptor descriptorForType6 = options2.getDescriptorForType();
    assertEquals(oldVotes, descriptorForType6.getExtensions());
    assertEquals(oldVotes, descriptorForType5.getExtensions());
    assertEquals(oldVotes, getResult5.getExtensions());
    assertEquals(oldVotes, getResult6.getExtensions());
    assertEquals(oldVotes, getResult7.getExtensions());
    assertEquals(oldVotes, descriptorForType3.getNestedTypes());
    assertEquals(oldVotes, descriptorForType6.getNestedTypes());
    assertEquals(oldVotes, descriptorForType5.getNestedTypes());
    assertEquals(oldVotes, getResult5.getNestedTypes());
    assertEquals(oldVotes, getResult6.getNestedTypes());
    assertEquals(oldVotes, getResult7.getNestedTypes());
    assertEquals(oldVotes, descriptorForType3.getOneofs());
    assertEquals(oldVotes, descriptorForType4.getOneofs());
    assertEquals(oldVotes, descriptorForType6.getOneofs());
    assertEquals(oldVotes, descriptorForType5.getOneofs());
    assertEquals(oldVotes, getResult5.getOneofs());
    assertEquals(oldVotes, getResult6.getOneofs());
    assertEquals(oldVotes, getResult7.getOneofs());
    assertEquals(oldVotes, descriptorForType3.getRealOneofs());
    assertEquals(oldVotes, descriptorForType4.getRealOneofs());
    assertEquals(oldVotes, descriptorForType6.getRealOneofs());
    assertEquals(oldVotes, descriptorForType5.getRealOneofs());
    assertEquals(oldVotes, getResult5.getRealOneofs());
    assertEquals(oldVotes, getResult6.getRealOneofs());
    assertEquals(oldVotes, getResult7.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    assertEquals(oldVotes, file2.getDependencies());
    Descriptors.FileDescriptor getResult8 = dependencies.get(0);
    assertEquals(oldVotes, getResult8.getDependencies());
    Descriptors.FileDescriptor getResult9 = dependencies.get(1);
    assertEquals(oldVotes, getResult9.getDependencies());
    Descriptors.FileDescriptor getResult10 = dependencies.get(2);
    assertEquals(oldVotes, getResult10.getDependencies());
    assertEquals(oldVotes, getResult8.getEnumTypes());
    assertEquals(oldVotes, getResult9.getEnumTypes());
    assertEquals(oldVotes, file2.getExtensions());
    assertEquals(oldVotes, getResult8.getExtensions());
    assertEquals(oldVotes, getResult9.getExtensions());
    assertEquals(oldVotes, getResult10.getExtensions());
    assertEquals(oldVotes, getResult10.getMessageTypes());
    assertEquals(oldVotes, file2.getPublicDependencies());
    assertEquals(oldVotes, getResult8.getPublicDependencies());
    assertEquals(oldVotes, getResult9.getPublicDependencies());
    assertEquals(oldVotes, getResult10.getPublicDependencies());
    assertEquals(oldVotes, file2.getServices());
    assertEquals(oldVotes, getResult8.getServices());
    assertEquals(oldVotes, getResult9.getServices());
    assertEquals(oldVotes, getResult10.getServices());
    assertSame(defaultInstanceForType2, toProtoResult.getDefaultInstanceForType());
    assertSame(file, descriptorForType.getFile());
    assertSame(descriptorForType, getResult3.getMessageType());
    assertSame(descriptorForType, getResult4.getMessageType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(oldVotes, defaultInstanceForType2.getEnumTypeList());
    assertSame(oldVotes, toProtoResult.getEnumTypeList());
    assertSame(oldVotes, toProtoResult3.getEnumTypeList());
    assertSame(oldVotes, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionList());
    assertSame(oldVotes, toProtoResult.getExtensionList());
    assertSame(oldVotes, toProtoResult3.getExtensionList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getExtensionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionRangeList());
    assertSame(oldVotes, toProtoResult.getExtensionRangeList());
    assertSame(oldVotes, toProtoResult3.getExtensionRangeList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getFieldList());
    assertSame(oldVotes, defaultInstanceForType2.getFieldOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getNestedTypeList());
    assertSame(oldVotes, toProtoResult.getNestedTypeList());
    assertSame(oldVotes, toProtoResult3.getNestedTypeList());
    assertSame(oldVotes, defaultInstanceForType2.getNestedTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getOneofDeclList());
    assertSame(oldVotes, toProtoResult.getOneofDeclList());
    assertSame(oldVotes, toProtoResult3.getOneofDeclList());
    assertSame(oldVotes, defaultInstanceForType2.getOneofDeclOrBuilderList());
    assertSame(oldVotes, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getReservedRangeList());
    assertSame(oldVotes, toProtoResult.getReservedRangeList());
    assertSame(oldVotes, toProtoResult3.getReservedRangeList());
    assertSame(oldVotes, defaultInstanceForType2.getReservedRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getReservedRangeOrBuilderList());
    assertSame(oldVotes, options3.getEditionDefaultsList());
    assertSame(oldVotes, options3.getEditionDefaultsOrBuilderList());
    assertSame(oldVotes, options3.getUninterpretedOptionList());
    assertSame(oldVotes, options3.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType3.getEnumTypeList());
    assertSame(oldVotes, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType3.getExtensionList());
    assertSame(oldVotes, toProtoResult2.getExtensionList());
    assertSame(oldVotes, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getExtensionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType3.getMessageTypeList());
    assertSame(oldVotes, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType3.getServiceList());
    assertSame(oldVotes, toProtoResult2.getServiceList());
    assertSame(oldVotes, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getServiceOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(oldVotes, options2.getUninterpretedOptionList());
    assertSame(oldVotes, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, options2.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, options.getUninterpretedOptionList());
    assertSame(oldVotes, options.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, sourceCodeInfo.getLocationList());
    assertSame(oldVotes, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(votes, instance.getDefaultInstanceForType());
    ByteString expectedVoteAddress = voteAddress.EMPTY;
    assertSame(expectedVoteAddress, defaultInstanceForType.getVoteAddress());
    assertSame(voteAddress, getResult.getVoteAddress());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    assertArrayEquals(new byte[]{26, 4, '\n', 0, 16, 3}, votesCapsule.getData());
  }

  /**
   * Method under test: {@link VotesCapsule#addNewVotes(ByteString, long)}
   */
  @Test
  public void testAddNewVotes2() {
    // Arrange
    ByteString address = mock(ByteString.class);
    ArrayList<Protocol.Vote> oldVotes = new ArrayList<>();
    VotesCapsule votesCapsule = new VotesCapsule(address, oldVotes);
    ByteString voteAddress = mock(ByteString.class);

    // Act
    votesCapsule.addNewVotes(voteAddress, 3L);

    // Assert
    List<Protocol.Vote> newVotes = votesCapsule.getNewVotes();
    assertEquals(1, newVotes.size());
    Protocol.Vote getResult = newVotes.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Vote defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals("Vote", toProtoResult.getName());
    assertEquals("Vote", descriptorForType.getName());
    assertEquals("protocol.Vote", descriptorForType.getFullName());
    assertNull(descriptorForType.getContainingType());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getVoteCount());
    byte[] data = votesCapsule.getData();
    assertEquals((byte) 0, data[5]);
    assertEquals(1, descriptorForType.getIndex());
    Protocol.Votes instance = votesCapsule.getInstance();
    assertEquals(1, instance.getNewVotesCount());
    assertEquals((byte) 16, data[6]);
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[2]);
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(3, fields.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    assertEquals(3L, getResult.getVoteCount());
    assertEquals((byte) 3, data[7]);
    assertEquals(4, getResult.getSerializedSize());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertEquals(45, toProtoResult2.getMessageTypeList().size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    assertEquals(48, toProtoResult.getSerializedSize());
    assertEquals((byte) 4, data[3]);
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, data.length);
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    Protocol.Votes defaultInstanceForType2 = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType2.findInitializationErrors().isEmpty());
    ProtocolStringList reservedNameList = toProtoResult3.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Protocol.Vote> oldVotes2 = votesCapsule.getOldVotes();
    assertTrue(oldVotes2.isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals(oldVotes, defaultInstanceForType3.findInitializationErrors());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType4 = toProtoResult2.getDefaultInstanceForType();
    assertEquals(oldVotes, defaultInstanceForType4.findInitializationErrors());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals(oldVotes, sourceCodeInfo.findInitializationErrors());
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertEquals(oldVotes, defaultInstanceForType5.findInitializationErrors());
    assertEquals(oldVotes, options.getFeatures().findInitializationErrors());
    assertEquals(oldVotes, toProtoResult.findInitializationErrors());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertEquals(oldVotes, options3.findInitializationErrors());
    assertEquals(oldVotes, getResult2.toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertEquals(oldVotes, getResult3.toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertEquals(oldVotes, getResult4.toProto().findInitializationErrors());
    assertEquals(oldVotes, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType4 = toProtoResult3.getDescriptorForType();
    assertEquals(oldVotes, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals(oldVotes, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals(oldVotes, getResult5.getEnumTypes());
    Descriptors.Descriptor getResult6 = messageTypes.get(43);
    assertEquals(oldVotes, getResult6.getEnumTypes());
    Descriptors.Descriptor getResult7 = messageTypes.get(44);
    assertEquals(oldVotes, getResult7.getEnumTypes());
    assertEquals(oldVotes, descriptorForType4.getExtensions());
    Descriptors.Descriptor descriptorForType6 = options2.getDescriptorForType();
    assertEquals(oldVotes, descriptorForType6.getExtensions());
    assertEquals(oldVotes, descriptorForType5.getExtensions());
    assertEquals(oldVotes, getResult5.getExtensions());
    assertEquals(oldVotes, getResult6.getExtensions());
    assertEquals(oldVotes, getResult7.getExtensions());
    assertEquals(oldVotes, descriptorForType3.getNestedTypes());
    assertEquals(oldVotes, descriptorForType6.getNestedTypes());
    assertEquals(oldVotes, descriptorForType5.getNestedTypes());
    assertEquals(oldVotes, getResult5.getNestedTypes());
    assertEquals(oldVotes, getResult6.getNestedTypes());
    assertEquals(oldVotes, getResult7.getNestedTypes());
    assertEquals(oldVotes, descriptorForType3.getOneofs());
    assertEquals(oldVotes, descriptorForType4.getOneofs());
    assertEquals(oldVotes, descriptorForType6.getOneofs());
    assertEquals(oldVotes, descriptorForType5.getOneofs());
    assertEquals(oldVotes, getResult5.getOneofs());
    assertEquals(oldVotes, getResult6.getOneofs());
    assertEquals(oldVotes, getResult7.getOneofs());
    assertEquals(oldVotes, descriptorForType3.getRealOneofs());
    assertEquals(oldVotes, descriptorForType4.getRealOneofs());
    assertEquals(oldVotes, descriptorForType6.getRealOneofs());
    assertEquals(oldVotes, descriptorForType5.getRealOneofs());
    assertEquals(oldVotes, getResult5.getRealOneofs());
    assertEquals(oldVotes, getResult6.getRealOneofs());
    assertEquals(oldVotes, getResult7.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    assertEquals(oldVotes, file2.getDependencies());
    Descriptors.FileDescriptor getResult8 = dependencies.get(0);
    assertEquals(oldVotes, getResult8.getDependencies());
    Descriptors.FileDescriptor getResult9 = dependencies.get(1);
    assertEquals(oldVotes, getResult9.getDependencies());
    Descriptors.FileDescriptor getResult10 = dependencies.get(2);
    assertEquals(oldVotes, getResult10.getDependencies());
    assertEquals(oldVotes, getResult8.getEnumTypes());
    assertEquals(oldVotes, getResult9.getEnumTypes());
    assertEquals(oldVotes, file2.getExtensions());
    assertEquals(oldVotes, getResult8.getExtensions());
    assertEquals(oldVotes, getResult9.getExtensions());
    assertEquals(oldVotes, getResult10.getExtensions());
    assertEquals(oldVotes, getResult10.getMessageTypes());
    assertEquals(oldVotes, file2.getPublicDependencies());
    assertEquals(oldVotes, getResult8.getPublicDependencies());
    assertEquals(oldVotes, getResult9.getPublicDependencies());
    assertEquals(oldVotes, getResult10.getPublicDependencies());
    assertEquals(oldVotes, file2.getServices());
    assertEquals(oldVotes, getResult8.getServices());
    assertEquals(oldVotes, getResult9.getServices());
    assertEquals(oldVotes, getResult10.getServices());
    assertEquals('\n', data[4]);
    assertSame(defaultInstanceForType3, toProtoResult.getDefaultInstanceForType());
    assertSame(file, descriptorForType.getFile());
    assertSame(descriptorForType, getResult3.getMessageType());
    assertSame(descriptorForType, getResult4.getMessageType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(oldVotes2, defaultInstanceForType3.getEnumTypeList());
    assertSame(oldVotes2, toProtoResult.getEnumTypeList());
    assertSame(oldVotes2, toProtoResult3.getEnumTypeList());
    assertSame(oldVotes2, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(oldVotes2, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(oldVotes2, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(oldVotes2, defaultInstanceForType3.getExtensionList());
    assertSame(oldVotes2, toProtoResult.getExtensionList());
    assertSame(oldVotes2, toProtoResult3.getExtensionList());
    assertSame(oldVotes2, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(oldVotes2, toProtoResult.getExtensionOrBuilderList());
    assertSame(oldVotes2, toProtoResult3.getExtensionOrBuilderList());
    assertSame(oldVotes2, defaultInstanceForType3.getExtensionRangeList());
    assertSame(oldVotes2, toProtoResult.getExtensionRangeList());
    assertSame(oldVotes2, toProtoResult3.getExtensionRangeList());
    assertSame(oldVotes2, defaultInstanceForType3.getExtensionRangeOrBuilderList());
    assertSame(oldVotes2, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(oldVotes2, toProtoResult3.getExtensionRangeOrBuilderList());
    assertSame(oldVotes2, defaultInstanceForType3.getFieldList());
    assertSame(oldVotes2, defaultInstanceForType3.getFieldOrBuilderList());
    assertSame(oldVotes2, defaultInstanceForType3.getNestedTypeList());
    assertSame(oldVotes2, toProtoResult.getNestedTypeList());
    assertSame(oldVotes2, toProtoResult3.getNestedTypeList());
    assertSame(oldVotes2, defaultInstanceForType3.getNestedTypeOrBuilderList());
    assertSame(oldVotes2, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(oldVotes2, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(oldVotes2, defaultInstanceForType3.getOneofDeclList());
    assertSame(oldVotes2, toProtoResult.getOneofDeclList());
    assertSame(oldVotes2, toProtoResult3.getOneofDeclList());
    assertSame(oldVotes2, defaultInstanceForType3.getOneofDeclOrBuilderList());
    assertSame(oldVotes2, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(oldVotes2, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(oldVotes2, defaultInstanceForType3.getReservedRangeList());
    assertSame(oldVotes2, toProtoResult.getReservedRangeList());
    assertSame(oldVotes2, toProtoResult3.getReservedRangeList());
    assertSame(oldVotes2, defaultInstanceForType3.getReservedRangeOrBuilderList());
    assertSame(oldVotes2, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(oldVotes2, toProtoResult3.getReservedRangeOrBuilderList());
    assertSame(oldVotes2, options3.getEditionDefaultsList());
    assertSame(oldVotes2, options3.getEditionDefaultsOrBuilderList());
    assertSame(oldVotes2, options3.getUninterpretedOptionList());
    assertSame(oldVotes2, options3.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes2, defaultInstanceForType4.getEnumTypeList());
    assertSame(oldVotes2, defaultInstanceForType4.getEnumTypeOrBuilderList());
    assertSame(oldVotes2, defaultInstanceForType4.getExtensionList());
    assertSame(oldVotes2, toProtoResult2.getExtensionList());
    assertSame(oldVotes2, defaultInstanceForType4.getExtensionOrBuilderList());
    assertSame(oldVotes2, toProtoResult2.getExtensionOrBuilderList());
    assertSame(oldVotes2, defaultInstanceForType4.getMessageTypeList());
    assertSame(oldVotes2, defaultInstanceForType4.getMessageTypeOrBuilderList());
    assertSame(oldVotes2, defaultInstanceForType4.getServiceList());
    assertSame(oldVotes2, toProtoResult2.getServiceList());
    assertSame(oldVotes2, defaultInstanceForType4.getServiceOrBuilderList());
    assertSame(oldVotes2, toProtoResult2.getServiceOrBuilderList());
    assertSame(oldVotes2, defaultInstanceForType5.getUninterpretedOptionList());
    assertSame(oldVotes2, options2.getUninterpretedOptionList());
    assertSame(oldVotes2, defaultInstanceForType5.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes2, options2.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes2, options.getUninterpretedOptionList());
    assertSame(oldVotes2, options.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes2, sourceCodeInfo.getLocationList());
    assertSame(oldVotes2, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(oldVotes2, defaultInstanceForType2.getNewVotesList());
    assertSame(oldVotes2, defaultInstanceForType2.getNewVotesOrBuilderList());
    assertSame(oldVotes2, defaultInstanceForType2.getOldVotesList());
    assertSame(oldVotes2, defaultInstanceForType2.getOldVotesOrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    ByteString expectedVoteAddress = voteAddress.EMPTY;
    assertSame(expectedVoteAddress, defaultInstanceForType.getVoteAddress());
    assertSame(voteAddress, getResult.getVoteAddress());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
  }

  /**
   * Method under test: {@link VotesCapsule#addNewVotes(ByteString, long)}
   */
  @Test
  public void testAddNewVotes3() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    VotesCapsule votesCapsule = new VotesCapsule(votes);
    ArrayList<Protocol.Vote> votesToAdd = new ArrayList<>();
    votesCapsule.addAllNewVotes(votesToAdd);
    ByteString voteAddress = mock(ByteString.class);

    // Act
    votesCapsule.addNewVotes(voteAddress, 3L);

    // Assert
    List<Protocol.Vote> newVotes = votesCapsule.getNewVotes();
    assertEquals(1, newVotes.size());
    Protocol.Vote getResult = newVotes.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Vote defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals("Vote", toProtoResult.getName());
    assertEquals("Vote", descriptorForType.getName());
    assertEquals("protocol.Vote", descriptorForType.getFullName());
    assertNull(descriptorForType.getContainingType());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getVoteCount());
    assertEquals(1, descriptorForType.getIndex());
    Protocol.Votes instance = votesCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getNewVotesCount());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, getResult.getAllFields().size());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(3, fields.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    assertEquals(3L, getResult.getVoteCount());
    assertEquals(4, getResult.getSerializedSize());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertEquals(45, toProtoResult2.getMessageTypeList().size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    assertEquals(48, toProtoResult.getSerializedSize());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    ProtocolStringList reservedNameList = toProtoResult3.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Protocol.Vote> oldVotes = votesCapsule.getOldVotes();
    assertTrue(oldVotes.isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertEquals(votesToAdd, defaultInstanceForType2.findInitializationErrors());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertEquals(votesToAdd, defaultInstanceForType3.findInitializationErrors());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals(votesToAdd, sourceCodeInfo.findInitializationErrors());
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertEquals(votesToAdd, defaultInstanceForType4.findInitializationErrors());
    assertEquals(votesToAdd, options.getFeatures().findInitializationErrors());
    assertEquals(votesToAdd, toProtoResult.findInitializationErrors());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertEquals(votesToAdd, options3.findInitializationErrors());
    assertEquals(votesToAdd, getResult2.toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertEquals(votesToAdd, getResult3.toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertEquals(votesToAdd, getResult4.toProto().findInitializationErrors());
    assertEquals(votesToAdd, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType4 = toProtoResult3.getDescriptorForType();
    assertEquals(votesToAdd, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals(votesToAdd, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals(votesToAdd, getResult5.getEnumTypes());
    Descriptors.Descriptor getResult6 = messageTypes.get(43);
    assertEquals(votesToAdd, getResult6.getEnumTypes());
    Descriptors.Descriptor getResult7 = messageTypes.get(44);
    assertEquals(votesToAdd, getResult7.getEnumTypes());
    assertEquals(votesToAdd, descriptorForType4.getExtensions());
    Descriptors.Descriptor descriptorForType6 = options2.getDescriptorForType();
    assertEquals(votesToAdd, descriptorForType6.getExtensions());
    assertEquals(votesToAdd, descriptorForType5.getExtensions());
    assertEquals(votesToAdd, getResult5.getExtensions());
    assertEquals(votesToAdd, getResult6.getExtensions());
    assertEquals(votesToAdd, getResult7.getExtensions());
    assertEquals(votesToAdd, descriptorForType3.getNestedTypes());
    assertEquals(votesToAdd, descriptorForType6.getNestedTypes());
    assertEquals(votesToAdd, descriptorForType5.getNestedTypes());
    assertEquals(votesToAdd, getResult5.getNestedTypes());
    assertEquals(votesToAdd, getResult6.getNestedTypes());
    assertEquals(votesToAdd, getResult7.getNestedTypes());
    assertEquals(votesToAdd, descriptorForType3.getOneofs());
    assertEquals(votesToAdd, descriptorForType4.getOneofs());
    assertEquals(votesToAdd, descriptorForType6.getOneofs());
    assertEquals(votesToAdd, descriptorForType5.getOneofs());
    assertEquals(votesToAdd, getResult5.getOneofs());
    assertEquals(votesToAdd, getResult6.getOneofs());
    assertEquals(votesToAdd, getResult7.getOneofs());
    assertEquals(votesToAdd, descriptorForType3.getRealOneofs());
    assertEquals(votesToAdd, descriptorForType4.getRealOneofs());
    assertEquals(votesToAdd, descriptorForType6.getRealOneofs());
    assertEquals(votesToAdd, descriptorForType5.getRealOneofs());
    assertEquals(votesToAdd, getResult5.getRealOneofs());
    assertEquals(votesToAdd, getResult6.getRealOneofs());
    assertEquals(votesToAdd, getResult7.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    assertEquals(votesToAdd, file2.getDependencies());
    Descriptors.FileDescriptor getResult8 = dependencies.get(0);
    assertEquals(votesToAdd, getResult8.getDependencies());
    Descriptors.FileDescriptor getResult9 = dependencies.get(1);
    assertEquals(votesToAdd, getResult9.getDependencies());
    Descriptors.FileDescriptor getResult10 = dependencies.get(2);
    assertEquals(votesToAdd, getResult10.getDependencies());
    assertEquals(votesToAdd, getResult8.getEnumTypes());
    assertEquals(votesToAdd, getResult9.getEnumTypes());
    assertEquals(votesToAdd, file2.getExtensions());
    assertEquals(votesToAdd, getResult8.getExtensions());
    assertEquals(votesToAdd, getResult9.getExtensions());
    assertEquals(votesToAdd, getResult10.getExtensions());
    assertEquals(votesToAdd, getResult10.getMessageTypes());
    assertEquals(votesToAdd, file2.getPublicDependencies());
    assertEquals(votesToAdd, getResult8.getPublicDependencies());
    assertEquals(votesToAdd, getResult9.getPublicDependencies());
    assertEquals(votesToAdd, getResult10.getPublicDependencies());
    assertEquals(votesToAdd, file2.getServices());
    assertEquals(votesToAdd, getResult8.getServices());
    assertEquals(votesToAdd, getResult9.getServices());
    assertEquals(votesToAdd, getResult10.getServices());
    assertSame(defaultInstanceForType2, toProtoResult.getDefaultInstanceForType());
    assertSame(file, descriptorForType.getFile());
    assertSame(descriptorForType, getResult3.getMessageType());
    assertSame(descriptorForType, getResult4.getMessageType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(oldVotes, defaultInstanceForType2.getEnumTypeList());
    assertSame(oldVotes, toProtoResult.getEnumTypeList());
    assertSame(oldVotes, toProtoResult3.getEnumTypeList());
    assertSame(oldVotes, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionList());
    assertSame(oldVotes, toProtoResult.getExtensionList());
    assertSame(oldVotes, toProtoResult3.getExtensionList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getExtensionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionRangeList());
    assertSame(oldVotes, toProtoResult.getExtensionRangeList());
    assertSame(oldVotes, toProtoResult3.getExtensionRangeList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getFieldList());
    assertSame(oldVotes, defaultInstanceForType2.getFieldOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getNestedTypeList());
    assertSame(oldVotes, toProtoResult.getNestedTypeList());
    assertSame(oldVotes, toProtoResult3.getNestedTypeList());
    assertSame(oldVotes, defaultInstanceForType2.getNestedTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getOneofDeclList());
    assertSame(oldVotes, toProtoResult.getOneofDeclList());
    assertSame(oldVotes, toProtoResult3.getOneofDeclList());
    assertSame(oldVotes, defaultInstanceForType2.getOneofDeclOrBuilderList());
    assertSame(oldVotes, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getReservedRangeList());
    assertSame(oldVotes, toProtoResult.getReservedRangeList());
    assertSame(oldVotes, toProtoResult3.getReservedRangeList());
    assertSame(oldVotes, defaultInstanceForType2.getReservedRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getReservedRangeOrBuilderList());
    assertSame(oldVotes, options3.getEditionDefaultsList());
    assertSame(oldVotes, options3.getEditionDefaultsOrBuilderList());
    assertSame(oldVotes, options3.getUninterpretedOptionList());
    assertSame(oldVotes, options3.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType3.getEnumTypeList());
    assertSame(oldVotes, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType3.getExtensionList());
    assertSame(oldVotes, toProtoResult2.getExtensionList());
    assertSame(oldVotes, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getExtensionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType3.getMessageTypeList());
    assertSame(oldVotes, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType3.getServiceList());
    assertSame(oldVotes, toProtoResult2.getServiceList());
    assertSame(oldVotes, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getServiceOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(oldVotes, options2.getUninterpretedOptionList());
    assertSame(oldVotes, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, options2.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, options.getUninterpretedOptionList());
    assertSame(oldVotes, options.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, sourceCodeInfo.getLocationList());
    assertSame(oldVotes, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(votes, instance.getDefaultInstanceForType());
    ByteString expectedVoteAddress = voteAddress.EMPTY;
    assertSame(expectedVoteAddress, defaultInstanceForType.getVoteAddress());
    assertSame(voteAddress, getResult.getVoteAddress());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    assertArrayEquals(new byte[]{26, 4, '\n', 0, 16, 3}, votesCapsule.getData());
  }

  /**
   * Method under test: {@link VotesCapsule#addNewVotes(ByteString, long)}
   */
  @Test
  public void testAddNewVotes4() {
    // Arrange
    ArrayList<Protocol.Vote> oldVotes = new ArrayList<>();
    Protocol.Vote defaultInstance = Protocol.Vote.getDefaultInstance();
    oldVotes.add(defaultInstance);
    VotesCapsule votesCapsule = new VotesCapsule(mock(ByteString.class), oldVotes);
    ByteString voteAddress = mock(ByteString.class);

    // Act
    votesCapsule.addNewVotes(voteAddress, 3L);

    // Assert
    List<Protocol.Vote> newVotes = votesCapsule.getNewVotes();
    assertEquals(1, newVotes.size());
    Protocol.Vote getResult = newVotes.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("Vote", toProtoResult.getName());
    assertEquals("Vote", descriptorForType.getName());
    assertEquals("protocol.Vote", descriptorForType.getFullName());
    assertNull(descriptorForType.getContainingType());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    byte[] data = votesCapsule.getData();
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 0, data[7]);
    assertEquals(1, descriptorForType.getIndex());
    Protocol.Votes instance = votesCapsule.getInstance();
    assertEquals(1, instance.getNewVotesCount());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(10, data.length);
    assertEquals((byte) 16, data[8]);
    assertEquals((byte) 18, data[2]);
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals((byte) 26, data[4]);
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(3, fields.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(3L, getResult.getVoteCount());
    assertEquals((byte) 3, data[9]);
    assertEquals(4, getResult.getSerializedSize());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertEquals(45, toProtoResult2.getMessageTypeList().size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    assertEquals(48, toProtoResult.getSerializedSize());
    assertEquals((byte) 4, data[5]);
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    Protocol.Votes defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    ProtocolStringList reservedNameList = toProtoResult3.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Protocol.Vote> newVotesList = defaultInstanceForType.getNewVotesList();
    assertTrue(newVotesList.isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(oldVotes, votesCapsule.getOldVotes());
    assertEquals('\n', data[6]);
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, toProtoResult.getDefaultInstanceForType());
    assertSame(file, descriptorForType.getFile());
    assertSame(descriptorForType, fields.get(1).getMessageType());
    assertSame(descriptorForType, fields.get(2).getMessageType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(newVotesList, defaultInstanceForType2.getEnumTypeList());
    assertSame(newVotesList, toProtoResult.getEnumTypeList());
    assertSame(newVotesList, toProtoResult3.getEnumTypeList());
    assertSame(newVotesList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(newVotesList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(newVotesList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType2.getExtensionList());
    assertSame(newVotesList, toProtoResult.getExtensionList());
    assertSame(newVotesList, toProtoResult3.getExtensionList());
    assertSame(newVotesList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(newVotesList, toProtoResult.getExtensionOrBuilderList());
    assertSame(newVotesList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType2.getExtensionRangeList());
    assertSame(newVotesList, toProtoResult.getExtensionRangeList());
    assertSame(newVotesList, toProtoResult3.getExtensionRangeList());
    assertSame(newVotesList, defaultInstanceForType2.getExtensionRangeOrBuilderList());
    assertSame(newVotesList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(newVotesList, toProtoResult3.getExtensionRangeOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType2.getFieldList());
    assertSame(newVotesList, defaultInstanceForType2.getFieldOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType2.getNestedTypeList());
    assertSame(newVotesList, toProtoResult.getNestedTypeList());
    assertSame(newVotesList, toProtoResult3.getNestedTypeList());
    assertSame(newVotesList, defaultInstanceForType2.getNestedTypeOrBuilderList());
    assertSame(newVotesList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(newVotesList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType2.getOneofDeclList());
    assertSame(newVotesList, toProtoResult.getOneofDeclList());
    assertSame(newVotesList, toProtoResult3.getOneofDeclList());
    assertSame(newVotesList, defaultInstanceForType2.getOneofDeclOrBuilderList());
    assertSame(newVotesList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(newVotesList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType2.getReservedRangeList());
    assertSame(newVotesList, toProtoResult.getReservedRangeList());
    assertSame(newVotesList, toProtoResult3.getReservedRangeList());
    assertSame(newVotesList, defaultInstanceForType2.getReservedRangeOrBuilderList());
    assertSame(newVotesList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(newVotesList, toProtoResult3.getReservedRangeOrBuilderList());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertSame(newVotesList, options3.getEditionDefaultsList());
    assertSame(newVotesList, options3.getEditionDefaultsOrBuilderList());
    assertSame(newVotesList, options3.getUninterpretedOptionList());
    assertSame(newVotesList, options3.getUninterpretedOptionOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(newVotesList, defaultInstanceForType3.getEnumTypeList());
    assertSame(newVotesList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType3.getExtensionList());
    assertSame(newVotesList, toProtoResult2.getExtensionList());
    assertSame(newVotesList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(newVotesList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType3.getMessageTypeList());
    assertSame(newVotesList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType3.getServiceList());
    assertSame(newVotesList, toProtoResult2.getServiceList());
    assertSame(newVotesList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(newVotesList, toProtoResult2.getServiceOrBuilderList());
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertSame(newVotesList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(newVotesList, options2.getUninterpretedOptionList());
    assertSame(newVotesList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(newVotesList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(newVotesList, options.getUninterpretedOptionList());
    assertSame(newVotesList, options.getUninterpretedOptionOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(newVotesList, sourceCodeInfo.getLocationList());
    assertSame(newVotesList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType.getNewVotesOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType.getOldVotesList());
    assertSame(newVotesList, defaultInstanceForType.getOldVotesOrBuilderList());
    assertSame(defaultInstance, getResult.getDefaultInstanceForType());
    assertSame(voteAddress, getResult.getVoteAddress());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
  }

  /**
   * Method under test: {@link VotesCapsule#addNewVotes(ByteString, long)}
   */
  @Test
  public void testAddNewVotes5() {
    // Arrange
    ArrayList<Protocol.Vote> votesToAdd = new ArrayList<>();
    Protocol.Vote defaultInstance = Protocol.Vote.getDefaultInstance();
    votesToAdd.add(defaultInstance);
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    VotesCapsule votesCapsule = new VotesCapsule(votes);
    votesCapsule.addAllNewVotes(votesToAdd);
    ByteString voteAddress = mock(ByteString.class);

    // Act
    votesCapsule.addNewVotes(voteAddress, 3L);

    // Assert
    List<Protocol.Vote> newVotes = votesCapsule.getNewVotes();
    assertEquals(2, newVotes.size());
    Protocol.Vote getResult = newVotes.get(1);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Votes instance = votesCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(2, instance.getNewVotesCount());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    assertEquals(3L, getResult.getVoteCount());
    assertEquals(4, getResult.getSerializedSize());
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(45, toProtoResult.getMessageTypeList().size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.getReservedNameList().isEmpty());
    assertTrue(toProtoResult.getPublicDependencyList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Protocol.Vote> oldVotes = votesCapsule.getOldVotes();
    assertTrue(oldVotes.isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(getResult.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertEquals(oldVotes, defaultInstanceForType.findInitializationErrors());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertEquals(oldVotes, defaultInstanceForType2.findInitializationErrors());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertEquals(oldVotes, sourceCodeInfo.findInitializationErrors());
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertEquals(oldVotes, defaultInstanceForType3.findInitializationErrors());
    assertEquals(oldVotes, options.getFeatures().findInitializationErrors());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertEquals(oldVotes, options3.findInitializationErrors());
    assertEquals(oldVotes, getResult2.toProto().findInitializationErrors());
    assertEquals(oldVotes, fields.get(1).toProto().findInitializationErrors());
    assertEquals(oldVotes, fields.get(2).toProto().findInitializationErrors());
    assertEquals(oldVotes, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType3 = toProtoResult2.getDescriptorForType();
    assertEquals(oldVotes, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = toProtoResult.getDescriptorForType();
    assertEquals(oldVotes, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertEquals(oldVotes, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes.get(43);
    assertEquals(oldVotes, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(44);
    assertEquals(oldVotes, getResult5.getEnumTypes());
    assertEquals(oldVotes, descriptorForType3.getExtensions());
    Descriptors.Descriptor descriptorForType5 = options2.getDescriptorForType();
    assertEquals(oldVotes, descriptorForType5.getExtensions());
    assertEquals(oldVotes, descriptorForType4.getExtensions());
    assertEquals(oldVotes, getResult3.getExtensions());
    assertEquals(oldVotes, getResult4.getExtensions());
    assertEquals(oldVotes, getResult5.getExtensions());
    assertEquals(oldVotes, descriptorForType2.getNestedTypes());
    assertEquals(oldVotes, descriptorForType5.getNestedTypes());
    assertEquals(oldVotes, descriptorForType4.getNestedTypes());
    assertEquals(oldVotes, getResult3.getNestedTypes());
    assertEquals(oldVotes, getResult4.getNestedTypes());
    assertEquals(oldVotes, getResult5.getNestedTypes());
    assertEquals(oldVotes, descriptorForType2.getOneofs());
    assertEquals(oldVotes, descriptorForType3.getOneofs());
    assertEquals(oldVotes, descriptorForType5.getOneofs());
    assertEquals(oldVotes, descriptorForType4.getOneofs());
    assertEquals(oldVotes, getResult3.getOneofs());
    assertEquals(oldVotes, getResult4.getOneofs());
    assertEquals(oldVotes, getResult5.getOneofs());
    assertEquals(oldVotes, descriptorForType2.getRealOneofs());
    assertEquals(oldVotes, descriptorForType3.getRealOneofs());
    assertEquals(oldVotes, descriptorForType5.getRealOneofs());
    assertEquals(oldVotes, descriptorForType4.getRealOneofs());
    assertEquals(oldVotes, getResult3.getRealOneofs());
    assertEquals(oldVotes, getResult4.getRealOneofs());
    assertEquals(oldVotes, getResult5.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(oldVotes, file2.getDependencies());
    Descriptors.FileDescriptor getResult6 = dependencies.get(0);
    assertEquals(oldVotes, getResult6.getDependencies());
    Descriptors.FileDescriptor getResult7 = dependencies.get(1);
    assertEquals(oldVotes, getResult7.getDependencies());
    Descriptors.FileDescriptor getResult8 = dependencies.get(2);
    assertEquals(oldVotes, getResult8.getDependencies());
    assertEquals(oldVotes, getResult6.getEnumTypes());
    assertEquals(oldVotes, getResult7.getEnumTypes());
    assertEquals(oldVotes, file2.getExtensions());
    assertEquals(oldVotes, getResult6.getExtensions());
    assertEquals(oldVotes, getResult7.getExtensions());
    assertEquals(oldVotes, getResult8.getExtensions());
    assertEquals(oldVotes, getResult8.getMessageTypes());
    assertEquals(oldVotes, file2.getPublicDependencies());
    assertEquals(oldVotes, getResult6.getPublicDependencies());
    assertEquals(oldVotes, getResult7.getPublicDependencies());
    assertEquals(oldVotes, getResult8.getPublicDependencies());
    assertEquals(oldVotes, file2.getServices());
    assertEquals(oldVotes, getResult6.getServices());
    assertEquals(oldVotes, getResult7.getServices());
    assertEquals(oldVotes, getResult8.getServices());
    assertSame(oldVotes, defaultInstanceForType.getEnumTypeList());
    assertSame(oldVotes, toProtoResult2.getEnumTypeList());
    assertSame(oldVotes, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionList());
    assertSame(oldVotes, toProtoResult2.getExtensionList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getExtensionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionRangeList());
    assertSame(oldVotes, toProtoResult2.getExtensionRangeList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getFieldList());
    assertSame(oldVotes, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getNestedTypeList());
    assertSame(oldVotes, toProtoResult2.getNestedTypeList());
    assertSame(oldVotes, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getNestedTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getOneofDeclList());
    assertSame(oldVotes, toProtoResult2.getOneofDeclList());
    assertSame(oldVotes, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getOneofDeclOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getReservedRangeList());
    assertSame(oldVotes, toProtoResult2.getReservedRangeList());
    assertSame(oldVotes, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getReservedRangeOrBuilderList());
    assertSame(oldVotes, options3.getEditionDefaultsList());
    assertSame(oldVotes, options3.getEditionDefaultsOrBuilderList());
    assertSame(oldVotes, options3.getUninterpretedOptionList());
    assertSame(oldVotes, options3.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getEnumTypeList());
    assertSame(oldVotes, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionList());
    assertSame(oldVotes, toProtoResult.getExtensionList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult.getExtensionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getMessageTypeList());
    assertSame(oldVotes, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getServiceList());
    assertSame(oldVotes, toProtoResult.getServiceList());
    assertSame(oldVotes, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(oldVotes, toProtoResult.getServiceOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(oldVotes, options2.getUninterpretedOptionList());
    assertSame(oldVotes, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, options2.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, options.getUninterpretedOptionList());
    assertSame(oldVotes, options.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, sourceCodeInfo.getLocationList());
    assertSame(oldVotes, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
    assertSame(defaultInstance, newVotes.get(0));
    assertSame(defaultInstance, getResult.getDefaultInstanceForType());
    assertSame(votes, instance.getDefaultInstanceForType());
    assertSame(voteAddress, getResult.getVoteAddress());
    assertArrayEquals(new byte[]{26, 0, 26, 4, '\n', 0, 16, 3}, votesCapsule.getData());
  }

  /**
   * Method under test: {@link VotesCapsule#addAllNewVotes(List)}
   */
  @Test
  public void testAddAllNewVotes() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();
    VotesCapsule votesCapsule = new VotesCapsule(votes);

    // Act
    votesCapsule.addAllNewVotes(new ArrayList<>());

    // Assert
    assertTrue(votesCapsule.getOldVotes().isEmpty());
    assertEquals(votes, votesCapsule.getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#addAllNewVotes(List)}
   */
  @Test
  public void testAddAllNewVotes2() {
    // Arrange
    ByteString address = mock(ByteString.class);
    VotesCapsule votesCapsule = new VotesCapsule(address, new ArrayList<>());

    // Act
    votesCapsule.addAllNewVotes(new ArrayList<>());

    // Assert
    Protocol.Votes instance = votesCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    List<Protocol.Vote> oldVotes = votesCapsule.getOldVotes();
    assertTrue(oldVotes.isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType.getEnumTypeList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult2 = options.getDescriptorForType().toProto();
    assertSame(oldVotes, toProtoResult2.getEnumTypeList());
    assertSame(oldVotes, toProtoResult.getEnumTypeList());
    assertSame(oldVotes, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionList());
    assertSame(oldVotes, toProtoResult2.getExtensionList());
    assertSame(oldVotes, toProtoResult.getExtensionList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult.getExtensionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionRangeList());
    assertSame(oldVotes, toProtoResult.getExtensionRangeList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getFieldList());
    assertSame(oldVotes, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getNestedTypeList());
    assertSame(oldVotes, toProtoResult2.getNestedTypeList());
    assertSame(oldVotes, toProtoResult.getNestedTypeList());
    assertSame(oldVotes, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getNestedTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getOneofDeclList());
    assertSame(oldVotes, toProtoResult2.getOneofDeclList());
    assertSame(oldVotes, toProtoResult.getOneofDeclList());
    assertSame(oldVotes, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getOneofDeclOrBuilderList());
    assertSame(oldVotes, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getReservedRangeList());
    assertSame(oldVotes, toProtoResult.getReservedRangeList());
    assertSame(oldVotes, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getReservedRangeOrBuilderList());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertSame(oldVotes, options2.getEditionDefaultsList());
    assertSame(oldVotes, options2.getEditionDefaultsOrBuilderList());
    assertSame(oldVotes, options2.getUninterpretedOptionList());
    assertSame(oldVotes, options2.getUninterpretedOptionOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType2.getEnumTypeList());
    assertSame(oldVotes, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionList());
    assertSame(oldVotes, toProtoResult3.getExtensionList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getExtensionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getMessageTypeList());
    assertSame(oldVotes, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getServiceList());
    assertSame(oldVotes, toProtoResult3.getServiceList());
    assertSame(oldVotes, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getServiceOrBuilderList());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options3.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(oldVotes, options3.getUninterpretedOptionList());
    assertSame(oldVotes, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, options3.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, options.getUninterpretedOptionList());
    assertSame(oldVotes, options.getUninterpretedOptionOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(oldVotes, sourceCodeInfo.getLocationList());
    assertSame(oldVotes, sourceCodeInfo.getLocationOrBuilderList());
    Protocol.Votes defaultInstanceForType4 = instance.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType4.getNewVotesList());
    assertSame(oldVotes, defaultInstanceForType4.getNewVotesOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType4.getOldVotesList());
    assertSame(oldVotes, defaultInstanceForType4.getOldVotesOrBuilderList());
  }

  /**
   * Method under test: {@link VotesCapsule#addAllNewVotes(List)}
   */
  @Test
  public void testAddAllNewVotes3() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    VotesCapsule votesCapsule = new VotesCapsule(votes);
    votesCapsule.addAllNewVotes(new ArrayList<>());

    // Act
    votesCapsule.addAllNewVotes(new ArrayList<>());

    // Assert
    assertTrue(votesCapsule.getOldVotes().isEmpty());
    assertEquals(votes, votesCapsule.getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#addAllNewVotes(List)}
   */
  @Test
  public void testAddAllNewVotes4() {
    // Arrange
    ArrayList<Protocol.Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Protocol.Vote.getDefaultInstance());
    VotesCapsule votesCapsule = new VotesCapsule(mock(ByteString.class), oldVotes);

    // Act
    votesCapsule.addAllNewVotes(new ArrayList<>());

    // Assert
    Protocol.Votes instance = votesCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    Protocol.Votes defaultInstanceForType = instance.getDefaultInstanceForType();
    List<Protocol.Vote> newVotesList = defaultInstanceForType.getNewVotesList();
    assertTrue(newVotesList.isEmpty());
    assertEquals(oldVotes, votesCapsule.getOldVotes());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(newVotesList, defaultInstanceForType2.getEnumTypeList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult2 = options.getDescriptorForType().toProto();
    assertSame(newVotesList, toProtoResult2.getEnumTypeList());
    assertSame(newVotesList, toProtoResult.getEnumTypeList());
    assertSame(newVotesList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(newVotesList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(newVotesList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType2.getExtensionList());
    assertSame(newVotesList, toProtoResult.getExtensionList());
    assertSame(newVotesList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(newVotesList, toProtoResult.getExtensionOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType2.getExtensionRangeList());
    assertSame(newVotesList, toProtoResult.getExtensionRangeList());
    assertSame(newVotesList, defaultInstanceForType2.getExtensionRangeOrBuilderList());
    assertSame(newVotesList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType2.getFieldList());
    assertSame(newVotesList, defaultInstanceForType2.getFieldOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType2.getNestedTypeList());
    assertSame(newVotesList, toProtoResult.getNestedTypeList());
    assertSame(newVotesList, defaultInstanceForType2.getNestedTypeOrBuilderList());
    assertSame(newVotesList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType2.getOneofDeclList());
    assertSame(newVotesList, toProtoResult.getOneofDeclList());
    assertSame(newVotesList, defaultInstanceForType2.getOneofDeclOrBuilderList());
    assertSame(newVotesList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType2.getReservedRangeList());
    assertSame(newVotesList, toProtoResult.getReservedRangeList());
    assertSame(newVotesList, defaultInstanceForType2.getReservedRangeOrBuilderList());
    assertSame(newVotesList, toProtoResult.getReservedRangeOrBuilderList());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertSame(newVotesList, options2.getEditionDefaultsList());
    assertSame(newVotesList, options2.getEditionDefaultsOrBuilderList());
    assertSame(newVotesList, options2.getUninterpretedOptionList());
    assertSame(newVotesList, options2.getUninterpretedOptionOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertSame(newVotesList, defaultInstanceForType3.getEnumTypeList());
    assertSame(newVotesList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType3.getExtensionList());
    assertSame(newVotesList, toProtoResult3.getExtensionList());
    assertSame(newVotesList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(newVotesList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType3.getMessageTypeList());
    assertSame(newVotesList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType3.getServiceList());
    assertSame(newVotesList, toProtoResult3.getServiceList());
    assertSame(newVotesList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(newVotesList, toProtoResult3.getServiceOrBuilderList());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options3.getDefaultInstanceForType();
    assertSame(newVotesList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(newVotesList, options3.getUninterpretedOptionList());
    assertSame(newVotesList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(newVotesList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(newVotesList, options.getUninterpretedOptionList());
    assertSame(newVotesList, options.getUninterpretedOptionOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(newVotesList, sourceCodeInfo.getLocationList());
    assertSame(newVotesList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType.getNewVotesOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType.getOldVotesList());
    assertSame(newVotesList, defaultInstanceForType.getOldVotesOrBuilderList());
  }

  /**
   * Method under test: {@link VotesCapsule#addAllNewVotes(List)}
   */
  @Test
  public void testAddAllNewVotes5() {
    // Arrange
    ArrayList<Protocol.Vote> votesToAdd = new ArrayList<>();
    votesToAdd.add(Protocol.Vote.getDefaultInstance());
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    VotesCapsule votesCapsule = new VotesCapsule(votes);
    votesCapsule.addAllNewVotes(votesToAdd);

    // Act
    votesCapsule.addAllNewVotes(new ArrayList<>());

    // Assert
    Protocol.Votes instance = votesCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    List<Protocol.Vote> oldVotes = votesCapsule.getOldVotes();
    assertTrue(oldVotes.isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType.getEnumTypeList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult2 = options.getDescriptorForType().toProto();
    assertSame(oldVotes, toProtoResult2.getEnumTypeList());
    assertSame(oldVotes, toProtoResult.getEnumTypeList());
    assertSame(oldVotes, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionList());
    assertSame(oldVotes, toProtoResult.getExtensionList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult.getExtensionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionRangeList());
    assertSame(oldVotes, toProtoResult.getExtensionRangeList());
    assertSame(oldVotes, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getFieldList());
    assertSame(oldVotes, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getNestedTypeList());
    assertSame(oldVotes, toProtoResult.getNestedTypeList());
    assertSame(oldVotes, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getOneofDeclList());
    assertSame(oldVotes, toProtoResult.getOneofDeclList());
    assertSame(oldVotes, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(oldVotes, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getReservedRangeList());
    assertSame(oldVotes, toProtoResult.getReservedRangeList());
    assertSame(oldVotes, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(oldVotes, toProtoResult.getReservedRangeOrBuilderList());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertSame(oldVotes, options2.getEditionDefaultsList());
    assertSame(oldVotes, options2.getEditionDefaultsOrBuilderList());
    assertSame(oldVotes, options2.getUninterpretedOptionList());
    assertSame(oldVotes, options2.getUninterpretedOptionOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType2.getEnumTypeList());
    assertSame(oldVotes, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionList());
    assertSame(oldVotes, toProtoResult3.getExtensionList());
    assertSame(oldVotes, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getExtensionOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getMessageTypeList());
    assertSame(oldVotes, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType2.getServiceList());
    assertSame(oldVotes, toProtoResult3.getServiceList());
    assertSame(oldVotes, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(oldVotes, toProtoResult3.getServiceOrBuilderList());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options3.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(oldVotes, options3.getUninterpretedOptionList());
    assertSame(oldVotes, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, options3.getUninterpretedOptionOrBuilderList());
    assertSame(oldVotes, options.getUninterpretedOptionList());
    assertSame(oldVotes, options.getUninterpretedOptionOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(oldVotes, sourceCodeInfo.getLocationList());
    assertSame(oldVotes, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
    assertSame(votes, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link VotesCapsule#addOldVotes(ByteString, long)}
   */
  @Test
  public void testAddOldVotes() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();
    VotesCapsule votesCapsule = new VotesCapsule(votes);
    ByteString voteAddress = mock(ByteString.class);

    // Act
    votesCapsule.addOldVotes(voteAddress, 3L);

    // Assert
    List<Protocol.Vote> oldVotes = votesCapsule.getOldVotes();
    assertEquals(1, oldVotes.size());
    Protocol.Vote getResult = oldVotes.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Vote defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals("Vote", toProtoResult.getName());
    assertEquals("Vote", descriptorForType.getName());
    assertEquals("protocol.Vote", descriptorForType.getFullName());
    assertNull(descriptorForType.getContainingType());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getVoteCount());
    assertEquals(1, descriptorForType.getIndex());
    Protocol.Votes instance = votesCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getOldVotesCount());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, getResult.getAllFields().size());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(3, fields.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    assertEquals(3L, getResult.getVoteCount());
    assertEquals(4, getResult.getSerializedSize());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertEquals(45, toProtoResult2.getMessageTypeList().size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    assertEquals(48, toProtoResult.getSerializedSize());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    ProtocolStringList reservedNameList = toProtoResult3.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Protocol.Vote> newVotes = votesCapsule.getNewVotes();
    assertTrue(newVotes.isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertEquals(newVotes, defaultInstanceForType2.findInitializationErrors());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertEquals(newVotes, defaultInstanceForType3.findInitializationErrors());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals(newVotes, sourceCodeInfo.findInitializationErrors());
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertEquals(newVotes, defaultInstanceForType4.findInitializationErrors());
    assertEquals(newVotes, options.getFeatures().findInitializationErrors());
    assertEquals(newVotes, toProtoResult.findInitializationErrors());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertEquals(newVotes, options3.findInitializationErrors());
    assertEquals(newVotes, getResult2.toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertEquals(newVotes, getResult3.toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertEquals(newVotes, getResult4.toProto().findInitializationErrors());
    assertEquals(newVotes, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType4 = toProtoResult3.getDescriptorForType();
    assertEquals(newVotes, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals(newVotes, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals(newVotes, getResult5.getEnumTypes());
    Descriptors.Descriptor getResult6 = messageTypes.get(43);
    assertEquals(newVotes, getResult6.getEnumTypes());
    Descriptors.Descriptor getResult7 = messageTypes.get(44);
    assertEquals(newVotes, getResult7.getEnumTypes());
    assertEquals(newVotes, descriptorForType4.getExtensions());
    Descriptors.Descriptor descriptorForType6 = options2.getDescriptorForType();
    assertEquals(newVotes, descriptorForType6.getExtensions());
    assertEquals(newVotes, descriptorForType5.getExtensions());
    assertEquals(newVotes, getResult5.getExtensions());
    assertEquals(newVotes, getResult6.getExtensions());
    assertEquals(newVotes, getResult7.getExtensions());
    assertEquals(newVotes, descriptorForType3.getNestedTypes());
    assertEquals(newVotes, descriptorForType6.getNestedTypes());
    assertEquals(newVotes, descriptorForType5.getNestedTypes());
    assertEquals(newVotes, getResult5.getNestedTypes());
    assertEquals(newVotes, getResult6.getNestedTypes());
    assertEquals(newVotes, getResult7.getNestedTypes());
    assertEquals(newVotes, descriptorForType3.getOneofs());
    assertEquals(newVotes, descriptorForType4.getOneofs());
    assertEquals(newVotes, descriptorForType6.getOneofs());
    assertEquals(newVotes, descriptorForType5.getOneofs());
    assertEquals(newVotes, getResult5.getOneofs());
    assertEquals(newVotes, getResult6.getOneofs());
    assertEquals(newVotes, getResult7.getOneofs());
    assertEquals(newVotes, descriptorForType3.getRealOneofs());
    assertEquals(newVotes, descriptorForType4.getRealOneofs());
    assertEquals(newVotes, descriptorForType6.getRealOneofs());
    assertEquals(newVotes, descriptorForType5.getRealOneofs());
    assertEquals(newVotes, getResult5.getRealOneofs());
    assertEquals(newVotes, getResult6.getRealOneofs());
    assertEquals(newVotes, getResult7.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    assertEquals(newVotes, file2.getDependencies());
    Descriptors.FileDescriptor getResult8 = dependencies.get(0);
    assertEquals(newVotes, getResult8.getDependencies());
    Descriptors.FileDescriptor getResult9 = dependencies.get(1);
    assertEquals(newVotes, getResult9.getDependencies());
    Descriptors.FileDescriptor getResult10 = dependencies.get(2);
    assertEquals(newVotes, getResult10.getDependencies());
    assertEquals(newVotes, getResult8.getEnumTypes());
    assertEquals(newVotes, getResult9.getEnumTypes());
    assertEquals(newVotes, file2.getExtensions());
    assertEquals(newVotes, getResult8.getExtensions());
    assertEquals(newVotes, getResult9.getExtensions());
    assertEquals(newVotes, getResult10.getExtensions());
    assertEquals(newVotes, getResult10.getMessageTypes());
    assertEquals(newVotes, file2.getPublicDependencies());
    assertEquals(newVotes, getResult8.getPublicDependencies());
    assertEquals(newVotes, getResult9.getPublicDependencies());
    assertEquals(newVotes, getResult10.getPublicDependencies());
    assertEquals(newVotes, file2.getServices());
    assertEquals(newVotes, getResult8.getServices());
    assertEquals(newVotes, getResult9.getServices());
    assertEquals(newVotes, getResult10.getServices());
    assertSame(defaultInstanceForType2, toProtoResult.getDefaultInstanceForType());
    assertSame(file, descriptorForType.getFile());
    assertSame(descriptorForType, getResult3.getMessageType());
    assertSame(descriptorForType, getResult4.getMessageType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(newVotes, defaultInstanceForType2.getEnumTypeList());
    assertSame(newVotes, toProtoResult.getEnumTypeList());
    assertSame(newVotes, toProtoResult3.getEnumTypeList());
    assertSame(newVotes, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(newVotes, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(newVotes, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getExtensionList());
    assertSame(newVotes, toProtoResult.getExtensionList());
    assertSame(newVotes, toProtoResult3.getExtensionList());
    assertSame(newVotes, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(newVotes, toProtoResult.getExtensionOrBuilderList());
    assertSame(newVotes, toProtoResult3.getExtensionOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getExtensionRangeList());
    assertSame(newVotes, toProtoResult.getExtensionRangeList());
    assertSame(newVotes, toProtoResult3.getExtensionRangeList());
    assertSame(newVotes, defaultInstanceForType2.getExtensionRangeOrBuilderList());
    assertSame(newVotes, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(newVotes, toProtoResult3.getExtensionRangeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getFieldList());
    assertSame(newVotes, defaultInstanceForType2.getFieldOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getNestedTypeList());
    assertSame(newVotes, toProtoResult.getNestedTypeList());
    assertSame(newVotes, toProtoResult3.getNestedTypeList());
    assertSame(newVotes, defaultInstanceForType2.getNestedTypeOrBuilderList());
    assertSame(newVotes, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(newVotes, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getOneofDeclList());
    assertSame(newVotes, toProtoResult.getOneofDeclList());
    assertSame(newVotes, toProtoResult3.getOneofDeclList());
    assertSame(newVotes, defaultInstanceForType2.getOneofDeclOrBuilderList());
    assertSame(newVotes, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(newVotes, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getReservedRangeList());
    assertSame(newVotes, toProtoResult.getReservedRangeList());
    assertSame(newVotes, toProtoResult3.getReservedRangeList());
    assertSame(newVotes, defaultInstanceForType2.getReservedRangeOrBuilderList());
    assertSame(newVotes, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(newVotes, toProtoResult3.getReservedRangeOrBuilderList());
    assertSame(newVotes, options3.getEditionDefaultsList());
    assertSame(newVotes, options3.getEditionDefaultsOrBuilderList());
    assertSame(newVotes, options3.getUninterpretedOptionList());
    assertSame(newVotes, options3.getUninterpretedOptionOrBuilderList());
    assertSame(newVotes, defaultInstanceForType3.getEnumTypeList());
    assertSame(newVotes, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType3.getExtensionList());
    assertSame(newVotes, toProtoResult2.getExtensionList());
    assertSame(newVotes, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(newVotes, toProtoResult2.getExtensionOrBuilderList());
    assertSame(newVotes, defaultInstanceForType3.getMessageTypeList());
    assertSame(newVotes, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType3.getServiceList());
    assertSame(newVotes, toProtoResult2.getServiceList());
    assertSame(newVotes, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(newVotes, toProtoResult2.getServiceOrBuilderList());
    assertSame(newVotes, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(newVotes, options2.getUninterpretedOptionList());
    assertSame(newVotes, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(newVotes, options2.getUninterpretedOptionOrBuilderList());
    assertSame(newVotes, options.getUninterpretedOptionList());
    assertSame(newVotes, options.getUninterpretedOptionOrBuilderList());
    assertSame(newVotes, sourceCodeInfo.getLocationList());
    assertSame(newVotes, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(votes, instance.getDefaultInstanceForType());
    ByteString expectedVoteAddress = voteAddress.EMPTY;
    assertSame(expectedVoteAddress, defaultInstanceForType.getVoteAddress());
    assertSame(voteAddress, getResult.getVoteAddress());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    assertArrayEquals(new byte[]{18, 4, '\n', 0, 16, 3}, votesCapsule.getData());
  }

  /**
   * Method under test: {@link VotesCapsule#addOldVotes(ByteString, long)}
   */
  @Test
  public void testAddOldVotes2() {
    // Arrange
    ByteString address = mock(ByteString.class);
    ArrayList<Protocol.Vote> oldVotes = new ArrayList<>();
    VotesCapsule votesCapsule = new VotesCapsule(address, oldVotes);
    ByteString voteAddress = mock(ByteString.class);

    // Act
    votesCapsule.addOldVotes(voteAddress, 3L);

    // Assert
    List<Protocol.Vote> oldVotes2 = votesCapsule.getOldVotes();
    assertEquals(1, oldVotes2.size());
    Protocol.Vote getResult = oldVotes2.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Vote defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals("Vote", toProtoResult.getName());
    assertEquals("Vote", descriptorForType.getName());
    assertEquals("protocol.Vote", descriptorForType.getFullName());
    assertNull(descriptorForType.getContainingType());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getVoteCount());
    byte[] data = votesCapsule.getData();
    assertEquals((byte) 0, data[5]);
    assertEquals(1, descriptorForType.getIndex());
    Protocol.Votes instance = votesCapsule.getInstance();
    assertEquals(1, instance.getOldVotesCount());
    assertEquals((byte) 16, data[6]);
    assertEquals((byte) 18, data[2]);
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(3, fields.size());
    assertEquals(3L, getResult.getVoteCount());
    assertEquals((byte) 3, data[7]);
    assertEquals(4, getResult.getSerializedSize());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    assertEquals(45, file.toProto().getMessageTypeList().size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    assertEquals(48, toProtoResult.getSerializedSize());
    assertEquals((byte) 4, data[3]);
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, data.length);
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(oldVotes, toProtoResult.findInitializationErrors());
    assertEquals('\n', data[4]);
    assertSame(file, descriptorForType.getFile());
    assertSame(descriptorForType, fields.get(1).getMessageType());
    assertSame(descriptorForType, fields.get(2).getMessageType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    ByteString expectedVoteAddress = voteAddress.EMPTY;
    assertSame(expectedVoteAddress, defaultInstanceForType.getVoteAddress());
    assertSame(voteAddress, getResult.getVoteAddress());
  }

  /**
   * Method under test: {@link VotesCapsule#addOldVotes(ByteString, long)}
   */
  @Test
  public void testAddOldVotes3() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    VotesCapsule votesCapsule = new VotesCapsule(votes);
    ArrayList<Protocol.Vote> votesToAdd = new ArrayList<>();
    votesCapsule.addAllNewVotes(votesToAdd);
    ByteString voteAddress = mock(ByteString.class);

    // Act
    votesCapsule.addOldVotes(voteAddress, 3L);

    // Assert
    List<Protocol.Vote> oldVotes = votesCapsule.getOldVotes();
    assertEquals(1, oldVotes.size());
    Protocol.Vote getResult = oldVotes.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Vote defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals("Vote", toProtoResult.getName());
    assertEquals("Vote", descriptorForType.getName());
    assertEquals("protocol.Vote", descriptorForType.getFullName());
    assertNull(descriptorForType.getContainingType());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getVoteCount());
    assertEquals(1, descriptorForType.getIndex());
    Protocol.Votes instance = votesCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getOldVotesCount());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, getResult.getAllFields().size());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(3, fields.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    assertEquals(3L, getResult.getVoteCount());
    assertEquals(4, getResult.getSerializedSize());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertEquals(45, toProtoResult2.getMessageTypeList().size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    assertEquals(48, toProtoResult.getSerializedSize());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    ProtocolStringList reservedNameList = toProtoResult3.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Protocol.Vote> newVotes = votesCapsule.getNewVotes();
    assertTrue(newVotes.isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertEquals(votesToAdd, defaultInstanceForType2.findInitializationErrors());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertEquals(votesToAdd, defaultInstanceForType3.findInitializationErrors());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals(votesToAdd, sourceCodeInfo.findInitializationErrors());
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertEquals(votesToAdd, defaultInstanceForType4.findInitializationErrors());
    assertEquals(votesToAdd, options.getFeatures().findInitializationErrors());
    assertEquals(votesToAdd, toProtoResult.findInitializationErrors());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertEquals(votesToAdd, options3.findInitializationErrors());
    assertEquals(votesToAdd, getResult2.toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertEquals(votesToAdd, getResult3.toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertEquals(votesToAdd, getResult4.toProto().findInitializationErrors());
    assertEquals(votesToAdd, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType4 = toProtoResult3.getDescriptorForType();
    assertEquals(votesToAdd, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals(votesToAdd, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals(votesToAdd, getResult5.getEnumTypes());
    Descriptors.Descriptor getResult6 = messageTypes.get(43);
    assertEquals(votesToAdd, getResult6.getEnumTypes());
    Descriptors.Descriptor getResult7 = messageTypes.get(44);
    assertEquals(votesToAdd, getResult7.getEnumTypes());
    assertEquals(votesToAdd, descriptorForType4.getExtensions());
    Descriptors.Descriptor descriptorForType6 = options2.getDescriptorForType();
    assertEquals(votesToAdd, descriptorForType6.getExtensions());
    assertEquals(votesToAdd, descriptorForType5.getExtensions());
    assertEquals(votesToAdd, getResult5.getExtensions());
    assertEquals(votesToAdd, getResult6.getExtensions());
    assertEquals(votesToAdd, getResult7.getExtensions());
    assertEquals(votesToAdd, descriptorForType3.getNestedTypes());
    assertEquals(votesToAdd, descriptorForType6.getNestedTypes());
    assertEquals(votesToAdd, descriptorForType5.getNestedTypes());
    assertEquals(votesToAdd, getResult5.getNestedTypes());
    assertEquals(votesToAdd, getResult6.getNestedTypes());
    assertEquals(votesToAdd, getResult7.getNestedTypes());
    assertEquals(votesToAdd, descriptorForType3.getOneofs());
    assertEquals(votesToAdd, descriptorForType4.getOneofs());
    assertEquals(votesToAdd, descriptorForType6.getOneofs());
    assertEquals(votesToAdd, descriptorForType5.getOneofs());
    assertEquals(votesToAdd, getResult5.getOneofs());
    assertEquals(votesToAdd, getResult6.getOneofs());
    assertEquals(votesToAdd, getResult7.getOneofs());
    assertEquals(votesToAdd, descriptorForType3.getRealOneofs());
    assertEquals(votesToAdd, descriptorForType4.getRealOneofs());
    assertEquals(votesToAdd, descriptorForType6.getRealOneofs());
    assertEquals(votesToAdd, descriptorForType5.getRealOneofs());
    assertEquals(votesToAdd, getResult5.getRealOneofs());
    assertEquals(votesToAdd, getResult6.getRealOneofs());
    assertEquals(votesToAdd, getResult7.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    assertEquals(votesToAdd, file2.getDependencies());
    Descriptors.FileDescriptor getResult8 = dependencies.get(0);
    assertEquals(votesToAdd, getResult8.getDependencies());
    Descriptors.FileDescriptor getResult9 = dependencies.get(1);
    assertEquals(votesToAdd, getResult9.getDependencies());
    Descriptors.FileDescriptor getResult10 = dependencies.get(2);
    assertEquals(votesToAdd, getResult10.getDependencies());
    assertEquals(votesToAdd, getResult8.getEnumTypes());
    assertEquals(votesToAdd, getResult9.getEnumTypes());
    assertEquals(votesToAdd, file2.getExtensions());
    assertEquals(votesToAdd, getResult8.getExtensions());
    assertEquals(votesToAdd, getResult9.getExtensions());
    assertEquals(votesToAdd, getResult10.getExtensions());
    assertEquals(votesToAdd, getResult10.getMessageTypes());
    assertEquals(votesToAdd, file2.getPublicDependencies());
    assertEquals(votesToAdd, getResult8.getPublicDependencies());
    assertEquals(votesToAdd, getResult9.getPublicDependencies());
    assertEquals(votesToAdd, getResult10.getPublicDependencies());
    assertEquals(votesToAdd, file2.getServices());
    assertEquals(votesToAdd, getResult8.getServices());
    assertEquals(votesToAdd, getResult9.getServices());
    assertEquals(votesToAdd, getResult10.getServices());
    assertSame(defaultInstanceForType2, toProtoResult.getDefaultInstanceForType());
    assertSame(file, descriptorForType.getFile());
    assertSame(descriptorForType, getResult3.getMessageType());
    assertSame(descriptorForType, getResult4.getMessageType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(newVotes, defaultInstanceForType2.getEnumTypeList());
    assertSame(newVotes, toProtoResult.getEnumTypeList());
    assertSame(newVotes, toProtoResult3.getEnumTypeList());
    assertSame(newVotes, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(newVotes, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(newVotes, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getExtensionList());
    assertSame(newVotes, toProtoResult.getExtensionList());
    assertSame(newVotes, toProtoResult3.getExtensionList());
    assertSame(newVotes, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(newVotes, toProtoResult.getExtensionOrBuilderList());
    assertSame(newVotes, toProtoResult3.getExtensionOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getExtensionRangeList());
    assertSame(newVotes, toProtoResult.getExtensionRangeList());
    assertSame(newVotes, toProtoResult3.getExtensionRangeList());
    assertSame(newVotes, defaultInstanceForType2.getExtensionRangeOrBuilderList());
    assertSame(newVotes, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(newVotes, toProtoResult3.getExtensionRangeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getFieldList());
    assertSame(newVotes, defaultInstanceForType2.getFieldOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getNestedTypeList());
    assertSame(newVotes, toProtoResult.getNestedTypeList());
    assertSame(newVotes, toProtoResult3.getNestedTypeList());
    assertSame(newVotes, defaultInstanceForType2.getNestedTypeOrBuilderList());
    assertSame(newVotes, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(newVotes, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getOneofDeclList());
    assertSame(newVotes, toProtoResult.getOneofDeclList());
    assertSame(newVotes, toProtoResult3.getOneofDeclList());
    assertSame(newVotes, defaultInstanceForType2.getOneofDeclOrBuilderList());
    assertSame(newVotes, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(newVotes, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(newVotes, defaultInstanceForType2.getReservedRangeList());
    assertSame(newVotes, toProtoResult.getReservedRangeList());
    assertSame(newVotes, toProtoResult3.getReservedRangeList());
    assertSame(newVotes, defaultInstanceForType2.getReservedRangeOrBuilderList());
    assertSame(newVotes, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(newVotes, toProtoResult3.getReservedRangeOrBuilderList());
    assertSame(newVotes, options3.getEditionDefaultsList());
    assertSame(newVotes, options3.getEditionDefaultsOrBuilderList());
    assertSame(newVotes, options3.getUninterpretedOptionList());
    assertSame(newVotes, options3.getUninterpretedOptionOrBuilderList());
    assertSame(newVotes, defaultInstanceForType3.getEnumTypeList());
    assertSame(newVotes, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType3.getExtensionList());
    assertSame(newVotes, toProtoResult2.getExtensionList());
    assertSame(newVotes, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(newVotes, toProtoResult2.getExtensionOrBuilderList());
    assertSame(newVotes, defaultInstanceForType3.getMessageTypeList());
    assertSame(newVotes, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(newVotes, defaultInstanceForType3.getServiceList());
    assertSame(newVotes, toProtoResult2.getServiceList());
    assertSame(newVotes, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(newVotes, toProtoResult2.getServiceOrBuilderList());
    assertSame(newVotes, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(newVotes, options2.getUninterpretedOptionList());
    assertSame(newVotes, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(newVotes, options2.getUninterpretedOptionOrBuilderList());
    assertSame(newVotes, options.getUninterpretedOptionList());
    assertSame(newVotes, options.getUninterpretedOptionOrBuilderList());
    assertSame(newVotes, sourceCodeInfo.getLocationList());
    assertSame(newVotes, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(votes, instance.getDefaultInstanceForType());
    ByteString expectedVoteAddress = voteAddress.EMPTY;
    assertSame(expectedVoteAddress, defaultInstanceForType.getVoteAddress());
    assertSame(voteAddress, getResult.getVoteAddress());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    assertArrayEquals(new byte[]{18, 4, '\n', 0, 16, 3}, votesCapsule.getData());
  }

  /**
   * Method under test: {@link VotesCapsule#addOldVotes(ByteString, long)}
   */
  @Test
  public void testAddOldVotes4() {
    // Arrange
    ArrayList<Protocol.Vote> oldVotes = new ArrayList<>();
    Protocol.Vote defaultInstance = Protocol.Vote.getDefaultInstance();
    oldVotes.add(defaultInstance);
    VotesCapsule votesCapsule = new VotesCapsule(mock(ByteString.class), oldVotes);
    ByteString voteAddress = mock(ByteString.class);

    // Act
    votesCapsule.addOldVotes(voteAddress, 3L);

    // Assert
    List<Protocol.Vote> oldVotes2 = votesCapsule.getOldVotes();
    assertEquals(2, oldVotes2.size());
    Protocol.Vote getResult = oldVotes2.get(1);
    assertEquals("", getResult.getInitializationErrorString());
    byte[] data = votesCapsule.getData();
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 0, data[7]);
    Protocol.Votes instance = votesCapsule.getInstance();
    assertEquals(10, instance.getSerializedSize());
    assertEquals(10, data.length);
    assertEquals((byte) 16, data[8]);
    assertEquals((byte) 18, data[2]);
    assertEquals((byte) 18, data[4]);
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(2, instance.getOldVotesCount());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(3, descriptorForType.getFields().size());
    assertEquals(3L, getResult.getVoteCount());
    assertEquals((byte) 3, data[9]);
    assertEquals(4, getResult.getSerializedSize());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(45, file.toProto().getMessageTypeList().size());
    assertEquals(45, file.getMessageTypes().size());
    assertEquals((byte) 4, data[5]);
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals('\n', data[6]);
    assertSame(defaultInstance, oldVotes2.get(0));
    assertSame(defaultInstance, getResult.getDefaultInstanceForType());
    assertSame(voteAddress, getResult.getVoteAddress());
  }

  /**
   * Method under test: {@link VotesCapsule#addOldVotes(ByteString, long)}
   */
  @Test
  public void testAddOldVotes5() {
    // Arrange
    ArrayList<Protocol.Vote> votesToAdd = new ArrayList<>();
    Protocol.Vote defaultInstance = Protocol.Vote.getDefaultInstance();
    votesToAdd.add(defaultInstance);
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    VotesCapsule votesCapsule = new VotesCapsule(votes);
    votesCapsule.addAllNewVotes(votesToAdd);
    ByteString voteAddress = mock(ByteString.class);

    // Act
    votesCapsule.addOldVotes(voteAddress, 3L);

    // Assert
    List<Protocol.Vote> oldVotes = votesCapsule.getOldVotes();
    assertEquals(1, oldVotes.size());
    Protocol.Vote getResult = oldVotes.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Votes instance = votesCapsule.getInstance();
    assertEquals(1, instance.getOldVotesCount());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(3, descriptorForType.getFields().size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(3L, getResult.getVoteCount());
    assertEquals(4, getResult.getSerializedSize());
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(45, toProtoResult.getMessageTypeList().size());
    assertEquals(45, file.getMessageTypes().size());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.getReservedNameList().isEmpty());
    assertTrue(toProtoResult.getPublicDependencyList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(votesToAdd, votesCapsule.getNewVotes());
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
    assertSame(defaultInstance, getResult.getDefaultInstanceForType());
    assertSame(votes, instance.getDefaultInstanceForType());
    assertSame(voteAddress, getResult.getVoteAddress());
    assertArrayEquals(new byte[]{18, 4, '\n', 0, 16, 3, 26, 0}, votesCapsule.getData());
  }

  /**
   * Method under test: {@link VotesCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey() {
    // Arrange, Act and Assert
    assertEquals(0, (new VotesCapsule(Protocol.Votes.getDefaultInstance())).createDbKey().length);
  }

  /**
   * Method under test: {@link VotesCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey2() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCreateDbKeyResult = (new VotesCapsule(address, new ArrayList<>())).createDbKey();

    // Assert
    verify(address).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Method under test: {@link VotesCapsule#createReadableString()}
   */
  @Test
  public void testCreateReadableString() {
    // Arrange, Act and Assert
    assertEquals("", (new VotesCapsule(Protocol.Votes.getDefaultInstance())).createReadableString());
  }

  /**
   * Method under test: {@link VotesCapsule#createReadableString()}
   */
  @Test
  public void testCreateReadableString2() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualCreateReadableStringResult = (new VotesCapsule(address, new ArrayList<>())).createReadableString();

    // Assert
    verify(address).toByteArray();
    assertEquals("4158415841584158", actualCreateReadableStringResult);
  }

  /**
   * Method under test: {@link VotesCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new VotesCapsule(Protocol.Votes.getDefaultInstance())).getData().length);
  }

  /**
   * Method under test: {@link VotesCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new VotesCapsule(address, new ArrayList<>())).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link VotesCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    ArrayList<Protocol.Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Protocol.Vote.getDefaultInstance());

    // Act
    byte[] actualData = (new VotesCapsule(address, oldVotes)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{18, 0}, actualData);
  }

  /**
   * Method under test: {@link VotesCapsule#getData()}
   */
  @Test
  public void testGetData4() {
    // Arrange
    VotesCapsule votesCapsule = new VotesCapsule(Protocol.Votes.getDefaultInstance());
    votesCapsule.addAllNewVotes(new ArrayList<>());

    // Act and Assert
    assertEquals(0, votesCapsule.getData().length);
  }

  /**
   * Method under test: {@link VotesCapsule#getData()}
   */
  @Test
  public void testGetData5() {
    // Arrange
    ArrayList<Protocol.Vote> votesToAdd = new ArrayList<>();
    votesToAdd.add(Protocol.Vote.getDefaultInstance());

    VotesCapsule votesCapsule = new VotesCapsule(Protocol.Votes.getDefaultInstance());
    votesCapsule.addAllNewVotes(votesToAdd);

    // Act and Assert
    assertArrayEquals(new byte[]{26, 0}, votesCapsule.getData());
  }

  /**
   * Method under test: {@link VotesCapsule#getInstance()}
   */
  @Test
  public void testGetInstance() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    // Act and Assert
    assertSame(votes, (new VotesCapsule(votes)).getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#VotesCapsule(Protocol.Votes)}
   */
  @Test
  public void testNewVotesCapsule() {
    // Arrange
    Protocol.Votes votes = Protocol.Votes.getDefaultInstance();

    // Act and Assert
    assertSame(votes, (new VotesCapsule(votes)).getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  public void testNewVotesCapsule2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  public void testNewVotesCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  public void testNewVotesCapsule4() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  public void testNewVotesCapsule5() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  public void testNewVotesCapsule6() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  public void testNewVotesCapsule7() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  public void testNewVotesCapsule8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  public void testNewVotesCapsule9() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{'\n', 2, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  public void testNewVotesCapsule10() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  public void testNewVotesCapsule11() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{18, 2, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  public void testNewVotesCapsule12() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  public void testNewVotesCapsule13() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }
}
