package org.tron.common.args;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GenesisBlockDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GenesisBlock}
   *   <li>{@link GenesisBlock#setNumber(String)}
   *   <li>{@link GenesisBlock#getAssets()}
   *   <li>{@link GenesisBlock#getNumber()}
   *   <li>{@link GenesisBlock#getParentHash()}
   *   <li>{@link GenesisBlock#getTimestamp()}
   *   <li>{@link GenesisBlock#getWitnesses()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void GenesisBlock.<init>()",
    "List GenesisBlock.getAssets()",
    "String GenesisBlock.getNumber()",
    "String GenesisBlock.getParentHash()",
    "String GenesisBlock.getTimestamp()",
    "List GenesisBlock.getWitnesses()",
    "void GenesisBlock.setNumber(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    GenesisBlock actualGenesisBlock = new GenesisBlock();
    actualGenesisBlock.setNumber("42");
    List<Account> actualAssets = actualGenesisBlock.getAssets();
    String actualNumber = actualGenesisBlock.getNumber();
    String actualParentHash = actualGenesisBlock.getParentHash();
    String actualTimestamp = actualGenesisBlock.getTimestamp();

    // Assert
    assertNull(actualParentHash);
    assertNull(actualTimestamp);
    assertNull(actualAssets);
    assertNull(actualGenesisBlock.getWitnesses());
    assertEquals(GenesisBlock.DEFAULT_NUMBER, actualNumber);
  }

  /**
   * Test {@link GenesisBlock#getDefault()}.
   *
   * <p>Method under test: {@link GenesisBlock#getDefault()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenesisBlock GenesisBlock.getDefault()"})
  public void testGetDefault() {
    // Arrange and Act
    GenesisBlock actualDefault = GenesisBlock.getDefault();

    // Assert
    List<Account> assets = actualDefault.getAssets();
    assertTrue(assets.isEmpty());
    assertEquals(GenesisBlock.DEFAULT_NUMBER, actualDefault.getNumber());
    assertEquals(GenesisBlock.DEFAULT_NUMBER, actualDefault.getParentHash());
    assertEquals(GenesisBlock.DEFAULT_NUMBER, actualDefault.getTimestamp());
    assertSame(assets, actualDefault.getWitnesses());
  }

  /**
   * Test {@link GenesisBlock#setAssets(List)}.
   *
   * <ul>
   *   <li>Given {@link GenesisBlock} (default constructor) Assets is {@link ArrayList#ArrayList()}.
   *   <li>Then {@link GenesisBlock} (default constructor) Assets Empty.
   * </ul>
   *
   * <p>Method under test: {@link GenesisBlock#setAssets(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GenesisBlock.setAssets(List)"})
  public void testSetAssets_givenGenesisBlockAssetsIsArrayList_thenGenesisBlockAssetsEmpty() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();
    genesisBlock.setAssets(new ArrayList<>());
    genesisBlock.setNumber("42");
    genesisBlock.setParentHash("Parent Hash");
    genesisBlock.setTimestamp(GenesisBlock.DEFAULT_NUMBER);
    genesisBlock.setWitnesses(new ArrayList<>());

    // Act
    genesisBlock.setAssets(null);

    // Assert that nothing has changed
    assertTrue(genesisBlock.getAssets().isEmpty());
  }

  /**
   * Test {@link GenesisBlock#setAssets(List)}.
   *
   * <ul>
   *   <li>Given {@link GenesisBlock} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link GenesisBlock} (default constructor) Assets is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GenesisBlock#setAssets(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GenesisBlock.setAssets(List)"})
  public void testSetAssets_givenGenesisBlock_whenArrayList_thenGenesisBlockAssetsIsArrayList() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();
    ArrayList<Account> assets = new ArrayList<>();

    // Act
    genesisBlock.setAssets(assets);

    // Assert
    assertSame(assets, genesisBlock.getAssets());
  }

  /**
   * Test {@link GenesisBlock#setTimestamp(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link GenesisBlock} (default constructor) Timestamp is {@link
   *       GenesisBlock#DEFAULT_NUMBER}.
   * </ul>
   *
   * <p>Method under test: {@link GenesisBlock#setTimestamp(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GenesisBlock.setTimestamp(String)"})
  public void testSetTimestamp_whenNull_thenGenesisBlockTimestampIsDefault_number() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();

    // Act
    genesisBlock.setTimestamp(null);

    // Assert
    assertEquals(GenesisBlock.DEFAULT_NUMBER, genesisBlock.getTimestamp());
  }

  /**
   * Test {@link GenesisBlock#setTimestamp(String)}.
   *
   * <ul>
   *   <li>When {@code Timestamp}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GenesisBlock#setTimestamp(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GenesisBlock.setTimestamp(String)"})
  public void testSetTimestamp_whenTimestamp_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new GenesisBlock().setTimestamp("Timestamp"));
  }

  /**
   * Test {@link GenesisBlock#setParentHash(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link GenesisBlock} (default constructor) ParentHash is {@link
   *       GenesisBlock#DEFAULT_NUMBER}.
   * </ul>
   *
   * <p>Method under test: {@link GenesisBlock#setParentHash(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GenesisBlock.setParentHash(String)"})
  public void testSetParentHash_whenNull_thenGenesisBlockParentHashIsDefault_number() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();

    // Act
    genesisBlock.setParentHash(null);

    // Assert
    assertEquals(GenesisBlock.DEFAULT_NUMBER, genesisBlock.getParentHash());
  }

  /**
   * Test {@link GenesisBlock#setParentHash(String)}.
   *
   * <ul>
   *   <li>When {@code Parent Hash}.
   *   <li>Then {@link GenesisBlock} (default constructor) ParentHash is {@code Parent Hash}.
   * </ul>
   *
   * <p>Method under test: {@link GenesisBlock#setParentHash(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GenesisBlock.setParentHash(String)"})
  public void testSetParentHash_whenParentHash_thenGenesisBlockParentHashIsParentHash() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();

    // Act
    genesisBlock.setParentHash("Parent Hash");

    // Assert
    assertEquals("Parent Hash", genesisBlock.getParentHash());
  }

  /**
   * Test {@link GenesisBlock#setWitnesses(List)}.
   *
   * <ul>
   *   <li>Given {@link GenesisBlock} (default constructor).
   *   <li>Then {@link GenesisBlock} (default constructor) Witnesses is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GenesisBlock#setWitnesses(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GenesisBlock.setWitnesses(List)"})
  public void testSetWitnesses_givenGenesisBlock_thenGenesisBlockWitnessesIsArrayList() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();
    ArrayList<Witness> witnesses = new ArrayList<>();

    // Act
    genesisBlock.setWitnesses(witnesses);

    // Assert
    assertSame(witnesses, genesisBlock.getWitnesses());
  }

  /**
   * Test {@link GenesisBlock#setWitnesses(List)}.
   *
   * <ul>
   *   <li>Then {@link GenesisBlock} (default constructor) Witnesses Empty.
   * </ul>
   *
   * <p>Method under test: {@link GenesisBlock#setWitnesses(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GenesisBlock.setWitnesses(List)"})
  public void testSetWitnesses_thenGenesisBlockWitnessesEmpty() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();
    genesisBlock.setAssets(new ArrayList<>());
    genesisBlock.setNumber("42");
    genesisBlock.setParentHash("Parent Hash");
    genesisBlock.setTimestamp(GenesisBlock.DEFAULT_NUMBER);
    genesisBlock.setWitnesses(new ArrayList<>());

    // Act
    genesisBlock.setWitnesses(null);

    // Assert that nothing has changed
    assertTrue(genesisBlock.getWitnesses().isEmpty());
  }
}
