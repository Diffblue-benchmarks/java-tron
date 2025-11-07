package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.exception.PermissionException;
import org.tron.protos.Protocol;
import org.tron.protos.contract.SmartContractOuterClass;

public class WalletUtilDiffblueTest {
  /**
   * Method under test:
   * {@link WalletUtil#checkPermissionOperations(Protocol.Permission, Protocol.Transaction.Contract)}
   */
  @Test
  public void testCheckPermissionOperations() throws PermissionException {
    // Arrange
    Protocol.Permission permission = Protocol.Permission.getDefaultInstance();

    // Act and Assert
    assertThrows(PermissionException.class,
        () -> WalletUtil.checkPermissionOperations(permission, Protocol.Transaction.Contract.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link WalletUtil#generateContractAddress2(byte[], byte[], byte[])}
   */
  @Test
  public void testGenerateContractAddress2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] salt = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(new byte[]{'A', ',', -42, -53, -77, -98, '3', '/', -107, -80, -113, 'x', -33, -57, -124, 'u', '9',
        'r', '8', -71, 'p'}, WalletUtil.generateContractAddress2(address, salt, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link WalletUtil#isConstant(SmartContractOuterClass.SmartContract.ABI, SmartContractOuterClass.TriggerSmartContract)}
   */
  @Test
  public void testIsConstant() throws ContractValidateException {
    // Arrange
    SmartContractOuterClass.SmartContract.ABI abi = SmartContractOuterClass.SmartContract.ABI.getDefaultInstance();

    // Act and Assert
    assertFalse(WalletUtil.isConstant(abi, SmartContractOuterClass.TriggerSmartContract.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link WalletUtil#isConstant(SmartContractOuterClass.SmartContract.ABI, SmartContractOuterClass.TriggerSmartContract)}
   */
  @Test
  public void testIsConstant2() throws ContractValidateException {
    // Arrange, Act and Assert
    assertFalse(WalletUtil.isConstant(SmartContractOuterClass.SmartContract.ABI.getDefaultInstance(),
        (SmartContractOuterClass.TriggerSmartContract) null));
  }

  /**
   * Method under test:
   * {@link WalletUtil#isConstant(SmartContractOuterClass.SmartContract.ABI, byte[])}
   */
  @Test
  public void testIsConstant3() throws UnsupportedEncodingException {
    // Arrange
    SmartContractOuterClass.SmartContract.ABI abi = SmartContractOuterClass.SmartContract.ABI.getDefaultInstance();

    // Act and Assert
    assertFalse(WalletUtil.isConstant(abi, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link WalletUtil#isConstant(SmartContractOuterClass.SmartContract.ABI, byte[])}
   */
  @Test
  public void testIsConstant4() {
    // Arrange, Act and Assert
    assertFalse(WalletUtil.isConstant(SmartContractOuterClass.SmartContract.ABI.getDefaultInstance(), (byte[]) null));
  }

  /**
   * Method under test: {@link WalletUtil#getAddressStringList(Collection)}
   */
  @Test
  public void testGetAddressStringList() {
    // Arrange and Act
    List<String> actualAddressStringList = WalletUtil.getAddressStringList(new ArrayList<>());

    // Assert
    assertTrue(actualAddressStringList.isEmpty());
  }

  /**
   * Method under test: {@link WalletUtil#getSelector(byte[])}
   */
  @Test
  public void testGetSelector() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualSelector = WalletUtil.getSelector("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAX".getBytes("UTF-8"), actualSelector);
  }

  /**
   * Method under test: {@link WalletUtil#getSelector(byte[])}
   */
  @Test
  public void testGetSelector2() {
    // Arrange, Act and Assert
    assertNull(WalletUtil.getSelector(null));
  }

  /**
   * Method under test: {@link WalletUtil#getSelector(byte[])}
   */
  @Test
  public void testGetSelector3() {
    // Arrange, Act and Assert
    assertNull(WalletUtil.getSelector(new byte[]{}));
  }

  /**
   * Method under test: {@link WalletUtil#isLong(String)}
   */
  @Test
  public void testIsLong() {
    // Arrange, Act and Assert
    assertNull(WalletUtil.isLong("foo"));
    assertEquals(42L, WalletUtil.isLong("42").longValue());
  }
}
