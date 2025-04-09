package org.tron.common.zksnark;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.zksnark.JLibsodiumParam.Black2bSaltPersonalParams;
import org.tron.common.zksnark.JLibsodiumParam.Blake2bFinalParams;
import org.tron.common.zksnark.JLibsodiumParam.Blake2bInitSaltPersonalParams;
import org.tron.common.zksnark.JLibsodiumParam.Blake2bUpdateParams;
import org.tron.common.zksnark.JLibsodiumParam.Chacha20Poly1305IetfEncryptParams;
import org.tron.common.zksnark.JLibsodiumParam.Chacha20poly1305IetfDecryptParams;
import org.tron.core.exception.ZksnarkException;

public class JLibsodiumDiffblueTest {
  /**
   * Test {@link JLibsodium#cryptoGenerichashBlake2bInitSaltPersonal(Blake2bInitSaltPersonalParams)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JLibsodium#cryptoGenerichashBlake2bInitSaltPersonal(Blake2bInitSaltPersonalParams)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JLibsodium.cryptoGenerichashBlake2bInitSaltPersonal(Blake2bInitSaltPersonalParams)"})
  public void testCryptoGenerichashBlake2bInitSaltPersonal_thenReturnZero()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    byte[] salt = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, JLibsodium.cryptoGenerichashBlake2bInitSaltPersonal(
        new Blake2bInitSaltPersonalParams(1L, key, 3, 3, salt, "AXAXAXAXAXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link JLibsodium#cryptoGenerichashBlake2bUpdate(Blake2bUpdateParams)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JLibsodium#cryptoGenerichashBlake2bUpdate(Blake2bUpdateParams)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JLibsodium.cryptoGenerichashBlake2bUpdate(Blake2bUpdateParams)"})
  public void testCryptoGenerichashBlake2bUpdate_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, JLibsodium.cryptoGenerichashBlake2bUpdate(null));
  }

  /**
   * Test {@link JLibsodium#cryptoGenerichashBlake2bFinal(Blake2bFinalParams)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JLibsodium#cryptoGenerichashBlake2bFinal(Blake2bFinalParams)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JLibsodium.cryptoGenerichashBlake2bFinal(Blake2bFinalParams)"})
  public void testCryptoGenerichashBlake2bFinal_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, JLibsodium.cryptoGenerichashBlake2bFinal(null));
  }

  /**
   * Test {@link JLibsodium#cryptoGenerichashBlack2bSaltPersonal(Black2bSaltPersonalParams)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JLibsodium#cryptoGenerichashBlack2bSaltPersonal(Black2bSaltPersonalParams)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JLibsodium.cryptoGenerichashBlack2bSaltPersonal(Black2bSaltPersonalParams)"})
  public void testCryptoGenerichashBlack2bSaltPersonal_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, JLibsodium.cryptoGenerichashBlack2bSaltPersonal(null));
  }

  /**
   * Test {@link JLibsodium#cryptoAeadChacha20poly1305IetfDecrypt(Chacha20poly1305IetfDecryptParams)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JLibsodium#cryptoAeadChacha20poly1305IetfDecrypt(Chacha20poly1305IetfDecryptParams)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JLibsodium.cryptoAeadChacha20poly1305IetfDecrypt(Chacha20poly1305IetfDecryptParams)"})
  public void testCryptoAeadChacha20poly1305IetfDecrypt_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, JLibsodium.cryptoAeadChacha20poly1305IetfDecrypt(null));
  }

  /**
   * Test {@link JLibsodium#cryptoAeadChacha20Poly1305IetfEncrypt(Chacha20Poly1305IetfEncryptParams)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JLibsodium#cryptoAeadChacha20Poly1305IetfEncrypt(Chacha20Poly1305IetfEncryptParams)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JLibsodium.cryptoAeadChacha20Poly1305IetfEncrypt(Chacha20Poly1305IetfEncryptParams)"})
  public void testCryptoAeadChacha20Poly1305IetfEncrypt_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, JLibsodium.cryptoAeadChacha20Poly1305IetfEncrypt(null));
  }

  /**
   * Test {@link JLibsodium#initState()}.
   * <p>
   * Method under test: {@link JLibsodium#initState()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JLibsodium.initState()"})
  public void testInitState() {
    // Arrange, Act and Assert
    assertEquals(0L, JLibsodium.initState());
  }
}
