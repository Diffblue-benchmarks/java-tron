package org.tron.core.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.ChainBaseManager;
import org.tron.core.exception.PermissionException;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class TransactionUtilDiffblueTest {
  @Mock
  private ChainBaseManager chainBaseManager;

  @InjectMocks
  private TransactionUtil transactionUtil;

  /**
   * Method under test: {@link TransactionUtil#validAccountName(byte[])}
   */
  @Test
  public void testValidAccountName() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAccountName("AXAXAXAX".getBytes("UTF-8")));
    assertTrue(TransactionUtil.validAccountName(new byte[]{}));
  }

  /**
   * Method under test: {@link TransactionUtil#validAssetDescription(byte[])}
   */
  @Test
  public void testValidAssetDescription() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAssetDescription("AXAXAXAX".getBytes("UTF-8")));
    assertTrue(TransactionUtil.validAssetDescription(new byte[]{}));
  }

  /**
   * Method under test: {@link TransactionUtil#validUrl(byte[])}
   */
  @Test
  public void testValidUrl() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validUrl("AXAXAXAX".getBytes("UTF-8")));
    assertFalse(TransactionUtil.validUrl(new byte[]{}));
  }

  /**
   * Method under test: {@link TransactionUtil#validAccountId(byte[])}
   */
  @Test
  public void testValidAccountId() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAccountId("AXAXAXAX".getBytes("UTF-8")));
    assertFalse(TransactionUtil.validAccountId(" XAXAXAX".getBytes("UTF-8")));
    assertFalse(TransactionUtil.validAccountId(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertFalse(TransactionUtil.validAccountId(new byte[]{}));
  }

  /**
   * Method under test: {@link TransactionUtil#validAssetName(byte[])}
   */
  @Test
  public void testValidAssetName() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAssetName("AXAXAXAX".getBytes("UTF-8")));
    assertFalse(TransactionUtil.validAssetName(" XAXAXAX".getBytes("UTF-8")));
    assertFalse(TransactionUtil.validAssetName(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertFalse(TransactionUtil.validAssetName(new byte[]{}));
  }

  /**
   * Method under test: {@link TransactionUtil#validTokenAbbrName(byte[])}
   */
  @Test
  public void testValidTokenAbbrName() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validTokenAbbrName("AXAXAXAX".getBytes("UTF-8")));
    assertFalse(TransactionUtil.validTokenAbbrName(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransactionUtil#getContractRet(Protocol.Transaction)}
   */
  @Test
  public void testGetContractRet() {
    // Arrange, Act and Assert
    assertNull(TransactionUtil.getContractRet(Protocol.Transaction.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link TransactionUtil#getCallTokenValue(Protocol.Transaction.Contract)}
   */
  @Test
  public void testGetCallTokenValue() {
    // Arrange, Act and Assert
    assertEquals(0L, TransactionUtil.getCallTokenValue(Protocol.Transaction.Contract.getDefaultInstance()));
    assertEquals(0L, TransactionUtil.getCallTokenValue(null));
  }

  /**
   * Method under test:
   * {@link TransactionUtil#generateContractAddress(byte[], long)}
   */
  @Test
  public void testGenerateContractAddress() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', '<', '>', '0', 24, 23, 'F', -11, -104, 'F', 'M', 'h', 't', -120, -36, 'I', 't',
        -46, -43, 'D', '9'}, TransactionUtil.generateContractAddress("AXAXAXAX".getBytes("UTF-8"), 1L));
    assertArrayEquals(new byte[]{'A', 't', -12, -77, '=', -82, -120, -19, 'h', 29, 'D', 'L', -110, -93, 'G', -68, 3, 4,
        -103, 'F', 'W'}, TransactionUtil.generateContractAddress(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1L));
  }

  /**
   * Method under test:
   * {@link TransactionUtil#generateContractAddress(byte[], byte[])}
   */
  @Test
  public void testGenerateContractAddress2() throws UnsupportedEncodingException {
    // Arrange
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(new byte[]{'A', '{', -23, 'i', -48, -7, -113, -47, '4', -19, -90, -77, -105, -79, '@', 'I', 'w',
        -34, '1', 'F', 16}, TransactionUtil.generateContractAddress(ownerAddress, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionUtil#checkPermissionOperations(Protocol.Permission, Protocol.Transaction.Contract)}
   */
  @Test
  public void testCheckPermissionOperations() throws PermissionException {
    // Arrange
    Protocol.Permission permission = Protocol.Permission.getDefaultInstance();

    // Act and Assert
    assertThrows(PermissionException.class, () -> TransactionUtil.checkPermissionOperations(permission,
        Protocol.Transaction.Contract.getDefaultInstance()));
  }

  /**
   * Method under test: {@link TransactionUtil#makeUpperCamelMethod(String)}
   */
  @Test
  public void testMakeUpperCamelMethod() {
    // Arrange, Act and Assert
    assertEquals("getOrigin name", TransactionUtil.makeUpperCamelMethod("Origin Name"));
    assertEquals("getGet", TransactionUtil.makeUpperCamelMethod("get"));
    assertEquals("get", TransactionUtil.makeUpperCamelMethod("_"));
    assertEquals("get", TransactionUtil.makeUpperCamelMethod("__"));
  }

  /**
   * Method under test:
   * {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}
   */
  @Test
  public void testEstimateConsumeBandWidthSize() {
    // Arrange
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.getMaxDelegateLockPeriod()).thenReturn(1L);
    when(dps.supportMaxDelegateLockPeriod()).thenReturn(true);

    // Act
    long actualEstimateConsumeBandWidthSizeResult = TransactionUtil.estimateConsumeBandWidthSize(dps, 42L);

    // Assert
    verify(dps).getMaxDelegateLockPeriod();
    verify(dps).supportMaxDelegateLockPeriod();
    assertEquals(277L, actualEstimateConsumeBandWidthSizeResult);
  }

  /**
   * Method under test:
   * {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}
   */
  @Test
  public void testEstimateConsumeBandWidthSize2() {
    // Arrange
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.getMaxDelegateLockPeriod()).thenReturn(-1L);
    when(dps.supportMaxDelegateLockPeriod()).thenReturn(true);

    // Act
    long actualEstimateConsumeBandWidthSizeResult = TransactionUtil.estimateConsumeBandWidthSize(dps, 42L);

    // Assert
    verify(dps).getMaxDelegateLockPeriod();
    verify(dps).supportMaxDelegateLockPeriod();
    assertEquals(286L, actualEstimateConsumeBandWidthSizeResult);
  }

  /**
   * Method under test:
   * {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}
   */
  @Test
  public void testEstimateConsumeBandWidthSize3() {
    // Arrange
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.getMaxDelegateLockPeriod()).thenReturn(Long.MAX_VALUE);
    when(dps.supportMaxDelegateLockPeriod()).thenReturn(true);

    // Act
    long actualEstimateConsumeBandWidthSizeResult = TransactionUtil.estimateConsumeBandWidthSize(dps, 42L);

    // Assert
    verify(dps).getMaxDelegateLockPeriod();
    verify(dps).supportMaxDelegateLockPeriod();
    assertEquals(285L, actualEstimateConsumeBandWidthSizeResult);
  }

  /**
   * Method under test:
   * {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}
   */
  @Test
  public void testEstimateConsumeBandWidthSize4() {
    // Arrange
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.supportMaxDelegateLockPeriod()).thenReturn(false);

    // Act
    long actualEstimateConsumeBandWidthSizeResult = TransactionUtil.estimateConsumeBandWidthSize(dps, 42L);

    // Assert
    verify(dps).supportMaxDelegateLockPeriod();
    assertEquals(275L, actualEstimateConsumeBandWidthSizeResult);
  }

  /**
   * Method under test:
   * {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}
   */
  @Test
  public void testEstimateConsumeBandWidthSize5() {
    // Arrange
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.getMaxDelegateLockPeriod()).thenReturn(1L);
    when(dps.supportMaxDelegateLockPeriod()).thenReturn(true);

    // Act
    long actualEstimateConsumeBandWidthSizeResult = TransactionUtil.estimateConsumeBandWidthSize(dps, 0L);

    // Assert
    verify(dps).getMaxDelegateLockPeriod();
    verify(dps).supportMaxDelegateLockPeriod();
    assertEquals(275L, actualEstimateConsumeBandWidthSizeResult);
  }
}
