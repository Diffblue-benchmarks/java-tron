package org.tron.common.zksnark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.exception.ZksnarkException;

public class LibrustzcashParamDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LibrustzcashParam.InitZksnarkParams#setOutput_hash(String)}
   *   <li>{@link LibrustzcashParam.InitZksnarkParams#setOutput_path(String)}
   *   <li>{@link LibrustzcashParam.InitZksnarkParams#setSpend_hash(String)}
   *   <li>{@link LibrustzcashParam.InitZksnarkParams#setSpend_path(String)}
   *   <li>{@link LibrustzcashParam.InitZksnarkParams#valid()}
   *   <li>{@link LibrustzcashParam.InitZksnarkParams#getOutput_hash()}
   *   <li>{@link LibrustzcashParam.InitZksnarkParams#getOutput_path()}
   *   <li>{@link LibrustzcashParam.InitZksnarkParams#getSpend_hash()}
   *   <li>{@link LibrustzcashParam.InitZksnarkParams#getSpend_path()}
   * </ul>
   */
  @Test
  public void testInitZksnarkParamsGettersAndSetters() throws ZksnarkException {
    // Arrange
    LibrustzcashParam.InitZksnarkParams initZksnarkParams = new LibrustzcashParam.InitZksnarkParams("Spend path",
        "Spend hash", "Output path", "Output hash");

    // Act
    initZksnarkParams.setOutput_hash("Output hash");
    initZksnarkParams.setOutput_path("Output path");
    initZksnarkParams.setSpend_hash("Spend hash");
    initZksnarkParams.setSpend_path("Spend path");
    initZksnarkParams.valid();
    String actualOutput_hash = initZksnarkParams.getOutput_hash();
    String actualOutput_path = initZksnarkParams.getOutput_path();
    String actualSpend_hash = initZksnarkParams.getSpend_hash();

    // Assert that nothing has changed
    assertEquals("Output hash", actualOutput_hash);
    assertEquals("Output path", actualOutput_path);
    assertEquals("Spend hash", actualSpend_hash);
    assertEquals("Spend path", initZksnarkParams.getSpend_path());
  }

  /**
   * Method under test:
   * {@link LibrustzcashParam.InitZksnarkParams#InitZksnarkParams(String, String, String, String)}
   */
  @Test
  public void testInitZksnarkParamsNewInitZksnarkParams() throws ZksnarkException {
    // Arrange and Act
    LibrustzcashParam.InitZksnarkParams actualInitZksnarkParams = new LibrustzcashParam.InitZksnarkParams("Spend path",
        "Spend hash", "Output path", "Output hash");

    // Assert
    assertEquals("Output hash", actualInitZksnarkParams.getOutput_hash());
    assertEquals("Output path", actualInitZksnarkParams.getOutput_path());
    assertEquals("Spend hash", actualInitZksnarkParams.getSpend_hash());
    assertEquals("Spend path", actualInitZksnarkParams.getSpend_path());
  }

  /**
   * Method under test:
   * {@link LibrustzcashParam.MerkleHashParams#MerkleHashParams(int, byte[], byte[], byte[])}
   */
  @Test
  public void testMerkleHashParamsNewMerkleHashParams() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    byte[] a = "AXAXAXAX".getBytes("UTF-8");
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(ZksnarkException.class,
        () -> new LibrustzcashParam.MerkleHashParams(63, a, b, "AXAXAXAX".getBytes("UTF-8")));

  }

  /**
   * Method under test:
   * {@link LibrustzcashParam.MerkleHashParams#MerkleHashParams(int, byte[], byte[], byte[])}
   */
  @Test
  public void testMerkleHashParamsNewMerkleHashParams2() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    byte[] a = "AXAXAXAX".getBytes("UTF-8");
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(ZksnarkException.class,
        () -> new LibrustzcashParam.MerkleHashParams(-1, a, b, "AXAXAXAX".getBytes("UTF-8")));

  }

  /**
   * Method under test: {@link LibrustzcashParam#validNull(byte[])}
   */
  @Test
  public void testValidNull() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validNull(null));
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validNull(new byte[]{}));
  }

  /**
   * Method under test: {@link LibrustzcashParam#validObjectNull(Object)}
   */
  @Test
  public void testValidObjectNull() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validObjectNull(null));
  }

  /**
   * Method under test: {@link LibrustzcashParam#validByteValue(byte, byte)}
   */
  @Test
  public void testValidByteValue() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validByteValue((byte) 'X', (byte) 'A'));
  }

  /**
   * Method under test: {@link LibrustzcashParam#validParamLength(byte[], int)}
   */
  @Test
  public void testValidParamLength() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validParamLength("AXAXAXAX".getBytes("UTF-8"), 3));
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validParamLength(null, 3));
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validParamLength(new byte[]{}, 3));
  }

  /**
   * Method under test: {@link LibrustzcashParam#valid11Params(byte[])}
   */
  @Test
  public void testValid11Params() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.valid11Params("AXAXAXAX".getBytes("UTF-8")));
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.valid11Params(null));
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.valid11Params(new byte[]{}));
  }

  /**
   * Method under test: {@link LibrustzcashParam#valid32Params(byte[])}
   */
  @Test
  public void testValid32Params() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.valid32Params("AXAXAXAX".getBytes("UTF-8")));
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.valid32Params(null));
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.valid32Params(new byte[]{}));
  }

  /**
   * Method under test: {@link LibrustzcashParam#validVoucherPath(byte[])}
   */
  @Test
  public void testValidVoucherPath() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validVoucherPath("AXAXAXAX".getBytes("UTF-8")));
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validVoucherPath(new byte[]{}));
  }

  /**
   * Method under test: {@link LibrustzcashParam#validValueParams(long)}
   */
  @Test
  public void testValidValueParams() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validValueParams(-1L));
  }

  /**
   * Method under test: {@link LibrustzcashParam#validPositionParams(long)}
   */
  @Test
  public void testValidPositionParams() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validPositionParams(-1L));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LibrustzcashParam.Zip32XfvkAddressParams#setAddr_ret(byte[])}
   *   <li>{@link LibrustzcashParam.Zip32XfvkAddressParams#setJ(byte[])}
   *   <li>{@link LibrustzcashParam.Zip32XfvkAddressParams#setJ_ret(byte[])}
   *   <li>{@link LibrustzcashParam.Zip32XfvkAddressParams#setXfvk(byte[])}
   *   <li>{@link LibrustzcashParam.Zip32XfvkAddressParams#valid()}
   *   <li>{@link LibrustzcashParam.Zip32XfvkAddressParams#getAddr_ret()}
   *   <li>{@link LibrustzcashParam.Zip32XfvkAddressParams#getJ()}
   *   <li>{@link LibrustzcashParam.Zip32XfvkAddressParams#getJ_ret()}
   *   <li>{@link LibrustzcashParam.Zip32XfvkAddressParams#getXfvk()}
   * </ul>
   */
  @Test
  public void testZip32XfvkAddressParamsGettersAndSetters() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    byte[] xfvk = "AXAXAXAX".getBytes("UTF-8");
    byte[] j = "AXAXAXAX".getBytes("UTF-8");
    byte[] j_ret = "AXAXAXAX".getBytes("UTF-8");
    LibrustzcashParam.Zip32XfvkAddressParams zip32XfvkAddressParams = new LibrustzcashParam.Zip32XfvkAddressParams(xfvk,
        j, j_ret, "AXAXAXAX".getBytes("UTF-8"));
    byte[] addr_ret = "AXAXAXAX".getBytes("UTF-8");

    // Act
    zip32XfvkAddressParams.setAddr_ret(addr_ret);
    byte[] j2 = "AXAXAXAX".getBytes("UTF-8");
    zip32XfvkAddressParams.setJ(j2);
    byte[] j_ret2 = "AXAXAXAX".getBytes("UTF-8");
    zip32XfvkAddressParams.setJ_ret(j_ret2);
    byte[] xfvk2 = "AXAXAXAX".getBytes("UTF-8");
    zip32XfvkAddressParams.setXfvk(xfvk2);
    zip32XfvkAddressParams.valid();
    byte[] actualAddr_ret = zip32XfvkAddressParams.getAddr_ret();
    byte[] actualJ = zip32XfvkAddressParams.getJ();
    byte[] actualJ_ret = zip32XfvkAddressParams.getJ_ret();

    // Assert that nothing has changed
    assertSame(addr_ret, actualAddr_ret);
    assertSame(j2, actualJ);
    assertSame(j_ret2, actualJ_ret);
    assertSame(xfvk2, zip32XfvkAddressParams.getXfvk());
  }

  /**
   * Method under test:
   * {@link LibrustzcashParam.Zip32XfvkAddressParams#Zip32XfvkAddressParams(byte[], byte[], byte[], byte[])}
   */
  @Test
  public void testZip32XfvkAddressParamsNewZip32XfvkAddressParams()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    byte[] xfvk = "AXAXAXAX".getBytes("UTF-8");
    byte[] j = "AXAXAXAX".getBytes("UTF-8");
    byte[] j_ret = "AXAXAXAX".getBytes("UTF-8");
    byte[] addr_ret = "AXAXAXAX".getBytes("UTF-8");

    // Act
    LibrustzcashParam.Zip32XfvkAddressParams actualZip32XfvkAddressParams = new LibrustzcashParam.Zip32XfvkAddressParams(
        xfvk, j, j_ret, addr_ret);

    // Assert
    assertSame(addr_ret, actualZip32XfvkAddressParams.getAddr_ret());
    assertSame(j, actualZip32XfvkAddressParams.getJ());
    assertSame(j_ret, actualZip32XfvkAddressParams.getJ_ret());
    assertSame(xfvk, actualZip32XfvkAddressParams.getXfvk());
  }

  /**
   * Method under test:
   * {@link LibrustzcashParam.Zip32XskDeriveParams#Zip32XskDeriveParams(byte[], int, byte[])}
   */
  @Test
  public void testZip32XskDeriveParamsNewZip32XskDeriveParams() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    byte[] m_bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act
    LibrustzcashParam.Zip32XskDeriveParams actualZip32XskDeriveParams = new LibrustzcashParam.Zip32XskDeriveParams(data,
        3, m_bytes);

    // Assert
    assertEquals(3, actualZip32XskDeriveParams.getSize());
    assertSame(data, actualZip32XskDeriveParams.getData());
    assertSame(m_bytes, actualZip32XskDeriveParams.getM_bytes());
  }
}
