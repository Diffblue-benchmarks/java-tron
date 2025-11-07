package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.BytesCapsule;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.nativecontract.param.CancelAllUnfreezeV2Param;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;
import org.tron.protos.contract.AccountContract;
import org.tron.protos.contract.Common;

public class CancelAllUnfreezeV2ProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}
   */
  @Test
  public void testValidate() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    CancelAllUnfreezeV2Param param = new CancelAllUnfreezeV2Param();
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> cancelAllUnfreezeV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}
   */
  @Test
  public void testValidate2() throws ContractValidateException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    CancelAllUnfreezeV2Param param = new CancelAllUnfreezeV2Param();
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> cancelAllUnfreezeV2Processor.validate(param, null));
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}
   */
  @Test
  public void testValidate3() throws ContractValidateException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    CancelAllUnfreezeV2Param param = new CancelAllUnfreezeV2Param();
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> cancelAllUnfreezeV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}
   */
  @Test
  public void testValidate4() throws ContractValidateException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    CancelAllUnfreezeV2Param param = new CancelAllUnfreezeV2Param();
    param.setOwnerAddress(new byte[]{});

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> cancelAllUnfreezeV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();
    AccountCapsule accountCapsule = new AccountCapsule(account);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-110, 2, 0}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight2() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    AccountCapsule accountCapsule = new AccountCapsule(AccountContract.AccountCreateContract.getDefaultInstance());
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertArrayEquals(new byte[]{-110, 2, 0}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight3() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-110, 2, 0, -48, 2, '*'}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight4() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addDelegatedFrozenV2BalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-110, 2, 0, -96, 2, '*'}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight5() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addFrozenBalanceForBandwidthV2(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, getResult.getSerializedSize());
    assertEquals(42L, getResult.getAmount());
    assertEquals(5, instance.getSerializedSize());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
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
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-110, 2, 2, 16, '*'}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight6() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAcquiredDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-110, 2, 0, -56, 2, '*'}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight7() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAcquiredDelegatedFrozenV2BalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-110, 2, 0, -88, 2, '*'}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight8() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAcquiredDelegatedFrozenBalanceForEnergy(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(8, instance.getSerializedSize());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-46, 1, 2, ' ', '*', -110, 2, 0}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight9() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addFrozenBalanceForEnergyV2(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(2, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 getResult2 = frozenV2List.get(1);
    assertEquals("", getResult2.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, getResult2.getSerializedSize());
    assertEquals(0, getResult2.getTypeValue());
    assertEquals(0L, getResult2.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, getResult.getTypeValue());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(2, instance.getFrozenV2Count());
    assertEquals(4, getResult.getSerializedSize());
    assertEquals(42L, getResult.getAmount());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult2.getType());
    assertEquals(Common.ResourceCode.ENERGY, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult2.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult2.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(getResult2.isInitialized());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals(getResult2, defaultInstanceForType);
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, getResult2.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType, getResult2.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-110, 2, 4, '\b', 1, 16, '*', -110, 2, 0}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight10() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addUnfrozenV2List(Common.ResourceCode.BANDWIDTH, 1L, 1L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-110, 2, 0, -102, 2, 4, 24, 1, ' ', 1}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight11() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAssetAmount(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 10L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(17, instance.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'2', '\f', '\n', '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1, 16, '\n', -110, 2, 0},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight12() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAssetMapV2(new HashMap<>());
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-110, 2, 0}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight13() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAllLatestAssetOperationTimeV2(new HashMap<>());
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-110, 2, 0}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight14() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.putLatestAssetOperationTimeMap("Key", 42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-110, 1, 7, '\n', 3, 'K', 'e', 'y', 16, '*', -110, 2, 0}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight15() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAllFreeAssetNetUsageV2(new HashMap<>());
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-110, 2, 0}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight16() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.putFreeAssetNetUsage("foo", 1L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-94, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1, -110, 2, 0}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight17() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAccountName(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertEquals(Short.SIZE, instance.getSerializedSize());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1, -110, 2, 0, -48, 2, '*'},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight18() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAccountId(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(17, instance.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-70, 1, '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1, -110, 2, 0, -48, 2, '*'},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight19() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[69]);
    assertEquals((byte) -126, data[Short.SIZE]);
    assertEquals((byte) -48, data[72]);
    assertEquals((byte) -6, data[0]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[71]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 16, data[14]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 26, data[3]);
    assertEquals((byte) 2, data[13]);
    assertEquals((byte) 2, data[73]);
    assertEquals(5, instance.getAllFields().size());
    assertEquals((byte) 5, data[4]);
    assertEquals(75, instance.getSerializedSize());
    assertEquals(75, data.length);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[10]);
    assertEquals('*', data[74]);
    assertEquals(':', data[12]);
    assertEquals('\r', data[2]);
    assertEquals('e', data[8]);
    assertEquals('n', data[7]);
    assertEquals('o', data[5]);
    assertEquals('r', data[9]);
    assertEquals('w', data[6]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight20() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(new BytesCapsule(new byte[]{}));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[69]);
    assertEquals((byte) -126, data[Short.SIZE]);
    assertEquals((byte) -48, data[72]);
    assertEquals((byte) -6, data[0]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[71]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 16, data[14]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 26, data[3]);
    assertEquals((byte) 2, data[13]);
    assertEquals((byte) 2, data[73]);
    assertEquals(5, instance.getAllFields().size());
    assertEquals((byte) 5, data[4]);
    assertEquals(75, instance.getSerializedSize());
    assertEquals(75, data.length);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[10]);
    assertEquals('*', data[74]);
    assertEquals(':', data[12]);
    assertEquals('\r', data[2]);
    assertEquals('e', data[8]);
    assertEquals('n', data[7]);
    assertEquals('o', data[5]);
    assertEquals('r', data[9]);
    assertEquals('w', data[6]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight21() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
            new RepositoryImpl(StoreFactory.getInstance(), repository)));
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight22() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setBalance(42L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[71]);
    assertEquals((byte) -48, data[74]);
    assertEquals((byte) -6, data[2]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[73]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 16, data[69]);
    assertEquals((byte) 16, data[Short.SIZE]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 26, data[5]);
    assertEquals((byte) 2, data[15]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[75]);
    assertEquals((byte) 5, data[6]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(77, instance.getSerializedSize());
    assertEquals(77, data.length);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[0]);
    assertEquals(' ', data[12]);
    assertEquals('*', data[1]);
    assertEquals('*', data[76]);
    assertEquals(':', data[14]);
    assertEquals('\r', data[4]);
    assertEquals('e', data[10]);
    assertEquals('n', data[9]);
    assertEquals('o', data[7]);
    assertEquals('r', data[11]);
    assertEquals('w', data[8]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight23() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setLatestOperationTime(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[71]);
    assertEquals((byte) -48, data[74]);
    assertEquals((byte) -6, data[2]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[73]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 16, data[69]);
    assertEquals((byte) 16, data[Short.SIZE]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 26, data[5]);
    assertEquals((byte) 2, data[15]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[75]);
    assertEquals((byte) 5, data[6]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(77, instance.getSerializedSize());
    assertEquals(77, data.length);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[12]);
    assertEquals('*', data[76]);
    assertEquals(':', data[14]);
    assertEquals('P', data[0]);
    assertEquals('\r', data[4]);
    assertEquals('e', data[10]);
    assertEquals('n', data[9]);
    assertEquals('o', data[7]);
    assertEquals('r', data[11]);
    assertEquals('w', data[8]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight24() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setLatestConsumeTime(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[72]);
    assertEquals((byte) -48, data[75]);
    assertEquals((byte) -6, data[3]);
    assertEquals((byte) -88, data[0]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[74]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[14]);
    assertEquals((byte) 1, data[2]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[71]);
    assertEquals((byte) 26, data[6]);
    assertEquals((byte) 2, data[69]);
    assertEquals((byte) 2, data[73]);
    assertEquals((byte) 2, data[76]);
    assertEquals((byte) 2, data[Short.SIZE]);
    assertEquals((byte) 5, data[7]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(78, instance.getSerializedSize());
    assertEquals(78, data.length);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[13]);
    assertEquals('*', data[77]);
    assertEquals(':', data[15]);
    assertEquals('\r', data[5]);
    assertEquals('e', data[11]);
    assertEquals('n', data[10]);
    assertEquals('o', data[8]);
    assertEquals('r', data[12]);
    assertEquals('w', data[9]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight25() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setLatestConsumeFreeTime(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[72]);
    assertEquals((byte) -48, data[75]);
    assertEquals((byte) -6, data[3]);
    assertEquals((byte) -80, data[0]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[74]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[14]);
    assertEquals((byte) 1, data[2]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[71]);
    assertEquals((byte) 26, data[6]);
    assertEquals((byte) 2, data[69]);
    assertEquals((byte) 2, data[73]);
    assertEquals((byte) 2, data[76]);
    assertEquals((byte) 2, data[Short.SIZE]);
    assertEquals((byte) 5, data[7]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(78, instance.getSerializedSize());
    assertEquals(78, data.length);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[13]);
    assertEquals('*', data[77]);
    assertEquals(':', data[15]);
    assertEquals('\r', data[5]);
    assertEquals('e', data[11]);
    assertEquals('n', data[10]);
    assertEquals('o', data[8]);
    assertEquals('r', data[12]);
    assertEquals('w', data[9]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight26() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAssetOptimized(true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[69]);
    assertEquals((byte) -126, data[Short.SIZE]);
    assertEquals((byte) -32, data[75]);
    assertEquals((byte) -48, data[72]);
    assertEquals((byte) -6, data[0]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[71]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 16, data[14]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[77]);
    assertEquals((byte) 26, data[3]);
    assertEquals((byte) 2, data[13]);
    assertEquals((byte) 2, data[73]);
    assertEquals((byte) 3, data[76]);
    assertEquals((byte) 5, data[4]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(78, instance.getSerializedSize());
    assertEquals(78, data.length);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[10]);
    assertEquals('*', data[74]);
    assertEquals(':', data[12]);
    assertEquals('\r', data[2]);
    assertEquals('e', data[8]);
    assertEquals('n', data[7]);
    assertEquals('o', data[5]);
    assertEquals('r', data[9]);
    assertEquals('w', data[6]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight27() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAssetIssuedName(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[80]);
    assertEquals((byte) -118, data[0]);
    assertEquals((byte) -48, data[83]);
    assertEquals((byte) -6, data[11]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[82]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 16, data[78]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[10]);
    assertEquals((byte) 1, data[12]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[79]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 26, data[14]);
    assertEquals((byte) 2, data[77]);
    assertEquals((byte) 2, data[81]);
    assertEquals((byte) 2, data[84]);
    assertEquals((byte) 5, data[15]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(86, instance.getSerializedSize());
    assertEquals(86, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals('*', data[85]);
    assertEquals(':', data[76]);
    assertEquals('A', data[3]);
    assertEquals('A', data[5]);
    assertEquals('A', data[7]);
    assertEquals('A', data[72]);
    assertEquals('A', data[74]);
    assertEquals('A', data[9]);
    assertEquals('X', data[69]);
    assertEquals('X', data[71]);
    assertEquals('X', data[73]);
    assertEquals('X', data[75]);
    assertEquals('\b', data[2]);
    assertEquals('\r', data[13]);
    assertEquals('o', data[Short.SIZE]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight28() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAssetIssuedID(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[69]);
    assertEquals((byte) -126, data[Short.SIZE]);
    assertEquals((byte) -48, data[72]);
    assertEquals((byte) -54, data[75]);
    assertEquals((byte) -6, data[0]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[71]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 16, data[14]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[79]);
    assertEquals((byte) 1, data[81]);
    assertEquals((byte) 1, data[83]);
    assertEquals((byte) 1, data[85]);
    assertEquals((byte) 26, data[3]);
    assertEquals((byte) 2, data[13]);
    assertEquals((byte) 2, data[73]);
    assertEquals((byte) 3, data[76]);
    assertEquals((byte) 5, data[4]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(86, instance.getSerializedSize());
    assertEquals(86, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[10]);
    assertEquals('*', data[74]);
    assertEquals(':', data[12]);
    assertEquals('A', data[78]);
    assertEquals('A', data[80]);
    assertEquals('A', data[82]);
    assertEquals('A', data[84]);
    assertEquals('\b', data[77]);
    assertEquals('\r', data[2]);
    assertEquals('e', data[8]);
    assertEquals('n', data[7]);
    assertEquals('o', data[5]);
    assertEquals('r', data[9]);
    assertEquals('w', data[6]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight29() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAllowance(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[71]);
    assertEquals((byte) -48, data[74]);
    assertEquals((byte) -6, data[2]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[73]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 16, data[69]);
    assertEquals((byte) 16, data[Short.SIZE]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 26, data[5]);
    assertEquals((byte) 2, data[15]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[75]);
    assertEquals((byte) 5, data[6]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(77, instance.getSerializedSize());
    assertEquals(77, data.length);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[12]);
    assertEquals('*', data[76]);
    assertEquals(':', data[14]);
    assertEquals('X', data[0]);
    assertEquals('\r', data[4]);
    assertEquals('e', data[10]);
    assertEquals('n', data[9]);
    assertEquals('o', data[7]);
    assertEquals('r', data[11]);
    assertEquals('w', data[8]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight30() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setLatestWithdrawTime(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[71]);
    assertEquals((byte) -48, data[74]);
    assertEquals((byte) -6, data[2]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[73]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 16, data[69]);
    assertEquals((byte) 16, data[Short.SIZE]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 26, data[5]);
    assertEquals((byte) 2, data[15]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[75]);
    assertEquals((byte) 5, data[6]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(77, instance.getSerializedSize());
    assertEquals(77, data.length);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[12]);
    assertEquals('*', data[76]);
    assertEquals(':', data[14]);
    assertEquals('\r', data[4]);
    assertEquals('`', data[0]);
    assertEquals('e', data[10]);
    assertEquals('n', data[9]);
    assertEquals('o', data[7]);
    assertEquals('r', data[11]);
    assertEquals('w', data[8]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight31() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setIsWitness(true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[71]);
    assertEquals((byte) -48, data[74]);
    assertEquals((byte) -6, data[2]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[73]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 16, data[69]);
    assertEquals((byte) 16, data[Short.SIZE]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 26, data[5]);
    assertEquals((byte) 2, data[15]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[75]);
    assertEquals((byte) 5, data[6]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(77, instance.getSerializedSize());
    assertEquals(77, data.length);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[12]);
    assertEquals('*', data[76]);
    assertEquals(':', data[14]);
    assertEquals('\r', data[4]);
    assertEquals('e', data[10]);
    assertEquals('n', data[9]);
    assertEquals('o', data[7]);
    assertEquals('p', data[0]);
    assertEquals('r', data[11]);
    assertEquals('w', data[8]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight32() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setIsCommittee(true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[71]);
    assertEquals((byte) -48, data[74]);
    assertEquals((byte) -6, data[2]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[73]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 16, data[69]);
    assertEquals((byte) 16, data[Short.SIZE]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 26, data[5]);
    assertEquals((byte) 2, data[15]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[75]);
    assertEquals((byte) 5, data[6]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(77, instance.getSerializedSize());
    assertEquals(77, data.length);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[12]);
    assertEquals('*', data[76]);
    assertEquals(':', data[14]);
    assertEquals('\r', data[4]);
    assertEquals('e', data[10]);
    assertEquals('n', data[9]);
    assertEquals('o', data[7]);
    assertEquals('r', data[11]);
    assertEquals('w', data[8]);
    assertEquals('x', data[0]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight33() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setFrozen(42L, 1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[75]);
    assertEquals((byte) -48, data[78]);
    assertEquals((byte) -6, data[6]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[77]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 16, data[4]);
    assertEquals((byte) 16, data[73]);
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 1, data[7]);
    assertEquals((byte) 1, data[74]);
    assertEquals((byte) 26, data[9]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[76]);
    assertEquals((byte) 2, data[79]);
    assertEquals((byte) 4, data[1]);
    assertEquals((byte) 5, data[10]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(81, instance.getSerializedSize());
    assertEquals(81, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[Short.SIZE]);
    assertEquals('*', data[3]);
    assertEquals('*', data[80]);
    assertEquals(':', data[0]);
    assertEquals(':', data[71]);
    assertEquals('A', data[69]);
    assertEquals('\b', data[2]);
    assertEquals('\r', data[8]);
    assertEquals('e', data[14]);
    assertEquals('n', data[13]);
    assertEquals('o', data[11]);
    assertEquals('r', data[15]);
    assertEquals('w', data[12]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight34() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setNetUsage(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[71]);
    assertEquals((byte) -48, data[74]);
    assertEquals((byte) -6, data[2]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[73]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 16, data[69]);
    assertEquals((byte) 16, data[Short.SIZE]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 26, data[5]);
    assertEquals((byte) 2, data[15]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[75]);
    assertEquals((byte) 5, data[6]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(77, instance.getSerializedSize());
    assertEquals(77, data.length);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[12]);
    assertEquals('*', data[76]);
    assertEquals(':', data[14]);
    assertEquals('@', data[0]);
    assertEquals('\r', data[4]);
    assertEquals('e', data[10]);
    assertEquals('n', data[9]);
    assertEquals('o', data[7]);
    assertEquals('r', data[11]);
    assertEquals('w', data[8]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight35() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setFreeNetUsage(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -104, data[0]);
    assertEquals((byte) -110, data[72]);
    assertEquals((byte) -48, data[75]);
    assertEquals((byte) -6, data[3]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[74]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[14]);
    assertEquals((byte) 1, data[2]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[71]);
    assertEquals((byte) 26, data[6]);
    assertEquals((byte) 2, data[69]);
    assertEquals((byte) 2, data[73]);
    assertEquals((byte) 2, data[76]);
    assertEquals((byte) 2, data[Short.SIZE]);
    assertEquals((byte) 5, data[7]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(78, instance.getSerializedSize());
    assertEquals(78, data.length);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[13]);
    assertEquals('*', data[77]);
    assertEquals(':', data[15]);
    assertEquals('\r', data[5]);
    assertEquals('e', data[11]);
    assertEquals('n', data[10]);
    assertEquals('o', data[8]);
    assertEquals('r', data[12]);
    assertEquals('w', data[9]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight36() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setNewWindowSize(Common.ResourceCode.BANDWIDTH, 3L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[72]);
    assertEquals((byte) -48, data[75]);
    assertEquals((byte) -64, data[0]);
    assertEquals((byte) -6, data[3]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[74]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[14]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[71]);
    assertEquals((byte) 26, data[6]);
    assertEquals((byte) 2, data[69]);
    assertEquals((byte) 2, data[73]);
    assertEquals((byte) 2, data[76]);
    assertEquals((byte) 2, data[Short.SIZE]);
    assertEquals((byte) 3, data[2]);
    assertEquals((byte) 5, data[7]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(78, instance.getSerializedSize());
    assertEquals(78, data.length);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[13]);
    assertEquals('*', data[77]);
    assertEquals(':', data[15]);
    assertEquals('\r', data[5]);
    assertEquals('e', data[11]);
    assertEquals('n', data[10]);
    assertEquals('o', data[8]);
    assertEquals('r', data[12]);
    assertEquals('w', data[9]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Protocol.Account.UnFreezeV2, Repository)}
   */
  @Test
  public void testUpdateFrozenInfoAndTotalResourceWeight37() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setWindowOptimized(Common.ResourceCode.BANDWIDTH, true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    Protocol.Account.UnFreezeV2 unFreezeV2 = Protocol.Account.UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[72]);
    assertEquals((byte) -48, data[75]);
    assertEquals((byte) -56, data[0]);
    assertEquals((byte) -6, data[3]);
    assertEquals(0, getResult.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0L, getResult.getAmount());
    assertEquals((byte) 0, data[74]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[14]);
    assertEquals((byte) 1, data[2]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[71]);
    assertEquals((byte) 26, data[6]);
    assertEquals((byte) 2, data[69]);
    assertEquals((byte) 2, data[73]);
    assertEquals((byte) 2, data[76]);
    assertEquals((byte) 2, data[Short.SIZE]);
    assertEquals((byte) 5, data[7]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(78, instance.getSerializedSize());
    assertEquals(78, data.length);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(getResult, getResult.getDefaultInstanceForType());
    assertEquals(' ', data[13]);
    assertEquals('*', data[77]);
    assertEquals(':', data[15]);
    assertEquals('\r', data[5]);
    assertEquals('e', data[11]);
    assertEquals('n', data[10]);
    assertEquals('o', data[8]);
    assertEquals('r', data[12]);
    assertEquals('w', data[9]);
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(account, instance.getDefaultInstanceForType());
  }
}
