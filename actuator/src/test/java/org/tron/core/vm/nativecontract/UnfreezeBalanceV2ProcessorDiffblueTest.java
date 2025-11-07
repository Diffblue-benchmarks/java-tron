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
import org.tron.core.vm.nativecontract.param.UnfreezeBalanceV2Param;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;
import org.tron.protos.contract.AccountContract;
import org.tron.protos.contract.Common;

public class UnfreezeBalanceV2ProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#validate(UnfreezeBalanceV2Param, Repository)}
   */
  @Test
  public void testValidate() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();

    UnfreezeBalanceV2Param param = new UnfreezeBalanceV2Param();
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    param.setUnfreezeBalance(42L);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> unfreezeBalanceV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#validate(UnfreezeBalanceV2Param, Repository)}
   */
  @Test
  public void testValidate2() throws ContractValidateException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();

    UnfreezeBalanceV2Param param = new UnfreezeBalanceV2Param();
    param.setOwnerAddress(new byte[]{21, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    param.setUnfreezeBalance(42L);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> unfreezeBalanceV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#validate(UnfreezeBalanceV2Param, Repository)}
   */
  @Test
  public void testValidate3() throws ContractValidateException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();

    UnfreezeBalanceV2Param param = new UnfreezeBalanceV2Param();
    param.setOwnerAddress(null);
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    param.setUnfreezeBalance(42L);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> unfreezeBalanceV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#validate(UnfreezeBalanceV2Param, Repository)}
   */
  @Test
  public void testValidate4() throws ContractValidateException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();

    UnfreezeBalanceV2Param param = new UnfreezeBalanceV2Param();
    param.setOwnerAddress(new byte[]{});
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    param.setUnfreezeBalance(42L);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> unfreezeBalanceV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#validate(UnfreezeBalanceV2Param, Repository)}
   */
  @Test
  public void testValidate5() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();

    UnfreezeBalanceV2Param param = new UnfreezeBalanceV2Param();
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    param.setUnfreezeBalance(42L);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> unfreezeBalanceV2Processor.validate(param, null));
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();
    AccountCapsule accountCapsule = new AccountCapsule(account);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getAllTronPower());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getTronPower());
    assertEquals(-42L, getResult.getAmount());
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
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
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
    assertArrayEquals(new byte[]{-110, 2, 11, 16, -42, -1, -1, -1, -1, -1, -1, -1, -1, 1}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight2() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    AccountCapsule accountCapsule = new AccountCapsule(AccountContract.AccountCreateContract.getDefaultInstance());
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getAllTronPower());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getTronPower());
    assertEquals(-42L, getResult.getAmount());
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
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
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
    assertArrayEquals(new byte[]{-110, 2, 11, 16, -42, -1, -1, -1, -1, -1, -1, -1, -1, 1}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight3() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
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
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(17, instance.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
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
    assertArrayEquals(new byte[]{-110, 2, 11, 16, -42, -1, -1, -1, -1, -1, -1, -1, -1, 1, -48, 2, '*'},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight4() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addDelegatedFrozenV2BalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
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
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(17, instance.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
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
    assertArrayEquals(new byte[]{-110, 2, 11, 16, -42, -1, -1, -1, -1, -1, -1, -1, -1, 1, -96, 2, '*'},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight5() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addFrozenBalanceForBandwidthV2(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
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
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight6() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAcquiredDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(-42L, accountCapsule.getAllTronPower());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getTronPower());
    assertEquals(-42L, getResult.getAmount());
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
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(17, instance.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
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
    assertArrayEquals(new byte[]{-110, 2, 11, 16, -42, -1, -1, -1, -1, -1, -1, -1, -1, 1, -56, 2, '*'},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight7() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAcquiredDelegatedFrozenV2BalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(-42L, accountCapsule.getAllTronPower());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getTronPower());
    assertEquals(-42L, getResult.getAmount());
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
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(17, instance.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
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
    assertArrayEquals(new byte[]{-110, 2, 11, 16, -42, -1, -1, -1, -1, -1, -1, -1, -1, 1, -88, 2, '*'},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight8() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAcquiredDelegatedFrozenBalanceForEnergy(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getAllTronPower());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getTronPower());
    assertEquals(-42L, getResult.getAmount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(19, instance.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(42L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
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
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-46, 1, 2, ' ', '*', -110, 2, 11, 16, -42, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight9() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addFrozenBalanceForEnergyV2(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals("FreezeV2", toProtoResult.getName());
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult2.getAmount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult2.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult2.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, getResult.getTypeValue());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult2.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(2, instance.getFrozenV2Count());
    assertEquals(21, instance.getSerializedSize());
    assertEquals(4, getResult.getSerializedSize());
    assertEquals(42L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(42L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(42L, getResult.getAmount());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult2.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertEquals(Common.ResourceCode.ENERGY, getResult.getType());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult2.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(getResult2.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(Double.SIZE, toProtoResult.getSerializedSize());
    assertSame(descriptorForType, getResult2.getDescriptorForType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    Protocol.Account.FreezeV2 defaultInstanceForType2 = defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, getResult2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-110, 2, 4, '\b', 1, 16, '*', -110, 2, 11, 16, -42, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight10() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addUnfrozenV2List(Common.ResourceCode.BANDWIDTH, 1L, 1L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getAllTronPower());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getTronPower());
    assertEquals(-42L, getResult.getAmount());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(21, instance.getSerializedSize());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
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
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{-110, 2, 11, 16, -42, -1, -1, -1, -1, -1, -1, -1, -1, 1, -102, 2, 4, 24, 1, ' ', 1},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight11() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAssetAmount(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 10L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getAllTronPower());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getTronPower());
    assertEquals(-42L, getResult.getAmount());
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
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(28, instance.getSerializedSize());
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
    assertArrayEquals(new byte[]{'2', '\f', '\n', '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1, 16, '\n', -110, 2, 11, 16, -42,
        -1, -1, -1, -1, -1, -1, -1, -1, 1}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight12() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAssetMapV2(new HashMap<>());
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getAllTronPower());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getTronPower());
    assertEquals(-42L, getResult.getAmount());
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
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
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
    assertArrayEquals(new byte[]{-110, 2, 11, 16, -42, -1, -1, -1, -1, -1, -1, -1, -1, 1}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight13() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAllLatestAssetOperationTimeV2(new HashMap<>());
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getAllTronPower());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getTronPower());
    assertEquals(-42L, getResult.getAmount());
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
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
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
    assertArrayEquals(new byte[]{-110, 2, 11, 16, -42, -1, -1, -1, -1, -1, -1, -1, -1, 1}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight14() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.putLatestAssetOperationTimeMap("Key", 42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getAllTronPower());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getTronPower());
    assertEquals(-42L, getResult.getAmount());
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
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(24, instance.getSerializedSize());
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
    assertArrayEquals(new byte[]{-110, 1, 7, '\n', 3, 'K', 'e', 'y', 16, '*', -110, 2, 11, 16, -42, -1, -1, -1, -1, -1,
        -1, -1, -1, 1}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight15() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addAllFreeAssetNetUsageV2(new HashMap<>());
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getAllTronPower());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getTronPower());
    assertEquals(-42L, getResult.getAmount());
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
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
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
    assertArrayEquals(new byte[]{-110, 2, 11, 16, -42, -1, -1, -1, -1, -1, -1, -1, -1, 1}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight16() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.putFreeAssetNetUsage("foo", 1L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getAllTronPower());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getTronPower());
    assertEquals(-42L, getResult.getAmount());
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
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(24, instance.getSerializedSize());
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
    assertArrayEquals(
        new byte[]{-94, 1, 7, '\n', 3, 'f', 'o', 'o', 16, 1, -110, 2, 11, 16, -42, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight17() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAccountName(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
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
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(27, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
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
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1, -110, 2, 11, 16, -42, -1, -1, -1, -1, -1,
        -1, -1, -1, 1, -48, 2, '*'}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight18() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAccountId(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
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
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
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
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, descriptorForType.getFields().size());
    assertEquals(28, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
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
    assertArrayEquals(new byte[]{-70, 1, '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1, -110, 2, 11, 16, -42, -1, -1, -1, -1, -1,
        -1, -1, -1, 1, -48, 2, '*'}, accountCapsule.getData());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight19() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[69]);
    assertEquals((byte) -126, data[Short.SIZE]);
    assertEquals((byte) -1, data[74]);
    assertEquals((byte) -1, data[75]);
    assertEquals((byte) -1, data[76]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[73]);
    assertEquals((byte) -48, data[83]);
    assertEquals((byte) -6, data[0]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[71]);
    assertEquals((byte) 16, data[14]);
    assertEquals((byte) 16, data[21]);
    assertEquals((byte) 16, data[72]);
    assertEquals((byte) 19, data[18]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[20]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[82]);
    assertEquals((byte) 26, data[23]);
    assertEquals((byte) 26, data[3]);
    assertEquals((byte) 2, data[13]);
    assertEquals((byte) 2, data[17]);
    assertEquals((byte) 2, data[84]);
    assertEquals(5, instance.getAllFields().size());
    assertEquals((byte) 5, data[4]);
    assertEquals((byte) 7, data[24]);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(86, instance.getSerializedSize());
    assertEquals(86, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[10]);
    assertEquals('*', data[85]);
    assertEquals(':', data[12]);
    assertEquals('\b', data[19]);
    assertEquals('\r', data[2]);
    assertEquals('e', data[8]);
    assertEquals('n', data[7]);
    assertEquals('o', data[5]);
    assertEquals('r', data[9]);
    assertEquals('w', data[6]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight20() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.ENERGY, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[69]);
    assertEquals((byte) -126, data[Short.SIZE]);
    assertEquals((byte) -1, data[76]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[75]);
    assertEquals((byte) -48, data[85]);
    assertEquals((byte) -6, data[0]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    assertEquals(1, getResult.getTypeValue());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(13, getResult.getSerializedSize());
    assertEquals((byte) 16, data[14]);
    assertEquals((byte) 16, data[21]);
    assertEquals((byte) 16, data[74]);
    assertEquals((byte) 19, data[18]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[20]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[73]);
    assertEquals((byte) 1, data[84]);
    assertEquals(2, getResult.getAllFields().size());
    assertEquals((byte) 26, data[23]);
    assertEquals((byte) 26, data[3]);
    assertEquals((byte) 2, data[13]);
    assertEquals((byte) 2, data[17]);
    assertEquals((byte) 2, data[86]);
    assertEquals(5, instance.getAllFields().size());
    assertEquals((byte) 5, data[4]);
    assertEquals((byte) 7, data[24]);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(88, instance.getSerializedSize());
    assertEquals(88, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertEquals(Common.ResourceCode.ENERGY, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[10]);
    assertEquals('*', data[87]);
    assertEquals(':', data[12]);
    assertEquals('\b', data[19]);
    assertEquals('\b', data[72]);
    assertEquals('\r', data[2]);
    assertEquals('\r', data[71]);
    assertEquals('e', data[8]);
    assertEquals('n', data[7]);
    assertEquals('o', data[5]);
    assertEquals('r', data[9]);
    assertEquals('w', data[6]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight21() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.TRON_POWER, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[69]);
    assertEquals((byte) -126, data[Short.SIZE]);
    assertEquals((byte) -1, data[76]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals(-42L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[75]);
    assertEquals((byte) -48, data[85]);
    assertEquals((byte) -6, data[0]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAmount());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(13, getResult.getSerializedSize());
    assertEquals((byte) 16, data[14]);
    assertEquals((byte) 16, data[21]);
    assertEquals((byte) 16, data[74]);
    assertEquals((byte) 19, data[18]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[20]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[84]);
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(2, getResult.getTypeValue());
    assertEquals((byte) 26, data[23]);
    assertEquals((byte) 26, data[3]);
    assertEquals((byte) 2, data[13]);
    assertEquals((byte) 2, data[17]);
    assertEquals((byte) 2, data[73]);
    assertEquals((byte) 2, data[86]);
    assertEquals(42L, accountCapsule.getTronPower());
    assertEquals(5, instance.getAllFields().size());
    assertEquals((byte) 5, data[4]);
    assertEquals((byte) 7, data[24]);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(88, instance.getSerializedSize());
    assertEquals(88, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertEquals(Common.ResourceCode.TRON_POWER, getResult.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[10]);
    assertEquals('*', data[87]);
    assertEquals(':', data[12]);
    assertEquals('\b', data[19]);
    assertEquals('\b', data[72]);
    assertEquals('\r', data[2]);
    assertEquals('\r', data[71]);
    assertEquals('e', data[8]);
    assertEquals('n', data[7]);
    assertEquals('o', data[5]);
    assertEquals('r', data[9]);
    assertEquals('w', data[6]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight22() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.UNRECOGNIZED, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)));

    // Assert that nothing has changed
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -126, data[Short.SIZE]);
    assertEquals((byte) -48, data[69]);
    assertEquals((byte) -6, data[0]);
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(0, instance.getFrozenV2Count());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(10, instance.getDescriptorForType().getNestedTypes().size());
    assertEquals((byte) 16, data[14]);
    assertEquals((byte) 16, data[21]);
    assertEquals((byte) 19, data[18]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[20]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 26, data[23]);
    assertEquals((byte) 26, data[3]);
    assertEquals((byte) 2, data[13]);
    assertEquals((byte) 2, data[17]);
    assertEquals(4, instance.getAllFields().size());
    assertEquals(42L, accountCapsule.getAllTronPower());
    assertEquals(42L, accountCapsule.getTronPower());
    assertEquals((byte) 5, data[4]);
    assertEquals(72, instance.getSerializedSize());
    assertEquals(72, data.length);
    assertEquals((byte) 7, data[24]);
    assertEquals(' ', data[10]);
    assertEquals('*', data[71]);
    assertEquals(':', data[12]);
    assertEquals('\b', data[19]);
    assertEquals('\r', data[2]);
    assertEquals('e', data[8]);
    assertEquals('n', data[7]);
    assertEquals('o', data[5]);
    assertEquals('r', data[9]);
    assertEquals('w', data[6]);
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight23() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(new BytesCapsule(new byte[]{}));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[69]);
    assertEquals((byte) -126, data[Short.SIZE]);
    assertEquals((byte) -1, data[74]);
    assertEquals((byte) -1, data[75]);
    assertEquals((byte) -1, data[76]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[73]);
    assertEquals((byte) -48, data[83]);
    assertEquals((byte) -6, data[0]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[71]);
    assertEquals((byte) 16, data[14]);
    assertEquals((byte) 16, data[21]);
    assertEquals((byte) 16, data[72]);
    assertEquals((byte) 19, data[18]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[20]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[82]);
    assertEquals((byte) 26, data[23]);
    assertEquals((byte) 26, data[3]);
    assertEquals((byte) 2, data[13]);
    assertEquals((byte) 2, data[17]);
    assertEquals((byte) 2, data[84]);
    assertEquals(5, instance.getAllFields().size());
    assertEquals((byte) 5, data[4]);
    assertEquals((byte) 7, data[24]);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(86, instance.getSerializedSize());
    assertEquals(86, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[10]);
    assertEquals('*', data[85]);
    assertEquals(':', data[12]);
    assertEquals('\b', data[19]);
    assertEquals('\r', data[2]);
    assertEquals('e', data[8]);
    assertEquals('n', data[7]);
    assertEquals('o', data[5]);
    assertEquals('r', data[9]);
    assertEquals('w', data[6]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight24() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
            new RepositoryImpl(StoreFactory.getInstance(), repository)));
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight25() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setBalance(42L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[71]);
    assertEquals((byte) -126, data[18]);
    assertEquals((byte) -1, data[76]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[75]);
    assertEquals((byte) -48, data[85]);
    assertEquals((byte) -6, data[2]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[73]);
    assertEquals((byte) 16, data[23]);
    assertEquals((byte) 16, data[69]);
    assertEquals((byte) 16, data[74]);
    assertEquals((byte) 16, data[Short.SIZE]);
    assertEquals((byte) 19, data[20]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[24]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[84]);
    assertEquals((byte) 26, data[5]);
    assertEquals((byte) 2, data[15]);
    assertEquals((byte) 2, data[19]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[86]);
    assertEquals((byte) 5, data[6]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(88, instance.getSerializedSize());
    assertEquals(88, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[0]);
    assertEquals(' ', data[12]);
    assertEquals('*', data[1]);
    assertEquals('*', data[87]);
    assertEquals(':', data[14]);
    assertEquals('\b', data[21]);
    assertEquals('\r', data[4]);
    assertEquals('e', data[10]);
    assertEquals('n', data[9]);
    assertEquals('o', data[7]);
    assertEquals('r', data[11]);
    assertEquals('w', data[8]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight26() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setLatestOperationTime(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[71]);
    assertEquals((byte) -126, data[18]);
    assertEquals((byte) -1, data[76]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[75]);
    assertEquals((byte) -48, data[85]);
    assertEquals((byte) -6, data[2]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[73]);
    assertEquals((byte) 16, data[23]);
    assertEquals((byte) 16, data[69]);
    assertEquals((byte) 16, data[74]);
    assertEquals((byte) 16, data[Short.SIZE]);
    assertEquals((byte) 19, data[20]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[24]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[84]);
    assertEquals((byte) 26, data[5]);
    assertEquals((byte) 2, data[15]);
    assertEquals((byte) 2, data[19]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[86]);
    assertEquals((byte) 5, data[6]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(88, instance.getSerializedSize());
    assertEquals(88, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[12]);
    assertEquals('*', data[87]);
    assertEquals(':', data[14]);
    assertEquals('P', data[0]);
    assertEquals('\b', data[21]);
    assertEquals('\r', data[4]);
    assertEquals('e', data[10]);
    assertEquals('n', data[9]);
    assertEquals('o', data[7]);
    assertEquals('r', data[11]);
    assertEquals('w', data[8]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight27() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setLatestConsumeTime(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[72]);
    assertEquals((byte) -126, data[19]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals((byte) -1, data[84]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[76]);
    assertEquals((byte) -48, data[86]);
    assertEquals((byte) -6, data[3]);
    assertEquals((byte) -88, data[0]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[74]);
    assertEquals((byte) 16, data[17]);
    assertEquals((byte) 16, data[24]);
    assertEquals((byte) 16, data[75]);
    assertEquals((byte) 19, data[21]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[14]);
    assertEquals((byte) 1, data[18]);
    assertEquals((byte) 1, data[2]);
    assertEquals((byte) 1, data[23]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[71]);
    assertEquals((byte) 1, data[85]);
    assertEquals((byte) 26, data[6]);
    assertEquals((byte) 2, data[20]);
    assertEquals((byte) 2, data[69]);
    assertEquals((byte) 2, data[73]);
    assertEquals((byte) 2, data[87]);
    assertEquals((byte) 2, data[Short.SIZE]);
    assertEquals((byte) 5, data[7]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(89, instance.getSerializedSize());
    assertEquals(89, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[13]);
    assertEquals('*', data[88]);
    assertEquals(':', data[15]);
    assertEquals('\b', data[22]);
    assertEquals('\r', data[5]);
    assertEquals('e', data[11]);
    assertEquals('n', data[10]);
    assertEquals('o', data[8]);
    assertEquals('r', data[12]);
    assertEquals('w', data[9]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight28() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setLatestConsumeFreeTime(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[72]);
    assertEquals((byte) -126, data[19]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals((byte) -1, data[84]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[76]);
    assertEquals((byte) -48, data[86]);
    assertEquals((byte) -6, data[3]);
    assertEquals((byte) -80, data[0]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[74]);
    assertEquals((byte) 16, data[17]);
    assertEquals((byte) 16, data[24]);
    assertEquals((byte) 16, data[75]);
    assertEquals((byte) 19, data[21]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[14]);
    assertEquals((byte) 1, data[18]);
    assertEquals((byte) 1, data[2]);
    assertEquals((byte) 1, data[23]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[71]);
    assertEquals((byte) 1, data[85]);
    assertEquals((byte) 26, data[6]);
    assertEquals((byte) 2, data[20]);
    assertEquals((byte) 2, data[69]);
    assertEquals((byte) 2, data[73]);
    assertEquals((byte) 2, data[87]);
    assertEquals((byte) 2, data[Short.SIZE]);
    assertEquals((byte) 5, data[7]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(89, instance.getSerializedSize());
    assertEquals(89, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[13]);
    assertEquals('*', data[88]);
    assertEquals(':', data[15]);
    assertEquals('\b', data[22]);
    assertEquals('\r', data[5]);
    assertEquals('e', data[11]);
    assertEquals('n', data[10]);
    assertEquals('o', data[8]);
    assertEquals('r', data[12]);
    assertEquals('w', data[9]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight29() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAssetOptimized(true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[69]);
    assertEquals((byte) -126, data[Short.SIZE]);
    assertEquals((byte) -1, data[74]);
    assertEquals((byte) -1, data[75]);
    assertEquals((byte) -1, data[76]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -32, data[86]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[73]);
    assertEquals((byte) -48, data[83]);
    assertEquals((byte) -6, data[0]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[71]);
    assertEquals((byte) 16, data[14]);
    assertEquals((byte) 16, data[21]);
    assertEquals((byte) 16, data[72]);
    assertEquals((byte) 19, data[18]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[20]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[82]);
    assertEquals((byte) 1, data[88]);
    assertEquals((byte) 26, data[23]);
    assertEquals((byte) 26, data[3]);
    assertEquals((byte) 2, data[13]);
    assertEquals((byte) 2, data[17]);
    assertEquals((byte) 2, data[84]);
    assertEquals((byte) 3, data[87]);
    assertEquals((byte) 5, data[4]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals((byte) 7, data[24]);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(89, instance.getSerializedSize());
    assertEquals(89, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[10]);
    assertEquals('*', data[85]);
    assertEquals(':', data[12]);
    assertEquals('\b', data[19]);
    assertEquals('\r', data[2]);
    assertEquals('e', data[8]);
    assertEquals('n', data[7]);
    assertEquals('o', data[5]);
    assertEquals('r', data[9]);
    assertEquals('w', data[6]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight30() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAssetIssuedName(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[80]);
    assertEquals((byte) -118, data[0]);
    assertEquals((byte) -1, data[85]);
    assertEquals((byte) -1, data[86]);
    assertEquals((byte) -1, data[87]);
    assertEquals((byte) -1, data[88]);
    assertEquals((byte) -1, data[89]);
    assertEquals((byte) -1, data[90]);
    assertEquals((byte) -1, data[91]);
    assertEquals((byte) -1, data[92]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[84]);
    assertEquals((byte) -48, data[94]);
    assertEquals((byte) -6, data[11]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[82]);
    assertEquals((byte) 16, data[78]);
    assertEquals((byte) 16, data[83]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[10]);
    assertEquals((byte) 1, data[12]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[6]);
    assertEquals((byte) 1, data[79]);
    assertEquals((byte) 1, data[8]);
    assertEquals((byte) 1, data[93]);
    assertEquals((byte) 26, data[14]);
    assertEquals((byte) 2, data[24]);
    assertEquals((byte) 2, data[77]);
    assertEquals((byte) 2, data[81]);
    assertEquals((byte) 2, data[95]);
    assertEquals((byte) 5, data[15]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(97, instance.getSerializedSize());
    assertEquals(97, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[21]);
    assertEquals('*', data[96]);
    assertEquals(':', data[23]);
    assertEquals(':', data[76]);
    assertEquals('A', data[3]);
    assertEquals('A', data[5]);
    assertEquals('A', data[7]);
    assertEquals('A', data[72]);
    assertEquals('A', data[74]);
    assertEquals('A', data[9]);
    assertEquals('X', data[73]);
    assertEquals('X', data[75]);
    assertEquals('\b', data[2]);
    assertEquals('\r', data[13]);
    assertEquals('e', data[19]);
    assertEquals('n', data[18]);
    assertEquals('o', data[Short.SIZE]);
    assertEquals('r', data[20]);
    assertEquals('w', data[17]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight31() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAssetIssuedID(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -126, data[Short.SIZE]);
    assertEquals((byte) -1, data[74]);
    assertEquals((byte) -1, data[75]);
    assertEquals((byte) -1, data[76]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[73]);
    assertEquals((byte) -48, data[83]);
    assertEquals((byte) -54, data[86]);
    assertEquals((byte) -6, data[0]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 16, data[14]);
    assertEquals((byte) 16, data[21]);
    assertEquals((byte) 16, data[72]);
    assertEquals((byte) 19, data[18]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[20]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[82]);
    assertEquals((byte) 1, data[90]);
    assertEquals((byte) 1, data[92]);
    assertEquals((byte) 1, data[94]);
    assertEquals((byte) 1, data[96]);
    assertEquals((byte) 26, data[23]);
    assertEquals((byte) 26, data[3]);
    assertEquals((byte) 2, data[13]);
    assertEquals((byte) 2, data[17]);
    assertEquals((byte) 2, data[84]);
    assertEquals((byte) 3, data[87]);
    assertEquals((byte) 5, data[4]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals((byte) 7, data[24]);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(97, instance.getSerializedSize());
    assertEquals(97, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[10]);
    assertEquals('*', data[85]);
    assertEquals(':', data[12]);
    assertEquals('A', data[89]);
    assertEquals('A', data[91]);
    assertEquals('A', data[93]);
    assertEquals('A', data[95]);
    assertEquals('\b', data[19]);
    assertEquals('\b', data[88]);
    assertEquals('\r', data[2]);
    assertEquals('e', data[8]);
    assertEquals('n', data[7]);
    assertEquals('o', data[5]);
    assertEquals('r', data[9]);
    assertEquals('w', data[6]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight32() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setAllowance(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[71]);
    assertEquals((byte) -126, data[18]);
    assertEquals((byte) -1, data[76]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[75]);
    assertEquals((byte) -48, data[85]);
    assertEquals((byte) -6, data[2]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[73]);
    assertEquals((byte) 16, data[23]);
    assertEquals((byte) 16, data[69]);
    assertEquals((byte) 16, data[74]);
    assertEquals((byte) 16, data[Short.SIZE]);
    assertEquals((byte) 19, data[20]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[24]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[84]);
    assertEquals((byte) 26, data[5]);
    assertEquals((byte) 2, data[15]);
    assertEquals((byte) 2, data[19]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[86]);
    assertEquals((byte) 5, data[6]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(88, instance.getSerializedSize());
    assertEquals(88, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[12]);
    assertEquals('*', data[87]);
    assertEquals(':', data[14]);
    assertEquals('X', data[0]);
    assertEquals('\b', data[21]);
    assertEquals('\r', data[4]);
    assertEquals('e', data[10]);
    assertEquals('n', data[9]);
    assertEquals('o', data[7]);
    assertEquals('r', data[11]);
    assertEquals('w', data[8]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight33() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setLatestWithdrawTime(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[71]);
    assertEquals((byte) -126, data[18]);
    assertEquals((byte) -1, data[76]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[75]);
    assertEquals((byte) -48, data[85]);
    assertEquals((byte) -6, data[2]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[73]);
    assertEquals((byte) 16, data[23]);
    assertEquals((byte) 16, data[69]);
    assertEquals((byte) 16, data[74]);
    assertEquals((byte) 16, data[Short.SIZE]);
    assertEquals((byte) 19, data[20]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[24]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[84]);
    assertEquals((byte) 26, data[5]);
    assertEquals((byte) 2, data[15]);
    assertEquals((byte) 2, data[19]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[86]);
    assertEquals((byte) 5, data[6]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(88, instance.getSerializedSize());
    assertEquals(88, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[12]);
    assertEquals('*', data[87]);
    assertEquals(':', data[14]);
    assertEquals('\b', data[21]);
    assertEquals('\r', data[4]);
    assertEquals('`', data[0]);
    assertEquals('e', data[10]);
    assertEquals('n', data[9]);
    assertEquals('o', data[7]);
    assertEquals('r', data[11]);
    assertEquals('w', data[8]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight34() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setIsWitness(true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[71]);
    assertEquals((byte) -126, data[18]);
    assertEquals((byte) -1, data[76]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[75]);
    assertEquals((byte) -48, data[85]);
    assertEquals((byte) -6, data[2]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[73]);
    assertEquals((byte) 16, data[23]);
    assertEquals((byte) 16, data[69]);
    assertEquals((byte) 16, data[74]);
    assertEquals((byte) 16, data[Short.SIZE]);
    assertEquals((byte) 19, data[20]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[24]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[84]);
    assertEquals((byte) 26, data[5]);
    assertEquals((byte) 2, data[15]);
    assertEquals((byte) 2, data[19]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[86]);
    assertEquals((byte) 5, data[6]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(88, instance.getSerializedSize());
    assertEquals(88, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[12]);
    assertEquals('*', data[87]);
    assertEquals(':', data[14]);
    assertEquals('\b', data[21]);
    assertEquals('\r', data[4]);
    assertEquals('e', data[10]);
    assertEquals('n', data[9]);
    assertEquals('o', data[7]);
    assertEquals('p', data[0]);
    assertEquals('r', data[11]);
    assertEquals('w', data[8]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight35() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setIsCommittee(true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[71]);
    assertEquals((byte) -126, data[18]);
    assertEquals((byte) -1, data[76]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[75]);
    assertEquals((byte) -48, data[85]);
    assertEquals((byte) -6, data[2]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[73]);
    assertEquals((byte) 16, data[23]);
    assertEquals((byte) 16, data[69]);
    assertEquals((byte) 16, data[74]);
    assertEquals((byte) 16, data[Short.SIZE]);
    assertEquals((byte) 19, data[20]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[24]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[84]);
    assertEquals((byte) 26, data[5]);
    assertEquals((byte) 2, data[15]);
    assertEquals((byte) 2, data[19]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[86]);
    assertEquals((byte) 5, data[6]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(88, instance.getSerializedSize());
    assertEquals(88, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[12]);
    assertEquals('*', data[87]);
    assertEquals(':', data[14]);
    assertEquals('\b', data[21]);
    assertEquals('\r', data[4]);
    assertEquals('e', data[10]);
    assertEquals('n', data[9]);
    assertEquals('o', data[7]);
    assertEquals('r', data[11]);
    assertEquals('w', data[8]);
    assertEquals('x', data[0]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight36() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setFrozen(42L, 1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[75]);
    assertEquals((byte) -126, data[22]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals((byte) -1, data[84]);
    assertEquals((byte) -1, data[85]);
    assertEquals((byte) -1, data[86]);
    assertEquals((byte) -1, data[87]);
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[79]);
    assertEquals((byte) -48, data[89]);
    assertEquals((byte) -6, data[6]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[77]);
    assertEquals((byte) 16, data[20]);
    assertEquals((byte) 16, data[4]);
    assertEquals((byte) 16, data[73]);
    assertEquals((byte) 16, data[78]);
    assertEquals((byte) 19, data[24]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[21]);
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 1, data[7]);
    assertEquals((byte) 1, data[74]);
    assertEquals((byte) 1, data[88]);
    assertEquals((byte) 26, data[9]);
    assertEquals((byte) 2, data[19]);
    assertEquals((byte) 2, data[23]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[76]);
    assertEquals((byte) 2, data[90]);
    assertEquals(42L, accountCapsule.getAllTronPower());
    assertEquals(42L, accountCapsule.getTronPower());
    assertEquals((byte) 4, data[1]);
    assertEquals((byte) 5, data[10]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(92, instance.getSerializedSize());
    assertEquals(92, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[Short.SIZE]);
    assertEquals('*', data[3]);
    assertEquals('*', data[91]);
    assertEquals(':', data[0]);
    assertEquals(':', data[18]);
    assertEquals(':', data[71]);
    assertEquals('A', data[69]);
    assertEquals('\b', data[2]);
    assertEquals('\r', data[8]);
    assertEquals('e', data[14]);
    assertEquals('n', data[13]);
    assertEquals('o', data[11]);
    assertEquals('r', data[15]);
    assertEquals('w', data[12]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight37() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setNetUsage(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[71]);
    assertEquals((byte) -126, data[18]);
    assertEquals((byte) -1, data[76]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[75]);
    assertEquals((byte) -48, data[85]);
    assertEquals((byte) -6, data[2]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[73]);
    assertEquals((byte) 16, data[23]);
    assertEquals((byte) 16, data[69]);
    assertEquals((byte) 16, data[74]);
    assertEquals((byte) 16, data[Short.SIZE]);
    assertEquals((byte) 19, data[20]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[13]);
    assertEquals((byte) 1, data[17]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[24]);
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[84]);
    assertEquals((byte) 26, data[5]);
    assertEquals((byte) 2, data[15]);
    assertEquals((byte) 2, data[19]);
    assertEquals((byte) 2, data[72]);
    assertEquals((byte) 2, data[86]);
    assertEquals((byte) 5, data[6]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(88, instance.getSerializedSize());
    assertEquals(88, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[12]);
    assertEquals('*', data[87]);
    assertEquals(':', data[14]);
    assertEquals('@', data[0]);
    assertEquals('\b', data[21]);
    assertEquals('\r', data[4]);
    assertEquals('e', data[10]);
    assertEquals('n', data[9]);
    assertEquals('o', data[7]);
    assertEquals('r', data[11]);
    assertEquals('w', data[8]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight38() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setFreeNetUsage(1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -104, data[0]);
    assertEquals((byte) -110, data[72]);
    assertEquals((byte) -126, data[19]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals((byte) -1, data[84]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[76]);
    assertEquals((byte) -48, data[86]);
    assertEquals((byte) -6, data[3]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[74]);
    assertEquals((byte) 16, data[17]);
    assertEquals((byte) 16, data[24]);
    assertEquals((byte) 16, data[75]);
    assertEquals((byte) 19, data[21]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[14]);
    assertEquals((byte) 1, data[18]);
    assertEquals((byte) 1, data[2]);
    assertEquals((byte) 1, data[23]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[71]);
    assertEquals((byte) 1, data[85]);
    assertEquals((byte) 26, data[6]);
    assertEquals((byte) 2, data[20]);
    assertEquals((byte) 2, data[69]);
    assertEquals((byte) 2, data[73]);
    assertEquals((byte) 2, data[87]);
    assertEquals((byte) 2, data[Short.SIZE]);
    assertEquals((byte) 5, data[7]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(89, instance.getSerializedSize());
    assertEquals(89, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[13]);
    assertEquals('*', data[88]);
    assertEquals(':', data[15]);
    assertEquals('\b', data[22]);
    assertEquals('\r', data[5]);
    assertEquals('e', data[11]);
    assertEquals('n', data[10]);
    assertEquals('o', data[8]);
    assertEquals('r', data[12]);
    assertEquals('w', data[9]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight39() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setNewWindowSize(Common.ResourceCode.BANDWIDTH, 3L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[72]);
    assertEquals((byte) -126, data[19]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals((byte) -1, data[84]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[76]);
    assertEquals((byte) -48, data[86]);
    assertEquals((byte) -64, data[0]);
    assertEquals((byte) -6, data[3]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[74]);
    assertEquals((byte) 16, data[17]);
    assertEquals((byte) 16, data[24]);
    assertEquals((byte) 16, data[75]);
    assertEquals((byte) 19, data[21]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[14]);
    assertEquals((byte) 1, data[18]);
    assertEquals((byte) 1, data[23]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[71]);
    assertEquals((byte) 1, data[85]);
    assertEquals((byte) 26, data[6]);
    assertEquals((byte) 2, data[20]);
    assertEquals((byte) 2, data[69]);
    assertEquals((byte) 2, data[73]);
    assertEquals((byte) 2, data[87]);
    assertEquals((byte) 2, data[Short.SIZE]);
    assertEquals((byte) 3, data[2]);
    assertEquals((byte) 5, data[7]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(89, instance.getSerializedSize());
    assertEquals(89, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[13]);
    assertEquals('*', data[88]);
    assertEquals(':', data[15]);
    assertEquals('\b', data[22]);
    assertEquals('\r', data[5]);
    assertEquals('e', data[11]);
    assertEquals('n', data[10]);
    assertEquals('o', data[8]);
    assertEquals('r', data[12]);
    assertEquals('w', data[9]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight40() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.setWindowOptimized(Common.ResourceCode.BANDWIDTH, true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.BANDWIDTH, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(1, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[72]);
    assertEquals((byte) -126, data[19]);
    assertEquals((byte) -1, data[77]);
    assertEquals((byte) -1, data[78]);
    assertEquals((byte) -1, data[79]);
    assertEquals((byte) -1, data[80]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals((byte) -1, data[84]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(-42L, getResult.getAmount());
    assertEquals((byte) -42, data[76]);
    assertEquals((byte) -48, data[86]);
    assertEquals((byte) -56, data[0]);
    assertEquals((byte) -6, data[3]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getAllTronPower());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, accountCapsule.getTronPower());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    assertEquals(1, instance.getFrozenV2Count());
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals((byte) 11, data[74]);
    assertEquals((byte) 16, data[17]);
    assertEquals((byte) 16, data[24]);
    assertEquals((byte) 16, data[75]);
    assertEquals((byte) 19, data[21]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[14]);
    assertEquals((byte) 1, data[18]);
    assertEquals((byte) 1, data[2]);
    assertEquals((byte) 1, data[23]);
    assertEquals((byte) 1, data[4]);
    assertEquals((byte) 1, data[71]);
    assertEquals((byte) 1, data[85]);
    assertEquals((byte) 26, data[6]);
    assertEquals((byte) 2, data[20]);
    assertEquals((byte) 2, data[69]);
    assertEquals((byte) 2, data[73]);
    assertEquals((byte) 2, data[87]);
    assertEquals((byte) 2, data[Short.SIZE]);
    assertEquals((byte) 5, data[7]);
    assertEquals(6, instance.getAllFields().size());
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(89, instance.getSerializedSize());
    assertEquals(89, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[13]);
    assertEquals('*', data[88]);
    assertEquals(':', data[15]);
    assertEquals('\b', data[22]);
    assertEquals('\r', data[5]);
    assertEquals('e', data[11]);
    assertEquals('n', data[10]);
    assertEquals('o', data[8]);
    assertEquals('r', data[12]);
    assertEquals('w', data[9]);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight41() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addFrozenBalanceForBandwidthV2(42L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.ENERGY, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(2, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 getResult2 = frozenV2List.get(1);
    assertEquals("", getResult2.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[69]);
    assertEquals((byte) -110, data[74]);
    assertEquals((byte) -126, data[Short.SIZE]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals((byte) -1, data[84]);
    assertEquals((byte) -1, data[85]);
    assertEquals((byte) -1, data[86]);
    assertEquals((byte) -1, data[87]);
    assertEquals((byte) -1, data[88]);
    assertEquals(-42L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(-42L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(-42L, getResult2.getAmount());
    assertEquals((byte) -42, data[80]);
    assertEquals((byte) -48, data[90]);
    assertEquals((byte) -6, data[0]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    assertEquals(1, getResult2.getTypeValue());
    Protocol.Account instance = accountCapsule.getInstance();
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(13, getResult2.getSerializedSize());
    assertEquals((byte) 16, data[14]);
    assertEquals((byte) 16, data[21]);
    assertEquals((byte) 16, data[72]);
    assertEquals((byte) 16, data[79]);
    assertEquals((byte) 19, data[18]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[20]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[78]);
    assertEquals((byte) 1, data[89]);
    assertEquals(2, getResult2.getAllFields().size());
    assertEquals(2, instance.getFrozenV2Count());
    assertEquals(2, getResult.getSerializedSize());
    assertEquals((byte) 26, data[23]);
    assertEquals((byte) 26, data[3]);
    assertEquals((byte) 2, data[13]);
    assertEquals((byte) 2, data[17]);
    assertEquals((byte) 2, data[71]);
    assertEquals((byte) 2, data[75]);
    assertEquals((byte) 2, data[91]);
    assertEquals(42L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(42L, accountCapsule.getAllTronPower());
    assertEquals(42L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(42L, accountCapsule.getTronPower());
    assertEquals(42L, getResult.getAmount());
    assertEquals(5, instance.getAllFields().size());
    assertEquals((byte) 5, data[4]);
    assertEquals((byte) 7, data[24]);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(93, instance.getSerializedSize());
    assertEquals(93, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertEquals(Common.ResourceCode.ENERGY, getResult2.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult2.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(getResult2.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[10]);
    assertEquals('*', data[73]);
    assertEquals('*', data[92]);
    assertEquals(':', data[12]);
    assertEquals('\b', data[19]);
    assertEquals('\b', data[77]);
    assertEquals('\r', data[2]);
    assertEquals('\r', data[76]);
    assertEquals('e', data[8]);
    assertEquals('n', data[7]);
    assertEquals('o', data[5]);
    assertEquals('r', data[9]);
    assertEquals('w', data[6]);
    assertSame(descriptorForType, getResult2.getDescriptorForType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    Protocol.Account.FreezeV2 defaultInstanceForType2 = defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, getResult2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(account, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight42() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.ENERGY, 42L,
            new RepositoryImpl(StoreFactory.getInstance(), repository)));
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, Common.ResourceCode, long, Repository)}
   */
  @Test
  public void testUpdateTotalResourceWeight43() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    AccountCapsule accountCapsule = new AccountCapsule(account);
    accountCapsule.addFrozenBalanceForBandwidthV2(2L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(accountCapsule, Common.ResourceCode.TRON_POWER, 42L,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getDynamicProperty(isA(byte[].class));
    List<Protocol.Account.FreezeV2> frozenV2List = accountCapsule.getFrozenV2List();
    assertEquals(2, frozenV2List.size());
    Protocol.Account.FreezeV2 getResult = frozenV2List.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    Protocol.Account.FreezeV2 getResult2 = frozenV2List.get(1);
    assertEquals("", getResult2.getInitializationErrorString());
    Protocol.Account.FreezeV2 defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("FreezeV2", descriptorForType.getName());
    assertEquals("protocol.Account.FreezeV2", descriptorForType.getFullName());
    byte[] data = accountCapsule.getData();
    assertEquals((byte) -110, data[69]);
    assertEquals((byte) -110, data[74]);
    assertEquals((byte) -126, data[Short.SIZE]);
    assertEquals((byte) -1, data[81]);
    assertEquals((byte) -1, data[82]);
    assertEquals((byte) -1, data[83]);
    assertEquals((byte) -1, data[84]);
    assertEquals((byte) -1, data[85]);
    assertEquals((byte) -1, data[86]);
    assertEquals((byte) -1, data[87]);
    assertEquals((byte) -1, data[88]);
    assertEquals(-42L, accountCapsule.getTronPowerFrozenV2Balance());
    assertEquals(-42L, getResult2.getAmount());
    assertEquals((byte) -42, data[80]);
    assertEquals((byte) -48, data[90]);
    assertEquals((byte) -6, data[0]);
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(0, defaultInstanceForType.getTypeValue());
    assertEquals(0L, accountCapsule.getAllFrozenBalanceForEnergy());
    assertEquals(0L, accountCapsule.getFrozenV2BalanceForEnergy());
    assertEquals(0L, defaultInstanceForType.getAmount());
    assertEquals(1, getResult.getAllFields().size());
    Protocol.Account instance = accountCapsule.getInstance();
    Descriptors.Descriptor descriptorForType2 = instance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType2.getNestedTypes();
    assertEquals(10, nestedTypes.size());
    assertEquals(13, getResult2.getSerializedSize());
    assertEquals((byte) 16, data[14]);
    assertEquals((byte) 16, data[21]);
    assertEquals((byte) 16, data[72]);
    assertEquals((byte) 16, data[79]);
    assertEquals((byte) 19, data[18]);
    assertEquals((byte) 1, data[1]);
    assertEquals((byte) 1, data[11]);
    assertEquals((byte) 1, data[15]);
    assertEquals((byte) 1, data[20]);
    assertEquals((byte) 1, data[22]);
    assertEquals((byte) 1, data[89]);
    assertEquals(2, getResult2.getAllFields().size());
    assertEquals(2, instance.getFrozenV2Count());
    assertEquals(2, getResult.getSerializedSize());
    assertEquals(2, getResult2.getTypeValue());
    assertEquals((byte) 26, data[23]);
    assertEquals((byte) 26, data[3]);
    assertEquals(2L, accountCapsule.getAllFrozenBalanceForBandwidth());
    assertEquals(2L, accountCapsule.getAllTronPower());
    assertEquals(2L, accountCapsule.getFrozenV2BalanceForBandwidth());
    assertEquals(2L, getResult.getAmount());
    assertEquals((byte) 2, data[13]);
    assertEquals((byte) 2, data[17]);
    assertEquals((byte) 2, data[71]);
    assertEquals((byte) 2, data[73]);
    assertEquals((byte) 2, data[75]);
    assertEquals((byte) 2, data[78]);
    assertEquals((byte) 2, data[91]);
    assertEquals(44L, accountCapsule.getTronPower());
    assertEquals(5, instance.getAllFields().size());
    assertEquals((byte) 5, data[4]);
    assertEquals((byte) 7, data[24]);
    assertEquals(8, descriptorForType.getIndex());
    assertEquals(93, instance.getSerializedSize());
    assertEquals(93, data.length);
    assertEquals(Common.ResourceCode.BANDWIDTH, getResult.getType());
    assertEquals(Common.ResourceCode.BANDWIDTH, defaultInstanceForType.getType());
    assertEquals(Common.ResourceCode.TRON_POWER, getResult2.getType());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult2.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(getResult2.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(' ', data[10]);
    assertEquals('*', data[92]);
    assertEquals(':', data[12]);
    assertEquals('\b', data[19]);
    assertEquals('\b', data[77]);
    assertEquals('\r', data[2]);
    assertEquals('\r', data[76]);
    assertEquals('e', data[8]);
    assertEquals('n', data[7]);
    assertEquals('o', data[5]);
    assertEquals('r', data[9]);
    assertEquals('w', data[6]);
    assertSame(descriptorForType, getResult2.getDescriptorForType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes.get(8));
    assertSame(descriptorForType2, descriptorForType.getContainingType());
    assertSame(frozenV2List, instance.getFrozenV2List());
    assertSame(frozenV2List, instance.getFrozenV2OrBuilderList());
    Protocol.Account.FreezeV2 defaultInstanceForType2 = defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, getResult2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(account, instance.getDefaultInstanceForType());
  }
}
