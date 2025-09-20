package org.tron.common.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.zksnark.LibrustzcashParam.InitZksnarkParams;
import org.tron.common.zksnark.LibrustzcashParam.MerkleHashParams;
import org.tron.common.zksnark.LibrustzcashParam.Zip32XfvkAddressParams;
import org.tron.common.zksnark.LibrustzcashParam.Zip32XskDeriveParams;
import org.tron.core.exception.ZksnarkException;

public class LibrustzcashParamDiffblueTest {
  /**
   * Test InitZksnarkParams getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InitZksnarkParams#setOutput_hash(String)}
   *   <li>{@link InitZksnarkParams#setOutput_path(String)}
   *   <li>{@link InitZksnarkParams#setSpend_hash(String)}
   *   <li>{@link InitZksnarkParams#setSpend_path(String)}
   *   <li>{@link InitZksnarkParams#valid()}
   *   <li>{@link InitZksnarkParams#getOutput_hash()}
   *   <li>{@link InitZksnarkParams#getOutput_path()}
   *   <li>{@link InitZksnarkParams#getSpend_hash()}
   *   <li>{@link InitZksnarkParams#getSpend_path()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "String InitZksnarkParams.getOutput_hash()",
    "String InitZksnarkParams.getOutput_path()",
    "String InitZksnarkParams.getSpend_hash()",
    "String InitZksnarkParams.getSpend_path()",
    "void InitZksnarkParams.setOutput_hash(String)",
    "void InitZksnarkParams.setOutput_path(String)",
    "void InitZksnarkParams.setSpend_hash(String)",
    "void InitZksnarkParams.setSpend_path(String)",
    "void InitZksnarkParams.valid()"
  })
  public void testInitZksnarkParamsGettersAndSetters() throws ZksnarkException {
    // Arrange
    InitZksnarkParams initZksnarkParams =
        new InitZksnarkParams("Spend path", "Spend hash", "Output path", "Output hash");

    // Act
    initZksnarkParams.setOutput_hash("Output hash");
    initZksnarkParams.setOutput_path("Output path");
    initZksnarkParams.setSpend_hash("Spend hash");
    initZksnarkParams.setSpend_path("Spend path");
    initZksnarkParams.valid();
    String actualOutput_hash = initZksnarkParams.getOutput_hash();
    String actualOutput_path = initZksnarkParams.getOutput_path();
    String actualSpend_hash = initZksnarkParams.getSpend_hash();

    // Assert
    assertEquals("Output hash", actualOutput_hash);
    assertEquals("Output path", actualOutput_path);
    assertEquals("Spend hash", actualSpend_hash);
    assertEquals("Spend path", initZksnarkParams.getSpend_path());
  }

  /**
   * Test InitZksnarkParams {@link InitZksnarkParams#InitZksnarkParams(String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link InitZksnarkParams#InitZksnarkParams(String, String, String,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InitZksnarkParams.<init>(String, String, String, String)"})
  public void testInitZksnarkParamsNewInitZksnarkParams() throws ZksnarkException {
    // Arrange and Act
    InitZksnarkParams actualInitZksnarkParams =
        new InitZksnarkParams("Spend path", "Spend hash", "Output path", "Output hash");

    // Assert
    assertEquals("Output hash", actualInitZksnarkParams.getOutput_hash());
    assertEquals("Output path", actualInitZksnarkParams.getOutput_path());
    assertEquals("Spend hash", actualInitZksnarkParams.getSpend_hash());
    assertEquals("Spend path", actualInitZksnarkParams.getSpend_path());
  }

  /**
   * Test MerkleHashParams {@link MerkleHashParams#MerkleHashParams(int, byte[], byte[], byte[])}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleHashParams#MerkleHashParams(int, byte[], byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MerkleHashParams.<init>(int, byte[], byte[], byte[])"})
  public void testMerkleHashParamsNewMerkleHashParams_whenMinusOne_thenThrowZksnarkException()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class,
        () ->
            new MerkleHashParams(
                -1,
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test MerkleHashParams {@link MerkleHashParams#MerkleHashParams(int, byte[], byte[], byte[])}.
   *
   * <ul>
   *   <li>When sixty-three.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleHashParams#MerkleHashParams(int, byte[], byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MerkleHashParams.<init>(int, byte[], byte[], byte[])"})
  public void testMerkleHashParamsNewMerkleHashParams_whenSixtyThree_thenThrowZksnarkException()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class,
        () ->
            new MerkleHashParams(
                63,
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link LibrustzcashParam#validNull(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#validNull(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.validNull(byte[])"})
  public void testValidNull_whenEmptyArrayOfByte_thenThrowZksnarkException()
      throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validNull(new byte[] {}));
  }

  /**
   * Test {@link LibrustzcashParam#validNull(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#validNull(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.validNull(byte[])"})
  public void testValidNull_whenNull_thenThrowZksnarkException() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validNull(null));
  }

  /**
   * Test {@link LibrustzcashParam#validObjectNull(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#validObjectNull(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.validObjectNull(Object)"})
  public void testValidObjectNull_whenNull_thenThrowZksnarkException() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validObjectNull(null));
  }

  /**
   * Test {@link LibrustzcashParam#validByteValue(byte, byte)}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#validByteValue(byte, byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.validByteValue(byte, byte)"})
  public void testValidByteValue_whenX_thenThrowZksnarkException() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class, () -> LibrustzcashParam.validByteValue((byte) 'X', (byte) 'A'));
  }

  /**
   * Test {@link LibrustzcashParam#validParamLength(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#validParamLength(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.validParamLength(byte[], int)"})
  public void testValidParamLength_whenAxaxaxaxBytesIsUtf8_thenThrowZksnarkException()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class,
        () -> LibrustzcashParam.validParamLength("AXAXAXAX".getBytes("UTF-8"), 3));
  }

  /**
   * Test {@link LibrustzcashParam#validParamLength(byte[], int)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#validParamLength(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.validParamLength(byte[], int)"})
  public void testValidParamLength_whenEmptyArrayOfByte_thenThrowZksnarkException()
      throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class, () -> LibrustzcashParam.validParamLength(new byte[] {}, 3));
  }

  /**
   * Test {@link LibrustzcashParam#validParamLength(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#validParamLength(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.validParamLength(byte[], int)"})
  public void testValidParamLength_whenNull_thenThrowZksnarkException() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validParamLength(null, 3));
  }

  /**
   * Test {@link LibrustzcashParam#valid11Params(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#valid11Params(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.valid11Params(byte[])"})
  public void testValid11Params_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class,
        () -> LibrustzcashParam.valid11Params("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link LibrustzcashParam#valid11Params(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#valid11Params(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.valid11Params(byte[])"})
  public void testValid11Params_whenEmptyArrayOfByte() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.valid11Params(new byte[] {}));
  }

  /**
   * Test {@link LibrustzcashParam#valid11Params(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#valid11Params(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.valid11Params(byte[])"})
  public void testValid11Params_whenNull() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.valid11Params(null));
  }

  /**
   * Test {@link LibrustzcashParam#valid32Params(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#valid32Params(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.valid32Params(byte[])"})
  public void testValid32Params_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class,
        () -> LibrustzcashParam.valid32Params("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link LibrustzcashParam#valid32Params(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#valid32Params(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.valid32Params(byte[])"})
  public void testValid32Params_whenEmptyArrayOfByte() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.valid32Params(new byte[] {}));
  }

  /**
   * Test {@link LibrustzcashParam#valid32Params(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#valid32Params(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.valid32Params(byte[])"})
  public void testValid32Params_whenNull() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.valid32Params(null));
  }

  /**
   * Test {@link LibrustzcashParam#validVoucherPath(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#validVoucherPath(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.validVoucherPath(byte[])"})
  public void testValidVoucherPath_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class,
        () -> LibrustzcashParam.validVoucherPath("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link LibrustzcashParam#validVoucherPath(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#validVoucherPath(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.validVoucherPath(byte[])"})
  public void testValidVoucherPath_whenEmptyArrayOfByte() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validVoucherPath(new byte[] {}));
  }

  /**
   * Test {@link LibrustzcashParam#validValueParams(long)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#validValueParams(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.validValueParams(long)"})
  public void testValidValueParams_whenMinusOne_thenThrowZksnarkException()
      throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validValueParams(-1L));
  }

  /**
   * Test {@link LibrustzcashParam#validPositionParams(long)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link LibrustzcashParam#validPositionParams(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibrustzcashParam.validPositionParams(long)"})
  public void testValidPositionParams_whenMinusOne_thenThrowZksnarkException()
      throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> LibrustzcashParam.validPositionParams(-1L));
  }

  /**
   * Test Zip32XfvkAddressParams getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Zip32XfvkAddressParams#setAddr_ret(byte[])}
   *   <li>{@link Zip32XfvkAddressParams#setJ(byte[])}
   *   <li>{@link Zip32XfvkAddressParams#setJ_ret(byte[])}
   *   <li>{@link Zip32XfvkAddressParams#setXfvk(byte[])}
   *   <li>{@link Zip32XfvkAddressParams#valid()}
   *   <li>{@link Zip32XfvkAddressParams#getAddr_ret()}
   *   <li>{@link Zip32XfvkAddressParams#getJ()}
   *   <li>{@link Zip32XfvkAddressParams#getJ_ret()}
   *   <li>{@link Zip32XfvkAddressParams#getXfvk()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "byte[] Zip32XfvkAddressParams.getAddr_ret()",
    "byte[] Zip32XfvkAddressParams.getJ()",
    "byte[] Zip32XfvkAddressParams.getJ_ret()",
    "byte[] Zip32XfvkAddressParams.getXfvk()",
    "void Zip32XfvkAddressParams.setAddr_ret(byte[])",
    "void Zip32XfvkAddressParams.setJ(byte[])",
    "void Zip32XfvkAddressParams.setJ_ret(byte[])",
    "void Zip32XfvkAddressParams.setXfvk(byte[])",
    "void Zip32XfvkAddressParams.valid()"
  })
  public void testZip32XfvkAddressParamsGettersAndSetters()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    Zip32XfvkAddressParams zip32XfvkAddressParams =
        new Zip32XfvkAddressParams(
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"));
    byte[] addr_ret = "AXAXAXAX".getBytes("UTF-8");

    // Act
    zip32XfvkAddressParams.setAddr_ret(addr_ret);
    byte[] j = "AXAXAXAX".getBytes("UTF-8");
    zip32XfvkAddressParams.setJ(j);
    byte[] j_ret = "AXAXAXAX".getBytes("UTF-8");
    zip32XfvkAddressParams.setJ_ret(j_ret);
    byte[] xfvk = "AXAXAXAX".getBytes("UTF-8");
    zip32XfvkAddressParams.setXfvk(xfvk);
    zip32XfvkAddressParams.valid();
    byte[] actualAddr_ret = zip32XfvkAddressParams.getAddr_ret();
    byte[] actualJ = zip32XfvkAddressParams.getJ();
    byte[] actualJ_ret = zip32XfvkAddressParams.getJ_ret();
    byte[] actualXfvk = zip32XfvkAddressParams.getXfvk();

    // Assert
    assertSame(addr_ret, actualAddr_ret);
    assertSame(j, actualJ);
    assertSame(j_ret, actualJ_ret);
    assertSame(xfvk, actualXfvk);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualAddr_ret);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualJ);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualJ_ret);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualXfvk);
  }

  /**
   * Test Zip32XfvkAddressParams {@link Zip32XfvkAddressParams#Zip32XfvkAddressParams(byte[],
   * byte[], byte[], byte[])}.
   *
   * <p>Method under test: {@link Zip32XfvkAddressParams#Zip32XfvkAddressParams(byte[], byte[],
   * byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Zip32XfvkAddressParams.<init>(byte[], byte[], byte[], byte[])"})
  public void testZip32XfvkAddressParamsNewZip32XfvkAddressParams()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange and Act
    Zip32XfvkAddressParams actualZip32XfvkAddressParams =
        new Zip32XfvkAddressParams(
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualZip32XfvkAddressParams.getAddr_ret());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualZip32XfvkAddressParams.getJ());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualZip32XfvkAddressParams.getJ_ret());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualZip32XfvkAddressParams.getXfvk());
  }

  /**
   * Test Zip32XskDeriveParams {@link Zip32XskDeriveParams#Zip32XskDeriveParams(byte[], int,
   * byte[])}.
   *
   * <p>Method under test: {@link Zip32XskDeriveParams#Zip32XskDeriveParams(byte[], int, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Zip32XskDeriveParams.<init>(byte[], int, byte[])"})
  public void testZip32XskDeriveParamsNewZip32XskDeriveParams()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange and Act
    Zip32XskDeriveParams actualZip32XskDeriveParams =
        new Zip32XskDeriveParams("AXAXAXAX".getBytes("UTF-8"), 3, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(3, actualZip32XskDeriveParams.getSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualZip32XskDeriveParams.getData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualZip32XskDeriveParams.getM_bytes());
  }
}
