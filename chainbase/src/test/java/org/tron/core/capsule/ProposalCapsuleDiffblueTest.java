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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.tron.protos.Protocol;

public class ProposalCapsuleDiffblueTest {
  /**
   * Method under test: {@link ProposalCapsule#calculateDbKey(long)}
   */
  @Test
  public void testCalculateDbKey() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1}, ProposalCapsule.calculateDbKey(1L));
  }

  /**
   * Method under test: {@link ProposalCapsule#getID()}
   */
  @Test
  public void testGetID() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ProposalCapsule(Protocol.Proposal.getDefaultInstance())).getID());
    assertEquals(1L, (new ProposalCapsule(mock(ByteString.class), 1L)).getID());
  }

  /**
   * Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  public void testSetID() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();
    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);

    // Act
    proposalCapsule.setID(1L);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, proposalCapsule.getID());
    assertEquals(1L, instance.getProposalId());
    assertEquals(2, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', 1}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  public void testSetID2() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setProposalAddress(mock(ByteString.class));

    // Act
    proposalCapsule.setID(1L);

    // Assert
    assertEquals(1L, proposalCapsule.getID());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(1L, instance.getProposalId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  public void testSetID3() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(new HashMap<>());

    // Act
    proposalCapsule.setID(1L);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, proposalCapsule.getID());
    assertEquals(1L, instance.getProposalId());
    assertEquals(2, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', 1}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  public void testSetID4() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setExpirationTime(10L);

    // Act
    proposalCapsule.setID(1L);

    // Assert
    assertEquals(1L, proposalCapsule.getID());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(1L, instance.getProposalId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', 1, ' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  public void testSetID5() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setCreateTime(10L);

    // Act
    proposalCapsule.setID(1L);

    // Assert
    assertEquals(1L, proposalCapsule.getID());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(1L, instance.getProposalId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', 1, '(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  public void testSetID6() {
    // Arrange
    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(parameters);

    // Act
    proposalCapsule.setID(1L);

    // Assert
    byte[] data = proposalCapsule.getData();
    assertEquals((byte) 16, data[6]);
    assertEquals(1L, proposalCapsule.getID());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(1L, instance.getProposalId());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[7]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[2]);
    assertEquals((byte) 4, data[3]);
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, data.length);
    assertEquals('\b', data[0]);
    assertEquals('\b', data[4]);
    assertSame(proposal, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#getProposalAddress()}
   */
  @Test
  public void testGetProposalAddress() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();
    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);

    // Act
    ByteString actualProposalAddress = proposalCapsule.getProposalAddress();

    // Assert
    assertSame(proposal, proposalCapsule.getInstance());
    assertSame(actualProposalAddress.EMPTY, actualProposalAddress);
  }

  /**
   * Method under test: {@link ProposalCapsule#getProposalAddress()}
   */
  @Test
  public void testGetProposalAddress2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);

    // Act
    ByteString actualProposalAddress = proposalCapsule.getProposalAddress();

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(7, fields.size());
    ByteString byteString = actualProposalAddress.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, instance.getDefaultInstanceForType().getProposerAddress());
  }

  /**
   * Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  public void testSetProposalAddress() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();
    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    ByteString address = mock(ByteString.class);

    // Act
    proposalCapsule.setProposalAddress(address);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(7, fields.size());
    assertSame(proposal, instance.getDefaultInstanceForType());
    ByteString expectedDefaultValue = address.EMPTY;
    assertSame(expectedDefaultValue, fields.get(1).getDefaultValue());
    assertSame(address, proposalCapsule.getProposalAddress());
    assertSame(address, instance.getProposerAddress());
    assertArrayEquals(new byte[]{18, 0}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  public void testSetProposalAddress2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    ByteString address = mock(ByteString.class);

    // Act
    proposalCapsule.setProposalAddress(address);

    // Assert
    assertSame(address, proposalCapsule.getProposalAddress());
    assertSame(address, proposalCapsule.getInstance().getProposerAddress());
  }

  /**
   * Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  public void testSetProposalAddress3() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setID(1L);
    ByteString address = mock(ByteString.class);

    // Act
    proposalCapsule.setProposalAddress(address);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(7, fields.size());
    assertSame(proposal, instance.getDefaultInstanceForType());
    ByteString expectedDefaultValue = address.EMPTY;
    assertSame(expectedDefaultValue, fields.get(1).getDefaultValue());
    assertSame(address, proposalCapsule.getProposalAddress());
    assertSame(address, instance.getProposerAddress());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  public void testSetProposalAddress4() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(new HashMap<>());
    ByteString address = mock(ByteString.class);

    // Act
    proposalCapsule.setProposalAddress(address);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(7, fields.size());
    assertSame(proposal, instance.getDefaultInstanceForType());
    ByteString expectedDefaultValue = address.EMPTY;
    assertSame(expectedDefaultValue, fields.get(1).getDefaultValue());
    assertSame(address, proposalCapsule.getProposalAddress());
    assertSame(address, instance.getProposerAddress());
    assertArrayEquals(new byte[]{18, 0}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  public void testSetProposalAddress5() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setExpirationTime(10L);
    ByteString address = mock(ByteString.class);

    // Act
    proposalCapsule.setProposalAddress(address);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(7, fields.size());
    assertSame(proposal, instance.getDefaultInstanceForType());
    ByteString expectedDefaultValue = address.EMPTY;
    assertSame(expectedDefaultValue, fields.get(1).getDefaultValue());
    assertSame(address, proposalCapsule.getProposalAddress());
    assertSame(address, instance.getProposerAddress());
    assertArrayEquals(new byte[]{18, 0, ' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  public void testSetProposalAddress6() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setCreateTime(10L);
    ByteString address = mock(ByteString.class);

    // Act
    proposalCapsule.setProposalAddress(address);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(7, fields.size());
    assertSame(proposal, instance.getDefaultInstanceForType());
    ByteString expectedDefaultValue = address.EMPTY;
    assertSame(expectedDefaultValue, fields.get(1).getDefaultValue());
    assertSame(address, proposalCapsule.getProposalAddress());
    assertSame(address, instance.getProposerAddress());
    assertArrayEquals(new byte[]{18, 0, '(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  public void testSetProposalAddress7() {
    // Arrange
    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(parameters);
    ByteString address = mock(ByteString.class);

    // Act
    proposalCapsule.setProposalAddress(address);

    // Assert
    byte[] data = proposalCapsule.getData();
    assertEquals((byte) 0, data[1]);
    assertEquals((byte) 16, data[6]);
    assertEquals((byte) 18, data[0]);
    assertEquals((byte) 1, data[7]);
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[2]);
    assertEquals((byte) 4, data[3]);
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(7, fields.size());
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, data.length);
    assertEquals('\b', data[4]);
    assertSame(proposal, instance.getDefaultInstanceForType());
    ByteString expectedDefaultValue = address.EMPTY;
    assertSame(expectedDefaultValue, fields.get(1).getDefaultValue());
    assertSame(address, proposalCapsule.getProposalAddress());
    assertSame(address, instance.getProposerAddress());
  }

  /**
   * Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  public void testSetProposalAddress8() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setState(Protocol.Proposal.State.DISAPPROVED);
    ByteString address = mock(ByteString.class);

    // Act
    proposalCapsule.setProposalAddress(address);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(7, fields.size());
    assertSame(proposal, instance.getDefaultInstanceForType());
    ByteString expectedDefaultValue = address.EMPTY;
    assertSame(expectedDefaultValue, fields.get(1).getDefaultValue());
    assertSame(address, proposalCapsule.getProposalAddress());
    assertSame(address, instance.getProposerAddress());
    assertArrayEquals(new byte[]{18, 0, '8', 1}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#getParameters()}
   */
  @Test
  public void testGetParameters() {
    // Arrange, Act and Assert
    assertTrue((new ProposalCapsule(Protocol.Proposal.getDefaultInstance())).getParameters().isEmpty());
    assertTrue((new ProposalCapsule(mock(ByteString.class), 1L)).getParameters().isEmpty());
  }

  /**
   * Method under test: {@link ProposalCapsule#getParameters()}
   */
  @Test
  public void testGetParameters2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setParameters(new HashMap<>());

    // Act and Assert
    assertTrue(proposalCapsule.getParameters().isEmpty());
  }

  /**
   * Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  public void testSetParameters() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();
    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);

    // Act
    proposalCapsule.setParameters(new HashMap<>());

    // Assert
    assertEquals(0, proposalCapsule.getData().length);
    assertTrue(proposalCapsule.getParameters().isEmpty());
    assertEquals(proposal, proposalCapsule.getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  public void testSetParameters2() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();
    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);

    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    Map<Long, Long> parameters2 = proposalCapsule.getParameters();
    assertEquals(1, parameters2.size());
    Map<Long, Long> parameters3 = instance.getParameters();
    assertEquals(1, parameters3.size());
    Map<Long, Long> parametersMap = instance.getParametersMap();
    assertEquals(1, parametersMap.size());
    assertEquals(1, instance.getParametersCount());
    assertEquals(1L, parameters2.get(1L).longValue());
    assertEquals(1L, parameters3.get(1L).longValue());
    assertEquals(1L, parametersMap.get(1L).longValue());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{26, 4, '\b', 1, 16, 1}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  public void testSetParameters3() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setID(1L);
    HashMap<Long, Long> parameters = new HashMap<>();

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getParametersCount());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(1, enumTypes.size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(7, fields.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(proposalCapsule.getParameters().isEmpty());
    assertTrue(instance.getParameters().isEmpty());
    assertTrue(instance.getParametersMap().isEmpty());
    assertEquals(parameters, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(parameters, file.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(parameters, defaultInstanceForType.getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(parameters, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(parameters, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(parameters, options3.getAllFields());
    assertEquals(parameters, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(parameters, features.getAllFieldsRaw());
    assertEquals(parameters, options2.getAllFieldsRaw());
    assertEquals(parameters, options3.getAllFieldsRaw());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', 1}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  public void testSetParameters4() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setProposalAddress(mock(ByteString.class));
    HashMap<Long, Long> parameters = new HashMap<>();

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getParametersCount());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(1, enumTypes.size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(7, fields.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(proposalCapsule.getParameters().isEmpty());
    assertTrue(instance.getParameters().isEmpty());
    assertTrue(instance.getParametersMap().isEmpty());
    assertEquals(parameters, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(parameters, file.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(parameters, defaultInstanceForType.getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(parameters, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(parameters, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(parameters, options3.getAllFields());
    assertEquals(parameters, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(parameters, features.getAllFieldsRaw());
    assertEquals(parameters, options2.getAllFieldsRaw());
    assertEquals(parameters, options3.getAllFieldsRaw());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{18, 0}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  public void testSetParameters5() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setExpirationTime(10L);
    HashMap<Long, Long> parameters = new HashMap<>();

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getParametersCount());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(1, enumTypes.size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(7, fields.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(proposalCapsule.getParameters().isEmpty());
    assertTrue(instance.getParameters().isEmpty());
    assertTrue(instance.getParametersMap().isEmpty());
    assertEquals(parameters, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(parameters, file.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(parameters, defaultInstanceForType.getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(parameters, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(parameters, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(parameters, options3.getAllFields());
    assertEquals(parameters, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(parameters, features.getAllFieldsRaw());
    assertEquals(parameters, options2.getAllFieldsRaw());
    assertEquals(parameters, options3.getAllFieldsRaw());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  public void testSetParameters6() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setCreateTime(10L);
    HashMap<Long, Long> parameters = new HashMap<>();

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getParametersCount());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.EnumDescriptor> enumTypes = descriptorForType.getEnumTypes();
    assertEquals(1, enumTypes.size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(7, fields.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(proposalCapsule.getParameters().isEmpty());
    assertTrue(instance.getParameters().isEmpty());
    assertTrue(instance.getParametersMap().isEmpty());
    assertEquals(parameters, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(parameters, file.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(parameters, defaultInstanceForType.getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(parameters, features.getAllFields());
    DescriptorProtos.EnumOptions options2 = enumTypes.get(0).getOptions();
    assertEquals(parameters, options2.getAllFields());
    DescriptorProtos.FieldOptions options3 = fields.get(0).getOptions();
    assertEquals(parameters, options3.getAllFields());
    assertEquals(parameters, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(parameters, features.getAllFieldsRaw());
    assertEquals(parameters, options2.getAllFieldsRaw());
    assertEquals(parameters, options3.getAllFieldsRaw());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#getExpirationTime()}
   */
  @Test
  public void testGetExpirationTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ProposalCapsule(Protocol.Proposal.getDefaultInstance())).getExpirationTime());
    assertEquals(0L, (new ProposalCapsule(mock(ByteString.class), 1L)).getExpirationTime());
  }

  /**
   * Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  public void testSetExpirationTime() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();
    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, proposalCapsule.getExpirationTime());
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(2, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  public void testSetExpirationTime2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getExpirationTime());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    byte[] data = proposalCapsule.getData();
    assertEquals(6, data.length);
    assertEquals(' ', data[4]);
    assertEquals('\n', data[5]);
  }

  /**
   * Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  public void testSetExpirationTime3() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setID(1L);

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getExpirationTime());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', 1, ' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  public void testSetExpirationTime4() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setProposalAddress(mock(ByteString.class));

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getExpirationTime());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{18, 0, ' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  public void testSetExpirationTime5() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(new HashMap<>());

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, proposalCapsule.getExpirationTime());
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(2, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  public void testSetExpirationTime6() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setCreateTime(10L);

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getExpirationTime());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    byte[] expectedData = " \n(\n".getBytes("UTF-8");
    assertArrayEquals(expectedData, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  public void testSetExpirationTime7() {
    // Arrange
    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(parameters);

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getExpirationTime());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getExpirationTime());
    byte[] data = proposalCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[0]);
    assertEquals((byte) 4, data[1]);
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, data.length);
    assertEquals(' ', data[6]);
    assertEquals('\b', data[2]);
    assertEquals('\n', data[7]);
    assertSame(proposal, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  public void testSetExpirationTime8() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setState(Protocol.Proposal.State.DISAPPROVED);

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getExpirationTime());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{' ', '\n', '8', 1}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#getCreateTime()}
   */
  @Test
  public void testGetCreateTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ProposalCapsule(Protocol.Proposal.getDefaultInstance())).getCreateTime());
    assertEquals(0L, (new ProposalCapsule(mock(ByteString.class), 1L)).getCreateTime());
  }

  /**
   * Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();
    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, proposalCapsule.getCreateTime());
    assertEquals(10L, instance.getCreateTime());
    assertEquals(2, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getCreateTime());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    byte[] data = proposalCapsule.getData();
    assertEquals(6, data.length);
    assertEquals('(', data[4]);
    assertEquals('\n', data[5]);
  }

  /**
   * Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime3() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setID(1L);

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getCreateTime());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', 1, '(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime4() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setProposalAddress(mock(ByteString.class));

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getCreateTime());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{18, 0, '(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime5() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(new HashMap<>());

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, proposalCapsule.getCreateTime());
    assertEquals(10L, instance.getCreateTime());
    assertEquals(2, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime6() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setExpirationTime(10L);

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getCreateTime());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    byte[] expectedData = " \n(\n".getBytes("UTF-8");
    assertArrayEquals(expectedData, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime7() {
    // Arrange
    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(parameters);

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getCreateTime());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    byte[] data = proposalCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[0]);
    assertEquals((byte) 4, data[1]);
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, data.length);
    assertEquals('(', data[6]);
    assertEquals('\b', data[2]);
    assertEquals('\n', data[7]);
    assertSame(proposal, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime8() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setState(Protocol.Proposal.State.DISAPPROVED);

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getCreateTime());
    Protocol.Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'(', '\n', '8', 1}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#getApprovals()}
   */
  @Test
  public void testGetApprovals() {
    // Arrange, Act and Assert
    assertTrue((new ProposalCapsule(Protocol.Proposal.getDefaultInstance())).getApprovals().isEmpty());
    assertTrue((new ProposalCapsule(mock(ByteString.class), 1L)).getApprovals().isEmpty());
  }

  /**
   * Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  public void testRemoveApproval() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();
    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);

    // Act
    proposalCapsule.removeApproval(mock(ByteString.class));

    // Assert
    assertEquals(proposal, proposalCapsule.getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  public void testRemoveApproval2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);

    // Act
    proposalCapsule.removeApproval(mock(ByteString.class));

    // Assert
    assertTrue(proposalCapsule.getInstance().getDefaultInstanceForType().getApprovalsList().isEmpty());
  }

  /**
   * Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  public void testRemoveApproval3() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setID(1L);

    // Act
    proposalCapsule.removeApproval(mock(ByteString.class));

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  public void testRemoveApproval4() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setProposalAddress(mock(ByteString.class));

    // Act
    proposalCapsule.removeApproval(mock(ByteString.class));

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  public void testRemoveApproval5() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(new HashMap<>());

    // Act
    proposalCapsule.removeApproval(mock(ByteString.class));

    // Assert
    assertEquals(proposal, proposalCapsule.getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  public void testRemoveApproval6() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setExpirationTime(10L);

    // Act
    proposalCapsule.removeApproval(mock(ByteString.class));

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  public void testRemoveApproval7() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setCreateTime(10L);

    // Act
    proposalCapsule.removeApproval(mock(ByteString.class));

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  public void testRemoveApproval8() {
    // Arrange
    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(parameters);

    // Act
    proposalCapsule.removeApproval(mock(ByteString.class));

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  public void testRemoveApproval9() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setState(Protocol.Proposal.State.DISAPPROVED);

    // Act
    proposalCapsule.removeApproval(mock(ByteString.class));

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  public void testClearApproval() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();
    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);

    // Act
    proposalCapsule.clearApproval();

    // Assert
    assertEquals(proposal, proposalCapsule.getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  public void testClearApproval2() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setID(1L);

    // Act
    proposalCapsule.clearApproval();

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  public void testClearApproval3() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setProposalAddress(mock(ByteString.class));

    // Act
    proposalCapsule.clearApproval();

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  public void testClearApproval4() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(new HashMap<>());

    // Act
    proposalCapsule.clearApproval();

    // Assert
    assertEquals(proposal, proposalCapsule.getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  public void testClearApproval5() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setExpirationTime(10L);

    // Act
    proposalCapsule.clearApproval();

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  public void testClearApproval6() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setCreateTime(10L);

    // Act
    proposalCapsule.clearApproval();

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  public void testClearApproval7() {
    // Arrange
    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(parameters);

    // Act
    proposalCapsule.clearApproval();

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  public void testClearApproval8() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setState(Protocol.Proposal.State.DISAPPROVED);

    // Act
    proposalCapsule.clearApproval();

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#addApproval(ByteString)}
   */
  @Test
  public void testAddApproval() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();
    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    ByteString committeeAddress = mock(ByteString.class);

    // Act
    proposalCapsule.addApproval(committeeAddress);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertEquals(1, approvals.size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getApprovalsCount());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(45, file.getMessageTypes().size());
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    assertTrue(file.toProto().findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertSame(committeeAddress, approvals.get(0));
    assertArrayEquals(new byte[]{'2', 0}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#addApproval(ByteString)}
   */
  @Test
  public void testAddApproval2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);
    ByteString committeeAddress = mock(ByteString.class);

    // Act
    proposalCapsule.addApproval(committeeAddress);

    // Assert
    byte[] data = proposalCapsule.getData();
    assertEquals((byte) 0, data[5]);
    Protocol.Proposal instance = proposalCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertEquals(1, approvals.size());
    assertEquals(1, instance.getApprovalsCount());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(45, file.getMessageTypes().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    assertTrue(file.toProto().findInitializationErrors().isEmpty());
    Protocol.Proposal defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getApprovalsList().isEmpty());
    assertEquals('2', data[4]);
    assertSame(committeeAddress, approvals.get(0));
  }

  /**
   * Method under test: {@link ProposalCapsule#addApproval(ByteString)}
   */
  @Test
  public void testAddApproval3() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setID(1L);
    ByteString committeeAddress = mock(ByteString.class);

    // Act
    proposalCapsule.addApproval(committeeAddress);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertEquals(1, approvals.size());
    assertEquals(1, instance.getApprovalsCount());
    assertEquals(2, instance.getAllFields().size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(45, file.getMessageTypes().size());
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    assertTrue(file.toProto().findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertSame(committeeAddress, approvals.get(0));
    assertArrayEquals(new byte[]{'\b', 1, '2', 0}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#addApproval(ByteString)}
   */
  @Test
  public void testAddApproval4() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setProposalAddress(mock(ByteString.class));
    ByteString committeeAddress = mock(ByteString.class);

    // Act
    proposalCapsule.addApproval(committeeAddress);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertEquals(1, approvals.size());
    assertEquals(1, instance.getApprovalsCount());
    assertEquals(2, instance.getAllFields().size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(45, file.getMessageTypes().size());
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    assertTrue(file.toProto().findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertSame(committeeAddress, approvals.get(0));
    assertArrayEquals(new byte[]{18, 0, '2', 0}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#addApproval(ByteString)}
   */
  @Test
  public void testAddApproval5() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(new HashMap<>());
    ByteString committeeAddress = mock(ByteString.class);

    // Act
    proposalCapsule.addApproval(committeeAddress);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertEquals(1, approvals.size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getApprovalsCount());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(45, file.getMessageTypes().size());
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    assertTrue(file.toProto().findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertSame(committeeAddress, approvals.get(0));
    assertArrayEquals(new byte[]{'2', 0}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#addApproval(ByteString)}
   */
  @Test
  public void testAddApproval6() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setExpirationTime(10L);
    ByteString committeeAddress = mock(ByteString.class);

    // Act
    proposalCapsule.addApproval(committeeAddress);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertEquals(1, approvals.size());
    assertEquals(1, instance.getApprovalsCount());
    assertEquals(2, instance.getAllFields().size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(45, file.getMessageTypes().size());
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    assertTrue(file.toProto().findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertSame(committeeAddress, approvals.get(0));
    assertArrayEquals(new byte[]{' ', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#addApproval(ByteString)}
   */
  @Test
  public void testAddApproval7() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setCreateTime(10L);
    ByteString committeeAddress = mock(ByteString.class);

    // Act
    proposalCapsule.addApproval(committeeAddress);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertEquals(1, approvals.size());
    assertEquals(1, instance.getApprovalsCount());
    assertEquals(2, instance.getAllFields().size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(45, file.getMessageTypes().size());
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    assertTrue(file.toProto().findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertSame(committeeAddress, approvals.get(0));
    assertArrayEquals(new byte[]{'(', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#addApproval(ByteString)}
   */
  @Test
  public void testAddApproval8() {
    // Arrange
    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(parameters);
    ByteString committeeAddress = mock(ByteString.class);

    // Act
    proposalCapsule.addApproval(committeeAddress);

    // Assert
    byte[] data = proposalCapsule.getData();
    assertEquals((byte) 0, data[7]);
    Protocol.Proposal instance = proposalCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertEquals(1, approvals.size());
    assertEquals(1, instance.getApprovalsCount());
    assertEquals((byte) 1, data[3]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[0]);
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(45, file.getMessageTypes().size());
    assertEquals((byte) 4, data[1]);
    assertEquals(7, descriptorForType.getFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, data.length);
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    assertTrue(file.toProto().findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertEquals('2', data[6]);
    assertEquals('\b', data[2]);
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertSame(committeeAddress, approvals.get(0));
  }

  /**
   * Method under test: {@link ProposalCapsule#addApproval(ByteString)}
   */
  @Test
  public void testAddApproval9() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setState(Protocol.Proposal.State.DISAPPROVED);
    ByteString committeeAddress = mock(ByteString.class);

    // Act
    proposalCapsule.addApproval(committeeAddress);

    // Assert
    Protocol.Proposal instance = proposalCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertEquals(1, approvals.size());
    assertEquals(1, instance.getApprovalsCount());
    assertEquals(2, instance.getAllFields().size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(45, file.getMessageTypes().size());
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    assertTrue(file.toProto().findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertSame(proposal, instance.getDefaultInstanceForType());
    assertSame(committeeAddress, approvals.get(0));
    assertArrayEquals(new byte[]{'2', 0, '8', 1}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#getState()}
   */
  @Test
  public void testGetState() {
    // Arrange, Act and Assert
    assertEquals(Protocol.Proposal.State.PENDING,
        (new ProposalCapsule(Protocol.Proposal.getDefaultInstance())).getState());
    assertEquals(Protocol.Proposal.State.PENDING, (new ProposalCapsule(mock(ByteString.class), 1L)).getState());
  }

  /**
   * Method under test: {@link ProposalCapsule#getState()}
   */
  @Test
  public void testGetState2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setState(Protocol.Proposal.State.DISAPPROVED);

    // Act and Assert
    assertEquals(Protocol.Proposal.State.DISAPPROVED, proposalCapsule.getState());
  }

  /**
   * Method under test: {@link ProposalCapsule#getState()}
   */
  @Test
  public void testGetState3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setState(Protocol.Proposal.State.APPROVED);

    // Act and Assert
    assertEquals(Protocol.Proposal.State.APPROVED, proposalCapsule.getState());
  }

  /**
   * Method under test: {@link ProposalCapsule#getState()}
   */
  @Test
  public void testGetState4() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setState(Protocol.Proposal.State.CANCELED);

    // Act and Assert
    assertEquals(Protocol.Proposal.State.CANCELED, proposalCapsule.getState());
  }

  /**
   * Method under test: {@link ProposalCapsule#setState(Protocol.Proposal.State)}
   */
  @Test
  public void testSetState() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();
    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);

    // Act
    proposalCapsule.setState(Protocol.Proposal.State.PENDING);

    // Assert
    assertEquals(proposal, proposalCapsule.getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#setState(Protocol.Proposal.State)}
   */
  @Test
  public void testSetState2() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setID(1L);

    // Act
    proposalCapsule.setState(Protocol.Proposal.State.PENDING);

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#setState(Protocol.Proposal.State)}
   */
  @Test
  public void testSetState3() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setProposalAddress(mock(ByteString.class));

    // Act
    proposalCapsule.setState(Protocol.Proposal.State.PENDING);

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#setState(Protocol.Proposal.State)}
   */
  @Test
  public void testSetState4() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(new HashMap<>());

    // Act
    proposalCapsule.setState(Protocol.Proposal.State.PENDING);

    // Assert
    assertEquals(proposal, proposalCapsule.getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#setState(Protocol.Proposal.State)}
   */
  @Test
  public void testSetState5() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setExpirationTime(10L);

    // Act
    proposalCapsule.setState(Protocol.Proposal.State.PENDING);

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#setState(Protocol.Proposal.State)}
   */
  @Test
  public void testSetState6() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setCreateTime(10L);

    // Act
    proposalCapsule.setState(Protocol.Proposal.State.PENDING);

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#setState(Protocol.Proposal.State)}
   */
  @Test
  public void testSetState7() {
    // Arrange
    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    ProposalCapsule proposalCapsule = new ProposalCapsule(proposal);
    proposalCapsule.setParameters(parameters);

    // Act
    proposalCapsule.setState(Protocol.Proposal.State.PENDING);

    // Assert
    assertSame(proposal, proposalCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ProposalCapsule#hasProcessed()}
   */
  @Test
  public void testHasProcessed() {
    // Arrange, Act and Assert
    assertFalse((new ProposalCapsule(Protocol.Proposal.getDefaultInstance())).hasProcessed());
    assertFalse((new ProposalCapsule(mock(ByteString.class), 1L)).hasProcessed());
  }

  /**
   * Method under test: {@link ProposalCapsule#hasProcessed()}
   */
  @Test
  public void testHasProcessed2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setState(Protocol.Proposal.State.DISAPPROVED);

    // Act and Assert
    assertTrue(proposalCapsule.hasProcessed());
  }

  /**
   * Method under test: {@link ProposalCapsule#hasProcessed()}
   */
  @Test
  public void testHasProcessed3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setState(Protocol.Proposal.State.APPROVED);

    // Act and Assert
    assertTrue(proposalCapsule.hasProcessed());
  }

  /**
   * Method under test: {@link ProposalCapsule#hasProcessed()}
   */
  @Test
  public void testHasProcessed4() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setState(Protocol.Proposal.State.CANCELED);

    // Act and Assert
    assertFalse(proposalCapsule.hasProcessed());
  }

  /**
   * Method under test: {@link ProposalCapsule#hasCanceled()}
   */
  @Test
  public void testHasCanceled() {
    // Arrange, Act and Assert
    assertFalse((new ProposalCapsule(Protocol.Proposal.getDefaultInstance())).hasCanceled());
    assertFalse((new ProposalCapsule(mock(ByteString.class), 1L)).hasCanceled());
  }

  /**
   * Method under test: {@link ProposalCapsule#hasCanceled()}
   */
  @Test
  public void testHasCanceled2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setState(Protocol.Proposal.State.DISAPPROVED);

    // Act and Assert
    assertFalse(proposalCapsule.hasCanceled());
  }

  /**
   * Method under test: {@link ProposalCapsule#hasCanceled()}
   */
  @Test
  public void testHasCanceled3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setState(Protocol.Proposal.State.APPROVED);

    // Act and Assert
    assertFalse(proposalCapsule.hasCanceled());
  }

  /**
   * Method under test: {@link ProposalCapsule#hasCanceled()}
   */
  @Test
  public void testHasCanceled4() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setState(Protocol.Proposal.State.CANCELED);

    // Act and Assert
    assertTrue(proposalCapsule.hasCanceled());
  }

  /**
   * Method under test: {@link ProposalCapsule#hasExpired(long)}
   */
  @Test
  public void testHasExpired() {
    // Arrange, Act and Assert
    assertTrue((new ProposalCapsule(Protocol.Proposal.getDefaultInstance())).hasExpired(10L));
    assertTrue((new ProposalCapsule(mock(ByteString.class), 1L)).hasExpired(10L));
    assertFalse((new ProposalCapsule(Protocol.Proposal.getDefaultInstance())).hasExpired(-1L));
  }

  /**
   * Method under test: {@link ProposalCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0},
        (new ProposalCapsule(Protocol.Proposal.getDefaultInstance())).createDbKey());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1},
        (new ProposalCapsule(mock(ByteString.class), 1L)).createDbKey());
  }

  /**
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new ProposalCapsule(Protocol.Proposal.getDefaultInstance())).getData().length);
  }

  /**
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ProposalCapsule(address, 1L)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1}, actualData);
  }

  /**
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ProposalCapsule(address, -1L)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  public void testGetData4() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ProposalCapsule(address, 0L)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  public void testGetData5() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ProposalCapsule(address, Long.MAX_VALUE)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, actualData);
  }

  /**
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  public void testGetData6() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    ProposalCapsule proposalCapsule = new ProposalCapsule(address, 1L);
    proposalCapsule.setID(1L);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1}, actualData);
  }

  /**
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  public void testGetData7() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    ProposalCapsule proposalCapsule = new ProposalCapsule(address, 1L);
    proposalCapsule.setExpirationTime(10L);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, ' ', '\n'}, actualData);
  }

  /**
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  public void testGetData8() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    ProposalCapsule proposalCapsule = new ProposalCapsule(address, 1L);
    proposalCapsule.setCreateTime(10L);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, '(', '\n'}, actualData);
  }

  /**
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  public void testGetData9() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(address, 1L);
    proposalCapsule.setParameters(parameters);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, 26, 4, '\b', 1, 16, 1}, actualData);
  }

  /**
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  public void testGetData10() {
    // Arrange
    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setParameters(parameters);

    // Act and Assert
    assertArrayEquals(new byte[]{26, 4, '\b', 1, 16, 1}, proposalCapsule.getData());
  }

  /**
   * Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  public void testGetData11() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    ProposalCapsule proposalCapsule = new ProposalCapsule(address, 1L);
    proposalCapsule.setState(Protocol.Proposal.State.DISAPPROVED);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, '8', 1}, actualData);
  }

  /**
   * Method under test: {@link ProposalCapsule#getInstance()}
   */
  @Test
  public void testGetInstance() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    // Act and Assert
    assertSame(proposal, (new ProposalCapsule(proposal)).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#hasMostApprovals(List)}
   */
  @Test
  public void testHasMostApprovals() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());

    // Act and Assert
    assertTrue(proposalCapsule.hasMostApprovals(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ProposalCapsule#hasMostApprovals(List)}
   */
  @Test
  public void testHasMostApprovals2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);

    // Act and Assert
    assertTrue(proposalCapsule.hasMostApprovals(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(Protocol.Proposal)}
   */
  @Test
  public void testNewProposalCapsule() {
    // Arrange
    Protocol.Proposal proposal = Protocol.Proposal.getDefaultInstance();

    // Act and Assert
    assertSame(proposal, (new ProposalCapsule(proposal)).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  public void testNewProposalCapsule2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  public void testNewProposalCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule("\bXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  public void testNewProposalCapsule4() {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  public void testNewProposalCapsule5() {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  public void testNewProposalCapsule6() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(" XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  public void testNewProposalCapsule7() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule("(XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  public void testNewProposalCapsule8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  public void testNewProposalCapsule9() {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  public void testNewProposalCapsule10() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule("2XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  public void testNewProposalCapsule11() {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  public void testNewProposalCapsule12() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule("8XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  public void testNewProposalCapsule13() {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(new byte[]{27, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  public void testNewProposalCapsule14() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  public void testNewProposalCapsule15() {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  public void testNewProposalCapsule16() {
    // Arrange, Act and Assert
    assertNull((new ProposalCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }
}
