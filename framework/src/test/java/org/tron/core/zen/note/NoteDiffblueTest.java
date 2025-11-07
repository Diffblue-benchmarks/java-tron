package org.tron.core.zen.note;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.exception.ZksnarkException;
import org.tron.core.zen.address.DiversifierT;
import org.tron.core.zen.address.IncomingViewingKey;
import org.tron.core.zen.address.PaymentAddress;

public class NoteDiffblueTest {
  /**
   * Method under test:
   * {@link Note#decode(NoteEncryption.Encryption.EncPlaintext)}
   */
  @Test
  public void testDecode() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    NoteEncryption.Encryption.EncPlaintext encPlaintext = new NoteEncryption.Encryption.EncPlaintext();
    encPlaintext.setData("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> Note.decode(encPlaintext));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link Note.NotePlaintextEncryptionResult#NotePlaintextEncryptionResult(Note, byte[], NoteEncryption)}
   *   <li>{@link Note.NotePlaintextEncryptionResult#setEncCiphertext(byte[])}
   *   <li>
   * {@link Note.NotePlaintextEncryptionResult#setNoteEncryption(NoteEncryption)}
   *   <li>{@link Note.NotePlaintextEncryptionResult#getEncCiphertext()}
   *   <li>{@link Note.NotePlaintextEncryptionResult#getNoteEncryption()}
   * </ul>
   */
  @Test
  public void testNotePlaintextEncryptionResultGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    Note note = new Note();
    byte[] encCiphertext = "AXAXAXAX".getBytes("UTF-8");
    byte[] epk = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Note.NotePlaintextEncryptionResult actualNotePlaintextEncryptionResult = note.new NotePlaintextEncryptionResult(
        encCiphertext, new NoteEncryption(epk, "AXAXAXAX".getBytes("UTF-8")));
    byte[] encCiphertext2 = "AXAXAXAX".getBytes("UTF-8");
    actualNotePlaintextEncryptionResult.setEncCiphertext(encCiphertext2);
    byte[] epk2 = "AXAXAXAX".getBytes("UTF-8");
    NoteEncryption noteEncryption = new NoteEncryption(epk2, "AXAXAXAX".getBytes("UTF-8"));

    actualNotePlaintextEncryptionResult.setNoteEncryption(noteEncryption);
    byte[] actualEncCiphertext = actualNotePlaintextEncryptionResult.getEncCiphertext();

    // Assert that nothing has changed
    assertSame(noteEncryption, actualNotePlaintextEncryptionResult.getNoteEncryption());
    assertSame(encCiphertext2, actualEncCiphertext);
  }

  /**
   * Method under test: {@link Note#setMemo(byte[])}
   */
  @Test
  public void testSetMemo() throws UnsupportedEncodingException {
    // Arrange
    Note note = new Note();

    // Act
    note.setMemo("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] memo = note.getMemo();
    assertEquals(512, memo.length);
    assertEquals('A', memo[0]);
    assertEquals('A', memo[2]);
    assertEquals('A', memo[4]);
    assertEquals('A', memo[6]);
    assertEquals('X', memo[1]);
    assertEquals('X', memo[3]);
    assertEquals('X', memo[5]);
    assertEquals('X', memo[7]);
  }

  /**
   * Method under test: {@link Note#setMemo(byte[])}
   */
  @Test
  public void testSetMemo2() {
    // Arrange
    Note note = new Note();

    // Act
    note.setMemo(null);

    // Assert that nothing has changed
    byte[] memo = note.getMemo();
    assertEquals((byte) 0, memo[0]);
    assertEquals((byte) 0, memo[1]);
    assertEquals((byte) 0, memo[2]);
    assertEquals((byte) 0, memo[3]);
    assertEquals((byte) 0, memo[4]);
    assertEquals((byte) 0, memo[5]);
    assertEquals((byte) 0, memo[6]);
    assertEquals((byte) 0, memo[7]);
    assertEquals(512, memo.length);
  }

  /**
   * Method under test: {@link Note#setMemo(byte[])}
   */
  @Test
  public void testSetMemo3() {
    // Arrange
    Note note = new Note();

    // Act
    note.setMemo(new byte[]{});

    // Assert that nothing has changed
    byte[] memo = note.getMemo();
    assertEquals((byte) 0, memo[0]);
    assertEquals((byte) 0, memo[1]);
    assertEquals((byte) 0, memo[2]);
    assertEquals((byte) 0, memo[3]);
    assertEquals((byte) 0, memo[4]);
    assertEquals((byte) 0, memo[5]);
    assertEquals((byte) 0, memo[6]);
    assertEquals((byte) 0, memo[7]);
    assertEquals(512, memo.length);
  }

  /**
   * Method under test: {@link Note#note(IncomingViewingKey)}
   */
  @Test
  public void testNote() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    Note note = new Note();
    IncomingViewingKey ivk = mock(IncomingViewingKey.class);
    DiversifierT d = DiversifierT.random();
    Optional<PaymentAddress> ofResult = Optional.of(new PaymentAddress(d, "AXAXAXAX".getBytes("UTF-8")));
    when(ivk.address(Mockito.<DiversifierT>any())).thenReturn(ofResult);

    // Act
    Optional<Note> actualNoteResult = note.note(ivk);

    // Assert
    verify(ivk).address(isA(DiversifierT.class));
    Note getResult = actualNoteResult.get();
    assertEquals(0L, getResult.getValue());
    byte[] memo = getResult.getMemo();
    assertEquals((byte) 0, memo[0]);
    assertEquals((byte) 0, memo[1]);
    assertEquals((byte) 0, memo[10]);
    assertEquals((byte) 0, memo[11]);
    assertEquals((byte) 0, memo[12]);
    assertEquals((byte) 0, memo[13]);
    assertEquals((byte) 0, memo[14]);
    assertEquals((byte) 0, memo[15]);
    assertEquals((byte) 0, memo[17]);
    assertEquals((byte) 0, memo[18]);
    assertEquals((byte) 0, memo[19]);
    assertEquals((byte) 0, memo[2]);
    assertEquals((byte) 0, memo[20]);
    assertEquals((byte) 0, memo[21]);
    assertEquals((byte) 0, memo[22]);
    assertEquals((byte) 0, memo[23]);
    assertEquals((byte) 0, memo[24]);
    assertEquals((byte) 0, memo[3]);
    assertEquals((byte) 0, memo[4]);
    assertEquals((byte) 0, memo[487]);
    assertEquals((byte) 0, memo[488]);
    assertEquals((byte) 0, memo[489]);
    assertEquals((byte) 0, memo[490]);
    assertEquals((byte) 0, memo[491]);
    assertEquals((byte) 0, memo[492]);
    assertEquals((byte) 0, memo[493]);
    assertEquals((byte) 0, memo[494]);
    assertEquals((byte) 0, memo[495]);
    assertEquals((byte) 0, memo[496]);
    assertEquals((byte) 0, memo[497]);
    assertEquals((byte) 0, memo[498]);
    assertEquals((byte) 0, memo[499]);
    assertEquals((byte) 0, memo[5]);
    assertEquals((byte) 0, memo[500]);
    assertEquals((byte) 0, memo[501]);
    assertEquals((byte) 0, memo[502]);
    assertEquals((byte) 0, memo[503]);
    assertEquals((byte) 0, memo[504]);
    assertEquals((byte) 0, memo[505]);
    assertEquals((byte) 0, memo[506]);
    assertEquals((byte) 0, memo[507]);
    assertEquals((byte) 0, memo[508]);
    assertEquals((byte) 0, memo[509]);
    assertEquals((byte) 0, memo[510]);
    assertEquals((byte) 0, memo[511]);
    assertEquals((byte) 0, memo[6]);
    assertEquals((byte) 0, memo[7]);
    assertEquals((byte) 0, memo[8]);
    assertEquals((byte) 0, memo[9]);
    assertEquals((byte) 0, memo[Short.SIZE]);
    assertEquals(512, memo.length);
    assertTrue(actualNoteResult.isPresent());
    byte[] expectedPkD = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPkD, getResult.getPkD());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getResult.getD().getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getRcm());
  }

  /**
   * Method under test: {@link Note#note(IncomingViewingKey)}
   */
  @Test
  public void testNote2() throws ZksnarkException {
    // Arrange
    Note note = new Note();
    IncomingViewingKey ivk = mock(IncomingViewingKey.class);
    Optional<PaymentAddress> emptyResult = Optional.empty();
    when(ivk.address(Mockito.<DiversifierT>any())).thenReturn(emptyResult);

    // Act
    Optional<Note> actualNoteResult = note.note(ivk);

    // Assert
    verify(ivk).address(isA(DiversifierT.class));
    assertFalse(actualNoteResult.isPresent());
    assertSame(emptyResult, actualNoteResult);
  }

  /**
   * Method under test: {@link Note#encode()}
   */
  @Test
  public void testEncode() {
    // Arrange, Act and Assert
    byte[] data = (new Note()).encode().getData();
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
    assertEquals((byte) 1, data[0]);
    assertEquals(564, data.length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Note#setD(DiversifierT)}
   *   <li>{@link Note#setPkD(byte[])}
   *   <li>{@link Note#setRcm(byte[])}
   *   <li>{@link Note#setValue(long)}
   *   <li>{@link Note#getD()}
   *   <li>{@link Note#getMemo()}
   *   <li>{@link Note#getPkD()}
   *   <li>{@link Note#getRcm()}
   *   <li>{@link Note#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    Note note = new Note();
    DiversifierT d = DiversifierT.random();

    // Act
    note.setD(d);
    byte[] pkD = "AXAXAXAX".getBytes("UTF-8");
    note.setPkD(pkD);
    byte[] rcm = "AXAXAXAX".getBytes("UTF-8");
    note.setRcm(rcm);
    note.setValue(42L);
    DiversifierT actualD = note.getD();
    byte[] actualMemo = note.getMemo();
    byte[] actualPkD = note.getPkD();
    byte[] actualRcm = note.getRcm();

    // Assert that nothing has changed
    assertEquals((byte) 0, actualMemo[0]);
    assertEquals((byte) 0, actualMemo[1]);
    assertEquals((byte) 0, actualMemo[10]);
    assertEquals((byte) 0, actualMemo[11]);
    assertEquals((byte) 0, actualMemo[12]);
    assertEquals((byte) 0, actualMemo[13]);
    assertEquals((byte) 0, actualMemo[14]);
    assertEquals((byte) 0, actualMemo[15]);
    assertEquals((byte) 0, actualMemo[17]);
    assertEquals((byte) 0, actualMemo[18]);
    assertEquals((byte) 0, actualMemo[19]);
    assertEquals((byte) 0, actualMemo[2]);
    assertEquals((byte) 0, actualMemo[20]);
    assertEquals((byte) 0, actualMemo[21]);
    assertEquals((byte) 0, actualMemo[22]);
    assertEquals((byte) 0, actualMemo[23]);
    assertEquals((byte) 0, actualMemo[24]);
    assertEquals((byte) 0, actualMemo[3]);
    assertEquals((byte) 0, actualMemo[4]);
    assertEquals((byte) 0, actualMemo[487]);
    assertEquals((byte) 0, actualMemo[488]);
    assertEquals((byte) 0, actualMemo[489]);
    assertEquals((byte) 0, actualMemo[490]);
    assertEquals((byte) 0, actualMemo[491]);
    assertEquals((byte) 0, actualMemo[492]);
    assertEquals((byte) 0, actualMemo[493]);
    assertEquals((byte) 0, actualMemo[494]);
    assertEquals((byte) 0, actualMemo[495]);
    assertEquals((byte) 0, actualMemo[496]);
    assertEquals((byte) 0, actualMemo[497]);
    assertEquals((byte) 0, actualMemo[498]);
    assertEquals((byte) 0, actualMemo[499]);
    assertEquals((byte) 0, actualMemo[5]);
    assertEquals((byte) 0, actualMemo[500]);
    assertEquals((byte) 0, actualMemo[501]);
    assertEquals((byte) 0, actualMemo[502]);
    assertEquals((byte) 0, actualMemo[503]);
    assertEquals((byte) 0, actualMemo[504]);
    assertEquals((byte) 0, actualMemo[505]);
    assertEquals((byte) 0, actualMemo[506]);
    assertEquals((byte) 0, actualMemo[507]);
    assertEquals((byte) 0, actualMemo[508]);
    assertEquals((byte) 0, actualMemo[509]);
    assertEquals((byte) 0, actualMemo[510]);
    assertEquals((byte) 0, actualMemo[511]);
    assertEquals((byte) 0, actualMemo[6]);
    assertEquals((byte) 0, actualMemo[7]);
    assertEquals((byte) 0, actualMemo[8]);
    assertEquals((byte) 0, actualMemo[9]);
    assertEquals((byte) 0, actualMemo[Short.SIZE]);
    assertEquals(42L, note.getValue());
    assertEquals(512, actualMemo.length);
    assertSame(pkD, actualPkD);
    assertSame(rcm, actualRcm);
    assertSame(d, actualD);
  }

  /**
   * Method under test: {@link Note#Note()}
   */
  @Test
  public void testNewNote() {
    // Arrange and Act
    Note actualNote = new Note();

    // Assert
    assertNull(actualNote.getPkD());
    assertEquals(0L, actualNote.getValue());
    byte[] memo = actualNote.getMemo();
    assertEquals((byte) 0, memo[0]);
    assertEquals((byte) 0, memo[1]);
    assertEquals((byte) 0, memo[10]);
    assertEquals((byte) 0, memo[11]);
    assertEquals((byte) 0, memo[12]);
    assertEquals((byte) 0, memo[13]);
    assertEquals((byte) 0, memo[14]);
    assertEquals((byte) 0, memo[15]);
    assertEquals((byte) 0, memo[17]);
    assertEquals((byte) 0, memo[18]);
    assertEquals((byte) 0, memo[19]);
    assertEquals((byte) 0, memo[2]);
    assertEquals((byte) 0, memo[20]);
    assertEquals((byte) 0, memo[21]);
    assertEquals((byte) 0, memo[22]);
    assertEquals((byte) 0, memo[23]);
    assertEquals((byte) 0, memo[24]);
    assertEquals((byte) 0, memo[3]);
    assertEquals((byte) 0, memo[4]);
    assertEquals((byte) 0, memo[487]);
    assertEquals((byte) 0, memo[488]);
    assertEquals((byte) 0, memo[489]);
    assertEquals((byte) 0, memo[490]);
    assertEquals((byte) 0, memo[491]);
    assertEquals((byte) 0, memo[492]);
    assertEquals((byte) 0, memo[493]);
    assertEquals((byte) 0, memo[494]);
    assertEquals((byte) 0, memo[495]);
    assertEquals((byte) 0, memo[496]);
    assertEquals((byte) 0, memo[497]);
    assertEquals((byte) 0, memo[498]);
    assertEquals((byte) 0, memo[499]);
    assertEquals((byte) 0, memo[5]);
    assertEquals((byte) 0, memo[500]);
    assertEquals((byte) 0, memo[501]);
    assertEquals((byte) 0, memo[502]);
    assertEquals((byte) 0, memo[503]);
    assertEquals((byte) 0, memo[504]);
    assertEquals((byte) 0, memo[505]);
    assertEquals((byte) 0, memo[506]);
    assertEquals((byte) 0, memo[507]);
    assertEquals((byte) 0, memo[508]);
    assertEquals((byte) 0, memo[509]);
    assertEquals((byte) 0, memo[510]);
    assertEquals((byte) 0, memo[511]);
    assertEquals((byte) 0, memo[6]);
    assertEquals((byte) 0, memo[7]);
    assertEquals((byte) 0, memo[8]);
    assertEquals((byte) 0, memo[9]);
    assertEquals((byte) 0, memo[Short.SIZE]);
    assertEquals(512, memo.length);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, actualNote.getD().getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualNote.getRcm());
  }

  /**
   * Method under test: {@link Note#Note(DiversifierT, byte[], long, byte[])}
   */
  @Test
  public void testNewNote2() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    DiversifierT d = DiversifierT.random();
    byte[] pkD = "AXAXAXAX".getBytes("UTF-8");
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Note actualNote = new Note(d, pkD, 42L, r);

    // Assert
    byte[] memo = actualNote.getMemo();
    assertEquals((byte) 0, memo[0]);
    assertEquals((byte) 0, memo[1]);
    assertEquals((byte) 0, memo[10]);
    assertEquals((byte) 0, memo[11]);
    assertEquals((byte) 0, memo[12]);
    assertEquals((byte) 0, memo[13]);
    assertEquals((byte) 0, memo[14]);
    assertEquals((byte) 0, memo[15]);
    assertEquals((byte) 0, memo[17]);
    assertEquals((byte) 0, memo[18]);
    assertEquals((byte) 0, memo[19]);
    assertEquals((byte) 0, memo[2]);
    assertEquals((byte) 0, memo[20]);
    assertEquals((byte) 0, memo[21]);
    assertEquals((byte) 0, memo[22]);
    assertEquals((byte) 0, memo[23]);
    assertEquals((byte) 0, memo[24]);
    assertEquals((byte) 0, memo[3]);
    assertEquals((byte) 0, memo[4]);
    assertEquals((byte) 0, memo[487]);
    assertEquals((byte) 0, memo[488]);
    assertEquals((byte) 0, memo[489]);
    assertEquals((byte) 0, memo[490]);
    assertEquals((byte) 0, memo[491]);
    assertEquals((byte) 0, memo[492]);
    assertEquals((byte) 0, memo[493]);
    assertEquals((byte) 0, memo[494]);
    assertEquals((byte) 0, memo[495]);
    assertEquals((byte) 0, memo[496]);
    assertEquals((byte) 0, memo[497]);
    assertEquals((byte) 0, memo[498]);
    assertEquals((byte) 0, memo[499]);
    assertEquals((byte) 0, memo[5]);
    assertEquals((byte) 0, memo[500]);
    assertEquals((byte) 0, memo[501]);
    assertEquals((byte) 0, memo[502]);
    assertEquals((byte) 0, memo[503]);
    assertEquals((byte) 0, memo[504]);
    assertEquals((byte) 0, memo[505]);
    assertEquals((byte) 0, memo[506]);
    assertEquals((byte) 0, memo[507]);
    assertEquals((byte) 0, memo[508]);
    assertEquals((byte) 0, memo[509]);
    assertEquals((byte) 0, memo[510]);
    assertEquals((byte) 0, memo[511]);
    assertEquals((byte) 0, memo[6]);
    assertEquals((byte) 0, memo[7]);
    assertEquals((byte) 0, memo[8]);
    assertEquals((byte) 0, memo[9]);
    assertEquals((byte) 0, memo[Short.SIZE]);
    assertEquals(42L, actualNote.getValue());
    assertEquals(512, memo.length);
    assertSame(pkD, actualNote.getPkD());
    assertSame(r, actualNote.getRcm());
    assertSame(d, actualNote.getD());
  }

  /**
   * Method under test:
   * {@link Note#Note(DiversifierT, byte[], long, byte[], byte[])}
   */
  @Test
  public void testNewNote3() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    DiversifierT d = DiversifierT.random();
    byte[] pkD = "AXAXAXAX".getBytes("UTF-8");
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Note actualNote = new Note(d, pkD, 42L, r, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] memo = actualNote.getMemo();
    assertEquals((byte) 0, memo[10]);
    assertEquals((byte) 0, memo[11]);
    assertEquals((byte) 0, memo[12]);
    assertEquals((byte) 0, memo[13]);
    assertEquals((byte) 0, memo[14]);
    assertEquals((byte) 0, memo[15]);
    assertEquals((byte) 0, memo[17]);
    assertEquals((byte) 0, memo[18]);
    assertEquals((byte) 0, memo[19]);
    assertEquals((byte) 0, memo[20]);
    assertEquals((byte) 0, memo[21]);
    assertEquals((byte) 0, memo[22]);
    assertEquals((byte) 0, memo[23]);
    assertEquals((byte) 0, memo[24]);
    assertEquals((byte) 0, memo[487]);
    assertEquals((byte) 0, memo[488]);
    assertEquals((byte) 0, memo[489]);
    assertEquals((byte) 0, memo[490]);
    assertEquals((byte) 0, memo[491]);
    assertEquals((byte) 0, memo[492]);
    assertEquals((byte) 0, memo[493]);
    assertEquals((byte) 0, memo[494]);
    assertEquals((byte) 0, memo[495]);
    assertEquals((byte) 0, memo[496]);
    assertEquals((byte) 0, memo[497]);
    assertEquals((byte) 0, memo[498]);
    assertEquals((byte) 0, memo[499]);
    assertEquals((byte) 0, memo[500]);
    assertEquals((byte) 0, memo[501]);
    assertEquals((byte) 0, memo[502]);
    assertEquals((byte) 0, memo[503]);
    assertEquals((byte) 0, memo[504]);
    assertEquals((byte) 0, memo[505]);
    assertEquals((byte) 0, memo[506]);
    assertEquals((byte) 0, memo[507]);
    assertEquals((byte) 0, memo[508]);
    assertEquals((byte) 0, memo[509]);
    assertEquals((byte) 0, memo[510]);
    assertEquals((byte) 0, memo[511]);
    assertEquals((byte) 0, memo[8]);
    assertEquals((byte) 0, memo[9]);
    assertEquals((byte) 0, memo[Short.SIZE]);
    assertEquals(42L, actualNote.getValue());
    assertEquals(512, memo.length);
    assertEquals('A', memo[0]);
    assertEquals('A', memo[2]);
    assertEquals('A', memo[4]);
    assertEquals('A', memo[6]);
    assertEquals('X', memo[1]);
    assertEquals('X', memo[3]);
    assertEquals('X', memo[5]);
    assertEquals('X', memo[7]);
    assertSame(pkD, actualNote.getPkD());
    assertSame(r, actualNote.getRcm());
    assertSame(d, actualNote.getD());
  }

  /**
   * Method under test:
   * {@link Note#Note(DiversifierT, byte[], long, byte[], byte[])}
   */
  @Test
  public void testNewNote4() throws ZksnarkException {
    // Arrange
    DiversifierT d = DiversifierT.random();
    byte[] pkD = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};
    byte[] r = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    Note actualNote = new Note(d, pkD, 42L, r, null);

    // Assert
    byte[] memo = actualNote.getMemo();
    assertEquals((byte) 0, memo[0]);
    assertEquals((byte) 0, memo[1]);
    assertEquals((byte) 0, memo[10]);
    assertEquals((byte) 0, memo[11]);
    assertEquals((byte) 0, memo[12]);
    assertEquals((byte) 0, memo[13]);
    assertEquals((byte) 0, memo[14]);
    assertEquals((byte) 0, memo[15]);
    assertEquals((byte) 0, memo[17]);
    assertEquals((byte) 0, memo[18]);
    assertEquals((byte) 0, memo[19]);
    assertEquals((byte) 0, memo[2]);
    assertEquals((byte) 0, memo[20]);
    assertEquals((byte) 0, memo[21]);
    assertEquals((byte) 0, memo[22]);
    assertEquals((byte) 0, memo[23]);
    assertEquals((byte) 0, memo[24]);
    assertEquals((byte) 0, memo[3]);
    assertEquals((byte) 0, memo[4]);
    assertEquals((byte) 0, memo[487]);
    assertEquals((byte) 0, memo[488]);
    assertEquals((byte) 0, memo[489]);
    assertEquals((byte) 0, memo[490]);
    assertEquals((byte) 0, memo[491]);
    assertEquals((byte) 0, memo[492]);
    assertEquals((byte) 0, memo[493]);
    assertEquals((byte) 0, memo[494]);
    assertEquals((byte) 0, memo[495]);
    assertEquals((byte) 0, memo[496]);
    assertEquals((byte) 0, memo[497]);
    assertEquals((byte) 0, memo[498]);
    assertEquals((byte) 0, memo[499]);
    assertEquals((byte) 0, memo[5]);
    assertEquals((byte) 0, memo[500]);
    assertEquals((byte) 0, memo[501]);
    assertEquals((byte) 0, memo[502]);
    assertEquals((byte) 0, memo[503]);
    assertEquals((byte) 0, memo[504]);
    assertEquals((byte) 0, memo[505]);
    assertEquals((byte) 0, memo[506]);
    assertEquals((byte) 0, memo[507]);
    assertEquals((byte) 0, memo[508]);
    assertEquals((byte) 0, memo[509]);
    assertEquals((byte) 0, memo[510]);
    assertEquals((byte) 0, memo[511]);
    assertEquals((byte) 0, memo[6]);
    assertEquals((byte) 0, memo[7]);
    assertEquals((byte) 0, memo[8]);
    assertEquals((byte) 0, memo[9]);
    assertEquals((byte) 0, memo[Short.SIZE]);
    assertEquals(42L, actualNote.getValue());
    assertEquals(512, memo.length);
    assertSame(d, actualNote.getD());
    assertSame(pkD, actualNote.getPkD());
    assertSame(r, actualNote.getRcm());
  }

  /**
   * Method under test:
   * {@link Note#Note(DiversifierT, byte[], long, byte[], byte[])}
   */
  @Test
  public void testNewNote5() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    DiversifierT d = DiversifierT.random();
    byte[] pkD = "AXAXAXAX".getBytes("UTF-8");
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Note actualNote = new Note(d, pkD, 42L, r, new byte[]{});

    // Assert
    byte[] memo = actualNote.getMemo();
    assertEquals((byte) 0, memo[0]);
    assertEquals((byte) 0, memo[1]);
    assertEquals((byte) 0, memo[10]);
    assertEquals((byte) 0, memo[11]);
    assertEquals((byte) 0, memo[12]);
    assertEquals((byte) 0, memo[13]);
    assertEquals((byte) 0, memo[14]);
    assertEquals((byte) 0, memo[15]);
    assertEquals((byte) 0, memo[17]);
    assertEquals((byte) 0, memo[18]);
    assertEquals((byte) 0, memo[19]);
    assertEquals((byte) 0, memo[2]);
    assertEquals((byte) 0, memo[20]);
    assertEquals((byte) 0, memo[21]);
    assertEquals((byte) 0, memo[22]);
    assertEquals((byte) 0, memo[23]);
    assertEquals((byte) 0, memo[24]);
    assertEquals((byte) 0, memo[3]);
    assertEquals((byte) 0, memo[4]);
    assertEquals((byte) 0, memo[487]);
    assertEquals((byte) 0, memo[488]);
    assertEquals((byte) 0, memo[489]);
    assertEquals((byte) 0, memo[490]);
    assertEquals((byte) 0, memo[491]);
    assertEquals((byte) 0, memo[492]);
    assertEquals((byte) 0, memo[493]);
    assertEquals((byte) 0, memo[494]);
    assertEquals((byte) 0, memo[495]);
    assertEquals((byte) 0, memo[496]);
    assertEquals((byte) 0, memo[497]);
    assertEquals((byte) 0, memo[498]);
    assertEquals((byte) 0, memo[499]);
    assertEquals((byte) 0, memo[5]);
    assertEquals((byte) 0, memo[500]);
    assertEquals((byte) 0, memo[501]);
    assertEquals((byte) 0, memo[502]);
    assertEquals((byte) 0, memo[503]);
    assertEquals((byte) 0, memo[504]);
    assertEquals((byte) 0, memo[505]);
    assertEquals((byte) 0, memo[506]);
    assertEquals((byte) 0, memo[507]);
    assertEquals((byte) 0, memo[508]);
    assertEquals((byte) 0, memo[509]);
    assertEquals((byte) 0, memo[510]);
    assertEquals((byte) 0, memo[511]);
    assertEquals((byte) 0, memo[6]);
    assertEquals((byte) 0, memo[7]);
    assertEquals((byte) 0, memo[8]);
    assertEquals((byte) 0, memo[9]);
    assertEquals((byte) 0, memo[Short.SIZE]);
    assertEquals(42L, actualNote.getValue());
    assertEquals(512, memo.length);
    assertSame(pkD, actualNote.getPkD());
    assertSame(r, actualNote.getRcm());
    assertSame(d, actualNote.getD());
  }
}
