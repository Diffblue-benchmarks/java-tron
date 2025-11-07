package org.tron.core.zen.note;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.exception.ZksnarkException;

public class NoteEncryptionDiffblueTest {
  /**
   * Method under test:
   * {@link NoteEncryption#encryptToRecipient(byte[], NoteEncryption.Encryption.EncPlaintext)}
   */
  @Test
  public void testEncryptToRecipient() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    byte[] epk = "A A A A ".getBytes("UTF-8");
    NoteEncryption noteEncryption = new NoteEncryption(epk, "A A A A ".getBytes("UTF-8"), true, true);
    byte[] pkD = "AXAXAXAX".getBytes("UTF-8");

    NoteEncryption.Encryption.EncPlaintext message = new NoteEncryption.Encryption.EncPlaintext();
    message.setData("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> noteEncryption.encryptToRecipient(pkD, message));
  }

  /**
   * Method under test:
   * {@link NoteEncryption#encryptToOurselves(byte[], byte[], byte[], NoteEncryption.Encryption.OutPlaintext)}
   */
  @Test
  public void testEncryptToOurselves() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    byte[] epk = "A A A A ".getBytes("UTF-8");
    NoteEncryption noteEncryption = new NoteEncryption(epk, "A A A A ".getBytes("UTF-8"), true, true);
    byte[] ovk = "AXAXAXAX".getBytes("UTF-8");
    byte[] cv = "AXAXAXAX".getBytes("UTF-8");
    byte[] cm = "AXAXAXAX".getBytes("UTF-8");

    NoteEncryption.Encryption.OutPlaintext message = new NoteEncryption.Encryption.OutPlaintext();
    message.setData("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> noteEncryption.encryptToOurselves(ovk, cv, cm, message));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NoteEncryption.Encryption.EncCiphertext#setData(byte[])}
   *   <li>{@link NoteEncryption.Encryption.EncCiphertext#getData()}
   * </ul>
   */
  @Test
  public void testEncryption_EncCiphertextGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    NoteEncryption.Encryption.EncCiphertext encCiphertext = new NoteEncryption.Encryption.EncCiphertext();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    encCiphertext.setData(data);

    // Assert that nothing has changed
    assertSame(data, encCiphertext.getData());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link NoteEncryption.Encryption.EncCiphertext}
   */
  @Test
  public void testEncryption_EncCiphertextNewEncCiphertext() {
    // Arrange, Act and Assert
    byte[] data = (new NoteEncryption.Encryption.EncCiphertext()).getData();
    assertEquals((byte) 0, data[0]);
    assertEquals((byte) 0, data[1]);
    assertEquals((byte) 0, data[10]);
    assertEquals((byte) 0, data[11]);
    assertEquals((byte) 0, data[12]);
    assertEquals((byte) 0, data[13]);
    assertEquals((byte) 0, data[14]);
    assertEquals((byte) 0, data[15]);
    assertEquals((byte) 0, data[17]);
    assertEquals((byte) 0, data[18]);
    assertEquals((byte) 0, data[19]);
    assertEquals((byte) 0, data[2]);
    assertEquals((byte) 0, data[20]);
    assertEquals((byte) 0, data[21]);
    assertEquals((byte) 0, data[22]);
    assertEquals((byte) 0, data[23]);
    assertEquals((byte) 0, data[24]);
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 0, data[4]);
    assertEquals((byte) 0, data[5]);
    assertEquals((byte) 0, data[555]);
    assertEquals((byte) 0, data[556]);
    assertEquals((byte) 0, data[557]);
    assertEquals((byte) 0, data[558]);
    assertEquals((byte) 0, data[559]);
    assertEquals((byte) 0, data[560]);
    assertEquals((byte) 0, data[561]);
    assertEquals((byte) 0, data[562]);
    assertEquals((byte) 0, data[563]);
    assertEquals((byte) 0, data[564]);
    assertEquals((byte) 0, data[565]);
    assertEquals((byte) 0, data[566]);
    assertEquals((byte) 0, data[567]);
    assertEquals((byte) 0, data[568]);
    assertEquals((byte) 0, data[569]);
    assertEquals((byte) 0, data[570]);
    assertEquals((byte) 0, data[571]);
    assertEquals((byte) 0, data[572]);
    assertEquals((byte) 0, data[573]);
    assertEquals((byte) 0, data[574]);
    assertEquals((byte) 0, data[575]);
    assertEquals((byte) 0, data[576]);
    assertEquals((byte) 0, data[577]);
    assertEquals((byte) 0, data[578]);
    assertEquals((byte) 0, data[579]);
    assertEquals((byte) 0, data[6]);
    assertEquals((byte) 0, data[7]);
    assertEquals((byte) 0, data[8]);
    assertEquals((byte) 0, data[9]);
    assertEquals((byte) 0, data[Short.SIZE]);
    assertEquals(580, data.length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NoteEncryption.Encryption.EncPlaintext#setData(byte[])}
   *   <li>{@link NoteEncryption.Encryption.EncPlaintext#getData()}
   * </ul>
   */
  @Test
  public void testEncryption_EncPlaintextGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    NoteEncryption.Encryption.EncPlaintext encPlaintext = new NoteEncryption.Encryption.EncPlaintext();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    encPlaintext.setData(data);

    // Assert that nothing has changed
    assertSame(data, encPlaintext.getData());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link NoteEncryption.Encryption.EncPlaintext}
   */
  @Test
  public void testEncryption_EncPlaintextNewEncPlaintext() {
    // Arrange, Act and Assert
    byte[] data = (new NoteEncryption.Encryption.EncPlaintext()).getData();
    assertEquals((byte) 0, data[0]);
    assertEquals((byte) 0, data[1]);
    assertEquals((byte) 0, data[10]);
    assertEquals((byte) 0, data[11]);
    assertEquals((byte) 0, data[12]);
    assertEquals((byte) 0, data[13]);
    assertEquals((byte) 0, data[14]);
    assertEquals((byte) 0, data[15]);
    assertEquals((byte) 0, data[17]);
    assertEquals((byte) 0, data[18]);
    assertEquals((byte) 0, data[19]);
    assertEquals((byte) 0, data[2]);
    assertEquals((byte) 0, data[20]);
    assertEquals((byte) 0, data[21]);
    assertEquals((byte) 0, data[22]);
    assertEquals((byte) 0, data[23]);
    assertEquals((byte) 0, data[24]);
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 0, data[4]);
    assertEquals((byte) 0, data[5]);
    assertEquals((byte) 0, data[539]);
    assertEquals((byte) 0, data[540]);
    assertEquals((byte) 0, data[541]);
    assertEquals((byte) 0, data[542]);
    assertEquals((byte) 0, data[543]);
    assertEquals((byte) 0, data[544]);
    assertEquals((byte) 0, data[545]);
    assertEquals((byte) 0, data[546]);
    assertEquals((byte) 0, data[547]);
    assertEquals((byte) 0, data[548]);
    assertEquals((byte) 0, data[549]);
    assertEquals((byte) 0, data[550]);
    assertEquals((byte) 0, data[551]);
    assertEquals((byte) 0, data[552]);
    assertEquals((byte) 0, data[553]);
    assertEquals((byte) 0, data[554]);
    assertEquals((byte) 0, data[555]);
    assertEquals((byte) 0, data[556]);
    assertEquals((byte) 0, data[557]);
    assertEquals((byte) 0, data[558]);
    assertEquals((byte) 0, data[559]);
    assertEquals((byte) 0, data[560]);
    assertEquals((byte) 0, data[561]);
    assertEquals((byte) 0, data[562]);
    assertEquals((byte) 0, data[563]);
    assertEquals((byte) 0, data[6]);
    assertEquals((byte) 0, data[7]);
    assertEquals((byte) 0, data[8]);
    assertEquals((byte) 0, data[9]);
    assertEquals((byte) 0, data[Short.SIZE]);
    assertEquals(564, data.length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NoteEncryption.Encryption.OutCiphertext#setData(byte[])}
   *   <li>{@link NoteEncryption.Encryption.OutCiphertext#getData()}
   * </ul>
   */
  @Test
  public void testEncryption_OutCiphertextGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    NoteEncryption.Encryption.OutCiphertext outCiphertext = new NoteEncryption.Encryption.OutCiphertext();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    outCiphertext.setData(data);

    // Assert that nothing has changed
    assertSame(data, outCiphertext.getData());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link NoteEncryption.Encryption.OutCiphertext}
   */
  @Test
  public void testEncryption_OutCiphertextNewOutCiphertext() {
    // Arrange, Act and Assert
    byte[] data = (new NoteEncryption.Encryption.OutCiphertext()).getData();
    assertEquals((byte) 0, data[0]);
    assertEquals((byte) 0, data[1]);
    assertEquals((byte) 0, data[10]);
    assertEquals((byte) 0, data[11]);
    assertEquals((byte) 0, data[12]);
    assertEquals((byte) 0, data[13]);
    assertEquals((byte) 0, data[14]);
    assertEquals((byte) 0, data[15]);
    assertEquals((byte) 0, data[17]);
    assertEquals((byte) 0, data[18]);
    assertEquals((byte) 0, data[19]);
    assertEquals((byte) 0, data[2]);
    assertEquals((byte) 0, data[20]);
    assertEquals((byte) 0, data[21]);
    assertEquals((byte) 0, data[22]);
    assertEquals((byte) 0, data[23]);
    assertEquals((byte) 0, data[24]);
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 0, data[4]);
    assertEquals((byte) 0, data[5]);
    assertEquals((byte) 0, data[55]);
    assertEquals((byte) 0, data[56]);
    assertEquals((byte) 0, data[57]);
    assertEquals((byte) 0, data[58]);
    assertEquals((byte) 0, data[59]);
    assertEquals((byte) 0, data[6]);
    assertEquals((byte) 0, data[60]);
    assertEquals((byte) 0, data[61]);
    assertEquals((byte) 0, data[62]);
    assertEquals((byte) 0, data[63]);
    assertEquals((byte) 0, data[65]);
    assertEquals((byte) 0, data[66]);
    assertEquals((byte) 0, data[67]);
    assertEquals((byte) 0, data[68]);
    assertEquals((byte) 0, data[69]);
    assertEquals((byte) 0, data[7]);
    assertEquals((byte) 0, data[70]);
    assertEquals((byte) 0, data[71]);
    assertEquals((byte) 0, data[72]);
    assertEquals((byte) 0, data[73]);
    assertEquals((byte) 0, data[74]);
    assertEquals((byte) 0, data[75]);
    assertEquals((byte) 0, data[76]);
    assertEquals((byte) 0, data[77]);
    assertEquals((byte) 0, data[78]);
    assertEquals((byte) 0, data[79]);
    assertEquals((byte) 0, data[8]);
    assertEquals((byte) 0, data[9]);
    assertEquals((byte) 0, data[Double.SIZE]);
    assertEquals((byte) 0, data[Short.SIZE]);
    assertEquals(80, data.length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NoteEncryption.Encryption.OutPlaintext#setData(byte[])}
   *   <li>{@link NoteEncryption.Encryption.OutPlaintext#getData()}
   * </ul>
   */
  @Test
  public void testEncryption_OutPlaintextGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    NoteEncryption.Encryption.OutPlaintext outPlaintext = new NoteEncryption.Encryption.OutPlaintext();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    outPlaintext.setData(data);

    // Assert that nothing has changed
    assertSame(data, outPlaintext.getData());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link NoteEncryption.Encryption.OutPlaintext}
   */
  @Test
  public void testEncryption_OutPlaintextNewOutPlaintext() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        (new NoteEncryption.Encryption.OutPlaintext()).getData());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NoteEncryption#NoteEncryption(byte[], byte[])}
   *   <li>{@link NoteEncryption#getEpk()}
   *   <li>{@link NoteEncryption#getEsk()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] epk = "AXAXAXAX".getBytes("UTF-8");
    byte[] esk = "AXAXAXAX".getBytes("UTF-8");

    // Act
    NoteEncryption actualNoteEncryption = new NoteEncryption(epk, esk);
    byte[] actualEpk = actualNoteEncryption.getEpk();

    // Assert
    assertSame(epk, actualEpk);
    assertSame(esk, actualNoteEncryption.getEsk());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NoteEncryption#NoteEncryption(byte[], byte[], boolean, boolean)}
   *   <li>{@link NoteEncryption#getEpk()}
   *   <li>{@link NoteEncryption#getEsk()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() throws UnsupportedEncodingException {
    // Arrange
    byte[] epk = "AXAXAXAX".getBytes("UTF-8");
    byte[] esk = "AXAXAXAX".getBytes("UTF-8");

    // Act
    NoteEncryption actualNoteEncryption = new NoteEncryption(epk, esk, true, true);
    byte[] actualEpk = actualNoteEncryption.getEpk();

    // Assert
    assertSame(epk, actualEpk);
    assertSame(esk, actualNoteEncryption.getEsk());
  }
}
