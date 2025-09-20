package org.tron.core.zen.note;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.ZksnarkException;
import org.tron.core.zen.note.NoteEncryption.Encryption;
import org.tron.core.zen.note.NoteEncryption.Encryption.EncCiphertext;
import org.tron.core.zen.note.NoteEncryption.Encryption.EncPlaintext;
import org.tron.core.zen.note.NoteEncryption.Encryption.OutCiphertext;
import org.tron.core.zen.note.NoteEncryption.Encryption.OutPlaintext;

public class NoteEncryptionDiffblueTest {
  /**
   * Test Encryption_EncCiphertext getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EncCiphertext#setData(byte[])}
   *   <li>{@link EncCiphertext#getData()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] EncCiphertext.getData()", "void EncCiphertext.setData(byte[])"})
  public void testEncryption_EncCiphertextGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    EncCiphertext encCiphertext = new EncCiphertext();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    encCiphertext.setData(data);
    byte[] actualData = encCiphertext.getData();

    // Assert
    assertSame(data, actualData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Test Encryption_EncCiphertext new {@link EncCiphertext} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EncCiphertext}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EncCiphertext.<init>()"})
  public void testEncryption_EncCiphertextNewEncCiphertext() {
    // Arrange, Act and Assert
    assertEquals(580, new EncCiphertext().getData().length);
  }

  /**
   * Test Encryption_EncPlaintext getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EncPlaintext#setData(byte[])}
   *   <li>{@link EncPlaintext#getData()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] EncPlaintext.getData()", "void EncPlaintext.setData(byte[])"})
  public void testEncryption_EncPlaintextGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    EncPlaintext encPlaintext = new EncPlaintext();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    encPlaintext.setData(data);
    byte[] actualData = encPlaintext.getData();

    // Assert
    assertSame(data, actualData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Test Encryption_EncPlaintext new {@link EncPlaintext} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EncPlaintext}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EncPlaintext.<init>()"})
  public void testEncryption_EncPlaintextNewEncPlaintext() {
    // Arrange, Act and Assert
    assertEquals(564, new EncPlaintext().getData().length);
  }

  /**
   * Test Encryption_OutCiphertext getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OutCiphertext#setData(byte[])}
   *   <li>{@link OutCiphertext#getData()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] OutCiphertext.getData()", "void OutCiphertext.setData(byte[])"})
  public void testEncryption_OutCiphertextGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    OutCiphertext outCiphertext = new OutCiphertext();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    outCiphertext.setData(data);
    byte[] actualData = outCiphertext.getData();

    // Assert
    assertSame(data, actualData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Test Encryption_OutCiphertext new {@link OutCiphertext} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OutCiphertext}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OutCiphertext.<init>()"})
  public void testEncryption_OutCiphertextNewOutCiphertext() {
    // Arrange, Act and Assert
    assertEquals(80, new OutCiphertext().getData().length);
  }

  /**
   * Test Encryption_OutPlaintext getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OutPlaintext#setData(byte[])}
   *   <li>{@link OutPlaintext#getData()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] OutPlaintext.getData()", "void OutPlaintext.setData(byte[])"})
  public void testEncryption_OutPlaintextGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    OutPlaintext outPlaintext = new OutPlaintext();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    outPlaintext.setData(data);
    byte[] actualData = outPlaintext.getData();

    // Assert
    assertSame(data, actualData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Test Encryption_OutPlaintext new {@link OutPlaintext} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OutPlaintext}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OutPlaintext.<init>()"})
  public void testEncryption_OutPlaintextNewOutPlaintext() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0
        },
        new OutPlaintext().getData());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NoteEncryption#NoteEncryption(byte[], byte[])}
   *   <li>{@link NoteEncryption#getEpk()}
   *   <li>{@link NoteEncryption#getEsk()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NoteEncryption.<init>(byte[], byte[])",
    "void NoteEncryption.<init>(byte[], byte[], boolean, boolean)",
    "byte[] NoteEncryption.getEpk()",
    "byte[] NoteEncryption.getEsk()"
  })
  public void testGettersAndSetters_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] epk = "AXAXAXAX".getBytes("UTF-8");
    byte[] esk = "AXAXAXAX".getBytes("UTF-8");

    // Act
    NoteEncryption actualNoteEncryption = new NoteEncryption(epk, esk);
    byte[] actualEpk = actualNoteEncryption.getEpk();
    byte[] actualEsk = actualNoteEncryption.getEsk();

    // Assert
    assertSame(epk, actualEpk);
    assertSame(esk, actualEsk);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualEpk);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualEsk);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NoteEncryption#NoteEncryption(byte[], byte[], boolean, boolean)}
   *   <li>{@link NoteEncryption#getEpk()}
   *   <li>{@link NoteEncryption#getEsk()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NoteEncryption.<init>(byte[], byte[])",
    "void NoteEncryption.<init>(byte[], byte[], boolean, boolean)",
    "byte[] NoteEncryption.getEpk()",
    "byte[] NoteEncryption.getEsk()"
  })
  public void testGettersAndSetters_whenTrue() throws UnsupportedEncodingException {
    // Arrange
    byte[] epk = "AXAXAXAX".getBytes("UTF-8");
    byte[] esk = "AXAXAXAX".getBytes("UTF-8");

    // Act
    NoteEncryption actualNoteEncryption = new NoteEncryption(epk, esk, true, true);
    byte[] actualEpk = actualNoteEncryption.getEpk();
    byte[] actualEsk = actualNoteEncryption.getEsk();

    // Assert
    assertSame(epk, actualEpk);
    assertSame(esk, actualEsk);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualEpk);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualEsk);
  }

  /**
   * Test {@link NoteEncryption#encryptToRecipient(byte[], EncPlaintext)}.
   *
   * <ul>
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link NoteEncryption#encryptToRecipient(byte[], EncPlaintext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Optional NoteEncryption.encryptToRecipient(byte[], EncPlaintext)"})
  public void testEncryptToRecipient_thenThrowZksnarkException()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    NoteEncryption noteEncryption =
        new NoteEncryption("A A A A ".getBytes("UTF-8"), "A A A A ".getBytes("UTF-8"), true, true);
    byte[] pkD = "AXAXAXAX".getBytes("UTF-8");

    EncPlaintext message = new EncPlaintext();
    message.setData("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> noteEncryption.encryptToRecipient(pkD, message));
  }

  /**
   * Test {@link NoteEncryption#encryptToOurselves(byte[], byte[], byte[], OutPlaintext)}.
   *
   * <ul>
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link NoteEncryption#encryptToOurselves(byte[], byte[], byte[],
   * OutPlaintext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "OutCiphertext NoteEncryption.encryptToOurselves(byte[], byte[], byte[], OutPlaintext)"
  })
  public void testEncryptToOurselves_thenThrowZksnarkException()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    NoteEncryption noteEncryption =
        new NoteEncryption("A A A A ".getBytes("UTF-8"), "A A A A ".getBytes("UTF-8"), true, true);
    byte[] ovk = "AXAXAXAX".getBytes("UTF-8");
    byte[] cv = "AXAXAXAX".getBytes("UTF-8");
    byte[] cm = "AXAXAXAX".getBytes("UTF-8");

    OutPlaintext message = new OutPlaintext();
    message.setData("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        ZksnarkException.class, () -> noteEncryption.encryptToOurselves(ovk, cv, cm, message));
  }
}
