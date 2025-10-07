package org.tron.core.db.api.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AccountDiffblueTest {
  /**
   * Test {@link Account#equals(Object)}, and {@link Account#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Account#equals(Object)}
   *   <li>{@link Account#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Account.equals(Object)", "int Account.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Account ofResult = Account.of();
    Account ofResult2 = Account.of();

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link Account#equals(Object)}, and {@link Account#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Account#equals(Object)}
   *   <li>{@link Account#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Account.equals(Object)", "int Account.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Account ofResult = Account.of();
    ofResult.setAddress("42 Main St");

    Account ofResult2 = Account.of();
    ofResult2.setAddress("42 Main St");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link Account#equals(Object)}, and {@link Account#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Account#equals(Object)}
   *   <li>{@link Account#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Account.equals(Object)", "int Account.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Account ofResult = Account.of();
    ofResult.setName("Name");

    Account ofResult2 = Account.of();
    ofResult2.setName("Name");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link Account#equals(Object)}, and {@link Account#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Account#equals(Object)}
   *   <li>{@link Account#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Account.equals(Object)", "int Account.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Account ofResult = Account.of();

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test {@link Account#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Account#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Account.equals(Object)", "int Account.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Account.of(), 1);
  }

  /**
   * Test {@link Account#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Account#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Account.equals(Object)", "int Account.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Account ofResult = Account.of();
    ofResult.setAddress("42 Main St");

    // Act and Assert
    assertNotEquals(ofResult, Account.of());
  }

  /**
   * Test {@link Account#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Account#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Account.equals(Object)", "int Account.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Account ofResult = Account.of();
    ofResult.setName("Name");

    // Act and Assert
    assertNotEquals(ofResult, Account.of());
  }

  /**
   * Test {@link Account#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Account#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Account.equals(Object)", "int Account.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Account ofResult = Account.of();
    ofResult.setBalance(42L);

    // Act and Assert
    assertNotEquals(ofResult, Account.of());
  }

  /**
   * Test {@link Account#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Account#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Account.equals(Object)", "int Account.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Account ofResult = Account.of();

    Account ofResult2 = Account.of();
    ofResult2.setAddress("42 Main St");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Test {@link Account#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Account#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Account.equals(Object)", "int Account.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Account ofResult = Account.of();

    Account ofResult2 = Account.of();
    ofResult2.setName("Name");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Test {@link Account#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Account#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Account.equals(Object)", "int Account.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Account.of(), null);
  }

  /**
   * Test {@link Account#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Account#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Account.equals(Object)", "int Account.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Account.of(), "Different type to Account");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Account#setAddress(String)}
   *   <li>{@link Account#setBalance(long)}
   *   <li>{@link Account#setName(String)}
   *   <li>{@link Account#toString()}
   *   <li>{@link Account#getAddress()}
   *   <li>{@link Account#getBalance()}
   *   <li>{@link Account#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String Account.getAddress()",
    "long Account.getBalance()",
    "String Account.getName()",
    "void Account.setAddress(String)",
    "void Account.setBalance(long)",
    "void Account.setName(String)",
    "String Account.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Account ofResult = Account.of();

    // Act
    ofResult.setAddress("42 Main St");
    ofResult.setBalance(42L);
    ofResult.setName("Name");
    String actualToStringResult = ofResult.toString();
    String actualAddress = ofResult.getAddress();
    long actualBalance = ofResult.getBalance();

    // Assert
    assertEquals("42 Main St", actualAddress);
    assertEquals("Account(address=42 Main St, name=Name, balance=42)", actualToStringResult);
    assertEquals("Name", ofResult.getName());
    assertEquals(42L, actualBalance);
  }

  /**
   * Test {@link Account#of()}.
   *
   * <p>Method under test: {@link Account#of()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Account Account.of()"})
  public void testOf() {
    // Arrange and Act
    Account actualOfResult = Account.of();

    // Assert
    assertNull(actualOfResult.getAddress());
    assertNull(actualOfResult.getName());
    assertEquals(0L, actualOfResult.getBalance());
  }
}
