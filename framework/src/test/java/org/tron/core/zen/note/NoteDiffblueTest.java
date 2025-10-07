package org.tron.core.zen.note;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.ZksnarkException;
import org.tron.core.zen.address.DiversifierT;
import org.tron.core.zen.note.NoteEncryption.Encryption;
import org.tron.core.zen.note.NoteEncryption.Encryption.EncPlaintext;

public class NoteDiffblueTest {
  /**
   * Test {@link Note#Note()}.
   *
   * <p>Method under test: {@link Note#Note()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.<init>()"})
  public void testNewNote() {
    // Arrange and Act
    Note actualNote = new Note();

    // Assert
    assertNull(actualNote.getPkD());
    assertEquals(0L, actualNote.getValue());
    assertEquals(512, actualNote.getMemo().length);
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualNote.getRcm());
  }

  /**
   * Test {@link Note#Note(DiversifierT, byte[], long, byte[])}.
   *
   * <p>Method under test: {@link Note#Note(DiversifierT, byte[], long, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.<init>(DiversifierT, byte[], long, byte[])"})
  public void testNewNote2() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    DiversifierT d = DiversifierT.random();

    // Act
    Note actualNote = new Note(d, "AXAXAXAX".getBytes("UTF-8"), 42L, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(42L, actualNote.getValue());
    assertEquals(512, actualNote.getMemo().length);
    assertSame(d, actualNote.getD());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNote.getPkD());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNote.getRcm());
  }

  /**
   * Test {@link Note#Note(DiversifierT, byte[], long, byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return first element is zero.
   * </ul>
   *
   * <p>Method under test: {@link Note#Note(DiversifierT, byte[], long, byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.<init>(DiversifierT, byte[], long, byte[], byte[])"})
  public void testNewNote_whenA_thenReturnFirstElementIsZero()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange and Act
    Note actualNote =
        new Note(
            DiversifierT.random(),
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            42L,
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            null);

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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNote.getPkD());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNote.getRcm());
  }

  /**
   * Test {@link Note#Note(DiversifierT, byte[], long, byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return first element is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Note#Note(DiversifierT, byte[], long, byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.<init>(DiversifierT, byte[], long, byte[], byte[])"})
  public void testNewNote_whenAxaxaxaxBytesIsUtf8_thenReturnFirstElementIsA()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange and Act
    Note actualNote =
        new Note(
            DiversifierT.random(),
            "AXAXAXAX".getBytes("UTF-8"),
            42L,
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"));

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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNote.getPkD());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNote.getRcm());
  }

  /**
   * Test {@link Note#Note(DiversifierT, byte[], long, byte[], byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return first element is zero.
   * </ul>
   *
   * <p>Method under test: {@link Note#Note(DiversifierT, byte[], long, byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.<init>(DiversifierT, byte[], long, byte[], byte[])"})
  public void testNewNote_whenEmptyArrayOfByte_thenReturnFirstElementIsZero()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange and Act
    Note actualNote =
        new Note(
            DiversifierT.random(),
            "AXAXAXAX".getBytes("UTF-8"),
            42L,
            "AXAXAXAX".getBytes("UTF-8"),
            new byte[] {});

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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNote.getPkD());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNote.getRcm());
  }

  /**
   * Test {@link Note#decode(EncPlaintext)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link Note#decode(EncPlaintext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test {@link Note#setMemo(byte[])}.
   *
   * <ul>
   *   <li>Given {@link Note#Note()}.
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then first element is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Note#setMemo(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.setMemo(byte[])"})
  public void testSetMemo_givenNote_whenAxaxaxaxBytesIsUtf8_thenFirstElementIsA()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>Given {@link Note#Note()}.
   *   <li>When empty array of {@code byte}.
   *   <li>Then first element is zero.
   * </ul>
   *
   * <p>Method under test: {@link Note#setMemo(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.setMemo(byte[])"})
  public void testSetMemo_givenNote_whenEmptyArrayOfByte_thenFirstElementIsZero() {
    // Arrange
    Note note = new Note();

    // Act
    note.setMemo(new byte[] {});

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
   *
   * <ul>
   *   <li>Given {@link Note#Note()}.
   *   <li>When {@code null}.
   *   <li>Then first element is zero.
   * </ul>
   *
   * <p>Method under test: {@link Note#setMemo(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Note.setMemo(byte[])"})
  public void testSetMemo_givenNote_whenNull_thenFirstElementIsZero() {
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
   * Test {@link Note#encode()}.
   *
   * <ul>
   *   <li>Given {@link Note#Note()}.
   *   <li>Then return array length is five hundred sixty-four.
   * </ul>
   *
   * <p>Method under test: {@link Note#encode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EncPlaintext Note.encode()"})
  public void testEncode_givenNote_thenReturnArrayLengthIsFiveHundredSixtyFour() {
    // Arrange, Act and Assert
    assertEquals(564, new Note().encode().getData().length);
  }
}
