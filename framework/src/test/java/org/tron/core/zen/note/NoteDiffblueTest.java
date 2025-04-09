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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.exception.ZksnarkException;
import org.tron.core.zen.address.DiversifierT;
import org.tron.core.zen.address.IncomingViewingKey;
import org.tron.core.zen.address.PaymentAddress;
import org.tron.core.zen.note.Note.NotePlaintextEncryptionResult;
import org.tron.core.zen.note.NoteEncryption.Encryption;
import org.tron.core.zen.note.NoteEncryption.Encryption.EncPlaintext;

public class NoteDiffblueTest {
  /**
   * Test {@link Note#Note()}.
   * <p>
   * Method under test: {@link Note#Note()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Note.<init>()"})
  public void testNewNote() {
    // Arrange and Act
    Note actualNote = new Note();

    // Assert
    assertNull(actualNote.getPkD());
    assertEquals(0L, actualNote.getValue());
    assertEquals(512, actualNote.getMemo().length);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualNote.getRcm());
  }

  /**
   * Test {@link Note#Note(DiversifierT, byte[], long, byte[])}.
   * <p>
   * Method under test: {@link Note#Note(DiversifierT, byte[], long, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Note.<init>(DiversifierT, byte[], long, byte[])"})
  public void testNewNote2() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    DiversifierT d = DiversifierT.random();
    byte[] pkD = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Note actualNote = new Note(d, pkD, 42L, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(42L, actualNote.getValue());
    assertEquals(512, actualNote.getMemo().length);
    assertSame(d, actualNote.getD());
    byte[] expectedPkD = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPkD, actualNote.getPkD());
    byte[] expectedRcm = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedRcm, actualNote.getRcm());
  }

  /**
   * Test {@link Note#Note(DiversifierT, byte[], long, byte[], byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return first element is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Note#Note(DiversifierT, byte[], long, byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Note.<init>(DiversifierT, byte[], long, byte[], byte[])"})
  public void testNewNote_whenA_thenReturnFirstElementIsZero() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange and Act
    Note actualNote = new Note(DiversifierT.random(), new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 42L,
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, null);

    // Assert
    byte[] memo = actualNote.getMemo();
    assertEquals((byte) 0, memo[0]);
    assertEquals((byte) 0, memo[1]);
    assertEquals((byte) 0, memo[2]);
    assertEquals((byte) 0, memo[3]);
    assertEquals((byte) 0, memo[4]);
    assertEquals((byte) 0, memo[5]);
    assertEquals((byte) 0, memo[6]);
    assertEquals((byte) 0, memo[7]);
    assertEquals(512, memo.length);
    byte[] expectedPkD = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPkD, actualNote.getPkD());
    byte[] expectedRcm = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedRcm, actualNote.getRcm());
  }

  /**
   * Test {@link Note#Note(DiversifierT, byte[], long, byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return first element is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Note#Note(DiversifierT, byte[], long, byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Note.<init>(DiversifierT, byte[], long, byte[], byte[])"})
  public void testNewNote_whenAxaxaxaxBytesIsUtf8_thenReturnFirstElementIsA()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    DiversifierT d = DiversifierT.random();
    byte[] pkD = "AXAXAXAX".getBytes("UTF-8");
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Note actualNote = new Note(d, pkD, 42L, r, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] memo = actualNote.getMemo();
    assertEquals(512, memo.length);
    assertEquals('A', memo[0]);
    assertEquals('A', memo[2]);
    assertEquals('A', memo[4]);
    assertEquals('A', memo[6]);
    assertEquals('X', memo[1]);
    assertEquals('X', memo[3]);
    assertEquals('X', memo[5]);
    assertEquals('X', memo[7]);
    byte[] expectedPkD = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPkD, actualNote.getPkD());
    byte[] expectedRcm = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedRcm, actualNote.getRcm());
  }

  /**
   * Test {@link Note#Note(DiversifierT, byte[], long, byte[], byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return first element is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Note#Note(DiversifierT, byte[], long, byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Note.<init>(DiversifierT, byte[], long, byte[], byte[])"})
  public void testNewNote_whenEmptyArrayOfByte_thenReturnFirstElementIsZero()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    DiversifierT d = DiversifierT.random();
    byte[] pkD = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Note actualNote = new Note(d, pkD, 42L, "AXAXAXAX".getBytes("UTF-8"), new byte[]{});

    // Assert
    byte[] memo = actualNote.getMemo();
    assertEquals((byte) 0, memo[0]);
    assertEquals((byte) 0, memo[1]);
    assertEquals((byte) 0, memo[2]);
    assertEquals((byte) 0, memo[3]);
    assertEquals((byte) 0, memo[4]);
    assertEquals((byte) 0, memo[5]);
    assertEquals((byte) 0, memo[6]);
    assertEquals((byte) 0, memo[7]);
    assertEquals(512, memo.length);
    byte[] expectedPkD = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPkD, actualNote.getPkD());
    byte[] expectedRcm = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedRcm, actualNote.getRcm());
  }

  /**
   * Test {@link Note#decode(EncPlaintext)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link ZksnarkException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Note#decode(EncPlaintext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Note Note.decode(EncPlaintext)"})
  public void testDecode_givenAxaxaxaxBytesIsUtf8_thenThrowZksnarkException()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    EncPlaintext encPlaintext = new EncPlaintext();
    encPlaintext.setData("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> Note.decode(encPlaintext));
  }

  /**
   * Test NotePlaintextEncryptionResult getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotePlaintextEncryptionResult#NotePlaintextEncryptionResult(Note, byte[], NoteEncryption)}
   *   <li>{@link NotePlaintextEncryptionResult#setEncCiphertext(byte[])}
   *   <li>{@link NotePlaintextEncryptionResult#setNoteEncryption(NoteEncryption)}
   *   <li>{@link NotePlaintextEncryptionResult#getEncCiphertext()}
   *   <li>{@link NotePlaintextEncryptionResult#getNoteEncryption()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotePlaintextEncryptionResult.<init>(Note, byte[], NoteEncryption)",
      "byte[] NotePlaintextEncryptionResult.getEncCiphertext()",
      "NoteEncryption NotePlaintextEncryptionResult.getNoteEncryption()",
      "void NotePlaintextEncryptionResult.setEncCiphertext(byte[])",
      "void NotePlaintextEncryptionResult.setNoteEncryption(NoteEncryption)"})
  public void testNotePlaintextEncryptionResultGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    Note note = new Note();
    byte[] encCiphertext = "AXAXAXAX".getBytes("UTF-8");
    byte[] epk = "AXAXAXAX".getBytes("UTF-8");

    // Act
    NotePlaintextEncryptionResult actualNotePlaintextEncryptionResult = note.new NotePlaintextEncryptionResult(
        encCiphertext, new NoteEncryption(epk, "AXAXAXAX".getBytes("UTF-8")));
    byte[] encCiphertext2 = "AXAXAXAX".getBytes("UTF-8");
    actualNotePlaintextEncryptionResult.setEncCiphertext(encCiphertext2);
    byte[] epk2 = "AXAXAXAX".getBytes("UTF-8");
    NoteEncryption noteEncryption = new NoteEncryption(epk2, "AXAXAXAX".getBytes("UTF-8"));

    actualNotePlaintextEncryptionResult.setNoteEncryption(noteEncryption);
    byte[] actualEncCiphertext = actualNotePlaintextEncryptionResult.getEncCiphertext();

    // Assert
    assertSame(noteEncryption, actualNotePlaintextEncryptionResult.getNoteEncryption());
    assertSame(encCiphertext2, actualEncCiphertext);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualEncCiphertext);
  }

  /**
   * Test {@link Note#setMemo(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then first element is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Note#setMemo(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Note.setMemo(byte[])"})
  public void testSetMemo_whenAxaxaxaxBytesIsUtf8_thenFirstElementIsA() throws UnsupportedEncodingException {
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
   * Test {@link Note#setMemo(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then first element is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Note#setMemo(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Note.setMemo(byte[])"})
  public void testSetMemo_whenEmptyArrayOfByte_thenFirstElementIsZero() {
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
   * Test {@link Note#setMemo(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then first element is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Note#setMemo(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Note.setMemo(byte[])"})
  public void testSetMemo_whenNull_thenFirstElementIsZero() {
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
   * Test {@link Note#note(IncomingViewingKey)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link Note#note(IncomingViewingKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional Note.note(IncomingViewingKey)"})
  public void testNote_givenEmpty_thenReturnNotPresent() throws ZksnarkException {
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
  }

  /**
   * Test {@link Note#note(IncomingViewingKey)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} Value is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Note#note(IncomingViewingKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional Note.note(IncomingViewingKey)"})
  public void testNote_thenReturnGetValueIsZero() throws UnsupportedEncodingException, ZksnarkException {
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
    assertEquals(512, getResult.getMemo().length);
    assertTrue(actualNoteResult.isPresent());
    byte[] expectedPkD = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPkD, getResult.getPkD());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getRcm());
  }

  /**
   * Test {@link Note#encode()}.
   * <ul>
   *   <li>Given {@link Note#Note()}.</li>
   *   <li>Then return array length is five hundred sixty-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link Note#encode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EncPlaintext Note.encode()"})
  public void testEncode_givenNote_thenReturnArrayLengthIsFiveHundredSixtyFour() {
    // Arrange, Act and Assert
    assertEquals(564, (new Note()).encode().getData().length);
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DiversifierT Note.getD()", "byte[] Note.getMemo()", "byte[] Note.getPkD()",
      "byte[] Note.getRcm()", "long Note.getValue()", "void Note.setD(DiversifierT)", "void Note.setPkD(byte[])",
      "void Note.setRcm(byte[])", "void Note.setValue(long)"})
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

    // Assert
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPkD);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualRcm);
  }
}
