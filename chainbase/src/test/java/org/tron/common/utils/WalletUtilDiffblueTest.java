package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.exception.PermissionException;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Permission;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transaction.Contract;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;
import org.tron.protos.contract.SmartContractOuterClass.TriggerSmartContract;

public class WalletUtilDiffblueTest {
  /**
   * Test {@link WalletUtil#checkPermissionOperations(Permission, Contract)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then throw {@link PermissionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletUtil#checkPermissionOperations(Permission, Transaction.Contract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletUtil.checkPermissionOperations(Permission, Transaction.Contract)"})
  public void testCheckPermissionOperations_whenDefaultInstance_thenThrowPermissionException()
      throws PermissionException {
    // Arrange
    Permission permission = Permission.getDefaultInstance();

    // Act and Assert
    assertThrows(PermissionException.class,
        () -> WalletUtil.checkPermissionOperations(permission, Contract.getDefaultInstance()));
  }

  /**
   * Test {@link WalletUtil#generateContractAddress2(byte[], byte[], byte[])}.
   * <p>
   * Method under test: {@link WalletUtil#generateContractAddress2(byte[], byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WalletUtil.generateContractAddress2(byte[], byte[], byte[])"})
  public void testGenerateContractAddress2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] salt = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(new byte[]{'A', ',', -42, -53, -77, -98, '3', '/', -107, -80, -113, 'x', -33, -57, -124, 'u', '9',
        'r', '8', -71, 'p'}, WalletUtil.generateContractAddress2(address, salt, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link WalletUtil#isConstant(ABI, byte[])} with {@code abi}, {@code selector}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletUtil#isConstant(ABI, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletUtil.isConstant(ABI, byte[])"})
  public void testIsConstantWithAbiSelector_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ABI abi = ABI.getDefaultInstance();

    // Act and Assert
    assertFalse(WalletUtil.isConstant(abi, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link WalletUtil#isConstant(ABI, byte[])} with {@code abi}, {@code selector}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletUtil#isConstant(ABI, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletUtil.isConstant(ABI, byte[])"})
  public void testIsConstantWithAbiSelector_whenNull() {
    // Arrange, Act and Assert
    assertFalse(WalletUtil.isConstant(ABI.getDefaultInstance(), (byte[]) null));
  }

  /**
   * Test {@link WalletUtil#isConstant(ABI, TriggerSmartContract)} with {@code abi}, {@code triggerSmartContract}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletUtil#isConstant(ABI, TriggerSmartContract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletUtil.isConstant(ABI, TriggerSmartContract)"})
  public void testIsConstantWithAbiTriggerSmartContract_whenDefaultInstance() throws ContractValidateException {
    // Arrange
    ABI abi = ABI.getDefaultInstance();

    // Act and Assert
    assertFalse(WalletUtil.isConstant(abi, TriggerSmartContract.getDefaultInstance()));
  }

  /**
   * Test {@link WalletUtil#isConstant(ABI, TriggerSmartContract)} with {@code abi}, {@code triggerSmartContract}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletUtil#isConstant(ABI, TriggerSmartContract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WalletUtil.isConstant(ABI, TriggerSmartContract)"})
  public void testIsConstantWithAbiTriggerSmartContract_whenNull() throws ContractValidateException {
    // Arrange, Act and Assert
    assertFalse(WalletUtil.isConstant(ABI.getDefaultInstance(), (TriggerSmartContract) null));
  }

  /**
   * Test {@link WalletUtil#getAddressStringList(Collection)}.
   * <p>
   * Method under test: {@link WalletUtil#getAddressStringList(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List WalletUtil.getAddressStringList(Collection)"})
  public void testGetAddressStringList() {
    // Arrange and Act
    List<String> actualAddressStringList = WalletUtil.getAddressStringList(new ArrayList<>());

    // Assert
    assertTrue(actualAddressStringList.isEmpty());
  }

  /**
   * Test {@link WalletUtil#getSelector(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code AXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletUtil#getSelector(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WalletUtil.getSelector(byte[])"})
  public void testGetSelector_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualSelector = WalletUtil.getSelector("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAX".getBytes("UTF-8"), actualSelector);
  }

  /**
   * Test {@link WalletUtil#getSelector(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletUtil#getSelector(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WalletUtil.getSelector(byte[])"})
  public void testGetSelector_whenEmptyArrayOfByte_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(WalletUtil.getSelector(new byte[]{}));
  }

  /**
   * Test {@link WalletUtil#getSelector(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletUtil#getSelector(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WalletUtil.getSelector(byte[])"})
  public void testGetSelector_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(WalletUtil.getSelector(null));
  }

  /**
   * Test {@link WalletUtil#isLong(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletUtil#isLong(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Long WalletUtil.isLong(String)"})
  public void testIsLong_when42_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, WalletUtil.isLong("42").longValue());
  }

  /**
   * Test {@link WalletUtil#isLong(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletUtil#isLong(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Long WalletUtil.isLong(String)"})
  public void testIsLong_whenFoo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(WalletUtil.isLong("foo"));
  }
}
